import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // A 배열크기
        int M = Integer.parseInt(st.nextToken()); // B 배열크기

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 0;
        int k = 0;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (i<N && j<M){
            if (A[i] <= B[j]){
                bw.write(A[i++] + " ");
            }else{
                bw.write(B[j++] + " ");
            }
        }

        while (i < N) bw.write(A[i++] + " ");
        while (j < M) bw.write(B[j++] + " ");
        
        bw.flush();
        bw.close();
    }
}
