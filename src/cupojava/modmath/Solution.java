package cupojava.modmath;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    private int m;
    private int[] counts;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        solution.m = scanner.nextInt();
        solution.counts = new int[10];

            for (int i = 0; i < solution.m; i++) {
                int n;
                if(solution.m%2 == 0){
                    n = solution.m/2;
                }else{
                    n = (int) Math.ceil(solution.m/2.0);
                }
                for (int k = 0; k < n; k++) {
                    int index = (i * k) % solution.m;
                    String indexStr = "" + index;
                    char[] indexChars = indexStr.toCharArray();
                    for (char tempChar : indexChars) {
                        solution.counts[Character.getNumericValue(tempChar)]++;
                    }

                }
            }

//        solution.counts[0] = solution.counts[0] - solution.m;

        for (int i = 0; i < solution.counts.length; i++) {
                System.out.println("" + i + ": " + solution.counts[i]*2);
            }
        }
 }