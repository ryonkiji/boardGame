package boardGame.tactic;

import boardGame.board.OthelloBoard;

/**
 * オセロ戦術インターフェース
 *
 * @author kijima
 *
 */
public interface OthelloTactic {

	/**
	 * コマを任意のマスに置く
	 *
	 * @param board
	 * @param stoneColor
	 */
	public abstract void put(OthelloBoard board, int stoneColor);
}
