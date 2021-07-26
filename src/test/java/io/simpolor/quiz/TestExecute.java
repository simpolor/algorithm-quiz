package io.simpolor.quiz;

import org.junit.Test;

import java.util.*;

public class TestExecute {

    @Test
    public void test(){

        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};

        int[] solution = solution(progresses, speeds);

        System.out.println(Arrays.toString(solution));
    }

    /***
     * 첫번째, 작업 종료날짜를 구함 (7, 3, 9)
     * 두번째, 종료날짜에 따른 정렬, 먼저 들어온 값보다 뒤에 값이 낮은 경우 같이 함계 (2, 1)
     * @param progresses
     * @param speeds
     * @return
     */
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<progresses.length; i++){
            for(int j=1; j<=100; j++) {
                progresses[i] += speeds[i];
                if(progresses[i] >= 100){
                    queue.add(j);
                    break;
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        int work = 1;
        int tempPoll = queue.poll(); // 비교를 위해 첫번째 값 추출
        while (!queue.isEmpty()){
            int poll = queue.poll();
            if(tempPoll >= poll){ // 같아도 같이 배포 나감
                work++;
            }else{
                result.add(work);
                work = 1;
                tempPoll = poll;
            }
        }
        result.add(work); // 마지막은 비교 대상이 없으므로 추가

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
