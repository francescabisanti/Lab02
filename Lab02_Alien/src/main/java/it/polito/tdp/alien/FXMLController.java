package it.polito.tdp.alien;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	AlienDictionary dictionary= new AlienDictionary();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btmTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btmClear;

    @FXML
    void doClear(ActionEvent event) {
    	this.dictionary.clearDictionary();
    	
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String inserito= txtParola.getText().toLowerCase();
    	
    	String [] campi= inserito.split(" ");
    	if(campi.length==2) {
    		if(campi[0].matches(".*\\d.*")==false && campi[0].matches(".*\\W.*")==false) {
    			if(campi[1].matches(".*\\d.*")==false && campi[1].matches(".*\\W.*")==false) {
    		
    		this.dictionary.addWords(campi[0], campi[1]);
    		txtParola.setText("");
    		return;
    		}
    			else
    				txtResult.setText("Errore sulla secondaParola");
    			}
    		else
    			txtResult.setText("Errore sulla PrimaParola");
    			
    	}
    	else if(campi.length==1) {
    		
    		if(campi[0].matches(".*\\d.*")==false && campi[0].matches(".*\\W.*")==false) {
    		String stampa= this.dictionary.translate(campi[0]);
    		txtResult.setText(stampa.toString());
    		txtParola.setText("");
    		return;
    		}
    		else
    			txtResult.setText("Errore sulla PrimaParola");
    	}
    	
    	
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmTranslate != null : "fx:id=\"btmTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmClear != null : "fx:id=\"btmClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
