import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] infix = br.readLine().toCharArray();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<infix.length; i++){
            char ch = infix[i];
            if (ch >= 65){ // 현재 문자가 알파벳이면 바로 출력
                bw.write(ch);
            }else{
                if(ch == '('){ // 열린괄호 나오면 무조건 push
                    stack.push(ch);
                } else if (ch == ')') { // 닫힌괄호 나오면 열린괄호 나올 때까지 pop해줌
                    while (!stack.isEmpty() && stack.peek() != '('){
                        bw.write(stack.pop());
                    }
                    stack.pop(); // '(' 버리기
                } else{ // 연산자라면
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(ch)){
                        // 현재문자 우선순위가 top의 우선순위보다 낮거나 같다면 pop
                        bw.write(stack.pop());
                    }
                    stack.push(ch);
                }
            }
        }
        
        // 스택에 남은 연산자들 pop
        while (!stack.isEmpty()){
            bw.write(stack.pop());
        }

        bw.flush();
        bw.close();
    }

    private static int priority(char ch){
        switch (ch){
            case '*': case '/': return 2;
            case '+': case '-': return 1;
            case '(': case ')': return 0;
        }
        return -1; // 잘못된 문자인 경우
    }
}
