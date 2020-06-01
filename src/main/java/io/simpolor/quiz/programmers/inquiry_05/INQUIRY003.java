package io.simpolor.quiz.programmers.inquiry_05;

import java.util.*;

/***
 * 숫자 야구
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 게임해보기
 *
 * 각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다.
 * 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.
 *
 * [ 숫자는 맞지만, 위치가 틀렸을 때는 볼 ]
 * [ 숫자와 위치가 모두 맞을 때는 스트라이크 ]
 * [ 숫자와 위치가 모두 틀렸을 때는 아웃 ]
 *
 * 예를 들어, 아래의 경우가 있으면
 *
 * A : 123
 * B : 1스트라이크 1볼.
 * A : 356
 * B : 1스트라이크 0볼.
 * A : 327
 * B : 2스트라이크 0볼.
 * A : 489
 * B : 0스트라이크 1볼.
 * 이때 가능한 답은 324와 328 두 가지입니다.
 *
 * 질문한 세 자리의 수, 스트라이크의 수,
 * 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때,
 * 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 질문의 수는 1 이상 100 이하의 자연수입니다.
 * baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * baseball	return
 * [[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]	2
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 문제에 나온 예와 같습니다.
 *
 */
public class INQUIRY003 {

    public static void main(String[] args) {

        int[][] baseball = new int[][]{{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};

        Solution solution = new Solution();
        int result = solution.solution(baseball);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int[][] baseball) {
            int result = 0;
            boolean data[] = new boolean[1000];
            for(int i=0; i<data.length; i++) {
                String n = Integer.toString(i);
                if(n.length() < 3) {data[i] = true;}
                else if(n.charAt(0)=='0' || n.charAt(1)=='0' || n.charAt(2)=='0') {data[i] = true;}
                else if(n.charAt(0) == n.charAt(1) || n.charAt(0) == n.charAt(2) || n.charAt(1) == n.charAt(2)) {data[i] = true;}
            }
            for(int i=0; i<baseball.length; i++) {
                int answer = baseball[i][0];
                int s = baseball[i][1];
                int b = baseball[i][2];

                for(int j=123; j<=987; j++) {
                    if(!data[j]) {
                        int[] sbData = judge(Integer.toString(j), Integer.toString(answer));
                        if(sbData[0] != s || sbData[1] != b) {data[j] = true;}
                    }
                }
            }
            for(int i=0; i<data.length; i++) {
                if(!data[i]) {result++;}
            }
            return result;
        }
        int[] judge(String n1, String n2) {
            int s = 0;
            int b = 0;
            char[] c = n2.toCharArray();
            for(int i=0; i<3; i++) {
                if(n1.indexOf(c[i]) >= 0) {
                    if(n1.charAt(i) == c[i]) {s++;}
                    else {b++;}
                }
            }
            return new int[] {s, b};
        }
    }

    public static class Solution1 {
        public int solution(int[][] baseball) {
            int[][] a = new int[baseball.length][5];

            for(int i = 0; i < baseball.length; i++){
                a[i][0] = String.valueOf(baseball[i][0]).charAt(0) - '0';
                a[i][1] = String.valueOf(baseball[i][0]).charAt(1) - '0';
                a[i][2] = String.valueOf(baseball[i][0]).charAt(2) - '0';
                a[i][3] = baseball[i][1];
                a[i][4] = baseball[i][2];
            }

            int ret = 0;

            int[] b = new int[3];

            for(b[0] = 1; b[0] < 10; b[0]++)
                for(b[1] = 1; b[1] < 10; b[1]++){
                    if(b[0] == b[1]) continue;
                    for(b[2] = 1; b[2] < 10; b[2]++){
                        if(b[0] == b[2] || b[1] == b[2]) continue;
                        if(match(b, a)) ret++;
                    }
                }

            return ret;
        }

        boolean match(int[] b, int[][] a){
            for(int i = 0; i < a.length; i++){
                int strike = 0;
                int ball = 0;
                for(int j = 0; j < b.length; j++)
                    for(int k = 0; k < b.length; k++){
                        if(b[j] == a[i][k]){
                            if(j == k) strike++;
                            else ball++;
                            break;
                        }
                    }

                if(a[i][3] != strike || a[i][4] != ball) return false;
            }

            return true;
        }
    }

    public static class Solution2 {
        public int solution(int[][] baseball) {
            int answer = 0;
            int[][] nums = new int[baseball.length][3];
            for(int i = 0; i < baseball.length; i++) {
                for(int j = 2; j >= 0; j--) {
                    nums[i][j] = baseball[i][0] % 10;
                    baseball[i][0] /= 10;
                }
            }
            Set<Integer> set = new HashSet<>();
            for(int i = 111; i < 1000; i++) {
                int[] num = new int[3];
                int t = i;
                for(int j = 2; j >= 0; j--) {
                    num[j] = t % 10;
                    t /= 10;
                }
                for(int k = 0; k < 3; k++) {
                    set.add(num[k]);
                }
                if(set.size() < 3 || set.contains(0)) {
                    set.clear();
                    continue;
                }
                int count = 0;
                for(int j = 0; j < nums.length; j++) {
                    int strike = 0, ball = 0;
                    for(int k = 0; k < 3; k++) {
                        if(set.contains(nums[j][k])) {
                            ball++;
                        }
                    }
                    for(int k = 0; k < 3; k++) {
                        if(num[k] == nums[j][k]) {
                            strike++;
                            ball--;
                        }
                    }
                    if(baseball[j][1] == strike && baseball[j][2] == ball) {
                        count++;
                    }
                }
                if(count == baseball.length) {
                    answer++;
                }
                set.clear();
            }
            return answer;
        }
    }

