package System;

// This class is one State of the Automaton
public class State {
	private State next;		//for the list of state in the Automaton.
	private int number;		//number of this state.
	private LinkedState first;	//first connected states with this State
								//to build the linked list.
	
	// constructor.
	public State(int number) {
		this.number = number;
		this.first = null;
	}
	
	// state which this State has connections.
	private class LinkedState {
		private int lsNumber;	//number of the connected state.
		private char lsTerm;	//vocabulary that triggers the transaction.
		private LinkedState nextLinkedState; //next state of the linked list.
		
		public LinkedState(int number, char term) {
			this.lsNumber = number;
			this.lsTerm = term;
			nextLinkedState = null;
		}
	}
	
	//add an state which this has transaction
	public void addLinkedState(int number, char term) {
		LinkedState ls = new LinkedState(number, term);
		ls.nextLinkedState = first;
		first = ls;
	}
	
	public State getNext() {
		return this.next;
	}
	
	public void setNext(State state) {
		this.next = state;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	//print all transactions from this state
	public void print() {
		for (LinkedState current = first;
				current != null; 
				current = current.nextLinkedState) 
			System.out.println("Current: " + number + " gets \"" + current.lsTerm + "\" goes to " + current.lsNumber);
	}
}