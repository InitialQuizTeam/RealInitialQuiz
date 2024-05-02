package src.initialQuizRiin;

import src.AccountManager;
import src.Scores;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameMain {
    public void main(String gameId,int gameScore) {
        Scores scores = new Scores(); // Scores 객체 생성


        Scanner scanner = new Scanner(System.in);
        String[] movies = {"몬스터주식회사", "인터스텔라", "라이언킹", "타이타닉"};
        Random random = new Random();

        System.out.println("드라마/영화 초성 맞추기 게임이 시작됩니다.");
        System.out.println("게임 종료를 원한다면 ✨종료✨라고 입력해주세요");
        System.out.println("3초 후 게임이 시작됩니다\n");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (movies.length > 0) {
            int randomIndex = random.nextInt(movies.length);
            String movie = movies[randomIndex];
            movies = removeElement(movies, randomIndex);

            System.out.println("🍴👧🏻🍴 햇님이 음식 먹을 준비를 합니다");
            System.out.println("냠냠! 🍕🌭🍔🍟🍰 (100% 남았습니다)\n");
            System.out.println("▶ 초성: " + HangulUtils.getChosungString(movie) + "\n");

            if (!playGame(movie, getHint(movie), scanner, scores)) {
                break; // 게임 종료
            }
        }

        System.out.println("\n3초 후 게임이 종료됩니다");
        System.out.println("게임 점수는 SCORE에 기록됩니다");

        System.out.println( gameId + "님 최종 점수 : " + scores.getScore() + "점");
        AccountManager.addScore(gameId, scores.getScore());
        //Langking.LangkingStart(gameId, scores.getScore());

        //scores.FileExample();
    }


    private static boolean playGame(String movie, int[] hint, Scanner scanner, Scores scores) {
        int chances = 5;

        while (chances > 0) {
            System.out.print("⟫⟫ 정답을 입력하세요: ");
            String guess = scanner.nextLine();

            if (guess.equalsIgnoreCase("종료")) {
                return false; // 사용자가 종료 입력
            }

            if (guess.equalsIgnoreCase(movie)) {
                System.out.println("\n✨정답입니다!✨\n");
                scores.increaseScore(); // 점수 증가
                return true; // 정답 맞춤
            } else {
                chances--;
                printHint(hint, chances);
                Sun.eatSnack(); //햇님이 간식을 냠냠
            }
        }

        System.out.println("\n================================");
        System.out.println("🥲햇님이 음식을 다 먹어버렸습니다🥲\n정답은 '" + movie + "'입니다.");
        System.out.println("================================\n");
        return false;
    }

    private static void printHint(int[] hint, int remainingChances) {
        System.out.print("\n⚠️틀렸습니다!⚠️\n힌트: ");
        for (int i = 0; i < 5 - remainingChances; i++) {
            System.out.print(Character.toChars(hint[i]));
        }
        System.out.println(" (기회 남은 횟수: " + remainingChances + ")");
    }

    private static int[] getHint(String movie) {
        switch (movie) {
            case "몬스터주식회사":
                return new int[]{0x1F303, 0x1F479, 0x1F9F0, 0x1F631, 0x1F469};
            case "인터스텔라":
                return new int[]{0x1F680, 0x1F30C, 0x1F52D, 0x23F3, 0x1F468, 0x200D, 0x1F680};
            case "라이언킹":
                return new int[]{0x1F981, 0x1F451, 0x1F305, 0x1F43E, 0x1F3B6};
            case "타이타닉":
                return new int[]{0x1F6A2, 0x2764, 0xFE0F, 0x1F30A, 0x2744, 0xFE0F, 0x1F3A4};
            default:
                return new int[]{};
        }
    }

    private static String[] removeElement(String[] array, int index) {
        String[] newArray = new String[array.length - 1];
        for (int i = 0, k = 0; i < array.length; i++) {
            if (i == index) {
                continue;
            }
            newArray[k++] = array[i];
        }
        return newArray;
    }
}
