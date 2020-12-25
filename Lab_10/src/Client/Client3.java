package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client3 {
    public static void main(String[] args) throws IOException {
        try(Socket clientSocket = new Socket("127.0.0.1",5000)){
            System.out.println("Client3 is connected");
            OutputStream output = clientSocket.getOutputStream();
            InputStream input = clientSocket.getInputStream();
            byte[] buffer = new byte[2048];
            Scanner systemInput = new Scanner(System.in);
            while(true){
                System.out.println("Message to Server");
                String message = systemInput.nextLine();
                if(message.equals("finish")){
                    break;
                }
                output.write(message.getBytes());
                int read = input.read();
                System.out.println("+ From Server: " + new String(buffer,0, read));
            }
            System.out.println("closing");

        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("done");
    }

}
