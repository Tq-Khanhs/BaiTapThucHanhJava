package tuan1CongTruNhanChia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CongTruNhanChia extends JFrame implements ActionListener{
	
	private JButton btnGiai;
	private JButton btnXoa;
	private JButton btnThoat;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtKQ;
	private JLabel lblA;
	private JLabel lblB;
	private JLabel lblKQ;
	private JRadioButton radCong;
	private JRadioButton radTru;
	private JRadioButton radNhan;
	private JRadioButton radChia;
	
	
	public CongTruNhanChia()
	{
		setTitle("Cộng-trừ-nhân-chia");
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
        setLocationRelativeTo(null);
        createGUI();
	}
	
	public void createGUI() {
		JPanel panelNorth;
		add(panelNorth = new JPanel(), BorderLayout.NORTH);
		JLabel lblTieuDe = new JLabel("Cộng trừ nhân chia");
		panelNorth.add(lblTieuDe);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.BLUE);
		
		JPanel panelWest;
		add(panelWest = new JPanel(),BorderLayout.WEST);
		panelWest.setLayout(new GridLayout(6,1));
		panelWest.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		panelWest.setBackground(Color.gray);
		panelWest.setPreferredSize(new Dimension(100,300));
		btnGiai = new JButton("Giai");
		btnXoa = new JButton("Xoa");
		btnThoat = new JButton("Thoat");
		panelWest.add(btnGiai);
		panelWest.add(btnXoa);
		panelWest.add(btnThoat);
		
		JPanel panelCenter;
		add(panelCenter = new JPanel(),BorderLayout.CENTER);
		panelCenter.setLayout(null);
		panelCenter.setBorder(BorderFactory.createTitledBorder("Tính toán"));
		panelCenter.add(lblA= new JLabel("Nhap a: ")) ;
		panelCenter.add(lblB= new JLabel("Nhap b: ")) ;
		panelCenter.add(lblKQ= new JLabel("Ket Qua ")) ;
		panelCenter.add(txtA = new JTextField());
		panelCenter.add(txtB = new JTextField());
		panelCenter.add(txtKQ = new JTextField());
		txtKQ.setEditable(false);
		
		JPanel panelCenterCenter;
		panelCenter.add(panelCenterCenter = new JPanel());
		panelCenterCenter.add(radCong = new JRadioButton("Cộng"));
		panelCenterCenter.add(radTru = new JRadioButton("Trừ"));
		panelCenterCenter.add(radNhan = new JRadioButton("Nhân"));
		panelCenterCenter.add(radChia = new JRadioButton("Chia"));
		panelCenterCenter.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		panelCenterCenter.setLayout(new GridLayout(2, 2));
		
		lblA.setBounds(50, 20, 50, 30);
		lblB.setBounds(50, 60, 50, 30);
		lblKQ.setBounds(50, 220, 50, 30);

		txtA.setBounds(100, 20, 250, 30);
		txtB.setBounds(100, 60, 250, 30);
		txtKQ.setBounds(100, 220, 250, 30);

		panelCenterCenter.setBounds(100, 100, 250, 100);
		panelCenterCenter.setBounds(100, 100, 250, 100);
		
		JPanel panelSouth;
		add(panelSouth = new JPanel(), BorderLayout.SOUTH);
		panelSouth.setPreferredSize(new Dimension(0, 50));
		panelSouth.setBackground(Color.PINK);
		panelSouth.add(new JLabel(new ImageIcon("hinh/hinh2.png")));
		
	}
	
	public static void main(String[] args) {
		new CongTruNhanChia().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
