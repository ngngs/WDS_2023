public class day17_gs {
    public static String main(String[] args) {
        // 문제
        /*
         * 가장 긴 단어 : 주어진 단어 리스트에서 다른 단어들을 조합하여 만들 수 있는 가장 긴 단어를 찾는 프로그램을 작성하라
         * 예) cat, banana, dog, nana, walk, walker, dogwalker
         * 정답 : dogwalker
         */

         String printLongestWord(String arr[]){
            HashMap<String, Boolean> map = new HashMap<String, Boolean>();
            for (String str : arr){
                map.put(str, true);
            }
            Array.sort(arr, new LengthComparator());
            for (String s : arr){
                if(canBuildWord(s, true, map)) {
                    System.out.println(s);
                    return s;
                }
            }
            return "";
        }

        // 문제
        /*
         * 사전에 등장하는 길이가 같은 단어 두 개가 주어졌을 때, 한 번에
         * 글자 하나만 바꾸어 한 단어를 다른 단어로 변환하는 메서드를 작성하라.
         * 변환 과정에서 만들어지는 각 단어도 사전에 있는 단어여야한다.
         */
        // 예 : DAMP, LIKE
        // 답 : DAMP -> LAMP -> LIMP -> LIME -> LIKE
        // 답지 : 773쪽 참고
        // 요약 : 무식한 방법->최적화시켜나가는게 중요함


        // 문제
        /*
        * 최대 부분행렬 : 양의 정수와 음의 정수로 이루어진 N*N 행렬이 주어졌을 때, 모든 원소의 합이 최대가 되는 부분행렬을 찾아라
        */

        // 답지 : 783쪽참고
        // 무식한 방법(O(N^6))
        // 동적계획법(O(N^4))
        // 최적화해법(O(N^3))
    }
}
