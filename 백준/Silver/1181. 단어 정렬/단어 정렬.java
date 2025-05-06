import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<String> words = new ArrayList<>();
        for (int i=0; i<N; i++){
            String word = br.readLine();
            if (words.contains(word)) continue; // 이미 있는 단어라면 건너뛰기

            words.add(word);
        }

        words.sort(Comparator.comparingInt(String::length)
                .thenComparing(w -> w)
        );

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<words.size(); i++){
            sb.append(words.get(i)+"\n");
        }
        System.out.println(sb);
    }
}
