package Taschenrechner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener {
	private View view;
	private Model model;
	private int Opcount;
	private int punktCount;
	private int minusCount;
	public Controller () {
		setModel(new Model());
		setView(new View());
		getView().addActionListenerToButtons(this);
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		try {
			if (command.charAt(0) == 'C') {
				getModel().setErgVorhanden(false);
				getView().resetFeld();
				setOpCount(0);
				setPunktCount(0);
				setMinusCount(0);
			}
			else if (command == "<-") {
				if (getModel().isErgVorhanden()) {
				}
				else  {
					if (getModel().checkLastInput(getView().getDisplayField().getText()) == "punkt") {
						setPunktCount(0);
				}
					if (getView().getDisplayField().getText().equals("Ungueltige Eingabe!")) {
						getView().resetFeld();
					}
					if (getModel().checkLastInput(getView().getDisplayField().getText()) == "operator") {
						setOpCount(0);
						}
					getView().getDisplayField().setText(getModel().deleteLastInput(getView().getDisplayField().getText()));
				}
			
			}
				
				
			
			else if (command.charAt(0) == '.' && getPunktCount() > 0);
			
			else if (command.charAt(0) == '.') {
				setPunktCount(getPunktCount()+1);
				if (getModel().isErgVorhanden()){
					getView().getDisplayField().setText('0' + command);
					getModel().setErgVorhanden(false);
				}
				else if (getModel().checkWerte(getView().getDisplayField().getText()) == true){
					getView().getDisplayField().setText(getView().getDisplayField().getText() +'0' + command);
				}
				else {
					getView().getDisplayField().setText(getView().getDisplayField().getText() + command);

				}
			}
			else if (command.charAt(0) == '=') {			
				if (!getModel().isErgVorhanden()){
					getView().getDisplayField().setText(getModel().rechne(getView().getDisplayField().getText()));
					setPunktCount(0);
					setOpCount(0);
				}
			}
			else if (command.charAt(0) == '-' ) {
				if (getModel().isErgVorhanden()) {
<<<<<<< HEAD
					getView().getDisplayField().setText("" + getModel().fErgebnis + command);
=======
					getView().getDisplayField().setText("" + getView().getDisplayField().getText() + command);
>>>>>>> develop
					setMinusCount(getMinusCount()+1);
					setPunktCount(0);
					getModel().setErgVorhanden(false);
				}
				else if (getModel().isWert2NotEmpty(getView().getDisplayField().getText()));
				else if (getMinusCount() == 0) {
					getView().getDisplayField().setText(getView().getDisplayField().getText () + command);
					setMinusCount(getMinusCount()+1);
					setPunktCount(0);
				}
				}
			
	//		Kommentar: Beschraenkt Eingabe zwar auf einen Operator, aber man kann diesen auch nicht aendern, falls vertippt.
			else if ((command.charAt(0) == '+'  || command.charAt(0) == '*' ||command.charAt(0) == '/')) {
				if (getModel().isErgVorhanden()) {
<<<<<<< HEAD
					getView().getDisplayField().setText("" + getModel().fErgebnis + command);
=======
					getView().getDisplayField().setText("" + getView().getDisplayField().getText() + command);
>>>>>>> develop
					setOpCount(getOpCount()+1);
					getModel().setErgVorhanden(false);
				}
				else if (getModel().isWert2NotEmpty(getView().getDisplayField().getText()) || getModel().isOperatorMinus(getView().getDisplayField().getText()));
				else if (getOpCount() == 0 ) {
					getView().getDisplayField().setText(getView().getDisplayField().getText() + command);
					setOpCount(getOpCount()+1);
					setPunktCount(0);
			}		
			}
			else if (getModel().isErgVorhanden()) {
					getView().getDisplayField().setText(command);
					getModel().setErgVorhanden(false);
					setOpCount(0);
					setPunktCount(0);
			}
			else {
				getView().getDisplayField().setText(getView().getDisplayField().getText()  + command);
				setMinusCount(0);
			}
		} catch (Exception x) {
			getView().getDisplayField().setText("Ungueltige Eingabe!");
			setPunktCount(0);
			getModel().setErgebnis(0);
			getModel().setErgVorhanden(true);
		}
	}
		
		

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public int getOpCount() {
		return Opcount;
	}

	public void setOpCount(int Opcount) {
		this.Opcount = Opcount;
	}

	public int getPunktCount() {
		return punktCount;
	}

	public void setPunktCount(int punktCount) {
		this.punktCount = punktCount;
	}

	public int getMinusCount() {
		return minusCount;
	}

	public void setMinusCount(int minusCount) {
		this.minusCount = minusCount;
	}

	
}
