import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A); // 오름차순 정렬

        int X = Integer.parseInt(br.readLine()); // target

        // 투포인터 사용
        int i = 0;
        int j = N-1;
        int count = 0;
        while (i < j){
            if (A[i] + A[j] == X){
                count++;
                i++;
                j--;
            }else if(A[i] + A[j] < X){
                i++;
            }else{
                // A[i] + A[j] > X
                j--;
            }
        }

        System.out.println(count);
    }
}
