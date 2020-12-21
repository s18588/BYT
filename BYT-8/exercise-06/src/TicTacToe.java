public class TicTacToe {
	public StringBuffer board;

	public TicTacToe(String s) {
		board = new StringBuffer(s);
	}

	public TicTacToe(String s, int position, char player) {
		board = new StringBuffer(s);
		board.setCharAt(position, player);
	}

	private boolean checkSpace(){
		for (int i = 0; i < 9; i++) {
			if (board.charAt(i) == '-')
				return true;
		}
		return false;
	}

	public int suggestMove(char player) {
		for (int i = 0; i < 9; i++) {
			if (board.charAt(i) == '-') {
				TicTacToe game = makeMove(i, player);
				if (game.winner() == player)
					return i;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (board.charAt(i) == '-')
				return i;
		}

		return -1;
	}


	public TicTacToe makeMove(int i, char player) {
		return new TicTacToe(board.toString(), i, player);
	}

	public char checkHorizontalWinner() {
		for (int i = 0; i < 9; i += 3) {
			if (board.charAt(i) != '-'
					&& board.charAt(i + 1) == board.charAt(i)
					&& board.charAt(i + 2) == board.charAt(i))
				return board.charAt(i);
		}
		return '-';
	}

	public char checkVerticalWinner() {
		for (int i = 0; i < 3; ++i) {
			if (board.charAt(i) != '-'
					&& board.charAt(i + 3) == board.charAt(i)
					&& board.charAt(i + 6) == board.charAt(i))
				return board.charAt(i);
		}
		return '-';
	}

	public char checkDiagonalWinner() {
		// check for diagonal winner
		if (board.charAt(0) != '-' && board.charAt(4) == board.charAt(0)
				&& board.charAt(8) == board.charAt(0))
			return board.charAt(0);
		if (board.charAt(2) != '-' && board.charAt(4) == board.charAt(2)
				&& board.charAt(6) == board.charAt(2))
			return board.charAt(2);
		return '-';
	}


	public char winner() {
		if(checkVerticalWinner()!='-') return checkVerticalWinner();
		if(checkDiagonalWinner()!='-') return checkDiagonalWinner();
		if(checkHorizontalWinner()!='-') return checkHorizontalWinner();
		return '-';
	}
}
