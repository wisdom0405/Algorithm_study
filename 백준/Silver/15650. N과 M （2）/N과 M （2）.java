import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<Integer>  sequence;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sequence = new ArrayList<>();

        // 1부터 N까지의 자연수 중에서 중복 없이 M개를 고른 수열 (오름차순)
        DFS(1, 0);

    }
    private static void DFS(int start, int depth){
        if(depth == M){
            // DFS depth가 M과 같아지면 종료, 수열 출력
            for(int num : sequence){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        // 아직 depth가 M이 아니라면 재귀호출
        for(int i=start; i<N+1; i++){
            sequence.add(i);
            DFS(i+1, depth+1); // 오름차순 유지
            sequence.remove(sequence.size()-1); // 마지막 요소 제거 (백트래킹)
        }

    }
}
