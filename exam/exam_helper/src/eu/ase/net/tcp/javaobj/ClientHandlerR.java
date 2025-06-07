package eu.ase.net.tcp.javaobj;

import java.io.*;
import java.net.Socket;

public class ClientHandlerR implements Runnable {

    private final Socket socket;

    public ClientHandlerR(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            InputStream in = this.socket.getInputStream();
            OutputStream out = this.socket.getOutputStream();

            ObjectInputStream ois = new ObjectInputStream(in);
            PrintWriter pw = new PrintWriter(out);

            Book book = (Book) ois.readObject();
            System.out.printf("Received book %s from %s:%d\n", book.toString(), this.socket.getInetAddress().getHostName(), this.socket.getPort());

            pw.printf("%s: Thank you for the book %s\n", Thread.currentThread().getName(), book.getTitle());
            pw.flush();

            ois.close();
            pw.close();

            this.socket.close();

            System.out.println("Client disconnected");

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
