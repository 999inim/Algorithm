import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/43163
class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) { 
        visited = new boolean[words.length];
        
        if(!Arrays.asList(words).contains(target)){ // words에 target이 없는 경우
            return 0;
        } else {
            dfs(begin, target, words, 0);
            return answer;
        }
    }
    
    public static void dfs(String current, String target, String[] words, int level) {
        // 탐색 종료조건
        if(isChangable(current, target)) {
            if (answer == 0 || level < answer){ 
                answer = level+1;
                return;
            }
        }
        
        // 다음 node 찾기 & 탐색
        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && isChangable(current, words[i])) { // 유망한지 여부
                visited[i] = true;
                dfs(words[i], target, words, level+1);
                // 부모 node로 back
                visited[i] = false;
            }   
        }
    }
    
    public static boolean isChangable(String current, String target) {
        boolean changable = false;
        int diffCount = 0;
        
        for(int i=0; i<current.length(); i++) {
            if(diffCount > 1) break;
            
            if (current.charAt(i) != target.charAt(i)) {
                diffCount++;
            }
        }
        
        if(diffCount == 1) {
            changable = true;
        }
        
        return changable;
    }
}
