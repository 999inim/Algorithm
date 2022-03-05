import java.util.Arrays;
import java.util.Comparator;

// https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numStrings = new String[numbers.length];
        int i=0;
        
        for(int n : numbers) {
            numStrings[i++] = String.valueOf(n);
        }
        
        Arrays.sort(numStrings, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        
        for (String s : numStrings) {
            answer += s;
        }
        
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}
