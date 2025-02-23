import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번째 줄 읽기
        int N = Integer.parseInt(st.nextToken()); // 배열크기 N
        int quizeNum = Integer.parseInt(st.nextToken()); // 질의 개수

        int[][] Arr = new int[N+1][N+1]; // 입력받을 값이 들어갈 int 배열선언

        // 원본배열 값 넣기
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine()); // 원본 배열 i번째 줄 읽기
            for(int j=1; j < N+1; j++){
                Arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 합배열 만들기
        int[][] sumArr = new int[N+1][N+1];
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                // 합배열 공식
                sumArr[i][j] = sumArr[i][j-1] + sumArr[i-1][j] - sumArr[i-1][j-1] + Arr[i][j];
            }
        }

        // 질의받기
        for(int i=0; i<quizeNum; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(sumArr[x2][y2] - sumArr[x1-1][y2] - sumArr[x2][y1-1] + sumArr[x1-1][y1-1]);
        }
    }
}
