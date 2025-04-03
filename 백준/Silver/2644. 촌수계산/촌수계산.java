import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int start, end;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 사람 수
        A = new ArrayList[N+1]; // 사람번호 1부터 시작
        visited = new boolean[N+1]; // 방문배열 초기화

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 촌수 계산할 대상 2명
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 인접리스트 만들어주기
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine()); // 관계 개수
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            // 양방향 그래프 연결
            A[parent].add(child);
            A[child].add(parent);
        }

        int result = DFS(start,0);
        System.out.println(result);
    }
    private static int DFS(int node, int depth){
        // 이번 노드가 end라면 종료
        if (node == end) return depth;

        // 방문한 노드가 아니라면 방문체크 후, count증가
        visited[node] = true;

        // 인접노드 리스트 순회
        for(int now : A[node]){
            if (!visited[now]){
                int result = DFS(now, depth+1);
                if (result != -1) return result; // 목표 노드 찾으면 즉시 반환
            }
        }
        return -1; // 경로가 없을 경우
    }
}
