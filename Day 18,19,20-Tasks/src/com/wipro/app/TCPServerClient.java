package com.wipro.app;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import com.wipro.model.CalculationRequest;

public class TCPServerClient {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        // Start server in a separate thread
        new Thread(() -> {
            try {
                runServer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Simulate a delay to ensure server starts before client
        try {
            Thread.sleep(1000); // 1 second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start client
        try {
            runClient();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void runServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);

            // Handle client request in a new thread
            new Thread(() -> {
                try {
                    ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                    ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

                    Object obj = in.readObject();
                    if (obj instanceof CalculationRequest) {
                        CalculationRequest request = (CalculationRequest) obj;
                        int result = performCalculation(request);
                        out.writeObject(result);
                        System.out.println("Result sent to client: " + result);
                    }

                    in.close();
                    out.close();
                    clientSocket.close();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static int performCalculation(CalculationRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static void runClient() throws IOException, ClassNotFoundException {
        try (Socket socket = new Socket("localhost", PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            CalculationRequest request = new CalculationRequest(2, 2, "+");
            out.writeObject(request);
            System.out.println("Request sent to server: " + request);

            int result = (int) in.readObject();
            System.out.println("Result received from server: " + result);
        }
    }
}
