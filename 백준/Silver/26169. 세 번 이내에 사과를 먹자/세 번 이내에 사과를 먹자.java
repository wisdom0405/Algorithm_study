import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] A = new int[5][5];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean isPossible = false;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 보드정보 입력받기
        for (int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 학생위치 입력받기
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 현재 위치는 떠나면 장애물
        A[r][c] = -1;
        DFS(r,c,0,0);

        System.out.println(isPossible ? 1 : 0);

    }
    private static void DFS(int i, int j, int depth, int apple){
        // 이미 성공했다면 탐색 중단
        if (isPossible) return;

        // 사과를 2개이상 먹었다면 성공
        if (apple >= 2){
            isPossible = true;
            return;
        }

        // 이동 3번 초과시 실패
        if (depth == 3) return;

        // 상하좌우 탐색
        for (int n=0; n<4; n++){
            int x = i + dx[n];
            int y = j + dy[n];
            if (!isIn(x,y) || A[x][y] == -1) continue;

            int temp = A[x][y]; // 현재 칸의 값 임시 저장
            int newAppleCount = apple + (temp == 1 ? 1 : 0);

            A[x][y] = -1; // 지나가고 나면 장애물로 바뀜
            DFS(x, y, depth+1, newAppleCount);

            A[x][y] = temp; // 백트래킹
        }
    }
    private static boolean isIn(int x, int y){
        return x>=0 && x<5 && y>=0 && y<5;
    }
}
