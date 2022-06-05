package boardGame.consts;

/**
 * ゲームIDに関する定数クラス
 *
 * @author kijima
 *
 */
public enum GameType {

	// オセロ
	Othello("001");

	private final String id;

	/**
	 * コンストラクタ
	 *
	 * @param id
	 */
	private GameType(String id) {
		this.id = id;
	}

	/**
	 * ゲームIDを返却
	 *
	 * @return
	 */
	public String getId() {
		return id;
	}
}
