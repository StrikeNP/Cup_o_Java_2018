package cupojava.problemone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {
    private static GridElement firstPosition;
    private static int numPlayers;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        firstPosition = new Node(0, new Node[8]);
        numPlayers = Integer.parseInt(in.nextLine());
        int numMoves = Integer.parseInt(in.nextLine());
        ArrayList<String> moves = new ArrayList<>();
        for(int i = 0; i < (numMoves * numPlayers); i++) {
            moves.add(in.nextLine());
        }
        formConnections(moves);
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
                    currentNode = new Node(currentNode, Node.N);
                    currentNode.setPlayer(currentPlayer);
                    break;
                case "NE":
                    currentNode = new Node(currentNode, Node.NE);
                    currentNode.setPlayer(currentPlayer);
                    break;
                case "E":
                    currentNode = new Node(currentNode, Node.E);
                    currentNode.setPlayer(currentPlayer);
                    break;
                case "SE":
                    currentNode = new Node(currentNode, Node.SE);
                    currentNode.setPlayer(currentPlayer);
                    break;
                case "S":
                    currentNode = new Node(currentNode, Node.S);
                    currentNode.setPlayer(currentPlayer);
                    break;
                case "SW":
                    currentNode = new Node(currentNode, Node.SW);
                    currentNode.setPlayer(currentPlayer);
                    break;
                case "W":
                    currentNode = new Node(currentNode, Node.W);
                    currentNode.setPlayer(currentPlayer);
                    break;
                case "NW":
                    currentNode = new Node(currentNode, Node.NW);
                    currentNode.setPlayer(currentPlayer);
                    break;
            }
            currentPlayer++;
            if(currentPlayer > numPlayers) {
                currentPlayer = 1;
            }
        }
    }

    private static int calculateScore(int playerNumber){
        int currentScore = 0;
        List<TraversalNode> nodesToTraverse = getNodesFromPlayer((Node)firstPosition, playerNumber, new ArrayList<>());
        for(TraversalNode traversalNode : nodesToTraverse) {
            if(!traversalNode.isChecked) {
                List<Integer> numberOfNodesInARow = new ArrayList<>();
                numberOfNodesInARow.add(calculateScore(traversalNode.node, 0, Node.N, playerNumber));
                numberOfNodesInARow.add(calculateScore(traversalNode.node, 0, Node.S, playerNumber));
                numberOfNodesInARow.add(calculateScore(traversalNode.node, 0, Node.E, playerNumber));
                numberOfNodesInARow.add(calculateScore(traversalNode.node, 0, Node.W, playerNumber));
                numberOfNodesInARow.add(calculateScore(traversalNode.node, 0, Node.NE, playerNumber));
                numberOfNodesInARow.add(calculateScore(traversalNode.node, 0, Node.NW, playerNumber));
                numberOfNodesInARow.add(calculateScore(traversalNode.node, 0, Node.SE, playerNumber));
                numberOfNodesInARow.add(calculateScore(traversalNode.node, 0, Node.SW, playerNumber));

                long numberOfPoints = numberOfNodesInARow.stream().filter(x -> x >= 3).count();
                for(int i = 0; i < numberOfPoints; i++) {
                    currentScore++;
                }
            }
        }
        return currentScore;
    }

    private static int calculateScore(Node currentNode, int numberOfNodesWithSamePlayer, int currentDirection, int playerNumber) {
        if(currentNode == null) {
            return numberOfNodesWithSamePlayer;
        } else {
            int localNumOfNodes = numberOfNodesWithSamePlayer;
            if(currentNode.getPlayer() == playerNumber) {
                localNumOfNodes++;
            }
            return calculateScore(currentNode.neighbors[currentDirection], localNumOfNodes, currentDirection, playerNumber);
        }
    }

    private static List<TraversalNode> getNodesFromPlayer(Node currentNode, int playerNumber, List<TraversalNode> runningList) {
        if(currentNode == null) {
            return runningList;
        } else {
            if(currentNode.getPlayer() == playerNumber) {
                runningList.add(new TraversalNode(currentNode));
            }
            for(int i = 0; i < currentNode.neighbors.length; i++) {
                return getNodesFromPlayer(currentNode.neighbors[i], playerNumber, runningList);
            }
        }
        return null;
    }

    private static class TraversalNode {
        public boolean isChecked;
        public Node node;

        public TraversalNode(Node node) {
            this.node = node;
            isChecked = false;
        }
    }
}
