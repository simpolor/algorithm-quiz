package io.simpolor.quiz.hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * https://www.hackerrank.com/challenges/compare-the-triplets/problem?h_r=next-challenge&h_v=zen
 */
public class ComparetheTriplets {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        List<Integer> result = new ArrayList<Integer>();
        /*int alice = 0;
        int bob = 0;

        for(int i=0; i<a.size; i++){
            if(a[i] > b[i]){
                alice++;
            }
            if(a[i] < b[i]){
                bob++;
            }
        }

        result.add(alice);
        result.add(bob);*/

        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        System.out.println("message : "+message);

        /*List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());*/

        /*List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());*/

        // List<Integer> result = compareTriplets(a, b);

        /*bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "))
                        + "\n"
        );*/

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
