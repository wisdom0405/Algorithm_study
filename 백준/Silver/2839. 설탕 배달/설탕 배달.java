import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N==4){
            System.out.println(-1);
            return;
        }
        if (N==3){
            System.out.println(1);
            return;
        }

        int[] A = new int[N+1]; // 1kg부터 시작, i키로당 최소 포장봉지갯수 저장

        // 배열 INF값으로 초기화
        int INF = 1000001;
        Arrays.fill(A, INF);

        // 5kg 짜리 봉지로 나눠담을 수 있는 설탕은 5kg 봉지로만 포장
        for(int i=5; i<N+1; i+=5){
            A[i] = i/5;
        }

        // 3kg 짜리 봉지로 나눠담을 수 있는 설탕 : 최소값 비교
        for(int i=3; i<N+1; i+=3){
            A[i] = Math.min(A[i], i/3);
        }

        for(int i=5; i<N+1; i++){
            A[i] = Math.min(A[i], A[i-3]+1);
            A[i] = Math.min(A[i], A[i-5]+1);
        }

        System.out.println(A[N] >= INF ? -1 : A[N]);
    }
}
