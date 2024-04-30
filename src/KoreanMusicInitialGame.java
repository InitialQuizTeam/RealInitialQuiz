package src;

import java.util.*;

public class KoreanMusicInitialGame {



    private static Map<String, String[]> musicTitleHints; // 클래스 변수로 선언

    static {
        // 노래 제목과 힌트의 맵을 초기화
        musicTitleHints = createMusicTitleHints();
    }


    private static Map<String, String[]> createMusicTitleHints() {
        Map<String, String[]> musicHints = new HashMap<>();

        // 여기에 노래 제목과 힌트를 추가하세요...
        // 힌트를 String 배열에 저장
        String[]gangnam={"말춤","오빤"};
        String[]everyday={"키스 먼저 할까요?","네가 없이 웃을 수 있을까"};
        String[]ddudu={"블핑","DD-D"};
        String[]gun={"맞으면,,","구멍난 가슴에 우리 추억이 흘러 넘쳐"};
        String[]meet={"참 행복했어","폴"};
        String[]hansoom={"에휴","2hi"};
        String[]snow={"도깨비","에일리"};
        String[]bbi={"포켓몬","IU"};
        String[]rain={"헤이즈","feat.신용재"};
        String[]like={"여자버전 답가","윤종신"};
        String[]soju={"막 잔"," 첫 잔"};
        String[]likeyou={"정승환","너였으면"};
        String[]byespeak={"박재정","나는 사실 그대에게 좋은 사람이 아녜요"};
        String[]yazang={"종로","을지로"};
        String[]we={"로이킴","최유리"};
        String[]love={"꽃다발 같은 ...","우리가 만나 지우지 못할 추억이 됐다"};
        String[]er={"쾌걸춘향","izi"};
        String[]goodbye={"참 맑기도 하다 널 떼러 가는 길","임한별"};
        String[]miss={"그렉","miss"};
        String[]loveme={"이젠 곁에 없지만","허각"};
        String[]wild={"3단","박효신"};
        String[]reason={"이석훈","로코베리"};
        String[]have={"며칠사이 야윈 널달래고","뱅크"};
        String[]worry={"응팔1988","이적"};
        String[]maestro={"5살 때부터 난 피아노를 쳤어","지휘봉"};
        String[]password={"짝수","윤하"};
        String[]ryn={"...","..."};
        String[]sinchon={"이대 다음","이대 전"};
        String[]wind={"바람 불어와","나얼"};


        // 노래 제목과 해당 힌트를 해시맵에 저장
        musicHints.put("강남-스타일",gangnam);
        musicHints.put("모든 날,- 모든 순간",everyday);
        musicHints.put("뚜두-뚜두",ddudu);
        musicHints.put("총 맞은- 것처럼",gun);
        musicHints.put("너를- 만나",meet);
        musicHints.put("한-숨",hansoom);
        musicHints.put("첫눈처럼- 너에게 가겠다",snow);
        musicHints.put("삐-삐",bbi);
        musicHints.put("비도 오-고 그래서",rain);
        musicHints.put("좋-니",like);
        musicHints.put("소주- 한 잔",soju);
        musicHints.put("헤어지자- 말해요",byespeak);
        musicHints.put("포장-마차",yazang);
        musicHints.put("잘 지내-자, 우리",we);
        musicHints.put("사랑을- 했다",love);
        musicHints.put("응급-실",er);
        musicHints.put("이별하러- 가는 길",goodbye);
        musicHints.put("보고- 싶다",miss);
        musicHints.put("나를 사랑했던- 사람아",loveme);
        musicHints.put("야생-화",wild);
        musicHints.put("그대를 사랑하는- 10가지 이유",reason);
        musicHints.put("가질 수- 없는 너",have);
        musicHints.put("걱정말아-요 그대",worry);
        musicHints.put("마에스-트로",maestro);
        musicHints.put("비밀번호-486",password);
        musicHints.put("...사랑했-잖아...",ryn);
        musicHints.put("신촌-을 못 가",sinchon);
        musicHints.put("바람-기억",wind);
        return musicHints;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("이어말하기 게임!");

        while (playAgain) {
            String musicTitle = getRandomMusicTitle(random);
            String[] initials = getInitials(musicTitle);

            System.out.println("✨다음 노래 제목을 이어말하시오.(@기회 5번@)✨: ");
            for (String initial : initials) {
                System.out.print(initial);
            }
            System.out.println();

            while (true) {
                System.out.print("✨노래 제목을 입력하거나 '힌트'를 입력하여 힌트를 받으세요✨: ");
                String guess = scanner.nextLine();

                if (guess.equalsIgnoreCase("힌트")) {
                    displayHint(musicTitle);
                } else {
                    String formattedGuess = guess.replace("-", "").toLowerCase();
                    String formattedMusicTitle = musicTitle.replace("-", "").toLowerCase();

                    int attempts = 4; // 오답 입력 시도 횟수
                    while (!formattedGuess.equalsIgnoreCase(formattedMusicTitle)) {
                        if (attempts == 0) {
                            System.out.println("5번의 오답 시도로 게임에서 패배하였습니다.");
                            return;
                        } else if (guess.equalsIgnoreCase("힌트")) {
                            displayHint(musicTitle);
                        }else{
                            System.out.println("틀렸습니다! 다시 시도하세요.");
                            System.out.println("기회 " + attempts-- +"번 남았습니다.");
                        }

                        System.out.print("노래 제목을 입력해주세요: ");
                        guess = scanner.nextLine();
                        formattedGuess = guess.replace("-", "");
                    }

                    if (formattedGuess.equals(formattedMusicTitle)) {
                        System.out.println("✨정답입니다!✨ 축하합니다!");
                        break;
                    } else {
                        System.out.println("틀렸습니다! 다시 시도하세요.");
                    }
                }
            }

            while (true) {
                System.out.print("게임을 다시 하시겠습니까? (yes/no): ");
                String playAgainInput = scanner.nextLine();
                if (playAgainInput.equalsIgnoreCase("yes") || playAgainInput.equalsIgnoreCase("y")) {
                    playAgain = true;
                    break;
                } else if (playAgainInput.equalsIgnoreCase("no") || playAgainInput.equalsIgnoreCase("n")) {
                    playAgain = false;
                    break;
                } else {
                    System.out.println("키워드를 제대로 입력하세요.");
                }
            }
        }

        System.out.println("게임이 종료되었습니다. 감사합니다!");
    }


    private static String[] getInitials(String title) {
        String[] words = new String[]{title.split("-")[0]}; // 쉼표(,)를 기준으로 전 단어를 words 배열에 담는다.
        return words;
    }

    private static String getRandomMusicTitle(Random random) {
        List<String> keysAsArray = new ArrayList<>(musicTitleHints.keySet());
        return keysAsArray.get(random.nextInt(keysAsArray.size()));
    }


    private static void displayHint(String musicTitle) {
        String[] hints = musicTitleHints.get(musicTitle);
        if (hints != null) {
            System.out.println("힌트: ");
            for (String hint : hints) {
                System.out.println(hint);
            }
        } else {
            System.out.println("해당 노래의 힌트가 없습니다.");
        }
    }
}