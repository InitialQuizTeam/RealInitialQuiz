package src.initialQuizRiin;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFileFunction {
    public static final String FONT_RED = "\u001B[31m";
    static Path currentPath = Paths.get("");
    static String path = currentPath.toAbsolutePath().toString();
    //        System.out.println("현재 작업 경로: " + path);

    //    public static final String ROOT_PATH = "/Users/kon/konFolder/src/TestZone";
    public static final String ROOT_PATH = path;
    static String targetPath = ROOT_PATH + "/CommonTextFile/memberList.txt";

    public void delete() {
        File originfile = new File(targetPath);


        boolean deleted = false;
        for (int i = 0; i < 10; i++) { // 최대 10번까지 시도
            try {
                Files.delete(Path.of(targetPath));
                deleted = true;
//                System.out.println("파일이 성공적으로 삭제되었습니다.");
                //
                System.out.println("☁︎     파일을 저장합니다");

                System.out.println(FONT_RED+"=================================================================================");
                System.out.println("██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗");
                System.out.println("██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗");
                System.out.println("██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝");
                System.out.println("██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗");
                System.out.println("╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║");
                System.out.println(" ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝");
                System.out.println("=================================================================================");




//                System.out.println(FONT_RED+"   _________    __  _____________ _    ____________");
//                System.out.println("  / ____/   |  /  |/  / ____/ __ \\ |  / / ____/ __ \\ ");
//                System.out.println(" / / __/ /| | / /|_/ / __/ / / / / | / / __/ / /_/ /");
//                System.out.println("/ /_/ / ___ |/ /  / / /___/ /_/ /| |/ / /___/ _, _/");
//                System.out.println("\\____/_/  |_/_/  /_/_____/\\____/ |___/_____/_/ |_|");


//                System.out.println("▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄       ▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄               ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄");
//                System.out.println("▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌     ▐░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌             ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌");
//                System.out.println("▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌   ▐░▐░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▐░▌           ▐░▌ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌");
//                System.out.println("▐░▌          ▐░▌       ▐░▌▐░▌▐░▌ ▐░▌▐░▌▐░▌          ▐░▌       ▐░▌  ▐░▌         ▐░▌  ▐░▌          ▐░▌       ▐░▌");
//                System.out.println("▐░▌ ▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░▌ ▐░▐░▌ ▐░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░▌       ▐░▌   ▐░▌       ▐░▌   ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌");
//                System.out.println("▐░▌▐░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌  ▐░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌    ▐░▌     ▐░▌    ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌");
//                System.out.println("▐░▌ ▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░▌   ▀   ▐░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░▌       ▐░▌     ▐░▌   ▐░▌     ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀█░█▀▀");
//                System.out.println("▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌          ▐░▌       ▐░▌      ▐░▌ ▐░▌      ▐░▌          ▐░▌     ▐░▌");
//                System.out.println("▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌       ▐░▐░▌       ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌      ▐░▌");
//                System.out.println("▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌        ▐░▌        ▐░░░░░░░░░░░▌▐░▌       ▐░▌");
//                System.out.println(" ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀          ▀          ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀");



//                        System.out.println(FONT_RED+"_______  _______  __   __  _______  _______  __   __  _______  ______");
//                System.out.println("|       ||   _   ||  |_|  ||       ||       ||  | |  ||       ||    _ |");
//                System.out.println("|    ___||  |_|  ||       ||    ___||   _   ||  |_|  ||    ___||   | ||");
//                System.out.println("|   | __ |       ||       ||   |___ |  | |  ||       ||   |___ |   |_||_");
//                System.out.println("|   ||  ||       ||       ||    ___||  |_|  ||       ||    ___||    __  |");
//                System.out.println("|   |_| ||   _   || ||_|| ||   |___ |       | |     | |   |___ |   |  | |");
//                System.out.println("|_______||__| |__||_|   |_||_______||_______|  |___|  |_______||___|  |_|");




                break;
            } catch (FileSystemException e) {
                try {
                    Thread.sleep(1000); // 1초 대기
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            } catch (IOException e) {
                e.printStackTrace(); // 다른 IO 예외 처리
                break;
            }
        }
        if (!deleted) {
            System.out.println("파일 삭제 실패. 다른 프로세스가 파일을 사용 중입니다.");
        }
        //        try {
//
//            if (originfile.exists()) {
//                Files.delete(Paths.get(targetPath));
//            }
//            if (originfile.exists()) {
//                originfile.deleteOnExit();
//            }
//            System.out.println("삭제 완료");
//
//        } catch (Exception e) {
//            System.out.println("삭제에 문제가 있습니다~!");
//            System.out.println(e);
    } //
}

