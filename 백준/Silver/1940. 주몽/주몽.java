import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine()); // 배열의 크기
        int M = Integer.parseInt(bf.readLine()); // 목표 합

        int[] A = new int[N]; // 배열 A
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A); // 배열 오름차 순 정렬
        
        int count = 0;
        int i = 0; // A[0] => min 값
        int j = N - 1; // A[N-1] => max 값

        while(i < j) {
            if (A[i] + A[j] < M) {
                i++; // min 값 i 한칸 이동
            } else if (A[i] + A[j] > M) {
                j--; // max 값 j 한칸 이동
            } else {
                count++; // count 값 증가
                i++; // 한번 사용한 값 필요없으므로 투 포인터 값 이동
                j--;
            }
        }
        
        System.out.println(count);
        bf.close();
    }
}
