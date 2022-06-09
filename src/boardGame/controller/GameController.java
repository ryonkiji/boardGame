package boardGame.controller;

import boardGame.exception.InputErrorException;
import boardGame.exception.SystemErrorException;

/**
 * GameMasterの抽象クラス
 *
 * ※各ゲームのゲームマスタークラスはこのクラスを継承すること
 *
 * @author kijima
 *
 */
public abstract class GameController {

	/**
	 * ゲーム処理
	 */
	public void execute() {

		try {

			// 初期処理
			init();

			// ゲーム開始
			start();

			// ゲーム終了
			end();
		} catch (SystemErrorException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 初期処理
	 */
	public void init() {

		try {
			// 対戦モードを決める
			setMode();

			// プレイヤー作成
			createPlayer();

			// ボード作成
			createBoard();
		}
		// 入力エラーに関するエラー
		catch (InputErrorException e) {
			// System.out.println("入力エラーに関するエラーを検知しました。");
			e.printStackTrace();
		}

	}

	/**
	 * 対戦モードを決める
	 *
	 * @throws InputErrorException
	 */
	public abstract void setMode() throws InputErrorException;

	/**
	 * プレイヤー作成
	 */
	public abstract void createPlayer();

	/**
	 * ボード作成
	 */
	public abstract void createBoard();

	/**
	 * ゲーム開始
	 *
	 * @throws SystemErrorException
	 */
	public abstract void start() throws SystemErrorException;

	/**
	 * ゲーム終了
	 */
	public abstract void end();
}
