package cupojava.problemone;

import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numPlayers = Integer.parseInt(in.nextLine());
        int numMoves = Integer.parseInt(in.nextLine());
        ArrayList<String> moves = new ArrayList<>();
        for(int i = 0; i < (numMoves * numPlayers); i++) {
            moves.add(in.nextLine());
        }
    }
}
