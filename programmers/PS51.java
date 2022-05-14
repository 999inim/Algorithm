import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i : scoville) {
            queue.offer(i); 
        }
        
        while(queue.peek() < K) {
            if(queue.size() == 1) {
                answer = -1;
                break;
            }
            
            int cur = queue.poll();
            int next = queue.poll(); 
                       
            answer += 1;
            queue.offer(cur + next*2);           
        }
        
        return answer;
    }
}
