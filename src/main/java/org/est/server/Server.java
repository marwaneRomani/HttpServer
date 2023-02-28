package org.est.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        serve();
    }
    public static void serve() throws Exception {
            ServerSocket serverSocket = new ServerSocket(4002);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            int i = inputStream.read();
            int i1 = inputStream.read();
            int i2 = inputStream.read();
            int i3 = inputStream.read();

            outputStream.write(i + i1 + i2 + i3);

            socket.close();
    }
}
