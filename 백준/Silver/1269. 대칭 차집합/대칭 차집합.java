import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Asize = Integer.parseInt(st.nextToken());
        int Bsize = Integer.parseInt(st.nextToken());

        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<Asize; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;
        int num = 0;
        for (int i=0; i<Bsize; i++) {
            num = Integer.parseInt(st.nextToken());
            if (A.contains(num)) count++;
        }

        int result = (Asize - count) + (Bsize - count);
        System.out.println(result);

    }
}
