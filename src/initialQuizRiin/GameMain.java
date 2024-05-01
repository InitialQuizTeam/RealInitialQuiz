package src.initialQuizRiin;

import src.AccountManager;
import src.Scores;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameMain {

    public void Game(String gameId){

        Scores scores = new Scores(); // Scores 객체 생성

//        System.out.println("1");
        scores.FileExample();
//        System.out.println("2");
        Scanner scanner = new Scanner(System.in);
        Map<String, int[]> movieHints = createMovieHints(); // 영화 힌트 생성

        for (String title : movieHints.keySet()) {
            Game game = new Game(title, movieHints.get(title), scores);
            game.play(scanner);
        }

        System.out.println("게임 종료!");
        System.out.println( gameId + "님 최종 점수 : " + scores.getScore() + "점");
        AccountManager.addScore(gameId, scores.getScore());
        scores.FileExample();
//        scanner.close();
    }

    private static Map<String, int[]> createMovieHints() {
        Map<String, int[]> movieHints = new HashMap<>(); // 영화별 힌트 저장을 위한 해시맵

        // 이모지를 유니코드로 변환하여 int 배열에 저장
        int[] monsterInc = {0x1F303, 0x1F479, 0x1F9F0, 0x1F631, 0x1F469}; // 🌃👹🧱😱👧
        //int[] avengers = {0x2694, 0x1F9B8, 0x200D, 0x2642, 0xFE0F, 0x1F4A5, 0x1F9B8, 0x200D, 0x2640, 0xFE0F, 0x1F30D}; // ⚔🦸‍♂️💥🦸‍♀️🌍
        int[] interstellar = {0x1F680, 0x1F30C, 0x1F52D, 0x23F3, 0x1F468, 0x200D, 0x1F680}; // 🚀🌌🔭⏳👨‍🚀
        int[] lionKing = {0x1F981, 0x1F451, 0x1F305, 0x1F43E, 0x1F3B6}; // 🦁👑🌅🐾🎶
        int[] titanic = {0x1F6A2, 0x2764, 0xFE0F, 0x1F30A, 0x2744, 0xFE0F, 0x1F3A4}; // 🚢❤️🌊❄️🎶

        // 영화 제목과 해당 이모지 배열을 해시맵에 저장
        movieHints.put("좀비", monsterInc);
        //movieHints.put("어벤져스", avengers);
        movieHints.put("해운대", interstellar);
        movieHints.put("파묘", lionKing);
        movieHints.put("도둑들", titanic);

        return movieHints;
    }
}
