package boardGame.message;

/**
 * Messageクラス
 *
 * @author kijima
 *
 */
public class OthelloMessage {

	/**
	 * 白の合計値を出力
	 *
	 * @param whiteCount
	 */
	public static void whiteCountMsg(int whiteCount) {
		System.out.println("白の合計：" + whiteCount);
	}

	/**
	 * 黒の合計値を出力
	 *
	 * @param blackCount
	 */
	public static void blackCountMsg(int blackCount) {
		System.out.println("黒の合計：" + blackCount);
	}

}
