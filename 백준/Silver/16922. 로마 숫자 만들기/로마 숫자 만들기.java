import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] romes = {1, 5, 10, 50};
    static boolean[][] visited;
    static boolean[] possible;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N+1][N*50+1];
        possible = new boolean[N*50+1];

        DFS(0,0);

        int count = 0;
        for (boolean b : possible){
            if (b) count++;
        }
        
        System.out.println(count);
    }
    private static void DFS(int depth, int sum) {
        if (depth == N) {
            possible[sum] = true;
            return;
        }

        if (visited[depth][sum]) return; // 이미 기록된 값이면 종료

        visited[depth][sum] = true; // 로마숫자 depth개 사용해서 만든 sum

        for (int r : romes){
            DFS(depth+1, sum + r);
        }
    }
}
