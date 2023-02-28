package org.est.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost",4002);
        // stream de communication
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write(10);
        outputStream.write(20);
        outputStream.write(30);
        int read = inputStream.read();
        System.out.println(read);
    }
}
