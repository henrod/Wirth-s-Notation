package System;

// This class has all states of the automaton in a linked list of States
public class Automaton {
	private static State first;
	
	public Automaton() {
		first = null;
	}
	 
	public State addState(State state) {
		state.setNext(first);
		first = state;
		
		return first;
	}
	
	public State getFirstState() {
		return this.first;
	}
	
	public State getState(int number) {
		for(State current = first; 
				current.getNext() != null; 
				current = current.getNext())
			if (current.getNumber() == number) return current;
		
		return null;
	}
	
	// print states and transitions
	public void print() {
		for (State current = first; current != null; current = current.getNext())
			current.print();
	}
}