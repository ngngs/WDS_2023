public class day18_gs {
    public static void main(String[] args) {
        // 01 배열과 문자열 해법

        /*
         * 문제3. 문자열에 들어 있는 모든 공백을 '%20'으로 바꾸는 메서드를 작성하라
         * 최종적으로 모든 문자를 담을 수 있을 만큼 충분한 공간이 이미 확보되어있다.
         * 문자열의 최종 길이가 함께 주어진다고 가정해도 된다.
         */

        private void replaceSpaces(char[] str, int trueLength){
            int spaceCount = 0, index, i = 0;
            for (i = 0; i < trueLength; i++){
                if (str[i] == ' ') {
                    spaceCount++;
                }
            }
            index = trueLength + spaceCount * 2;
            if (trueLength < str.length) str[trueLegnth] = '\0';
            for (i = trueLength - 1; i >= 0; i--){
                if (str[i] == ' '){
                    str[index-1] = '0';
                    str[index-2] = '2';
                    str[index-3] = '%';
                    index = index - 3;
                } else {
                    str[index - 1] = str[i];
                    index--;
                }
            }
        }
    }
}
