package Interfaces;

import java.util.Arrays;

public class EnumTest {

	enum CellValue {
		EMPTY(' '), 
		HUMAN('X'), 
		COMPUTER('O');
		private char value;
		
		private CellValue(char value) {
			this.value = value;
		}
		public char getValue() {
			return value;
		}
		public boolean isFigure() {
			return this != EMPTY;
		}
	}

	public static void main(String[] args) {
		CellValue cellValue = null;
		cellValue = cellValue.HUMAN;
		System.out.println(cellValue.name());
		System.out.println(cellValue.ordinal());
		System.out.println(cellValue.toString());

		System.out.println(Arrays.toString(CellValue.values()));

		cellValue = CellValue.valueOf("COMPUTER");
		System.out.println(cellValue.name());
		System.out.println(cellValue.ordinal());
		System.out.println(cellValue.toString());

		cellValue = cellValue.HUMAN;
		System.out.println(cellValue.getValue() + "->" + cellValue.isFigure());
		System.out.println(cellValue.COMPUTER.getValue() + "->" + CellValue.COMPUTER.isFigure());
		System.out.println(cellValue.EMPTY.getValue() + "->" + CellValue.EMPTY.isFigure());
	}

}
