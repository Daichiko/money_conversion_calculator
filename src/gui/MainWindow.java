package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField BolivaresJtextfield;
	private JTextField DolaresJtextfield;
	private JTextField TasaJtextfield;
	private JLabel BolivaresResult;
	private JLabel USDResult;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 263);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel BolivaresLabel = new JLabel("Bs:");
		BolivaresLabel.setFont(new Font("Impact", Font.PLAIN, 16));
		BolivaresLabel.setBounds(30, 30, 45, 19);
		contentPane.add(BolivaresLabel);
		
		BolivaresJtextfield = new JTextField();
		BolivaresJtextfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!TasaJtextfield.getText().isEmpty()) {      
	            	if (moreTwoComma(TasaJtextfield.getText())) {
		                JOptionPane.showMessageDialog(null, "El campo 'Tasa' no puede estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
	            	}else 
	            	{
			            if (BolivaresJtextfield.getText().isEmpty() && DolaresJtextfield.getText().isEmpty()) {
			                JOptionPane.showMessageDialog(null, "Rellene el campo 'Bs' o 'USD' para la conversion", "Advertencia", JOptionPane.WARNING_MESSAGE);
			            }else {
			            	if (!BolivaresJtextfield.getText().isEmpty())
				                if (moreTwoComma(BolivaresJtextfield.getText())) {
					                JOptionPane.showMessageDialog(null, "El campo 'Bs' no puede poseer mas de 1 coma", "Advertencia", JOptionPane.WARNING_MESSAGE);
					            }else
					            	convertBolivaresToDolares();
			            	else
			            		USDResult.setText("");
			            	
			            	if (!DolaresJtextfield.getText().isEmpty())
					            if (moreTwoComma(DolaresJtextfield.getText())) {		
					                JOptionPane.showMessageDialog(null, "El campo 'USD' no puede poseer mas de 1 coma", "Advertencia", JOptionPane.WARNING_MESSAGE);
					            }else
					                convertDolaresToBolivares();
			            	else
			            		BolivaresResult.setText("");
			            }
	            	}
	            }else
	                JOptionPane.showMessageDialog(null, "El campo 'Tasa' no puede estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		});
		BolivaresJtextfield.setFont(new Font("Impact", Font.PLAIN, 16));
		BolivaresJtextfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
		        
				if (!(Character.isDigit(keyChar) || keyChar == ','))
					e.consume();
			}
		});
		BolivaresJtextfield.setBounds(69, 30, 297, 19);	
		contentPane.add(BolivaresJtextfield);
		BolivaresJtextfield.setColumns(10);
		
		DolaresJtextfield = new JTextField();
		DolaresJtextfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!TasaJtextfield.getText().isEmpty()) {      
	            	if (moreTwoComma(TasaJtextfield.getText())) {
		                JOptionPane.showMessageDialog(null, "El campo 'Tasa' no puede estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
	            	}else 
	            	{
			            if (BolivaresJtextfield.getText().isEmpty() && DolaresJtextfield.getText().isEmpty()) {
			                JOptionPane.showMessageDialog(null, "Rellene el campo 'Bs' o 'USD' para la conversion", "Advertencia", JOptionPane.WARNING_MESSAGE);
			            }else {
			            	if (!BolivaresJtextfield.getText().isEmpty())
				                if (moreTwoComma(BolivaresJtextfield.getText())) {
					                JOptionPane.showMessageDialog(null, "El campo 'Bs' no puede poseer mas de 1 coma", "Advertencia", JOptionPane.WARNING_MESSAGE);
					            }else
					            	convertBolivaresToDolares();
			            	else
			            		USDResult.setText("");
			            	
			            	if (!DolaresJtextfield.getText().isEmpty())
					            if (moreTwoComma(DolaresJtextfield.getText())) {		
					                JOptionPane.showMessageDialog(null, "El campo 'USD' no puede poseer mas de 1 coma", "Advertencia", JOptionPane.WARNING_MESSAGE);
					            }else
					                convertDolaresToBolivares();
			            	else
			            		BolivaresResult.setText("");
			            }
	            	}
	            }else
	                JOptionPane.showMessageDialog(null, "El campo 'Tasa' no puede estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		});
		DolaresJtextfield.setFont(new Font("Impact", Font.PLAIN, 16));
		DolaresJtextfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
		        
				if (!(Character.isDigit(keyChar) || keyChar == ','))
					e.consume();
			}
		});
		DolaresJtextfield.setBounds(69, 80, 297, 19);
		contentPane.add(DolaresJtextfield);
		DolaresJtextfield.setColumns(10);
		
		JButton Exit = new JButton("Salir");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Exit.setBounds(520, 185, 85, 21);
		contentPane.add(Exit);
		
		TasaJtextfield = new JTextField();
		TasaJtextfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!TasaJtextfield.getText().isEmpty()) {      
	            	if (moreTwoComma(TasaJtextfield.getText())) {
		                JOptionPane.showMessageDialog(null, "El campo 'Tasa' no puede estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
	            	}else 
	            	{
			            if (BolivaresJtextfield.getText().isEmpty() && DolaresJtextfield.getText().isEmpty()) {
			                JOptionPane.showMessageDialog(null, "Rellene el campo 'Bs' o 'USD' para la conversion", "Advertencia", JOptionPane.WARNING_MESSAGE);
			            }else {
			            	if (!BolivaresJtextfield.getText().isEmpty())
				                if (moreTwoComma(BolivaresJtextfield.getText())) {
					                JOptionPane.showMessageDialog(null, "El campo 'Bs' no puede poseer mas de 1 coma", "Advertencia", JOptionPane.WARNING_MESSAGE);
					            }else
					            	convertBolivaresToDolares();
			            	else
			            		USDResult.setText("");
			            	
			            	if (!DolaresJtextfield.getText().isEmpty())
					            if (moreTwoComma(DolaresJtextfield.getText())) {		
					                JOptionPane.showMessageDialog(null, "El campo 'USD' no puede poseer mas de 1 coma", "Advertencia", JOptionPane.WARNING_MESSAGE);
					            }else
					                convertDolaresToBolivares();
			            	else
			            		BolivaresResult.setText("");
			            }
	            	}
	            }else
	                JOptionPane.showMessageDialog(null, "El campo 'Tasa' no puede estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		});
		TasaJtextfield.setFont(new Font("Impact", Font.PLAIN, 16));
		TasaJtextfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
		        
				if (!(Character.isDigit(keyChar) || keyChar == ','))
					e.consume();
			}
		});
		TasaJtextfield.setBounds(69, 130, 166, 19);
		contentPane.add(TasaJtextfield);
		TasaJtextfield.setColumns(10);
		
		JLabel DolaresLabel = new JLabel("USD:");
		DolaresLabel.setFont(new Font("Impact", Font.PLAIN, 16));
		DolaresLabel.setBounds(30, 80, 45, 19);
		contentPane.add(DolaresLabel);
		
		JLabel TasaLabel = new JLabel("Tasa:");
		TasaLabel.setFont(new Font("Impact", Font.PLAIN, 16));
		TasaLabel.setBounds(30, 130, 45, 19);
		contentPane.add(TasaLabel);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!TasaJtextfield.getText().isEmpty()) {      
	            	if (moreTwoComma(TasaJtextfield.getText())) {
		                JOptionPane.showMessageDialog(null, "El campo 'Tasa' no puede estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
	            	}else 
	            	{
			            if (BolivaresJtextfield.getText().isEmpty() && DolaresJtextfield.getText().isEmpty()) {
			                JOptionPane.showMessageDialog(null, "Rellene el campo 'Bs' o 'USD' para la conversion", "Advertencia", JOptionPane.WARNING_MESSAGE);
			            }else {
			            	if (!BolivaresJtextfield.getText().isEmpty())
				                if (moreTwoComma(BolivaresJtextfield.getText())) {
					                JOptionPane.showMessageDialog(null, "El campo 'Bs' no puede poseer mas de 1 coma", "Advertencia", JOptionPane.WARNING_MESSAGE);
					            }else
					            	convertBolivaresToDolares();
			            	else
			            		USDResult.setText("");
			            	
			            	if (!DolaresJtextfield.getText().isEmpty())
					            if (moreTwoComma(DolaresJtextfield.getText())) {		
					                JOptionPane.showMessageDialog(null, "El campo 'USD' no puede poseer mas de 1 coma", "Advertencia", JOptionPane.WARNING_MESSAGE);
					            }else
					                convertDolaresToBolivares();
			            	else
			            		BolivaresResult.setText("");
			            }
	            	}
	            }else
	                JOptionPane.showMessageDialog(null, "El campo 'Tasa' no puede estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);	
			}
		});
		btnCalcular.setBounds(30, 185, 85, 21);
		contentPane.add(btnCalcular);
		
		USDResult = new JLabel("Conversion: ");
		USDResult.setFont(new Font("Impact", Font.PLAIN, 16));
		USDResult.setBounds(376, 30, 237, 13);
		contentPane.add(USDResult);
		
		BolivaresResult = new JLabel("Conversion:\r\n");
		BolivaresResult.setFont(new Font("Impact", Font.PLAIN, 16));
		BolivaresResult.setBounds(376, 80, 237, 13);
		contentPane.add(BolivaresResult);
	}
	
	private void convertBolivaresToDolares() {
        try {
        	String bolivaresString = BolivaresJtextfield.getText().replace(",", ".");
            double bolivares = Double.parseDouble(bolivaresString);

            String tasaString = TasaJtextfield.getText().replace(",", ".");
            double tasa = Double.parseDouble(tasaString);
            
            double dolares = bolivares / tasa;
            
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("#,###.####", symbols);
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
            String dolaresFormatted = decimalFormat.format(dolares);          
            
            USDResult.setText("Conversion: " + dolaresFormatted + "$");          
            
        } catch (NumberFormatException e) {
        	DolaresJtextfield.setText("");
        }
    }

    private void convertDolaresToBolivares() {
        try {
        	String dolaresString = DolaresJtextfield.getText().replace(",", ".");
            double dolares = Double.parseDouble(dolaresString);

            String tasaString = TasaJtextfield.getText().replace(",", ".");
            double tasa = Double.parseDouble(tasaString);
        	
            double bolivares = dolares * tasa;
            
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("#,###.####", symbols);
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
            String bolivaresFormatted = decimalFormat.format(bolivares);
            
            BolivaresResult.setText("Conversion: " +  bolivaresFormatted  + "Bs");
            
        } catch (NumberFormatException e) {
        	BolivaresJtextfield.setText("");
        }
    }
    
    private static boolean moreTwoComma(String texto) {
        int contadorComas = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == ',') {
                contadorComas++;
            }
            if (contadorComas >= 2)
            	return true;
        }
        return false;
    }
}
