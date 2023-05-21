package com.example.neo4jd3.service.impl;

import com.example.neo4jd3.dao.ShortestPathRepo;
import com.example.neo4jd3.payload.response.ShortestPathResponse;
import com.example.neo4jd3.service.ShortestPathService;
import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import org.neo4j.driver.internal.value.PathValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ShortestPathServiceImpl implements ShortestPathService {
    private final ShortestPathRepo shortestPathRepo;

    @Autowired
    public ShortestPathServiceImpl(ShortestPathRepo shortestPathRepo) {
        this.shortestPathRepo = shortestPathRepo;
    }

    @Override
    public Mono<ShortestPathResponse> getShortestPath(String from, String to, Integer lenId) {
        final Flux<PathValue> rows = shortestPathRepo.shortestPath(from, to, lenId);

        //阻塞
        rows.subscribe(
                (it) -> {
                    List<Map<String, Object>> paths = new ArrayList<>();
                    for (var x : it.asPath()) {
                        System.out.println(x.start().asMap());
                        System.out.println(x.relationship().asMap());
                        System.out.println(x.end().asMap());

                        Map<String, Object> path = Map.of(
                                "start", x.start().asMap(),
                                "relationship", x.relationship().asMap(),
                                "end", x.end().asMap()
                        );

                        paths.add(path);
                    }

                    System.out.println(new Gson().toJson(paths));

                    try {
                        SendJsonTo("10.112.163.93", 8888, new Gson().toJson(paths));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        return rows.map(it -> this.convert(it.asPath(), lenId))
                .take(1)
                .next()
                .switchIfEmpty(Mono.empty());
    }

    private ShortestPathResponse convert(org.neo4j.driver.types.Path path, Integer lenId) {
        List<String> nodesInPath = new ArrayList<>();

        for (var node : path.nodes()) {
            String nodeName = node.get("name").asString();
            nodesInPath.add(nodeName);
        }

        Double totLen = StreamSupport.stream(path.relationships().spliterator(), false)
                .filter(edge -> edge.hasType("ACHIEVABLE"))
                .mapToDouble(route -> route.get("para").get(lenId).asDouble())
                .sum();

        return new ShortestPathResponse(nodesInPath, totLen);
    }

    private void SendJsonTo(String ip, Integer port, String json) throws IOException {
        Socket socket = new Socket(ip, port);
        System.out.println("Connected to server...");

        PrintWriter writer = new PrintWriter(socket.getOutputStream());
//        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String name = "Hello from client";

        writer.println(name);
        writer.flush();

        writer.println(json);
        writer.flush();

//        String response = reader.readLine();
//        System.out.println("Received: " + response);

        writer.close();
//        reader.close();
        socket.close();
    }
}
