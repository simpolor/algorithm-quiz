package io.simpolor.quiz.programmers.dynamic;

import java.util.*;

/***
 * N으로 표현
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.
 *
 * 12 = 5 + 5 + (5 / 5) + (5 / 5)
 * 12 = 55 / 5 + 5 / 5
 * 12 = (55 + 5) / 5
 *
 * 5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
 * 이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * N은 1 이상 9 이하입니다.
 * number는 1 이상 32,000 이하입니다.
 * 수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
 * 최솟값이 8보다 크면 -1을 return 합니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * N	number	return
 * 5,	12, 	4
 * 2	11, 	3
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 예제 #1
 * 문제에 나온 예와 같습니다.
 *
 * 예제 #2
 * 11 = 22 / 2와 같이 2를 3번만 사용하여 표현할 수 있습니다.
 *
 * 출처
 *
 */
public class DYNAMIC001 {

    public static void main(String[] args) {

        int n = 5;
        int number = 12;

        Solution solution = new Solution();
        int result = solution.solution(n, number);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int N, int number) {
            int answer = -1;
            HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
            HashSet<Integer> s = new HashSet<>();
            s.add(N);
            map.put(1, s);

            loop : for (int i = 2; i < 9; i++) {
                HashSet<Integer> set = new LinkedHashSet<>();

                int NNN = Integer.parseInt(Integer.toBinaryString((int) Math.pow(2, i) - 1)) * N;

                if (NNN == number){
                    return i;
                }

                set.add(NNN);

                for (int j = 1; j <= i / 2; j++) {
                    Iterator<Integer> it1 = map.get(j).iterator();
                    Iterator<Integer> it2 = map.get(i - j).iterator();

                    while (it1.hasNext()) {
                        int itValue1 = it1.next();
                        while (it2.hasNext()) {
                            int itValue2 = it2.next();
                            for (Operator o : Operator.values()) {
                                int calculate = o.calculate(itValue1, itValue2);
                                if (calculate == number){
                                    answer = i;
                                    break loop;
                                }

                                set.add(calculate);
                            }
                        }
                    }
                }
                map.put(i, set);
            }

            return answer;
        }

        enum Operator {
            PLUS {
                @Override
                public int calculate(int i, int j) {
                    return i + j;
                }
            }, MINUS {
                @Override
                public int calculate(int i, int j) {
                    return i - j;
                }
            }, BACKMINUS {
                @Override
                public int calculate(int i, int j) {
                    return j - i;
                }
            }, MUL {
                @Override
                public int calculate(int i, int j) {
                    return i * j;
                }
            }, DIV {
                @Override
                public int calculate(int i, int j) {
                    if (j == 0){
                        return 0;
                    }
                    return i / j;
                }
            }, BACKDIV {
                @Override
                public int calculate(int i, int j) {
                    if (i == 0){
                        return 0;
                    }
                    return j / i;
                }
            };

            public abstract int calculate(int i, int j);
        }
    }

    public static class Solution1 {
        int answer = -1;

        public int solution(int N, int number) {
            dfs(N, 0, 0, number, "");
            return answer;
        }

        public void dfs(int n, int pos, int num, int number, String s) {
            if (pos > 8)
                return;
            if (num == number) {
                if (pos < answer || answer == -1) {
                    System.out.println(s);
                    answer = pos;
                }
                return;
            }
            int nn=0;
            for (int i = 0; i < 8; i++) {
                nn=nn*10+n;
                dfs(n, pos + 1+i, num + nn, number, s + "+");
                dfs(n, pos + 1+i, num - nn, number, s + "-");
                dfs(n, pos + 1+i, num * nn, number, s + "*");
                dfs(n, pos + 1+i, num / nn, number, s + "/");
            }
            // dfs(n,pos+1,num*10+n,number,s+"5");
        }
    }

    public static class Solution2 {
        public int solution(int N, int number) {
            int answer = -1;
            Set<Integer>[] setArr = new Set[9];
            int t = N;
            for(int i = 1; i < 9; i++) {
                setArr[i] = new HashSet<>();
                setArr[i].add(t);
                t = t * 10 + N;
            }
            for(int i = 1; i < 9; i++) {
                for(int j = 1; j < i; j++) {
                    for(Integer a : setArr[j]) {
                        for(Integer b : setArr[i - j]) {
                            setArr[i].add(a + b);
                            setArr[i].add(a - b);
                            setArr[i].add(b - a);
                            setArr[i].add(a * b);
                            if(b != 0) {
                                setArr[i].add(a / b);
                            }
                            if(a != 0) {
                                setArr[i].add(b / a);
                            }
                        }
                    }
                }
            }
            for(int i = 1; i < 9; i++) {
                if(setArr[i].contains(number)) {
                    answer = i;
                    break;
                }
            }
            return answer;
        }
    }

    public static class Solution3 {
        public int solution(int N, int number) {
            int answer = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] num = new int[9];
            ArrayList<Integer>[] lists = new ArrayList[9];
            for(int i = 1; i <= 8; i++) {
                num[i] = num[i-1]*10+N;
            }
            for(int i = 1; i <= 8; i++) {
                map.put(num[i], i);
                lists[i] = new ArrayList<>();
                lists[i].add(num[i]);
                lists[i].add(-num[i]);
            }
            for(int i = 1; i < 9; i++) {
                for (int x : lists[i]) {
                    if (!map.containsKey(x) || map.get(x) < i) continue;
                    for(int j = 1; j <  9-i; j++) {
                        for (int y : lists[j]) {
                            if (!map.containsKey(y) || map.get(y) < j) continue;
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(x+y);
                            list.add(x-y);
                            list.add(x*y);
                            if (y != 0) list.add(x / y);

                            for(int z : list) {
                                if(!map.containsKey(z) || map.get(z) > i+j) {
                                    map.put(z, i+j);
                                    lists[i+j].add(z);
                                }
                            }
                        }
                    }
                }
            }
            if(!map.containsKey(number)) {
                answer = -1;
            }
            else {
                answer = map.get(number);
            }
            return answer;
        }
    }


}
