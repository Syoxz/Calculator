package Taschenrechner;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Model {
	DecimalFormat df = new DecimalFormat("###.#########",
		new DecimalFormatSymbols(Locale.ENGLISH));
	private double ergebnis = 0;
	
	String fErgebnis = "";
	String wert1 = "";
	String wert2 = "";
	String operator = "";
	String [] display = new String [] {"","",""};
	//fuers resetten des displayfeldes, nachdem das ergebnis ausgegeben wurde und eine neues Zeichen eingegeben wird
	private boolean ergVorhanden = false;
	public Model() {
		
	}
//Setzt die Werte 	
	public Model(String werte) {
		setzeWerte(werte);
		this.wert1 = display[0];
		this.wert2 = display[1];
		this.operator = display[2];
	}
	public String [] setzeWerte (String werte) {
		char [] arr = werte.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= '0' && arr[i] <='9' || arr[i] == '.' || arr [i] == '-') {
				if (arr[i]  == '-') {
					if (display[0].isEmpty()) {
						display[0] += arr[i];
					}
					else if (display[2].isEmpty()) {
							 display[2] = "" + arr[i];
					}
					else {
						display[1] += arr[i];
					}
				}
				else if (display[2].isEmpty()) {
						 display[0] += arr[i];
				}
				else {
						display[1] += arr[i];
				}
			}
			else if ((arr[i] == '+'|| arr[i] == '/' || arr[i] == '*') && display[2].isEmpty()){
						display[2] = "" + arr[i];
			}}
		return display;
	}
	public boolean isOperatorMinus (String werte) {
		Model m = new Model(werte);
			if (m.operator.equals("-")) {
				return true;
			}
		 return false;
	}
	public boolean  checkWerte (String werte) {
		Model m = new Model (werte);	 
		if (!m.operator.isEmpty() && m.wert2.isEmpty()) {
			return true;
		}
		else if (m.wert1.isEmpty() || (m.wert1.isEmpty() && m.wert2.isEmpty())) {
			return true;
		}
		return false;
	}	
	public boolean isWert2NotEmpty (String werte) {
		Model m = new Model (werte);
		if (!m.wert2.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public String rechne (String werte) {
		Model x = new Model(werte);
		if (x.operator.equals("+")) {
			ergebnis = (Double.parseDouble(x.wert1)+ Double.parseDouble(x.wert2));
		}
		else if (x.operator.equals("-")) {
			ergebnis = (Double.parseDouble(x.wert1) - Double.parseDouble(x.wert2));
		}
		else if (x.operator.equals("/")) {
			if (x.wert2.equals("0")) {
				setErgVorhanden(true);
				return "Durch 0 Teilen ist nicht moeglich!";
			} 
			ergebnis = (Double.parseDouble(x.wert1) / Double.parseDouble(x.wert2));
		
		}
		else {
			ergebnis = (Double.parseDouble(x.wert1) * Double.parseDouble(x.wert2));
		}
		
		setErgVorhanden(true); 
		fErgebnis =  df.format(ergebnis);
		return "" + fErgebnis;
	}
	public String deleteLastInput(String werte) {
		char [] arr = werte.toCharArray();
 		String neueWerte = "";
 		for (int i = 0; i < arr.length -1; i++) {
 			neueWerte += arr[i];
 		}
		return neueWerte;
	}
	public String checkLastInput (String werte) {
		char [] arr = werte.toCharArray();
		if (arr[arr.length-1] == '.') {
			return "punkt";
		}
		else if (arr[arr.length-1] == '*' |arr[arr.length-1] == '+' | arr[arr.length-1] == '/' ) {
			return "operator";
		}
		return "";
	}
	public double getErgebnis() {
		return ergebnis;
	}

	public void setErgebnis(double ergebnis) {
		this.ergebnis = ergebnis;
	}

	public boolean isErgVorhanden() {
		return ergVorhanden;
	}

	public void setErgVorhanden(boolean ergVorhanden) {
		this.ergVorhanden = ergVorhanden;
	}





	
	
	
	 
}
