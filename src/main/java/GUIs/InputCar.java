package GUIs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataObjects.DataCar;
import DataOnly.Car;
import Utilities.DataOverNetwork;

import javax.swing.JTextPane;
import javax.swing.JCheckBox;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class InputCar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputCar frame = new InputCar();
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
	public InputCar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 3000, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane txtNumber = new JTextPane();
		txtNumber.setText("number");
		txtNumber.setToolTipText("");
		txtNumber.setBounds(10, 92, 285, 20);
		contentPane.add(txtNumber);

		JTextPane petriname = new JTextPane();
		petriname.setText("1080");
		petriname.setBounds(10, 159, 285, 20);
		contentPane.add(petriname);

		JTextPane txtModel = new JTextPane();
		txtModel.setText("model");
		txtModel.setBounds(10, 61, 285, 20);
		contentPane.add(txtModel);

		JTextPane txtTarget = new JTextPane();
		txtTarget.setToolTipText("");
		txtTarget.setText("target");
		txtTarget.setBounds(10, 123, 2850, 20);
		contentPane.add(txtTarget);

		JTextPane txtPlace = new JTextPane();
		txtPlace.setText("P");
		txtPlace.setBounds(10, 21, 285, 20);
		contentPane.add(txtPlace);

		JCheckBox isPriorityCarCheckBox = new JCheckBox("isPriorityCar");
		isPriorityCarCheckBox.setBounds(10, 200, 100, 20);
		contentPane.add(isPriorityCarCheckBox);

		JCheckBox isBusCheckBox = new JCheckBox("isBus");
		isBusCheckBox.setBounds(10, 220, 100, 20);
		contentPane.add(isBusCheckBox);

		JCheckBox isTaxiCheckBox = new JCheckBox("isTaxi");
		isTaxiCheckBox.setBounds(10, 240, 100, 20);
		contentPane.add(isTaxiCheckBox);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Socket s;
				try {
					s = new Socket(InetAddress.getByName("localhost"), Integer.parseInt(petriname.getText()));
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					DataOverNetwork DataToSend = new DataOverNetwork();

					DataCar temp = new DataCar();
					Car c = new Car(txtModel.getText(), txtNumber.getText(), txtTarget.getText().split(","),
							isPriorityCarCheckBox.isSelected(), isBusCheckBox.isSelected(), isTaxiCheckBox.isSelected());
					temp.SetValue(c);
					temp.SetName(txtPlace.getText());
					DataToSend.petriObject = temp;

					DataToSend.NetWorkPort = Integer.parseInt(petriname.getText());
					oos.writeObject(DataToSend);
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSend.setBounds(10, 280, 285, 44);
		contentPane.add(btnSend);

	}
}
