package src.initialQuizRiin;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFileFunction {
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
                System.out.println("☁︎     파일을 저장합니다");
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

