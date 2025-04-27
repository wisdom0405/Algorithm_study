import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] num;
    static int[] operator = new int[4]; // +, -, *, /
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 수 개수
        num = new int[N];

        // 수 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 개수 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, num[0]);

        System.out.println(max);
        System.out.println(min);

    }
    private static void dfs(int idx, int cur){
        if (idx == N){
            min = Math.min(min, cur); // 최솟값 비교
            max = Math.max(max, cur); // 최댓값 비교
            return;
        }

        for (int i=0; i<4; i++){
            if (operator[i] > 0){
                operator[i]--;
                if (i == 0){
                    dfs(idx+1, cur + num[idx]);
                } else if (i == 1) {
                    dfs(idx+1, cur - num[idx]);
                } else if (i == 2) {
                    dfs(idx+1, cur * num[idx]);
                }else{
                    dfs(idx+1, divide(cur, num[idx]));
                }

                operator[i]++;
            }
        }

    }

    private static int divide(int a, int b){
        if (a < 0){
            return -(-a / b);
        }else{
            return a / b;
        }
    }
}
