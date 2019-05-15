package Gomoku;

public interface ComputerTurn {
	
	void setGameTable(GameTable gameTable);

	Cell makeTurn();

	Cell makeFirstTurn();
}
