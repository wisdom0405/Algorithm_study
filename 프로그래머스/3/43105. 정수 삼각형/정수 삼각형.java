import java.util.Arrays;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][];
        
        // 최대값 저장 dp테이블
        for (int i = 0; i < triangle.length; i++) {
                dp[i] = new int[triangle[i].length];
        }

        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[1][0] + triangle[0][0];
        dp[1][1] = triangle[1][1] + triangle[0][0];

        // 삼각형 왼쪽 변
        for(int i = 2; i < triangle.length; i++) {
            dp[i][0] = triangle[i][0] + dp[i-1][0];

            answer = Math.max(answer, dp[i][0]);
        }

        // 삼각형 오른쪽 변
        for(int i = 2; i < triangle.length; i++) {
            dp[i][triangle[i].length - 1] = triangle[i][triangle[i].length - 1] + dp[i-1][triangle[i].length - 2];
            answer = Math.max(answer, dp[i][triangle[i].length - 1]);
        }

        // 그 외 영역들 dp 테이블 채우기
        for(int i = 2; i < triangle.length; i++) {
            for(int j = 1; j < triangle[i].length-1; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer;
    }
}