import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int a :arr){
            if(stack.isEmpty()){
                stack.push(a);
            }else{
                if(stack.peek() != a){
                    stack.push(a); // 최상단의 값이 a와 다르면 push
                }
            }
        }
         int[] answer = new int[stack.size()];
            for(int i = answer.length;i > 0;i--){
                answer[i-1] = stack.pop();
            }
        return answer;
    }
}