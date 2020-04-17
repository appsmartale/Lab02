package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary alienDictionary = new AlienDictionary();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtTranslate"
    private TextField txtTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearText"
    private Button btnClearText; // Value injected by FXMLLoader

    @FXML
    void doReset(ActionEvent event) {
    	txtTranslate.clear();
    	txtResult.clear();
    	alienDictionary.resetDictionary();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	txtResult.clear();
    	String testo = txtTranslate.getText().toLowerCase();
    	
    	//Controllo sull'input
    	if (testo == null || testo.length() == 0) {
    		txtResult.setText("Inserire una o due parole.");
    		return;
    	}
    	
    	StringTokenizer st = new StringTokenizer(testo, " ");
    	
    	//Controllo su StringTokenizer (superfluo)
    	if (!st.hasMoreElements()) {
    		txtResult.setText("Inserire una o due parole.");
    		return;
    	}
    	
    	//Estraggo la prima parola
    	String alienWord = st.nextToken();
    	
    	if (st.hasMoreTokens()) {
    		//Devo inserire parola e traduzione nel dizionario
    		
    		//Estraggo la seconda parola
    		String translation = st.nextToken();
    		
    		if (!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici.");
    			return;
    		}
    		
    		//Aggiungo la parola aliena e traduzione nel dizionario
    		alienDictionary.addWord(alienWord, translation);
    		
    		txtResult.setText("La parola: \"" + alienWord + 
    				"\", con traduzione: \"" +translation + "\", è stata inserita nel dizionario.");
    	} else {
    		//Controllo che non ci siano caratteri non ammessi
    		if (!alienWord.matches("[a-zA-Z]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
    		}
    		
    		//String translation = alienDictionary.translateWord(alienWord);
    		String translation = alienDictionary.translateWordWildCard(alienWord);
    		
    		if (translation != null) {
    			txtResult.setText(translation);
    		} else {
    			txtResult.setText("La parola cercata non esiste nel dizionario.");
    		}
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtTranslate != null : "fx:id=\"txtTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
