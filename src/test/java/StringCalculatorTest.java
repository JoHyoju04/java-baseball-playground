import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    @Test
    void 더하기(){
        //given
        String input = "2 + 3";

        //when
        StringCalculator stringCalculator = new StringCalculator(input);
        int result = stringCalculator.calculate();

        //then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 빼기(){
        //given
        String input = "2 - 3";

        //when
        StringCalculator stringCalculator = new StringCalculator(input);
        int result = stringCalculator.calculate();

        //then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void 곱하기(){
        //given
        String input = "2 * 3";

        //when
        StringCalculator stringCalculator = new StringCalculator(input);
        int result = stringCalculator.calculate();

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 나누기(){
        //given
        String input = "2 / 3";

        //when
        StringCalculator stringCalculator = new StringCalculator(input);
        int result = stringCalculator.calculate();

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 모든_사칙_연산자가_들어갔을때(){
        //given
        String input = "2 + 3 * 4 / 2";

        //when
        StringCalculator stringCalculator = new StringCalculator(input);
        int result = stringCalculator.calculate();

        //then
        assertThat(result).isEqualTo(10);
    }

    @Test
    void 연산자_자리에_숫자가_들어오면_예외처리(){
        //given
        String input = "2 2";

        //when, then
        assertThatThrownBy(() -> {
            new StringCalculator(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_없으면_예외처리(){
        //given
        String input = "+";

        //when, then
        assertThatThrownBy(() -> {
            new StringCalculator(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}