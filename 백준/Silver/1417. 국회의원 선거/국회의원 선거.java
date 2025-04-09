import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 후보 수

        // 단일후보라면 매수안해도 되므로 0출력 후 종료
        if (N==1){
            System.out.println(0);
            return;
        }

        int dasom = Integer.parseInt(br.readLine()); // 다솜이 득표 수

        // 내림차순 우선순위 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b-a);

        // 다른사람 득표 수 큐에 넣기
        for(int i=1; i<N; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }

        // 매수해야 하는 인원 수
        int count = 0;

        while (!queue.isEmpty()){
            int others = queue.poll(); // 다른후보 득표 수
            if (others >= dasom){ // 다솜이 득표보다 크거나 같다면
                dasom++; // 다솜 득표수 1표 올리고
                count++; // 매수인원 증가
                queue.add(others-1); // 다른후보 득표수 1감소 후 다시 큐에 넣기
            }
        }

        System.out.println(count);
    }
}
