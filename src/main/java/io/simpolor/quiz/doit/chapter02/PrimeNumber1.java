package io.simpolor.quiz.doit.chapter02;

public class PrimeNumber1 {

    public static void main(String[] args){
        int counter = 0; // 나눗셈의 횟수

        for(int n=2; n<=1000; n++){
            int i;
            for(i=2; i<n; i++){
                counter++;
                if(n % i == 0){ // 나누어 떨어지면 소수가 아님
                    break; // 더이상 반복은 불필요
                }
            }
            if(n == i){ // 마지막까지 나누어떨어지지 않음
                System.out.println(n);
            }
        }

        System.out.println("나눗셈을 수행하는 횟수 : "+counter);
    }
}
