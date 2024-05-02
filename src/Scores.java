package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static src.AccountManager.ROOT_PATH;

//점수 관리하기 위한 클래스
public class Scores {
    private int score;
    AccountManager acountManager = new AccountManager();



    //scores 생성자
    public Scores(int score) {
        //초기 점수를 0으로 한거임
        this.score = score;
        //System.out.println("게임 종료! 최종 점수: " + getScore());
    }
    public void increaseScore() {
        //한문제 맞을 때 마다 점수 10 증가시키는거임
        this.score += 10;
    }
    public int getScore() {
        return this.score;
    }

    public void printFinalScore() {
        // 게임 종료 시 최종 점수 출력
        System.out.println("게임 종료! 최종 점수: " + getScore());
    }

    public void FileExample() {

        // 파일을 저장할 기본 경로
//        public static final String ROOT_PATH = "/Users/superstar/Desktop";

        //프로그램 실행된 폴더 디렉토리 위치를 읽어옴
        // (프로젝트 실행되는 폴더 위치 읽어옴) = 상대 경로
        Path currentPath = Paths.get("");
        String path = currentPath.toAbsolutePath().toString();
        System.out.println("현재 작업 경로: " + path);

        //    public static final String ROOT_PATH = "/Users/kon/konFolder/src/TestZone";
        final String ROOT_PATH = path;
        String targetPath = ROOT_PATH + "/CommonTextFile/scoreList.txt";


        // 폴더 생성 명령
        // 파일 정보 객체 생성
        File directory = new File(ROOT_PATH + "/CommonTextFile");
        System.out.println(directory);
        // 폴더 생성
        if (!directory.exists()) directory.mkdir();

        // 파일 생성하기
        File newFile = new File(ROOT_PATH + "/CommonTextFile/scoreList.txt");

        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                System.out.println("파일 생성에 실패했습니다.");
            }
        }

        try (FileWriter fw = new FileWriter(targetPath)) {
            int score2 = getScore();
            String outputMessage = String.format("점수 : %d.\n", score2);

            // 파일 생성 명령
            fw.write(outputMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}