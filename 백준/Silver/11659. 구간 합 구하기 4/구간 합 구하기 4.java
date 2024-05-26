import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken()); // 숫자의 개수
        int quizNo = Integer.parseInt(stringTokenizer.nextToken()); // 질의의 개수

        long[] S = new long[suNo + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // 합 배열 생성
        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        // 구해야 하는 횟수 quizNo 만큼 for문 반복
        for (int q = 0; q < quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken()); // 구간 시작
            int j = Integer.parseInt(stringTokenizer.nextToken()); // 구간 끝
            bufferedWriter.write((S[j] - S[i - 1]) + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
