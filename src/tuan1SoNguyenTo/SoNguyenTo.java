package tuan1SoNguyenTo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SoNguyenTo extends JFrame implements ActionListener{
	private JTextField txtNhap;
	private JButton buttonGenarate;
	private JTextArea  taKQ;
	private JScrollPane scroll;
	
	
	public SoNguyenTo()
	{
		setTitle("Primes");
		setSize(400,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		createGUI();
	}
	
	public void createGUI()
	{
		setLayout(null);
		add(txtNhap = new JTextField());
		txtNhap.setBounds(50, 30, 200, 30);
		txtNhap.setToolTipText("Nhap so nguyen to can hien thi");
		
		add(buttonGenarate = new JButton("Genarate"));
		buttonGenarate.setBounds(250, 30, 100, 30);
		
		taKQ = new JTextArea();
		scroll = new JScrollPane(taKQ);
		add(scroll);
		scroll.setBounds(50,70,300,270);
		taKQ.setToolTipText("Danh sach so nguyen to");
		taKQ.setEditable(false);
		
		
		buttonGenarate.addActionListener(this);
		
		
	}
	
	public static void main(String[] args) {
		new SoNguyenTo().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		int a = Integer.parseInt(txtNhap.getText());
		if(o==buttonGenarate) {
			 for (int i = 2, count = 0; count <a; i++) {
		            if (isPrime(i)) {
		                taKQ.append(i + "\n");
		                count++;
		            }
		        }
			
		}
		
	}
	
	 private static boolean isPrime(int num) {
	        if (num < 2) {
	            return false;
	        }
	        for (int i = 2; i <= Math.sqrt(num); i++) {
	            if (num % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
}
