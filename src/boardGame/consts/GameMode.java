package boardGame.consts;

/**
 * ゲームモードに関する定数クラス
 *
 * @author kijima
 *
 */
public enum GameMode {

	// 対人対戦モード
	PRACTICE("1"),
	// 初級CPU対戦モード
	LOWER("2"),
	// 中級CPU対戦モード
	MIDDLE("3"),
	// 上級CPU対戦モード
	UPPER("4");

	private final String mode;

	/**
	 * コンストラクタ
	 *
	 * @param mode
	 */
	private GameMode(String mode) {
		this.mode = mode;
	}

	/**
	 * ゲームモードを返却
	 *
	 * @return
	 */
	public String getMode() {
		return mode;
	}
}
