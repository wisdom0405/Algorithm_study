import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] memo;
        memo = new int[41][2];

        // 이미 아는 수 입력
        // fibonacci(0) : 0 한개
        memo[0][0] = 1;
        memo[0][1] = 0;

        memo[1][0] = 0;
        memo[1][1] = 1;

        for (int i=2; i<41; i++){
            memo[i][0] = memo[i-1][0] + memo[i-2][0];
            memo[i][1] = memo[i-1][1] + memo[i-2][1];
        }

        while (T-- > 0){
            int N = sc.nextInt();
            System.out.println(memo[N][0] + " " + memo[N][1]);
        }
    }
}