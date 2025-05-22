import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int mod = 10007;

        if (N==1){
            System.out.println(1);
            return;
        } else if (N==2) {
            System.out.println(3);
            return;
        }

        int[] DP = new int[N+1];
        // 아는 수 입력하기
        DP[1] = 1;
        DP[2] = 3;
        for (int i=3; i<N+1; i++){
            DP[i] = (DP[i-2] * 2 + DP[i-1]) % mod;
        }

        System.out.println(DP[N]);
    }
}
