package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Deck {

	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * 
	 *        cardsInDeck - attribute keeping track of the cards that are in the
	 *        deck. The attribute is valued in the Constructor for the class, and
	 *        items are removed from the collection in the 'Draw' method
	 */
	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * 
	 *        Default no-arg constructor. Create a single deck of cards, make sure
	 *        it's shuffled.
	 */
	public Deck() {
		this(1);
	}

	/**
	 * @author BRG
	 * @version Lab #1
	 * @since Lab #1
	 * @param iNbrOfDecks - Number of decks to include in the cardsInDeck attribute.
	 * 
	 *                    One argument Constructor... If '2' is passed in, make sure
	 *                    cardsInDeck contains two 52-card decks. Make sure the deck
	 *                    is shuffled.
	 */
	public Deck(int iNbrOfDecks) {

		//TODO: Build decks of cards.  If 1 is passed in, build a deck with 52 cards.  If 2 is passed in, build two decks, total 104 cards

	}
	
	/**
	 * @author BRG
	 * @version Lab #1
	 * @since Lab #1
	 * @return - Return a Card object
	 * @throws DeckException
	 */
	public Card Draw()  {

		return cardsInDeck.remove(0);

	}

	/**
	 * @author BRG
	 * @version Lab #1
	 * @since Lab #1
	 * @return Number of cards remaining in the deck
	 * 
	 * getiDeckCount - Return the number of cards remaining in the deck.
	 */
	public int getiDeckCount() {
		return cardsInDeck.size();
	}

 
	/**
	 * getCardsInDeck - getter for cardsInDeck.  It's private, must be invoked
	 * with reflections.
	 * 
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * @return - the cards in the deck.
	 */
	private ArrayList<Card> getCardsInDeck() {
		return cardsInDeck;
	}
 
	
	
}