package cupojava.boggle;

import java.util.*;

public class Solution {

    char[][] map;
    int rows, columns, numWords;
    ArrayList<String> words = new ArrayList<>();
    ArrayList<String> wordsFound = new ArrayList<>();

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Solution solution = new Solution();
        solution.readInput();
        solution.checkForHorzWords();
        solution.checkForVertWords();
        solution.wordsFound.sort(String::compareToIgnoreCase);
        for(String word: solution.wordsFound){
            System.out.println(word);
        }
    }

    public Solution(){

    }


    private void readInput(){
        Scanner scanner = new Scanner(System.in);
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        numWords =scanner.nextInt();
        map = new char[columns][rows];
        scanner.nextLine();
        for(int row = 0; row < rows; row ++){
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            for(int column = 0; column < chars.length; column ++){
                map[column][row] = chars[column];
            }
        }
        for(int i = 0; i < numWords; i++){
            String newWord = scanner.nextLine();
            words.add(newWord);
        }
    }

    private void checkForHorzWords(){
        for(int row = 0; row < rows; row++){
            String forwards = "";
            String backwards = "";
            for(int column = 0; column < columns; column++){
                forwards += map[column][row];
                backwards += map[columns - column - 1][row];
            }
            for(String validWord : words){
                if(forwards.contains(validWord)){
                    wordsFound.add(validWord);
                }
                if(backwards.contains(validWord)){
                    wordsFound.add(validWord);
                }
            }
        }
    }

    private void checkForVertWords(){
        for(int column = 0; column < columns; column++){
            String upwards = "";
            String downwards = "";
            for(int row = 0; row < rows; row++){
                downwards += map[column][row];
                upwards += map[column][rows - row -1];
            }
            for(String validWord : words){
                if(upwards.contains(validWord)){
                    wordsFound.add(validWord);
                }
                if(downwards.contains(validWord)){
                    wordsFound.add(validWord);
                }
            }
        }
    }

//    private void check

}