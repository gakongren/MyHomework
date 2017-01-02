package cn.sorato.exp6;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 * Created by kongren on 2016/11/7.
 */
public class Client{
    volatile boolean isConnected = false;
    volatile boolean isWorking = true;
    String address;
    int port;
    String user;
    Socket socket;
    private ObjectOutputStream ow = null;
    private ObjectInputStream ir = null;
    private Thread display;
    private static Client instance;
    private ClientUI cui;

    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        String cmd;
        Client.get();
//        while(c.isWorking){
//            cmd = "";//in.next();
//            switch(cmd){
//                case "/connect":
//                    c.connect();
//                    break;
//                case "/disconnect":
//                    c.disconnect();
//                    c.stop();
//                    break;
//                default:
//                    try{
//                        c.send(cmd);
//                    }catch(IOException e){
//                        e.printStackTrace();
//                    }
//            }
//        }
//        c.disconnect();
    }

    private MessageObj getMsgObj(String msg){
        return new MessageObj(this.user, msg);
    }

    private void stop(){
        isWorking = false;
    }

    static Client get(){
        if(instance == null)
            instance = new Client();
        return instance;
    }

    public static Client get(String user, String address, int port){
        get();
        instance.user = user;
        instance.address = address;
        instance.port = port;
        return instance;
    }

    public void log(String str){
        cui.logInfo(str);
    }

    private Client(){
        cui = new ClientUI(this);
        cui.setVisible(true);
    }

    public void connect() throws IOException{
        if(isConnected){
            disconnect();
        }
        socket = new Socket();            //此时Socket对象未绑定本地端口,并且未连接远程服务器
        socket.setReuseAddress(true);
        SocketAddress remoteAddr = new InetSocketAddress(address, port);
        socket.setKeepAlive(true);
        socket.connect(remoteAddr);
        isConnected = true;
        ow = new ObjectOutputStream(socket.getOutputStream());
        ir = new ObjectInputStream(socket.getInputStream());
        new Thread(()->{
            try{
                MessageObj msg;
                while(isConnected){
                    try{
                        msg = (MessageObj) ir.readObject();
                        if(msg == null)
                            continue;
                        addDisplay(msg);
                    }catch(SocketException e){
                        disconnect();
                    }catch(ClassNotFoundException e){
                        e.printStackTrace();
                    }
                }
            }catch(IOException e){
                warn("连接中断");
                disconnect();
            }
        }).start();
        cui.updateConnectBtn();
    }

    private void addDisplay(MessageObj msg){
        cui.append(msg);
    }

    void disconnect(){
        if(!isConnected)
            return;
        isConnected = false;
        cui.updateConnectBtn();
        try{
            //TODO:做一点微小的工作打断显示线程
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        ow = null;
    }

    public void send(String str) throws IOException{
        if(!isConnected){
            warn("未连接至服务端");
            return;
        }
        ow.writeObject(getMsgObj(str));
        ow.flush();
    }

    private void warn(String msg){
        cui.warn(msg);
    }
}
