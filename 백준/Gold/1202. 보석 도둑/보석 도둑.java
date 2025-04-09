import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        Jewel[] jewels = new Jewel[N];
        int[] bags = new int[K];

        // 보석 정보 입력받기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(weight, price);
        }

        // 가방정보 입력받기
        for(int i=0; i<K; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 보석, 가방 무게기준 오름차 순
        Arrays.sort(jewels);
        Arrays.sort(bags);

        // 가격 기준 내림차순 정렬 우선순위 큐 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long totalPrice = 0;
        int jewelIndex = 0;

        for(int i=0; i<K; i++){
            // 현재 가방이 담을 수 있는 최대 무게
            int bagCapacity = bags[i];

            // 현재 가방에 들어갈 수 있는 보석들 PQ에 추가
            while (jewelIndex < N && jewels[jewelIndex].weight <= bagCapacity){
                pq.offer(jewels[jewelIndex].price); // 보석 가격 추가
                jewelIndex++;
            }

            // 가장 비싼 보석 하나 선택
            if (!pq.isEmpty()){
                totalPrice += pq.poll();
            }
        }
        System.out.println(totalPrice);
    }
}
class Jewel implements Comparable<Jewel> {
    int weight;
    int price;

    public Jewel(int weight, int price){
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewel o) {
        return this.weight - o.weight; // 무게 오름차 순
    }
}
