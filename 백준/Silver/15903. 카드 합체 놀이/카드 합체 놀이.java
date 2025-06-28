import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 카드개수
        int M = Integer.parseInt(st.nextToken()); // 카드합체 횟수

        PriorityQueue<Long> pq = new PriorityQueue<>();

        // 카드 정보입력받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            pq.offer(Long.parseLong(st.nextToken()));
        }

        while (M-- > 0){
            long x = pq.poll();
            long y = pq.poll();
            long sum = x + y;

            pq.offer(sum);
            pq.offer(sum);
        }

        long result = 0;
        while (!pq.isEmpty()){
            result += pq.poll();
        }

        System.out.println(result);
    }
}
