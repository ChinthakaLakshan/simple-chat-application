package com.company;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("This server is running o...");
         ServerSocket serverSocket=new ServerSocket(8090);
        System.out.println("waiting to connect");
          Socket socket =serverSocket.accept();
        System.out.println("connected ");

        //read
        InputStream inputStream=socket.getInputStream();
        DataInputStream dataInputStream=new DataInputStream(inputStream);

        String msg=dataInputStream.readUTF();

        System.out.println("client message :"+msg);
         serverSocket.close();


    }
}
