package io.simpolor.quiz.programmers.greedy_06;

import java.util.*;

/***
 * 체육복
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.
 * 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
 *
 * 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
 * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
 *
 * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
 * 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
 * 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 전체 학생의 수는 2명 이상 30명 이하입니다.
 * 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
 * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * n	lost	reserve	return
 * 5	[2, 4]	[1, 3, 5]	5
 * 5	[2, 4]	[3]	        4
 * 3	[3]	    [1]	        2
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 예제 #1
 * 1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.
 *
 * 예제 #2
 * 3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.
 *
 */
public class GREEDY001 {

    public static void main(String[] args) {

        int n = 5;
        int[] lost = new int[]{2, 4};
        int[] reverse = new int[]{1, 3, 5};

        Solution solution = new Solution();
        int result = solution.solution(n, lost, reverse);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int[] people = new int[n];
            int answer = n;

            System.out.println(Arrays.toString(people));
            // 읽어버린 사람 카운트
            for (int l : lost) {
                people[l - 1]--;
            }
            System.out.println(Arrays.toString(people));

            // 여벌있는 사람 카운트
            for (int r : reserve) {
                people[r - 1]++;
            }
            System.out.println(Arrays.toString(people));

            for (int i = 0; i < people.length; i++) {

                if(people[i] == -1) { // 잃어버린 사람인 경우
                    if(i-1>=0 && people[i-1] == 1) { // 앞사람의 있는지 확인
                        people[i]++;
                        people[i-1]--;
                    }else if(i+1< people.length && people[i+1] == 1) { // 뒷사람이 있는지 확인
                        people[i]++;
                        people[i+1]--;
                    }else // 그래도 없으면 최종 응답 값에 1 차감
                        answer--;
                }
            }
            return answer;
        }
    }

    public static class Solution1 {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            answer = n;

            for (int i = 0; i < lost.length; i++) {
                boolean rent = false;
                int j = 0;
                while (!rent) {
                    if (j == reserve.length) break;
                    if (lost[i] == reserve[j]) {
                        reserve[j] = -1;
                        rent = true;
                    } else if (lost[i] - reserve[j] == 1) {
                        reserve[j] = -1;
                        rent = true;
                    } else if (lost[i] - reserve[j] == -1) {
                        reserve[j] = -1;
                        rent = true;
                    } else {
                        j++;
                    }
                }
                if (!rent) answer--;
            }
            return answer;
        }
    }

    public static class Solution2 {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer=n-lost.length;
            HashSet<Integer> ko = new HashSet<Integer>();
            for(int k : reserve) {
                ko.add(k);
            }
            for(int i =0;i<lost.length;i++) {
                if(ko.contains(lost[i])) {
                    //System.out.println("내껀내가입지");
                    answer++;
                    ko.remove(lost[i]);
                    lost[i]=-1;
                }
            }


            for(int i =0;i<lost.length;i++) {
                //System.out.println(i);

                if(ko.contains(lost[i]-1)) {
                    //System.out.println("있다");
                    answer++;
                    ko.remove(lost[i]-1);
                }else if(ko.contains(lost[i]+1)) {
                    //System.out.println("있다");
                    answer++;
                    ko.remove(lost[i]+1);
                }
                //System.out.println("없다");
            }


            return answer;
        }
    }

    public static class Solution3 {
        public int solution(int n, int[] lost, int[] reserve) {
            int[] student = new int[n];

            for (int i = 0; i < student.length; i++) {
                student[i] = 1;
            }

            for (int i = 0; i < lost.length; i++) {
                student[lost[i]-1] = 0;
            }

            for (int i = 0; i < reserve.length; i++) {
                student[reserve[i]-1] += 1;
            }

            for (int i = 0; i < student.length; i++) {
                if (student[i] == 0) {
                    if(i == 0) {
                        if (student[i + 1] == 2) {
                            student[i + 1] = 1;
                            student[i] = 1;
                        }
                    }else if(i == student.length-1) {
                        if (student[i - 1] == 2) {
                            student[i - 1] = 1;
                            student[i] = 1;
                        }
                    }else{
                        if (student[i - 1] == 2) {
                            student[i - 1] = 1;
                            student[i] = 1;
                        } else if (student[i + 1] == 2) {
                            student[i + 1] = 1;
                            student[i] = 1;
                        }
                    }
                }
            }

            int cnt = 0;
            for (int i = 0; i < student.length; i++) {
                if(student[i] != 0) {
                    cnt++;
                }
            }

            return cnt;
        }
    }

    public static class Solution4 {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            int numlost = 0;

            int [] clas = new int[n];
            Arrays.fill(clas,1);

            for(int i=0; i < reserve.length ;i++){
                clas[reserve[i]-1] += 1;
            }

            for(int j=0; j < lost.length ; j++) {
                clas[lost[j]-1] -= 1;
                if(clas[lost[j]-1] == 0)
                    numlost +=1;
            }

            for(int k = 0 ; k < clas.length ; k++) {
                if(clas[k] == 0) {
                    if(k != 0 && clas[k-1] == 2){
                        clas[k]+=1;
                        clas[k-1]-=1;
                        numlost -=1;
                    }
                    else if(k != clas.length-1 && clas[k+1] == 2) {
                        clas[k]+=1;
                        clas[k+1]-=1;
                        numlost-=1;
                    }
                }
            }
            answer = n - numlost;

            System.out.println(answer);
            return answer;
        }
    }





}
