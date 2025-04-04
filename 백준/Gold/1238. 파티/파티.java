import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,X;
    static ArrayList<Road>[] roads;
    static int[] depart;
    static int[] timeTaken;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 학생 수
        M = Integer.parseInt(st.nextToken()); // 도로 수
        X = Integer.parseInt(st.nextToken()); // 파티 장소

        roads = new ArrayList[N+1]; // 도로 번호 1부터 시작
        depart = new int[N+1]; // 집 -> 파티장소 (출발소요시간)

        // 도로 인접노드리스트 초기화
        for(int i=1; i<N+1; i++){
            roads[i] = new ArrayList<>();
        }

        // 도로정보 입력받기
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 시작점
            int end = Integer.parseInt(st.nextToken()); // 도착점
            int time = Integer.parseInt(st.nextToken()); // 소요시간

            // 단방향 도로
            roads[start].add(new Road(end, time));
        }

        // 집 -> 파티장소(X) 최단 소요시간
        for(int i=1; i<N+1; i++){
            timeTaken = new int[N+1]; // 소요시간 배열 초기화
            Arrays.fill(timeTaken, Integer.MAX_VALUE);

            timeTaken[i] = 0; // 출발노드 소요시간 0으로 초기화
            dijkstra(i); // 다익스트라 수행

            // i출발 -> 파티장소 최단 소요시간 기록
            depart[i] = timeTaken[X];
        }

        // 파티장소(X) -> 집 최단 소요시간
        timeTaken = new int[N+1]; // 소요시간 배열 초기화
        Arrays.fill(timeTaken, Integer.MAX_VALUE);
        timeTaken[X] = 0; // 출발노드 소요시간 0으로 초기화
        dijkstra(X); // 파티장소(X) 출발 다익스트라 수행

        int max = Integer.MIN_VALUE;
        for(int i=1; i<N+1; i++){
            max = Math.max(max, timeTaken[i] + depart[i]);
        }

        System.out.println(max);
    }
    private static void dijkstra(int start){
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.offer(new Road(start, 0));

        while (!pq.isEmpty()){
            Road now = pq.poll();

            // 현재 노드의 최단경로가 이미 더 짧다면 무시
            if (now.time > timeTaken[now.num]) continue;

            for(Road next : roads[now.num]){
                int newTimeTaken = timeTaken[now.num] + next.time; // 새로운 경로 소요시간
                if (newTimeTaken < timeTaken[next.num]){
                    timeTaken[next.num] = newTimeTaken; // 새로운경로 소요시간으로 update
                    pq.add(new Road(next.num, newTimeTaken));
                }
            }
        }
    }
}
class Road implements Comparable<Road>{
    int num; // 도로 도착도시 번호
    int time; // 소요시간

    public Road(int des, int time){
        this.num = des;
        this.time = time;
    }

    @Override
    public int compareTo(Road o) {
        return this.time - o.time; // 소요시간 오름차순
    }
}
