import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 내림차순 우선순위 큐

        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (N-->0){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num == 0){ // 아이들을 만났을 경우
                if (!pq.isEmpty()){
                    bw.write(pq.poll() + "\n");
                }else{
                    bw.write(-1 + "\n");
                }
            }else{ // 선물충전 거점지일 경우
                while (num-->0){ 
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
