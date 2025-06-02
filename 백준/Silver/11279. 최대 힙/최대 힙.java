import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 연산의 수
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 내림차순 우선순위 큐

        while (N-->0){
            int X = Integer.parseInt(br.readLine());
            if (X == 0){
                if (!pq.isEmpty()){ // 큐가 비어있지 않다면 최댓값 출력
                    bw.write(pq.poll() + "\n");
                }else{ // 큐가 비어있다면 0 출력
                    bw.write(0 + "\n");
                }
            }else{ // 그 외에는 큐에 정수 넣기
                pq.offer(X);
            }
        }

        bw.flush();
        bw.close();
    }
}
