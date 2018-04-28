package cupojava.problemone;

import java.util.ArrayList;
import java.util.List;

public class Node {
    Node N = null, S = null, E = null, W = null, NE = null, NW = null, SE = null, SW = null;




    public List<Node> getConnections() {
        List<Node> matches = new ArrayList<>();
        for(int i = 0; i < neighbors.length; i++) {
            if(player = neighbors[i]) {
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
}
