import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static int weight = 500;
    static int count;
    static int[] plan;
    static boolean[] done;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N일동안 운동계획, 매일 K만큼 중량감소
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        done = new boolean[N];
        count = 0;

        // N일간 운동계획표 입력받기
        st = new StringTokenizer(br.readLine());
        plan = new int[N];
        for(int i=0; i<N; i++){
            plan[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);
        System.out.println(count);

    }
    private static void DFS( int day){
        // 종료조건 : N번째 날이면 count 후 종료
        if(day == N){
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            int newWeight = weight - K + plan[i];
            if(!done[i] && newWeight >= 500){
                done[i] = true;
                weight = newWeight; // 새로운 중량으로 update
                DFS(day+1);

                done[i] = false;
                weight = weight + K -plan[i]; // 이전 중량으로 백트래킹
            }
        }
    }
}
