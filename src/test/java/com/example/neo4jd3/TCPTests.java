package com.example.neo4jd3;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;

public class TCPTests {
    private Socket client;

    @Test
    public void testTCP() {
        try {
            client = new Socket("localhost", 65432);
            System.out.println("Connected to server");

            setClientMessage("Hello from client");
        } catch (IOException e) {
            System.out.println("Could not connect to server");
        }
    }

    @Test
    public void testJson() {
        Map<String, Object> map = Map.of(
                "name", "st5",
                "jointAngle", List.of(0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
                "position", "0,0,0,0,0,0"
        );

        Gson gson = new Gson();
        String json = gson.toJson(map);

        try {
            client = new Socket("localhost", 65432);
            System.out.println("Connected to server");

            setClientMessage(json);
        } catch (IOException e) {
            System.out.println("Could not connect to server");
        }
    }

    void setClientMessage(String message) {
        try {
            OutputStream pt = client.getOutputStream();
            pt.write(message.getBytes());

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
