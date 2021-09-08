package work;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinatesTest {

    @Test
    public void ConstructorShouldFailIfAnyValueBelow0() {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(-1, 0));
    }

    @Test
    public void ConstructorShouldFailIfAnyValueAbove100() {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(101, 0));
    }

    @Test
    public void copyShouldReturnNewObject() {

        //given
        Coordinates co = new Coordinates(50, 50);
        //when
        Coordinates copy = new Coordinates(0, 0);
        //then
        assertThat(copy, not(sameInstance(co)));
    }


}