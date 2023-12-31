import java.util.LinkedList;

public class day16_gs {
    public static string main(String[] args) {
        
        // 정수를 영어로
        /*
         * 정수가 주어졌을 때 영어로 표현해주는 프로그램을 작성하라
         * 예를 들어, 1,000이 입력되면 "One Thousand", 234가 입력되면 "Two Hundred Thirty Four"를 출력하라
         */

        String[] smalls = {"Zero", "One", "Two", "Three", "Four", 
        "Five", "Six", "Seven", "Eight", "Nine", 
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", 
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        String tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String bigs = {"", "Thousand", "Million", "Billion"};
        String hundred = "Hundred";
        String negative = "Negative";

        String convert(int num){
            if (num == 0) {
                return smalls[0];
            } else if (num < 0){
                return negative + " " + convert(-1*num);
            }

            LinkedList<String> parts = new LinkedList<String>();
            int chunkCount = 0;

            while(num>0){
                if (num % 1000 != 0){
                    String chunk = convertChunk(num % 1000) + " " + bigs[chunkCount];
                    parts.addFirst(chunk);
                }
                num /= 1000;
                chunkCount++;
            }

            return listToString(parts);
        }

        
    }
}
