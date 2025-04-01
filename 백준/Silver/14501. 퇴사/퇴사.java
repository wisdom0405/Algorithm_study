import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // D[i] = i일째부터 N+1일째까지 벌 수 있는 최대금액
        int[] D = new int[N+2]; // 1부터 시작 (1~N+1) , N+1일 퇴사일
        int[] T = new int[N+1]; // 1부터 시작
        int[] P = new int[N+1]; // 1부터 시작

        // 스케쥴 표 입력받기
        StringTokenizer st;
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken()); // i일 째 업무 소요일수
            P[i] = Integer.parseInt(st.nextToken()); // i일 째 업무 금액
        }

        D[N+1] = 0; // 퇴사일에는 일을 시작할 수 없음
        for(int i=N; i>0; i--){
            if (T[i] + i > N + 1){ // 오늘 업무수행 시 퇴사일자를 넘어간다면
                D[i] = D[i+1]; // 최대로 벌 수 있는 금액은 다음날과 동일
                continue;
            }

            // D[i+1] : 오늘 업무 선택안하고 다음날 업무 선택할 건지
            // P[i] + D[i+T[i]] : 오늘 업무선택(업무금액) + 오늘상담 일정 끝난 후 다음날부터 벌 수 있는 최대금액
            D[i] = Math.max(D[i+1], P[i] + D[i+T[i]]);
        }

        System.out.println(D[1]);
    }
}
