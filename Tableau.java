/**
* @authors Emily Hageboeck Colin Sherman Mitchell Hornsby and Kelly Amar
* moves the last card of a tableau pile to another tableau pile 
*/ 

import java.awt.List;
import java.util.ArrayList;

public class Tableau extends AbstractCell{
	private ArrayList<Card> movePile;
	
	public Tableau() {
		super(52);
	}


	public Card getCard(int i)
	{
		if(pile.size() != 0)
		{
			return pile.get(i);
		}
		else {
			throw new IllegalStateException("Cell is empty");
		}
	}
	
	public boolean canMove(Cell fromCell)

	{

	Card cardToMove = fromCell.topCard();

	System.out.print(cardToMove);

	if(this.isEmpty())

	{

	if(cardToMove.getRank() == 13)

	{

	return true;

	}

	}

	Card cardToMoveTo = this.topCard();

	System.out.print(cardToMoveTo);

	if(oppositeSuit(cardToMove) && rankOrder(cardToMove))

	{

	return true;

	}

	return false;

	}
		
	private boolean oppositeSuit(Card moveCard)
	{
		ArrayList<Suit> red = new ArrayList();
		red.add(Suit.diamond);
		red.add(Suit.heart);
		ArrayList<Suit> black = new ArrayList();
		black.add(Suit.spade);
		black.add(Suit.club);
		if(red.contains(this.topCard().getSuit()) && black.contains(moveCard.getSuit()) || black.contains(this.topCard().getSuit()) && red.contains(moveCard.getSuit()))
		{
			return true;
		}
		return false;
	}
	
	private boolean rankOrder(Card moveCard)
	{
		
		int destinationRank = this.topCard().getRank();
		int moveCardRank = moveCard.getRank();
		if(destinationRank - moveCardRank == 1)
		{
			return true;
		}
		return false;
	}
	
	
	public boolean inSequence(Cell fromCell)
	{
		if (size() == 1 || isEmpty()) 
		{
			return true;
		}
			Card topCard = this.topCard();
			for (int i = size()-2; i > 0; i--) {
				Card nextCard = this.getCard(i);
				if (!(oppositeSuit(nextCard)) || !(rankOrder(topCard))) 
				{
					return false;
				}
				topCard = nextCard;
			}
		return true;
	}
}