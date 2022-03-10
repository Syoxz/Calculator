package Taschenrechner;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;


@SuppressWarnings("serial")
public class View extends JFrame {	
	private JPanel op;
	private JPanel zahlenPanel;
	private JPanel display;
	private JPanel displayButton;
	private JButton [] zahlenButton = new JButton [10];
	private JButton zero,punkt,equals,delete, plus, minus, mal,geteilt;
	private JTextField displayField;
	
	public View () {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		setTitle("Taschenrechner");
		setBounds(0,0, 350,300);
		setZahlenPanel(new JPanel());
		setDisplay(new JPanel());
		setDisplayButton(new JPanel());
		setOp(new JPanel());
		
		
		getZahlenPanel().setLayout (new GridLayout(4,3,0,0));
		addButton();
		
 
		getDisplay().setLayout(new GridLayout(1,1,0,0));
		displayField = new JTextField (20);
		displayField.setEditable(false);
		getDisplay().add(displayField);
		
		getOp().setLayout(new GridLayout (4,1,0,0));
		oButtons();
		
		getDisplayButton().setLayout(new GridLayout(2,1,0,0));
		equalButton();
				
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(getZahlenPanel(),BorderLayout.CENTER);
		getContentPane().add(getDisplayButton(), BorderLayout.EAST);
		getContentPane().add(getDisplay(), BorderLayout.NORTH);
		getContentPane().add(getOp(), BorderLayout.WEST);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		}
	
	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}

	public void equalButton() {
		equals = new JButton("=");
		delete = new JButton("<-");
		displayButton.add(delete);
		displayButton.add(equals);
	}
	public void oButtons () {
		plus = new JButton("+");
		minus = new JButton("-");
		mal = new JButton("*");
		geteilt = new JButton("/");
		op.add(mal);
		op.add(geteilt);
		op.add(plus);
		op.add(minus);
//		op.setPreferredSize(new Dimension (80,80));
	}
	public void resetFeld() {
		getDisplayField().setText("");
		
	}
	public void addButton() {
		getZahlenPanel().setLayout (new GridLayout(4,3,0,0));
		for (int i = 9; i >=1; i--) {
			zahlenButton [i] = new JButton (""+i);
			zahlenPanel.add(zahlenButton[i]);
		}
		zahlenButton[0] = new JButton("C");
		zahlenPanel.add(zahlenButton[0]);
		rButtons();
	}
	public void rButtons () {
		zero = new JButton("0");
		zahlenPanel.add(zero);
		punkt = new JButton(".");
		zahlenPanel.add(punkt);
	}
	public void addActionListenerToButtons(ActionListener al) {	
		for (int i = 0; i < zahlenButton.length; i++) {
			getZahlenButton(i).addActionListener(al);
		}

		getZero().addActionListener(al);
		getPunkt().addActionListener(al);
		getEquals().addActionListener(al);
		getMal().addActionListener(al);
		getGeteilt().addActionListener(al);
		getPlus().addActionListener(al);
		getMinus().addActionListener(al);
		getDelete().addActionListener(al);
					
	}
	
	public JPanel getDisplayButton() {
		return displayButton;
	}
	public void setDisplayButton(JPanel displayButton) {
		this.displayButton = displayButton;
	}
	public JPanel getOp() {
		return op;
	}
	public void setOp(JPanel op) {
		this.op = op;
	}
	public JPanel getZahlenPanel() {
		return zahlenPanel;
	}
	public void setZahlenPanel(JPanel zahlenPanel) {
		this.zahlenPanel = zahlenPanel;
	}
	
	public JButton getEquals() {
		return equals;
	}
	public void setEquals(JButton equals) {
		this.equals = equals;
	}
	public JPanel getDisplay() {
		return display;
	}
	public void setDisplay(JPanel display) {
		this.display = display;
	}
	//Geaendert: Gibt i des arrays zurueck, nicht ganzen Array	
	public JButton getZahlenButton(int i) {
		return zahlenButton[i];
	}
	public void setZahlenButton(JButton[] zahlenButton) {
		this.zahlenButton = zahlenButton;
	}
	public JButton getZero() {
		return zero;
	}
	public void setA(JButton zero) {
		this.zero = zero;
	}
	public JButton getPunkt() {
		return punkt;
	}
	public void setB(JButton punkt) {
		this.punkt = punkt;
	}
	public JTextField getDisplayField() {
		return displayField;
	}
	public void setDisplayField(JTextField string) {
		this.displayField = string;
	}
	
	public JButton getPlus() {
		return plus;
	}
	public void setPlus(JButton plus) {
		this.plus = plus;
	}
	public JButton getMinus() {
		return minus;
	}
	public void setMinus(JButton minus) {
		this.minus = minus;
	}
	public JButton getMal() {
		return mal;
	}
	public void setMal(JButton mal) {
		this.mal = mal;
	}
	public JButton getGeteilt() {
		return geteilt;
	}
	public void setGeteilt(JButton geteilt) {
		this.geteilt = geteilt;
	}
	
		

}

