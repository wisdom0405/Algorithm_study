import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        int quadrant = 0;

        if (x > 0 && y > 0){
            quadrant = 1;
        }else if(x > 0 && y < 0){
            quadrant = 4;
        } else if (x < 0 && y > 0) {
            quadrant = 2;
        }else {
            quadrant = 3;
        }

        System.out.println(quadrant);

    }
}
