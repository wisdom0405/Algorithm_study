import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
         PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int a : scoville){
            // scoville 배열에 있는 값 모두 pq에 저장
            pq.add(a);
        }

        while (pq.peek() < K){
            if(pq.size() >= 2) {
                int s1 = pq.poll(); // 가장 스코빌 지수가 낮은 것
                int s2 = pq.poll(); // 두번째로 스코빌 지수가 낮은 것
                int newScoville = s1 + s2 * 2;
                pq.add(newScoville);
                answer ++;
            }
            else{
                return -1;
            }
        }
        return answer;
    }
}