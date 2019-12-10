package kz;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Methods {
    public static String getDistanceOfRoute(String s,Graph graph) {
        String[] arr = s.split("-");
        int distance  = 0;
        for(int i=0; i < arr.length-1;i++) {
            Node nA = graph.getNodeByName(arr[i]);
            Node nB = graph.getNodeByName(arr[i+1]);
            if(nA.getAdjacentNodes().containsKey(nB))
                distance += nA.getAdjacentNodes().get(nB);
            else return "NO SUCH ROUTE";
        }
        return String.valueOf(distance);
    }

    public static int getNumberOfTrips(Node nodeC, Node nodeC1, int i, Graph graph ) {
        int count = getNumberOfTrip_(nodeC,nodeC1,i,graph,0,0);
        return count;
    }

    private static int getNumberOfTrip_(Node nodeC, Node nodeC1, int i, Graph graph, int k,int count) {
        k++;
        if (nodeC.getAdjacentNodes().containsKey(nodeC1)) {
            if (k <= i)
                count++;
            k = 0;
        } else {
                for(Node n: nodeC.getAdjacentNodes().keySet()) {
                    count = getNumberOfTrip_(n,nodeC1,i,graph,k,count);
                }
            }
          return count ;
    }
    public static Graph calculateShortestPath(Graph graph, Node source, Node destination) {
        source.setDistance(0);
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);
        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry< Node, Integer> adjacencyPair: currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }
    public static int calculateShortestPathFromSource(Graph graph, Node source, Node destination) {
        graph = calculateShortestPath(graph,source,destination);
        return graph.getNodeByName(destination.getName()).getDistance();
    }
    public static int calculateShortestPathFromSource2(Graph graph, Node source, Node destination) {
        graph = calculateShortestPath(graph,source,destination);
        int min = 0;
        for(Node n : graph.getNodes()){
            if(n.getAdjacentNodes().containsKey(source)) {
                if (n.getDistance() != 0) {
                    if (min == 0) {
                        min = n.getDistance() + n.getAdjacentNodes().get(source);
                    }
                    min = Math.min(n.getDistance() + n.getAdjacentNodes().get(source), min);
                }
            }
        }
        return min;
    }

    private static Node getLowestDistanceNode(Set < Node > unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode,
                                                 Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

}
