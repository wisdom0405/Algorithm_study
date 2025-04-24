import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N; // 지도크기
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int num = 1; // 육지번호
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 지도크기
        A = new int[N][N]; // 지도배열
        visited = new boolean[N][N]; // 방문배열
        // 지도 정보 입력받기
        StringTokenizer st;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 섬 구분해서 번호 붙이기
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (!visited[i][j] && A[i][j]!=0){
                    labelIsland(i,j); // 같은 육지 탐색 (BFS탐색하면서 육지번호 붙여줌)
                    num++; // 육지번호 증가(변경)
                }
            }
        }

        // 2. 섬마다 BFS 돌려서 최소 다리 길이 찾기
        int min = Integer.MAX_VALUE; // 다리길이 최솟값
        for (int n=2; n<num; n++){
            min = Math.min(min, bridgeBFS(n));
        }
        System.out.println(min);

    }
    private static void labelIsland(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        A[i][j] = num; // 시작좌표 육지번호 붙여주기
        while (!q.isEmpty()){
            int[] now = q.poll();
            visited[now[0]][now[1]] = true; // 현재좌표 방문처리
            for (int k=0;k<4; k++){ // 현재좌표 상하좌우 탐색
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (isIn(nx, ny)&&!visited[nx][ny]){
                    // 상하좌우 탐색좌표가 유효하고, 방문한적 없다면
                    visited[nx][ny] = true; // 방문체크
                    if (A[nx][ny]!=0) {
                        A[nx][ny] = num; // 육지번호 붙여주기
                        q.offer(new int[]{nx, ny}); // 큐에 탐색좌표 넣기
                    }
                }
            }
        }
    }

    private static int bridgeBFS(int islandNum){
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        // 섬 테두리 찾기
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (A[i][j] == islandNum){
                    for (int n=0; n<4; n++){
                        int nx = i + dx[n];
                        int ny = j + dy[n];
                        if (isIn(nx,ny) && A[nx][ny] == 0){
                            q.offer(new int[] {i, j});
                            visited[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        // 다리건설
        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int n=0; n<4; n++){
                int nx = now[0] + dx[n];
                int ny = now[1] + dy[n];
                if (isIn(nx,ny) && !visited[nx][ny]){
                    // 상하좌우 탐색좌표가 유효하고 아직 방문하지 않았다면
                    // 다른섬에 도착
                    if (A[nx][ny]!=0 && A[nx][ny]!=islandNum){
                        return dist[now[0]][now[1]]; // 다리길이 return
                    }
                    // 바다면 계속 확장
                    if (A[nx][ny] == 0){
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[now[0]][now[1]] + 1;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    private static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
