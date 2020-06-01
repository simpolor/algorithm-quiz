package io.simpolor.quiz.programmers.greedy_06;

import java.util.Arrays;
import java.util.Comparator;

/***
 * 단속카메라
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 고속도로를 이동하는 모든 차량이 고속도로를 이용하면서 단속용 카메라를 한 번은 만나도록 카메라를 설치하려고 합니다.
 *
 * 고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때,
 * 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치해야 하는지를 return 하도록 solution 함수를 완성하세요.
 *
 * ------------------------------
 * 제한사항
 *------------------------------
 * 차량의 대수는 1대 이상 10,000대 이하입니다.
 *
 * routes에는 차량의 이동 경로가 포함되어 있으며
 * routes[i][0]에는 i번째 차량이 고속도로에 진입한 지점,
 * routes[i][1]에는 i번째 차량이 고속도로에서 나간 지점이 적혀 있습니다.
 *
 * 차량의 진입/진출 지점에 카메라가 설치되어 있어도 카메라를 만난것으로 간주합니다.
 * 차량의 진입 지점, 진출 지점은 -30,000 이상 30,000 이하입니다.
 *
 * ------------------------------
 * 입출력 예
 *------------------------------
 * routes	return
 * [[-20,15], [-14,-5], [-18,-13], [-5,-3]]	2
 *
 * ------------------------------
 * 입출력 예 설명
 *------------------------------
 * -5 지점에 카메라를 설치하면 두 번째, 네 번째 차량이 카메라를 만납니다.
 *
 * -15 지점에 카메라를 설치하면 첫 번째, 세 번째 차량이 카메라를 만납니다.
 *
 */
public class GREEDY005 {

    public static void main(String[] args) {

        int[][] routes = new int[][]{{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};

        Solution solution = new Solution();
        int result = solution.solution(routes);

        System.out.println(result);
    }

    public static class Solution {

        public int solution(int[][] routes) {
            Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

            int ans = 0;
            int last_camera = Integer.MIN_VALUE;
            for (int[] a : routes) {
                if (last_camera < a[0]) {
                    ++ans;
                    last_camera = a[1];
                }
            }
            return ans;
        }
    }

    public static class Solution1 {

        public int solution(int[][] routes) {
            Arrays.sort(routes, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] <= o2[0]){
                        return -1;
                    }
                    return 1;
                }
            });

            int answer = 0;
            int last = routes[0][1];
            for(int i=1; i<routes.length; i++){

                if(routes[i][0] <= last){
                    if(last >= routes[i][1]){
                        last = routes[i][1];
                    }
                }else{
                    answer += 1;
                    last = routes[i][1];
                }

            }
            answer += 1;

            return answer;
        }
    }

    public static class Solution2 {
        public int solution(int[][] routes) {
            int cameraCnt = 0, lastCameraLocation = Integer.MIN_VALUE;
            Arrays.sort(routes, new Comparator<int[]>() {
                public int compare(int[] arg0, int[] arg1) {
                    return Integer.compare(arg0[1], arg1[1]);
                }
            });

            for (int[] section : routes) {
                if (lastCameraLocation < section[0]) {
                    cameraCnt++;
                    lastCameraLocation = section[1];
                }
            }

            return cameraCnt;
        }
    }

    public static class Solution3 {
        public int solution(int[][] routes) {
            int answer = 0;
            Arrays.sort(routes, new Comparator<int []>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[1], o2[1]);
                }
            });
            int cameraPos = -30001;
            for(int i = 0; i < routes.length; i++) {
                if(cameraPos < routes[i][0]) {
                    answer++;
                    cameraPos = routes[i][1];
                }
            }
            return answer;
        }
    }


}
