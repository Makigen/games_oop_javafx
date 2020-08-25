package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void positionTest() {
        BishopBlack testBishop = new BishopBlack(Cell.C8);
        assertThat(testBishop.position(), is(Cell.C8));
    }

    @Test
    public void copyTest() {
        BishopBlack testBishop = new BishopBlack(Cell.F8);
        assertThat(testBishop.copy(Cell.A6).position(), is(Cell.A6));
    }

    @Test
    public void wayTest() throws ImpossibleMoveException {
        BishopBlack testBishop = new BishopBlack(Cell.C1);
        assertThat(testBishop.way(Cell.G5), is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenNotDiagonal() throws ImpossibleMoveException{
        BishopBlack testBishop = new BishopBlack(Cell.C1);
        testBishop.way(Cell.G4);
    }
}
