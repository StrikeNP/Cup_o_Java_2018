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

    public Node(Node parent, int side){
        switch (side){
            case N:
                this.neighbors[N] = parent;
                this.neighbors[NW] = parent.neighbors[W];
                this.neighbors[NE] = parent.neighbors[E];
                this.neighbors[W] = parent.neighbors[SW];
                this.neighbors[E] = parent.neighbors[SE];
                if(parent.neighbors[SW] != null) {
                    this.neighbors[SW] = parent.neighbors[SW].neighbors[S];
                    this.neighbors[S] = parent.neighbors[SW].neighbors[SE];
                } else {
                    this.neighbors[SW] = null;
                    this.neighbors[S] = null;
                }
                if(parent.neighbors[SE] != null) {
                    this.neighbors[SE] = parent.neighbors[SE].neighbors[S];
                    this.neighbors[S] = parent.neighbors[SE].neighbors[SW];
                } else {
                    this.neighbors[SE] = null;
                    this.neighbors[S] = null;
                }
                break;
            case S:
                this.neighbors[S] = parent;
                this.neighbors[SW] = parent.neighbors[W];
                this.neighbors[SE] = parent.neighbors[E];
                this.neighbors[W] = parent.neighbors[NW];
                this.neighbors[E] = parent.neighbors[NE];
                if(parent.neighbors[NW] != null) {
                    this.neighbors[NW] = parent.neighbors[NW].neighbors[N];
                    this.neighbors[N] = parent.neighbors[NW].neighbors[NE];
                } else {
                    this.neighbors[NW] = null;
                    this.neighbors[N] = null;
                }
                if(parent.neighbors[NE] != null) {
                    this.neighbors[NE] = parent.neighbors[NE].neighbors[N];
                    this.neighbors[N] = parent.neighbors[NE].neighbors[NW];
                } else {
                    this.neighbors[NE] = null;
                    this.neighbors[N] = null;

                }
                break;
            case E:
                this.neighbors[E] = parent;
                this.neighbors[SE] = parent.neighbors[S];
                this.neighbors[NE] = parent.neighbors[N];
                this.neighbors[N] = parent.neighbors[NW];
                this.neighbors[S] = parent.neighbors[SW];
                if(parent.neighbors[NE] != null) {
                    this.neighbors[NW] = parent.neighbors[NW].neighbors[W];
                    this.neighbors[W] = parent.neighbors[NW].neighbors[SW];
                } else {
                    this.neighbors[NW] = null;
                    this.neighbors[W] = null;
                }
                if(parent.neighbors[SW] != null) {
                    this.neighbors[SW] = parent.neighbors[SW].neighbors[W];
                    this.neighbors[W] = parent.neighbors[SW].neighbors[NW];
                } else {
                    this.neighbors[SW] = null;
                    this.neighbors[W] = null;
                }
                break;
            case W:
                this.neighbors[W] = parent;
                this.neighbors[SW] = parent.neighbors[S];
                this.neighbors[NW] = parent.neighbors[N];
                this.neighbors[N] = parent.neighbors[NE];
                this.neighbors[S] = parent.neighbors[S];
                if(parent.neighbors[NE] != null) {
                    this.neighbors[NE] = parent.neighbors[NE].neighbors[E];
                    this.neighbors[E] = parent.neighbors[NE].neighbors[SE];
                } else {
                    this.neighbors[NE] = null;
                    this.neighbors[E] = null;
                }
                if(parent.neighbors[SE] != null) {
                    this.neighbors[SE] = parent.neighbors[SE].neighbors[E];
                    this.neighbors[E] = parent.neighbors[SE].neighbors[NE];
                } else {
                    this.neighbors[SE] = null;
                    this.neighbors[E] = null;
                }
                break;
            case NE:
                this.neighbors[NE] = parent;
                this.neighbors[N] = parent.neighbors[W];
                this.neighbors[E] = parent.neighbors[S];
                if(parent.neighbors[W] != null) {
                    this.neighbors[NW] = parent.neighbors[W].neighbors[W];
                    this.neighbors[W] = parent.neighbors[W].neighbors[SW];
                    if(parent.neighbors[W].neighbors[SW] != null) {
                        this.neighbors[SW] = parent.neighbors[W].neighbors[SW].neighbors[S];
                    }
                } else {
                    this.neighbors[NW] = null;
                    this.neighbors[W] = null;
                }
                if(parent.neighbors[S] != null) {
                    this.neighbors[SE] = parent.neighbors[S].neighbors[S];
                    this.neighbors[S] = parent.neighbors[S].neighbors[SW];
                    if(parent.neighbors[S].neighbors[SW] != null) {
                        this.neighbors[SW] = parent.neighbors[S].neighbors[SW].neighbors[W];
                    }
                } else {
                    this.neighbors[SE] = null;
                    this.neighbors[S] = null;
                }
                break;
            case NW:
                this.neighbors[NW] = parent;
                this.neighbors[N] = parent.neighbors[E];
                this.neighbors[W] = parent.neighbors[S];
                if(parent.neighbors[E] != null) {
                    this.neighbors[NW] = parent.neighbors[W].neighbors[W];
                    this.neighbors[W] = parent.neighbors[W].neighbors[SW];
                    if(parent.neighbors[W].neighbors[SW] != null) {
                        this.neighbors[SW] = parent.neighbors[W].neighbors[SW].neighbors[S];
                    }
                } else {
                    this.neighbors[NW] = null;
                    this.neighbors[W] = null;
                }
                if(parent.neighbors[S] != null) {
                    this.neighbors[SE] = parent.neighbors[S].neighbors[S];
                    this.neighbors[S] = parent.neighbors[S].neighbors[SW];
                    if(parent.neighbors[S].neighbors[SW] != null) {
                        this.neighbors[SW] = parent.neighbors[S].neighbors[SW].neighbors[W];
                    }
                } else {
                    this.neighbors[SE] = null;
                    this.neighbors[S] = null;
                }
                break;
            case SE:
                this.neighbors[SE] = parent;
                this.neighbors[E] = parent.neighbors[N];
                this.neighbors[S] = parent.neighbors[W];
                break;
            case SW:
                this.neighbors[SW] = parent;
                this.neighbors[W] = parent.neighbors[N];
                this.neighbors[S] = parent.neighbors[E];
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



