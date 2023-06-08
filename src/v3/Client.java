package v3;

import java.io.*;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Client {
    private static java.lang.String[] String;

    public static void main(String[] args) throws IOException{

        System.out.println("This is client running");
        Socket socket = new Socket("localhost",8090);

        OutputStream outputStream=socket.getOutputStream();
        DataOutputStream dataOutputStream= new DataOutputStream(outputStream);

        InputStream inputStream=socket.getInputStream();
        DataInputStream dataInputStream=new DataInputStream(inputStream);

        Scanner sc = new Scanner(System.in);


        //String msg =clientMsg.nextLine();
        //dataOutputStream.writeUTF(msg);

       String msg="";
        while (!msg.equals("Stop")){
             msg=sc.nextLine();
            dataOutputStream.writeUTF(msg);
            dataOutputStream.flush();

            String serverMessage= dataInputStream.readUTF();
            System.out.println("server msgs :"+ serverMessage);

        }

      /*for(int i=0;i<4;i++){
          Scanner clientMsg = new Scanner(System.in);
          System.out.println("Enter the Message :");
          String msg [i]=clientMsg.nextLine();
         // msg= String [i];
           dataOutputStream.writeUTF(msg[i]);
          dataOutputStream.flush();
      }*/



        dataOutputStream.close();
        socket.close();

    }
}
