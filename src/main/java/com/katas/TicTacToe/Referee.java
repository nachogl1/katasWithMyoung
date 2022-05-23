package com.katas.TicTacToe;

import static com.katas.TicTacToe.GameStatus.*;
import static com.katas.TicTacToe.TicTacToeSymbols.*;

public class Referee {

    private static final int GRID_MAX = 2;
    private TicTacToeSymbols winner;
    private TicTacToeSymbols[][] grid;

    public GameStatus checkRules(TicTacToeSymbols[][] currentGrid) {

        this.grid = currentGrid;
        GameStatus result = ONGOING;

        if (isThereWinner()) {
            result = this.winner == PLAYER_X ? PLAYER_X_WON : PLAYER_O_WON;
        }

        return result;

    }

    private boolean isThereWinner() {
        return isColumnWinner() || isRowWinner();
    }

    private boolean isRowWinner() {
        for (int x = 0; x <= GRID_MAX; x++) {

            if (grid[x][0] != EMPTY && grid[x][0] == grid[x][1] && grid[x][1] == grid[x][2]) {
                this.winner = grid[x][0];
                return true;
            }

        }

        return false;
    }

    private boolean isColumnWinner() {

        for (int y = 0; y <= GRID_MAX; y++) {

            if (grid[0][y] != EMPTY && grid[0][y] == grid[1][y] && grid[1][y] == grid[2][y]) {
                this.winner = grid[0][y];
                return true;
            }

        }

        return false;
    }
}
