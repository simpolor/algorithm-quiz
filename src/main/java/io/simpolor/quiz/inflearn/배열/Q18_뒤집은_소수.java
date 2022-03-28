package io.simpolor.quiz.inflearn.배열;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1과 자기 자신 외의 약수를 가지지 않는 1보다 큰 자연수
// ex) 에스토스테네스 체 푸는 방법이 가장 빠르다.
// 해당 수의 배수를 해당 값까지 체크한다.
public class Q18_뒤집은_소수 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }

        List<Integer> answer = solution(n, nums);
        for(int i : answer){
            System.out.print(i + " ");
        }
    }

    public static List<Integer> solution(int n, int[] nums){

        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<n; i++){

            // 숫자를 뒤집는 로직
            int temp = nums[i];
            int reverse = 0; // 처음에 0이기 때문에 첫번째 자리가 1자리 부터 시작
            while (temp > 0){
                int share = temp % 10;
                reverse = reverse * 10 + share;
                temp = temp / 10;
            }

            boolean decimal = true;
            if(reverse == 1){
                decimal = false;
            }
            for(int j=2; j<reverse; j++){
                if(reverse % j == 0){
                    decimal = false;
                    break;
                }
            }
            if(decimal){
                answer.add(reverse);
            }
        }

        return answer;
    }
}
