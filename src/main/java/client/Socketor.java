package client;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class Socketor {
    private String ip;
    private int port;
    private Socket clientSocket;
    private BufferedReader reader;
    private BufferedWriter writer;

    public Socketor(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void connect() {
        try {
            clientSocket = new Socket(ip, port);
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException("Prisijungimo prie serverio klaida: " + e.getMessage());
        }
    }

    public void sendRequest(List<String> request) {
        try {
            writer.write(request.size() + "\n");
            for (String line : request)
                writer.write(line + "\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Klaida siunciant uzklausa: " + e.getMessage());
        }
    }

    public String getResponse() {
        try {
            String response = reader.readLine();
            return response;
        } catch (IOException e) {
            throw new RuntimeException("Negautas atsakymas is serverio: " + e.getMessage());
        }
    }

    public void close() {
        try {
            reader.close();
            writer.close();
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Klaida uzdarant prisijungima: " + e.getMessage());
        }
    }

}
