package boardGame.board;

import boardGame.consts.OthelloConsts;
import boardGame.stone.OthelloStone;

/**
 * オセロ用のボードクラス
 *
 * @author kijima
 *
 */
public class OthelloBoard implements Board {

	/**
	 * コマ
	 */
	private OthelloStone stone;

	/**
	 * 盤
	 */
	private int[][] board;

	/**
	 * コンストラクタ
	 */
	public OthelloBoard() {
		init();
	}

	/**
	 * 初期処理
	 */
	public void init() {
		// OthelloStoneクラスインスタンス化
		stone = new OthelloStone();
		// ボード作成
		create();
	}

	/**
	 * ボード作成
	 */
	public void create() {

		// 9*9マスの二次元配列を作成
		board = new int[OthelloConsts.MASU][OthelloConsts.MASU];

		// 全てのマスに初期値をセット
		for (int y = 0; y < OthelloConsts.MASU; y++) {
			for (int x = 0; x < OthelloConsts.MASU; x++) {
				board[y][x] = OthelloConsts.BLANK;
			}
		}

		// 原点
		board[0][0] = OthelloConsts.ORIGIN;

		// x軸, y軸に数字を並べる
		for (int i = 1; i < OthelloConsts.MASU; i++) {
			// x軸に数字を並べる
			board[0][i] = i;
			// y軸に数字を並べる
			board[i][0] = i;
		}

		// 初期位置にコマを配置
		board[4][4] = board[5][5] = OthelloConsts.WHITE_STONE;
		board[4][5] = board[5][4] = OthelloConsts.BLACK_STONE;
	}

	/**
	 * 盤面のコマ数を集計
	 */
	public void calc() {
		stone.count(board);
	}

	/**
	 * 盤面を表示
	 */
	public void show() {

		// コマ数を表示
		stone.show();

		// 盤面を表示
		for (int y = 0; y < OthelloConsts.MASU; y++) {
			for (int x = 0; x < OthelloConsts.MASU; x++) {

				if (y == 0 && x == 0) {
					System.out.print("y|x");
				}

				if (y == 0 && x > 0) {
					System.out.print(" " + board[0][x] + " ");
				}

				if (y > 0 && x == 0) {
					System.out.print(" " + board[y][0] + " ");
				}

				// 白の場合
				if (board[y][x] == OthelloConsts.WHITE_STONE) {
					System.out.print(" ○ ");
				}
				// 黒の場合
				else if (board[y][x] == OthelloConsts.BLACK_STONE) {
					System.out.print(" ● ");
				}
				// 何もない場合
				else if (board[y][x] == OthelloConsts.BLANK) {
					System.out.print("   ");
				}
			}
			System.out.print(OthelloConsts.CRLF);
		}
	}

	/**
	 * 座標(y, x)にコマが置けるかどうかを判定
	 *
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean canPut(int y, int x, int color) {

		// 座標(y, x)が盤の範囲内に収まるどうか判定
		if (x >= OthelloConsts.MASU || y >= OthelloConsts.MASU) {
			return false;
		}
		// 座標(y, x)に既にコマが置かれているかどうかを判定
		if (board[y][x] != OthelloConsts.BLANK) {
			return false;
		}
		// 座標(y, x)から上方向に同じ色のコマがあるかどうかを判定
		if (canPut(y, x, -1, 0, color)) {
			return true;
		}
		// 座標(y, x)から右斜め上方向に同じ色のコマがあるかどうかを判定
		if (canPut(y, x, -1, 1, color)) {
			return true;
		}
		// 座標(y, x)から右方向に同じ色のコマがあるかどうかを判定
		if (canPut(y, x, 0, 1, color)) {
			return true;
		}
		// 座標(y, x)から右斜め下方向に同じ色のコマがあるかどうかを判定
		if (canPut(y, x, 1, 1, color)) {
			return true;
		}
		// 座標(y, x)から下方向に同じ色のコマがあるかどうかを判定
		if (canPut(y, x, 1, 0, color)) {
			return true;
		}
		// 座標(y, x)から左斜め下方向に同じ色のコマがあるかどうかを判定
		if (canPut(y, x, 1, -1, color)) {
			return true;
		}
		// 座標(y, x)から左方向に同じ色のコマがあるかどうかを判定
		if (canPut(y, x, 0, -1, color)) {
			return true;
		}
		// 座標(y, x)から左斜め上方向に同じ色のコマがあるかどうかを判定
		if (canPut(y, x, -1, -1, color)) {
			return true;
		}
		return false;
	}

	/**
	 * 座標(y, x)からベクトルの先にマスを進めた場合にコマをひっくり返せるかどうかを判定
	 *
	 * @param x
	 * @param y
	 * @param vecX
	 * @param vecY
	 * @return
	 */
	private boolean canPut(int y, int x, int vecY, int vecX, int color) {

		// ベクトルの方向にマスを進める
		y += vecY;
		x += vecX;

		// 現在のコマの位置情報が盤の範囲外の場合、false
		if (x < 0 || x >= OthelloConsts.MASU || y < 0 || y >= OthelloConsts.MASU) {
			return false;
		}

		// 座標(y, x)に同じ色のコマが置かれている場合、false
		if (board[y][x] == color) {
			return false;
		}

		// 座標(y, x)にコマが置かれていない場合、false
		if (board[y][x] == OthelloConsts.BLANK) {
			return false;
		}

		// ベクトルの方向にマスを進める
		y += vecY;
		x += vecX;

		// ベクトルの先に同じ色のコマが出現するまで繰り返し行う
		while (x >= 0 && x < OthelloConsts.MASU && y >= 0 && y < OthelloConsts.MASU) {

			// 座標(y, x)にコマが置かれていない場合、false
			if (board[y][x] == OthelloConsts.BLANK) {
				return false;
			}

			// ベクトルの先に同じ色のコマが出現した場合、true
			if (board[y][x] == color) {
				return true;
			}

			// ベクトルの方向にマスを進める
			y += vecY;
			x += vecX;
		}

		return false;
	}

