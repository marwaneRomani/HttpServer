package org.est.server;

import java.io.*;
import java.net.http.HttpResponse;
import java.nio.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMTBlockant extends Thread {

    public static void main(String[] args) {
        new ServerMTBlockant().start();
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(4002);

            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                new Conversation(socket).start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private class Conversation extends Thread {

        private Socket socket;

        public Conversation(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream);

                String httpRequest = bufferedReader.lines().reduce("", (acc, data) -> acc + data + "\n");

                System.out.println(httpRequest);

//                socket.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}