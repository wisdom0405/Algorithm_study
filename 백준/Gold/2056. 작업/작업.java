import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수행해야 할 작업

        ArrayList<Work>[] A = new ArrayList[N+1]; // 작업번호 1번부터 시작
        Work[] works = new Work[N+1]; // 작업정보 저장
        int[] indegree = new int[N+1]; // 진입차수 배열
        int[] spent = new int[N+1]; // i번 작업 수행하는데 소요되는 시간

        // 인접노드 리스트 초기화 하기
        for (int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        // 작업 정보 입력받기
        StringTokenizer st;
        for (int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken()); // 걸리는 시간
            works[i] = new Work(i, time); // 작업정보 저장

            int priorNumbers = Integer.parseInt(st.nextToken()); // 선행관계에 있는 작업들의 개수
            indegree[i] = priorNumbers; // 진입차수 저장

            // 선행작업 저장
            while (priorNumbers-->0){
                int prior = Integer.parseInt(st.nextToken()); // 선행 작업번호
                A[prior].add(works[i]); // prior 번 작업 -> i번 작업수행
            }
        }

        // 위상정렬 시작
        Queue<Work> q = new LinkedList<>();

        // 진입차수 0인 작업 큐에 넣기
        for (int i=1; i<N+1; i++){
            if (indegree[i] == 0){
                q.offer(works[i]);
            }
        }

        while (!q.isEmpty()){
            Work now = q.poll();
            spent[now.index] += now.time;

            for (Work next : A[now.index]){
                indegree[next.index]--; // 진입차수 감소
                spent[next.index] = Math.max(spent[next.index], spent[now.index]);
                if (indegree[next.index] == 0){
                    q.offer(next); // 진입차수 감소 후 0이 되었다면 큐에 넣음
                }
            }
        }

        int result = 0;
        for (int i=1; i<N+1; i++){
            result = Math.max(result, spent[i]);
        }

        System.out.println(result);
    }
}
class Work{
    int index; // 작업번호
    int time; // 걸리는 시간

    public Work(int index, int time){
        this.index = index;
        this.time = time;
    }
}
