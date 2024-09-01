import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "1";
        BaseballGame baseballGame = new BaseballGame();

        while (!input.equals("2")) {
            if (br.readLine() == "") break;
            if (input.equals("1")) baseballGame = new BaseballGame();

            System.out.print("숫자를 입력해 주세요 : ");
            input = br.readLine();
            if (input.equals("2")) break;
            String result = baseballGame.play(input);
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            }
        }
        br.close();

    }

}
