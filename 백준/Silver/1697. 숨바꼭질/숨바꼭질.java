import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이 현재 점
        int K = Integer.parseInt(st.nextToken()); // 동생 위치 점

        int max = 100001;
        boolean[] visited = new boolean[max];
        int[] time = new int[max];

        Queue<Integer> q = new LinkedList<>();
        q.offer(N); // 수빈이 위치
        visited[N] = true;

        while (!q.isEmpty()){
            int now = q.poll(); // 현재좌표

            // 동생 잡았으면 이동 최솟값 출력 후 종료
            if (now == K){
                System.out.println(time[now]);
                break;
            }

            // 이동할 수 있는 경우 3가지
            int[] nextMoves = {now-1, now+1, now*2};
            for (int next : nextMoves){
                if (next >= 0 && next < max && !visited[next]){
                    q.offer(next); // 유효한 범위면 큐에 넣는다.
                    visited[next] = true;
                    time[next] = time[now] + 1;
                }
            }
        }
    }
}
