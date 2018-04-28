package cupojava.problemone;

import java.util.ArrayList;
import java.util.List;

public class Node implements GridElement {

    private int player = 0;

    public static final int N = 0, S = 1, E = 2, W = 3, NE = 4, NW = 5, SE = 6, SW = 7;

    protected Node[] neighbors = new Node[8];

    public Node(int player, Node[] neighbors){
        this.player = player;
        this.neighbors = neighbors;
    }

    public Node(Node parent, int parentSide){
        this.neighbors[parentSide] = parent;
        switch (parentSide){
            case N:
                this.neighbors[NW]=parent.neighbors[W];
                this.neighbors[NE]=parent.neighbors[E];
                break;
            case S:
                this.neighbors[SW]=parent.neighbors[W];
                this.neighbors[SE]=parent.neighbors[E];
                break;
            case E:
                this.neighbors[SE]=parent.neighbors[S];
                this.neighbors[NE]=parent.neighbors[N];
                break;
            case W:
                this.neighbors[SW]=parent.neighbors[S];
                this.neighbors[NW]=parent.neighbors[N];
                break;
            case NE:
                this.neighbors[N]=parent.neighbors[W];
                this.neighbors[E]=parent.neighbors[S];
                break;
            case NW:
                this.neighbors[N]=parent.neighbors[E];
                this.neighbors[W]=parent.neighbors[S];
                break;
            case SE:
                this.neighbors[E]=parent.neighbors[N];
                this.neighbors[S]=parent.neighbors[W];
                break;
            case SW:
                this.neighbors[W]=parent.neighbors[N];
                this.neighbors[S]=parent.neighbors[E];
                break;
        }
    }

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




        public void validateBorders() {
            for(Node testNode: neighbors){
                if (testNode.neighbors[E] == null) {
                    createColumn(false);
                }else if (testNode.neighbors[W] == null){
                    createColumn(true);
                }
                if(testNode.neighbors[N] == null){
                    createRow(true);
                } else if(testNode.neighbors[S] == null){
                    createRow(false);
                }
            }
        }


        private void createColumn(boolean createOnLeft){
            Node parent = this;
            do{
                if(createOnLeft) {
                    new Node(parent, E);
                }else{
                    new Node(parent, W);
                }
                parent = parent.neighbors[N];
            }while(parent != null);
            do{
                parent = this.neighbors[S];
                if(createOnLeft) {
                    new Node(parent, E);
                }else{
                    new Node(parent, W);
                }
                parent = parent.neighbors[S];
            }while(parent != null);
        }
        private void createRow(boolean createOnTop){
            Node parent = this;
            do{
                if(createOnTop) {
                    new Node(parent, N);
                }else{
                    new Node(parent, S);
                }
                parent = parent.neighbors[E];
            }while(parent != null);
            parent = this.neighbors[W];
            do{
                if(createOnTop) {
                    new Node(parent, N);
                }else{
                    new Node(parent, S);
                }
                parent = parent.neighbors[W];
            }while(parent != null);
        }

        public int getPlayer() {
            return player;
        }

    }



