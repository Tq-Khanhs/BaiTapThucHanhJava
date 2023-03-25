package tuan3QuanLiSach;

	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;



	public class QLSachGUI extends JFrame implements ActionListener,MouseListener  {

		
		private JTextField txtMaSach;
		private JTextField txtTuaSach;
		private JTextField txtTacGia;
		private JTextField txtNamXB;
		private JTextField txtNhaXB;
		private JTextField txtSoTrang;
		private JTextField txtDonGia;
		private JTextField txtISBN;
		private JButton btnThem;
		private JButton btnXoa;
		private JButton btnSua;
		private JButton btnLuu;
		private JComboBox<String> cboMaSach;
		private JTable table;
		private JTextField txtMess;
		private JButton btnXoaRong;
		private JPanel pnlSouth;
		private DefaultTableModel model; 
	    private ThuVien thuvien;

	
		private JButton btnLoc;

		public QLSachGUI() {
			setTitle("Quáº£n lÃ½ sÃ¡ch");
			setSize(900, 600);
			setLocationRelativeTo(null);
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			buildUI();
		}

		private void buildUI() {

			JPanel pnlNorth;
			add(pnlNorth = new JPanel(), BorderLayout.NORTH);
			pnlNorth.setPreferredSize(new Dimension(0, 180));
			pnlNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
			pnlNorth.setLayout(null); //Absolute layout

			JLabel lblMaSach, lblTuaSach, lblTacGia, lblNamXB, lblNhaXB, lblSoTrang, lblDonGia, lblISBN;
			pnlNorth.add(lblMaSach = new JLabel("Mã sách: "));
			pnlNorth.add(lblTuaSach = new JLabel("Tựa sách: "));
			pnlNorth.add(lblTacGia = new JLabel("Tác giả: "));
			pnlNorth.add(lblNamXB = new JLabel("Năm xuất bản: "));
			pnlNorth.add(lblNhaXB = new JLabel("Nhà xuất bản: "));
			pnlNorth.add(lblSoTrang = new JLabel("Số trang: "));
			pnlNorth.add(lblDonGia = new JLabel("Đơn giá: "));
			pnlNorth.add(lblISBN = new JLabel("International Standard Book Number: "));

			pnlNorth.add(txtMaSach = new JTextField());
			pnlNorth.add(txtTuaSach = new JTextField());
			pnlNorth.add(txtTacGia = new JTextField());
			pnlNorth.add(txtNamXB = new JTextField());
			pnlNorth.add(txtNhaXB = new JTextField());
			pnlNorth.add(txtSoTrang = new JTextField());
			pnlNorth.add(txtDonGia = new JTextField());
			pnlNorth.add(txtISBN = new JTextField());

			pnlNorth.add(txtMess = new JTextField());
			txtMess.setEditable(false);
			txtMess.setBorder(null);
			txtMess.setForeground(Color.red);
			txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

			int w1 = 100, w2 = 300, h = 20;
			lblMaSach.setBounds(20, 20, w1, h); txtMaSach.setBounds(120, 20, 200, h);

			lblTuaSach.setBounds(20, 45, w1, h); txtTuaSach.setBounds(120, 45, w2, h);
			lblTacGia.setBounds(450, 45, w1, h); txtTacGia.setBounds(570, 45, w2, h);

			lblNamXB.setBounds(20, 70, w1, h); txtNamXB.setBounds(120, 70, w2, h);
			lblNhaXB.setBounds(450, 70, w1, h); txtNhaXB.setBounds(570, 70, w2, h);

			lblSoTrang.setBounds(20, 95, w1, h); txtSoTrang.setBounds(120, 95, w2, h);
			lblDonGia.setBounds(450, 95, w1, h); txtDonGia.setBounds(570, 95, w2, h);

			lblISBN.setBounds(20, 120, 220, h); txtISBN.setBounds(240, 120, 180, h);
			txtMess.setBounds(20, 145, 550, 20);

			
			JPanel pnlCenter;
			add(pnlCenter = new JPanel(), BorderLayout.CENTER);
			pnlCenter.add(btnThem = new JButton("Them")); 
			pnlCenter.add(btnXoaRong = new JButton("Xoa rong"));
			pnlCenter.add(btnXoa = new JButton("Xoa"));
			pnlCenter.add(btnSua = new JButton("Sua"));
			pnlCenter.add(btnLuu = new JButton("Luu"));
			pnlCenter.add(new JLabel("Tim Theo ma sach: "));
			pnlCenter.add(cboMaSach = new JComboBox<String>());
			cboMaSach.setPreferredSize(new Dimension(100, 25));
			pnlCenter.add(btnLoc = new JButton("Loc theo tua sach"));


		    pnlSouth = new JPanel();
		    pnlSouth.setBorder(BorderFactory.createTitledBorder("Danh sach cac cuon sach"));
		    add(pnlSouth,BorderLayout.SOUTH);
		    taoBang();
		    table.addMouseListener(this);
		    
		    thuvien = new ThuVien();
		    thuvien.napDuLieuTuFile();
		    docDuLieuTuListVaoModel();
		    capNhatCombobox();
		    
		    

			cboMaSach.addActionListener(this);
			btnThem.addActionListener(this);
			btnXoa.addActionListener(this);
			btnXoaRong.addActionListener(this);
			btnSua.addActionListener(this);
			btnLuu.addActionListener(this);
			btnLoc.addActionListener(this);
		}
		
		public void taoBang()
		{
			model = new DefaultTableModel();
			model.addColumn("Ma sach");
			model.addColumn("Tua sach");
			model.addColumn("Tac gia");
			model.addColumn("Nam XB");
			model.addColumn("Nha XB");
			model.addColumn("So trang");
			model.addColumn("Don gia");
			model.addColumn("ISBN");
			table = new JTable(model);
		    JScrollPane scrollPane = new JScrollPane(table);
		    TableColumn column = new TableColumn();
		     for (int i = 0; i < table.getColumnCount(); i++) {
		            column = table.getColumnModel().getColumn(i);
		            column.setPreferredWidth(120);
		        }    
		    table.setPreferredScrollableViewportSize(new Dimension(880,290));;
		        
		    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		    rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		    DefaultTableCellRenderer xenter = new DefaultTableCellRenderer();
		    xenter.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		    table.getColumnModel().getColumn(0).setCellRenderer(xenter);
		    table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		    table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		    table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		    pnlSouth.add(scrollPane);
		}
		
		public static void main(String[] args) {
			new QLSachGUI().setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if(o==btnThem) {
				if(txtMaSach.getText().equals("")||txtTuaSach.getText().equals("")||txtDonGia.getText().equals("")||txtISBN.getText().equals("")||txtNamXB.getText().equals("")||txtNhaXB.getText().equals("")||txtSoTrang.getText().equals("")||txtTacGia.getText().equals("")) {
					JOptionPane.showMessageDialog(this,"Hay nhap day du thong tin");
				}
				else {
					String ma = txtMaSach.getText();
					String tua = txtTuaSach.getText();
					String tacgia = txtTacGia.getText();
					int namXB = Integer.parseInt(txtNamXB.getText());
					String nhaXB = txtNhaXB.getText();
					int sotrang = Integer.parseInt(txtSoTrang.getText());
					double dongia = Double.parseDouble(txtDonGia.getText());
					String isbn = txtISBN.getText();
					Sach s = new Sach(ma,tua,tacgia,namXB,nhaXB,sotrang,dongia,isbn);
					if(!thuvien.themSach(s)) {
						JOptionPane.showMessageDialog(this,"Trung");
					}else {
						model.addRow(new Object[] {s.getMaSach(),s.getTuaSach(),s.getTacGia(),s.getNamXB(),s.getNhaXB(),s.getSoTrang(),s.getDonGia(),s.getIsbn()});
					}
				}
				
			}else if(o==btnXoaRong) {
				txtDonGia.setText("");
				txtISBN.setText("");
				txtMaSach.setText("");
				txtNamXB.setText("");
				txtNhaXB.setText("");
				txtSoTrang.setText("");
				txtTacGia.setText("");
				txtTuaSach.setText("");	
				txtMaSach.requestFocus();
			}else if(o==btnLuu) {
				DataBase.luuFile(thuvien.getDsSach());
				txtMess.setText("Luu thanh cong");
			}else if(o==btnSua) {
				String maSachOld = txtMaSach.getText().trim();
				if(validData()) {
					Sach sachNew = revertSachFromTextfields();
					if(thuvien.capNhatSach(maSachOld, sachNew)) {
						txtMess.setText("Cap nhat thanh cong");
						xoaHetDuLieuModel();
						docDuLieuTuListVaoModel();
					}else
						txtMess.setText("Cần chọn cuốn sách để cập nhật. ");
				}
			}else if(o==btnXoa) {
				int row= table.getSelectedRow();
				Sach sach = thuvien.geElementAt(row);
				if(JOptionPane.showConfirmDialog(this,"Ban co muon xoa cuon sach co ma la"+ sach.getMaSach()+ "khong?","Xac nhan",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					if(thuvien.xoa1CuonSach(row)) {
						xoaHetDuLieuModel();
						docDuLieuTuListVaoModel();
						capNhatCombobox();
						txtMess.setText("Xoa thanh cong");
					}else
						txtMess.setText("Da xay ra loi!");
				
				}else {
					txtMess.setText("Ban da huy xoa");
				}
			
				
			}else if(o==btnLoc){
				String tuaSach = JOptionPane.showInputDialog("Hay nhap tua sach");
				Sach s = thuvien.timTheoTua(tuaSach);
				xoaHetDuLieuModel();
				model.addRow(new Object[]{s.getMaSach(),s.getTuaSach(),s.getTacGia(),s.getNamXB(),s.getNhaXB(),s.getSoTrang(),s.getDonGia(),s.getIsbn()});
				
			}
			if(o==cboMaSach) {
				xoaHetDuLieuModel();
				 String selectedValue = cboMaSach.getSelectedItem().toString();
				 Sach s = thuvien.timKiem(selectedValue);
				 model.addRow(new Object[]{s.getMaSach(),s.getTuaSach(),s.getTacGia(),s.getNamXB(),s.getNhaXB(),s.getSoTrang(),s.getDonGia(),s.getIsbn()});
			}
				
}
				
			

		
		public void docDuLieuTuListVaoModel() {
			for(int i=0;i< thuvien.getSize();i++) {
				Sach s = thuvien.geElementAt(i);
				model.addRow(new Object[] {s.getMaSach(),s.getTuaSach(),s.getTacGia(),s.getNamXB(),s.getNhaXB(),s.getSoTrang(),s.getDonGia(),s.getIsbn()});
			}
		}
		
		private boolean validData() {
			String maSach = txtMaSach.getText().trim();
			String tuaSach = txtTuaSach.getText().trim();
			String tacGia = txtTacGia.getText().trim();
			String nam = txtNamXB.getText().trim();
			String gia = txtDonGia.getText().trim();
			String isbn = txtISBN.getText().trim();
			String soTrang = txtSoTrang.getText().trim();
			
		
			return true;
		}
		
		private Sach revertSachFromTextfields() {
			String maSach = txtMaSach.getText().trim();
			String tuaSach = txtTuaSach.getText().trim();
			String tacGia = txtTacGia.getText().trim();

			String nam = txtNamXB.getText().trim();
			int namXB = nam.length() == 0 ? 0 : Integer.parseInt(nam); //Để trống thì coi như là 0

			String nhaXB = txtNhaXB.getText().trim();

			String trang = txtSoTrang.getText().trim();
			int soTrang = trang.length() == 0 ? 0 : Integer.parseInt(trang);

			String gia = txtDonGia.getText().trim();
			double donGia = gia.equals("") ? 0 : Double.parseDouble(gia);

			String isbn = txtISBN.getText().trim();
			return new Sach(maSach, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, isbn);
		}
		
		public void xoaHetDuLieuModel() {
			DefaultTableModel dm = (DefaultTableModel)table.getModel();
			dm.getDataVector().removeAllElements();
		}
		
		public void capNhatCombobox() {
			for(int i=0;i< thuvien.getSize();i++) {
				Sach s = thuvien.geElementAt(i);
				cboMaSach.addItem(s.getMaSach());
			}
			
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row= table.getSelectedRow();
			if(row!=-1) {
				Sach sach = thuvien.geElementAt(row);
				txtDonGia.setText(String.valueOf(sach.getDonGia()) );
				txtISBN.setText(sach.getIsbn());
				txtMaSach.setText(sach.getMaSach());
				txtNamXB.setText(String.valueOf(sach.getNamXB()) );
				txtNhaXB.setText(sach.getNhaXB());
				txtSoTrang.setText(String.valueOf(sach.getSoTrang() ));
				txtTacGia.setText(sach.getTacGia());
				txtTuaSach.setText(sach.getTuaSach());	
				
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

}
