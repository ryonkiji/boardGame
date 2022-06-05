package boardGame.consts;

/**
 * コマの色に関する定数クラス
 *
 * @author kijima
 *
 */
public enum StoneColor {

	WHITE("白", OthelloConsts.WHITE_STONE), BLACK("黒", OthelloConsts.BLACK_STONE);

	/**
	 * 色
	 */
	private final String color;

	/**
	 * 色彩値
	 */
	private final int colorNum;

	/**
	 * コンストラクタ
	 *
	 * @param id
	 */
	private StoneColor(String color, int colorNum) {
		this.color = color;
		this.colorNum = colorNum;
	}

	/**
	 * ゲームIDを返却
	 *
	 * @return
	 */
	public String getColor() {
		return color;
	}

	/**
	 * ゲームIDを返却
	 *
	 * @return
	 */
	public int getColorNum() {
		return colorNum;
	}
}
