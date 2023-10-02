package pkgCore;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import org.apache.commons.math3.util.CombinatoricsUtils;

import pkgEnum.eCardNo;
import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eRow;
import pkgEnum.eRowCount;
import pkgEnum.eSuit;
import pkgException.HandException;

public class HandPoker extends Hand implements Comparable {

	public HandPoker() {
		this.setHS(new HandScorePoker());
	}

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        HandPoker - Create an instance of GamePoker with a link back to
	 *        GamePoker that's handling it.
	 * @param GP
	 */
	public HandPoker(Player p, GamePlay GP) {
		super(p, GP);
		this.setHS(new HandScorePoker());
	}
	
	private ArrayList<CardRankCount> CRC = null;

	private HandScorePoker HSP = new HandScorePoker();

	protected HandScorePoker getHSP() {
		return HSP;
	}

	protected ArrayList<CardRankCount> getCRC() {
		return CRC;
	}
	

	@Override
	public HandScore ScoreHand() throws HandException {
		// Sort the hand by rank
		Collections.sort(super.getCards());

		// Count the Frequency of cards, store in CRC ArrayList
		Frequency();

		// Score the hand using Java Reflections

		this.HSP = ScoreHandReflections();
		return HSP;
	}

	private void Frequency() {

		CRC = new ArrayList<CardRankCount>();

		int iCnt = 0;
		int iPos = 0;

		for (eRank eRank : eRank.values()) {
			iCnt = (CountRank(eRank));
			if (iCnt > 0) {
				iPos = FindCardRank(eRank);
				CRC.add(new CardRankCount(eRank, iCnt, iPos));
				
			}
		}
		Collections.sort(CRC);
	}

	private int CountRank(eRank eRank) {
		int iCnt = 0;
		for (Card c : super.getCards()) {
			if (c.geteRankValue() == eRank) {
				iCnt++;
			}
		}
		return iCnt;
	}

