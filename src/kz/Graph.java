package kz;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    private Set<Node> nodes  = new HashSet<>();
    public void addNode(Node node) {
        nodes.add(node);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public Node getNodeByName(String str) {
        for(Node n:nodes){
            if(n.getName().equalsIgnoreCase(str)) {
                return n;
            }
        }
        return null;
    }
}