    public static class Solution3 {
        public int solution(int[][] baseball) {
            int ans = 0;

            for (int i=123; i<=987; i++) {
                int b = i/10 % 10;
                if (b == 0) continue;
                int a = i % 10;
                if (a == 0 || a == b) continue;
                int c = i / 100;
                if (b == c || a == c) continue;
                boolean flag = true;
                for (int j=0; j<baseball.length; j++) {
                    if (!isCorrect(a, b, c, baseball[j][0], baseball[j][1], baseball[j][2])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) ans++;
            }

            return ans;
        }

        static boolean isCorrect(int a, int b, int c, int q, int strike, int ball) {
            int A, B, C, strikeCnt = 0, ballCnt = 0;
            A = q % 10;
            B = q/10 % 10;
            C = q / 100;

            if (a == A) strikeCnt++;
            if (b == B) strikeCnt++;
            if (c == C) strikeCnt++;
            if (a != A && (a == B || a == C)) ballCnt++;
            if (b != B && (b == A || b == C)) ballCnt++;
            if (c != C && (c == A || c == B)) ballCnt++;

            if (strikeCnt == strike && ballCnt == ball) return true;
            return false;
        }
    }

    public static class Solution4 {
        public int solution(int[][] baseball) {
            //모든 가능한 경우의 수 (123 ~ 987)나열
            ArrayList<String> per = new ArrayList<>();

            for(int i=1; i<10; i++) {   //첫째 자리 생성
                String result1 = "";
                String first = i +"";
                result1 = result1 + first;
                for(int j=1; j<10; j++) {   //둘째 자리 생성 - 첫째 자리에 있는 숫자면 pass
                    String result2 ="";
                    String second = j + "";
                    if(!result1.contains(second)) {
                        result2 = result1 + second;
                    }else {
                        continue;
                    }
                    for(int k =1; k<10; k++) {  //셋째 자리 생성 - 첫째, 둘째자리에 있는 숫자면 pass
                        String result3 = "";
                        String third = k + "";
                        if(!result2.contains(third)) {
                            result3 = result2 + third;
                            per.add(result3);
                        }
                    }
                }
            }


            int N = baseball.length;
            for(int i=0; i<N; i++) {
                //질문한 세 자리의 수와 비교해서 스트라이크,볼의  수가 같은지 확인
                String question = baseball[i][0] + "";
                int real_strike = baseball[i][1];
                int real_ball = baseball[i][2];
                ArrayList<String> answers = new ArrayList<>();

                for(String p : per) { //남은 모든 경우의 수와 question 직접비교

                    //strike비교하자
                    int strike = 0;
                    for(int j=0; j<3; j++) {
                        if(p.substring(j,j+1).equals(question.substring(j,j+1))) {
                            strike++;
                        }
                    }
                    if(strike != real_strike) continue;

                    //ball비교하자
                    //어떤 세자리 숫자의 i번째 숫자를
                    //question이 가지고 있으면서 동시에 i번째 숫자가 아니면 ball
                    int ball = 0;
                    for(int j=0; j<3; j++) {
                        if(question.contains(p.substring(j,j+1)) &&
                                !question.substring(j, j+1).equals(p.substring(j,j+1))) {
                            ball++;
                        }
                    }
                    if(ball != real_ball) continue;

                    answers.add(p);

                }
                //맞는놈만 반복해서 확인 (덮어쓰기)
                per = answers;
                //반복
            }
            //남은놈 리턴



            int answer = per.size();
            return answer;
        }

    }

    public static class Solution5 {
        public int solution(int[][] baseball) {
            int answer = 0;
            int n = baseball.length;

            int s;
            int b;
            int v;
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    for (int k = 1; k <= 9; k++) {
                        if (i == j || i == k || j == k) continue;

                        set.add(i);
                        set.add(j);
                        set.add(k);

                        int index;
                        for (index = 0; index < n; index++) {
                            s = 0;
                            b = 0;
                            if (i == (v = (baseball[index][0] / 100))) s++;
                            else {
                                if (set.contains(v)) b++;
                            }

                            if (j == (v = (baseball[index][0] / 10) % 10)) s++;
                            else {
                                if (set.contains(v)) b++;
                            }

                            if (k == (v = (baseball[index][0] % 10))) s++;
                            else {
                                if (set.contains(v)) b++;
                            }

                            if (s != baseball[index][1]) break;
                            if (b != baseball[index][2]) break;
                        }
                        if (index == n) answer++;
                        set.clear();
                    }
                }
            }

            return answer;
        }
    }

    public static class Solution6 {
        public int solution(int[][] baseball) {
            int answer = 0;
            for(int t = 111; t <= 999; t++) {
                int fir = t/100;
                int sec = (t%100)/10;
                int thr = t%10;
                if(fir == sec || fir == thr || sec == thr) {
                    continue;
                }
                if(fir == 0 || sec == 0 || thr == 0 ) {
                    continue;
                }
                if(compare(t, baseball)) {
                    answer++;
                }
            }
            return answer;
        }

        public boolean compare(int t, int[][] baseball) {
            for(int i = 0; i < baseball.length; i++) {
                int[] res = check(t,baseball[i][0]);
                if(res[0] != baseball[i][1] || res[1] != baseball[i][2]) {
                    return false;
                }
            }
            return true;
        }

        public int[] check(int t, int n) {
            int[] res = new int[2];
            String s1 = String.valueOf(t);
            String s2 = String.valueOf(n);
            for(int i = 0; i < 3; i++) {
                if(s1.charAt(i) == s2.charAt(i)) {
                    res[0]++;
                }
            }

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(i==j) {
                        continue;
                    }
                    if(s1.charAt(i)==s2.charAt(j)) {
                        res[1]++;
                    }
                }

            }
            return res;
        }
    }


}
