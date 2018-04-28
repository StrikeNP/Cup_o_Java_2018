package cupojava.problemone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {
    private static GridElement firstPosition;
    private static int numPlayers;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        firstPosition = new Node(-1, new Node[8]);
        numPlayers = Integer.parseInt(in.nextLine());
        int numMoves = Integer.parseInt(in.nextLine());
        ArrayList<String> moves = new ArrayList<>();
        for(int i = 0; i < (numMoves * numPlayers); i++) {
            moves.add(in.nextLine());
        }
        for (int i = 1; i <= numPlayers; i++){
            System.out.println(calculateScore(i));
        }
    }

    private static void formConnections(List<String> moves) {
        Node currentNode = (Node)firstPosition;
        int currentPlayer = 1;
        for(String move : moves) {
            switch (move) {
                case "N":
                    currentNode.neighbors[Node.N] = new Node(currentPlayer, new Node[8]);
                    currentNode = currentNode.neighbors[Node.N];
                    break;
                case "NE":
                    currentNode.neighbors[Node.NE] = new Node(currentPlayer, new Node[8]);
                    currentNode = currentNode.neighbors[Node.NE];
                    break;
                case "E":
                    currentNode.neighbors[Node.E] = new Node(currentPlayer, new Node[8]);
                    currentNode = currentNode.neighbors[Node.E];
                    break;
                case "SE":
                    currentNode.neighbors[Node.SE] = new Node(currentPlayer, new Node[8]);
                    currentNode = currentNode.neighbors[Node.SE];
                    break;
                case "S":
                    currentNode.neighbors[Node.S] = new Node(currentPlayer, new Node[8]);
                    currentNode = currentNode.neighbors[Node.S];
                    break;
                case "SW":
                    currentNode.neighbors[Node.SW] = new Node(currentPlayer, new Node[8]);
                    currentNode = currentNode.neighbors[Node.SW];
                    break;
                case "W":
                    currentNode.neighbors[Node.W] = new Node(currentPlayer, new Node[8]);
                    currentNode = currentNode.neighbors[Node.W];
                    break;
                case "NW":
                    currentNode.neighbors[Node.NW] = new Node(currentPlayer, new Node[8]);
                    currentNode = currentNode.neighbors[Node.NW];
                    break;
            }
            currentPlayer++;
            if(currentPlayer > numPlayers) {
                currentPlayer = 1;
            }
        }
    }

    private static int calculateScore(int playerNumber){
        //TODO: Use getConnections() to calculate the score
        return 0;
    }
}
