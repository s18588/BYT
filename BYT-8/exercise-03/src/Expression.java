public class Expression {

	private IEvaluable evaluate;

	public Expression(int constant) {
		this.evaluate = new EvaluateConstant(constant);
	}

	public Expression(char op, Expression left, Expression right) {
		this.evaluate = new Evaluate(op, left, right);
	}

	public int evaluate() {
		return evaluate.evaluate();
	}
}
