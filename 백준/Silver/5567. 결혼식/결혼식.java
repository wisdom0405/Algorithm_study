import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 상근이 동기의 수
        int M = Integer.parseInt(br.readLine()); // 리스트 길이

        boolean[] visited = new boolean[N+1]; // 방문배열 (학번 1번부터 시작)
        ArrayList<Integer>[] graph = new ArrayList[N+1];

        // 인접리스트 초기화
        for (int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        // 친구관계 정보입력
        StringTokenizer st;
        while (M-->0){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 친구관계 양방향 저장
            graph[A].add(B);
            graph[B].add(A);
        }

        Queue<int[]> queue = new LinkedList<>();
        visited[1] = true; // 상근이 본인
        queue.offer(new int[]{1,0}); // {현재번호, 깊이}

        int count = 0;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int peer = cur[0];
            int depth = cur[1];

            if (depth >=1 && depth <=2){
                count++;
            }

            // 친구의 친구까지만 탐색
            if (depth == 2) continue;

            for (int next : graph[peer]){
                if (!visited[next]){
                    visited[next] = true;
                    queue.offer(new int[] {next, depth+1});
                }
            }
        }

        System.out.println(count);
    }
}
