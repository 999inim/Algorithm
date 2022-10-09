import java.util.ArrayList;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/43164
class Solution {
    static boolean[] visited;
    static ArrayList<String> list = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(list);
        
        String[] temp = list.get(0).split(" ");
        
        return temp;
    }

    private static void dfs(int cnt, String icn, String word, String[][] tickets) {
        
        if (cnt == tickets.length) {
            list.add(word);

        } else {
            for (int i = 0; i < tickets.length; i++) {
                if (!visited[i] && tickets[i][0].equals(icn)) {
                    visited[i] = true;
                    
                    dfs(cnt + 1, tickets[i][1], word + " " + tickets[i][1], tickets);
                    visited[i] = false;
                }
            }
        }
    }
}
