import java.util.stream.IntStream;

public class day38_gs {
    // String.substring(n) : n부터 출력
    // String.substring(n, m) : n부터 m까지
    public String solution(String my_string, int n) {
        String answer = my_string.substring(my_string.length()-n);
        return answer;
    }

    // 문자열 바꾸기(replaceAll)
    class Solution {
        public String solution2(String rny_string) {
            String answer = "";
            
            answer = rny_string.replaceAll("m", "rn");
            
            return answer;
        }
    }

    // 배열 내에 특정 값이 존재하는 지 여부
    class Solution {
        public int solution(int[] numList, int n) {
            return IntStream.of(numList).anyMatch(num -> num == n) ? 1 : 0;
    }
}
}
