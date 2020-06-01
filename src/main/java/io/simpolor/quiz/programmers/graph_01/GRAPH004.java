package io.simpolor.quiz.programmers.graph_01;

import java.util.*;

/***
 * 방의 개수
 * ------------------------------
 * 문제 설명
 * ------------------------------
 *
 * 원점(0,0)에서 시작해서 아래처럼 숫자가 적힌 방향으로 이동하며 선을 긋습니다.
 *
 * 스크린샷 2018-09-06 오후 4.55.33.png
 * O     O     O     O     O
 *
 * O    (7)   (0)   (1)    O
 *         ↖ ↑ ↗
 * O    (6) ← O → (2)    O
 *         ↙ ↓ ↘
 * O    (5)   (4)   (3)    O
 *
 * O     O     O     O     O
 *
 * ex) 1일때는 오른쪽 위로 이동
 *
 * 그림을 그릴 때, 사방이 막히면 방하나로 샙니다.
 * 이동하는 방향이 담긴 배열 arrows가 매개변수로 주어질 때, 방의 갯수를 return 하도록 solution 함수를 작성하세요.
 *
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 배열 arrows의 크기는 1 이상 100,000 이하 입니다.
 * arrows의 원소는 0 이상 7 이하 입니다.
 * 방은 다른 방으로 둘러 싸여질 수 있습니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * arrows	return
 * [6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0]	3
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 스크린샷 2018-09-06 오후 5.08.09.png
 *
 *  O     O     O     O-----O
 *                 /     /
 *  O-----0-----O---(0,0)   0
 *  |        /   ← 6 |
 *  O     0     O     0     O
 *  |     |  ＼       |
 *  O     0-----0     0     O
 *  |                 |
 *  O-----O-----O-----O     O
 *
 * (0,0) 부터 시작해서 6(왼쪽) 으로 3번 이동합니다. 그 이후 주어진 arrows 를 따라 그립니다.
 * 삼각형 (1), 큰 사각형(1), 평행사변형(1) = 3
 */
public class GRAPH004 {

    public static void main(String[] args) {

        int[] arrows = new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};


