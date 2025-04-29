import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] num;
    static ArrayList<Integer> sequence = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N+1]; // 1부터 시작
        for (int i=1; i<N+1; i++){
            num[i] = i;
        }
        DFS(1,0);
        bw.flush();
        bw.close();
    }
    private static void DFS(int start, int depth)throws IOException{
        if (depth == M){
            for (int seq : sequence){
                bw.write(seq + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i=start; i<N+1; i++){
            sequence.add(num[i]);
            DFS(i, depth+1);
            sequence.remove(sequence.size()-1); // 백트래킹
        }

    }
}
