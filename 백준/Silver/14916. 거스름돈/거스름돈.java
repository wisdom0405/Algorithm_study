import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N==1 || N==3){
            System.out.println(-1);
            return;
        }

        if (N==2 || N==4){
            System.out.println(N/2);
            return;
        }

        int[] A = new int[N+1]; // 최소 거스름돈 개수
        int INF = 10000001;
        Arrays.fill(A,INF);

        // 5원으로 거슬러 줌
        for(int i=5; i<N+1; i+=5){
            A[i] = i/5;
        }

        // 2원으로 거슬러줌
        for(int i=2; i<N+1; i+=2){
            A[i] = Math.min(A[i], i/2);
        }

        for(int i=6; i<N+1; i++){
            A[i] = Math.min(A[i], A[i-5]+1);
            A[i] = Math.min(A[i], A[i-2]+1);
        }

        System.out.println(A[N] >= INF ? -1 : A[N]);
    }
}
