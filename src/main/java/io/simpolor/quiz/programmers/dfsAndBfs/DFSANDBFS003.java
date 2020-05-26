package io.simpolor.quiz.programmers.dfsAndBfs;

import java.util.*;

/***
 * 단어 변환
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
 *
 * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
 * 2. words에 있는 단어로만 변환할 수 있습니다.
 * 예를 들어 begin이 hit, target가 cog, words가 [hot,dot,dog,lot,log,cog]라면 hit -> hot -> dot -> dog -> cog와 같이 4단계를 거쳐 변환할 수 있습니다.
 *
 * 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 각 단어는 알파벳 소문자로만 이루어져 있습니다.
 * 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
 * words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
 * begin과 target은 같지 않습니다.
 * 변환할 수 없는 경우에는 0를 return 합니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * begin	target	words	return
 * hit	cog	[hot, dot, dog, lot, log, cog]	4
 * hit	cog	[hot, dot, dog, lot, log]	0
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 예제 #1
 * 문제에 나온 예와 같습니다.
 *
 * 예제 #2
 * target인 cog는 words 안에 없기 때문에 변환할 수 없습니다.
 *
 */
public class DFSANDBFS003 {

    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};

        Solution solution = new Solution();
        int result = solution.solution(begin, target, words);

        System.out.println(result);
    }

    public static class Solution {

        static class Node {
            String next;
            int edge;

            public Node(String next, int edge) {
                this.next = next;
                this.edge = edge;
            }
        }

        public int solution(String begin, String target, String[] words) {
            int n = words.length, ans = 0;

            // for (int i=0; i<n; i++)
            //  if (words[i] != target && i == n-1) return 0;

            Queue<Node> q = new LinkedList<>();


            boolean[] visit = new boolean[n];
            q.add(new Node(begin, 0));

            while(!q.isEmpty()) {
                Node cur = q.poll();
                if (cur.next.equals(target)) {
                    ans = cur.edge;
                    break;
                }

                for (int i=0; i<n; i++) {
                    if (!visit[i] && isNext(cur.next, words[i])) {
                        visit[i] = true;
                        q.add(new Node(words[i], cur.edge + 1));
                    }
                }
            }

            return ans;
        }

        static boolean isNext(String cur, String n) {
            int cnt = 0;
            for (int i=0; i<n.length(); i++) {
                if (cur.charAt(i) != n.charAt(i)) {
                    if (++ cnt > 1) return false;
                }
            }

            return true;
        }
    }

    public static class Solution1 {
        public int solution(String begin, String target, String[] words) {
            int n = words.length + 1;
            int distance[] = new int[n];
            boolean queued[] = new boolean[n];
            @SuppressWarnings("unchecked") LinkedList<Integer> edges[] = new LinkedList[n];

            for (int i = 0; i < n; i++) {
                edges[i] = new LinkedList<Integer>();
            }

            int targetIndex = checkConnectivity(edges, begin, target, words, n);
            if (targetIndex < 0) {
                return 0;
            }
            targetIndex++;

            LinkedList<Integer> queue = new LinkedList<>();
            queue.addLast(0);
            queued[0] = true;
            int from, to;
            Iterator<Integer> iterator;

            while(!queue.isEmpty()) {
                from = queue.poll();
                iterator = edges[from].listIterator();
                while(iterator.hasNext()) {
                    to = iterator.next();
                    if (!queued[to]) {
                        distance[to] = distance[from] + 1;
                        if (to == targetIndex) {
                            queue.clear();
                            break;
                        }
                        else {
                            queue.addLast(to);
                            queued[to] = true;
                        }
                    }
                }
            }

            return distance[targetIndex];
        }

        public int checkConnectivity(
                LinkedList<Integer> edges[], String begin, String target, String[] words, int n) {
            String s, t;
            int length;
            int diff;
            int targetNumber = -1;
            int i;

            for (i = 0; i < words.length; i++) {
                if (target.equals(words[i])) {
                    targetNumber = i;
                    break;
                }
            }
            if (i == words.length) {
                return -1;
            }

            for (i = 0; i < n - 1; i++) {
                if (i == 0) s = begin;
                else s = words[i - 1];
                for (int j = 0; j < n; j++) {
                    if (j == 0) t = begin;
                    else if (j == n - 1) t = target;
                    else t = words[j - 1];


                    length = s.length();
                    diff = 0;
                    for (int k = 0; k < length; k++) {
                        if (s.charAt(k) != t.charAt(k)) {
                            diff++;
                            if (diff > 1) {
                                break;
                            }
                        }
                    }
                    if (diff == 1) {
                        edges[i].addLast(j);
                    }
                }
            }

            return targetNumber;
        }
    }

    public static class Solution2 {
        public static int solution(String begin, String target, String[] words) {

            Queue<String> queue = new LinkedList<String>();
            queue.offer(begin);

            boolean has_target = false;
            for(int i=0; i<words.length; i++){
                if(words[i].equals(target)){
                    has_target = true;
                }
            }
            if(!has_target) return 0;


            int answer = 0;

            while(true) {
                int size = queue.size();
                for(int i=0; i<size; i++){
                    String str = queue.poll();
                    if(str.equals(target)) return answer;

                    for(int j=0; j<words.length; j++){
                        if(diff(str, words[j])==1){
                            queue.offer(words[j]);
                        }
                    }
                }
                answer += 1;

                if(answer > words.length) return 0;
            }

        }

        public static int diff(String str1, String str2){
            int count = 0;
            for(int i=0; i<str1.length(); i++){
                if(str1.charAt(i) != str2.charAt(i)) count++;
            }
            return count;
        }
    }

    public static class Solution3 {

        int min = 9999;

        public int solution(String begin, String target, String[] words) {

            boolean match = false;
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(target)) {
                    match = true;
                }
            }

            if(!match) {
                return 0;
            }

            dfs(begin, target, words, 0);

            int answer = min;
            return answer;
        }

        public void dfs(String begin, String target, String[] words, int n) {
            if(begin.equals(target)) {

                if(min > n) {
                    min = n;
                }

                return ;
            }

            String[] tmp = new String[words.length - 1];
            int r = 100;

            for(int i = 0; i < words.length; i++) {
                int count = 0;
                for(int j = 0; j < begin.length(); j++) {
                    if(words[i].charAt(j) != begin.charAt(j)) {
                        count++;
                    }
                }

                if(count == 1) {
                    int idx = 0;
                    for(int j = 0; j < i; j++) {
                        tmp[idx] = new String(words[j]);
                        idx++;
                    }
                    for(int j = i+1; j < words.length; j++) {
                        tmp[idx] = new String(words[j]);
                        idx++;
                    }

                    dfs(words[i], target, tmp, n+1);
                }
            }
        }
    }


    public static class Solution4 {
        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            int len = words.length;
            int[] distance = new int[len];
            boolean[] check = new boolean[len];
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0; i<len; i++) {
                if(checkDiffOne(begin, words[i])){
                    distance[i]++;
                    queue.add(i);
                }
            }
            while(queue.size() > 0) {
                int cur = queue.poll();
                for(int i=0; i<len; i++) {
                    if(checkDiffOne(words[cur], words[i])) {
                        if(distance[i] != 0) {
                            if(distance[i] > distance[cur]+1) {
                                distance[i] = distance[cur]+1;
                                queue.add(i);
                            }
                        }else {
                            distance[i] = distance[cur]+1;
                            if(!words[i].equals(target))
                                queue.add(i);
                        }
                    }
                }
            }
            for(int i=0; i<len; i++) {
                if(words[i].equals(target))
                    return distance[i];
            }
            return 0;
        }
        private boolean checkDiffOne(String a, String b) {
            int cnt =0;
            for(int i=0; i<a.length(); i++){
                if(a.charAt(i) != b.charAt(i))
                    cnt++;
                if(cnt > 1)
                    return false;
            }
            return true;
        }
    }

    public static class Solution5 {
        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            int n = words.length;
            if(!containTarget(target, words)) {
                return answer;
            }
            Queue<String> q = new LinkedList<>();
            q.add(begin);
            boolean[] check = new boolean[n];
            while(!q.isEmpty()) {
                System.out.println(q.toString());
                String s = q.poll();
                if(compareWord(s, target) == 1) {
                    return answer+1;
                }
                for(int i = 0; i < n; i++) {
                    if(compareWord(s, words[i]) == 1 && !check[i]) {
                        answer++;
                        q.add(words[i]);
                        check[i] = true;
                        break;
                    }
                }
            }
            return answer;
        }

        public boolean containTarget(String target, String[] words) {
            for(int i = 0; i < words.length; i++) {
                if(target.equals(words[i])) {
                    return true;
                }
            }
            return false;
        }

        public int compareWord(String s1, String s2) {
            int cnt = s1.length();
            for(int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) == s2.charAt(i)) {
                    cnt--;
                }
            }
            return cnt;
        }
    }

    public static class Solution6 {
        private String target;
        private String[] words;
        private boolean[] visit;

        private int answer;

        public int solution(String begin, String target, String[] words) {
            this.target = target;
            this.words = new String[words.length];
            visit = new boolean[words.length];
            System.arraycopy(words, 0, this.words, 0, words.length);
            answer = 987654321;
            bfs(0, begin);

            return answer == 987654321 ? 0 : answer;
        }

        private void bfs(int cnt, String cur){

            if(cur.equals(target)){
                answer = Math.min(answer, cnt);
                return;
            }

            for(int i = 0 ; i < words.length ; i++){
                if(!visit[i] && compareWord(cur, words[i]) == 1){
                    visit[i] = true;
                    bfs(cnt + 1, words[i]);
                    visit[i] = false;
                }
            }

        }

        private int compareWord(String a, String b){
            int size = a.length();
            int diffCnt = 0;
            for(int i = 0 ; i < size ; i++){
                if(a.charAt(i) != b.charAt(i)){
                    diffCnt++;
                }
            }

            return diffCnt;
        }
    }


}