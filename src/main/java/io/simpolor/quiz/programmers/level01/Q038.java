package io.simpolor.quiz.programmers.level01;

import java.util.*;

public class Q038 {

    /***
     * [1차] 비밀지도
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 비밀지도
     * 네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다.
     * 그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다.
     * 다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.
     *
     * 1. 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 공백(" ) 또는벽(#") 두 종류로 이루어져 있다.
     * 2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 지도 1과 지도 2라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
     *    지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
     * 3. 지도 1과 지도 2는 각각 정수 배열로 암호화되어 있다.
     * 4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
     *
     * secret map
     *
     * ㅁ # ㅁ ㅁ #    01001 = 9
     * # ㅁ # ㅁ ㅁ    10100 = 20
     * # # # ㅁ ㅁ    11100 = 28
     * # ㅁ ㅁ # ㅁ    10010 = 18
     * ㅁ # ㅁ # #    01011 = 11
     *
     * # # # # ㅁ    11110 = 30
     * ㅁ ㅁ ㅁ ㅁ #    00001 = 1
     * # ㅁ # ㅁ #    10101 = 21
     * # ㅁ ㅁ ㅁ #    10001 = 17
     * # # # ㅁ ㅁ    11100 = 28
     *
     * # # # # #
     * # ㅁ # ㅁ #
     * # # # ㅁ #
     * # ㅁ ㅁ # #
     * # # # # #
     *
     * 네오가 프로도의 비상금을 손에 넣을 수 있도록, 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라.
     *
     * ------------------------------
     * 입력 형식
     * ------------------------------
     * 입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다.
     *
     * 1 ≦ n ≦ 16
     * arr1, arr2는 길이 n인 정수 배열로 주어진다.
     * 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2n - 1을 만족한다.
     * 출력 형식
     * 원래의 비밀지도를 해독하여 '#', 공백으로 구성된 문자열 배열로 출력하라.
     *
     * ------------------------------
     * 입출력 예제
     * ------------------------------
     * 매개변수	값
     * n	5
     * arr1	[9, 20, 28, 18, 11]
     * arr2	[30, 1, 21, 17, 28]
     * 출력	["#####","# # #", "### #", "# ##", "#####"]
     *
     * 매개변수	값
     * n	6
     * arr1	[46, 33, 33 ,22, 31, 50]
     * arr2	[27 ,56, 19, 14, 14, 10]
     * 출력	["######", "### #", "## ##", " #### ", " #####", "### # "]
     *
     */
    public static void main(String[] args){

        int n = 5;
        int[] arr1 = new int[]{9, 20, 28, 18, 11};
        int[] arr2 = new int[]{30, 1, 21, 17, 28};

        Solution solution = new Solution();
        String[] result = solution.solution(n, arr1, arr2);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] result = new String[n];
            for (int i = 0; i < n; i++) {
                result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            }

            for (int i = 0; i < n; i++) {
                result[i] = String.format("%" + n + "s", result[i]);
                result[i] = result[i].replaceAll("1", "#");
                result[i] = result[i].replaceAll("0", " ");
            }

