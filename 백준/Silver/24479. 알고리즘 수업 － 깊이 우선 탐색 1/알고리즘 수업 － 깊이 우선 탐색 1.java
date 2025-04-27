import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] result;
    static int num = 1;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int start = Integer.parseInt(st.nextToken()); // 시작정점

        A = new ArrayList[N+1]; // 정점번호 1부터 시작
        visited = new boolean[N+1];
        result = new int[N+1]; // 정답 배열 (각 원소 당 출력 순서기록)
        // 인접노드리스트 초기화
        for (int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        while (M-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 연결 (무방향 그래프)
            A[u].add(v);
            A[v].add(u);
        }

        // 노드별 인접리스트 오름차순 정렬(오름차순 방문)
        for (int i=1; i<N+1; i++){
            Collections.sort(A[i]);
        }

        // 출발노드부터 dfs 수행
        dfs(start);

        for (int i=1; i<N+1; i++){
            System.out.println(result[i]);
        }

    }
    private static void dfs(int start){
        if (visited[start]) return; // 이미 방문한 노드라면 종료

        visited[start] = true; // 방문체크
        result[start] = num++; // 출력순서 저장 후 num 증가
        for (int next : A[start]){ // 인접노드 탐색하면서 아직 방문안한 요소있다면 dfs 재귀호출
            if (!visited[next]){
                dfs(next);
            }
        }
    }
}
