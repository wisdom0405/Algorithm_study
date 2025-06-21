import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        while (N-->0){
            set.add(br.readLine());
        }

        int count = 0;
        while (M-->0){
            String word = br.readLine();
            if (set.contains(word)){
                count++;
            }
        }

        System.out.println(count);
    }
}
