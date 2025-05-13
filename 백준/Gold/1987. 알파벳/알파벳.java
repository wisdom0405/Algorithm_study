import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R,C,max = 0;
    static char[][] board;
    static boolean[] used = new boolean[26]; // A ~ Z 사용여부
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i=0; i<R; i++){
            String alphabets = br.readLine();
            for (int j=0; j<C; j++){
                board[i][j] = alphabets.charAt(j);
            }
        }

        used[board[0][0] - 'A'] = true; // 첫 시작 알파벳 방문처리
        DFS(0,0,1);
        System.out.println(max);
    }
    private static void DFS(int x, int y, int depth){
        // 이동칸 수 최댓값 비교
        max = Math.max(max, depth);

        for (int k=0; k<4; k++){ // 현재 좌표 상하좌우 좌표 탐색
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx>=0 && ny>=0 && nx<R && ny<C){
                int idx = board[nx][ny] - 'A'; // 탐색좌표 알파벳 index
                if (!used[idx]){
                    used[idx] = true;
                    DFS(nx, ny, depth+1);
                    used[idx] = false; // 백트래킹
                }
            }
        }
    }
}
