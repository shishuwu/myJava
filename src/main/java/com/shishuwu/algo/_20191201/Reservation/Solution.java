package com.shishuwu.algo._20191201.Reservation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'missingReservations' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY firstReservationList
     *  2. 2D_INTEGER_ARRAY secondReservationList
     */

    /*
 输入如下：

3
2
1234 532632
234 632633
2354 732634
4
2
1234 532632
234 632633
458 642633
2354 732634

     */

    public static List<Integer> missingReservations(List<List<Integer>> firstReservationList, List<List<Integer>> secondReservationList) {
        // Write your code here
        List<Integer> result = new ArrayList<>();


        int firstSize = firstReservationList.get(0).get(0);

        List<Integer> firstIds = new ArrayList<>();
        for (int i = 2; i < (i + firstSize); i++) {
            int id = firstReservationList.get(i).get(0);
            firstIds.add(i);
        }

        int secondSize = secondReservationList.get(0).get(0);
        List<Integer> secondIds = new ArrayList<>();
        for (int j = 2; j < (j + secondSize); j++) {
            int id = secondReservationList.get(j).get(0);
            secondIds.add(j);
        }

        secondIds.removeAll(firstIds);

        return secondIds;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int firstReservationListRows = Integer.parseInt(bufferedReader.readLine().trim());
        int firstReservationListColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> firstReservationList = new ArrayList<>();

        IntStream.range(0, firstReservationListRows).forEach(i -> {
            try {
                firstReservationList.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int secondReservationListRows = Integer.parseInt(bufferedReader.readLine().trim());
        int secondReservationListColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> secondReservationList = new ArrayList<>();

        IntStream.range(0, secondReservationListRows).forEach(i -> {
            try {
                secondReservationList.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.missingReservations(firstReservationList, secondReservationList);

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
