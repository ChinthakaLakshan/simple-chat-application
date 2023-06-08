package v4;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("This server is running o...");
         ServerSocket serverSocket=new ServerSocket(8090);


        while(true) {

            System.out.println("waiting to connect");
            Socket socket =serverSocket.accept();
             ServerClientThread thread=new ServerClientThread();
              thread.start();

        }

    }
}
