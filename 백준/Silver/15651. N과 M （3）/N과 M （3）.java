import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] num;
    static ArrayList<Integer> sequence;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1 ~ N까지 자연수 중 M 길이의 수열, 중복 선택가능
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N+1]; // 자연수 1부터 시작
        sequence = new ArrayList<>();
        for (int i=1; i<N+1; i++){
            num[i] = i;
        }
        dfs(0);
        bw.flush();
        bw.close();
    }
    private static void dfs(int depth)throws IOException{
        if (depth == M){
            for (int seq : sequence){
                bw.write(seq + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=1; i<N+1; i++){
            sequence.add(num[i]);
            dfs(depth+1);
            sequence.remove(sequence.size()-1);
        }
    }
}
