import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;
    static int root, leaf, rid = 0;
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 노드개수
        visited = new boolean[N];
        A = new ArrayList[N];

        // 인접리스트 초기화
        for(int i=0; i<N; i++){
            A[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int parentNode = Integer.parseInt(st.nextToken());
            if (parentNode == -1){
                root = i; // 부모노드가 -1이라면 해당 노드는 루트노드
                continue;
            }
            // 양방향 저장
            A[i].add(parentNode);
            A[parentNode].add(i);
        }

        rid = Integer.parseInt(br.readLine()); // 제거대상 노드번호

        // 제거대상이 루트노드라면 0 출력
        if (rid == root){
            System.out.println("0");
            return;
        }
        
        visited[rid] = true;
        DFS(root);
        System.out.println(leaf);
    }
    private static void DFS(int node){
        visited[node] = true; // 방문처리
        int count = 0;
        for(int now : A[node]){
            // node의 인접리스트 순회하면서 아직 방문하지 않은 노드있다면 DFS 재귀호출
            if (!visited[now]){
                DFS(now);
                count++;
            }
        }
        // 인접리스트를 순회했는데 DFS 재귀호출한 적이 없다면 leaf노드이다.
        if (count == 0) leaf++;
    }
}
