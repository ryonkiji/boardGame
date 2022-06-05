package boardGame.judg;

import boardGame.board.OthelloBoard;
import boardGame.consts.OthelloConsts;
import boardGame.consts.StoneColor;

/**
 * オセロ判定クラス
 *
 * @author kijima
 *
 */
public class OthelloJudg {

	/**
	 * 盤面にコマが置けるかどうかを問い合わせる
	 *
	 * @param board
	 * @param playerList
	 * @return
	 */
	public boolean isEmptySpace(OthelloBoard board) {
		if (isEmptySpace(board, StoneColor.WHITE.getColorNum()) && isEmptySpace(board, StoneColor.BLACK.getColorNum())) {
			return true;
		}
		return false;
	}

	/**
	 * 1マスずつ盤面にコマを置く箇所があるかを問い合わせる
	 *
	 * @param board
	 *
	 * @return
	 */
	public boolean isEmptySpace(OthelloBoard board, int color) {
		for (int y = 1; y < OthelloConsts.MASU; y++) {
			for (int x = 1; x < OthelloConsts.MASU; x++) {
				if (board.canPut(y, x, color)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * マスにコマが置けるか否かを判定
	 *
	 * @param board
	 *
	 * @param y
	 * @param x
	 */
	public boolean canPut(OthelloBoard board, int y, int x, int stoneColor) {
		return board.canPut(y, x, stoneColor);
	}

	/**
	 * 勝敗判定
	 *
	 * @param board
	 */
	public void whichWinner(OthelloBoard board) {

		// コマ（白）の合計を問い合わせる
		int whiteStoneNum = board.getWhiteStoneTotal();
		// コマ（黒）の合計を問い合わせる
		int blackStoneNum = board.getBlackStoneTotal();

		if (whiteStoneNum > blackStoneNum) {
			System.out.println("自分(白)の勝ち!");
		} else {
			System.out.println("相手(黒)の勝ち!");
		}
	}

}
