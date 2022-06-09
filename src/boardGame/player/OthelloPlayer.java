package boardGame.player;

import boardGame.board.OthelloBoard;
import boardGame.consts.GameMode;
import boardGame.consts.StoneColor;
import boardGame.tactic.OthelloLowerLevelTactic;
import boardGame.tactic.OthelloManualTactic;
import boardGame.tactic.OthelloTactic;

/**
 * オセロゲームに参加するプレイヤークラス
 *
 * @author kijima
 *
 */
public class OthelloPlayer implements Player {

	/**
	 * 名前
	 */
	private final String name;

	/**
	 * コマの色
	 */
	private final String stoneColorStr;

	/**
	 * コマの色
	 */
	private final int stoneColor;

	/**
	 * 自分のターンかどうか
	 */
	private boolean isMyTurn;

	/**
	 * 戦術
	 */
	private OthelloTactic tactic;

	public String getName() {
		return name;
	}

	/**
	 * コンストラクタ
	 *
	 * @param mode
	 */
	public OthelloPlayer() {
		this.name = StoneColor.WHITE.getName();
		this.stoneColorStr = StoneColor.WHITE.getColor();
		this.stoneColor = StoneColor.WHITE.getColorNum();
		this.isMyTurn = true;
		tactic = new OthelloManualTactic();
	}

	/**
	 * コンストラクタ
	 */
	public OthelloPlayer(String mode) {
		this.name = StoneColor.BLACK.getName();
		this.stoneColorStr = StoneColor.BLACK.getColor();
		this.stoneColor = StoneColor.BLACK.getColorNum();
		if (GameMode.PRACTICE.getMode().equals(mode)) {
			tactic = new OthelloManualTactic();
		} else if (GameMode.LOWER.getMode().equals(mode)) {
			tactic = new OthelloLowerLevelTactic();
		}
	}

	/**
	 * コマを配置
	 *
	 * @param board
	 */
	public void put(OthelloBoard board) {

		System.out.println(name + "(" + stoneColorStr + ")のターン！");

		// 戦術に基づきコマを任意のマスに置く
		tactic.put(board, stoneColor);
	}

	/**
	 * 自分のターンかどうかを判定
	 */
	public boolean isMyTurn() {
		return isMyTurn;
	}

	/**
	 * ターンを切り替える
	 */
	public void nextTurn() {
		this.isMyTurn = !isMyTurn;
	}
}
