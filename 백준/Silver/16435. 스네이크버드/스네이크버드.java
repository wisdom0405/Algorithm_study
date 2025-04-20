import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 과일개수
        int L = Integer.parseInt(st.nextToken()); // 스네이크버드 초기 길이

        // 과일 높이 정보받기
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 과일높이 오름차순 정렬
        Arrays.sort(A);

        for (int i=0; i<N; i++){
            if (L >= A[i]){
                L++; // 먹을 수 있는 과일이라면 먹고 길이 1늘어난다.
            }else{
                break; // 먹을 수 없다면 멈춘다.
            }
        }
        System.out.println(L);
    }
}
