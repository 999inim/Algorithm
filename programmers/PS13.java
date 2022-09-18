import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42583
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int totalTime = 0;
        int truckSum = 0;
        
        for (int i = 0; i < truck_weights.length; i++) {
            int curTruck = truck_weights[i];
            
            while(true) {
                if (queue.size() == bridge_length) { //다리 길이
                    truckSum -= queue.poll();
                } else if (curTruck + truckSum > weight) { //총 트럭무게
                    totalTime += 1;
                    queue.add(0);
                } else { //올라갈 수 있을때
                    totalTime += 1;
                    truckSum += curTruck;
                    queue.add(curTruck);
                    break;
                }
            }            
        }
        answer = totalTime + bridge_length;
        return answer;
    }
}
