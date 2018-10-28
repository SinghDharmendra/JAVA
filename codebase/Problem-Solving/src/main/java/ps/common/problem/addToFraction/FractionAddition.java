package ps.common.problem.addToFraction;

public class FractionAddition {
	static int den3;
	static int num3;

	int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	void lowest(int den, int num) {
		int common_factor = gcd(num, den);
		den3 = den / common_factor;
		num3 = num / common_factor;
	}

	void addFraction(int num1, int den1, int num2, int den2) throws InputValidation {
		validateInput(den1, den2);
		den3 = gcd(den1, den2);
		den3 = (den1 * den2) / den3;
		num3 = (num1) * (den3 / den1) + (num2) * (den3 / den2);
		lowest(den3, num3);
	}

	private void validateInput(int den1, int den2) throws InputValidation {
		if (den1 == 0 || den2 == 0) {
			System.out.println("One of den is 0");
			throw new InputValidation("invalid_input", "One of Denum is zero");
		}
	}

	public static void main(String[] args) {
		int num1 = 1, den1 = 500, num2 = 2, den2 = 0;
		FractionAddition fd = new FractionAddition();
		try {
			fd.addFraction(num1, den1, num2, den2);
		} catch (InputValidation e) {
			System.out.println(e.getErrorCode() + "\nDesc :" + e.getErrorDesc());
			return;

		}
		System.out.println(den3);
		System.out.println(num3);
	}

}

class InputValidation extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorDesc;

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public InputValidation(String errorCode, String errorDesc) {
		this.errorDesc = errorDesc;
		this.errorCode = errorCode;

	}
}
