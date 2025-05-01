import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] S;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer> sequence;
    static boolean firstTestCase = true;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = br.readLine()).equals("0")){
            StringTokenizer st = new StringTokenizer(line);
            int k = Integer.parseInt(st.nextToken()); // 집합 개수 k

            S = new int[k]; //  집합배열 초기화
            sequence = new ArrayList<>(); // 수열 리스트 초기화

            for (int i=0; i<k; i++){
                S[i] = Integer.parseInt(st.nextToken());
            }

            if (!firstTestCase) bw.write("\n");
            firstTestCase = false;

            DFS(0,0);

        }
        bw.flush();
        bw.close();
    }
    private static void DFS(int start, int depth) throws IOException{
        if (depth == 6){
            for (int seq : sequence){
                bw.write(seq + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i=start; i<S.length; i++){
            sequence.add(S[i]);
            DFS(i+1,depth+1);
            sequence.remove(sequence.size()-1); // 맨마지막 요소 삭제
        }
    }
}
