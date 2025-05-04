import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M,N,H;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 상자 가로칸 수
        N = Integer.parseInt(st.nextToken()); // 상자 세로 칸 수
        H = Integer.parseInt(st.nextToken()); // 쌓아올려지는 상자의 수
        int[][][] A = new int[H][N][M]; // 3차원 배열 선언

        // 안익은 토마토
        boolean unripeTomato = false;
        // 토마토 정보 입력 받기
        for (int h=0; h<H; h++){
            for (int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<M; j++){
                    A[h][i][j] = Integer.parseInt(st.nextToken());
                    if (A[h][i][j] == 0) unripeTomato = true; // 안익은 토마토 있는지?
                }
            }
        }

        // 애초에 안익은 토마토가 없다면 기다릴 필요 없으므로 0출력 후 종료
        if (!unripeTomato){
            System.out.println(0);
            return;
        }

        // 상, 하, 좌, 우, 위, 아래
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        // 익은 토마토 큐에 넣기 (시작점)
        Queue<int[]> q = new LinkedList<>();
        for (int h=0; h<H; h++){
            for (int i=0; i<N; i++){
                for (int j=0; j<M; j++){
                    if (A[h][i][j] == 1){
                        q.offer(new int[] {h,i,j});
                    }
                }
            }
        }

        // bfs 탐색
        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int k=0; k<6; k++){
                // 상 하 좌 우 위 아래 토마토 탐색
                int z = now[0] + dz[k];
                int x = now[1] + dx[k];
                int y = now[2] + dy[k];
                if (isIn(z,x,y) && A[z][x][y] == 0){ // 유효한 좌표이고, 안익은 토마토라면
                    A[z][x][y] = A[now[0]][now[1]][now[2]] + 1; // 토마토 익히고, 일수 증가
                    q.offer(new int[] {z,x,y}); // 익은 토마토 좌표 큐에 넣기
                }
            }
        }

        // bfs 탐색 후 토마토 검사
        int day = 0;
        for (int z=0; z<H; z++){
            for (int x=0; x<N; x++){
                for (int y=0; y<M; y++){
                    day = Math.max(day, A[z][x][y]);
                    if (A[z][x][y] == 0){
                        // 아직 안익은 토마토가 있다면 -1 출력 후 종료
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(day-1);
    }
    private static boolean isIn(int z, int x, int y){
        return z>=0 && x>=0 && y>=0 && z<H && x<N && y<M;
    }
}
