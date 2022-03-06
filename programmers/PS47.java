class Solution {
    // https://programmers.co.kr/learn/courses/30/lessons/43162
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] checked = new boolean[n];        
        
        // 1. 각 컴퓨터별로 dfs로 탐색
        for(int i =0; i<n; i++) {      
            if(checked[i] == false){ // 체크 안된 컴퓨터(다른 그래프)
                answer++;
                dfs(i, computers, checked);
            } else { // 이미 체크된 컴퓨터(현재 그래프에 포함)
                continue;
            }
          
        }
        
        return answer;
    }
    
    // 2. 같은 네트워크(그래프)에 포함된 컴퓨터 모두 체크
    public static void dfs(int current, int[][] computers, boolean[] checked) {
        checked[current] = true;
        
        for(int col=0; col<checked.length; col++) {
            if(computers[current][col]==1 && !checked[col]) {
                dfs(col, computers, checked);
            }            
        }       
    }
}
