package com.projectrunner.app;

public class ProjFlow {
    private final Graph graph = new Graph();

    public void addNode(Node node){
        graph.addNode(node);
    }

    public void addEdge(Edge edge){
        graph.addEdge(edge);
    }

    public void run(String startNode){
        graph.run(startNode);
    }
}
