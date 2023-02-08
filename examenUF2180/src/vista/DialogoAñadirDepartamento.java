package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import modelo.Departamento;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoAñadirDepartamento extends JFrame {

	private JPanel contentPane = new JPanel();
	private JTextField textCodDepa;
	private JTextField textCodCentro;
	private final ButtonGroup TipoDir = new ButtonGroup();
	private JTextField textNombre;
	private JSpinner spinnerPresupuesto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogoAñadirDepartamento frame = new DialogoAñadirDepartamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DialogoAñadirDepartamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Detalles del Departamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 414, 205);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[][][139.00,grow][153.00]", "[grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(DialogoAñadirDepartamento.class.getResource("/images/editar32.png")));
		panel.add(lblNewLabel_3, "cell 0 0 1 2");
		
		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel, "cell 1 0,alignx trailing");
		
		textCodDepa = new JTextField();
		textCodDepa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCodDepa.setColumns(10);
		panel.add(textCodDepa, "cell 2 0 2 1,growx");
		
		JLabel lblCentro = new JLabel("Centro:");
		lblCentro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblCentro, "cell 1 1,alignx trailing");
		
		textCodCentro = new JTextField();
		textCodCentro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCodCentro.setColumns(10);
		panel.add(textCodCentro, "cell 2 1 2 1,growx");
		
		JLabel lblTipoDireccion = new JLabel("Tipo Direccion:");
		lblTipoDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblTipoDireccion, "cell 0 2 2 1,alignx right");
		
		JRadioButton rdbtnPropiedad = new JRadioButton("Propiedad");
		TipoDir.add(rdbtnPropiedad);
		rdbtnPropiedad.setSelected(true);
		rdbtnPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(rdbtnPropiedad, "flowx,cell 2 2");
		
		JLabel lblPresupuesto = new JLabel("Presupuesto:");
		lblPresupuesto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblPresupuesto, "cell 1 3,alignx right");
		
		spinnerPresupuesto = new JSpinner();
		spinnerPresupuesto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerPresupuesto.getModel().setValue(5);
	//	spinnerPresupuesto.getModel().setMinimum(2);
		panel.add(spinnerPresupuesto, "flowx,cell 2 3");
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNombre, "cell 1 4,alignx trailing");
		
		JRadioButton rdbtnFunciones = new JRadioButton("En funciones");
		TipoDir.add(rdbtnFunciones);
		rdbtnFunciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(rdbtnFunciones, "cell 2 2");
		
		JLabel lblenMilesDe = new JLabel("(en miles de €)");
		lblenMilesDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblenMilesDe, "cell 2 3,alignx center");
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNombre.setColumns(10);
		panel.add(textNombre, "cell 2 4 2 1,growx");
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(10, 215, 414, 35);
		contentPane.add(buttonPane);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recogerDatos();

				
				
				
				
				
			}
		});
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				
				
				
				
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
	
	
	
	
	protected void recogerDatos() {
		int cod_departamento = Integer.parseInt(textCodDepa.getText());
		int cod_centro = Integer.parseInt(textCodCentro.getText());
		String tipo_dir = TipoDir.();
		int presupuesto = Integer.parseInt(textCodCentro.getText());
		String nombre = textNombre.getText();
		
		Departamento departamento = new Departamento(cod_departamento, cod_centro, tipo_dir,presupuesto , nombre);
		
		int cantidad = (int) spinnerCantidad.getValue();
		controlador.insertaCentro(centro);
		
	}


	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
	}
}
