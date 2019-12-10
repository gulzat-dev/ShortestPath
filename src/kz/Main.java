package kz;

public class Main {

    public static void main(String[] args) {
        String s = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        String[] dest = s.split(",");

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeA.addDestination(nodeB, 5);
        nodeA.addDestination(nodeE, 7);
        nodeA.addDestination(nodeD, 5);

        nodeB.addDestination(nodeC, 4);

        nodeC.addDestination(nodeD, 8);
        nodeC.addDestination(nodeE, 2);

        nodeD.addDestination(nodeC, 8);
        nodeD.addDestination(nodeE, 6);

        nodeE.addDestination(nodeB, 3);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        String out1 = Methods.getDistanceOfRoute("A-B-C",graph);
        System.out.print("out1: "+ out1);
        String out2 = Methods.getDistanceOfRoute("A-D",graph);
        System.out.print("\n out2: "+ out2);
        String out3 = Methods.getDistanceOfRoute("A-D-C",graph);
        System.out.print("\n out3: "+ out3);
        String out4 = Methods.getDistanceOfRoute("A-E-B-C-D",graph);
        System.out.print("\n out4: "+ out4);
        String out5 = Methods.getDistanceOfRoute("A-E-D",graph);
        System.out.print("\n out5: "+ out5);
        int out6 = Methods.getNumberOfTrips(nodeC,nodeC,3,graph);
        System.out.print("\n out6: "+ out6);
        int out7 = Methods.getNumberOfTrips(nodeA,nodeC,5,graph);
        System.out.print("\n out7: "+ out7);
        int out8  = Methods.calculateShortestPathFromSource(graph, nodeA, nodeC);
        System.out.print("\n out8: "+ out8);
        int out9  = Methods.calculateShortestPathFromSource2(graph, nodeB, nodeB);
        System.out.print("\n out9: "+ out9);
        int out10 = Methods.numberDifRoutes(graph, nodeC, nodeC);
        System.out.print("\n out10: "+ out10);
    }

}
