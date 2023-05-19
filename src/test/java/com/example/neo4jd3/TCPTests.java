package com.example.neo4jd3;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPTests {
    private Socket client;

    @Test
    public void testTCP() {
        try {
            client = new Socket("localhost", 65432);
            System.out.println("Connected to server");

            setClientMessage();
        } catch (IOException e) {
            System.out.println("Could not connect to server");
        }
    }

    void setClientMessage() {
        try {
            OutputStream pt = client.getOutputStream();
            String printText = "Hello from client";
            pt.write(printText.getBytes());

            InputStream in = client.getInputStream();
            byte[] buffer = new byte[1024];
            int length = in.read(buffer);
            if (length > 0) {
                System.out.println("Server says: " + new String(buffer, 0, length));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
