import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        // 테스트 시작
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 건물 개수
            int K = Integer.parseInt(st.nextToken()); // 건설순서 규칙개수

            int[] indegree = new int[N+1]; // 진입차수 배열 (건물번호 1번부터 시작)
            Craft[] crafts = new Craft[N+1]; // 건설정보
            int[] spent = new int[N+1]; // i번 건물 짓는데 소요되는 최소시간

            ArrayList<Craft>[] A = new ArrayList[N+1]; // 건물 건설정보 저장 그래프

            // 인접노드 리스트 초기화
            for(int i=1; i<N+1; i++){
                A[i] = new ArrayList<>();
            }

            // 건물 건설정보 입력받기
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<N+1; i++){
                int time = Integer.parseInt(st.nextToken());
                crafts[i] = new Craft(i, time);
            }

            // 건설규칙 정보받기
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                A[first].add(crafts[second]); // first 건설 후 -> second 건설
                indegree[second]++; // second 건물 진입차수 증가
            }

            // 목표 건물번호
            int target = Integer.parseInt(br.readLine()); // 목표 건물 번호

            // 위상정렬
            Queue<Craft> q = new LinkedList<>();

            // 진입차수 0인 건물 큐에 넣기
            for(int i=1; i<N+1; i++){
                if (indegree[i] == 0){
                    q.offer(crafts[i]);
                }
            }

            while (!q.isEmpty()){
                Craft now = q.poll();
                spent[now.num] += now.time;
                if (now.num == target){
                    System.out.println(spent[now.num]);
                    break;
                }

                for(Craft next : A[now.num]){
                    indegree[next.num]--; // 진입차수 감소
                    spent[next.num] = Math.max(spent[next.num], spent[now.num]);
                    if (indegree[next.num] == 0){
                        q.offer(next);
                    }
                }
            }

        }
    }
}
class Craft{
    int num; // 건물번호
    int time; // 건설 소요시간

    public Craft(int num, int time){
        this.num = num;
        this.time = time;
    }
}
