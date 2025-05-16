import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    static int[][] A;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 통로 세로 길이
        M = Integer.parseInt(st.nextToken()); // 통로 가로 길이
        K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기 개수

        A = new int[N][M]; // 통로 초기화
        visited = new boolean[N][M]; // 방문배열 초기화

        // 음식물 쓰레기 좌표 입력받기
        for (int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            A[r-1][c-1] = 1;
        }

        int max = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (A[i][j] == 1 && !visited[i][j]){
                    max = Math.max(max, BFS(i, j));
                }
            }
        }

        System.out.println(max);
    }
    private static int BFS(int r, int c){
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c}); // 큐에 현재좌표 넣기
        visited[r][c] = true; // 방문처리

        // BFS 탐색시작
        while (!q.isEmpty()){
            int[] now = q.poll(); // 현재좌표
            visited[now[0]][now[1]] = true; // 방문체크
            count++;

            for (int i=0; i<4; i++){ // 상하좌우 좌표탐색
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (isIn(nx,ny) && !visited[nx][ny]){
                    visited[nx][ny] = true; // 방문체크
                    if (A[nx][ny] == 1){
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return count;
    }
    private static boolean isIn(int x, int y){
        return x>=0 && y>=0 && x<N && y<M;
    }
}
