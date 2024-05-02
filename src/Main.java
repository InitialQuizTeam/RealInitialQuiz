package src;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String FONT_BLACK = "\u001B[30m";
    public static final String FONT_RED = "\u001B[31m";
    public static final String FONT_GREEN = "\u001B[32m";
    public static final String FONT_BLUE = "\u001B[34m";
    public static final String FONT_PURPLE = "\u001B[35m";
    public static final String FONT_CYAN = "\u001B[36m";
    public static final String FONT_WHITE = "\u001B[37m";
    public static final String BACKGROUND_BLACK = "\u001B[40m";
    public static final String BACKGROUND_RED = "\u001B[41m";
    public static final String BACKGROUND_GREEN = "\u001B[42m";
    public static final String BACKGROUND_YELLOW = "\u001B[43m";
    public static final String BACKGROUND_BLUE = "\u001B[44m";
    public static final String BACKGROUND_PURPLE = "\u001B[45m";
    public static final String BACKGROUND_CYAN = "\u001B[46m";
    public static final String BACKGROUND_WHITE = "\u001B[47m";
    //숫자인지 판별
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println(FONT_CYAN+"☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
            System.out.println("          초성 맞추기 게임");
            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
            System.out.println("☁︎        1. 회원가입                    ");
            System.out.println("☁︎        2. 로그인 ➤ 게임시작             "); //# 3. 영화 초성 게임 로그인 되면 나오도록
            System.out.println("☁︎        3. PW 찾기                    ");
            System.out.println("☁︎        4. 게임 종료                   ");
            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
            System.out.print(">> ");
            String inputString = null;
            while(true) {
                inputString = sc.nextLine();
                boolean isInt = isInteger(inputString);
//                System.out.println(isInt);
                if (isInt) break;
                else System.out.println("☁︎     숫자를 입력하세요.");
            }
            int menuNum = Integer.parseInt(inputString);

            switch (menuNum) {
                case 1:
                    //회원 가입
                    AccountManager.CreateAccountProcess();

                    break;
                case 2:
                    //로그인/ 게임시작
                   

                    AccountManager.TryLogin();
//                    AccountManager.addScore("dragon",33);
                    //GameMain gameMain = new GameMain();
                      //gameMain.main();

                    break;
                case 3:
                    // 비밀번호 찾기
                    AccountManager.tryGetPassword();

                    break;
                case 4:
                    //종료
                    System.out.println("☁︎     종료합니다");
                    System.exit(0);

                default:
                    System.out.println("☁︎     메뉴를 잘못 선택했어요\n☁︎     다시 입력해주세요.");
                    break;

            }

        }
    }
}
