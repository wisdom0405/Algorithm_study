import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 로프개수
        int[] ropes = new int[N];

        // 로프 정보 저장
        for(int i=0; i<N; i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        int max = 0;
        for(int i=0; i<N; i++){
            int weight = ropes[i] * (N-i); // i번째 로프부터 N개 사용
            max = Math.max(max, weight);
        }

        System.out.println(max);
    }
}
