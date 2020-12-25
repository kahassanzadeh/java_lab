package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Handler implements Runnable {

    private Socket socket;

    private int clNumber;

    public Handler(Socket socket,int clNumber){
        this.socket = socket;
        this.clNumber = clNumber;
    }


    @Override
    public void run() {
        try{
            System.out.println("Client number " + clNumber + " added");
            OutputStream output = socket.getOutputStream();
            InputStream input = socket.getInputStream();
            byte[] buffer = new byte[2048];
            StringBuilder outputString = new StringBuilder();
            while(true){
                try{
                    int read = input.read(buffer);
                    System.out.println("From client" + clNumber + ": " + new String(buffer,0,read));
                    outputString.append(" ").append(new String(buffer, 0, read));
                    System.out.println(" to client " + clNumber + ": "+ outputString);
                    output.write(outputString.toString().getBytes());
                }
                catch(Exception e){
                    break;
                }
            }
            System.out.println("Connection closed with client number " + clNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                socket.close();
            }catch (IOException exception){
                exception.printStackTrace();
            }
        }
    }
}
