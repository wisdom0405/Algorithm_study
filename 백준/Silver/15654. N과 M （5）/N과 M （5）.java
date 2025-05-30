import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] A;
    static boolean[] visited;
    static ArrayList<Integer> sequence = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 자연수 입력 받기
        A = new int[N];
        visited = new boolean[N]; // 방문배열 초기화

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(A);
        dfs(0);

        bw.flush();
        bw.close();
    }

    private static void dfs(int depth) throws IOException{
        // sequence 길이가 M 이라면 수열 출력 후 종료
        if (depth == M){
            for (int seq : sequence){
                bw.write(seq + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i=0; i<N; i++){
            if (!visited[i]){
                visited[i] = true;
                sequence.add(A[i]);

                dfs(depth+1); // dfs재귀호출
                visited[i] = false;
                sequence.remove(sequence.size()-1); // 백트래킹
            }

        }
    }
}
