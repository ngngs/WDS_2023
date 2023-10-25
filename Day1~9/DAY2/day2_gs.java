// 1번 문제
// 아래 코드의 시간 복잡도는?
class Solution {
    public void foo(int[] array) {
        int sum = 0;
        int product = 1;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        for (int i = 0; i < array.legnth; i++){
            product *= array[i];
        }
        System.out.println(sum + ", " + product);
    }
}

// 정답 : array의 길이가 n이라고 가정할 때, 시간복잡도는 O(N)


// ##################################################

// 4번 문제
// 서로 다른 배열이 주어질 때, 다음 코드의 시간복잡도는?
class Solution {
    public void printUnorderedParis(int[] arrayA, int{} arrayB) {
        for (int i = 0; i < arrayA.length; i++){
            for (int j = 0; j < arrayB.length; j++){
                if (arrayA[i] < arrayB[j]){
                            System.out.println(arrayA[i] + ", " + arrayB[j]);                    
                }
            }
        }

    }
}

// 정답 : A의 배열의 수가 n개, B의 배열의 수가 m개라면 O(NM)

// ##################################################

// 7번문제
// 다음 중 O(N)과 같은 것은?
// 1번 : O(N+P), P < N/2
// 2번 : O(2N)
// 3번 : O(N+logN)
// 4번 : O(N+M)

// 정답은 4번을 제외한 모두
// 오답으로 3번은 O(N)과 다르다 생각했다. log가 나오면 계산을 잘 못하는 경우가 있는데
// O(N)이 O(logN)보다 지배적인 항이라는 사실을 잊지 말자


// ##################################################
// 10번 문제
// 소수 판별 문제의 시간 복잡도 구하기
class Solution {
    public boolean isPrime(int n){
        for (int x = 2; x * x <= n; x++){
            if (n % x ==0){
                return false;
            }
        }
        return true;
    }
}
// 추론 오류 : 이 문제의 답을 O(N^2)이라고 생각했다. 이유는 N/2까지 N번 곱하기라고 생각했지만 틀렸다
// 정답 : 정답은 O(루트N)이다. 최악의 경우만 고려하면 된다. 최악의 경우 FOR 루프가 몇 번 도는가?
// 루프는 x=2부터 x*x =n까지 반복한다. 즉, x는 루트n (x가 n의 제곱근이 될 떄까지)까지 반복한다
// 따라서 이 코드의 시간복잡도는 O(루트N)