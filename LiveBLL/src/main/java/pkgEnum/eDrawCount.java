package pkgEnum;

/**
 * @author BRG
 * @version Lab #3
 * @since Lab #3
 * 
 *        eDrawCount - The draw count.
 */
public enum eDrawCount {

	FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5), SIXTH(6), SEVENTH(7), EIGHTH(8), NINTH(9), TENTH(10);

	private eDrawCount(final int DrawNo) {
		this.DrawNo = DrawNo;
	}

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        DrawNo - Draw Number value
	 */
	private int DrawNo;

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3 getDrawNo - getter for Draw Number
	 * 
	 * @return - return the draw number
	 */
	public int getDrawNo() {
		return DrawNo;
	}

}