package Gomoku;

import Exceptions.DataSet;

public interface WinnerResult {

	boolean winnerExists();

	DataSet<Cell> getWinnerCells();
}
