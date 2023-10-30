package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidateInputTest {

    @Test
    void input이_없으면_IllegalStateException() {
        String input = "";
        assertThatThrownBy(() ->
                ValidateInput.isRightInput(input)).isInstanceOf(IllegalStateException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"aaa", "12a", "-1", "1.2"})
    void input이_정수형태가_아닌경우_IllegalStateException() {
        String input = "35k";
        assertThatThrownBy(() ->
                ValidateInput.isNumeric(input)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 이름에_중복이_있으면_IllegalStateException() {
        String[] names = new String[]{"name", "name"};
        assertThatThrownBy(() ->
                ValidateInput.isRightCarNames(names)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 이름의_길이범위를_초과하면_IllegalStateException() {
        String[] names = new String[]{"longer"};
        assertThatThrownBy(() ->
                ValidateInput.isRightCarNames(names)).isInstanceOf(IllegalStateException.class);
    }
}