import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N개 수
        int K = Integer.parseInt(st.nextToken()); // K번째 수

        int[] numbers = new int[N];

        // 숫자 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(numbers);

        System.out.println(numbers[K-1]);
    }
}
