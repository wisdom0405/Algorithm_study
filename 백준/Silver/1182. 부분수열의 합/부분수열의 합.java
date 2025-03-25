import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,S;
    static int[] sequence;
    static int count;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N개의 정수 수열
        S = Integer.parseInt(st.nextToken()); // target
        sequence = new int[N];
        count = 0;

        // 수열 입력받기
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0,0, false);
        System.out.println(count);
    }
    private static void DFS(int index, int sum, boolean selected){
        // 모든 원소를 탐색한 경우
        if (index == N){
            if(sum == S && selected){ // 적어도 하나의 원소를 선택한 경우 count++
                count++;
            }
            return;
        }

        // 현재 요소를 선택하는 경우
        DFS(index+1, sum + sequence[index], true);

        // 현재 요소를 선택하지 않는 경우
        DFS(index+1, sum, selected);
    }
}
