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
	 * コマを置く位置情報を取得
	 *
	 * @param board
	 * @param color
	 * @return
	 */
	public abstract int[] getPosition(OthelloBoard board, int color);
}
