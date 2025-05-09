import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의 수

        StringTokenizer st;
        PriorityQueue<Discussion> pq = new PriorityQueue<>();
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken()); // 회의 시작시간
            int endTime = Integer.parseInt(st.nextToken()); // 회의 끝나는 시간
            pq.add(new Discussion(startTime, endTime));
        }

        int lastEndTime = 0;
        int count = 0;
        while (!pq.isEmpty()){
            Discussion now = pq.poll();

            if (now.startTime < lastEndTime) continue;

            count++;
            lastEndTime = now.endTime;
        }
        System.out.println(count);
    }
}
class Discussion implements Comparable<Discussion>{
    int startTime; // 회의 시작시간
    int endTime; // 회의 끝나는 시간

    Discussion(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Discussion o) {
        if (this.endTime == o.endTime){
            // 끝나는 시간이 동일하다면 시작시간 오름차순 정렬
            return this.startTime - o.startTime;
        }else {
            // 끝나는 시간 오름차순 정렬 (빨리 끝나는 것)
            return this.endTime - o.endTime;
        }
    }
}
