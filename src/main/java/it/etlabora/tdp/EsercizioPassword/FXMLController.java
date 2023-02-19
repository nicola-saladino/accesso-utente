/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.etlabora.tdp.EsercizioPassword;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnAccediId"
    private Button btnAccediId; // Value injected by FXMLLoader

    @FXML // fx:id="lblInformazione"
    private Label lblInformazione; // Value injected by FXMLLoader

    @FXML // fx:id="lblNumeroTentativiRimasti"
    private Label lblNumeroTentativiRimasti; // Value injected by FXMLLoader

    @FXML // fx:id="txtInserisciNome"
    private TextField txtInserisciNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtInserisciPassword"
    private TextField txtInserisciPassword; // Value injected by FXMLLoader
    
    int tentativiIngresso=0;
    @FXML
    void btnAccedi(ActionEvent event) {
    	if (txtInserisciNome.getText().trim().isEmpty() || txtInserisciPassword.getText().trim().isEmpty()) {
    	    lblInformazione.setText("Devi inserire entrambi i campi!");
    	    btnAccediId.setDisable(false);
    	} else {
    		tentativiIngresso++;
    		lblNumeroTentativiRimasti.setText(Integer.toString(tentativiIngresso));
    	    // Entrambi i campi sono compilati
    	    if (txtInserisciPassword.getText().matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!\\?#@])(?=\\S+$).{7,}$")) {
    	        // Il testo soddisfa la regex
    	        lblInformazione.setText("Dati corretti, accesso in corso..");
    	        btnAccediId.setDisable(true);
    	    } else {
    	        // Il testo non soddisfa la regex
    	        lblInformazione.setText("Errore: la password deve avere: 7 o + caratteri, maiuscola,carattere speciale");
    	        btnAccediId.setDisable(false);
    	        txtInserisciNome.setDisable(true);
    	        if (tentativiIngresso >= 3) {
    	            btnAccediId.setDisable(true);
    	            lblInformazione.setText("Numero massimo di tentativi raggiunto");
    	        }
    	    }
    	}
    }

    @FXML
    void btnPulisciCampi(ActionEvent event) {
    	if (tentativiIngresso >= 3 || txtInserisciPassword.getText().matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!\\?#@])(?=\\S+$).{7,}$")) {
			btnAccediId.setDisable(false);
			txtInserisciNome.setDisable(false);
			txtInserisciNome.setText("");
			txtInserisciPassword.setText("");
			lblNumeroTentativiRimasti.setText("");
			tentativiIngresso = 0;
		}
    	return;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnAccediId != null : "fx:id=\"btnAccediId\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblInformazione != null : "fx:id=\"lblInformazione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblNumeroTentativiRimasti != null : "fx:id=\"lblNumeroTentativiRimasti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserisciNome != null : "fx:id=\"txtInserisciNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserisciPassword != null : "fx:id=\"txtInserisciPassword\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
