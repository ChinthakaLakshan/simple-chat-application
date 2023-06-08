package v3;
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
            System.out.println("connected ");
            //read
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            String msg = "";

            Scanner sc = new Scanner(System.in);
            while (!msg.equals("Stop")) {

                msg = dataInputStream.readUTF();
                System.out.println("clent msgs :" + msg);

                String messageToClient = sc.nextLine();
                dataOutputStream.writeUTF(messageToClient);
                dataOutputStream.flush();

            }


            // System.out.println("client message :"+msg);
            //serverSocket.close();
        }

    }
}
