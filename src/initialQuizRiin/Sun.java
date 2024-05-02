package src.initialQuizRiin;

public class Sun {
    private static String[] snacks = {"🍕", "🌭", "🍔", "🍟", "🍰"}; // 햇님의 간식
    private static int snackIndex = snacks.length; // 햇님의 현재 먹은 간식의 인덱스, 처음에는 배열의 길이로 초기화

    // 햇님이 간식을 먹는 메서드
    public static void eatSnack() {
        if (snackIndex > 0) {
            snackIndex--; // 간식을 먹으면 인덱스를 하나씩 줄임
            System.out.println("\n햇님이 간식을 하나 먹었습니다");
            System.out.print("냐암! ");
            for (int i = 0; i < snackIndex; i++) {
                System.out.print(snacks[i]);
            }
            double remainingPercentage = ((double) snackIndex / snacks.length) * 100;
            System.out.printf(" (%.0f%% 남았습니다)\n\n", remainingPercentage);
        } else {
            snackIndex = snacks.length; // 간식을 다 먹은 후에는 인덱스를 다시 초기화하여 처음부터 시작
            eatSnack(); // 다시 간식을 먹기 시작
        }
    }
}

