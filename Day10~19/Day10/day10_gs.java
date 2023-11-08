// 6. 수학 및 논리 퍼즐

// 소수 판별 : 에라토스테네스의 체
// 처음 주어진 리스트는 1부터 max까지의 모든 수로 구성되어 있다
// 처음에는 2로 나누어지는 모든 수를 리스트에서 지운다
// 그 후 다음 소수로 나누어지는 모든 리스트를 제거하며 max까지 구간 내 모든 소수들의 리스트를 만든다

boolean[] sieveOfEratosthenes(int max){
    boolean[] flags = new boolean[max + 1];
    int conut = 0;

    init(flags); // 0과 1번 인덱스를 제외한 모든 원소값을 true로 초기화
    int prime = 2;

    while (prime <= Math.sqrt(max)) {
        /* prime의 배수들을 지워나간다 */
        crossOff(flags, prime);

        /* 그다음 true로 세팅된 인덱스를 찾는다 */
        prime = getNextPrime(flags, prime);
    }

    return flags;
}

void crossOff(boolean[] flags, int prime){
    /* prime의 배수들을 지우되, 이전 루프에서 이미 지워졌을 것이므로 prime * prime부터 시작 */
    for (int i = prime * prime; i < flags.length; i += prime){
        flags[i] = false;
    }
}

int getNextPrime(boolean[] flags, int prime) {
    int next = prime + 1;
    while (next < flags.length && !flags[next]) {
        next++;
    }
    return next;
}


// ###################################################

// 문제6-1. 약병 20개에는 알약이 충분히 들어있다. 이 중 19개에는 1.0그램 알약이, 1개에는 1.1그램 알약이 들어있다.
// 정확한 저울 하나가 주어질 때, 무거운 알약이 들어있는 약병을 찾는 방법은? 저울은 딱 한 번 사용가능하다.

// 답 : 1번부터 20번까지 약병을 세우고, 번호에 맞게 약병에서 알약을 꺼낸다.
// 예를 들어, 1번에서 1개, 2번에서 2개
// 총 무게는 (1+2+3+...+19+20) 의 무게중 초과하는 무게 만큼의 번호가 나온 약병이 답이다.

// ####################################################

// 문제6-5. 5리터 물병과, 3리터 물병, 그리고 물이 무제한으로 주어질 때 이 물병 두 개를 사용해 정확히 4리터를 구하라
// 단, 물병의 형태가 괴상해서 정확히 절반만 담는 건 불가능하다