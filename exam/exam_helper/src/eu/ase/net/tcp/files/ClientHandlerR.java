package eu.ase.net.tcp.files;

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


            // on IN save file to server
            String filename = String.format("file_from_%s_%d", this.socket.getInetAddress().getHostName(), this.socket.getPort());
            FileOutputStream fos = new FileOutputStream(filename);

            // create data input stream on input stream's socket so we can read length
            DataInputStream dis = new DataInputStream(in);

            long fileLenght = dis.readLong();

            // read chunks sent by server
            byte[] buffer = new byte[1024];
            int bytesRead;
            long totalRead = 0;

            while(totalRead < fileLenght && (bytesRead = in.read(buffer)) != -1){
                fos.write(buffer, 0, bytesRead);
                totalRead += bytesRead;
            }

            fos.flush();
            System.out.println("File received");

            // on OUT send message to client
            PrintWriter pw = new PrintWriter(out);
            pw.printf("%s: Thank you for the file\n", Thread.currentThread().getName());
            pw.flush();

            fos.close();
            pw.close();
            dis.close();
            this.socket.close();

            System.out.println("Client disconnected");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
