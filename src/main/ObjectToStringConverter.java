package main;

public class ObjectToStringConverter extends Converter<Object, String> {
	@Override
	public String convert(Object source) {
		return String.valueOf(source);
	}
}
