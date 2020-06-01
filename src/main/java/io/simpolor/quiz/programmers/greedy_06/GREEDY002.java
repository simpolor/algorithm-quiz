package io.simpolor.quiz.programmers.greedy_06;

/***
 * 조이스틱
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
 * ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
 *
 * 조이스틱을 각 방향으로 움직이면 아래와 같습니다.
 *
 * ▲ - 다음 알파벳
 * ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
 * ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
 * ▶ - 커서를 오른쪽으로 이동
 *
 * 예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.
 *
 * - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다. A B C D E F G H J
 * - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다. A
 * - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다. Z
 *
 * 따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
 * 만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
 *
 * ------------------------------
 * 제한 사항
 * ------------------------------
 * name은 알파벳 대문자로만 이루어져 있습니다.
 * name의 길이는 1 이상 20 이하입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * name	return
 * JEROEN	56
 * JAN	23
 *
 */
public class GREEDY002 {

    public static void main(String[] args) {

        String name = "JAN";

        Solution solution = new Solution();
        int result = solution.solution(name);

        System.out.println(result);
    }

    public static class Solution1 {

        public int solution(String name) {

            int answer = 0;

            int[] diff={0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};

            for(char c:name.toCharArray()) {
                answer += diff[c - 'A'];
            }

            int length=name.length();
            int min=length-1;

            for(int i=0;i<length;i++){
                int next=i+1;
                while(next<length && name.charAt(next)=='A'){
                    next++;
                }
                min=Math.min(min,i+length-next+Math.min(i,length-next));
            }

            return answer+min;
        }
    }

    public static class Solution {

        public int solution(String name) {

            char[] c = name.toCharArray();
            boolean[] b = new boolean[c.length];

            for(int i = 0; i < c.length; i++) {
                if (c[i] == 'A') b[i] = true;
            }

            int ret = 0;
            int i = 0;
            while(true){
                if(c[i] < 'N') ret += c[i] - 'A';
                else ret += 26 - (c[i] - 'A');

                b[i] = true;
                int j = 0;
                for(; j < b.length; j++)
                    if(!b[j]) break;

                if(j == c.length) break;

                int l = 1;
                int r = 1;
                int lidx = i-1;
                if(lidx == -1) lidx = c.length-1;
                int ridx = i+1;
                if(ridx == c.length) ridx = 0;

                while(b[lidx]){
                    l++;
                    lidx--;
                    if(lidx == -1) lidx = c.length-1;
                }

                while(b[ridx]){
                    r++;
                    ridx++;
                    if(ridx == c.length) ridx = 0;
                }

                if(l < r){
                    ret += l;
                    i = lidx;
                }else{
                    ret += r;
                    i = ridx;
                }
            }

            return ret;
        }
    }

    public static class Solution2 {
        public int solution(String name) {
            StringBuilder word = new StringBuilder();
            for(int i=0; i<name.length(); i++){
                word.append("A");
            }
            int answer = 0;
            int idx = 0;
            while(!word.toString().equals(name)){
                int right = getCost(name, word, idx, 1);
                int left = getCost(name, word, idx, -1);
                if(right <= left){
                    answer += right;
                    String word_tmp = word.toString();
                    idx = action(name, word, idx, 1);
                    answer += getDiff(name, word_tmp, idx);
                    System.out.println(right + " " +word.toString());
                }
                else {
                    answer += left;
                    String word_tmp = word.toString();
                    idx = action(name, word, idx, -1);
                    answer += getDiff(name, word_tmp, idx);
                    System.out.println(left + " " +word.toString());
                }
            }
            return answer;
        }
        public int action(String name, StringBuilder word, int index, int direction){
            if(index < 0){
                index += name.length();
            }
            if(index >= name.length()){
                index %= name.length();
            }
            if(name.charAt(index) == word.charAt(index)){
                return action(name, word, index + direction, direction);
            }
            else{
                word.setCharAt(index, name.charAt(index));
                return index;
            }
        }

        public int getCost(String name, StringBuilder word, int index, int direction){
            if(index < 0){
                index += name.length();
            }
            if(index >= name.length()){
                index %= name.length();
            }

            if(name.charAt(index) == word.charAt(index)){
                return 1 + getCost(name, word, index + direction, direction);
            }
            else{
                return 0;
            }
        }

        public int getDiff(String name, String word, int index) {
            int diff = Math.abs((word.charAt(index) - name.charAt(index)));
            return Math.min(26 - diff, diff);
        }

    }

    public static class Solution3 {
        public int solution(String name) {

            int answer = 0;
            int[] charMove = new int[name.length()];
            for (int i = 0; i < charMove.length; i++) {
                int c = name.charAt(i);
                if(c > 'M')
                    charMove[i] = 'Z' - c + 1;
                else
                    charMove[i] = c - 'A';
            }
            answer += charMove[0];
            int right=0;
            int left=0;
            for (int i = charMove.length-1; i >=1 ; i--) {
                if(charMove[i] != 0) {
                    for (int j = i; j >= 1; j--)
                        right += charMove[j] +1;
                    break;
                }
            }
            for (int i = 1; i <= charMove.length-1; i++) {
                if(charMove[i] != 0) {
                    for (int j = i; j <= charMove.length-1; j++)
                        left += charMove[j] +1;
                    break;
                }
            }
            if(Math.min(right, left) != 0)
                answer += Math.min(right, left);
            return answer;
        }
    }

