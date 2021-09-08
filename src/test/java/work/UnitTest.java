package work;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UnitTest {

    @Test
    void moveShouldFailIfFuelIsLowerThan0() {
        //given
        Unit unit = new Unit(new Coordinates(90, 30), 50, 50);
        //then
        assertThrows(IllegalStateException.class, () -> unit.move(90, 90));
    }

    @Test
    void unitShouldNotMoveWithoutFuel() {
        //given
        Unit unit = new Unit(new Coordinates(0,0), 0, 10);
        //when
        //then
        assertThrows(IllegalStateException.class, () -> unit.move(5, 5));
    }

    @Test
    void unitShouldLoseFuelWhileMoving(){
        //given
        Unit unit = new Unit(new Coordinates(0, 0), 10, 10);
        //when
        unit.move(2, 2);
        //then
        assertThat(unit.getFuel(), is(6));
    }

    @Test
    void unitAfterMovingShouldReturnNewCoordinates() {
        //given
        Unit unit = new Unit(new Coordinates(0,0), 40, 10);
        //when
        Coordinates move = unit.move(4,4);
        //then
        assertThat(move, equalTo(new Coordinates(4, 4)));
    }

    @Test
    void TankUpShouldReturnMaxFuel() {
        //given
        Unit unit = new Unit(new Coordinates(90, 30), 50, 50);
        //when
        unit.tankUp();
        //then
        assertThat(unit.getFuel(), is(50));
    }

    @Test
    void cargoShouldNotExtendMaxWeight() {
        //given
        Unit unit = new Unit(new Coordinates(0,0), 40, 40);
        Cargo c1 = new Cargo("c1", 25);
        Cargo c2 = new Cargo("c2", 20);
        //when
        unit.loadCargo(c1);
        //then
        assertThrows(IllegalStateException.class, () -> unit.loadCargo(c2));
    }
    @Test
    void cargoShouldEquals0AfterUnload() {
        //given
        Unit unit = new Unit(new Coordinates(0,0), 40, 40);
        Cargo c1 = new Cargo("c1", 25);
        //when
        unit.loadCargo(c1);
        unit.unloadAllCargo();
        //then
        assertThat(unit.getLoad(), is(0));
    }


}