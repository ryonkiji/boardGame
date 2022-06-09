package boardGame.setting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import boardGame.exception.InputErrorException;
import boardGame.exception.SystemErrorException;

/**
 * オセロの設定クラス
 *
 * @author kijima
 *
 */
public class OthelloSetting implements Setting {

	/**
	 * 入力受付オブジェクト
	 */
	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * 設定情報を受け付ける
	 *
	 * @throws SystemErrorException
	 * @throws InputErrorException
	 */
	public String inputMode() throws InputErrorException {

		// 入力
		String input = null;

		// 判定
		boolean isInputOk = false;

		// 正しい入力を受け付けるまで繰り返し入力を求める
		while (!isInputOk) {
			try {
				// 入力受付
				System.out.println("対戦モードを入力して下さい。");
				System.out.println("　1：対人対戦");
				System.out.println("　2：初級CPU対戦");
				// System.out.println(" 3：中級CPU対戦");
				// System.out.println(" 4：上級CPU対戦");
				input = br.readLine();

				// 論理チェック
				if (isCorrectMode(input)) {
					isInputOk = true;
					break;
				}

				System.out.println("※対戦モードを正しく入力して下さい。");
				System.out.println("　1：対人対戦");
				System.out.println("　2：初級CPU対戦");
				// System.out.println(" 3：中級CPU対戦");
				// System.out.println(" 4：上級CPU対戦");

			} catch (IOException e) {
				throw new InputErrorException(e);
			}
		}
		return input;
	}

	/**
	 * 正しく対戦モードが入力されたか判定する
	 *
	 * @param input
	 */
	public boolean isCorrectMode(String input) {

		if ("1".equals(input) || "2".equals(input)) {
			return true;
		}

		return false;
	}
}
