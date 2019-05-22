package Gomoku;

import java.util.List;

import Exceptions.DataSet;

public interface WinnerResult {

	boolean winnerExists();

	List<Cell> getWinnerCells();
}
