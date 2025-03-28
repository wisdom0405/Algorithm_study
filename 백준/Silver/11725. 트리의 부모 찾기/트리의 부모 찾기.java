import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 노드개수
        tree = new ArrayList[N+1]; // 노드번호 1번부터 시작
        visited = new boolean[N+1]; // 방문배열 초기화

        // 인접리스트 초기화
        for(int i=1; i<N+1; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int node1, node2;
        // 인접노드리스트 입력 받아주기
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());

            // 양방향 연결
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        parent = new int[N+1]; // 부모노드 저장배열
        DFS(0, 1);

        for(int i=2; i<N+1; i++){
            System.out.println(parent[i]);
        }
    }
    private static void DFS(int parentNode, int node){
        parent[node] = parentNode;
        visited[node] = true;

        // 현재노드의 인접리스트 순회
        for(int now : tree[node]){
            if (!visited[now]){
                DFS(node, now);
            }
        }
    }
}
