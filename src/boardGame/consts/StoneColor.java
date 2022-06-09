package boardGame.consts;

import boardGame.exception.SystemErrorException;

/**
 * コマの色に関する定数クラス
 *
 * @author kijima
 *
 */
public enum StoneColor {

	BRANK("", "", OthelloConsts.BLANK, "   "), WHITE("自分", "白", OthelloConsts.WHITE_STONE, " ○ "), BLACK("相手", "黒", OthelloConsts.BLACK_STONE, " ● ");

	/**
	 * 名前
	 */
	private final String name;

	/**
	 * 色
	 */
	private final String color;

	/**
	 * 色彩値
	 */
	private final int colorNum;

	/**
	 * 表示文字列
	 */
	private final String displayValue;

	/**
	 * コンストラクタ
	 *
	 * @param id
	 */
	private StoneColor(String name, String color, int colorNum, String displayValue) {
		this.name = name;
		this.color = color;
		this.colorNum = colorNum;
		this.displayValue = displayValue;
	}

	/**
	 * 名前を返却
	 *
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 色を返却
	 *
	 * @return
	 */
	public String getColor() {
		return color;
	}

	/**
	 * 色彩値を返却
	 *
	 * @return
	 */
	public int getColorNum() {
		return colorNum;
	}

	/**
	 * 色彩値を返却
	 *
	 * @return
	 * @throws SystemErrorException
	 */
	public static StoneColor getByColorNum(int colorNum) throws SystemErrorException {

		if (WHITE.getColorNum() == colorNum) {
			return WHITE;
		} else if (BLACK.getColorNum() == colorNum) {
			return BLACK;
		} else if (BRANK.getColorNum() == colorNum) {
			return BRANK;
		} else {
			throw new SystemErrorException();
		}
	}

	/**
	 * 表示文字列
	 *
	 * @return
	 */
	public String getDisplayValue() {
		return displayValue;
	}
}
