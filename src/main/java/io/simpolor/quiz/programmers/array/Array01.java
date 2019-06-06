package io.simpolor.quiz.programmers.array;

public class Array01 {

    /***
     * 배열을 입력하면 4,3,2,1 중 가장 작은 수를 뺀 나머지 배열을 출력
     * 혹시라노 빈배열 혹은 배열에 하나의 수만 들어가 있을 경우 -10을 리턴
     */
    public static void main(String[] args) {
        int[] answer = {2,4,3,1,5};

        int[] result = new int[answer.length - 1];
        int min = 0;
        int empty = -10;

        if(answer.length > 1){
            int up = 0;
            for(int i=0; i<answer.length; i++){
                if(min == 0 || min > answer[i]){
                    min = answer[i];
                }else{
                    up++;
                }
                System.out.println("up : "+up);
            }
        }

        System.out.println(">>> result");
        for(int i : result){
            System.out.println("> : "+i);
        }

    }

}
