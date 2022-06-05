package boardGame;

import boardGame.consts.GameType;
import boardGame.controller.GameController;
import boardGame.controller.OthelloController;

/**
 * Mainクラス
 *
 * @author kijima
 *
 */
public class BoardGame {

	public BoardGame(String[] args) {
		GameController game = new OthelloController();

		// 引数エラー
		if (args == null || args.length == 0) {
			System.out.println("ゲーム種目番号を入力して下さい。");
		}
		// オセロ
		else if (GameType.Othello.getId().equals(args[0])) {
			game = new OthelloController();
		}
		// 引数エラー
		else {
			System.out.println("ゲーム種目番号を確認して下さい。");
			System.out.println("オセロ：001");
		}

		// ゲーム開始
		game.execute();
	}

	public static void main(String[] args) {
		BoardGame main = new BoardGame(args);
	}

}
