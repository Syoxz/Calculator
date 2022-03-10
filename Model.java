package Taschenrechner;



public class Model {
	private double ergebnis = 0;

	//fuers resetten des displayfeldes, nachdem das ergebnis ausgegeben wurde und eine neues Zeichen eingegeben wird
	private boolean ergVorhanden = false;
	public boolean isOperatorMinus (String werte) {
		char [] arr = werte.toCharArray();
		 String wert1 = "";
		 String wert2 = "";
		 String operator = "";
		 for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= '0' && arr[i] <='9' || arr[i] == '.') {
				if (operator.isEmpty()) {
					wert1 += arr[i];
				}
				else {
					wert2 += arr[i];
				}
			}
			if ((arr[i] == '+' || arr[i] == '-' || arr[i] == '/' || arr[i] == '*') && (!wert1.isEmpty() && wert2.isEmpty())){
				operator = "" + arr [i];
				}
			if (operator.equals("-")) {
				return true;
			}
	}
		 return false;
	}
	public char setzeWerte (String werte) {
		char [] arr = werte.toCharArray();
		 String wert1 = "";
		 String wert2 = "";
		 String operator = "";
		 int count = 0;
		 for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= '0' && arr[i] <='9' || arr[i] == '.') {
				if (operator.isEmpty()) {
					wert1 += arr[i];
				}
				else {
					wert2 += arr[i];
				}
			}
			if ((arr[i] == '+' || arr[i] == '-' || arr[i] == '/' || arr[i] == '*') && (!wert1.isEmpty() && wert2.isEmpty())){
				operator = "" + arr [i];
				count ++;
			}
		}
		 
		 //Loesung mit verschiedenen Chars als Return ist Fehleranfaellig, da wenn das eine das andere nicht ausschließt, ueberschreibungen stattfinden koennen		 
		if (count > 0 && wert2.isEmpty()) {
			return 't';
		}
		
	
		
		else if (wert1.isEmpty() || (wert1.isEmpty() && wert2.isEmpty())) {
			return 't';
		}
		else if (!wert2.isEmpty()) {
			return 'a';
		}
		
	
		return 'f';
	}	
	public String rechne (String werte) {
		char [] arr = werte.toCharArray();
		//ToDo: Beliebig viele Werte und Operatoren verwenden
		String wert1 = "";
		String wert2 = "";
		String operator = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= '0' && arr[i] <='9' || arr[i] == '.' || arr [i] == '-') {
				if (arr[i]  == '-') {
					if (wert1.isEmpty()) {
						wert1 += arr[i];
					}
					else if (operator.isEmpty()) {
						operator = "" + arr[i];
					}
					else {
						wert2 += arr[i];
					}
				}
				else if (operator.isEmpty()) {
					wert1 += arr[i];
				}
				else {
					wert2 += arr[i];
				}
			}
			else if ((arr[i] == '+'|| arr[i] == '/' || arr[i] == '*') && operator.isEmpty()){
				
					operator = "" + arr[i];
			}
			
		}
		if (operator.equals("+")) {
			ergebnis = (Double.parseDouble(wert1)+ Double.parseDouble(wert2));
		}
		else if (operator.equals("-")) {
			ergebnis = (Double.parseDouble(wert1) - Double.parseDouble(wert2));
		}
		else if (operator.equals("/")) {
			if (wert2.equals("0")) {
				setErgVorhanden(true);
				return "Durch 0 Teilen ist nicht moeglich!";
			} 
			ergebnis = (Double.parseDouble(wert1) / Double.parseDouble(wert2));
			
		}
		else {
			ergebnis = (Double.parseDouble(wert1) * Double.parseDouble(wert2));
		}
		
		setErgVorhanden(true);
		ergebnis = Math.round(ergebnis*10000.0)/10000.0;
		return "" + ergebnis;
	}
	public String deleteLastInput(String werte) {
		char [] arr = werte.toCharArray();
 		String neueWerte = "";
 		
 		for (int i = 0; i < arr.length -1; i++) {
 			neueWerte += arr[i];
 		}
 		
		return neueWerte;
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
