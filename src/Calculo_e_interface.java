import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Calculo_e_interface extends JFrame {

	private JLabel lblPeso;
	private JLabel lblAltura;
	private JLabel lblResultado;
	private JLabel lblKg;
	private JLabel lblMetro;
	private JButton btnCalcular; 
	private JButton btnLimpar;
	private JTextField txfPeso;
	private JTextField txfAltura;
	private JTextField txfPesoideal;
	private JTextField txfIMC;
	private JTextField txfInterpretacao;
	private String peso_Ideal , Imc;
	
	// Construtor da classe.
	public Calculo_e_interface() {
		
		setTitle("Calculo de IMC");  // Seta o titulo
		setSize(300, 500);			 // Seta o Tamanho
		setLayout(null); 			 // Define o layout
		setLocationRelativeTo(null); // Centraliza a tela
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Fecha o processo quando clicado no X
		
		ComponentesCriar();
	}
	
	// Cria todos os componentes e adiciona no JFrame.
	private void ComponentesCriar() {
		
		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 10, 70, 25);
		getContentPane().add(lblPeso);
		
		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 80, 70, 25);
		getContentPane().add(lblAltura);
		
		lblKg = new JLabel("Kg");
		lblKg.setBounds(200, 25, 70, 25);
		getContentPane().add(lblKg);
		
		lblMetro = new JLabel("M");
		lblMetro.setBounds(200, 105, 70, 25);
		getContentPane().add(lblMetro);
		
		btnCalcular = new JButton (new AbstractAction("Calcular") {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				double peso = Double.parseDouble(txfPeso.getText());
				double altura = Double.parseDouble(txfAltura.getText());
				double alturaCM = altura * 100;
				
				double pesoIdeal = (alturaCM - 100) - ((alturaCM - peso)/4)*(5/100);
				peso_Ideal = Double.toString(pesoIdeal);
				
				double IMC = peso / Math.pow(altura, 2);
				Imc = Double.toString(IMC);
				
				if (IMC < 20) {
					txfInterpretacao.setText("Baixo Peso");
					txfIMC.setText(Imc);
					txfPesoideal.setText(peso_Ideal);
				}
				else if (IMC < 25) {
					txfInterpretacao.setText("Normal");
					txfIMC.setText(Imc);
					txfPesoideal.setText(peso_Ideal);
				}
				else if (IMC <= 30) {
					txfInterpretacao.setText("Acima do Peso");
					txfIMC.setText(Imc);
					txfPesoideal.setText(peso_Ideal);
				}
				else {
					txfInterpretacao.setText("Obeso");
					txfIMC.setText(Imc);
					txfPesoideal.setText(peso_Ideal);
				}
				
			}
		});
		btnCalcular.setBounds(10, 140, 140, 25);
		getContentPane().add(btnCalcular);
		
		btnLimpar = new JButton (new AbstractAction("Limpar") {
			
			@Override
			
			public void actionPerformed(ActionEvent e) {
				ComponentesCriar();
				
			}
			});
		
		btnLimpar.setBounds(10, 400, 140, 25);
		getContentPane().add(btnLimpar);
		
		txfPeso = new JTextField();
		txfPeso.setText("Digite sua Altura");
		txfPeso.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txfPeso.getText().isEmpty()) {
					txfPeso.setText("Digite seu Peso");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txfPeso.setText("");
			}
		});
		txfPeso.setBounds(10, 35, 180, 25);
		getContentPane().add(txfPeso);
		
		
		txfAltura = new JTextField();
		txfAltura.setText("Digite sua Altura");
		txfAltura.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (txfAltura.getText().isEmpty()) {
					txfAltura.setText("Digite sua Altura");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txfAltura.setText("");
				
			}
		});
		txfAltura.setToolTipText("Altura");
		txfAltura.setBounds(10, 105, 180, 25);
		getContentPane().add(txfAltura);
		
		txfPesoideal = new JTextField();
		txfPesoideal.setBounds(10, 250, 130, 25);
		txfPesoideal.setText("Peso ideal");
		txfPesoideal.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txfPesoideal.getText().isEmpty()) {
					txfPesoideal.setText("Peso ideal");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txfPesoideal.setText("");
				
			}
		});
		getContentPane().add(txfPesoideal);
		
		txfIMC = new JTextField ();
		txfIMC.setBounds(150, 250, 140, 25);
		txfIMC.setText("IMC");
		txfIMC.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txfIMC.getText().isEmpty()) {
					txfIMC.setText("IMC");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txfIMC.setText("");
			}
		});
		getContentPane().add(txfIMC);
		
		txfInterpretacao = new JTextField();
		txfInterpretacao.setText("Interpretação");
		txfInterpretacao.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txfInterpretacao.getText().isEmpty()) {
					txfInterpretacao.setText("Interpretação");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txfInterpretacao.setText("");
				
			}
		});
		txfInterpretacao.setBounds(10, 290, 280, 25);
		getContentPane().add(txfInterpretacao);
		
		
		
	}
	
	
	public static void main(String[] args) {

		new Calculo_e_interface().setVisible(true);

	}

}
