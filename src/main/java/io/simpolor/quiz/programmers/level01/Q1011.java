package io.simpolor.quiz.programmers.level01;

import java.util.*;

public class Q1011 {

    /***
     * 문자열 내 마음대로 정렬하기
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
     * 예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * strings는 길이 1 이상, 50이하인 배열입니다.
     * strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
     * strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
     * 모든 strings의 원소의 길이는 n보다 큽니다.
     * 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * strings	n	return
     * [sun, bed, car]	1	[car, bed, sun]
     * [abce, abcd, cdx]	2	[abcd, abce, cdx]
     *
     * ------------------------------
     * 입출력 예 설명
     * ------------------------------
     * 입출력 예 1
     * sun, bed, car의 1번째 인덱스 값은 각각 u, e, a 입니다. 이를 기준으로 strings를 정렬하면 [car, bed, sun] 입니다.
     *
     * 입출력 예 2
     * abce와 abcd, cdx의 2번째 인덱스 값은 c, c, x입니다. 따라서 정렬 후에는 cdx가 가장 뒤에 위치합니다.
     * abce와 abcd는 사전순으로 정렬하면 abcd가 우선하므로, 답은 [abcd, abce, cdx] 입니다.
     *
     */
    public static void main(String[] args){

        /*String[] strings = new String[]{"sun", "bed", "car"};
        int n = 1;*/
        String[] strings = new String[]{"abce", "abcd", "cdx"};
        int n = 2;

        Solution solution = new Solution();
        String[] result = solution.solution(strings, n);

        System.out.println(Arrays.toString(result));
    }


    public static class Solution {
        public String[] solution(String[] strings, int n) {

            List<String> list = new ArrayList<>();
            for(String s : strings){
                list.add(s.charAt(n) + s);
            }

            Collections.sort(list);

            String[] answer = new String[strings.length];
            for(int i=0; i<list.size(); i++){
                answer[i] = list.get(i).substring(1);
            }

            return answer;
        }
    }

    public static class Solution1 {
        public String[] solution(String[] strings, int n) {

            Arrays.sort(strings, new Comparator<String>(){
                @Override
                public int compare(String s1, String s2){
                    if(s1.charAt(n) > s2.charAt(n)) return 1;
                    else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                    else if(s1.charAt(n) < s2.charAt(n)) return -1;
                    else return 0;
                }
            });
            return strings;
        }
    }

    public static class Solution2 {
        public String[] solution(String[] strings, int n) {
            return Arrays.stream(strings).map(string -> new IndexString(string, n)).sorted()
                    .map(indexString -> indexString.string).toArray(String[]::new);
        }

        class IndexString implements Comparable<IndexString> {

            String string;
            char index;

            IndexString(String string, int index) {
                this.string = string;
                this.index = string.charAt(index);
            }

            public int compareTo(IndexString indexString) {
                System.out.println(index+"," + indexString.index);
                if (index == indexString.index) {
                    return string.compareTo(indexString.string);
                } else {
                    return index - indexString.index;
                }
            }
        }
    }

    public static class Solution3 {
        public String[] solution(String[] strings, int n) {
            int l = strings.length;
            for(int i=0;i<l;i+=1){
                strings[i] = strings[i].substring(n,n+1)+strings[i];
            }
            Arrays.sort(strings);
            for(int i=0;i<l;i+=1){
                strings[i] = strings[i].substring(1);
            }
            return strings;
        }
    }

    public static class Solution4 {
        public String[] solution(String[] strings, int n) {

            for(int i=0; i<strings.length-1; i++){
                for(int k=i+1; k<strings.length;k++){
                    if(strings[i].charAt(n)>strings[k].charAt(n)){
                        String tmp = strings[i];
                        strings[i]= strings[k];
                        strings[k]=tmp;
                    }
                    else if(strings[i].charAt(n)==strings[k].charAt(n)){
                        if(strings[i].compareTo(strings[k]) >0){
                            String tmp = strings[i];
                            strings[i]= strings[k];
                            strings[k]=tmp;
                        }
                    }
                }
            }
            return strings;
        }
    }

}
