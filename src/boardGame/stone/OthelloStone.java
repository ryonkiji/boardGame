package boardGame.stone;

import boardGame.consts.OthelloConsts;
import boardGame.message.OthelloMessage;

/**
 * Counterクラス
 *
 * @author kijima
 *
 */
public class OthelloStone implements Stone {

	/**
	 * コマ（白）の合計
	 */
	private int whiteCount;

	/**
	 * コマ（黒）の合計
	 */
	private int blackCount;

	/**
	 * コマ数を計算
	 *
	 * @param board
	 *
	 * @return
	 */
	public void count(int[][] board) {

		// コマ（白）の合計
		int whiteCount = 0;

		// コマ（黒）の合計
		int blackCount = 0;

		// 一マスずつ集計
		for (int y = 0; y < OthelloConsts.MASU; y++) {
			for (int x = 0; x < OthelloConsts.MASU; x++) {
				// コマ（白）の場合
				if (board[y][x] == OthelloConsts.WHITE_STONE) {
					whiteCount++;
				}
				// コマ（黒）の場合
				else if (board[y][x] == OthelloConsts.BLACK_STONE) {
					blackCount++;
				}
			}
		}

		this.blackCount = blackCount;
		this.whiteCount = whiteCount;
	}

	/**
	 * コマ数を表示
	 *
	 * @return
	 */
	public void show() {
		OthelloMessage.whiteCountMsg(whiteCount);
		OthelloMessage.blackCountMsg(blackCount);
	}

	/**
	 * コマ（白）を集計する
	 */
	public int countWhiteStone(int[][] board) {

		// コマ（白）の合計
		int whiteCount = 0;
		for (int y = 0; y < OthelloConsts.MASU; y++) {
			for (int x = 0; x < OthelloConsts.MASU; x++) {
				if (board[y][x] == OthelloConsts.WHITE_STONE) {
					whiteCount++;
				}
			}
		}
		return whiteCount;
	}

	/**
	 * コマ（黒）を集計する
	 */
	public int countBlackStone(int[][] board) {

		// コマ（黒）の合計
		int blackCount = 0;
		for (int y = 0; y < OthelloConsts.MASU; y++) {
			for (int x = 0; x < OthelloConsts.MASU; x++) {
				if (board[y][x] == OthelloConsts.BLACK_STONE) {
					blackCount++;
				}
			}
		}
		return blackCount;
	}
}
