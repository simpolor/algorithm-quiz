package io.simpolor.quiz.programmers.level01;

import java.time.LocalDate;

public class Q_2016년 {

    /***
     * 2016 ( 연습문제 )
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
     *
     * 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수,
     * solution을 완성하세요.
     *
     * 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT 입니다.
     *
     * 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * 2016년은 윤년입니다.
     * 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
     *
     */
    public static void main(String[] args){

        int a = 5;
        int b = 24;

        Solution solution = new Solution();
        String result = solution.solution(a, b);

        System.out.println(result);
    }


    public static class Solution {
        public String solution(int a, int b) {

            String answer = "";

            LocalDate localDate = LocalDate.of(2016, a, b);

            int dayOfWeek = localDate.getDayOfWeek().getValue();

            switch (dayOfWeek){

                case 0:
                    answer = "SUN";
                    break;
                case 1:
                    answer = "MON";
                    break;
                case 2:
                    answer = "TUE";
                    break;
                case 3:
                    answer = "WED";
                    break;
                case 4:
                    answer = "THU";
                    break;
                case 5:
                    answer = "FRI";
                    break;
                case 6:
                    answer = "SAT";
                    break;
            }


            return answer;
        }
    }

    public static class Solution1 {
        public String solution(int a, int b) {

            String answer = "";

            //16/1/1 은 금요일 이므로 index 0 을 금요일로 설정
            String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
            int[] mon = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            int totalDays = 0;
            for (int i=1; i<a; i++) {
                totalDays += mon[i-1];
            }
            totalDays += b - 1;

            answer = day[totalDays % 7];

            return answer;
        }
    }


    public static class Solution1_1 {

        public String solution(int a, int b) {

            String answer = "";

            String[] day = new String[] { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
            int[] month = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

            int x = 0;

            if (a == 2) {
                if (b<0 && b>29)
                    return "2월은 29일 이하로 입력해주세요";

            } else if (a == 1 || a == 3 || a == 5 || a == 7 || a == 8 || a == 10 || a == 12) {
                if (b<0 && b>31)
                    return "31일 이하로 입력해주세요.";
            } else if (a == 4 || a == 6 || a == 9 || a == 11) {
                if (b<0 && b>30)
                    return "30일 이하로 입력해주세여";
            }

            for (int i = 0; i < a - 1; i++) {
                x += month[i];
            }
            x += b-1;
            answer = day[x%7];

            return answer;
        }
    }

    public static class Solution2 {
        public String solution(int a, int b) { // 문제2] 2016년 (programmers 1단계)

            String answer = "";

            int[] monthEnd = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            String[] weekEng = "SUN,MON,TUE,WED,THU,FRI,SAT".split(",");

            String[][] data = new String[12][31];

            int rememberWeek = 5;

            for(int i=0;i<data.length;i++) {
                for(int j=0;j<monthEnd[i];j++) {
                    data[i][j] = weekEng[(j + rememberWeek) % (weekEng.length)];
                }
                rememberWeek = (rememberWeek + monthEnd[i] % weekEng.length) % weekEng.length;
            }

            answer = data[a-1][b-1];

            return answer;
        }
    }

    public static class Solution3 {
        public String solution(int a, int b) {

            int d = 0 ; // 2016년의 누적 일 수를 담을 변수 d

            String answer = "";
            String day[] = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"}; //16/1/1 은 금요일 이므로 index 0 을 금요일로 설정
            int index;

            switch(a) {
                case 1 : //누적 일수 0
                    d = b; //전달 까지의 일수 count + b
                    index = d%7-1;
                    if (index < 0) {
                        index = 6;
                    }
                    answer = day[index]; //index 0부터 시작하므로 -1
                    return answer;
                case 2 :
                    d = 30*(a-1) + (a/2) + b; //전달 까지의 일수 count + b
                    index = d%7-1;
                    if (index < 0) {
                        index = 6;
                    }
                    answer = day[index];
                    return answer;
                case 9 : case 11 :
                    d = 30*(a-1) + a - (a/2) - 1 + b; //전달 까지의 일수 count + b
                    index = d%7-1;
                    if (index < 0) {
                        index = 6;
                    }
                    answer = day[index];
                    return answer;
                default :
                    d = 30*(a-1) + (a/2) - 1 + b; //전달 까지의 일수 count + b
                    index = d%7-1;
                    if (index < 0) {
                        index = 6;
                    }
                    answer = day[index];
                    return answer;
            }
        }
    }

    public static class Solution4 {

        public String solution(int a, int b) {
            String answer = "";

            int c = 0;      // 요일 구하기 위해 더할 변수

            switch(a) {
                case 1 : case 4 : case 7 : c = 4; break;
                case 3 : case 11: c = 1; break;
                case 6 : c = 2; break;
                case 9 : case 12: c = 3; break;
                case 10 : c = 5; break;
                case 5 : c = 6; break;
            }

            switch(((b % 7) + c) % 7) {
                case 0 : answer = "SUN"; break;
                case 1 : answer = "MON"; break;
                case 2 : answer = "TUE"; break;
                case 3 : answer = "WED"; break;
                case 4 : answer = "THU"; break;
                case 5 : answer = "FRI"; break;
                case 6 : answer = "SAT"; break;
            }

            return answer;
        }
    }

    public static class Solution5 {
        public String solution(int a, int b) {

            int[] year2016 = {31,29,31,30,31,30,31,31,30,31,30,31};

            int days = 0;
            for(int i=0; i<year2016.length; i++){
                if(i==a-1) break;
                days += year2016[i];
            }
            days += b;

            switch(days%7) {
                case 0: return "THU";
                case 1: return "FRI";
                case 2: return "SAT";
                case 3: return "SUN";
                case 4: return "MON";
                case 5: return "TUE";
                case 6: return "WED";
            }

            return null;
        }
    }

    public static class Solution6 {
        public String solution(int a, int b) {

            String answer = "";
            int sum = b;

            for(int i=1 ;i <a;i++){
                if(i == 1 ||i == 3 ||i == 5 ||i == 7 ||i == 8 ||i == 10 ||i == 12)
                    sum += 31;
                else if(i == 2)
                    sum += 29;
                else
                    sum += 30;
            }

            String[] weekday = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
            answer = weekday[sum% 7 ];

            return answer;
        }
    }





}
