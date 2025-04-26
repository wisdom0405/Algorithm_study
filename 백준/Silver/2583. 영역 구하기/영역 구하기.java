import java.io.*;
import java.util.*;

public class Main {
    static int[][] A;
    static boolean[][] visited;
    static int M,N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        A = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            Arrays.fill(A[i], 1);
        }

        // 직사각형 그리기
        while (K-- > 0){
            st = new StringTokenizer(br.readLine());
            // 왼쪽아래 좌표
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            // 오른쪽 위 좌표
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    A[j][i] = 0;
                }
            }
        }
        int count = 0; // bfs 횟수 (영역개수)
        ArrayList<Integer> spacious = new ArrayList<>(); // 영역당 넓이
        for (int i=0; i<M; i++){
            for (int j=0; j<N; j++){
                if (!visited[i][j] && A[i][j]!=0){
                    spacious.add(bfs(i,j));
                    count++;
                }
            }
        }
        Collections.sort(spacious);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(count + "\n");

        for (int i=0; i<spacious.size(); i++){
            bw.write(spacious.get(i) + " ");
        }
        bw.flush();
        bw.close();
    }
    private static int bfs(int i, int j){
        visited[i][j] = true; // 방문처리
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});

        int spacious = 0;
        while (!q.isEmpty()){
            int[] now = q.poll();
            spacious++;

            for(int k=0; k<4; k++){
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (isIn(nx, ny)&& !visited[nx][ny]){
                    visited[nx][ny] = true;
                    if (A[nx][ny] != 0){
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }
        return spacious;
    }
    private static boolean isIn(int x, int y){
        return x>=0 && y>=0 && x<M && y<N;
    }
}
