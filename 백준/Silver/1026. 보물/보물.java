import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // A배열 입력받기
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        // B배열 입력받기
        for(int i=0; i<N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        // A 오름차순 정렬
        Arrays.sort(A);

        // B 내림차순 정렬
        B = IntStream.of(B)
                .boxed()
                .sorted((a,b) -> b - a)
                .mapToInt(Integer::intValue)
                .toArray();

        int sum = 0;
        for(int i=0; i<N; i++){
            sum += (A[i] * B[i]);
        }

        System.out.println(sum);
    }
}
