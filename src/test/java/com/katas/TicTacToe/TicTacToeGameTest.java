package com.katas.TicTacToe;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class TicTacToeGameTest {

    private TicTacToeGame game;

    @BeforeEach
    void setUp() {
        game = new TicTacToeGame();
    }

    @Test
    void checkNotStartedStatus() {
        GameStatus result = game.checkStatus();
        assertThat(result).isEqualTo(GameStatus.NOT_STARTED);
    }

    @Test
    void checkGameStatusOngoing() {
        game.move(0, 0);
        GameStatus result = game.checkStatus();
        assertThat(result).isEqualTo(GameStatus.ONGOING);
    }

    @Test
    void playerXMakesWinsARow() {
        game.move(0, 0); //X
        game.move(2, 0);
        game.move(0, 1); //X
        game.move(1, 0);
        game.move(0, 2); //X
        GameStatus result = game.checkStatus();
        assertThat(result).isEqualTo(GameStatus.PLAYER_X_WON);
    }

    @Test
    void playerOMakesWinsARow() {
        game.move(0, 0); //X
        game.move(1, 0); //O
        game.move(0, 1); //X
        game.move(1, 1); //O
        game.move(2, 0); //X
        for (TicTacToeSymbols[] ticTacToeSymbols : game.move(1, 2)) {
            System.out.println(Arrays.asList(ticTacToeSymbols));
        }
        GameStatus result = game.checkStatus();
        assertThat(result).isEqualTo(GameStatus.PLAYER_O_WON);
    }

    @Test
    void playerXMakesWinsAColumn() {
        game.move(0, 0); //X
        game.move(0, 1); //O
        game.move(1, 0); //X
        game.move(1, 2); //O
        game.move(2, 0); //X
        game.move(2, 1); //O
        GameStatus result = game.checkStatus();
        assertThat(result).isEqualTo(GameStatus.PLAYER_X_WON);
    }

    @Test
    void playerOMakesWinsAColumn() {
        game.move(0, 0); //X
        game.move(0, 2); //O
        game.move(1, 1); //X
        game.move(1, 2); //O
        game.move(2, 0); //X
        game.move(2, 2); //
        GameStatus result = game.checkStatus();
        assertThat(result).isEqualTo(GameStatus.PLAYER_O_WON);
    }

        /*
            We left it with everything passing
            Need to finish:
             -diagonal winner
             -Drawn
             -Cannot repeat positioo
             -No play outside bounds
             -Clean
             -Create repo, upload it and add Myoung as collaborator
        */

}
