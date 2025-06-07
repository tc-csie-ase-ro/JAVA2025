package eu.ase.net.udp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

    public static void main(String[] args) {

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9000);
            byte[] buffer = new byte[1024];

            FileOutputStream fos = new FileOutputStream("received_myfile.txt");

            System.out.println("Server listening on port 9000...");

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                // Check for EOF packet
                String data = new String(packet.getData(), 0, packet.getLength());
                if ("EOF".equals(data)) {
                    System.out.println("EOF received. File complete.");
                    break;
                }

                // Write packet data to file
                fos.write(packet.getData(), 0, packet.getLength());
            }

            fos.close();
            socket.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}