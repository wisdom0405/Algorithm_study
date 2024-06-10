import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[array.length];
        int[] commands_array = new int[array.length]; // command 배열 실행 후 결과값들어가는 배열

        for(int i = 0; i < commands.length; i++){
            int start = commands[i][0] - 1; //command 1번째 : 잘라야하는 start index
            int end = commands[i][1]; //command 2번째 : 잘라야하는 end index
            int n = commands[i][2] - 1; // 정렬 후 k번째에 있는 수

            commands_array = Arrays.copyOfRange(array, start, end); // 배열 잘라서 넣기
            Arrays.sort(commands_array);
            answer[i] = commands_array[n];
            answer = Arrays.copyOf(answer,commands.length);
        }

        return answer;
    }
}
