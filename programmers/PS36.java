// https://programmers.co.kr/learn/courses/30/lessons/43165
class Solution {
    static int answer = 0;
    
    static int numlen;
    static int tnum;
    static int[] cNumbers;
    
    public int solution(int[] numbers, int target) {
        // static 메서드에서 값 접근 및 캐시할 수 있도록 변수초기화
        cNumbers = numbers;
        tnum = target;
        numlen = numbers.length;
        
				// 1. 진입점
        dfs(0, numbers[0]);
        dfs(0, -numbers[0]);
   
        return answer;
    }
    
    public static void dfs(int idx, int result) {
        
        if(idx == numlen-1) { // 3. 최종 depth에서 조건체크
            if (result == tnum) answer +=1;
        } else { // 2. 다음 depth 조건에 따른 재귀호출
            dfs(idx+1, result+cNumbers[idx+1]);
            dfs(idx+1, result-cNumbers[idx+1]);
        }        
    }
}
