import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int sol = 0;
        int[] result = new int[3]; //학생 채점지
        
        String s1 = "12345";
        String s2 = "21232425";
        String s3 = "3311224455";
        
        // 1. 각 학생들의 맞춘 문제 수 구하기
        for(int i =0; i < answers.length; i++) {
            sol = answers[i];
            if (sol == s1.charAt(i%5)-48) result[0]++;
            if (sol == s2.charAt(i%8)-48) result[1]++;
            if (sol == s3.charAt(i%10)-48) result[2]++;
        }
        
        // 2. 세 학생의 점수를 비교하여 최대값 구하기
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int maxVal = result[0];
        
        for(int i = 1; i < 3; i++) {
            
            // 더 큰 값일때와 같을때 분기
            if (result[i] > maxVal) {
                list.clear();
                
                maxVal = result[i];
                list.add(i+1);
            } else if (result[i] == maxVal) {
                list.add(i+1);
            }
        }
        
        answer = new int[list.size()];
        int idx =0;
        for(int n : list) {
            answer[idx++]=n;
        }
        
        return answer;
    }
}
