import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

class day33_gs {

    class Solution {
        // 배열 평균구하기
        public double solution(int[] numbers) {
            double answer = Arrays.stream(numbers).average().orElse(0.0);
            return answer;
        }

        // 배열 내 filter 갯수 구하기(count)
        public int solution2(int[] array, int height) {
            int answer = (int) Arrays.stream(array)
                            .filter(x -> x > height)
                            .count();
            
            return answer;
        }

        // 배열 뒤집기
        public int[] solution3(int[] numList) {
            List<Integer> list = Arrays.stream(numList).boxed().collect(Collectors.toList());
    
            Collections.reverse(list);
            
            int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
            
            return answer;
        }
    }
}