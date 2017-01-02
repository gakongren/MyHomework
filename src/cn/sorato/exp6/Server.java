package cn.sorato.exp6;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;

/**
 * Created by kongren on 2016/11/7.
 */
public class Server{
    public static int port;
    private volatile boolean isWorking = false;
    private ServerSocket so;
    private volatile Map<Socket, ObjectOutputStream> sockets = new HashMap<>();

    private final List<Socket> markRemove = new ArrayList<>();

    public Server(int i){
        port = i;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Server s = new Server(in.nextInt());
        s.start();
        String cmd;
        while(s.isWorking()){
            cmd = in.next();
            switch(cmd){
                case "/stop":
                    s.stop();
                    break;
                default:
            }
        }
    }

    public boolean isWorking(){
        return isWorking;
    }

    public void log(String str){
        System.out.println(str);
    }

    public void start(){
        System.out.println("启动");
        isWorking = true;
        try{
            so = new ServerSocket(port);
            so.setReuseAddress(true);
            new Thread(()->{
                while(isWorking){
                    try{
                        Socket soc = so.accept();
                        sockets.put(soc, new ObjectOutputStream(soc.getOutputStream()));
                        new Thread(()->{
                            log("连接:" + soc.getInetAddress());
                            handle(soc);
                        }).start();
                    }catch(SocketException e){
                        if(e.getMessage().equalsIgnoreCase("socket closed"))
                            log("服务器连接关闭");
                        else
                            e.printStackTrace();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void handle(Socket soc){
        try{
            ObjectInputStream bo = new ObjectInputStream(soc.getInputStream());
            MessageObj msg = null;
            while(isWorking && sockets.get(soc) != null){
                try{
                    msg = (MessageObj) bo.readObject();
                }catch(EOFException e){
                    log("user_disconnect");
                    synchronized(this){
                        markRemove.add(soc);
                    }
                    return;
                }catch(ClassNotFoundException e){
                    e.printStackTrace();
                    continue;
                }
                synchronized(this){
                    markRemove.forEach(e->sockets.remove(e));
                    markRemove.clear();
                }
                for(Map.Entry<Socket, ObjectOutputStream> e : sockets.entrySet()){
                    Socket outso = e.getKey();
                    ObjectOutputStream pw = e.getValue();
                    pw.writeObject(msg);
                    pw.flush();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void stop(){
        isWorking = false;
        try{
            so.close();
            sockets.keySet().forEach(s->{
                try{
                    s.close();
                }catch(IOException e){
                    log("终止与" + s.getInetAddress().toString() + "的连接");
                }
            });
        }catch(IOException ignored){
        }
    }
}
