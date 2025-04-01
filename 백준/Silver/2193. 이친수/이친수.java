import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N 자리수 이친수 구할 것

        // 이친수 조건
        // 1. 이친수는 0으로 시작하지 않는다.
        // 2. 이친수는 1이 두 번 연속으로 나타나지 않는다.

        // N 자리 수 중 0으로 끝나는 이친수 개수, 1로 끝나는 이친수 개수 저장
        long[][] D = new long[N+1][2];

        // 알고 있는 숫자는 미리 저장한다.
        // 이친수는 1로 시작해야 한다.
        D[1][0] = 0;
        D[1][1] = 1;

        for (int i=2; i<=N; i++){
            // 0은 모두 붙일 수 있다.
            D[i][0] = D[i-1][0] + D[i-1][1];

            // 1은 0으로 끝난 수에만 붙일 수 있다.
            D[i][1] = D[i-1][0];
        }

        System.out.println(D[N][0] + D[N][1]);
    }
}
