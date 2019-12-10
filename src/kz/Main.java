package kz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {

            File f;
            f = new File("conf.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");
            Graph graph = new Graph();
            while ((readLine = b.readLine()) != null) {
                String[] in = readLine.split(": ");
                switch (in[0]) {
                    case "Input":

                        String s= in[1].trim();
                        String[] dest = s.split(", ");
                        for(int i =0; i< dest.length;i++){
                            String name  = String.valueOf(dest[i].charAt(0));
                            String name2  = String.valueOf(dest[i].charAt(1));
                            if (graph.getNodeByName(name)== null)
                                graph.addNode(new Node(name));
                            if (graph.getNodeByName(name2)== null)
                                graph.addNode(new Node(name2));
                            graph.getNodeByName(name).addDestination(graph.getNodeByName(name2),Character.getNumericValue(dest[i].charAt(2)));
                        }
                        break;
                    case "1":
                        case "2":
                    case "3":
                    case "4":
                    case "5":
                        String out1 = Methods.getDistanceOfRoute(in[1].trim(),graph);
                        System.out.print( "\n " + in[0] + "# "+ out1);
                        break;
                    case "6":
                    case "7":
                        String[] k = in[1].split(" ");
                        int out6 = Methods.getNumberOfTrips(graph.getNodeByName(k[0]),graph.getNodeByName(k[1]),Integer.parseInt(k[2]),graph);
                        System.out.print("\n "+ in[0] + "# " + out6);
                        break;
                    case "8":
                        String[] m = in[1].split(" ");
                        int out8 = Methods.calculateShortestPathFromSource(graph, graph.getNodeByName(m[0]),graph.getNodeByName(m[1]));
                        System.out.print("\n "+ in[0] + "# "+ out8);
                        break;
                    case "9":
                        String[] n= in[1].split(" ");
                        int out9 = Methods.calculateShortestPathFromSource2(graph, graph.getNodeByName(n[0]),graph.getNodeByName(n[1]));
                        System.out.print("\n " + in[0] + "# " + out9);
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
