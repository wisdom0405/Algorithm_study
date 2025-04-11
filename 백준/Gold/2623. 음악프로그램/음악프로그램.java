import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 가수 수
        int M = Integer.parseInt(st.nextToken()); // 보조 PD 수

        int[] indegree = new int[N+1]; // 진입 차수 (가수번호 1부터 시작)
        ArrayList<Integer>[] A = new ArrayList[N+1];

        // 인접노드리스트 초기화 해주기
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        // 보조 PD가 받아온 출연순서 입력하기
        for(int j=0; j<M; j++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 알아온 가수 수
            int first = Integer.parseInt(st.nextToken());
            for(int i=1; i<n; i++){
                int second = Integer.parseInt(st.nextToken());
                A[first].add(second);
                indegree[second]++;
                first = second;
            }
        }

        // 위상정렬
        Queue<Integer> q = new LinkedList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=1; i<N+1; i++){
            if (indegree[i] == 0){ // 진입차수 0인 것만 큐에 넣는다.
                q.offer(i);
            }
        }

        while (!q.isEmpty()){
            int now = q.poll();
            bw.write(now+"\n");

            for (int next : A[now]){
                indegree[next]--; // 인접 노드들 진입차수 1감소
                if (indegree[next] == 0){
                    // 진입차수 감소 후 0이 된다면 큐에 넣기
                    q.offer(next);
                }
            }
        }

        for(int i=1; i<N+1; i++){
            if (indegree[i] != 0){
                System.out.println(0);
                return;
            }
        }

        bw.flush();
        bw.close();
    }
}
