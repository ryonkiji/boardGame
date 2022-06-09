package boardGame.setting;

import boardGame.exception.InputErrorException;

/**
 * 設定クラスのインターフェース
 *
 * @author kijima
 *
 */
public interface Setting {

	abstract String inputMode() throws InputErrorException;
}
