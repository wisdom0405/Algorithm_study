import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 학생의 수 N명
        StringTokenizer st;
        ArrayList<Score> scoreList = new ArrayList<>();

        while (N-->0){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            scoreList.add(new Score(name, korean, english,math));
        }

        scoreList.sort(
                Comparator.comparingInt(Score::getKorean).reversed()
                        .thenComparingInt(Score::getEnglish)
                        .thenComparing((a, b) -> Integer.compare(b.getMath(), a.getMath())) // 수학점수 내림차순 직접 구현
                        .thenComparing(Score::getName)
        );

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Score s : scoreList){
            bw.write(s.getName() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
class Score{
    String name;
    int korean;
    int english;
    int math;

    public Score(String name, int korean, int english, int math){
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
    public String getName(){
        return this.name;
    }
    public int getKorean(){
        return this.korean;
    }
    public int getEnglish(){
        return this.english;
    }
    public int getMath(){
        return this.math;
    }
}
