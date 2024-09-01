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

    public String play(String input) {
        if (!isNumeric(input)) throw new IllegalArgumentException();
        int strikeCnt = 0;
        int ballCnt = 0;
        for (int i = 0; i < computerNum.length(); i++) {
            if (computerNum.charAt(i) == input.charAt(i)) {
                strikeCnt++;
            } else if (computerNum.contains(String.valueOf(input.charAt(i)))) ballCnt++;
        }
        StringBuilder sb = new StringBuilder();
        if (ballCnt > 0) {
            sb.append(ballCnt);
            sb.append(BALL);
        }

        if (strikeCnt > 0) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(strikeCnt);
            sb.append(STRIKE);
        }
        if (strikeCnt == 0 && ballCnt == 0) {
            return NOTING;
        }
        return sb.toString();
    }

    boolean isNumeric(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }
        try {
            int num = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }
}
