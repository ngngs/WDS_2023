import java.util.Arrays;

public class day34_gs {
    // 배열 내 각 문자열 길이
    public int[] solution(String[] strlist) {
        int[] answer = Arrays.stream(strlist).mapToInt(String::length).toArray();
        
        return answer;
    }

    // 배열 정렬 후, 중앙값 구하기
    public int solution2(int[] array) {
        
        int midIndex = (int) array.length / 2;
        
        Arrays.sort(array);
        
        int answer = array[midIndex];
        
        return answer;
    }

    // 배열[i:j] 까지 자르기
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = Arrays.copyOfRange(numbers, num1, num2+1);
        return answer;
    }
}
