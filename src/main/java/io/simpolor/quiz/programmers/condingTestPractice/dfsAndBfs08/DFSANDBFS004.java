package io.simpolor.quiz.programmers.condingTestPractice.dfsAndBfs08;

import java.util.*;

/***
 * 여행경로
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 ICN 공항에서 출발합니다.
 *
 * 항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때,
 * 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 모든 공항은 알파벳 대문자 3글자로 이루어집니다.
 * 주어진 공항 수는 3개 이상 10,000개 이하입니다.
 *
 * tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
 * 주어진 항공권은 모두 사용해야 합니다.
 * 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
 * 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * tickets	return
 * [[ICN, JFK], [HND, IAD], [JFK, HND]]	[ICN, JFK, HND, IAD]
 * [[ICN, SFO], [ICN, ATL], [SFO, ATL], [ATL, ICN], [ATL,SFO]]	[ICN, ATL, ICN, SFO, ATL, SFO]
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 예제 #1
 *
 * [ICN, JFK, HND, IAD] 순으로 방문할 수 있습니다.
 *
 * 예제 #2
 *
 * [ICN, SFO, ATL, ICN, ATL, SFO] 순으로 방문할 수도 있지만 [ICN, ATL, ICN, SFO, ATL, SFO] 가 알파벳 순으로 앞섭니다.
 *
 */
public class DFSANDBFS004 {

