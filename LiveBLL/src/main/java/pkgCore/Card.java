package pkgCore;

import java.io.Serializable;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Card implements Comparable<Card>,  Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private eSuit eSuitValue;
	private eRank eRankValue;
	public boolean isWild;
	
	public Card (eSuit _eSuitValue, eRank _eRankValue)
	{
		this.eSuitValue = _eSuitValue;
		this.eRankValue = _eRankValue;
		this.isWild = false;
	}
	
	/**
	 * @version Lab #1
	 * @since Lab #1
	 * 
	 *        compareTo - set the generic sort order to sort by rank ascending
	 */
	@Override
	public int compareTo(Card o) {
		Card c = (Card) o;
		return c.geteRankValue().compareTo(this.geteRankValue());
	}

	/**
	 * @version Lab #1
	 * @since Lab #1
	 * 
	 *        equals - return 'true' if eSuit and eRank are the same.
	 */
	@Override
	public boolean equals(Object o) {
		// If the object is compared with itself then return true
		if (o == this) {
			return true;
		}

		/*
		 * Check if o is an instance of Complex or not "null instanceof [type]" also
		 * returns false
		 */
		if (!(o instanceof Card)) {
			return false;
		}

		// typecast o to Complex so that we can compare data members
		Card c = (Card) o;

		if ((c.geteRankValue().equals(this.geteRankValue())) && (c.geteSuitValue().equals(this.geteSuitValue())))

			return true;

		return false;
	}

	public eSuit geteSuitValue() {
		return eSuitValue;
	}

	public eRank geteRankValue() {
		return eRankValue;
	}

	public boolean isWild() {
		return isWild;
	}


	
}