            return result;
        }
    }

    public static class Solution5 {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[arr1.length];
            int[] temp = new int[arr1.length];
            String[] str = new String[arr1.length];
            for(int i = 0 ; i < arr1.length; i++){
                temp[i] = arr1[i] | arr2[i];
                str[i] = Integer.toBinaryString(temp[i]);
            }
            for(int i = 0; i < str.length; i++){
                if(str[i].length() != n){
                    for(int j = str[i].length(); j < n; j++){
                        str[i] = "0" + str[i];
                    }
                }
                answer[i] = str[i].replaceAll("1", "#").replaceAll("0", " ");
            }
            return answer;
        }
    }

    public static class Solution7 {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];

            int []temp = new int[n];

            for(int i = 0 ; i < n ; i++){
                String resultStr = "";
                int target =1;
                int arr = arr1[i] | arr2[i];
                for(int j = 0 ; j < n; j++){
                    resultStr = ((arr & target) > 0 ? "#" : " ")+resultStr;
                    target = target << 1;
                }
                answer[i] = resultStr;
            }

            return answer;
        }
    }

    public static class Solution1 {
        public String makeSharp(int n, int m) {
            if(n == 0) {
                if( m > 0) {
                    String str = "";
                    for(int i = 0; i < m; i++) {
                        str += " ";
                    }
                    return str;
                }
                else return "";
            }
            else {
                return n % 2 == 0 ? makeSharp(n/2, m-1) + " " : makeSharp(n/2, m-1) + "#";
            }
        }
        public String[] solution(int n, int [] arr1, int [] arr2) {
            String [] answer = new String[n];
            int [] secretMap = new int[n];
            for(int i = 0; i < n; i++) {
                secretMap[i] = arr1[i] | arr2[i];
                answer[i] = makeSharp(secretMap[i], n);
            }
            return answer;
        }
    }

    public static class Solution2 {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            int[] result = new int[n];
            String[] strResult = new String[n];

            for(int i=0;i<n;i++) {
                result[i] = arr1[i] | arr2[i];
                strResult[i] = Integer.toBinaryString(result[i]);
            }

            System.out.println(Arrays.toString(strResult));

            String s="";
            String[] rr = new String[n];
            for(int i=0;i<n;i++) {
                s="";
                for(int j=0;j<n;j++) {
                    if(strResult[i].length()<n) {
                        strResult[i] = "0"+strResult[i];
                    }
                    if(strResult[i].charAt(j)=='1')
                        s+="#";
                    else
                        s+=" ";
                }
                rr[i] = s;
            }
            return rr;

        }
    }

    public static class Solution3 {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = {};
            String[] result = new String[n];
            for(int i = 0; i < n; i++){
                int value = 0;
                int tmp1 = arr1[i];
                int tmp2 = arr2[i];
                boolean flag = false;
                boolean space = true;
                String tmpStr = "";
                for(int j = n - 1; j >= 0; j--){
                    if(tmp1 >= (int)Math.pow(2,j)){
                        tmp1 -= (int)Math.pow(2,j);
                        tmpStr += "#";
                        flag = true;
                        space = false;
                    }
                    if(tmp2 >= (int)Math.pow(2,j)){
                        tmp2 -= (int)Math.pow(2,j);
                        if(!flag)
                            tmpStr += "#";
                        space = false;
                    }
                    if(space){
                        tmpStr += " ";
                    }
                    flag = false;
                    space = true;
                }
                result[i] = tmpStr;
            }
            answer = result;
            return answer;
        }
    }

    public static class Solution4 {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            int[] container = new int[n];

            for (int i = 0; i < n; i++) {
                container[i] = arr1[i] | arr2[i];
            }

            String[] answer = new String[n];

            for (int i = 0; i < n; i++) {
                String ans = "";
                int remainder = container[i];

                for (int j = 0; j < n; j++) {
                    if(remainder%2 == 1) { ans = "#" + ans; }
                    else { ans = " " + ans; }
                    remainder = remainder/2;
                }

                answer[i] = ans;
            }
            return answer;
        }
    }

    public static class Solution6 {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String [] arrStrAns = new String[n];

            for(int i = 0; i < n; i++) {
                String a1 = Integer.toBinaryString(arr1[i]);
                String a2 = Integer.toBinaryString(arr2[i]);

                String temp1;
                if(a1.length() < n)
                    temp1 = String.format("%" + n + "s", a1);
                else
                    temp1 = a1;

                String temp2;
                if(a2.length() < n)
                    temp2 = String.format("%" + n + "s", a2);
                else
                    temp2 = a2;

                temp1.replaceAll(" ", "0");
                temp2.replaceAll(" ", "0");

                String [] arrA1 = temp1.split("");
                String [] arrA2 = temp2.split("");

                String a = "";
                for(int j = 0; j < n; j++) {
                    a += (arrA1[j].equals("1") || arrA2[j].equals("1")) ? "1" : "0";
                }

                arrStrAns[i] = a;
            }

            String[] answer = new String[n];
            for(int i = 0; i < n; i++) {
                String [] a = arrStrAns[i].split("");

                String ans = "";
                for(int j = 0; j < a.length; j++) {
                    ans += (Integer.parseInt(a[j]) == 1) ? "#" : " ";
                }

                answer[i] = ans;
            }

            return answer;
        }
    }

}
