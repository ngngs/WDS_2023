import java.util.Arrays;

public class day39_gs {
    class Solution {

        // char 형태의 경우 ""로 할 경우 다음과 같은 에러발생
        // java:11: error: bad operand types for binary operator '=='
        class Solution {
            public int solution1(int n, String control) {
                int answer = 0;
                
                for (int i=0; i<control.length(); i++){
                    char command = control.charAt(i);
                    if (command == 'w'){
                        answer += 1;
                    } else if (command == 's'){
                        answer -= 1;
                    } else if (command == 'd'){
                        answer += 10;
                    } else {
                        answer -= 10;
                    }
                }
                
                return answer;
            }
        }

        // 자바 배열 원소 합(Arrays.stream(배열).sum())
        class Solution {
            public int solution2(int[] arr1, int[] arr2) {
                int answer = 0;
                
                if (arr1.length != arr2.length){
                    return arr1.length > arr2.length ? 1 : -1;
                } else {
                    int arr1Sum = Arrays.stream(arr1).sum();
                    int arr2Sum = Arrays.stream(arr2).sum();
                    
                    if (arr1Sum == arr2Sum) return 0;
                    else return arr1Sum > arr2Sum ? 1 : -1;
                }
        

            }
        }
    
    }
}
