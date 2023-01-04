package com.hassan;

import java.util.*;

public class WeightedGraph {
    private class Node{
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }
        public void addEdge(Node to, int weight)
        {
            edges.add(new Edge(this,to,weight));
        }
        public List<Edge> getEdges()
        {
            return edges;
        }
    }
    private class Edge{
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from.label+" -> "+to.label;
        }
    }
    Map<String,Node> nodes = new HashMap<>();

    public void addNode(String label)
    {
        nodes.putIfAbsent(label,new Node(label));
    }
    public void addEdge(String from, String to,int weight)
    {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();
        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();
        fromNode.addEdge(toNode,weight);
        toNode.addEdge(fromNode,weight);
    }

    public void print()
    {
        for (var node: nodes.values()) {
            var edges = node.getEdges();
            if (!edges.isEmpty())
                System.out.println(node.label+" is connected to "+edges);
        }
    }
    private class NodeEntry{
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public int getShortestDistance(String from,String to)
    {
        var fromNode = nodes.get(from);
        Map<Node,Integer> distances = new HashMap<>();
        // initialize distances with max Value
        for (var node: nodes.values())
            distances.put(node,Integer.MAX_VALUE);
        distances.replace(fromNode,0);
        // to keep track of visited nodes
        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority)
        );
        queue.add(new NodeEntry(fromNode,0));

        while (!queue.isEmpty())
        {
            var current = queue.remove().node;
            visited.add(current);
            for (var edge: current.getEdges()) {
                if(visited.contains(edge.to))
                    continue;

                var newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to))
                {
                    distances.replace(edge.to,newDistance);
                    queue.add(new NodeEntry(edge.to,newDistance));
                }
            }
        }

        return distances.get(nodes.get(to));
    }
}
