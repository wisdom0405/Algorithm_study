import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    static String[][] A;
    static boolean[][] visited;
    static int count = 0;
    static HashSet<String> passed = new HashSet<>();
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우 좌표
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 세로 칸 (행)
        C = Integer.parseInt(st.nextToken()); // 가로 칸 (열)
        A = new String[R+1][C+1]; // 보드 (행, 열 모두 1부터 시작)
        visited = new boolean[R+1][C+1]; // 방문배열

        // 보드 정보 입력받기
        for (int i=1; i<R+1; i++){
            String[] alphabets = br.readLine().split("");
            for (int j=1; j<C+1; j++){
                A[i][j] = alphabets[j-1];
            }
        }

        DFS(1,1);

        System.out.println(count);
    }
    private static void DFS(int i, int j){
        passed.add(A[i][j]); // 현재 알파벳 추가
        count = Math.max(count, passed.size()); // 이동칸수 최대값으로 업데이트

        for (int k=0; k<4; k++){ // 현재 좌표에서 상하좌우 좌표 탐색
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (isIn(nx,ny) && !visited[nx][ny] && !passed.contains(A[nx][ny])){
                visited[nx][ny] = true;
                DFS(nx, ny); // 탐색좌표로 재귀호출
                visited[nx][ny] = false;
            }
        }
        passed.remove(A[i][j]); // 백트래킹
    }
    private static boolean isIn(int x, int y){
        return x>0 && y>0 && x<=R && y<=C;
    }
}
