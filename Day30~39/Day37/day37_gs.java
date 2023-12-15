public class day37_gs {
    
    // String -> int (Interger.parseInt())
    // int -> String (Integer.toString())
    public int solution(String n_str) {
        int answer = 0;
        answer = Integer.parseInt(n_str);
        return answer;
    }


    // 대문자 변환(toUpperCase)
    // 소문자 변환(toLowerCase)
    public String solution2(String myString) {
        String answer = myString.toUpperCase();
        return answer;
    }

    // 문자열 곱하기(String.repeat)
    public String solution3(String my_string, int k) {
        String answer = "";
        
        answer = my_string.repeat(k);
        
        return answer;
    }
}
