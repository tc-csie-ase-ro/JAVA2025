package eu.ase.net.tcp.javaobj;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {

    public static void main(String[] args) {

        int port = 9000;
        boolean listening = true;

        ExecutorService executor = Executors.newFixedThreadPool(10);


        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server started on port " + port);

            while (listening) {
                // accept connection from client
                Socket socket = serverSocket.accept();
                executor.submit(new ClientHandlerR(socket));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
            System.out.println("Server stopped");
        }

    }
}