import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < N; i++) {
            dp[i] = 1; // 최소한 자기 자신 하나는 포함되므로 1로 초기화
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
