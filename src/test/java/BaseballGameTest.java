import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseballGameTest {
    @Test
    void 숫자와_자리가_같으면_스트라이크() {
        //given
        String input = "123";
        //when
        String computerNum = "123";
        BaseballGame baseballGame = new BaseballGame(computerNum);
        String result = baseballGame.play(input);
        //then
        assertEquals("3스트라이크", result);

        String result2 = baseballGame.play("543");
        //then
        assertEquals("1스트라이크", result2);
    }

    @Test
    void 숫자만_맞으면_볼() {
        //given
        String input = "937";
        //when
        String computerNum = "123";
        BaseballGame baseballGame = new BaseballGame(computerNum);
        String result = baseballGame.play(input);
        //then
        assertEquals("1볼", result);
    }

    @Test
    void 모든_숫자와_자리가_맞지_않으면_낫싱() {
        //given
        String input = "987";
        //when
        String computerNum = "123";
        BaseballGame baseballGame = new BaseballGame(computerNum);
        String result = baseballGame.play(input);
        //then
        assertEquals("낫싱", result);
    }

    @Test
    void 숫자가_아닌_값이_입력되면_IllegalArgumentException() {
        //given
        String input = "abc";
        //when
        String computerNum = "456";

        //then
        BaseballGame baseballGame = new BaseballGame(computerNum);
        assertThatThrownBy(() -> {
            baseballGame.play(input);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("1볼 1스트라이크")
    void oneBall_oneStrike() {
        //given
        String input = "123";

        //when
        String computerNum = "713";
        BaseballGame baseballGame = new BaseballGame(computerNum);
        String result = baseballGame.play(input);

        //then
        assertEquals("1볼 1스트라이크", result);

    }

    @Test
    @DisplayName("1볼")
    void oneBall() {
        //given
        String input = "145";

        //when
        String computerNum = "713";
        BaseballGame baseballGame = new BaseballGame(computerNum);
        String result = baseballGame.play(input);

        //then
        assertEquals("1볼", result);

    }

    @Test
    @DisplayName("2볼")
    void twoBall() {
        //given
        String input = "671";

        //when
        String computerNum = "713";
        BaseballGame baseballGame = new BaseballGame(computerNum);
        String result = baseballGame.play(input);

        //then
        assertEquals("2볼", result);
    }

    @Test
    @DisplayName("1스트라이크")
    void oneStrike() {
        //given
        String input = "216";

        //when
        String computerNum = "713";
        BaseballGame baseballGame = new BaseballGame(computerNum);
        String result = baseballGame.play(input);

        //then
        assertEquals("1스트라이크", result);
    }

}