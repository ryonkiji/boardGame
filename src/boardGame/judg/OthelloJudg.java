package boardGame.judg;

import boardGame.board.OthelloBoard;
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
		if (board.isEmptySpace(StoneColor.WHITE.getColorNum()) && board.isEmptySpace(StoneColor.BLACK.getColorNum())) {
			return true;
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
	public boolean canReverse(OthelloBoard board, int y, int x, int stoneColor) {
		return board.canReverse(y, x, stoneColor);
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
