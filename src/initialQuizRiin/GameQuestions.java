package src.initialQuizRiin;

public class GameQuestions {
    // 게임 문제들을 저장하는 배열
    public static String[][] questions = {
            {"몬스터주식회사", "인터스텔라", "라이온킹", "타이타닉"}
    };

    // 각 문제에 대한 힌트들을 저장하는 배열
    public static int[][] hints = {
            {0x1F303, 0x1F479, 0x1F9F0, 0x1F631, 0x1F469},
            {0x1F680, 0x1F30C, 0x1F52D, 0x23F3, 0x1F468, 0x200D, 0x1F680},
            {0x1F981, 0x1F451, 0x1F305, 0x1F43E, 0x1F3B6},
            {0x1F6A2, 0x2764, 0xFE0F, 0x1F30A, 0x2744, 0xFE0F, 0x1F3A4}
    };

    public static String[][] getQuestions() {
        return questions;
    }

    public static int[][] getHints() {
        return hints;
    }
}
