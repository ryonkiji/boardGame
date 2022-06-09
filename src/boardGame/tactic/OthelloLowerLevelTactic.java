package boardGame.tactic;

import boardGame.board.OthelloBoard;

/**
 * オセロ初級戦術クラス
 *
 * @author kijima
 *
 */
public class OthelloLowerLevelTactic implements OthelloTactic {

	/**
	 * コマを任意のマスに置く
	 *
	 * @param board
	 * @param stoneColor
	 */
	public void put(OthelloBoard board, int color) {

		// 一番初めにヒットしたコマが置ける座標を取得
		for (int y = 1; y < OthelloBoard.masu; y++) {
			for (int x = 1; x < OthelloBoard.masu; x++) {
				if (board.canReverse(y, x, color)) {
					// 座標にコマを置く
					board.put(y, x, color);
				}
			}
		}
	}
}