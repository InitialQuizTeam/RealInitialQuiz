package src.initialQuizRiin;

public class HangulUtils {
    private static final char[] INITIALS = {
            'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
    };

    public static char getChosung(char ch) {
        if (ch >= '가' && ch <= '힣') {
            int index = (ch - '가') / 588;
            return INITIALS[index];
        } else {
            return ch;
        }
    }

    public static String getChosungString(String str) {
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            result.append(getChosung(ch));
        }
        return result.toString();
    }
}
