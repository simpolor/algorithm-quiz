package io.simpolor.quiz.inflearn.탐색;

// 원소의 n의 부분집합의 공식은 2n 제곱이다
// 입력 3일 경우 123, 12, 13, 1, 23, 2, 3 출력
public class Q58_부분집합_구하기_DFS {

    public static int n;
    public static int[] ch; // 체크용 변수

    public static void main(String[] args) {

        n = 3;
        ch = new int[n+1];
        solution(1);
    }

    // 부분 집합은 순서대로 1 2 3 .. 뻗어나감
    // 부분 집한은 이진트리를 사용
    public static void solution(int index){
        if(index == n+1){
            String temp = " ";
            for(int i=1; i<=n; i++){
                if(ch[i] == 1){
                    temp += (i + " ");
                }
            }
            if(temp.length() > 0){ // 공집합 출력을 안하기 위한 조건문
                System.out.println(temp);
            }
        }else{
            ch[index] = 1; // 해당 원소를 사용한다.. 스택 프레임에 의한 사용유무
            solution(index + 1); // 왼쪽
            ch[index] = 0; // 해당 원소를 사용안한다.
            solution(index + 1); // 오른쪽
        }
    }
}