	private int FindCardRank(eRank eRank) {
		int iPos = 0;

		for (iPos = 0; iPos < super.getCards().size(); iPos++) {
			if (super.getCards().get(iPos).geteRankValue() == eRank) {
				break;
			}
		}
		return iPos;
	}

	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * 
	 *        ScoreHandReflections - Using reflections, score the hand.
	 * @return
	 */
	private HandScorePoker ScoreHandReflections() {

		HandScorePoker HSP = null;

		try {

			// c = structure of class 'Hand'
			Class<?> c = Class.forName("pkgCore.HandPoker");

			Object o = null;

			for (eHandStrength eHandStrength : eHandStrength.values()) {
				String strEvalMethod = eHandStrength.getEvalMethod();
				Method mEval = c.getDeclaredMethod(strEvalMethod, null);
				mEval.setAccessible(true);
				o = mEval.invoke(this, null);

				if ((boolean) o) {
					break;
				}
			}

			HSP = (HandScorePoker) this.getHS();

		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return HSP;
	}

	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * @return 'true' if Hand is a Royal Flush
	 * 
	 */
	private boolean isRoyalFlush() {

		boolean bIsRoyalFlush = false;	
		
		if ((this.getCards().get(0).geteRankValue() == eRank.ACE) && (isStraightFlush())) {
			bIsRoyalFlush = true;
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.RoyalFlush);
			HSP.setHiCard(this.getCards()
					.get(CRC.get(eRow.ONE.ordinal()).getiCardPosition()));
			HSP.setLoCard(null);
			HSP.setKickers(null);
			this.setHS(HSP);
		}
		
		return bIsRoyalFlush;
		
	}
	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * @return 'true' if Hand is a Straight Flush
	 * 
	 */
	private boolean isStraightFlush() {
		boolean bisStraightFlush = false;
		
		if (isFlush() && isStraight()) {
			bisStraightFlush = true;
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.StraightFlush);
			HSP.setHiCard(this.getCards()
					.get(CRC.get(eRow.ONE.ordinal()).getiCardPosition()));
			HSP.setLoCard(null);
			HSP.setKickers(null);
			this.setHS(HSP);
		}
		return bisStraightFlush;
	}

	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * @return 'true' if Hand is a Four of a Kind
	 * 
	 */
	private boolean isFourOfAKind() {
		boolean bisFourOfAKind = false;

		if ((GetCRCSize() == eRowCount.TWO.getiRowCountItems())
				&& ((GetCRCCount(eRow.ONE.ordinal()) == 4) 
						&& (GetCRCCount(eRow.TWO.ordinal()) == 1))) 
		
		{
			bisFourOfAKind = true;
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.FourOfAKind);
			HSP.setHiCard(this.getCards()
					.get(CRC.get(eRow.ONE.ordinal()).getiCardPosition()));
			HSP.setLoCard(null);
			HSP.setKickers(FindTheKickers(this.getCRC()));
			this.setHS(HSP);
		}
		return bisFourOfAKind;
	}

	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * @return 'true' if Hand is a Full House
	 * 
	 */	
	private boolean isFullHouse() {
		boolean bisFullHouse = false;
		
		if ((GetCRCSize() == eRowCount.TWO.getiRowCountItems())
				&& ((GetCRCCount(eRow.ONE.ordinal()) == 3) 
						&& (GetCRCCount(eRow.TWO.ordinal()) == 2))) 
			

		{
			bisFullHouse = true;
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.FullHouse);
			HSP.setHiCard(this.getCards()
					.get(CRC.get(eRow.ONE.ordinal()).getiCardPosition()));
			HSP.setLoCard(this.getCards()
					.get(CRC.get(eRow.TWO.ordinal()).getiCardPosition()));
			HSP.setKickers(null);
			this.setHS(HSP);
		}

		return bisFullHouse;

	}
	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * @return 'true' if Hand is a Flush
	 * 
	 */	
	private boolean isFlush() {
		boolean bisFlush = false;
		
		int iCnt = 0;
		
		for (var S: eSuit.values()) {
			for (var C: this.getCards()) {
				if (C.geteSuitValue() == S) {
					iCnt++;
				}
			}
			if (iCnt == this.getCards().size()) {
				bisFlush = true;
				break;
			}
			
			if (iCnt > 0) {
				break;
			}
		}
		
		if (bisFlush) {
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.Flush);
			HSP.setHiCard(this.getCards()
					.get(CRC.get(eRow.ONE.ordinal()).getiCardPosition()));
			HSP.setLoCard(null);
			HSP.setKickers(FindTheKickers(this.getCRC()));
			this.setHS(HSP);
		}

		return bisFlush;
	}

	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * @return 'true' if Hand is a Straight
	 * 
	 */	
	private boolean isStraight() {
		boolean bisStraight = true;
		int i = 0;
		boolean isWheel = false;
		
		if (this.getCards().get(0).geteRankValue() == eRank.ACE) {
			if (this.getCards().get(1).geteRankValue() == eRank.FIVE) {
				i = 1;
				isWheel = true;
			}
		}
		
		for (; i < this.getCards().size()-1; i++) {
			if (this.getCards().get(i).geteRankValue().getiRankNbr() == 
					this.getCards().get(i+1).geteRankValue().getiRankNbr() + 1) {
				
			}
			else {
				bisStraight = false;
			}
		}
		if (bisStraight) {
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.Straight);
			if (isWheel) {
				HSP.setHiCard(this.getCards().get(this.getCRC().get(eRow.TWO.ordinal()).getiCardPosition()));
			}
			else {
				HSP.setHiCard(this.getCards().get(this.getCRC().get(eRow.ONE.ordinal()).getiCardPosition()));
			}
			HSP.setKickers(FindTheKickers(this.getCRC()));
			this.setHS(HSP);
		}
		return bisStraight;
	}

	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * @return 'true' if Hand is a Three of a Kind
	 * 
	 */
	private boolean isThreeOfAKind() {
		boolean bisThreeOfAKind = false;

		if ((GetCRCSize() == eRowCount.THREE.getiRowCountItems())
				&& ((GetCRCCount(eRow.ONE.ordinal()) == 3) 
						&& (GetCRCCount(eRow.TWO.ordinal()) == 1)) && (GetCRCCount(eRow.THREE.ordinal()) == 1)) 
			

		{
			bisThreeOfAKind = true;
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.ThreeOfAKind);
			HSP.setHiCard(this.getCards()
					.get(CRC.get(eRow.ONE.ordinal()).getiCardPosition()));
			HSP.setLoCard(null);
			HSP.setKickers(FindTheKickers(this.getCRC()));
			this.setHS(HSP);
		}

		return bisThreeOfAKind;
	}
	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * @return 'true' if Hand is a Two Pair
	 * 
	 */
	private boolean isTwoPair() {
		boolean bisTwoPair = false;

		if ((GetCRCSize() == eRowCount.THREE.getiRowCountItems())
				&& ((GetCRCCount(eRow.ONE.ordinal()) == 2) 
						&& (GetCRCCount(eRow.TWO.ordinal()) == 2)) && (GetCRCCount(eRow.THREE.ordinal()) == 1)) 
			

		{
			bisTwoPair = true;
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.TwoPair);
			HSP.setHiCard(this.getCards()
					.get(CRC.get(eRow.ONE.ordinal()).getiCardPosition()));
			HSP.setLoCard(this.getCards()
					.get(CRC.get(eRow.TWO.ordinal()).getiCardPosition()));
			HSP.setKickers(FindTheKickers(this.getCRC()));
			this.setHS(HSP);
		}
		return bisTwoPair;
	}
	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * @return 'true' if Hand is a Pair
	 * 
	 */
	private boolean isPair() {

		boolean bisPair = false;

		if ((GetCRCSize() == eRowCount.FOUR.getiRowCountItems())
				&& ((GetCRCCount(eRow.ONE.ordinal()) == 2) 
						&& (GetCRCCount(eRow.TWO.ordinal()) == 1)) && (GetCRCCount(eRow.THREE.ordinal()) == 1) 
				&& (GetCRCCount(eRow.FOUR.ordinal()) == 1)) 
			

		{
			bisPair = true;
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.Pair);
			HSP.setHiCard(this.getCards()
					.get(CRC.get(eRow.ONE.ordinal()).getiCardPosition()));
			HSP.setLoCard(null);
			HSP.setKickers(FindTheKickers(this.getCRC()));
			this.setHS(HSP);
		}

		return bisPair;
	}

	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * @return 'true' if Hand is a High Card
	 * 
	 */
	private boolean isHighCard() {
		boolean bisHighCard = true;

		HandScorePoker HSP = (HandScorePoker) this.getHS();
		HSP.seteHandStrength(eHandStrength.HighCard);
		HSP.setHiCard(this.getCards().get(this.getCRC().get(eRow.ONE.ordinal()).getiCardPosition()));
		HSP.setKickers(FindTheKickers(this.getCRC()));
		this.setHS(HSP);
		return bisHighCard;
	}

	private int GetCRCSize() {
		return CRC.size();
	}

	private int GetCRCCount(int iRow) {
		return CRC.get(iRow).getiCnt();
	}

	private ArrayList<Card> FindTheKickers(ArrayList<CardRankCount> CRC) {
		ArrayList<Card> kickers = new ArrayList<Card>();

		// Start at '1' to skip the first CRC
		for (int i = 1; i < CRC.size(); i++) {
			if (CRC.get(i).getiCnt() == 1) {
				kickers.add(this.getCards().get(CRC.get(i).getiCardPosition()));
			}
		}

		return kickers;
	}

	/**
	 * equals - return 'true' if the cards are the same.
	 */
	@Override
	public boolean equals(Object obj) {

		HandPoker hp = (HandPoker) obj;
		ArrayList<Card> PassedCards = hp.getCards();
		ArrayList<Card> ThisCards = this.getCards();

		boolean isEqual = PassedCards.equals(ThisCards);

		return isEqual;

	}

	// External Comparator
	public static Comparator<HandPoker> hpComparator = new Comparator<HandPoker>() {
		@Override
		public int compare(HandPoker hp1, HandPoker hp2) {
			return hp1.compareTo(hp2);
		}
	};

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        compareTo - This is the default sort for HandPoker. Sorted by...
	 * 
	 *        HandStrength HiHand LoHand Kickers
	 * 
	 * 
	 * 
	 */
	@Override
	public int compareTo(Object o) {

		HandPoker PassedHP = (HandPoker) o;

		HandScorePoker PassedHSP = PassedHP.getHSP();
		HandScorePoker ThisHSP = this.getHSP();

		// Sort on Hand Strength
		if (PassedHSP.geteHandStrength().getHandStrength() - ThisHSP.geteHandStrength().getHandStrength() != 0)
			return PassedHSP.geteHandStrength().getHandStrength() - ThisHSP.geteHandStrength().getHandStrength();

		// Then Sort on High Card
		if (PassedHSP.getHiCard().geteRankValue().getiRankNbr()
				- ThisHSP.getHiCard().geteRankValue().getiRankNbr() != 0)
			return PassedHSP.getHiCard().geteRankValue().getiRankNbr()
					- ThisHSP.getHiCard().geteRankValue().getiRankNbr();

		// Then Sort on Low Card
		if ((PassedHSP.getLoCard() != null) && (ThisHSP.getLoCard() != null)) {
			if (PassedHSP.getLoCard().geteRankValue().getiRankNbr()
					- ThisHSP.getLoCard().geteRankValue().getiRankNbr() != 0) {
				return PassedHSP.getLoCard().geteRankValue().getiRankNbr()
						- ThisHSP.getLoCard().geteRankValue().getiRankNbr();
			}
		}

		// Then Sort by kickers.
		for (int k = 0; k < 4; k++) {
			if ((PassedHSP.getKickers() != null) && (ThisHSP.getKickers() != null)) {
				if ((PassedHSP.getKickers().size() > k) && (ThisHSP.getKickers().size() > k)) {
					if (PassedHSP.getKickers().get(k).geteRankValue().getiRankNbr()
							- ThisHSP.getKickers().get(k).geteRankValue().getiRankNbr() != 0) {
						return PassedHSP.getKickers().get(k).geteRankValue().getiRankNbr()
								- ThisHSP.getKickers().get(k).geteRankValue().getiRankNbr();
					}
				}
			}
		}
		return 0;
	}
}
