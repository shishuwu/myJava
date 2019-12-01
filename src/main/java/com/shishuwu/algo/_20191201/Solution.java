package com.shishuwu.algo._20191201;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;


class Result {

    /*
     * Complete the 'multiple' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER x
     *  2. INTEGER y
     *  3. INTEGER z
     *  4. INTEGER n
     */

    public static List<Integer> multiple(int x, int y, int z, int n) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        result.add(x);
        for (int i = x + 1; i < n; i++){
            if((i % x == 0 || i % y == 0) && i % z != 0){
                result.add(i);
            }
        }
        result.add(n);
        return result;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int x = Integer.parseInt(bufferedReader.readLine().trim());

        int y = Integer.parseInt(bufferedReader.readLine().trim());

        int z = Integer.parseInt(bufferedReader.readLine().trim());

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.multiple(x, y, z, n);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

