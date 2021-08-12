package io.simpolor.quiz;

import org.junit.Test;

import java.util.*;

public class TestExecute {

    @Test
    public void test(){

        int[] truckWeights = new int[]{7,4,5,6};
        int bridgeLength = 2;
        int weight = 10;

        int solution = solution(bridgeLength, weight, truckWeights);

        System.out.println(solution);
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        return answer;
    }
}
