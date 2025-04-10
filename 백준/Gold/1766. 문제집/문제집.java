import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 문제 개수
        int M = Integer.parseInt(st.nextToken()); // 먼저 푸는 것이 좋은 문제 개수

        int[] indegree = new int[N+1]; // 진입차수 배열 (문제번호 1부터 시작)

        ArrayList<Integer>[] A = new ArrayList[N+1]; // 그래프 배열
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>(); // 인접노드 리스트 만들어주기
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()); // 선행풀이 문제
            int second = Integer.parseInt(st.nextToken()); // 선행풀이 이후 풀어야하는 문제

            A[first].add(second); // first문제 풀이 후 -> second 풀기
            indegree[second]++; // second 문제에 진입차수 증가
        }

        // 오름차순 우선순위 큐 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<N+1; i++){
            if (indegree[i] == 0){ // 진입차수 0이면 큐에 넣는다.
                pq.offer(i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!pq.isEmpty()){
            int now = pq.poll(); // 현재 문제
            bw.write(now + " ");

            for(int next : A[now]){ // 현재 문제의 인접노드 리스트 순회
                indegree[next]--; // 다음문제 진입차수 감소
                if (indegree[next] == 0){ // 감소 후 진입차수가 0이되면 큐에 넣는다.
                    pq.offer(next);
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
