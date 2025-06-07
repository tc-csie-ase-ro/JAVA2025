package eu.ase.net.udp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;

public class UDPClient {

    public static void main(String[] args) {

        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9000;

            File file = new File("myfile.txt");

            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int bytesRead;

            System.out.printf("Sending file (%d bytes) to server...\n", file.length());

            while ((bytesRead = fis.read(buffer)) != -1) {
                DatagramPacket packet = new DatagramPacket(buffer, bytesRead, serverAddress, serverPort);
                socket.send(packet);
            }

            fis.close();

            // Send EOF packet — zero-length packet or special message
            byte[] eof = "EOF".getBytes();
            DatagramPacket eofPacket = new DatagramPacket(eof, eof.length, serverAddress, serverPort);
            socket.send(eofPacket);

            System.out.println("File sent.");

            socket.close();


        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
