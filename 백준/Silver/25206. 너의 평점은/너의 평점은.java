import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double getCredit = 0.0;
        double getScore = 0.0;

        for (int i=0; i<20; i++){
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken(); // 과목
            double credit = Double.parseDouble(st.nextToken()); // 학점
            String degree = st.nextToken();

            double score = calcScore(degree);
            if (score != -1.0){
                getCredit += credit;
                getScore += credit * score;
            }
        }

        double result = getScore / getCredit;
        System.out.printf("%.6f", result);
    }
    private static double calcScore (String degree){
        switch (degree) {
            case "A+":
                return 4.5;

            case "A0":
                return 4.0;

            case "B+":
                return 3.5;

            case "B0":
                return 3.0;

            case "C+":
                return 2.5;

            case "C0":
                return 2.0;

            case "D+":
                return 1.5;

            case "D0":
                return 1.0;

            case "F":
                return 0.0;

            default: // P/F 과목인 경우 학점계산 X
                return -1.0;
        }

    }
}
