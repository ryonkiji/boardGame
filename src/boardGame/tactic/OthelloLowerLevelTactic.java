package boardGame.tactic;

import boardGame.board.OthelloBoard;
import boardGame.consts.OthelloConsts;

/**
 * オセロ初級戦術クラス
 *
 * @author kijima
 *
 */
public class OthelloLowerLevelTactic implements OthelloTactic {

	/**
	 * コマを置く位置情報を取得
	 */
	public int[] getPosition(OthelloBoard board, int color) {

		// 一番初めにヒットしたコマが置ける座標を取得
		for (int y = 1; y < OthelloConsts.MASU; y++) {
			for (int x = 1; x < OthelloConsts.MASU; x++) {
				if (board.canPut(y, x, color)) {
					int[] num = { y, x };
					return num;
				}
			}
		}
		return null;
	}
}