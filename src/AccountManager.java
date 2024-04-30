package src;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
    /**
     * @problem => 절대 경로일 경우, Mac /Windows 간 호환문제 있음
     * @Solution => 상대 경로 처리
     */
    //절대 경로
    //    public static final String ROOT_PATH = "/Users/kon/konFolder/src/TestZone";

    //프로그램 실행된 폴더 디렉토리 위치를 읽어옴
    // (프로젝트 실행되는 폴더 위치 읽어옴) = 상대 경로
    static Path currentPath = Paths.get("");
    static String path = currentPath.toAbsolutePath().toString();
    //        System.out.println("현재 작업 경로: " + path);

    //    public static final String ROOT_PATH = "/Users/kon/konFolder/src/TestZone";
    public static final String ROOT_PATH = path;
    static String targetPath = ROOT_PATH + "/CommonTextFile/memberList.txt";
    static String tempPath = ROOT_PATH + "/CommonTextFile/temp.txt";


    static Scanner sc = new Scanner(System.in);

    ////////////////////
    // ☘️ 회원가입
    static void CreateAccountProcess() {

        //폴더 체크
        //파일 정보 객체 생성
        File directory = new File(ROOT_PATH + "/CommonTextFile");
        //폴더 없으면 생성
        if (!directory.exists()) directory.mkdir();

        //파일 생성하기
        File newfile = new File(targetPath);


        if (!newfile.exists()) {
            try {
                newfile.createNewFile();
            } catch (IOException e) {
                System.out.println("memberList.txt 파일 생성에 실패했습니다.");
            }
        }


        String gameId = null;   //게임 아이디
        String userName = null; //사람 이름
        String passWord = null; //비밀번호

        //사용은 안하는 변수들
        int score = -1;       //점수
        int gameLife; //게임 목숨
        int hint;     //힌트 갯수

        //회원 정보 저장할 리스트 생성
        List<User> userList = new ArrayList<>();
        //<-----------------------------
        //read
        try (FileReader fr = new FileReader(targetPath)) {
            //읽는 방법 = 2
            //보조스트링 활용
            //텍스트를 라인 단위로 읽어들이는 보조 스트림
            BufferedReader br = new BufferedReader(fr);


            while (true) {
                String s = br.readLine();
                if (s == null) break;

                //읽는 방법 = 1
//            int read = fr.read();
//            System.out.println("(char)read = " + (char)read);
                //파일 생성 명령
                //읽은 것을 콤마로 구분하여 분리하여 배열로 만든다
                String[] split = s.split(",");
//                System.out.println(Arrays.toString(split));

                // 읽어들인 회원정보로 회원 객체 생성
                User user = new User(
                        split[0],                     //id
                        split[1],                    //memberName
                        split[2],                    //password
                        Integer.parseInt(split[3]),  //score
                        Integer.parseInt(split[4]),  //Life
                        Integer.parseInt(split[5])   //hint
                );
                userList.add(user);
            }
            //데이터 뿌려주기 (테스트용)
//            System.out.println(userList);


        } catch (Exception e) {
            e.printStackTrace();
        }


        //write
        try (FileWriter fw = new FileWriter(newfile, true)) {
            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");

            for (; ; ) {
                System.out.println("☁︎                        [메뉴로 돌아가기:q]");
                System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                System.out.print("☁︎     사용할 아이디를 입력하세요: ");
                gameId = sc.nextLine();
                if (gameId.equals("") || gameId == null) System.out.println("☁︎     아이디를 다시 입력하세요.");
                else if (gameId.equals("q")) {
                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                    System.out.println("메뉴로 돌아갑니다.");
                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                    return;
                } else {
                    //아이디 중복 검사
                    for (User user : userList) {
//                        System.out.println("id="+user.getGameId());
                        if (gameId.equals(user.getGameId())) {
                            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                            System.out.println("☁︎     아이디가 이미 있습니다.\n" +
                                    "☁︎     다른 아이디를 생각해보세요.");
                            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                            gameId = "";
                            //로그인 되면 탈출하고 게임 가기
                            break;
                        }
                    } //<-- 아이디 중복 검사

                    if (gameId != "") {
                        System.out.println("☁︎     아이디를 사용하실 수 있습니다~!");
                        break;
                    }
                }
            }

            for (; ; ) {
                System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                System.out.println("☁︎                        [메뉴로 돌아가기:q]");
                System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                System.out.print("☁︎     이름을 입력하세요: ");
                userName = sc.nextLine();
                if (userName.equals("") || userName == null) System.out.println("☁︎     이름을 다시 입력하세요.");
                else if (userName.equals("q")) {
                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                    System.out.println("메뉴로 돌아갑니다.");
                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                    return;
                } else break;
            }
            for (; ; ) {
                System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                System.out.println("☁︎                        [메뉴로 돌아가기:q]");
                System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                System.out.print("☁︎     사용할 비밀번호를 입력하세요: ");
                passWord = sc.nextLine();
                if (passWord.equals("") || passWord == null) System.out.println("☁︎     비밀번호를 다시 입력하세요.");
                else if (passWord.equals("q")) {
                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                    System.out.println("메뉴로 돌아갑니다.");
                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                    return;
                } else break;
            }
            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
            //아이디,이름,비밀번호,정답갯수(0),목숨(5),힌트(5)
            String outputMessage = String.format("%s,%s,%s,0,5,5\n", gameId, userName, passWord);

            //파일로 저장
            fw.write(outputMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("\n\n☁︎     %s님 반값습니다.😁\n☁︎     당신은 이제 회원입니다!\n", userName);

    }//end CreateAccountProcess


    ///////////////////////
    //// ☘️ 로그인
    static void TryLogin() {

        String gameId = null;   //게임 아이디
        String password = null; //비밀번호

        //접근할 파일 위치 지정 : targetPath: memberList.txt
        try (FileReader fr = new FileReader(targetPath)) {
            //읽는 방법 = 2
            //보조스트링 활용
            //텍스트를 라인 단위로 읽어들이는 보조 스트림
            BufferedReader br = new BufferedReader(fr);

            //회원 정보 저장할 리스트 생성
            List<User> userList = new ArrayList<>();

            while (true) {
                String s = br.readLine();
                if (s == null) break;

                //읽는 방법 = 1
//            int read = fr.read();
//            System.out.println("(char)read = " + (char)read);
                //파일 생성 명령
                //읽은 것을 콤마로 구분하여 분리하여 배열로 만든다
                String[] split = s.split(",");
//                System.out.println(Arrays.toString(split));

                // 읽어들인 회원정보로 회원 객체 생성
                User user = new User(
                        split[0],                     //id
                        split[1],                    //memberName
                        split[2],                    //password
                        Integer.parseInt(split[3]),  //score
                        Integer.parseInt(split[4]),  //Life
                        Integer.parseInt(split[5])   //hint
                );
                userList.add(user);
            }
            //데이터 뿌려주기 (테스트용)
//            System.out.println(userList);

            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
            System.out.println("☁︎                        [메뉴로 돌아가기:q]");
            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
            for (; ; ) {
                System.out.print("☁︎     접속할 아이디를 입력하세요: ");
                gameId = sc.nextLine();
                if (gameId.equals("") || gameId == null) System.out.println("☁︎     아이디를 다시 입력하세요.");
                else if (gameId.equals("q")) {
                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                    System.out.println("메뉴로 돌아갑니다.");
                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                    return;
                } else {
                    //아이디 null 아닐때
                    //아이디 검사
                    boolean id_Check = false;
                    for (User user : userList) {
//                        System.out.println(user.getGameId());
                        if (gameId.equals(user.getGameId())) {
                            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                            System.out.println("☁︎     아이디가 확인되었습니다.");
                            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                            id_Check = true;
                            break;
                        }
                    }
                    if (id_Check) {
                        break;
                    } else {
                        System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                        System.out.println("☁︎     아이디가 없어요.다시 확인해주세요.");
                        System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");

                    }


                    //아예 없으면 다시 나가도록
                }
            }

            for (; ; ) {
                System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                System.out.println("☁︎                        [메뉴로 돌아가기:q]");
                System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                System.out.print("☁︎     비밀번호를 입력하세요: ");
                password = sc.nextLine();
                if (password.equals("") || password == null) System.out.println("☁︎     비밀번호를 다시 입력하세요.");
                else if (password.equals("q")) {
                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                    System.out.println("메뉴로 돌아갑니다.");
                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                    return;
                } else {
                    //비밀번호 검사
                    for (User user : userList) {
//                        System.out.println(user.getGameId());
                        if (password.equals(user.getPassWord())) {
                            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                            System.out.println("☁︎     비밀번호가 확인되었습니다.");
                            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                            //로그인 되면 탈출하고 게임 가기
                            return;
                        }
//                        } else {
//                            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
//                            System.out.println("☁︎     비밀번호가 틀립니다. 다시 확인해주세요");
//                            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
//                            break;
//                        }
                    } //<-- 비밀번호 검사
                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                    System.out.println("☁︎     비밀번호가 틀립니다. 다시 확인해주세요");
                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end TryLogin

    /////////////////////
    // ☘️ 비밀번호 찾기
    public static void tryGetPassword() {
        String gameId = null;   //게임 아이디
        String password = null; //비밀번호

        //접근할 파일 위치 지정 : targetPath: memberList.txt
        try (FileReader fr = new FileReader(targetPath)) {
            //읽는 방법 = 2
            //보조스트링 활용
            //텍스트를 라인 단위로 읽어들이는 보조 스트림
            BufferedReader br = new BufferedReader(fr);

            //회원 정보 저장할 리스트 생성
            List<User> userList = new ArrayList<>();

            while (true) {
                String s = br.readLine();
                if (s == null) break;

                //읽는 방법 = 1
//            int read = fr.read();
//            System.out.println("(char)read = " + (char)read);
                //파일 생성 명령
                //읽은 것을 콤마로 구분하여 분리하여 배열로 만든다
                String[] split = s.split(",");
//                System.out.println(Arrays.toString(split));

                // 읽어들인 회원정보로 회원 객체 생성
                User user = new User(
                        split[0],                     //id
                        split[1],                    //memberName
                        split[2],                    //password
                        Integer.parseInt(split[3]),  //score
                        Integer.parseInt(split[4]),  //Life
                        Integer.parseInt(split[5])   //hint
                );
                userList.add(user);
            }
            //데이터 뿌려주기 (테스트용)
//            System.out.println(userList);

            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
            System.out.println("☁︎                        [메뉴로 돌아가기:q]");
            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");

            for (; ; ) {
                System.out.print("☁︎     찾고싶은 아이디를 입력하세요: ");
                gameId = sc.nextLine();
                if (gameId.equals("") || gameId == null) System.out.println("☁︎     아이디를 다시 입력하세요.");
                else if (gameId.equals("q")) {
                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                    System.out.println("메뉴로 돌아갑니다.");
                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                    return;
                } else {
                    //아이디 null 아닐때
                    //아이디 검사
                    boolean id_Check = false;
                    for (User user : userList) {
//                        System.out.println(user.getGameId());
                        if (gameId.equals(user.getGameId())) {
                            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                            System.out.println("☁︎     아이디는 확인되었습니다.");
                            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                            for (; ; ) {
                                System.out.println("☁︎     이름을 입력하세요.");
                                System.out.print("☁︎     ➤");
                                String inputUserName = sc.nextLine();
                                String name = user.getUserName();

                                if (inputUserName.equals(name)) {
                                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                                    System.out.println("☁︎     이름이 일치합니다.");
                                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                                    String savedPassword = user.getPassWord();
                                    System.out.println("☁︎     당신의 비밀번호를 알려드립니다.");
                                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                                    System.out.printf("☁︎     귀하의 비밀번호는 %s 입니다.\n", savedPassword);
                                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                                    id_Check = true;
                                } else {
                                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                                    System.out.println("☁︎     아쉽게도 이름이 틀렸습니다.");
                                    System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                                }

                                if (id_Check) {
                                    return;
                                }
                            }

                        }  //if
                    }
                    if (id_Check) {
                        break;
                    } else {
                        System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                        System.out.println("☁︎     아이디가 없어요.다시 확인해주세요.");
                        System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
                    }

                    if (id_Check) {
                        break;
                    }
                    //아예 없으면 다시 나가도록
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } //end tryGetPassword

    /////////////////////
    // ☘️ 점수 수정 테스트
    public static void addScore(String GameUserName,int Gamescore) {
        File originfile = new File(targetPath);
        File tempfile = new File(tempPath);

        if (!tempfile.exists()) {
            try {
                tempfile.createNewFile();
            } catch (IOException e) {
                System.out.println("temp.txt 파일 생성에 실패했습니다.");
            }
        }


        String gameId = null;   //게임 아이디
        String password = null; //비밀번호
        String tempText = "";

        //접근할 파일 위치 지정 : targetPath: memberList.txt
        try (FileReader fr = new FileReader(targetPath)) {
            //읽는 방법 = 2
            //보조스트링 활용
            //텍스트를 라인 단위로 읽어들이는 보조 스트림
            BufferedReader br = new BufferedReader(fr);

            //회원 정보 저장할 리스트 생성
            List<User> userList = new ArrayList<>();

            while (true) {
                String s = br.readLine();
                if (s == null) break;


                //파일 생성 명령
                //읽은 것을 콤마로 구분하여 분리하여 배열로 만든다
                String[] split = s.split(",");

                // 읽어들인 회원정보로 회원 객체 생성
                User user = new User(
                        split[0],                     //id
                        split[1],                    //memberName
                        split[2],                    //password
                        Integer.parseInt(split[3]),  //score
                        Integer.parseInt(split[4]),  //Life
                        Integer.parseInt(split[5])   //hint
                );
                userList.add(user);
            }

            for (; ; ) {

                gameId = GameUserName;

                //아이디 검사
                boolean id_Check = false;

                //반복 시작
                for (User user : userList) {

                    if (gameId.equals(user.getGameId())) {
//                            tempText += "👻";
                        tempText += user.getGameId() + ",";
                        tempText += user.getUserName() + ",";
                        tempText += user.getPassWord() + ",";
                        tempText += Gamescore + ",";               //점수
                        tempText += user.getGameLife() + ",";
                        tempText += user.getHint() + "\n";
//                            System.out.print(tempText);
                        id_Check = true;  //아이디 접근 완료
                        //end if
                    } else {           //아이디 아니면 그냥 복사
                        tempText+=user.getGameId()+",";
                        tempText+=user.getUserName()+",";
                        tempText+=user.getPassWord()+",";
                        tempText+=user.getScore()+",";
                        tempText+=user.getGameLife()+",";
                        tempText+=user.getHint()+"\n";
//                        tempText+=user;
//                            System.out.print(tempText);
                    }
                }
                //아예 없으면 다시 나가도록
                if(!id_Check) return;


                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.print(tempText); //데이터 찍어보기
        try(FileWriter fw = new FileWriter(tempfile)){

            fw.write(tempText,0,tempText.length());

            if(originfile.exists() && tempfile.exists()) {
//                        originfile.delete();

                Files.delete(Paths.get(targetPath));
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//tempfile.renameTo(originfile);
        //파일 이전 작업
        try {
            Files.move(tempfile.toPath(), originfile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    } //end addScore




    //##사용 안하는 함수
    ////////////////////////////////////
    // // ☘️ (사용안함) - 회원 정보 보여주기 - 추후에 필요하면 관리자 메뉴로 사용
    static void UserInfoView() {
        //접근할 파일 위치 지정 : targetPath: memberList.txt
        try (FileReader fr = new FileReader(targetPath)) {
            //읽는 방법 = 2
            //보조스트링 활용
            //텍스트를 라인 단위로 읽어들이는 보조 스트림
            BufferedReader br = new BufferedReader(fr);

            //회원 정보 저장할 리스트 생성
            List<User> userList = new ArrayList<>();

            while (true) {
                String s = br.readLine();
                if (s == null) break;

                //읽는 방법 = 1
//            int read = fr.read();
//            System.out.println("(char)read = " + (char)read);
                //파일 생성 명령
                //읽은 것을 콤마로 구분하여 분리하여 배열로 만든다
                String[] split = s.split(",");
//                System.out.println(Arrays.toString(split));

                // 읽어들인 회원정보로 회원 객체 생성
                User user = new User(
                        split[0],                     //id
                        split[1],                    //memberName
                        split[2],                    //password
                        Integer.parseInt(split[3]),  //score
                        Integer.parseInt(split[4]),  //Life
                        Integer.parseInt(split[5])   //hint
                );
                userList.add(user);
            }

            System.out.println(userList);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end UserView


}   //end class
