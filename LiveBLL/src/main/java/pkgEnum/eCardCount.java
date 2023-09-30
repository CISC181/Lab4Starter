package pkgEnum;

/**
 * 
 * eCardCount - the card count.
 * 
 * @author BRG
 * @version Lab #3
 * @since Lab #3
 *
 */
public enum eCardCount {
	One(1), Two(2), Three(3), Four(4), Five(5);

	private eCardCount(final int CardCount) {
		this.CardCount = CardCount;
	}

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        CardCount - Card Count value
	 */
	private int CardCount;

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        getCardCount - getter for Card Count
	 * 
	 * @return - CardCount
	 */
	public int getCardCount() {
		return CardCount;
	}
}