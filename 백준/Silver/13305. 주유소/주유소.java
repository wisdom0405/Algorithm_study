import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 도시 사이의 거리 저장
        int[] distance = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N-1; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }

        // 도시 별 주유소 리터당 가격 저장
        int[] price = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        long min = Integer.MAX_VALUE;
        long totalPrice = 0;
        for (int i=0; i<N-1; i++){
            min = Math.min(min, price[i]);
            totalPrice += min * distance[i];
        }

        System.out.println(totalPrice);
    }
}
