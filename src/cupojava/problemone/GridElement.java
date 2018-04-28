package cupojava.problemone;

import java.util.List;

public interface GridElement {

    public Node N=null, S=null, E=null, W=null, NE = null, NW=null, SE=null, SW=null;

    public List<Node> getConnections();
    public void validateBorders();
}
