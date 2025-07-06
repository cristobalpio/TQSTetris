package cat.uab.tqs.tetris.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
 
    private Game _game;

    @BeforeEach
    void setUp() {
        _game = new Game();
    }

    @Test
    public void testGameStartFromIdle() {
        _game.start();
        assertEquals(GameState.RUNNING, _game.getState());
    }

    @Test
    public void testGameStartFromStart() {
        _game.start();
        assertEquals(GameState.RUNNING, _game.getState());
        assertThrows(IllegalStateException.class, () -> _game.start());
    }

    @Test
    public void testGameStartFromPaused() {
        _game.start();
        _game.pause();
        assertThrows(IllegalStateException.class, () -> _game.start());
    }

    @Test
    public void testGamePauseFromIdle() {
        assertThrows(IllegalStateException.class, () -> _game.pause());
    }
}