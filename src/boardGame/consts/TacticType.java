package boardGame.consts;

/**
 * 戦術に関する定数クラス
 *
 * @author kijima
 *
 */
public enum TacticType {

	// 手動
	MANUAL("001"),
	WEEKAUTO("002"),
	MIDAUTO("003"),
	STRAUTO("004");

	private final String type;

	/**
	 * コンストラクタ
	 *
	 * @param type
	 */
	private TacticType(String type) {
		this.type = type;
	}

	/**
	 * 戦術タイプを返却
	 *
	 * @return
	 */
	public String getType() {
		return type;
	}
}
