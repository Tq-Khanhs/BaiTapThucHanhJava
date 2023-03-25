package tuan1PhuongTrinhBac2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PhuongTrinhBac2 extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JButton buttonGiai;
	private JButton buttonXoa;
	private JButton buttonThoat;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtKQ;
	
	public PhuongTrinhBac2()
	{
		setTitle("^-^");
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		creatGUI();
	}
	
	public void creatGUI()
	{
		JPanel panelNorth;
		add(panelNorth = new JPanel(),BorderLayout.NORTH);
		panelNorth.setBackground(Color.CYAN);
		JLabel lblTieuDe;
		panelNorth.add(lblTieuDe= new JLabel("GIAI PHUONG TRINH BAC HAI"));
		lblTieuDe.setFont( new Font("Arial",Font.BOLD, 20));
		
		JPanel panelCenter;
		add(panelCenter = new JPanel(),BorderLayout.CENTER);
		panelCenter.setLayout(null);
		
		JLabel lblNhapA, lblNhapB, lblNhapC, lblKetQua;
		
		panelCenter.add(lblNhapA= new JLabel("Nhap a: ")) ;
		int x=20, y=40, width=100, height= 30;
		lblNhapA.setBounds(x, y, width, height);
		
		panelCenter.add(lblNhapB= new JLabel("Nhap b: ")) ;
		y+= 50;
		lblNhapB.setBounds(x, y, width, height);
		
		panelCenter.add(lblNhapC= new JLabel("Nhap c: ")) ;
		y+= 50;
		lblNhapC.setBounds(x, y, width, height);
		
		panelCenter.add(lblKetQua= new JLabel("Ket Qua: ")) ;
		y+= 50;
		lblKetQua.setBounds(x, y, width, height);
		
		panelCenter.add(txtA = new JTextField());
		x += 100; y=40; width=300;
		txtA.setBounds(x,y,width,height);
		
		panelCenter.add(txtB = new JTextField());
		y+=50;
		txtB.setBounds(x,y,width,height);
		
		panelCenter.add(txtC = new JTextField());
		y+=50;
		txtC.setBounds(x,y,width,height);
		
		panelCenter.add(txtKQ = new JTextField());
		y+=50;
		txtKQ.setBounds(x,y,width,height);
		txtKQ.setEditable(false);
		
		JPanel panelSouth;
		add(panelSouth = new JPanel(),BorderLayout.SOUTH);
		panelSouth.setBorder(BorderFactory.createTitledBorder("Chon tac vu"));
		panelSouth.add(buttonGiai= new JButton("Giai"));
		panelSouth.add(buttonXoa= new JButton("Xoa Rong"));
		panelSouth.add(buttonThoat= new JButton("Thoat"));
		
		
		buttonGiai.addActionListener(this);
		buttonXoa.addActionListener(this);
		buttonThoat.addActionListener(this);
	}
	
	public static void main(String[] args) {
	    new PhuongTrinhBac2().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(buttonThoat))
			System.exit(0);
		else if(o.equals(buttonXoa)){
			txtA.setText("");
			txtB.setText("");
			txtC.setText("");
			txtKQ.setText("");
			txtA.requestFocus();
		}else if(o.equals(buttonGiai)){
			if(!isInt(txtA)) {
				focus(txtA);
			}
			if(!isInt(txtB)) {
				focus(txtB);
			}
			if(!isInt(txtC)) {
				focus(txtC);
			}
			
			int a = Integer.parseInt(txtA.getText());
			int b = Integer.parseInt(txtB.getText());
			int c = Integer.parseInt(txtC.getText());
			if(a==0) {
				giaiPhuongTrinhBac1(b,c);
			}else {
				float delta = b*b - 4*a*c;
				if(delta<0) {
					txtKQ.setText("Vo nghiem");
				}else if(delta == 0) {
					txtKQ.setText("Nghiem kep x1 = x2 =" +(-b/2*(float)a));
				}else {
					txtKQ.setText("Co hai nghiem x1 = " +((-b+Math.sqrt(delta))/(2*(float)a)) +",x2 = " + ((-b-Math.sqrt(delta))/(2*(float)a)) );
					
				}
			}
			
		}
		
		
	}
	
	private void focus(JTextField text)
	{
		JOptionPane.showMessageDialog(null,"Nhap lai");
		text.selectAll();
		text.requestFocus();
	}
	
	private boolean isInt(JTextField text)
	{
		boolean result = true;
		try {
			Integer.parseInt(text.getText());
		}catch(NumberFormatException ex) {
			result = false;
		}
		return result;
	}
	
	private void giaiPhuongTrinhBac1(int a,int b)
	{
		if(a!= 0) {
			txtKQ.setText("Nghiem x = "+(-b/(float)a));
		}else if(b == 0)
		{
			txtKQ.setText("Vo so nghiem");
		}else {
			txtKQ.setText("Vo nghiem");
		}
	}
	
	

}
