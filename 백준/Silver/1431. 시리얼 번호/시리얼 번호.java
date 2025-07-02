import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<String> guitars = new ArrayList<>();
        while (N-- > 0) {
            String serialNum = br.readLine();
            guitars.add(serialNum);
        }

        guitars.sort((A, B) -> {
                    if (A.length() != B.length()) { // 길이 다르면 길이 오름차 순
                        return A.length() - B.length();
                    } else { // 길이 같으면 숫자 자리수 합 오름차순
                        int sumA = 0;
                        int sumB = 0;

                        // 문자열에서 숫자만 각 자리수 더한 합
                        for (int i = 0; i < A.length(); i++) {
                            char charA = A.charAt(i);
                            char charB = B.charAt(i);

                            if (Character.isDigit(charA)) {
                                sumA += charA - '0';
                            }

                            if (Character.isDigit(charB)) {
                                sumB += charB - '0';
                            }
                        }

                        if (sumA == sumB) {
                            return A.compareTo(B);
                        }
                        return sumA - sumB;
                    }
                }
        );

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (String serial : guitars){
            bw.write(serial + "\n");
        }

        bw.flush();
        bw.close();
    }
}
