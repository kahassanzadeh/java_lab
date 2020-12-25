package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * this class handles the multi thread part
 * this class implements the Runnable interface
 *
 * @author Mohammadreza Hassanzadeh
 * @since Dec 25 2020
 * @version 1.0
 */
public class Handler implements Runnable {
    //socket of the server
    private final Socket socket;
    //client number
    private final int clNumber;

    /**
     * constructor for the Handler class
     * @param socket socket of the server
     * @param clNumber client number
     */
    public Handler(Socket socket,int clNumber){
        this.socket = socket;
        this.clNumber = clNumber;
    }

    /**
     * override method
     *
     * using to creat a thread
     */
    @Override
    public void run() {
        try{
            System.out.println("Client number " + clNumber + " added");
            OutputStream output = socket.getOutputStream();
            InputStream input = socket.getInputStream();
            byte[] buffer = new byte[4096];
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
