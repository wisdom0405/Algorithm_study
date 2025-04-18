import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<City2>[] A;
    static int[] costs;
    static int[] previous;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시개수
        M = Integer.parseInt(br.readLine()); // 버스노선 개수
        A = new ArrayList[N+1]; // 도시번호 1부터 시작
        costs = new int[N+1]; // 최소비용 저장 배열
        previous = new int[N+1]; // 최소비용 업데이트 시 이전경로 저장

        // 인접노드 리스트 초기화
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        // 노선정보 입력받기
        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 출발도시
            int end = Integer.parseInt(st.nextToken()); // 도착도시
            int cost = Integer.parseInt(st.nextToken()); // 비용

            A[start].add(new City2(end, cost)); // 단방향 노선
        }

        // 목표 출발, 도착 도시 입력받기
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 시작노드는 이전 노드없음
        previous[start] = -1;

        // 최소비용 배열 초기화
        int INF = 100000001;
        Arrays.fill(costs, INF);
        costs[start] = 0; // 출발도시는 최소거리 0

        dijkstra(start);

        ArrayList<Integer> route = new ArrayList<>();
        route.add(end);
        int prev = previous[end];
        while (prev != -1){
            route.add(prev);
            prev = previous[prev];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(costs[end] + "\n");
        sb.append(route.size() + "\n");

        for (int i=route.size()-1; i>=0; i--){
            sb.append(route.get(i)+" ");
        }

        System.out.println(sb);

    }
    private static void dijkstra(int start){
        PriorityQueue<City2> pq = new PriorityQueue<>();
        pq.offer(new City2(start, 0));

        while (!pq.isEmpty()){
            City2 now = pq.poll();

            // 현재 최소비용이 이미 더 작다면 무시
            if (now.cost > costs[now.index]) continue;

            for(City2 next : A[now.index]){
                // 새로 탐색한 경로가 비용이 더 작다면 update
                int newCost = costs[now.index] + next.cost;
                if (newCost < costs[next.index]){
                    costs[next.index] = newCost;
                    previous[next.index] = now.index; // 최소비용 업데이트 시 이전노드 기록
                    pq.offer(new City2(next.index, newCost));
                }
            }
        }
    }
}
class City2 implements Comparable<City2>{
    int index; // 도착 도시 번호
    int cost; // 비용

    public City2(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(City2 other) {
        return this.cost - other.cost; // 비용 오름차순
    }
}
