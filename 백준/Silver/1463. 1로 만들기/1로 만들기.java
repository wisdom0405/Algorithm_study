import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[]D = new int[N+1]; // 1부터 시작

        // 아는 수는 먼저 채워줌 : 1을 1로 만드는 연산개수는 0
        D[1] = 0;

        for(int i=2; i<N+1; i++){
            D[i] = D[i-1] + 1; // 1을 빼는 방법
            if (i%2 == 0){ // 2로 나누는 방법
                D[i] = Math.min(D[i], D[i/2] + 1);
            }
            if (i%3 == 0){ // 3으로 나누는 방법
                D[i] = Math.min(D[i], D[i/3] + 1);
            }
        }

        System.out.println(D[N]);
    }
}
