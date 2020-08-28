package io.simpolor.quiz.programmers.level01;

import java.util.Stack;

public class Q1001 {


    /***
     * 인형뽑기
     *
     * ------------------------------
     * 문제 설명 ( 카카오 인턴쉽 )
     * ------------------------------
     * 게임개발자인 죠르디는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 합니다.
     * 죠르디는 게임의 재미를 높이기 위해 화면 구성과 규칙을 다음과 같이 게임 로직에 반영하려고 합니다.
     *
     * ㅁ ㅁ ㅁ ㅁ ㅁ  ㅁ
     * ㅁ ㅁ ㅋ ㅁ ㅋ  ㅁ
     * ㅁ ㅋ ㅋ ㅁ ㅋ  ㅁ
     * ㅋ ㅋ ㅋ ㅋ ㅋ  ㅁ
     * ㅋ ㅋ ㅋ ㅋ ㅋ  ㅁ
     * 1  2  3  4  5
     *
     * 게임 화면은 1 x 1 크기의 칸들로 이루어진 N x N 크기의 정사각 격자이며 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다. (위 그림은 5 x 5 크기의 예시입니다).
     * 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다.
     * 모든 인형은 1 x 1 크기의 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다.
     * 게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다.
     * 집어 올린 인형은 바구니에 쌓이게 되는 데, 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다.
     * 다음 그림은 [1번, 5번, 3번] 위치에서 순서대로 인형을 집어 올려 바구니에 담은 모습입니다.
     *
     * ㅁ ㅁ ㅁ ㅁ ㅁ  ㅁ
     * ㅁ ㅁ ㅁ ㅁ ㅁ  ㅁ
     * ㅁ ㅋ ㅋ ㅁ ㅋ  ㅋ
     * ㅁ ㅋ ㅋ ㅋ ㅋ  ㅋ
     * ㅋ ㅋ ㅋ ㅋ ㅋ  ㅋ
     * 1  2  3  4  5
     *
     * 만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다.
     * 위 상태에서 이어서 [5번] 위치에서 인형을 집어 바구니에 쌓으면 같은 모양 인형 두 개가 없어집니다.
     *
     * ㅁ ㅁ ㅁ ㅁ ㅁ  ㅁ            ㅁ ㅁ ㅁ ㅁ ㅁ  ㅁ
     * ㅁ ㅁ ㅁ ㅁ ㅁ  ㅋ            ㅁ ㅁ ㅁ ㅁ ㅁ  ㅁ
     * ㅁ ㅋ ㅋ ㅁ ㅁ  ㅋ      ->    ㅁ ㅋ ㅋ ㅁ ㅁ  ㅁ
     * ㅁ ㅋ ㅋ ㅋ ㅋ  ㅋ            ㅁ ㅋ ㅋ ㅋ ㅋ  ㅋ
     * ㅋ ㅋ ㅋ ㅋ ㅋ  ㅋ            ㅋ ㅋ ㅋ ㅋ ㅋ  ㅋ
     *  1  2  3  4  5                1  2  3  4  5
     *
     * 크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.
     * 또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다. (그림에서는 화면표시 제약으로 5칸만으로 표현하였음)
     *
     * 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,
     * 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return 하도록 solution 함수를 완성해주세요.
     *
     * ------------------------------
     * 제한사항
     * ------------------------------
     * board 배열은 2차원 배열로 크기는 5 x 5 이상 30 x 30 이하입니다.
     * board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
     * 0은 빈 칸을 나타냅니다.
     * 1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
     * moves 배열의 크기는 1 이상 1,000 이하입니다.
     * moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * board
     * [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
     *
     * moves
     * [1,5,3,5,1,2,1,4]
     *
     * result
     * 4
     *
     * ------------------------------
     * 입출력 예에 대한 설명
     * ------------------------------
     * 입출력 예 #1
     *
     * 인형의 처음 상태는 문제에 주어진 예시와 같습니다.
     * 크레인이 [1, 5, 3, 5, 1, 2, 1, 4] 번 위치에서 차례대로 인형을 집어서 바구니에 옮겨 담은 후,
     * 상태는 아래 그림과 같으며 바구니에 담는 과정에서 터트려져 사라진 인형은 4개 입니다.
     *
     */
    public static void main(String[] args){

        int[][] board = new int[][]{
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}};

