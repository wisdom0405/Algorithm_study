// 연속된 자연수의 합 구하기 (백준2018)
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1; // 자기자신 하나로 이루어진 경우의 수 미리 저장
        int start_index = 1;
        int end_index = 1;
        int sum = 1; // 첫번째 sum은 1로 초기화

        while (end_index != N) {
            if(sum == N){ // 현재연속 합이 N과 같은 경우
                count++; // count 값 증가
                end_index++; // end_index 확장 후 sum에 더해줌
                sum = sum + end_index;
            } else if(sum > N){ // 현재연속 합이 N 보다 더 큰 경우
                sum = sum - start_index; // 기존 start_index를 빼주고 start_index 증가시켜야 함
                start_index++;
            } else{ // sum < N : 현재연속 합이 N 보다 작은 경우
                end_index++;
                sum = sum + end_index;
            }
        }
        System.out.println(count);
        sc.close();
    }
}