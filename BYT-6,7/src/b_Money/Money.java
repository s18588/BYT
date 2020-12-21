package b_Money;

public class Money implements Comparable<Money> {
	private int amount;
	private Currency currency;

	Money (Integer amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Integer getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	@Override
	public String toString() {
		return ((double)amount/100)+" "+ currency.getName();
	}

	public Integer universalValue() {
		return currency.universalValue(amount);
	}
	

	public Boolean equals(Money other) {
		if (this == other) return true;
		if (!(other instanceof Money)) return false;
		else {
			return universalValue() == other.universalValue();
		}

	}

	public Money add(Money other) {
		return
				new Money(
						amount+other.getCurrency().valueInThisCurrency(other.amount, currency),
						currency);
	}

	public Money sub(Money other) {
		return
				new Money(
						amount-other.getCurrency().valueInThisCurrency(other.amount, currency),
						currency);
	}

	public Boolean isZero() {
		return (double)amount==0.0;
	}

	public Money negate() {
		return new Money(-amount,currency);
	}

	public int compareTo(Money other) {
		return Integer.compare(universalValue(), other.universalValue());
	}
}