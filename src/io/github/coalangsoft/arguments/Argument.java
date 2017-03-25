package io.github.coalangsoft.arguments;

public class Argument {

	public final boolean exists;
	public final String value;

	Argument(boolean exists, String value) {
		if(!exists && value != null){
			throw new IllegalStateException("An Argument has to exist to have a value!");
		}
		this.exists = exists;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Argument [exists=" + exists + ", value=" + value + "]";
	}

}
