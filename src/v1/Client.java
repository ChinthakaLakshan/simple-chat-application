package v1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException{

        System.out.println("This is client running");
        Socket socket = new Socket("localhost",8090);

        OutputStream outputStream=socket.getOutputStream();
        DataOutputStream dataOutputStream= new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("Hello server");
        dataOutputStream.flush();
        dataOutputStream.close();

    }
}
