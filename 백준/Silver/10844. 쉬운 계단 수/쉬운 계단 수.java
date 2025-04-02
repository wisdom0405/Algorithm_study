import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] D = new long[N+1][10]; // 길이 N 계단 수 중, n으로 끝나는 계단 수 개수
        long mod = 1000000000;

        // 이미 아는 수 입력
        D[1][0] = 0; // 길이 0이고, 0으로 끝나는 계단수는 없다.

        // 길이 1이고, i로 끝나는 계단수는 1개씩
        for(int i=1; i<=9; i++){
            D[1][i] = 1;
        }

        for(int i=2; i<=N; i++){
            D[i][0] = D[i-1][1] % mod;
            D[i][9] = D[i-1][8] % mod;
            for(int j=1; j<=8; j++){
                D[i][j] = (D[i-1][j-1] + D[i-1][j+1]) % mod;
            }
        }

        long sum = 0;
        for(int i=0; i<=9; i++){
            sum = (sum + D[N][i]) % mod ;
        }

        System.out.println(sum);
    }
}
