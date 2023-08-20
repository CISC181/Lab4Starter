package pkgCore;

import java.io.Serializable;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Card implements Comparable<Card>, Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	/**
	 * @version Lab #1
	 * @since Lab #1
	 * 
	 *        eSuit - enum for Suit of the Card
	 */

	private eSuit eSuitValue;

	/**
	 * @version Lab #1
	 * @since Lab #1
	 * 
	 *        eRank - enum for Rank of the Card
	 */
	private eRank eRankValue;

	/**
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        Wild - signifies if the card is 'Wild' or not. If Wild, it can be
	 *        substituted by any other card
	 */
	private boolean Wild;
	
	/**
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        Wild - signifies if the card is 'Wild' or not. If Wild, it can be
	 *        substituted by any other card
	 */
	private short sCardNbr;	

	/**
	 * @version Lab #1
	 * @since Lab #1 *
	 * @param _eSuitValue
	 * @param _eRankValue
	 */
		
		
		public Card(eSuit _eSuitValue, eRank _eRankValue, short _sCardNbr) {
			this(_eRankValue,_eSuitValue, _sCardNbr);
			this.Wild = false;
		}

		/**
		 * @version Lab #1
		 * @since Lab #1
		 * @param eSuit - Given suit of the Card
		 * @param eRank - Given rank of the Card
		 * 
		 *              Create an instance of the Card class
		 */
		public Card(pkgEnum.eRank _eRankValue, pkgEnum.eSuit _eSuitValue , short _sCardNbr) {
			super();
			this.eSuitValue = _eSuitValue;
			this.eRankValue = _eRankValue;
			this.Wild = false;
			this.sCardNbr = _sCardNbr;
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

		// TODO: Uncomment this after you add the attributes
		/*
		 * if ((c.geteRankValue().equals(this.geteRankValue())) &&
		 * (c.geteSuitValue().equals(this.geteSuitValue())))
		 * 
		 * return true;
		 */
		return false;
	}

	public eSuit geteSuitValue() {
		return eSuitValue;
	}

	public eRank geteRankValue() {
		return eRankValue;
	}

	public boolean isWild() {
		return Wild;
	}

	public short getsCardNbr() {
		return sCardNbr;
	}

 

}
