// Name   : Bhumi Bhadre
// Roll No: 31
// Experiment 12: Develop any application using networking
// Program 1: TCP Client-Server Application (Echo Server)

import java.io.*;
import java.net.*;

public class NetworkingDemo {
    // Inner class for the Server
    static class EchoServer {
        public void start(int port) {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("[Server] Started on port " + port);
                System.out.println("[Server] Waiting for client connection...");

                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("[Server] Client connected: " + clientSocket.getInetAddress());

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("[Server] Received: " + inputLine);
                        out.println("Echo from server: " + inputLine);
                        if (inputLine.equalsIgnoreCase("bye")) break;
                    }
                }
                System.out.println("[Server] Client disconnected. Shutting down.");
            } catch (IOException e) {
                System.out.println("[Server Error] " + e.getMessage());
            }
        }
    }

    // Inner class for the Client
    static class EchoClient {
        public void start(String host, int port) {
            try (Socket socket = new Socket(host, port);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

                System.out.println("[Client] Connected to " + host + ":" + port);
                System.out.println("[Client] Type messages (type 'bye' to exit):");

                String userInput;
                while (true) {
                    System.out.print("> ");
                    userInput = stdIn.readLine();
                    if (userInput == null) break;
                    
                    out.println(userInput);
                    System.out.println("[Client] Server response: " + in.readLine());
                    
                    if (userInput.equalsIgnoreCase("bye")) break;
                }
            } catch (UnknownHostException e) {
                System.out.println("[Client Error] Unknown host: " + host);
            } catch (IOException e) {
                System.out.println("[Client Error] I/O error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("server")) {
            new EchoServer().start(5000);
        } else if (args.length > 0 && args[0].equalsIgnoreCase("client")) {
            new EchoClient().start("localhost", 5000);
        } else {
            System.out.println("Usage:");
            System.out.println("  java NetworkingDemo server  - Start the echo server");
            System.out.println("  java NetworkingDemo client  - Start the echo client");
            
            // For demonstration in a single run (not recommended for actual use but shows code works)
            System.out.println("\n--- Starting both in separate threads for demo ---");
            new Thread(() -> new EchoServer().start(5000)).start();
            
            // Wait for server to start
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            
            new EchoClient().start("localhost", 5000);
        }
    }
}

