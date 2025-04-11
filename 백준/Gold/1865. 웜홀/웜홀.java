import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        // 테스트 케이스 시작
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 지점 개수 (노드)
            int M = Integer.parseInt(st.nextToken()); // 도로 개수 (에지)
            int W = Integer.parseInt(st.nextToken()); // 웜홀 개수 (에지)

            int[] spent = new int[N+1]; // n번 지점 도착하는데 걸리는 최소시간

            // 에지 정보 저장
            ArrayList<Path> paths = new ArrayList<>();

            // 도로 정보 입력받기 (양방향)
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                paths.add(new Path(node1, node2, time));
                paths.add(new Path(node2, node1, time));
            }

            // 웜홀 정보 입력받기 (단방향)
            for(int i=0; i<W; i++){
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken()); // 줄어드는 시간

                paths.add(new Path(node1, node2, -time)); // 웜홀에서는 시간 줄어듦
            }

            // 모든 노드가 0번노드(가상노드)와 연결되어있다고 가정
            // 가상노드 : 만약 그래프가 연결되지 않았고 음수사이클이 출발노드에서 도달 불가능한 곳이 있다면 그 사이클을 못찾음
            for(int i=1; i<N+1; i++){
                paths.add(new Path(0, i, 0));
            }

            Arrays.fill(spent, 0); // 모든 노드가 출발노드인 것으로 간주
            // 사용한 에지가 N개 일때 사이클 만들어짐 => N+1 번째 수행했을 때 값이 더 감소하면 음수사이클이 있다는 뜻
            boolean isCycle = false;
            for(int i=0; i<=N; i++){
                for(Path path : paths){
                    if (spent[path.end] > spent[path.start] + path.time){
                        spent[path.end] = spent[path.start] + path.time;
                        if (i == N) isCycle = true; // N+1 번째 수행에서도 값이 변하면 음수사이클 존재한다는 뜻
                    }
                }
            }

            System.out.println(isCycle ? "YES" : "NO");
        }

    }
}
class Path{
    int start;
    int end;
    int time;

    public Path(int start, int end, int time){
        this.start = start;
        this.end = end;
        this.time = time;
    }
}
