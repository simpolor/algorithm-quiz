package io.simpolor.quiz.programmers.level01;

import java.util.*;

public class Q1026 {

    /***
     * 제일 작은 수 제거하기
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수,
     * solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
     * 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * arr은 길이 1 이상인 배열입니다.
     * 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * arr	return
     * [4,3,2,1]	[4,3,2]
     * [10]	[-1]
     *
     */
    public static void main(String[] args){

        // int[] arr = new int[]{4, 3, 2, 1};
        int[] arr = new int[]{10};

        Solution solution = new Solution();
        int[] result = solution.solution(arr);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {
        public int[] solution(int[] arr) {

            if(arr.length > 1){
                int[] answer = new int[arr.length-1];

                Arrays.sort(arr);

                int cnt = 0;
                int[] reverse = new int[arr.length];

                for(int i=arr.length-1; 0<i; i--){
                    reverse[cnt] = arr[i];
                    cnt++;
                }

                for(int i=0; i<reverse.length-1; i++){
                    answer[i] = reverse[i];
                }

                return answer;
            }


            return new int[]{-1};
        }
    }

    public static class Solution1 {
        public int[] solution(int[] arr) {
            if (arr.length <= 1) return new int[]{ -1 };
            int min = Arrays.stream(arr).min().getAsInt();
            return Arrays.stream(arr).filter(i -> i != min).toArray();
        }
    }

    public static class Solution2 {
        public int[] solution(int[] arr) {
            if (arr.length == 1) {
                arr[0] = -1;
                return arr;
            } else {
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                for (int a : arr) {
                    arrayList.add(a);
                }
                Integer minimum = Collections.min(arrayList);
                arrayList.remove(minimum);
                int[] resultArray = new int[arr.length - 1];
                for (int i = 0; i < arrayList.size(); ++i) {
                    resultArray[i] = arrayList.get(i);
                }
                return resultArray;
            }
        }
    }

    public static class Solution3 {
        public int[] solution(int[] arr) {
            int[] answer = {};
            if(arr.length == 1) {
                answer = new int[1];
                answer[0] = -1;
            } else {
                answer = new int[arr.length-1];
                int min = arr[0];
                for(int i = 1; i< arr.length; i++) {
                    if(min > arr[i]) min = arr[i];
                }
                List<Integer> list = new ArrayList<>();
                for(int i = 0; i< arr.length; i++) {
                    if(min != arr[i]) list.add(arr[i]);
                }
                for(int i= 0; i<answer.length; i++ ) {
                    answer[i] = list.get(i);
                }
            }
            return answer;
        }
    }

    // best
    public static class Solution4 {
        public int[] solution(int[] arr) {
            if(arr.length == 1) {
                return new int[] {-1};
            }

            int[] answer = new int[arr.length-1];

            int min = Integer.MAX_VALUE;

            for (int i = 0; i < arr.length; i++) {
                if(arr[i] < min) {
                    min = arr[i];
                }
            }

            int idx = 0;

            for (int i = 0; i < arr.length; i++) {
                if( arr[i] == min) {
                    continue;
                }

                answer[idx] = arr[i];
                idx++;
            }


            return answer;
        }
    }



}
