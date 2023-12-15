import java.util.Arrays;
import java.util.List;

public class day36_gs {
    public String solution(String my_string) {
        String answer = "";
        List<String> vowel = {"a", "e", "i", "o", "u"};

        for (String v : vowel){
            answer = answer.replaceAll(v, "");
        }

        return answer;
    }

    // 자바에서 배열 인덱스[-1] 을 할 경우 ArrayIndexOutOfBoundsException(배열 인덱스가 범위를 벗어남)과 같은 예외가 발생
    public int solution(int[] numbers) {
        int answer = 0;
        
        Arrays.sort(numbers);
            
        answer= numbers[numbers.length-1] * numbers[numbers.length-2];
        return answer;
    }

    // String.contains(String)
    public String solution(String[] str_list, String ex) {
        String answer = "";
        
        for (int i = 0; i < str_list.length; i++) {
            if (!str_list[i].contains(ex)) {
                answer += str_list[i];
            }
        }
        return answer;
    }
}
