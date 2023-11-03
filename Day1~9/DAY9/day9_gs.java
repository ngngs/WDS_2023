// 비트 조작

// 다음 문제를 풀어보자

0110 + 0010

0110 * 0101

0110 + 0110

0011 + 0010

0011 * 0011

0100 * 0011

0110 - 0011

1101 >> 2

1101 ^ (~1101)

1000 - 0110

1101 ^ 0101

1011 & (~0 << 2)

// 정답(위에서 아래로)
1000
1111
1100
0101
1001
1100
0011
0011
1111
0010
1000
1000

// 0110 + 0110은 0110 * 2와 같다. 즉, 0110을 왼쪽으로 한 번 시프트한다.
// 0100은 4와 같고, 4를 곱하는 것은 왼쪽으로 두 번 시프트하는 것과 같다.
// 0011을 왼쪽으로 두 번 시프트하면 1100이 ㅗ딘다.


// 문제2. 2진수를 문자열로
// 0.72와 같이 0과 1 사이의 실수가 double 타입으로 주어졌을 때, 그 값을 2진수 형태로 출력하는 코드를 작성하라.
// 길이가 32 이하인 문자열로 2진수로 정확하게 표현할 수 없다면 Error를 출력
String printBinary(double num){
    if (num >= 1 || num <= 0){
        return "ERROR"
    }

    StringBuilder binary = new StringBuilder();
    binary.append(".");
    while(num > 0){
        if (binary.length() >= 32){
            return "ERROR";
        }

        double r = num * 2;
        if (r >= 1){
            binary.append(1);
            num = r - 1;
        } else {
            binary.append(0);
            num = r;
        }
    }
    return binary.toString();
}