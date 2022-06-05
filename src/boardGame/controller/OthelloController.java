package boardGame.controller;

import boardGame.board.OthelloBoard;
import boardGame.exception.InputErrorException;
import boardGame.exception.SystemErrorException;
import boardGame.judg.OthelloJudg;
import boardGame.player.OthelloPlayer;
import boardGame.setting.OthelloSetting;
import boardGame.setting.Setting;

public class OthelloController extends GameController {

	/**
	 * 設定クラス
	 */
	public Setting setting;

	/**
	 * 対戦モード
	 */
	public String mode;

	/**
	 * マイプレイヤー
	 */
	public OthelloPlayer user;

	/**
	 * ライバルプレイヤー
	 */
	public OthelloPlayer rival;

	/**
	 * ボードクラス
	 */
	public OthelloBoard board;

	/**
	 * ボードクラス
	 */
	public OthelloJudg judg;

	/**
	 * 対戦モードを決める
	 *
	 * @throws SystemErrorException
	 * @throws InputErrorException
	 */
	public void setMode() throws InputErrorException {
		setting = new OthelloSetting();
		mode = setting.inputMode();
	}

	/**
	 * ユーザー作成
	 */
	public void createPlayer() {
		user = new OthelloPlayer();
		rival = new OthelloPlayer(mode);
	}

	/**
	 * ボード作成
	 */
	public void createBoard() {
		board = new OthelloBoard();
	}

	/**
	 * ゲーム開始
	 *
	 * @throws SystemErrorException
	 */
	@Override
	public void start() throws SystemErrorException {

		System.out.println("<<オセロゲーム開始！>>");

		// コマ数を計算
		board.calc();

		// 盤面を表示
		board.show();

		// 判定クラスインスタンス化
		judg = new OthelloJudg();

		boolean isContinue = judg.isEmptySpace(board);
		while (isContinue) {

			// マスにコマを置く
			if (user.isMyTurn()) {
				user.put(board);
			} else {
				rival.put(board);
			}

			// コマ数を計算
			board.calc();

			// 盤面を表示
			board.show();

			// 次のプレイヤーへ
			user.nextTurn();

			// 盤面にコマが置けるかどうかを問い合わせる
			isContinue = judg.isEmptySpace(board);
		}
	}

	/**
	 * ゲーム終了
	 */
	@Override
	public void end() {

		// 勝敗判定
		judg.whichWinner(board);

		System.out.println("<<オセロゲーム終了！>>");
	}
}
