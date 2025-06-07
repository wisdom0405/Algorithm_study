import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        while (K-->0){
            int num = sc.nextInt();
            if (num == 0){
                stack.pop();
            }else{
                stack.push(num);
            }
        }

        int result = 0;
        while (!stack.isEmpty()){
            result += stack.pop();
        }

        System.out.println(result);
    }
}
