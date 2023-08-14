package pkgCore;

import java.io.Serializable;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Card implements Comparable<Card>, Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	//TODO: Add four attributes 
	
	/**
	 * @version Lab #1
	 * @since Lab #1
	 * *
	 * @param _eSuitValue
	 * @param _eRankValue
	 */
	public Card(eSuit _eSuitValue, eRank _eRankValue) {
	}

	/**
	 * @version Lab #1
	 * @since Lab #1
	 * *
	 * @param _eSuitValue
	 * @param _eRankValue
	 */	
	public Card(eRank _eRankValue, eSuit _eSuitValue) {
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
		
		//TODO: Uncomment this after you add the attributes
		//return c.geteRankValue().compareTo(this.geteRankValue());
		
		//TODO: Remove return 0 after you add the attributes
		return 0;
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

		//TODO: Uncomment this after you add the attributes
		/*
		if ((c.geteRankValue().equals(this.geteRankValue())) && (c.geteSuitValue().equals(this.geteSuitValue())))

			return true;
		 */
		return false;
	}

	//TODO: Add getters for the new attributes



}
