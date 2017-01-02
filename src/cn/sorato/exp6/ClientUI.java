package cn.sorato.exp6;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * Created by kongren on 2016/11/9.
 */
public class ClientUI extends JFrame{
    private JButton connect = new JButton("连接");
    private JButton disconnect = new JButton("断开");
    private JButton send = new JButton("发送");
    private JTextArea input = new JTextArea();
    private JTextArea display = new JTextArea();
    private JLabel status = new JLabel();
    private ConnectPane connectPane = new ConnectPane();
    private Client client;

    public void warn(String msg){
        status.setForeground(Color.RED);
        status.setText(msg);
    }

    public void logInfo(String str){
        status.setForeground(Color.BLACK);
        status.setText(str);
    }

    public void append(MessageObj msg){
        display.append(msg.username + ":\n" + msg.msg + "\n");
        display.setCaretPosition(display.getText().length());
    }

    private class ConnectPane extends JDialog{
        JTextField addr, port, user;
        JButton connect_confirm = new JButton("连接");

        void init(){
            setSize(300, 80);
            Container c = getContentPane();
            c.setLayout(new FlowLayout());
            user = new JTextField("用户名");
            addr = new JTextField("地址");
            port = new JTextField("端口");
//            user.setVisible(true);
//            addr.setVisible(true);
            addr.setPreferredSize(new Dimension(120, 20));
            addr.setHorizontalAlignment(SwingConstants.CENTER);
            port.setPreferredSize(new Dimension(40, 20));
//            port.setVisible(true);
            connect_confirm.addActionListener(e->{
                client.user = user.getText();
                client.address = addr.getText();
                client.port = Integer.parseInt(port.getText());
                if(client.port>65535||client.port<0){
                    JOptionPane.showMessageDialog(this,"不合法的端口号");
                    return;
                }
                try{
                    client.connect();
                    connectPane.setVisible(false);
                    connect.setVisible(false);
                    disconnect.setVisible(true);
                    logInfo("");
                }catch(IOException e1){
                    warn("连接失败");
                }
            });
            c.add(user);
            c.add(addr);
            c.add(port);
            c.add(connect_confirm);
        }
    }

    ClientUI(Client client){
        super("套接字群聊");
        this.client = client;
        try{
            Image logo = ImageIO.read(this.getClass().getResource("/logo.png"));
            setIconImage(logo);
        }catch(IOException e){
            e.printStackTrace();
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        connectPane.init();
        initUI();
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                super.windowClosing(e);
                client.disconnect();
            }
        });
    }

    private GridBagConstraints getBag(int gridx, int gridy, int gridwidth, int gridheight, boolean fill){
        GridBagConstraints ctr1 = new GridBagConstraints();
        ctr1.gridx = gridx;
        ctr1.gridy = gridy;
        ctr1.weighty = gridheight;
        ctr1.weightx = gridwidth;
        ctr1.gridwidth = gridwidth;
        ctr1.gridheight = gridheight;
        if(fill)
            ctr1.fill = GridBagConstraints.BOTH;
        ctr1.insets = new Insets(5, 5, 5, 5);
        return ctr1;
    }

    public void updateConnectBtn(){
        disconnect.setVisible(client.isConnected);
        connect.setVisible(!client.isConnected);
    }

    private void initUI(){
        setSize(300, 500);
        Container container = this.getContentPane();
        container.setLayout(new GridBagLayout());
        connect.addActionListener(e->connectPane.setVisible(true));

        display.setLineWrap(true);
        display.setEditable(false);
        JScrollPane displayPane = new JScrollPane(display);
        displayPane.setBorder(new LineBorder(Color.BLACK, 1, false));
        JScrollPane inputPane = new JScrollPane(input);
        inputPane.setBorder(new LineBorder(Color.BLACK, 1, false));

        disconnect.addActionListener(e->client.disconnect());

        send.addActionListener(e->{
            String s = input.getText();
            if("".equals(s))
                return;
            try{
                client.send(s);
                input.setText("");
            }catch(IOException e1){
                warn("连接中断");
                client.disconnect();
            }
        });

        container.add(displayPane, getBag(0, 0, 3, 8, true));
        container.add(inputPane, getBag(0, 8, 3, 2, true));
        container.add(send, getBag(2, 10, 1, 1, false));
        container.add(status, getBag(1, 10, 1, 1, true));
        container.add(connect, getBag(0, 10, 1, 1, false));
        container.add(disconnect, getBag(0, 10, 1, 1, false));
    }
}
