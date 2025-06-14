import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 유저의 수
        int M = Integer.parseInt(st.nextToken()); //관계의 수

        ArrayList<Integer>[] A = new ArrayList[N+1]; // 유저번호 1부터 시작
        boolean[] visited; // 방문 여부
        int[] kevinBacon; // 케빈베이컨 수

        for (int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        while (M-->0){
            st = new StringTokenizer(br.readLine());
            int user1 = Integer.parseInt(st.nextToken());
            int user2 = Integer.parseInt(st.nextToken());
            A[user1].add(user2); // 친구 관계 양방향 저장
            A[user2].add(user1);
        }

        Queue<int[]> q = new LinkedList<>();
        int[] result = new int[N+1];

        for (int n=1; n<N+1; n++){
            visited = new boolean[N+1];
            kevinBacon = new int[N+1];

            // bfs 시작
            q.offer(new int[]{n, 0});
            while (!q.isEmpty()){
                int[] now = q.poll();
                int user = now[0]; // 유저번호
                int depth = now[1]; // 관계깊이

                kevinBacon[user] = depth; // 케빈베이컨 수 저장

                for (int next : A[user]){ // user가 아는 사람 큐에 저장
                    if (!visited[next]){
                        visited[next] = true;
                        q.offer(new int[]{next, depth+1});
                    }
                }
            }

            int sum = 0; // 케빈베이컨 점수 총합

            for (int i=1; i<N+1; i++){
                sum += kevinBacon[i];
            }

            result[n] = sum;
        }


        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 1; i <= N; i++){
            if (result[i] < min){
                min = result[i];
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
