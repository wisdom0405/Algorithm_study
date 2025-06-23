import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        // 그림 입력받기
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int count = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (!visited[i][j] && A[i][j] == 1){
                    count++;
                    max = Math.max(max, dfs(i,j));
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
    private static int dfs(int x, int y){
        visited[x][y] = true;
        int area = 1;

        for (int k=0; k<4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (isIn(nx,ny) && !visited[nx][ny] && A[nx][ny] == 1){
                area += dfs(nx,ny);
            }
        }
        return area;
    }
    private static boolean isIn(int x, int y){
        return x>=0 && y>=0 && x<N && y<M;
    }
}
