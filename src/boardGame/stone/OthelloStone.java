package boardGame.stone;

import boardGame.board.OthelloBoard;
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
	 * コマ数を表示
	 *
	 * @param board
	 *
	 * @return
	 */
	public void show(int[][] board) {

		// コマ（白）の数を表示
		countWhiteStone(board);
		OthelloMessage.whiteCountMsg(whiteCount);

		// コマ（黒）の数を表示
		countBlackStone(board);
		OthelloMessage.blackCountMsg(blackCount);
	}

	/**
	 * コマ（白）を集計する
	 */
	public int countWhiteStone(int[][] board) {

		// コマ（白）の合計
		int whiteCount = 0;
		for (int y = 0; y < OthelloBoard.masu; y++) {
			for (int x = 0; x < OthelloBoard.masu; x++) {
				if (board[y][x] == OthelloConsts.WHITE_STONE) {
					whiteCount++;
				}
			}
		}
		this.whiteCount = whiteCount;
		return whiteCount;
	}

	/**
	 * コマ（黒）を集計する
	 */
	public int countBlackStone(int[][] board) {

		// コマ（黒）の合計
		int blackCount = 0;
		for (int y = 0; y < OthelloBoard.masu; y++) {
			for (int x = 0; x < OthelloBoard.masu; x++) {
				if (board[y][x] == OthelloConsts.BLACK_STONE) {
					blackCount++;
				}
			}
		}
		this.blackCount = blackCount;
		return blackCount;
	}
}
