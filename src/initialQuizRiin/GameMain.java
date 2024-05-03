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
        Scores scores = new Scores(gameScore); // Scores 객체 생성
        Scanner scanner = new Scanner(System.in);
//👻 영화 및 드라마 목록 리스트 배열
        String[] movies = {"몬스터주식회사", "인터스텔라", "라이언킹", "타이타닉", "드림하이", "오징어게임", "사랑의 불시착", "부산행", "그 해 우리는",
                "토이스토리", "더글로리", "이상한 변호사 우영우", "사이코지만 괜찮아", "기생충", "킹덤", "수상한 그녀", "겨울왕국", "도둑들",
                "위대한 쇼맨", "님아 그 강을 건너지 마오", "소년시대", "서울의 봄", "라라랜드", "해리포터", "아바타", "스즈메의 문단속",
                "보헤미안 랩소디", "어바웃 타임", "펜트하우스", "호텔 델루나", "이태원 클라쓰", "별에서 온 그대"};
        Random random = new Random();

        System.out.println("드라마/영화 초성 맞추기 게임이 시작됩니다.");
        System.out.println("게임 종료를 원한다면 ✨종료✨라고 입력해주세요");
        System.out.println("3초 후 게임이 시작됩니다\n");
        System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎︎");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (movies.length > 0) {
            int randomIndex = random.nextInt(movies.length);
            String movie = movies[randomIndex];
            movies = removeElement(movies, randomIndex);

