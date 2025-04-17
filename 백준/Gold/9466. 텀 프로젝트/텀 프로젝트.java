
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static boolean[] visited; // DFS 방문여부
    static boolean[] done; // 사이클 방문여부
    static int count;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        // 테스트 시작
        while (T-- > 0){
            int N = Integer.parseInt(br.readLine()); // 학생수
            A = new int[N+1]; // 학생번호 1부터 시작
            visited = new boolean[N+1]; // 방문여부체크 배열
            done = new boolean[N+1]; // 사이클여부체크 배열
            count = 0;

            // 선호 학생번호 선택
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=1; i<N+1; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            for (int i=1; i<N+1; i++){
                if (!visited[i]){
                    DFS(i);
                }
            }

            System.out.println(N - count);
        }



    }
    // DFS로 사이클 찾아내기
    private static void DFS(int now){
        visited[now] = true; // 방문체크
        int next = A[now]; // 다음 방문

        if (!visited[next]){
            DFS(next);
        }else if (!done[next]){
            // 사이클 찾으면
            int temp = next;
            count++; // 현재노드 포함
            while (temp != now){
                temp = A[temp];
                count++;
            }
        }

        done[now] = true;
    }
}
