package io.simpolor.quiz.inflearn.스택큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q42_응급실 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        int answer = solution(n, m, arr);
        System.out.print(answer);
    }

    // 0번째 부터 진료를 주위해야함
    public static int solution(int n, int m, int[] arr){

        int answer = 0;
        Queue<Person> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            queue.offer(new Person(i, arr[i]));
        }

        while (!queue.isEmpty()){
            Person temp = queue.poll();
            for(Person person : queue){
                if(person.priority > temp.priority){
                    queue.offer(temp);
                    temp = null;
                    break;
                }
            }
            if(temp != null){
                answer++;
                if(temp.id == m){
                    return answer;
                }
            }
        }

        return answer;
    }

    public static class Person {
        public int id;
        public int priority;

        public Person(int id, int priority){
            this.id = id;
            this.priority = priority;
        }
    }
}
