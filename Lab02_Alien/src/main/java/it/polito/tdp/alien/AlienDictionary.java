package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

/**public class AlienDictionary {
	
	private List<Word> dictionary;

	public AlienDictionary() {
		super();
		dictionary = new ArrayList<Word>();
	}
	
	public void resetDictionary() {
		this.dictionary.clear();
	}

	/*public void addWord(String alienWord, String translation) {
		Word newWord = new Word(alienWord, translation);
		for (Word word: this.dictionary) {
			if (word == newWord) {
				word.setTranslation(translation);
			}
			else {
				dictionary.add(newWord);
			}
		}
	}*
	
	public void addWord(String alien, String trans) {
		Word w = new Word(alien, trans);
		if (dictionary.contains(w)) {
			dictionary.get(dictionary.indexOf(w)).setTranslation(trans);
			return;
		}
		dictionary.add(w);
	}
	
	/*public String translateWord(String alienWord) {
		Word newWord = new Word(alienWord);
		for (Word word: this.dictionary) {
			if (word == newWord) {
				return word.getTranslation();
			}
		}
		return null ;
	}*
	
	public String translateWord(String alien) {
		Word w = new Word(alien);
		if (dictionary.contains(w)) {
			return dictionary.get(dictionary.indexOf(w)).getTranslation();
		}
		return null;
	}
}
**/

public class AlienDictionary {
	
	private List<WordEnhanced> dictionary;

	public AlienDictionary() {
		super();
		dictionary = new ArrayList<WordEnhanced>();
	}
	
	public void resetDictionary() {
		this.dictionary.clear();
	}
	
	public void addWord(String alien, String trans) {
		WordEnhanced w = new WordEnhanced(alien);
		if (dictionary.contains(w)) {
			dictionary.get(dictionary.indexOf(w)).setTranslation(trans);
			return;
		}
		w.setTranslation(trans);
		dictionary.add(w);
	}
	
	public String translateWordWildCard(String alienWildCard) {
		// Utilizzo le regual expression di Java (posso usare stringa.matches())
		// Sostituisco "?" con "."
		// "." nelle regex indica un qualsiasi carattere
		alienWildCard = alienWildCard.replaceAll("\\?", ".");
		
		int matchCounter = 0;
		StringBuilder sb = new StringBuilder();
		
		for (WordEnhanced w: dictionary) {
			if (w.compareWild(alienWildCard)) {
				matchCounter++;
				sb.append(w.getTranslation() + "\n");
				
			}
		}
		
		if (matchCounter != 0) {
			return sb.toString();
		}
		else {
			return null;
		}
	}
}