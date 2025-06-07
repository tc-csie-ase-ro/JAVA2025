package eu.ase.net.tcp.javaobj;

import java.io.*;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) {


        try (Socket socket = new  Socket("localhost", 9000)){
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();


            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            ObjectOutputStream oos = new ObjectOutputStream(out);

            Book book = new Book(1999, "Book1", "Author1");

            System.out.printf("Sending book %s to server...\n", book.toString());

            oos.writeObject(book);
            oos.flush();

            String line = br.readLine();
            System.out.println(line);

            oos.close();
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


