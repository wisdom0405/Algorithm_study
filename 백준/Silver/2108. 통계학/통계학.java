import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        int[] count = new int[8001]; // -4000 ~ 4000 -> +4000 shift
        int sum = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers[i] = num;
            sum += num;
            count[num + 4000]++;

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        Arrays.sort(numbers);

        // 산술평균 (반올림)
        int mean = (int) Math.round((double) sum / N);

        // 중앙값
        int median = numbers[N / 2];

        // 최빈값
        int maxFreq = 0;
        for (int freq : count) {
            maxFreq = Math.max(maxFreq, freq);
        }

        List<Integer> modes = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxFreq) {
                modes.add(i - 4000);
            }
        }
        Collections.sort(modes);
        int mode = (modes.size() > 1) ? modes.get(1) : modes.get(0);

        // 범위
        int range = max - min;

        // 출력
        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}
