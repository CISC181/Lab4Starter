package pkgException;

import java.util.ArrayList;

import pkgCore.Card;

public class HandException extends Exception {

	private ArrayList<Card> lstCards;
	public HandException(ArrayList<Card> cards) {
		this.lstCards = cards;
	}

}
