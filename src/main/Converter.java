package main;

public abstract class Converter<S, D> {
	public abstract D convert(S source);

}