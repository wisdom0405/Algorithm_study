import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] num;
    static boolean[] visited;
    static ArrayList<Integer> sequence;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        num = new int[N+1];
        visited = new boolean[N+1];
        sequence = new ArrayList<>();

        for (int i=1; i<N+1; i++){
            num[i] = i;
        }

        dfs(0);

    }
    private static void dfs(int depth){
        // 모든 숫자 다 썼으면 순열 출력 후 종료
        if (depth == N){
            for (int seq : sequence){
                System.out.print(seq + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<N+1; i++){
            if (!visited[i]){
                visited[i] = true; // 방문체크
                sequence.add(num[i]); // 순열리스트에 요소 추가

                dfs(depth+1); // dfs 재귀호출 depth증가

                visited[i] = false; // 방문 취소(백트래킹)
                sequence.remove(sequence.size()-1); // 마지막 요소 제거
            }
        }

    }
}
