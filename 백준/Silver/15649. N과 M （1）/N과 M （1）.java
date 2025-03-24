import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static List<Integer> sequence;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1 ~ N까지 자연 수 중에서 중복없이 M개를 고른수열
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1]; // 자연수 1부터 시작, 방문배열 초기화
        sequence = new ArrayList<>();

        DFS(0);
    }
    private static void DFS(int depth){
        if(depth == M){ // 현재자리수와 목표자리수 일치하면 return
            for(int num : sequence){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<N+1; i++){
            if(!visited[i]){ // 아직 사용하지 않은 숫자라면, 방문체크 후 DFS 재귀호출
                visited[i] = true;
                sequence.add(i);

                DFS(depth + 1); // 재귀호출 depth증가

                // 백트래킹
                visited[i] = false;
                sequence.remove(sequence.size() - 1); // 마지막 숫자 제거
            }
        }
    }
}
