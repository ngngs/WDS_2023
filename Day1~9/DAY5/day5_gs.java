// 좋은 코드란?
// 1. 정확도 : 예상 가능 혹은 불가능한 입력에 대해서 정확히 동작할 수 있어야한다.
// 2. 효율성 : 시간과 공간 모두 효율적이어야한다. 흔히 O표기법을 고려한 점근적 효율성만 고려하지만 실생활에서 상수 인자는 굉장히 중요하다.
// 3. 간략화 : 코드 100줄을 10줄로 줄일 수 있다면 좋은 코드다.
// 4. 가독성 : 다른 개발자도 읽을 수 있어야한다.
// 5. 관리가능성 : 제품의 수명동안 수정 가능해야한다.

// 모듈화?
// 모듈화된 코드를 작성하는 것은 관계 없는 코드들을 별도 메소드로 나누는 것을 의미한다.
// 정수 배열의 최솟값과 최댓값 원소를 바꾸는 코드를 작성하라
void swapMinMax(int[] array) {
    int minIndex = 0;
    for (int i = 1; i < array.length; i++){
        if (array[i] < array[minIndex]){
            minIndex = i;
        }
    }
}

// 모듈화 시켜보자
void swapMinMaxBetter(int[] array){
    int minIndex = getMinIndex(array);
    int maxIndex = getMaxIndex(array);
    swap(array, minIndex, maxIndex);
}

int getMinIndex(int[] array) {...}
int getMaxIndex(int[] array) {...}
void swap(int[] array, int m, int n){...}
