class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 0;
        int end = 0;
        int sum = start+end;
        while (end <= n){
                if(sum < n){ // 아직 합계가 n보다 작다면
                    end++; //end값 늘리고 sum에 합함
                    sum += end;
                }else if (sum > n){ // 합계가 n보다 커지면
                    start++; // start 증가
                    sum -= start; // 기존 start값 빼주고
                }else{ // sum == n인 경우
                    answer++;
                    start++;
                    sum -= start;
                }
            }
        return answer;
    }
}