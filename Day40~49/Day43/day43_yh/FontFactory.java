package study.my.java.whiteship.effective_java.chapter01.item01.lecture07;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {

    private static Map<String, Font> cache = new HashMap<>();

    // 2. 자주 변하지 않는 속성들은 FlyweightFactory라는 곳에 따로 모아놓음.
    public static Font getFont(String font){
        if(cache.containsKey(font)){ // (1) 만약 캐싱된 값이 있으면 그걸 리턴
            return cache.get(font);
        }else{ // (2) 캐싱된 값이 없으면 새로 만들어서(new Font) 리턴
            String[] split = font.split(":");
            Font newFont = new Font(split[0], Integer.parseInt(split[1]));
            cache.put(font, newFont);
            return newFont;
        }
    }
}
