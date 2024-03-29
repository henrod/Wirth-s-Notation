package System;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// This class keeps a list of reserved words, including the compiler and name of variables and labels.
public class ReservedWords {
	Word first;
	SubMachine firstSM;
	int submachineCount;
	
	public ReservedWords() {
		first = new Word("");
		submachineCount = 0;
	}
	
	public void addWord(String strWord) {
		Word new_word = new Word(strWord);
		new_word.next = first;
		first = new_word;
	}
	
	public int addNonTerminal(String nTerminal) {
		if (firstSM == null)
			firstSM = new SubMachine(nTerminal, ++submachineCount);
		else {
			SubMachine SM = new SubMachine(nTerminal, ++submachineCount);
			SM.next = firstSM;
			firstSM = SM;
		}
		
		addWord(nTerminal);
		
		return submachineCount;
	}
	
	// search if the words exists as a reserved word in the language or code.
	public boolean exists(String word) {
		for (Word current = first; current != null; current = current.next) 
			if (current.word.equals(word))
				return true;
		return false;
	}
	
	private class Word {
		String word;
		Word next;
		
		private Word(String word) {
			this.word = word;
			next = null;
		}
	}
	
	// this class has all sub-machines associated with each non-terminal of the grammar
	private class SubMachine {
		int subMachineNumber;
		String nonTerminal;
		SubMachine next;
		
		private SubMachine(String nonTerminal, int subMachine) {
			this.subMachineNumber = subMachine;
			this.nonTerminal = nonTerminal;
			this.next = null;
		}
	}
	
	// returns sub-machine number from its non-terminal name
	public int getSubMachine(String non_terminal) {
		for (SubMachine SM = firstSM; SM != null; SM = SM.next)
			if (SM.nonTerminal.equals(non_terminal))
				return SM.subMachineNumber;
		// error: no sub-machine with this non-terminal
		return -1;
	}
}
