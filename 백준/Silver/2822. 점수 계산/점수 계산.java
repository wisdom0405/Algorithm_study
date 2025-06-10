import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<int[]> scoreList = new ArrayList<>();

        for (int i=1; i<9; i++){
            int score = Integer.parseInt(br.readLine());
            scoreList.add(new int[] {i, score}); // i번째 퀴즈, score점
        }

        // 두번 째 요소 기준 내림차 순
        Collections.sort(scoreList, (a,b) -> Integer.compare(b[1], a[1]));

        int sum = 0;
        for (int i=0; i<5; i++){
            sum += scoreList.get(i)[1];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sum + "\n");

        int[] quizeNum = new int[5];

        for (int i=0; i<5; i++){
            quizeNum[i] = scoreList.get(i)[0];
        }

        Arrays.sort(quizeNum);

        for (int i=0; i<5; i++){
            bw.write(quizeNum[i] + " ");
        }

        bw.flush();
        bw.close();

    }
}
