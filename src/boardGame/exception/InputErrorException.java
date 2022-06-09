package boardGame.exception;

/**
 * 入力に関するエラー
 *
 * @author kijima
 *
 */
public class InputErrorException extends Exception {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 1L;

	Exception ex;

	public InputErrorException(Exception e) {
		this.ex = e;
	}

	public InputErrorException(String msg) {

	}

	public InputErrorException() {
	}
}
