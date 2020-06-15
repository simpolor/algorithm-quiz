package io.simpolor.quiz.programmers.ez;

import java.util.Arrays;

public class Q005 {


    /***
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 배열을 입력하면 4,3,2,1 중 가장 작은 수를 뺀 나머지 배열을 출력
     * 혹시라노 빈배열 혹은 배열에 하나의 수만 들어가 있을 경우 -10을 리턴
     *
     */
    public static void main(String[] args){

        int[] arr = new int[]{5, 4, 6};

        Solution solution = new Solution();
        int[] result = solution.solution(arr);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {

        public int[] solution(int[] arr){

            if(arr.length <= 1){
                return new int[]{ -10 };
            }

            int index = 0;
            for(int i=0; i<arr.length; i++){
                if(arr[index] > arr[i]){
                    index = i;
                }
            }

            int count = 0;
            int[] answer = new int[arr.length -1];
            for(int i=0; i<arr.length; i++){
                if(index != i){
                    answer[count++] = arr[i];
                }
            }

            System.out.println(index);

            return answer;
        }
    }
}
