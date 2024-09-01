import java.util.HashSet;
import java.util.Random;

public class BaseballGame {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTING = "낫싱";
    private final String computerNum;

    BaseballGame(String computerNum) {
        if (!isNumeric(computerNum)) throw new IllegalArgumentException();
        this.computerNum = computerNum;
    }

    BaseballGame() {
        HashSet<Integer> numbers = new HashSet<>();
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        while (numbers.size() != 3) {
            numbers.add(rand.nextInt(10));
        }
        for (int number : numbers) {
            sb.append(number);
        }
        computerNum = sb.toString();
        if (!isNumeric(computerNum)) throw new IllegalArgumentException();
    }

}
