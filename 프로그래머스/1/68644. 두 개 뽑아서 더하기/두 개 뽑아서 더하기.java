import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (!answerList.contains(numbers[i]+numbers[j])) {
                    answerList.add(numbers[i] + numbers[j]);
                }
            }
        }
        Collections.sort(answerList);
        int[] answer = new int[answerList.size()];
        for (int j = 0; j < answerList.size(); j++) {
            answer[j] = answerList.get(j);
        }
        return answer;
    }
}