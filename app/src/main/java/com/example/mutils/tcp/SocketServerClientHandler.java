package com.example.mutils.tcp;
 
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.example.mutils.utils.JK;

import java.io.InputStream;
import java.net.Socket;
 
/**
 * @program: com.io.socket.server
 * @description: 服务端客户消息处理线程类
 * @author: liujinghui
 * @create: 2019-02-16 11:02
 **/
public class SocketServerClientHandler extends Thread{
 
    //每个消息通过Socket进行传输
    private Socket clientConnectSocket;
    public SocketServerClientHandler(Socket clientConnectSocket){
        this.clientConnectSocket = clientConnectSocket;
    }

    @Override
    public void run() {
        extracted();
//        extracted2();
    }

    private void extracted() {
        try {
            InputStream inputStream = clientConnectSocket.getInputStream();
            while (true) {
                int count = 0;
                while (count == 0) {
                    count = inputStream.available();//获取字节流的长度
                }
                byte[] b = new byte[count];
                inputStream.read(b);
                String fromHexString = getString(b);
                System.out.println("客户端" + clientConnectSocket.getPort() + "传来消息: " + fromHexString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void extracted2() {
        try {
            InputStream inputStream = clientConnectSocket.getInputStream();
            while (true) {
                byte[] data = new byte[100];
                int len;
                while ((len = inputStream.read(data)) != -1) {
                    String message = new String(data, 0, len);
                    System.out.println("客户端传来消息: " + message);
                    clientConnectSocket.getOutputStream().write(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NonNull
    private String getString(byte[] b) throws Exception {
        String hexStr = JK.conver16HexStr(b);//将字节转为16进制字符串
        String body_length = hexStr.substring(16, 24);//消息内容的长度 16进制
        String hex16To10 = JK.hex16To10(body_length);//将消息内容16转10输出
        String body = hexStr.substring(24, 24 + Integer.parseInt(hex16To10) * 2);//内容
        String fromHexString = JK.fromHexString(body);
        return fromHexString;
    }
}