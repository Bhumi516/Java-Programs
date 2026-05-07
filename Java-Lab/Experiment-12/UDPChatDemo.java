// Name   : Bhumi Bhadre
// Roll No: 31
// Experiment 12: Develop any application using networking
// Program 2: UDP Client-Server (Datagram Sockets)

import java.net.*;
import java.util.Scanner;

public class UDPChatDemo {
    private static final int PORT = 9876;
    private static final int BUFFER_SIZE = 1024;

    static class UDPServer {
        public void start() {
            try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
                byte[] receiveData = new byte[BUFFER_SIZE];
                System.out.println("[UDP Server] Listening on port " + PORT);

                while (true) {
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    serverSocket.receive(receivePacket);

                    String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    InetAddress IPAddress = receivePacket.getAddress();
                    int port = receivePacket.getPort();

                    System.out.println("[UDP Server] From " + IPAddress + ":" + port + " -> " + message);

                    // Send response
                    String response = "UDP Echo: " + message;
                    byte[] sendData = response.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                    serverSocket.send(sendPacket);

                    if (message.equalsIgnoreCase("exit")) break;
                }
            } catch (Exception e) {
                System.out.println("[UDP Server Error] " + e.getMessage());
            }
        }
    }

    static class UDPClient {
        public void start() {
            try (DatagramSocket clientSocket = new DatagramSocket();
                 Scanner scanner = new Scanner(System.in)) {
                
                InetAddress IPAddress = InetAddress.getByName("localhost");
                byte[] receiveData = new byte[BUFFER_SIZE];

                System.out.println("[UDP Client] Ready. Type messages (type 'exit' to quit):");

                while (true) {
                    System.out.print("> ");
                    String message = scanner.nextLine();
                    byte[] sendData = message.getBytes();

                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, PORT);
                    clientSocket.send(sendPacket);

                    if (message.equalsIgnoreCase("exit")) break;

                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    clientSocket.receive(receivePacket);
                    String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    System.out.println("[UDP Client] Response: " + response);
                }
            } catch (Exception e) {
                System.out.println("[UDP Client Error] " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("server")) {
            new UDPServer().start();
        } else if (args.length > 0 && args[0].equalsIgnoreCase("client")) {
            new UDPClient().start();
        } else {
            System.out.println("Usage: java UDPChatDemo [server|client]");
            
            // Auto-run both for demo
            new Thread(() -> new UDPServer().start()).start();
            try { Thread.sleep(500); } catch (InterruptedException e) {}
            new UDPClient().start();
        }
    }
}