//            System.out.println("🍴👧🏻🍴 햇님이 음식 먹을 준비를 합니다");
//            System.out.println("냠냠! 🍕🌭🍔🍟🍰 (100% 남았습니다)\n");
//            System.out.println("▶ 초성: " + HangulUtils.getChosungString(movie) + "\n");

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
        String[] snacks = {"🍕", "🌭", "🍔", "🍟", "🍰"}; // 햇님의 간식
        while (chances > 0) {
            String eatItem = "";
            for (int i = 0; i < chances; i++) {
                String namnam = snacks[i].toString();
                eatItem+=namnam;
            }
            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎︎");
            System.out.println("☁︎        햇님이 음식 먹을 준비를 합니다");
            System.out.printf("냠냠!🥄👧🏻🥢 %s (음식이 %d %% 남았습니다)\n",eatItem,chances*20);
            System.out.println("▶ 초성: " + HangulUtils.getChosungString(movie) + "\n");

            System.out.print("⟫⟫ 정답을 입력하세요: ");
            String guess = scanner.nextLine();

            if (guess.equalsIgnoreCase("종료")) {
                return false; // 사용자가 종료 입력
            }

            if (guess.equalsIgnoreCase(movie)) {
                System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎︎");
                System.out.println("\n✨정답입니다!✨\n");
                System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎︎");
                scores.increaseScore(); // 점수 증가
                return true; // 정답 맞춤
            } else {
                chances--;
                printHint(hint, chances);
//                Sun.eatSnack(); //햇님이 간식을 냠냠
            }
        }

        System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎︎");
        System.out.println("냠냠!🥄👧🏻🥢 햇님이 음식을 다 먹어버렸습니다\n정답은 '" + movie + "'입니다.");
        System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎︎");
        return false;
    }

    private static void printHint(int[] hint, int remainingChances) {
        System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎︎");
        System.out.print("\n⚠️틀렸습니다!⚠️\n");
        System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎︎");
        System.out.print("힌트: ");

        for (int i = 0; i < 5 - remainingChances; i++) {
            System.out.print(Character.toChars(hint[i]));
        }
        System.out.println(" (기회 남은 횟수: " + remainingChances + ")");
    }

    //👻 힌트 보여주는 메서드
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
            case "드림하이":
                return new int[]{0x1F3A4,0x1F4D8 , 0x1F3A7, 0x1F3B5,0x2B50};
            case "오징어게임":
                return new int[]{0x1F3B2, 0x1F4B0, 0x1F465, 0x1F525, 0x1F480};
            case "사랑의 불시착":
                return new int[]{0x1FA96, 0x2708, 0x1F3DD, 0x1F491, 0x1F525};
            case "부산행":
                return new int[]{0x1F682, 0x1F480, 0x1F3D9, 0x1F9DF, 0x200D, 0x2642, 0xFE0F, 0x1F525};
            case "그 해 우리는":
                return new int[]{0x1F4DA, 0x1F46B, 0x1F494, 0x1F4C6, 0x1F519};
            case "토이스토리":
                return new int[]{0x1F9F8, 0x1F920, 0x1F680, 0x1F468, 0x200D, 0x1F680, 0x1F4AB};
            case "더글로리":
                return new int[]{0x1F393, 0x1F4BC, 0x1F4A1, 0x1F50D, 0x1F4B0};
            case "이상한 변호사 우영우":
                return new int[]{0x2696, 0x1F468, 0x200D, 0x2696, 0xFE0F, 0x1F4BC, 0x1F440, 0x1F47B};
            case "사이코지만 괜찮아":
                return new int[]{0x1F9E0, 0x1F494, 0x1F50E, 0x1F6CB, 0x1F60A};
            case "기생충":
                return new int[]{0x1F3E0, 0x1F468, 0x200D, 0x1F469, 0x200D, 0x1F467, 0x200D, 0x1F466, 0x1F4B0, 0x1F33F, 0x1F3DA};
            case "킹덤":
                return new int[]{0x1F451, 0x1F9DF, 0x200D, 0x2642, 0xFE0F, 0x1F3F0, 0x1F480, 0x2694, 0xFE0F};
            case "수상한 그녀":
                return new int[]{0x1F50D, 0x1F469, 0x200D, 0x2696, 0xFE0F, 0x1F4BC, 0x1F4B0, 0x1F575, 0xFE0F, 0x200D, 0x2640, 0xFE0F};
            case "겨울왕국":
                return new int[]{0x2744, 0xFE0F, 0x1F478, 0x1F3FB, 0x1F3F0, 0x26C4, 0x1F3B6};
            case "도둑들":
                return new int[]{0x1F4B0, 0x1F52B, 0x1F3E6, 0x1F575, 0xFE0F, 0x200D, 0x2642, 0xFE0F, 0x1F92F};
            case "위대한 쇼맨":
                return new int[]{0x1F3A9, 0x1F3AA, 0x1F3B6, 0x1F31F, 0x2764, 0xFE0F};
            case "님아 그 강을 건너지 마오":
                return new int[]{0x1F30A, 0x1F6A3, 0x200D, 0x2642, 0xFE0F, 0x1F3DE, 0x1F46B, 0x1F6D1};
            case "소년시대":
                return new int[]{0x1F466, 0x1F3B8, 0x1F3B6, 0x1F4DA, 0x1F31F};
            case "서울의 봄":
                return new int[]{0x1F338, 0x1F3D9, 0x1F6B6, 0x200D, 0x2642, 0xFE0F, 0x1F4AD, 0x1F331};
            case "라라랜드":
                return new int[]{0x1F3B6, 0x1F31F, 0x1F3AD, 0x1F306, 0x1F494};
            case "해리포터":
                return new int[]{0x1F9D9, 0x200D, 0x2642, 0xFE0F, 0x1F52E, 0x1F4DA, 0x26A1, 0x1F3F0};
            case "아바타":
                return new int[]{0x1F33F, 0x1F30D, 0x1F30C, 0x1F680, 0x1F535};
            case "스즈메의 문단속":
                return new int[]{0x1F6B2, 0x1F4D6, 0x1F468, 0x200D, 0x1F9B1, 0x1F338, 0x1F30A};
            case "보헤미안 랩소디":
                return new int[]{0x1F3A4, 0x1F3B8, 0x1F451, 0x1F3B6, 0x1F3F3, 0xFE0F, 0x200D, 0x1F308};
            case "어바웃 타임":
                return new int[]{0x23F0, 0x1F48F, 0x1F3A5, 0x1F494, 0x1F4AB};
            case "펜트하우스":
                return new int[]{0x1F3D9, 0x1F460, 0x1F52A, 0x1F525, 0x1F4BC};
            case "호텔 델루나":
                return new int[]{0x1F47B, 0x1F3E8, 0x1F5DD, 0x1F56F, 0x1F315};
            case "이태원 클라쓰":
                return new int[]{0x1F354, 0x1F37B, 0x1F3A4, 0x1F57A, 0x1F3FC, 0x1F35C};
            case "별에서 온 그대":
                return new int[]{0x1F47D, 0x1F320, 0x1F3EB, 0x1F469, 0x200D, 0x1F680, 0x1F495};

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
