package ru.job4j.chess;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenNotFreeCellThenOccupiedCellException() {
        OccupiedCellException exception = assertThrows(
                OccupiedCellException.class,
                () -> {
                    Logic logic = new Logic();
                    logic.add(new BishopBlack(Cell.D4));
                    logic.add(new BishopBlack(Cell.E5));
                    logic.move(Cell.E5, Cell.B2);
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Cell is occupied");
    }
}