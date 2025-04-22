import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 계단 개수
        int[] score = new int[N+1]; // 계단번호 1부터 시작, 계단별 점수 저장배열
        int[] D = new int[N+1]; // 점수최댓값 저장배열

        // 계단별 점수 입력받기
        for (int i=1; i<N+1; i++){
            score[i] = sc.nextInt();
        }

        if (N == 1){
            System.out.println(score[1]);
        } else if (N == 2) {
            System.out.println(score[1] + score[2]);
        }else{
            // 이미 아는 수 입력하기
            D[1] = score[1];
            D[2] = score[1] + score[2];
            D[3] = Math.max(score[1] + score[3], score[2] + score[3]);

            for (int i=4; i<N+1; i++){
                D[i] = Math.max(D[i-2] + score[i], D[i-3] + score[i-1] + score[i]);
            }

            System.out.println(D[N]);
        }
    }
}