        Solution solution = new Solution();
        int result = solution.solution(arrows);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int[] arrows) {
            int answer = 0;
            Set<String> lineSet = new HashSet<>();
            Set<String> pointSet = new HashSet<String>();
            int x = 0;
            int y = 0;
            pointSet.add("" + x+"|"+y);
            for (int i = 0; i < arrows.length; i++) {
                for(int j = 0; j < 2; j++){
                    int vect = arrows[i];
                    String start = ""+ x+"|"+y;

                    if(vect<=1 || vect==7) y++;
                    if(1<=vect && vect<=3) x++;
                    if(3<=vect && vect<=5) y--;
                    if(5<=vect && vect<=7) x--;
                    String point = "" + x+"|"+y;
                    String normalLine = start +"|" + point;
                    String backLine =  point + "|" + start;

                    if(pointSet.contains(point)){
                        if(!lineSet.contains(normalLine)){
                            answer++;
                        }
                    }
                    pointSet.add(point);
                    lineSet.add(normalLine);
                    lineSet.add(backLine);
                }

            }

            return answer;
        }
    }

    public static class Solution1 {
        public int solution(int[] arrows) {
            int [] dx = {0, 1, 1, 1, 0, -1, -1, -1};
            int [] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
            Set<Long> vs = new HashSet<>();
            Set<Long> es = new HashSet<>();
            long x = 0;
            long y = 0;
            vs.add(0L);
            int cv = 0;
            for (int a : arrows) {
                long ed = a > 3 ? a - 4 : a;
                long ex = a > 3 ? x + dx[a] : x;
                long ey = a > 3 ? y + dy[a] : y;
                long e = (ex * 200000 + ey) * 4 + ed;
                if (!es.contains(e)) {
                    es.add(e);
                    if (ed == 1 || ed == 3) {
                        long ce;
                        if (ed == 1) {
                            ce = (ex * 200000 + (ey - 1)) * 4 + 3;
                        } else {
                            ce = (ex * 200000 + (ey + 1)) * 4 + 1;
                        }
                        if (es.contains(ce)) {
                            cv++;
                        }
                    }
                }

                x += dx[a];
                y += dy[a];
                vs.add(x * 200000 + y);
            }
            int e = es.size();
            int v = vs.size();
            int answer = e - v + cv + 1;
            return answer;
        }
    }

    public static class Solution2 {

        public int solution(int[] arrows) {
            int answer = 0;
            Set<String> lineSet = new HashSet<>();
            Set<String> pointSet = new HashSet<>();
            int x = 0;
            int y = 0;

            pointSet.add("(" + x + "," + y + ")");

            for (int arrow : arrows) {
                for (int j = 0; j < 2; j++) {
                    String start = "(" + x + "," + y + ")";

                    if (arrow <= 1 || arrow == 7) { y++; }
                    if (1 <= arrow && arrow <= 3) { x++; }
                    if (3 <= arrow && arrow <= 5) { y--; }
                    if (5 <= arrow && arrow <= 7) { x--; }

                    String point = "(" + x + "," + y + ")";
                    String startLine = start + "," + point;
                    String backLine = point + "," + start;
                    if (pointSet.contains(point)) {
                        if (!lineSet.contains(startLine)) {
                            answer++;
                        }
                    }
                    pointSet.add(point);
                    lineSet.add(startLine);
                    lineSet.add(backLine);
                }
            }
            return answer;
        }
    }

    public static class Solution3 {
        public static int solution(int[] arrows) {
            int n = arrows.length;
            HashSet<String> loc = new HashSet<>();
            HashSet<String> vector = new HashSet<>();
            int answer = 0;
            int[] cur = new int[] {0, 0};
            loc.add("0,0");
            for(int i=0;i<n;i++) {
                int[] nextloc = next(cur, arrows[i]);
                String nextvec = vectostr(cur[0], cur[1], arrows[i]);
                if(arrows[i]%2==1) {
                    String mid = midofvec(cur, arrows[i]);
                    if(loc.contains(mid)&&!vector.contains(nextvec)) {
                        answer++;
                    }
                    loc.add(mid);
                }
                if(loc.contains(loctostr(nextloc[0], nextloc[1]))) {
                    if(!vector.contains(nextvec)) {
                        answer++;
//                  System.out.println(loctostr(nextloc[0], nextloc[1]));
                    }
                }

                loc.add(loctostr(cur[0], cur[1]));
                vector.add(nextvec);
                int[] rev = reverse(cur, arrows[i]);
                vector.add(vectostr(rev[0], rev[1], rev[2]));
                cur=nextloc;
            }
            return answer;
        }
        static String vectostr(int x, int y, int v) {
            return ((Integer) x).toString()+","+((Integer) y).toString()+","+((Integer) v).toString();
        }
        static String loctostr(int x, int y) {
            return ((Integer) x).toString()+","+((Integer) y).toString();
        }
        static String midofvec(int[] cur, int v) {
            int[] nxt = next(cur, v);
            double x = ((double) cur[0]+nxt[0])/2;
            double y = ((double) cur[1]+nxt[1])/2;
            String re = ((Double) x).toString()+","+((Double) y).toString();
            return re;
        }
        static int[] next(int[] cur, int v) {
            int x = cur[0];
            int y = cur[1];
            if(v==0) return new int[] {x, y+1};
            else if(v==1) return new int[] {x+1, y+1};
            else if(v==2) return new int[] {x+1, y};
            else if(v==3) return new int[] {x+1, y-1};
            else if(v==4) return new int[] {x, y-1};
            else if(v==5) return new int[] {x-1, y-1};
            else if(v==6) return new int[] {x-1, y};
            else return new int[] {x-1, y+1};
        }
        static int[] reverse(int[] cur, int v) {
            int[] nt = next(cur, v);
            return new int[] {nt[0], nt[1], (v+4)%8};
        }
    }

    public static class Solution4 {
        public int solution(int[] arrows) {

            HashSet<String> pointSet = new HashSet<>();
            HashSet<String> areaSet = new HashSet<>();
            HashSet<String> lineSet = new HashSet<>();

            int x = 0;
            int y = 0;
            int lastx = 0;
            int lasty = 0;
            int head = 0;
            pointSet.add(x + "," + y);

            for (int arrow : arrows) {
                head = arrow%4;
                switch (arrow) {
                    case 0:
                        lastx = x;
                        lasty = y++;
                        break;
                    case 1:
                        lastx = x++;
                        lasty = y++;
                        break;
                    case 2:
                        lastx = x++;
                        lasty = y;
                        break;
                    case 3:
                        lastx = x++;
                        lasty = y--;
                        break;
                    case 4:
                        lastx = x;
                        lasty = y--;
                        break;
                    case 5:
                        lastx = x--;
                        lasty = y--;
                        break;
                    case 6:
                        lastx = x--;
                        lasty = y;
                        break;
                    case 7:
                        lastx = x--;
                        lasty = y++;
                        break;
                    default:
                }

                pointSet.add(x + "," + y);
                // 현재 점의 좌표를 pointSet에 추가
                areaSet.add((x+lastx)+","+(x*lastx)+","+(y+lasty)+","+(y*lasty));
                // 선이 사용하는 영역의 정보를 areaSet에 추가
                lineSet.add((x+lastx)+","+(x*lastx)+","+(y+lasty)+","+(y*lasty)+","+head);
                // 생성된 선의 정보를 lineSet에 추가

            }

            //중복점의수 = 전체점의수(1+arrow.length) - 중복제거점의수(pointSet.size())
            //중복선의수 = 전체선의수(arrow.length) - 중복제거선의수(lineSet.size())
            //중복점이 발생할때 방의수가 1증가하지만, 선이 중복되는 중복점의 경우 의미가 없으므로
            //방의수 = 중복점의수 - 중복선의수 = 1+lineSet.size()-pointSet.size()

            //같은영역내 X자로 교차하는 case를 고려하지 못해 Error 발생
            //영역은 중복되나 선이 중복하지 않는 경우(lineSet.size()-areaSet.size())를 더해주어야 정답일것으로 추정

            int answer = 1+2*lineSet.size()-pointSet.size()-areaSet.size();
            return answer;

        }
    }



}
