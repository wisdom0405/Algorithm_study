import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> wordSet = new HashSet<>();
        for (int i=0; i<N; i++){
            wordSet.add(br.readLine());
        }

        List<String> words = new ArrayList<>(wordSet);
        words.sort(Comparator
                .comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder())
        );

        StringBuilder sb = new StringBuilder();
        for (String word : words){
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }
}
