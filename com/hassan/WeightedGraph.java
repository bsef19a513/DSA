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

    public Path getShortestPath(String from,String to)
    {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        //validation
        if (fromNode==null||toNode==null)
            throw new IllegalArgumentException();

        Map<Node,Integer> distances = new HashMap<>();
        // initialize distances with max Value
        for (var node: nodes.values())
            distances.put(node,Integer.MAX_VALUE);
        distances.replace(fromNode,0);

        //to keep track of previous nodes
        Map<Node,Node> previousNodes = new HashMap<>();

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
                    previousNodes.put(edge.to,current); // updating previous node
                    queue.add(new NodeEntry(edge.to,newDistance));
                }
            }
        }

        return buildPath(previousNodes,toNode);
    }

    private Path buildPath(Map<Node,Node> previousNodes, Node toNode)
    {
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        var previous = previousNodes.get(toNode);
        while (previous!=null)
        {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        var path = new Path();
        while (!stack.isEmpty())
            path.add(stack.pop().label);
        return path;
    }
    public boolean hasCycle()
    {
        Set<Node> visited = new HashSet<>();
        for (var node: nodes.values()) {
            if (!visited.contains(node) && hasCycle(node,null,visited))
                return true;
        }
        return false;
    }
    private boolean hasCycle(Node node, Node parent, Set<Node> visited)
    {
        visited.add(node);
        for (var edge: node.getEdges()) {
            if (edge.to==parent)
                continue;
            if (visited.contains(edge.to)|| hasCycle(edge.to,node,visited))
                return true;
        }
        return false;
    }
    public WeightedGraph getMinimumSpanningTree()
    {
        var tree = new WeightedGraph();
        if (nodes.isEmpty())
            return tree;
        PriorityQueue<Edge> edges = new PriorityQueue<>(
                Comparator.comparingInt(e->e.weight)
        );
        var startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.label);
        while (tree.nodes.size()<nodes.size())
        {
            if (edges.isEmpty())
                return tree;
            var minEdge = edges.remove();
            var nextNode = minEdge.to;
            if(tree.containsNode(nextNode.label))
                continue;
            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label, nextNode.label, minEdge.weight);
            for (var edge: nextNode.getEdges())
                if (!tree.containsNode(edge.to.label))
                    edges.add(edge);
        }

        return tree;
    }
    public boolean containsNode(String label)
    {
        return nodes.containsKey(label);
    }
}
