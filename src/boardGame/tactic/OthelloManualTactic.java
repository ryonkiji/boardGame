package boardGame.tactic;

import java.util.Scanner;

import boardGame.board.OthelloBoard;
import boardGame.judg.OthelloJudg;

/**
 * オセロ手動戦術クラス
 *
 * @author kijima
 *
 */
public class OthelloManualTactic implements OthelloTactic {

	/**
	 * コマを任意のマスに置く
	 *
	 * @param board
	 * @param stoneColor
	 */
	public void put(OthelloBoard board, int color) {

		Scanner s = new Scanner(System.in);
		OthelloJudg judg = new OthelloJudg();

		// 入力
		int y = 0;
		int x = 0;

		// 判定
		boolean isInputOk = false;

		// 正しい入力を受け付けるまで繰り返し入力を求める
		while (!isInputOk) {

			try {
				// y座標入力受付
				System.out.println("コマを置くy座標を入力して下さい。");
				y = s.nextInt();

				// x座標入力受付
				System.out.println("コマを置くx座標を入力して下さい。");
				x = s.nextInt();
			} catch (Exception e) {
				System.out.println("1~8の数字を入力して下さい。");
				put(board, color);
			}

			// 論理チェック
			if (judg.canReverse(board, y, x, color)) {
				isInputOk = true;
				break;
			}

			System.out.println("指定箇所にコマを置けません。もう一度入力して下さい。");
		}

		// 座標にコマを置く
		board.put(y, x, color);
	}
}
