package it.polito.tdp.alien;

public class Word {
	
	private String alienWord;
	private String translation;
	
	/*Questo costruttore crea un oggetto Word, corrispondente ad una voce da ricercare nel dizionario.
	 * La verifica nel dizionario avverrà utilizzando il metodo equals opportunamente modificato. 
	 * Il metodo setTranslation abbinerà/sovrascriverà a questa voce la sua traduzione.*/
	public Word(String alienWord) {
		this.alienWord = alienWord;
	}
	/*Questo costruttore crea un oggetto Word, completo di voce e traduzione.*/
	public Word(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation;
	}
	public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	
	

}
