package cupojava.problemone;

import java.util.ArrayList;
import java.util.List;

public class Node implements GridElement {

    private int player = 0;

    public static final int N = 0, S = 1, E = 2, W = 3, NE = 4, NW = 5, SE = 6, SW = 7;

    protected Node[] neighbors = new Node[8];
//    Node N = null, S = null, E = null, W = null, NE = null, NW = null, SE = null, SW = null;




    public List<Node> getConnections() {
        List<Node> matches = new ArrayList<>();
        for(int i = 0; i < neighbors.length; i++) {
            if(player == neighbors[i].player) {
                matches.add(neighbors[i]);
            }
        }
        return matches;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public void clear() {
        this.player = 0;
    }


    public Node(int player, Node[] neighbors){
        this.player = player;
        this.neighbors = neighbors;
    }

    public void validateBorders() {
        for(Node testNode: neighbors){

        }
    }


    private void createColumn(Node edgeNode, boolean createOnLeft){
//        do{
//            Node newNode = new Node(0, )
//        }
        Node nextNode = edgeNode.neighbors[N];
        while(nextNode != null){
//                nextNode.neighbors[E] =
        }
    }
    private void createRow(){

    }


}
