package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * this class created for the Server Managing and using multi thread
 *
 * @author Mohammad reza Hassanzadeh
 * @since Dec 25 2020
 * @version 1.0
 */
public class Server {

    public static void main(String[] args){
        ExecutorService mainPool = Executors.newCachedThreadPool();
        int counter = 0;
        try(ServerSocket welcomingSocket = new ServerSocket(5000)){
            System.out.println("Server.Server started.\nWaiting for a client ... ");
            while (counter < 10000)
            {
                Socket connectionSocket = welcomingSocket.accept();
                counter++;
                mainPool.execute(new Handler(connectionSocket, counter));
            }
            System.out.print("done.\nClosing server ... ");
            mainPool.shutdown();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.println("done");
    }
}