	/**
	 * 指定座標にコマを置く
	 *
	 * @param xy
	 * @param i
	 */
	public void put(int[] yx, int color) {

		// x座標, y座標を取得する
		int y = yx[0];
		int x = yx[1];

		// 座標にコマを配置
		board[y][x] = color;

		// コマをひっくり返す
		reverse(y, x, color);
	}

	/**
	 * 座標(y, x)のコマをひっくり返す
	 *
	 * @param x
	 * @param y
	 * @param color
	 */
	public void reverse(int y, int x, int color) {

		// 座標(y, x)から上方向のコマをひっくり返す
		if (canPut(y, x, -1, 0, color)) {
			reverse(y, x, -1, 0, color);
		}
		// 座標(y, x)から右斜め上方向のコマをひっくり返す
		if (canPut(y, x, -1, 1, color)) {
			reverse(y, x, -1, 1, color);
		}
		// 座標(y, x)から右方向のコマをひっくり返す
		if (canPut(y, x, 0, 1, color)) {
			reverse(y, x, 0, 1, color);
		}
		// 座標(y, x)から右斜め下方向のコマをひっくり返す
		if (canPut(y, x, 1, 1, color)) {
			reverse(y, x, 1, 1, color);
		}
		// 座標(y, x)から下方向のコマをひっくり返す
		if (canPut(y, x, 1, 0, color)) {
			reverse(y, x, 1, 0, color);
		}
		// 座標(y, x)から左斜め下方向のコマをひっくり返す
		if (canPut(y, x, 1, -1, color)) {
			reverse(y, x, 1, -1, color);
		}
		// 座標(y, x)から左方向のコマをひっくり返す
		if (canPut(y, x, 0, -1, color)) {
			reverse(y, x, 0, -1, color);
		}
		// 座標(y, x)から左斜め上方向のコマをひっくり返す
		if (canPut(y, x, -1, -1, color)) {
			reverse(y, x, -1, -1, color);
		}
	}

	/**
	 * 座標(y, x)からベクトルの先のコマをひっくり返す
	 *
	 * @param y
	 * @param x
	 * @param vecY
	 * @param vecX
	 * @param color
	 */
	public void reverse(int y, int x, int vecY, int vecX, int color) {

		// ベクトルの方向にマスを進める
		y += vecY;
		x += vecX;

		// 同じ色のコマが出現するまでコマをひっくり返す
		while (board[y][x] != color) {
			board[y][x] = color;
			y += vecY;
			x += vecX;
		}
	}

	/**
	 * コマ（白）の合計値を取得する
	 *
	 * @return
	 */
	public int getWhiteStoneTotal() {
		return stone.countWhiteStone(board);
	}

	/**
	 * コマ（黒）の合計値を取得する
	 *
	 * @return
	 */
	public int getBlackStoneTotal() {
		return stone.countBlackStone(board);
	}
}
