import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean isLeapYear = false;

        if (n % 4 == 0){
            if (n%100 != 0 || n%400 == 0){
                isLeapYear = true;
            }
        }

        System.out.println(isLeapYear ? 1 : 0);
    }
}
