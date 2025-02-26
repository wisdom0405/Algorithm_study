import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // N : 숫자의 개수
        int[] A = new int[N]; // 크기 N의 배열 선언

        // 원본배열에 값 넣기
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // 버블 정렬 구현
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    // 인접한 원소 교환
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }

        // 정렬된 배열 출력
        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append("\n");
        }

        System.out.println(sb);
    }
}