import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long mod = 10007;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] D = new long[N+1];
        
        if (N == 1) { // N이 1일 때는 바로 출력
            System.out.println(1);
            return;
        }

        // 이미 아는 답 넣기
        D[1] = 1;
        D[2] = 2;
        for(int i=3; i<N+1; i++){
            D[i] = (D[i-1] + D[i-2]) % mod;
        }

        System.out.println(D[N]);
    }
}
