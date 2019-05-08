package main;

public class StringToIntegerConverter extends Converter<String, Integer> {
	@Override
	public Integer convert(String source) {
		return Integer.parseInt(source);
	}
}