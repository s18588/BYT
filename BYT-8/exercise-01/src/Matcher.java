public class Matcher {
	public Matcher() {
	}

	public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {

		actual = clip(actual, clipLimit);
		if(!compareLength(expected,actual)) return false;
		return checkEntries(expected, actual, delta);

	}

	public int[] clip(int[] arr, int clipLimit) {
		var a = arr;
		for (int i = 0; i < a.length; i++)
			if (a[i] > clipLimit)
				a[i] = clipLimit;

		return a;
	}
	public boolean compareLength(int[] expected, int[] actual) {

		if (actual.length != expected.length) return false;
		else return true;
	}

	public boolean checkEntries(int[] expected, int[] actual, int delta) {

		for (int i = 0; i < actual.length; i++)
			if (Math.abs(expected[i] - actual[i]) > delta)
				return false;
		return true;
	}


}