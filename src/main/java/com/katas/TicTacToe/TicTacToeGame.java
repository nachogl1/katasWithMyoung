package com.katas.TicTacToe;

import static com.katas.TicTacToe.TicTacToeSymbols.*;

public class TicTacToeGame {
    private TicTacToeSymbols[][] grid = {{EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}};
    private GameStatus currentStatus = GameStatus.NOT_STARTED;
    private Referee referee = new Referee();
    private TicTacToeSymbols currentPlayer = PLAYER_X;

    public TicTacToeSymbols[][] move(int row, int column) {
        this.grid[row][column] = this.currentPlayer == PLAYER_X ? PLAYER_X : PLAYER_O;
        this.currentPlayer = this.currentPlayer == PLAYER_X ? PLAYER_O : PLAYER_X;
        this.update();
        return this.grid;
    }

    public GameStatus checkStatus() {
        return currentStatus;
    }

    private void update() {
        this.currentStatus = referee.checkRules(this.grid);
    }
}
