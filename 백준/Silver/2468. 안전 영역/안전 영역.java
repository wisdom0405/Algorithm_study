import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] A;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int count;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int rain;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N][N];

        StringTokenizer st;
        // 지역 높이 입력받기 + 지역높이 min, max 구하기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, A[i][j]);
            }
        }

        int maxSafePlaceCount = 0;
        for(int k=0; k<max; k++){
            visited = new boolean[N][N]; // 방문배열 초기화
            count = 0; // count 초기화
            rain = k;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if (!visited[i][j] && A[i][j] > rain){ // 방문하지 않았고, 안전지대라면
                        count++;
                        BFS(i,j);
                    }
                }
            }
            // 높이 k 이하인 지역이 물에 잠겼을 때 안전지대 개수 기록
            maxSafePlaceCount = Math.max(maxSafePlaceCount, count);
        }

        System.out.println(maxSafePlaceCount);
    }
    private static void BFS(int x, int y){
        visited[x][y] = true; // 방문체크
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});

        while (!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){ // 현재 좌표의 상하좌우 좌표 탐색
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny]){
                    if (A[nx][ny] > rain){ // 탐색지형이 rain보다 높다면 안전지대
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}
