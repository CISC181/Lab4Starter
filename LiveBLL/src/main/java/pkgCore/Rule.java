package pkgCore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import pkgEnum.eCardCount;
import pkgEnum.eCardDestination;
import pkgEnum.eCardVisibility;
import pkgEnum.eDrawCount;
import pkgEnum.eGame;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Rule implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private int MaxNumberOfPlayers;
	private int PlayerNumberOfCards;
	private int NumberOfJokers;
	private int PlayerCardsMin;
	private int PlayerCardsMax;
	private int CommunityCardsMin;
	private int CommunityCardsMax;
	private int PossibleHandCombinations;
	private ArrayList<Card> WildCards = new ArrayList<Card>();
	private HashMap<eDrawCount, CardDraw> hmCardDraw = new HashMap<eDrawCount, CardDraw>();

	private eGame Game;

	public Rule(eGame gme) {
		this.Game = gme;
		switch (gme) {
		case FiveStud: {
			this.MaxNumberOfPlayers = 4;
			this.PlayerNumberOfCards = 5;
			this.NumberOfJokers = 0;
			this.PlayerCardsMin = 5;
			this.PlayerCardsMax = 5;
			this.CommunityCardsMin = 0;
			this.CommunityCardsMax = 0;
			this.PossibleHandCombinations = 1;
			this.hmCardDraw.put(eDrawCount.FIRST,
					new CardDraw(eCardCount.Two, eCardDestination.PLAYER, eCardVisibility.EVERYONE));
			this.hmCardDraw.put(eDrawCount.SECOND,
					new CardDraw(eCardCount.One, eCardDestination.PLAYER, eCardVisibility.ME));
			this.hmCardDraw.put(eDrawCount.THIRD,
					new CardDraw(eCardCount.One, eCardDestination.PLAYER, eCardVisibility.ME));
			this.hmCardDraw.put(eDrawCount.FOURTH,
					new CardDraw(eCardCount.One, eCardDestination.PLAYER, eCardVisibility.ME));

			break;
		}
		case FiveStudOneJoker: {
			this.MaxNumberOfPlayers = 4;
			this.PlayerNumberOfCards = 5;
			this.NumberOfJokers = 1;
			this.PlayerCardsMin = 5;
			this.PlayerCardsMax = 5;
			this.CommunityCardsMin = 0;
			this.CommunityCardsMax = 0;
			this.PossibleHandCombinations = 1;
			this.hmCardDraw.put(eDrawCount.FIRST,
					new CardDraw(eCardCount.Two, eCardDestination.PLAYER, eCardVisibility.EVERYONE));
			this.hmCardDraw.put(eDrawCount.SECOND,
					new CardDraw(eCardCount.One, eCardDestination.PLAYER, eCardVisibility.ME));
			this.hmCardDraw.put(eDrawCount.THIRD,
					new CardDraw(eCardCount.One, eCardDestination.PLAYER, eCardVisibility.ME));
			this.hmCardDraw.put(eDrawCount.FOURTH,
					new CardDraw(eCardCount.One, eCardDestination.PLAYER, eCardVisibility.ME));

			break;
		}
		case FiveStudTwoJoker: {
			this.MaxNumberOfPlayers = 4;
			this.PlayerNumberOfCards = 5;
			this.NumberOfJokers = 2;
			this.PlayerCardsMin = 5;
			this.PlayerCardsMax = 5;
			this.CommunityCardsMin = 0;
			this.CommunityCardsMax = 0;
			this.PossibleHandCombinations = 1;
			this.hmCardDraw.put(eDrawCount.FIRST,
					new CardDraw(eCardCount.Two, eCardDestination.PLAYER, eCardVisibility.EVERYONE));
			this.hmCardDraw.put(eDrawCount.SECOND,
					new CardDraw(eCardCount.One, eCardDestination.PLAYER, eCardVisibility.ME));
			this.hmCardDraw.put(eDrawCount.THIRD,
					new CardDraw(eCardCount.One, eCardDestination.PLAYER, eCardVisibility.ME));
			this.hmCardDraw.put(eDrawCount.FOURTH,
					new CardDraw(eCardCount.One, eCardDestination.PLAYER, eCardVisibility.ME));

			break;
		}
		case TexasHoldEm: {
			this.MaxNumberOfPlayers = 8;
			this.PlayerNumberOfCards = 2;
			this.NumberOfJokers = 0;
			this.PlayerCardsMin = 0;
			this.PlayerCardsMax = 2;
			this.CommunityCardsMin = 3;
			this.CommunityCardsMax = 5;
			this.PossibleHandCombinations = 21;
			this.hmCardDraw.put(eDrawCount.FIRST,
					new CardDraw(eCardCount.Two, eCardDestination.PLAYER, eCardVisibility.ME));
			this.hmCardDraw.put(eDrawCount.SECOND,
					new CardDraw(eCardCount.Three, eCardDestination.COMMON, eCardVisibility.EVERYONE));
			this.hmCardDraw.put(eDrawCount.THIRD,
					new CardDraw(eCardCount.One, eCardDestination.COMMON, eCardVisibility.EVERYONE));
			this.hmCardDraw.put(eDrawCount.FOURTH,
					new CardDraw(eCardCount.One, eCardDestination.COMMON, eCardVisibility.EVERYONE));
			break;
		}
		case Omaha: {
			this.MaxNumberOfPlayers = 6;
			this.PlayerNumberOfCards = 4;
			this.NumberOfJokers = 0;
			this.PlayerCardsMin = 2;
			this.PlayerCardsMax = 2;
			this.CommunityCardsMin = 3;
			this.CommunityCardsMax = 5;
			this.PossibleHandCombinations = 60;
			this.hmCardDraw.put(eDrawCount.FIRST,
					new CardDraw(eCardCount.Two, eCardDestination.PLAYER, eCardVisibility.ME));
			this.hmCardDraw.put(eDrawCount.SECOND,
					new CardDraw(eCardCount.Two, eCardDestination.PLAYER, eCardVisibility.ME));
			this.hmCardDraw.put(eDrawCount.THIRD,
					new CardDraw(eCardCount.Three, eCardDestination.COMMON, eCardVisibility.EVERYONE));
			this.hmCardDraw.put(eDrawCount.FOURTH,
					new CardDraw(eCardCount.One, eCardDestination.COMMON, eCardVisibility.EVERYONE));
			this.hmCardDraw.put(eDrawCount.FIFTH,
					new CardDraw(eCardCount.One, eCardDestination.COMMON, eCardVisibility.EVERYONE));
			break;
		}
		case SuperOmaha: {
			this.MaxNumberOfPlayers = 6;
			this.PlayerNumberOfCards = 4;
			this.NumberOfJokers = 0;
			this.PlayerCardsMin = 0;
			this.PlayerCardsMax = 2;
			this.CommunityCardsMin = 3;
			this.CommunityCardsMax = 5;
			this.PossibleHandCombinations = 81;
			this.hmCardDraw.put(eDrawCount.FIRST,
					new CardDraw(eCardCount.Two, eCardDestination.PLAYER, eCardVisibility.ME));
			this.hmCardDraw.put(eDrawCount.SECOND,
					new CardDraw(eCardCount.Two, eCardDestination.PLAYER, eCardVisibility.ME));
			this.hmCardDraw.put(eDrawCount.THIRD,
					new CardDraw(eCardCount.Three, eCardDestination.COMMON, eCardVisibility.EVERYONE));
			this.hmCardDraw.put(eDrawCount.FOURTH,
					new CardDraw(eCardCount.One, eCardDestination.COMMON, eCardVisibility.EVERYONE));
			this.hmCardDraw.put(eDrawCount.FIFTH,
					new CardDraw(eCardCount.One, eCardDestination.COMMON, eCardVisibility.EVERYONE));

			break;
		}
		case SevenDraw: {
			this.MaxNumberOfPlayers = 4;
			this.PlayerNumberOfCards = 7;
			this.NumberOfJokers = 0;
			this.PlayerCardsMin = 5;
			this.PlayerCardsMax = 5;
			this.CommunityCardsMin = 0;
			this.CommunityCardsMax = 0;
			this.PossibleHandCombinations = 21;
			this.hmCardDraw.put(eDrawCount.FIRST,
					new CardDraw(eCardCount.Two, eCardDestination.PLAYER, eCardVisibility.EVERYONE));
			this.hmCardDraw.put(eDrawCount.SECOND,
					new CardDraw(eCardCount.One, eCardDestination.PLAYER, eCardVisibility.ME));
			this.hmCardDraw.put(eDrawCount.THIRD,
					new CardDraw(eCardCount.One, eCardDestination.PLAYER, eCardVisibility.ME));
			this.hmCardDraw.put(eDrawCount.FOURTH,
					new CardDraw(eCardCount.One, eCardDestination.PLAYER, eCardVisibility.ME));
			this.hmCardDraw.put(eDrawCount.FIFTH,
					new CardDraw(eCardCount.One, eCardDestination.PLAYER, eCardVisibility.ME));
			this.hmCardDraw.put(eDrawCount.SIXTH,
					new CardDraw(eCardCount.One, eCardDestination.PLAYER, eCardVisibility.ME));

			break;
		}
		}
	}

	public int GetMaxNumberOfPlayers() {
		return this.MaxNumberOfPlayers;
	}

	public int GetPlayerNumberOfCards() {
		return this.PlayerNumberOfCards;
	}

	public int GetNumberOfJokers() {
		return this.NumberOfJokers;
	}

	public int GetCommunityCardsCount() {
		return this.CommunityCardsMax;
	}

	public ArrayList<Card> GetWildCards() {
		return this.WildCards;
	}

	public eGame GetGame() {
		return this.Game;
	}

	public int getCommunityCardsMin() {
		return CommunityCardsMin;
	}

	public void setCommunityCardsMin(int communityCardsMin) {
		CommunityCardsMin = communityCardsMin;
	}

	public int getCommunityCardsMax() {
		return CommunityCardsMax;
	}

	public void setCommunityCardsMax(int communityCardsMax) {
		CommunityCardsMax = communityCardsMax;
	}

	public int getPlayerCardsMin() {
		return PlayerCardsMin;
	}

	public void setPlayerCardsMin(int playerCardsMin) {
		PlayerCardsMin = playerCardsMin;
	}

	public int getPlayerCardsMax() {
		return PlayerCardsMax;
	}

	public int getTotalCardsToDraw() {
		return this.GetPlayerNumberOfCards() + this.getCommunityCardsMax();
	}

	public void setPlayerCardsMax(int playerCardsMax) {
		PlayerCardsMax = playerCardsMax;
	}

	public int getPossibleHandCombinations() {
		return PossibleHandCombinations;
	}

	public void setPossibleHandCombinations(int possibleHandCombinations) {
		PossibleHandCombinations = possibleHandCombinations;
	}

	public CardDraw getCardDraw(eDrawCount eDrawCount) {
		return (CardDraw) hmCardDraw.get(eDrawCount);
	}
}