    public static class Solution4 {
        public int solution(String name) {
            int answer = 0;
            for(int i = 0; i < name.length(); i++) {
                int current = name.charAt(i) - 'A';
                if(current > 12) {
                    answer += current - (2 * (current % 13));
                }else {
                    answer += current;
                }
            }

            int base = name.length() - 1;
            int mio = 0;
            for(int i = 1; i < name.length(); i++) {
                int initiate = -1;
                int fine = -1;
                if(name.charAt(i) == 'A') {
                    initiate = i;
                    for(int j = i + 1; j < name.length(); j++) {
                        i++;
                        if(name.charAt(j) != 'A') {
                            fine = j - 1;
                            break;
                        }
                    }
                    if(fine == -1) {
                        fine = name.length() - 1;
                    }
                    int curr_risparmio = (fine + 1 - initiate) - Math.min(initiate - 1, name.length() - (fine + 1));
                    if(curr_risparmio > mio) {
                        mio = curr_risparmio;
                    }
                }
            }
            answer += base - mio;
            return answer;
        }
    }

    public static class Solution5 {
        public int solution(String name) {
            int [] move = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                    12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
            int n = name.length();
            int [] count = new int[n];
            int sum = 0;

            for (int i = 0; i < n; i++) {
                count[i] = move[name.charAt(i) - 'A'];
                sum += count[i];
            }
            int answer = Integer.MAX_VALUE;

            int pcount;
            int psum;
            for (int i = 0; i < n/2; i++) {
                pcount = 0;
                psum = sum;
                int[] erase = count.clone();
                int j = 0;
                pcount += (i - j);
                for (; j <= i; j++) {   //-> move to right until arrive at i.
                    pcount += erase[j];
                    psum -= erase[j];
                    erase[j] = 0;
                    if (psum == 0) break;
                }
                j--;

                while(psum > 0) {   // move to left until psum is zero.
                    j--;
                    pcount++;
                    if (j < 0) j = n - 1;
                    pcount += erase[j];
                    psum -= erase[j];
                    erase[j] = 0;
                    if (psum == 0) break;
                }
                if (answer > pcount) answer = pcount;
            }

            psum = sum;
            pcount = 0;
            int[] erase = count.clone();
            psum -= erase[0];
            pcount += erase[0];

            for (int i = n; i >= (n/2 + 1); i--) {
                int j = 0;
                if (i < n) { // move to left until arrive at i.
                    for (j = n - 1; j >= i; j--) {
                        pcount++;
                        pcount += erase[j];
                        psum -= erase[j];
                        erase[j] = 0;
                        if (psum == 0) break;
                    }
                    j++;
                }

                //--> move to right
                while(psum > 0) {
                    j++;
                    if (j == n) j = 0;

                    pcount++;
                    pcount += erase[j];
                    psum -= erase[j];
                    erase[j] = 0;
                    if (psum == 0) break;
                }
                if (answer > pcount) answer = pcount;
            }

            return answer;
        }
    }


    public static class Solution6 {
        public int solution(String name) {
            int answer = 0;
            int m = name.length();

            //커서 조작 횟수 앞으로 갔을 경우 조작 횟수로 초기화
            int cursorMove = m - 1;
            int front = 0, middle = 0, back = 0;

            for(int i = 0; i < m; i++){
                char word = name.charAt(i);
                if(word == 65){
                    if(back != 0){
                        front += back;
                        back = 0;
                    }
                    middle += 1;
                }else{
                    if(middle != 0){
                        back += 1;
                    }else if(middle == 0){
                        front += 1;
                    }
                }
            }

            //1보다 클 경우 front + front - 2를 하면 되돌아가는 횟수
            front = front > 1 ?  front + front - 2 : 0;

            if(front + back < cursorMove) cursorMove = front + back;

            answer += cursorMove;

            //알파벳 조작 횟수
            for(int i = 0; i < m; i++){
                char word = name.charAt(i);
                if(word == 65) continue;

                int position = word - 65;

                if(word > 78){ //79번부터는 거꾸로 가는게 빠름
                    answer += 26 - position;
                }else{
                    answer += position;
                }
            }

            return answer;
        }
    }

    public static class Solution7 {
        public int solution(String name) {
            int answer = 0;

            for(int i = 0; i < name.length(); i++) {
                int distance = name.charAt(i) - 'A';
                if (distance <= 13) answer+= distance;
                else answer += 26-distance;
            }

            int rightMove = name.length() - 1;

            int aEndIndex = 0;
            for(int i = 1; i < name.length(); i++) {
                aEndIndex++;
                if (name.charAt(i) != 'A') break;
            }

            int leftMove = name.length() - aEndIndex;

            answer += (rightMove < leftMove)? rightMove: leftMove;

            return answer;
        }
    }






}
