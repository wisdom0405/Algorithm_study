import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 상자 가로 칸 수
        N = Integer.parseInt(st.nextToken()); // 상자 세로 칸 수
        int[][] A = new int[N][M];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 토마토 정보 입력받기
        boolean zero = false;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                A[i][j]  = Integer.parseInt(st.nextToken());
                if (A[i][j] == 0) {
                    zero = true;
                }
            }
        }

        // 애초에 익은 토마토들 밖에 없다면 굳이 익을때까지 기다릴 필요 없음
        if (!zero){
            System.out.println(0);
            return;
        }

        // 익은 토마토 큐에 넣기
        Queue<int[]> q = new LinkedList<>();
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (A[i][j] == 1){
                    q.offer(new int[] {i,j});
                }
            }
        }

        // bfs 탐색
        while (!q.isEmpty()){
            int[] now = q.poll(); // 익은 토마토 좌표
            for (int k=0; k<4; k++){ // 상하좌우 토마토 탐색
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (isIn(nx,ny) && A[nx][ny]==0){
                    A[nx][ny] = A[now[0]][now[1]] + 1; // 전파될 때마다 +1 저장
                    q.offer(new int[] {nx, ny}); // 새로 익은 토마토 좌표 큐에 넣기
                }
            }
        }

        // 탐색 후 토마토 검사
        int day = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                day = Math.max(day, A[i][j]);
                if (A[i][j] == 0){
                    // 아직 익지 않은 토마토가 존재한다면 -1 출력 후 종료
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(day-1);
    }

    private static boolean isIn(int x, int y){
        return x>=0 && y>=0 && x<N && y<M;
    }
}
