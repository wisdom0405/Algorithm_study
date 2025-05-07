import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수의 개수
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i=0; i<N; i++){
            numbers.add(Integer.parseInt(br.readLine()));
        }

        numbers.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (int num : numbers){
            sb.append(num + "\n");
        }
        System.out.println(sb);
    }
}
