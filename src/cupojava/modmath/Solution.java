package cupojava.modmath;

import java.io.*;
import java.util.*;

public class Solution {

    private int m;
    private int[] counts;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        solution.m = scanner.nextInt();
        solution.counts = new int[10];

        for(int i = 0; i < solution.m; i++){
            for(int k = 0; k < solution.m; k++){
                int index = (i*k)%solution.m;
              if(solution.m==5)
                System.out.print(index);
                String indexStr = "" + index;
                char[] indexChars = indexStr.toCharArray();
                for(char tempChar: indexChars){
                    solution.counts[Character.getNumericValue(tempChar)]++;
                }

            }
            if(solution.m == 5)
            System.out.print("\n");
        }

        for(int i = 0; i < solution.counts.length; i++){
            System.out.println("" + i + ": " + solution.counts[i]);
        }



    }
}