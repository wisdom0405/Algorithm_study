import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] D = new int[N+1][N+1];

        // 이항계수 배열 최기화
        for(int i=1; i<N+1; i++){
            D[i][1] = i; // i개 중 1개 뽑는 경우의 수 : i개
            D[i][0] = 1; // i개 중 아무것도 뽑지 않는 경우의 수 : 1개
            D[i][i] = 1; // i개 중 i개 뽑는 경우의 수 : 1개
        }

        for(int i=2; i<N+1; i++){
            for (int j=1; j<i; j++){
                D[i][j] = D[i-1][j] + D[i-1][j-1];
                D[i][j] = D[i][j] % 10007;
            }
        }

        System.out.println(D[N][K]);
    }
}
