package b_Money;

import java.util.Hashtable;

public class Bank {
	private Hashtable<String, Account> accountlist = new Hashtable<String, Account>();
	private String name;
	private Currency currency;

	Bank(String name, Currency currency) {
		this.name = name;
		this.currency = currency;
	}

	public String getName() {
		return name;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void openAccount(String accountid) throws AccountExistsException, AccountDoesNotExistException {
		if (accountlist.containsKey(accountid)) throw new AccountExistsException();
		Account account = new Account(accountid, currency);
		accountlist.put(accountid, account);
	}


	public Account getAccount(String accountId) throws AccountDoesNotExistException{
		if (!accountlist.containsKey(accountId))  throw new AccountDoesNotExistException();
		return accountlist.get(accountId);
	}

	public void deposit(String accountid, Money money) throws AccountDoesNotExistException {
		if (getAccount(accountid)==null) {
			throw new AccountDoesNotExistException();
		}
		else {
			getAccount(accountid).deposit(money);
		}
	}

	public void withdraw(String accountid, Money money) throws AccountDoesNotExistException {
		if (getAccount(accountid)==null) {
			throw new AccountDoesNotExistException();
		}
		else {
			getAccount(accountid).withdraw(money);
		}
	}
	

	public Integer getBalance(String accountid) throws AccountDoesNotExistException {
		if (getAccount(accountid)==null) {
			throw new AccountDoesNotExistException();
		}
		else {
			return getAccount(accountid).getBalance().getAmount();
		}
	}


	public void transfer(String fromAccount, Bank toBank, String toAccount, Money amount) throws AccountDoesNotExistException {
		getAccount(fromAccount).withdraw(amount);
		toBank.getAccount(toAccount).deposit(amount);
	}


	public void transfer(String fromAccount, String toAccount, Money amount) throws AccountDoesNotExistException {
		transfer(fromAccount, this, toAccount, amount);
	}

	/**
	 * Add a timed payment
	 * @param accountid Id of account to deduct from in this Bank
	 * @param payid Id of timed payment
	 * @param interval Number of ticks between payments
	 * @param next Number of ticks till first payment
	 * @param amount Amount of Money to transfer each payment
	 * @param tobank Bank where receiving account resides
	 * @param toaccount Id of receiving account
	 */
	public void addTimedPayment(String accountid, String payid, Integer interval, Integer next, Money amount, Bank tobank, String toaccount) throws AccountDoesNotExistException {
		Account account = getAccount(accountid);
		account.addTimedPayment(payid, interval, next, amount, tobank, toaccount);
	}
	
	/**
	 * Remove a timed payment
	 * @param accountid Id of account to remove timed payment from
	 * @param id Id of timed payment
	 */
	public void removeTimedPayment(String accountid, String id) throws AccountDoesNotExistException {
		getAccount(accountid).removeTimedPayment(id);
	}
	
	/**
	 * A time unit passes in the system
	 */
	public void tick() throws AccountDoesNotExistException {
		for (Account account : accountlist.values()) {
			account.tick();
		}
	}	
}