        int[] moves = new int[]{ 1, 5, 3, 5, 1, 2, 1, 4 };

        Solution solution = new Solution();
        int result = solution.solution(board, moves);

        System.out.println(result);
    }

    public static class Solution {

        public int solution(int[][] board, int[] moves) {

            int answer = 0;

            Stack<Integer> stack = new Stack<>();

            // 크레인을 움직인 수 만큼 반복
            for(int i=0; i<moves.length; i++){

                // 실제로 인덱스는 0부터 시작하므로 -1
                int pickup = moves[i] - 1;

                // 현재 인형
                for(int j=0; j<board.length; j++){
                    int doll = board[j][pickup];

                    if(doll != 0){
                        board[j][pickup] = 0;

                        if(!stack.empty()){
                            int bump = stack.peek();
                            if(bump == doll){
                                stack.pop();
                                answer += 2;
                                break;
                            }
                        }

                        stack.push(doll);
                        break;
                    }
                }
            }

            return answer;
        }

    }

    public static class Solution1 {

        public int solution(int[][] board, int[] moves) {
            int count = 0;
            Stack<Integer> st = new Stack<Integer>();
            for(int i = 0; i < moves.length; i++) {        //뽑는 인형 위치
                int pickUp = moves[i]-1;                //moves의 위치를 board 배열의 인덱스로 치환
                int temp = 0;                            //뽑은 인형
                for(int j = 0; j < board.length; j++) {    //위에서 아래로 내려가면서 인형을 뽑으면 그부분을 0으로 만들어 주고 break
                    if(board[j][pickUp] != 0) {
                        temp = board[j][pickUp];        //뽑은 인형
                        board[j][pickUp] = 0;
                        break;
                    }
                }
                if(temp != 0) {                            //1.인형을 뽑았는데
                    if(st.isEmpty()) {                    //2-1.바구니가 비었으면
                        st.push(temp);                    //바구니에 push
                    }else {                                //2-2.바구니가 안비었으면
                        if(st.peek() == temp) {            //3-1.바구니 최근에 담긴게 뽑은 인형이랑 같으면
                            st.pop();                    //담긴 인형을 없애고
                            count++;                    //터트림
                        }else {                            //3-2.바구니에 담긴 인형이 뽑은인형이랑 다르면
                            st.push(temp);                //뽑은 인형을 바구니에 추가
                        }
                    }
                }
            }
            return count*2;                                //없어진 인형은 짝을 이루므로 *2
        }

    }

    public static class Solution2 {
        public static int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < moves.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[j][moves[i] - 1] != 0) {
                        //해당 위치에 인형이 있는 경우
                        if (st.empty()) {
                            //인형을 담을 스택이 비어있는 경우
                            st.push(board[j][moves[i] - 1]);
                        } else {
                            //스택이 비어있지 않는 경우
                            if (st.peek() == board[j][moves[i] - 1]) {
                                //st.peek()을 사용하여 집어올린 인형과 값을 비교해 두 값이 같은 경우에는
                                st.pop();
                                //스택에서 인형을 제거한 뒤
                                answer += 2;
                                // answer를 2 증가시켜준다. (인형 2개가 사라지기 때문)
                            } else {
                                //st.peek()을 사용하여 집어올린 인형과 값을 비교해 두 값이 다른 경우에는
                                st.push(board[j][moves[i] - 1]);
                                //스택에 인형을 넣어준다.
                            }
                        }
                        //일련의 작업이 끝난 뒤 인형을 집어올린 좌표에는 더 이상 인형이 없으므로 0을 저장한다.
                        board[j][moves[i] - 1] = 0;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
