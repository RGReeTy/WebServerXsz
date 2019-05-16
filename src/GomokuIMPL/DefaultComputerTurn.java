package GomokuIMPL;

import java.util.Objects;

import Exceptions.DataSet;
import Exceptions.DynaArray;
import Gomoku.Cell;
import Gomoku.CellValue;
import Gomoku.ComputerTurn;
import Gomoku.GameTable;

public class DefaultComputerTurn implements ComputerTurn {
	private GameTable gameTable;
	private int winCount = DefaultConstants.WIN_COUNT;

	@Override
	public void setGameTable(GameTable gameTable) {
		Objects.requireNonNull(gameTable, "Game table can't be null");
		if (gameTable.getSize() < winCount) {
			throw new IllegalArgumentException(
					"Size of gameTable is to small=" + gameTable.getSize() + ". Required >= " + winCount);
		}
		this.gameTable = gameTable;

	}

	@Override
	public Cell makeTurn() {
		CellValue[] figures = { CellValue.COMPUTER, CellValue.HUMAN };
		for (int i = winCount - 1; i > 0; i--) {
			for (CellValue cellValue : figures) {
				Cell cell = tryMakeTurn(cellValue, i);
				if (cell != null) {
					return cell;
				}
			}
		}
		return makeRandomTurn();
	}

	@Override
	public Cell makeFirstTurn() {
		Cell cell = new Cell(gameTable.getSize() / 2, gameTable.getSize() / 2);
		gameTable.setValue(cell.getRowIndex(), cell.getColIndex(), CellValue.COMPUTER);
		return cell;
	}

	protected Cell makeRandomTurn() {

	}

	protected Cell tryMakeTurn(CellValue cellValue, int notBlankCount) {
		Cell cell = tryMakeTurnByRow(cellValue, notBlankCount);
		if (cell != null) {
			return cell;
		}
		cell = tryMakeTurnByCol(cellValue, notBlankCount);
		if (cell != null) {
			return cell;
		}
		cell = tryMakeTurnByMainDiagonal(cellValue, notBlankCount);
		if (cell != null) {
			return cell;
		}
		cell = tryMakeTurnNotByMainDiagonal(cellValue, notBlankCount);
		if (cell != null) {
			return cell;
		}
		return null;

	}

	protected Cell tryMakeTurnByRow(CellValue cellValue, int notBlankCount) {
		for (int i = 0; i < gameTable.getSize(); i++) {
			for (int j = 0; j < gameTable.getSize() - winCount - 1; j++) {
				boolean hasEmptyCells = false;
				int count = 0;
				DataSet<Cell> inspectedCells = new DynaArray<>();
				for (int k = 0; k < winCount; k++) {
					inspectedCells.add(new Cell(i, j + k));
					if (gameTable.getValue(i, j + k) == cellValue) {
						count++;
					} else if (gameTable.getValue(i, j + k) == CellValue.EMPTY) {
						hasEmptyCells = true;
					} else {
						hasEmptyCells = false;
						break;
					}
				}
				if (count == notBlankCount && hasEmptyCells) {
					return makeTurnToOneCellFromDataSet(inspectedCells);
				}
			}
			return null;
		}
		
		
		
		
	}
}
