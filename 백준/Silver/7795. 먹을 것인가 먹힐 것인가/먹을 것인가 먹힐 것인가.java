import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        // 테스트 시작
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // A개수
            int M = Integer.parseInt(st.nextToken()); // B개수

            int[] A = new int[N];
            int[] B = new int[M];

            // A 배열 입력받기
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A); // 오름차순 정렬

            // B 배열 입력받기
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B); // 오름차순 정렬

            int j = 0;
            int count = 0;
            for(int i=0; i<N; i++){
                while (j<M && B[j] < A[i]){
                    j++;
                }
                count += j;
            }

            System.out.println(count);
        }
    }
}
