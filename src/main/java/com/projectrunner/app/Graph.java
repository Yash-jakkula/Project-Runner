package com.projectrunner.app;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    private final Map<String,Node> nodes = new HashMap<>();
    private final Map<String,String> edges = new HashMap<>();

    public void addNode(Node node){
        nodes.put(node.getName(),node);
    }

    public void addEdge(Edge edge){
        edges.put(edge.getFrom(),edge.getTo());
    }

    public void run(String startNode){
        String current = startNode;
        while(current!=null){
            Node node = nodes.get(current);
            if(node == null) break;
            System.out.println("running current node "+current);
            String res = node.run(current);
            current = edges.getOrDefault(current,null);
        }
    }
}
