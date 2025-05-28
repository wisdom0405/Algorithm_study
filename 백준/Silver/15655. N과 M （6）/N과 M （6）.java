import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] nums;
    static ArrayList<Integer> sequence = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 숫자 입력받기
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(nums);
        DFS(0,0);
        
        bw.flush();
        bw.close();
    }
    private static void DFS(int start, int depth)throws IOException{
        if (depth == M) {
            for (int seq : sequence){
                bw.write(seq + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i=start; i<N; i++){
            sequence.add(nums[i]);
            DFS(i+1, depth + 1);
            sequence.remove(sequence.size()-1);
        }
    }
}
