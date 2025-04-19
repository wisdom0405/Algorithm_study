import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int num = 0; // 단지번호

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        visited = new boolean[N][N];

        // 지도 정보 입력받기
        for(int i=0; i<N; i++){
            String[] line = br.readLine().split("");
            for(int j=0; j<N; j++){
                A[i][j] = Integer.parseInt(line[j]);
            }
        }

        ArrayList<Integer> countList = new ArrayList<>(); // 단지개수 리스트

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (A[i][j]==1 && !visited[i][j]){
                    // 집이 있고 아직 방문하지 않았다면 BFS 수행
                    // BFS 종료되면 단지 별 집 개수 기록
                    countList.add(BFS(i,j));
                    num++; // 단지 번호 증가
                }
            }
        }

        System.out.println(num); // 총 단지개수
        Collections.sort(countList);
        for (int i=0; i<countList.size(); i++){
            System.out.println(countList.get(i));
        }

    }

    private static int BFS(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i,j});
        visited[i][j] = true; // 방문체크

        int count = 0; // count 값 초기화

        while (!q.isEmpty()){
            int[] now = q.poll();
            count++; // 단지에 포함된 집 개수 증가

            for (int k=0; k<4; k++){
                // 좌표 상하좌우 탐색
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny]){
                    // 상하좌우 탐색좌표가 범위안에 있고 아직 방문하지 않았다면 방문체크 후 큐에 넣어준다.
                    visited[nx][ny] = true;
                    if (A[nx][ny] == 1){
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }

        return count;
    }
}
