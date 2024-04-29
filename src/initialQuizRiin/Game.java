package src.initialQuizRiin;

import java.util.Scanner;

public class Game {
    private String title;
    private int[] hint;

    public Game(String title, int[] hint) {
        this.title = title;
        this.hint = hint;

    }

    public void play(Scanner scanner) {
        int chances = 5; // 총 기회 횟수
        String initial = HangulUtils.getChosungString(title); // 초성 추출

        System.out.println("▶ 초성: " + initial + "\n");

        while (chances > 0) {
            System.out.print("정답을 입력하세요: ");
            String guess = scanner.nextLine();

            if (guess.equals(title)) {
                System.out.println("\n✨정답입니다!✨\n");
                return; // 정답을 맞췄으므로 종료
            } else {
                chances--;
                printHint(chances);
            }
        }

        System.out.println("\n기회를 모두 사용하셨습니다.\n정답은 '" + title + "'입니다.");
    }

    private void printHint(int remainingChances) {
        System.out.print("틀렸습니다! 힌트: ");

        for (int i = 0; i < 5 - remainingChances; i++) {
            System.out.print(Character.toChars(hint[i]));
        }

        System.out.println(" (기회 남은 횟수: " + remainingChances + ")");
    }

}
