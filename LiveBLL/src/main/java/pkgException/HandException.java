package pkgException;

import java.util.ArrayList;

import pkgCore.Card;
import pkgCore.HandPoker;

public class HandException extends Exception {

	private ArrayList<Card> lstCards;
	private HandPoker hp;
	public HandException(ArrayList<Card> cards) {
		this.lstCards = cards;
	}
	
	public HandException(HandPoker HP) {
		this.hp = HP;
	}
}
