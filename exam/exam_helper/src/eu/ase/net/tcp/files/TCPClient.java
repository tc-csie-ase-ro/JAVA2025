package eu.ase.net.tcp.files;

import java.io.*;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) {


        try (Socket socket = new  Socket("localhost", 9000)){

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();


            // on OUT
            System.out.printf("Sending file to server...\n");

            // create file
            File file = new File("myfile.txt");
            // open it
            FileInputStream fis = new FileInputStream(file);

            // create data output stream on socket output stream so we can send the file length
            DataOutputStream dos = new DataOutputStream(out);

            dos.writeLong(file.length());

            // split file in chunks and send it to server
            byte[] buffer = new byte[1024];
            int bytesRead;

            while((bytesRead = fis.read(buffer)) != -1){
                dos.write(buffer, 0, bytesRead);
            }

            dos.flush();
            System.out.println("File sent");

            // on IN create buffered reader to read message from server
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = br.readLine();
            System.out.println(line);

            fis.close();
            out.close();
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


