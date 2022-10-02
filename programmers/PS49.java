import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42587
class Solution {
    class Task {
        int priority;
        int originLoc;
        
        Task(int priority, int originLoc) {
            this.priority = priority;
            this.originLoc = originLoc;
        }    
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int pCounter = 0;
        boolean upperExist = false;
        Queue<Task> queue = new LinkedList<Task>();
         
        // 문서(우선순위,원래위치) -> 현재순서대로 Queue에 삽입
        for (int i = 0; i< priorities.length; i++) {
            queue.add(new Task(priorities[i], i));
        }
    
        
        while(!queue.isEmpty()) {
            Task cur = queue.poll();
            
            for(Task e : queue) {
                if (e.priority > cur.priority) {
                    queue.add(cur);
                    upperExist = true;
                    break;
                }
            }
            
            if(!upperExist) {
                if(cur.originLoc == location) {
                    answer = ++pCounter;
                    break;
                } else {
                    pCounter++;   
                }
                
            }
            upperExist = false;
        }
        
        return answer;
    }
}
