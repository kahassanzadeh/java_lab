package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
/**
 * this class is an example of a client
 *
 * @author Mohammadreza Hassanzadeh
 * @since Dec 25 2020
 * @version 1.0
 */
public class Client5 {
    public static void main(String[] args) throws IOException {
        try(Socket clientSocket = new Socket("127.0.0.1",5000)){
            System.out.println("Client5 is connected");
            OutputStream output = clientSocket.getOutputStream();
            InputStream input = clientSocket.getInputStream();
            byte[] buffer = new byte[4096];
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
