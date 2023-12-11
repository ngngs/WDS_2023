import java.util.Arrays;

public class day35_gs {

    // 배열 내 각 원소를 2배
    public int[] solution(int[] numbers) {
        int[] answer = Arrays.stream(numbers)
                        .map(x -> x*2)
                        .toArray();
    
        return answer;
    }

    // 특정 문자열 제거하기
    public String solution(String my_string, String letter) {
        String answer = my_string.replaceAll(letter, "");
        return answer;
    }

    // 숫자 여부 확인(Character.isDigit), 문자를 숫자로 변환(Character.getNumericValue)
    public int solution(String my_string) {
        int answer = 0;
        
        for (int i=0; i < my_string.length(); i++) {
            char alpha = my_string.charAt(i);
            if (Character.isDigit(alpha)){
                answer += Character.getNumericValue(alpha);
            }
        }
        
        return answer;
    }
}
