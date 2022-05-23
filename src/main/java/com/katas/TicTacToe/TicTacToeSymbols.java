package com.katas.TicTacToe;

public enum TicTacToeSymbols {
    PLAYER_X("X"),
    PLAYER_O("O"),
    EMPTY("-");

    private final String symbol;

    TicTacToeSymbols(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