    public static void main(String[] args) {

        String[][] tickets = new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"},	{"ICN", "JFK", "HND", "IAD"}};

        Solution solution = new Solution();
        String[]  result = solution.solution(tickets);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {
        List<Stack<String>> result;
        String[][] tickets;

        public String[] solution(String[][] tickets) {
            result = new ArrayList<>();
            this.tickets = tickets;

            boolean[] visited = new boolean[tickets.length];
            Stack<String> st = new Stack<>();
            st.push("ICN");

            dfs(visited, st, 0);

            if (result.size() > 1) {
                Collections.sort(result, new Comparator<Stack<String>>() {
                    @Override
                    public int compare(Stack<String> o1, Stack<String> o2) {
                        for (int i = 0; i < o1.size(); i++) {
                            String s1 = o1.get(i);
                            String s2 = o2.get(i);

                            if (!s1.equals(s2)) {
                                return s1.compareTo(s2);
                            }
                        }

                        return 0;
                    }
                });
            }

            Stack<String> res = result.remove(0);
            String[] answer = new String[res.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = res.get(i);
            }

            return answer;
        }

        public void dfs(boolean[] visited, Stack<String> st, int len) {
            if (len == tickets.length) {
                Stack<String> res = new Stack<>();
                for (String s : st) {
                    res.push(s);
                }

                result.add(res);
                return;
            }

            String arrive = st.peek();

            for (int i = 0; i < tickets.length; i++) {
                String[] tic = tickets[i];

                if (!visited[i] && arrive.equals(tic[0])) {
                    st.push(tic[1]);
                    visited[i] = true;

                    dfs(visited, st, len + 1);

                    visited[i] = false;
                    st.pop();
                }
            }
        }
    }

    public static class Solution1 {
        public String[] solution(String[][] tickets) {
            List<String[]> list = new ArrayList<>(Arrays.asList(tickets));

            Stack<String> st = new Stack<>();
            st.push("ICN");

            Stack<String> result = dfs(list, st);

            String[] answer = result.stream().toArray(String[]::new);
            return answer;
        }

        public Stack<String> dfs(List<String[]> list, Stack<String> st) {
            if (list.isEmpty()) {
                Stack<String> result = new Stack<>();
                for (String s : st) {
                    result.push(s);
                }

                return result;
            }

            List<Stack<String>> resultList = new ArrayList<>();
            String arrive = st.peek();

            for (int i = 0; i < list.size(); i++) {
                String[] tic = list.get(i);
                if (!arrive.equals(tic[0])) {
                    continue;
                }

                st.push(tic[1]);
                list.remove(tic);

                Stack<String> next = dfs(list, st);

                st.pop();
                list.add(i, tic);

                if (!next.isEmpty()) {
                    resultList.add(next);
                }
            }

            Stack<String> max = new Stack<>();

            for (Stack<String> res : resultList) {
                if (max.isEmpty()) {
                    max = res;
                    continue;
                }

                for (int i = 0; i < res.size(); i++) {
                    String s1 = res.get(i);
                    String s2 = max.get(i);
                    int compare = s1.compareTo(s2);

                    if (compare == 0) {
                        continue;
                    }

                    if (compare < 0) {
                        max = res;
                    }

                    break;
                }
            }

            return max;
        }
    }

    public static class Solution2 {
        boolean completed;
        public String[] solution(String[][] tickets) {
            String[] answer = new String[tickets.length + 1];
            Map<String, Integer> ticket = new HashMap<>();
            Map<String, List<String>> map = new HashMap<>();
            Stack<String> stack = new Stack<>();
            for(int i = 0; i < tickets.length; i++) {
                if(ticket.containsKey(tickets[i][0] + tickets[i][1])) {
                    ticket.replace(tickets[i][0] + tickets[i][1], ticket.get(tickets[i][0] + tickets[i][1]) + 1);
                }else {
                    ticket.put(tickets[i][0] + tickets[i][1], 1);
                }
            }
            for(int i = 0; i < tickets.length; i++) {
                if(map.containsKey(tickets[i][0])) {
                    map.get(tickets[i][0]).add(tickets[i][1]);
                }else {
                    map.put(tickets[i][0], new ArrayList<>());
                    map.get(tickets[i][0]).add(tickets[i][1]);
                }
            }
            for(String s : map.keySet()) {
                map.get(s).sort((a,b) -> a.compareTo(b));
            }
            stack.add("ICN");
            dfs(map, ticket, stack, "ICN", answer);
            return answer;
        }
        void dfs(Map<String, List<String>> map, Map<String, Integer> ticket, Stack<String> stack, String from, String[] answer) {
            if(completed) {
                return;
            }
            boolean chk = false;
            for(String key : ticket.keySet()) {
                if(ticket.get(key) != 0) {
                    chk = true;
                    break;
                }
            }
            if(!chk) {
                stack.toArray(answer);
                completed = true;
                return;
            }
            if(map.containsKey(from)) {
                for(String to : map.get(from)) {
                    if(ticket.containsKey(from + to) && ticket.get(from + to) > 0) {
                        ticket.replace(from + to, ticket.get(from + to) - 1);
                        stack.push(to);
                        dfs(map, ticket, stack, to, answer);
                        stack.pop();
                        ticket.replace(from + to, ticket.get(from + to) + 1);
                    }
                }
            }
        }
    }

    public static class Solution3 {
        public class Answer implements Comparable<Answer> {
            String[] cities;

            public Answer(String[] cities) {
                this.cities = cities;
            }

            @Override
            public int compareTo(Answer o) {
                int n = cities.length;
                int compare;
                for (int i = 0; i < n; i++) {
                    if ((compare = cities[i].compareTo(o.cities[i])) < 0) {
                        return -1;
                    }
                    else if (compare > 0) {
                        return +1;
                    }
                }
                return 0;
            }
        }

        public class City {
            String name;
            LinkedList<Integer> flights;
            boolean flightsUsed[];

            public City(String name) {
                this.name = name;
                flights = new LinkedList<>();
            }

            public void ready() {
                flightsUsed = new boolean[flights.size()];
            }
        }


        public String[] solution(String[][] tickets) {
            HashMap<String, Integer> map = new HashMap<>();
            int n = tickets.length;
            int i;
            for (i = 0; i < n; i++) {
                map.put(tickets[i][0], map.getOrDefault(tickets[i][0], map.size()));
                map.put(tickets[i][1], map.getOrDefault(tickets[i][1], map.size()));
            }

            int nCities = map.size();
            City cities[] = new City[nCities];
            Iterator<String> iterator = map.keySet().iterator();
            String s;
            int number;
            while(iterator.hasNext()) {
                s = iterator.next();
                number = map.get(s);
                cities[number] = new City(s);
            }

            for (i = 0; i < n; i++) {
                cities[map.get(tickets[i][0])].flights.addLast(map.get(tickets[i][1]));
            }

            for (i = 0; i < nCities; i++) {
                cities[i].ready();
            }

            int[] route = new int[n + 1];
            LinkedList<Answer> answerSheet = new LinkedList<>();

            route[0] = map.get("ICN");
            find(1, 0, n, route, answerSheet, cities);
            Collections.sort(answerSheet);

            return answerSheet.get(0).cities;
        }
        public void find(int k, int ticketUsed, int totalTickets,
                         int[] route, LinkedList<Answer> answerSheet, City[] cities) {
            Iterator<Integer> iterator;
            City city;
            int i, nextCity;

            if (ticketUsed == totalTickets) {
                String cityNames[] = new String[ticketUsed + 1];
                for (i = 0; i < ticketUsed + 1; i++) {
                    cityNames[i] = cities[route[i]].name;
                    answerSheet.addLast(new Answer(cityNames));
                }
            }
            else {
                city = cities[route[k - 1]];
                iterator = city.flights.listIterator();
                i = -1;
                while(iterator.hasNext()) {
                    nextCity = iterator.next();
                    i++;

                    if (!city.flightsUsed[i]) {
                        route[k] = nextCity;
                        city.flightsUsed[i] = true;

                        find(k + 1, ticketUsed + 1, totalTickets, route, answerSheet, cities);

                        city.flightsUsed[i] = false;
                    }
                }
            }
        }
    }

    public static class Solution4 {
        static int n=0;
        HashMap<String,Integer> map = new HashMap<>();
        String[][] tickets;

        int[] c;
        String[] answer = {};
        public String[] solution(String[][] tickets) {
            this.tickets=tickets;

            n=tickets.length;
            c=new int[n];

            Arrays.sort(tickets,(o1, o2) -> {
                if(o1[0].equals(o2[0])){
                    return o1[1].compareTo(o2[1]);
                }
                else{
                    return o1[0].compareTo(o2[0]);
                }
            });



            arr.add("ICN");
            DFS("ICN",0);

            return answer;
        }
        ArrayList<String> arr = new ArrayList<>();

        public void DFS(String cur, int level){

            if(answer.length>0) return;
            if(level==n){
                answer = new String[arr.size()];

                for(int i=0; i<arr.size(); i++)
                    answer[i]=arr.get(i);
                return;
            }
            for(int i=0; i<tickets.length; i++){
                if(tickets[i][0].equals(cur) && c[i]==0){
                    arr.add(tickets[i][1]);
                    c[i]=1;
                    DFS(tickets[i][1],level+1);
                    c[i]=0;
                    arr.remove(arr.lastIndexOf(tickets[i][1]));
                }
            }

        }
    }

    public static class Solution5 {
        public static ArrayList<String> arr;
        public static void dfs(String a, String[][] t, String r, int i, int n, boolean[] v) {
            a = a+r+" ";

            if(i==n) {
                arr.add(a);
            }


            for(int j=0;j<t.length;j++) {
                if(!v[j] && t[j][0].compareTo(r) == 0) {
                    v[j] = true;
                    dfs(a, t, t[j][1], i+1, n, v);
                    v[j] = false;
                }
            }
        }
        public String[] solution(String[][] tickets) {
            boolean[] visit = new boolean[tickets.length];
            arr = new ArrayList<>();
            dfs("", tickets, "ICN", 0, tickets.length, visit);
            Collections.sort(arr);
            String[] answer = arr.get(0).split(" ");
            return answer;
        }
    }






}