package cupojava.problemone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {
    //private static GridElement firstPosition;
    private static Node firstPosition;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        firstPosition = new Node();
        int numPlayers = Integer.parseInt(in.nextLine());
        int numMoves = Integer.parseInt(in.nextLine());
        ArrayList<String> moves = new ArrayList<>();
        for(int i = 0; i < (numMoves * numPlayers); i++) {
            moves.add(in.nextLine());
        }
        for (int i =0; i < numPlayers; i++){

        }
    }

    private static void formConnections(List<String> moves) {
        //TODO: From the connections based on the moves
    }

    private static int calculateScore(int playerNumber){
        //TODO: Use getConnections() to calculate the score
        return 0;
    }
}
