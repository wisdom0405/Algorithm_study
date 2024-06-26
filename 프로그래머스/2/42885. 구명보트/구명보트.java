import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people); // 몸무게순 오름차순 정렬
        int min = 0; // 몸무게가 최소인 사람의 index는 0

        for(int i = people.length-1; i >=0; i--){
            if(i < min) break;
            if(people[i] + people[min] <= limit){
                answer++;
                min++;
            }else answer++;
        }

        return answer;
    }
}