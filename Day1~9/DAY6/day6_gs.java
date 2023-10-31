// 문제. 중복이없는가?
// 문제. 문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는 지 확인하는 알고리즘을 작성하라.
// 이어서) 자료구조를 추가로 사용하지 않고 풀 수 있는 알고리즘 또한 고민하라.

/*
 * 나의 추측
 * 1. 문자열 길이가 N이라고 가정한다면 해시구조를 만들어서(공간 복잡도 O(N))
 * for 문을 한 번 다 돌면(시간복잡도O(N)) 문제를 풀 수 있다.
 * 
 * 2. 자료 구조를 추가하지 않고...? 잘 생각이 안난다 
 */

 /*
  * 정답
  * 1. 먼저, 문자가 아스키 코드인지, 유니코드인지 확인해야한다. (만약 유니코드라면 아스키 코드에 비해 더욱 많은 공간이 필요하다)
  * 아스키 코드라고 가정한다면, 길이는 256의 배열을 만들고(공간복잡도 O(1)) 전체 문자를 순회(시간복잡도 O(N))으로 풀 수 있다
  */

  boolean isUniqueChars(String str) {
    if (str.length() > 128) return false;
    boolean[] char_set = new boolean[128];
    for (int i = 0; i < str.length(); i++){
        int val = str.charAt(i);
        if (char_set){
            return false;
        }
        char_set[val] = true;
    }

    return true;
  }

  /*
   * 2번 풀이. 자료구조를 추가하지 않고 푸는법?
   * 간단함. for 문을 2중으로 돌면 됨(시간복잡도 O(N^2))
   */