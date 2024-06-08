package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenStartPositionB1ThenPositionB1() {
        Cell startPosition = Cell.B1;
        Figure figure = new BishopBlack(startPosition);
        Cell position = figure.position();
        assertThat(position).isEqualTo(startPosition);
    }

    @Test
    void whenEndPositionD3ThenPositionD3() {
        Cell endPosition = Cell.D3;
        Figure figure = new BishopBlack(Cell.B1);
        Figure copy = figure.copy(endPosition);
        Cell position = copy.position();
        assertThat(position).isEqualTo(endPosition);
    }

    @Test
    void whenC1toG5ThenD2E3F4G5() {
        Figure figure = new BishopBlack(Cell.C1);
        Cell[] way = figure.way(Cell.G5);
        Cell[] expectedWay = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(way).containsExactly(expectedWay);
    }

    @Test
    void whenNotDiagonalMoveThenImpossibleMoveException() {
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    new BishopBlack(Cell.C1).way(Cell.C5);
                }
        );
        assertThat(exception.getMessage()).isEqualTo(
                String.format("Could not move by diagonal from %s to %s", Cell.C1, Cell.C5)
        );
    }
}