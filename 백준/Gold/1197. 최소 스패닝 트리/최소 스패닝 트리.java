import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N,E;
    static int[] parent;
    static Edge[] edges;
    static int count = 0;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 노드개수
        E = Integer.parseInt(st.nextToken()); // 에지개수

        parent = new int[N+1]; // 노드번호 1번부터 시작
        edges = new Edge[E];

        // 에지정보 입력받기
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, value);
        }

        // 에지 value기준으로 오름차순 정렬
        Arrays.sort(edges, Comparator.comparingInt(a -> a.value));

        // 대표노드배열 parent 초기화
        for(int i=1; i<N+1; i++){
            parent[i] = i;
        }

        for(int i=0; i<E; i++){
            // count가 N-1이 될때까지 반복
            if (count > N-1) break;

            Edge edge = edges[i];
            if(find(edge.start) != find(edge.end)){
                // start, end 노드의 대표노드가 다르다면(사이클X) union 연산
                union(edge.start, edge.end);
                sum += edge.value;
                count++;
            }
        }

        System.out.println(sum);
    }
    private static int find(int a){
        if(a == parent[a]) return a; // 자기자신이 대표노드라면 index return
        return parent[a] = find(parent[a]); // 아니라면 내 대표노드의 대표노드 찾아서 넣어줌
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){ // a와 b의 대표노드가 다르다면
            parent[b] = a; // b의 대표노드에 a의 대표노드 찾아서 넣어주기
        }
    }
}
class Edge{
    int start;
    int end;
    int value;

    public Edge(int start, int end, int value){
        this.start = start;
        this.end = end;
        this.value = value;
    }
}
