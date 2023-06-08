package v4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerClientThread extends Thread {
private Socket socket;
    @Override
    public void run() {
        try{  System.out.println("connected ");
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

            }}

        catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
