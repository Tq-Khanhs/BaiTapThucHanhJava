package tuan2ThongTinNhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GUIThongTinNhanVien extends JFrame implements ActionListener,MouseListener{
	private JTextField txtMNV,txtHo,txtTen,txtTuoi,txtLuong,txtTim;
	private Box b;
	private JLabel lblMNV,lblHo,lblTuoi,lblLuong;
	private JPanel pnCenter;
	private JButton btnTim,btnThem,btnXoaTrang,btnXoa,btnLuu;
	private DSNhanVien listNV;
	private JPanel pnTable= new JPanel();
	private DefaultTableModel model = new DefaultTableModel();
	private JTable table = new JTable(model);
	private JRadioButton radNam;
	private JRadioButton radNu;
	private int flag;
	
	public GUIThongTinNhanVien() {
		super("^-^");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(700,600);
		createGUI();
	}
	
	public void createGUI() {
		JPanel pnBorder;
		pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		JPanel pnNorth;
		JLabel lblTieuDe = new JLabel("THONG TIN NHAN VIEN");
		lblTieuDe.setForeground(Color.BLUE);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		pnBorder.add(pnNorth = new JPanel(),BorderLayout.NORTH);
		pnNorth.add(lblTieuDe);
		
		pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter,BoxLayout.X_AXIS));
		Box b1,b2,b3,b4;
		b =  Box.createVerticalBox();
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b4 = Box.createHorizontalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		pnCenter.add(b);
		pnCenter.add(Box.createVerticalStrut(10));
		
		lblMNV = new JLabel("Ma Nhan Vien: ");
		txtMNV = new JTextField();
		b1.add(lblMNV);
		b1.add(txtMNV);
		
		lblHo = new JLabel("Ho:");
		txtHo = new JTextField();
		txtTen = new JTextField();
		b2.add(lblHo);
		lblHo.setPreferredSize(lblMNV.getPreferredSize());
		b2.add(txtHo);
		b2.add(new JLabel("Ten Nhan Vien: "));
		b2.add(txtTen);
		
		lblTuoi = new JLabel("Tuoi: ");
		txtTuoi = new JTextField();
		radNam = new JRadioButton("Nam",true);
		radNu = new JRadioButton("Nu");
	    ButtonGroup group = new ButtonGroup();
	    group.add(radNu);
	    group.add(radNam);
	    b3.add(lblTuoi);
	    lblTuoi.setPreferredSize(lblMNV.getPreferredSize());
	    b3.add(txtTuoi);
	    b3.add(new JLabel("Phai"));
	    b3.add(radNam);
	    b3.add(radNu);
	    
	    lblLuong = new JLabel("Luong: ");
	    txtLuong = new JTextField();
	    b4.add(lblLuong);
	    lblLuong.setPreferredSize(lblMNV.getPreferredSize());
	    b4.add(txtLuong);
 
	    taoBang();
 
		pnBorder.add(pnCenter,BorderLayout.CENTER);
		JSplitPane split;
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		pnBorder.add(split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPanel,rightPanel),BorderLayout.SOUTH);
		split.setResizeWeight(0.5);
		leftPanel.add(new JLabel("Nhap ma so can tim"));
		leftPanel.add(txtTim= new JTextField(10));
		leftPanel.add(btnTim = new JButton("Tim"));
		rightPanel.add(btnThem = new JButton("Them"));
		rightPanel.add(btnXoaTrang = new JButton("Xoa Trang"));
		rightPanel.add(btnXoa = new JButton("Xoa"));
		rightPanel.add(btnLuu = new JButton("Luu"));
		
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		radNam.addActionListener(this);
		radNu.addActionListener(this);
		table.addMouseListener(this);
		
		
		
		this.add(pnBorder);
		listNV = new DSNhanVien();
	    listNV.napDuLieuTuFile();

//	    
//	    listNV.themNhanVien(nv1);
//	    listNV.themNhanVien(nv2);
//	    listNV.themNhanVien(nv3);
//	    listNV.themNhanVien(nv4);
	    
	    docDuLieuTuListVaoModel();
	}
	
	public static void main(String[] args) {
		new GUIThongTinNhanVien().setVisible(true);
	}
	
	public void taoBang()
	{
		model.addColumn("Ma NV");
		model.addColumn("Ho");
		model.addColumn("Ten");
		model.addColumn("Phai");
		model.addColumn("Tuoi");
		model.addColumn("Tien Luong");
	    TableColumn phaicolumn = table.getColumnModel().getColumn(3);
	    JComboBox comboBox = new JComboBox();
	    comboBox.addItem("Nam");
	    comboBox.addItem("Nu");
	    phaicolumn.setCellEditor(new DefaultCellEditor(comboBox));
	    JScrollPane scrollPane = new JScrollPane(table);
	    TableColumn column = new TableColumn();
	     for (int i = 0; i < table.getColumnCount(); i++) {
	            column = table.getColumnModel().getColumn(i);
	            column.setPreferredWidth(120);
	        }    
	    table.setPreferredScrollableViewportSize(new Dimension(691,330));;
	        
	    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	    rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
	    DefaultTableCellRenderer xenter = new DefaultTableCellRenderer();
	    xenter.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
	    table.getColumnModel().getColumn(0).setCellRenderer(xenter);
	    table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
	    table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
	    table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
	    
	    pnTable.add(scrollPane);
	    b.add(pnTable);
	    
	    
	    
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o =e.getSource();
		if(o.equals(btnThem))
		{
		    if(txtMNV.getText().equals("")||txtHo.getText().equals("")||txtTen.getText().equals("")||txtTuoi.getText().equals("")||txtLuong.getText().equals("")){
		    	JOptionPane.showMessageDialog(this, "Hay nhap day du thong tin");
			}
		    else {
		    	String ma = txtMNV.getText();
				   String ho = txtHo.getText();
				   String ten = txtTen.getText();
				   int tuoi = Integer.parseInt(txtTuoi.getText());
				   boolean phai = true;
				   if(radNu.isSelected()) {
					   phai = false;
				   }
				   double luong = Double.parseDouble(txtLuong.getText());
				   NhanVien nv = new NhanVien(ma,ho,ten,phai,tuoi,luong);
				   if(! listNV.themNhanVien(nv))
					   JOptionPane.showMessageDialog(this,"Trung");
				   else {
					   model.addRow(new Object[] {nv.getMaNV(),nv.getHoNV(),nv.getTenNV(),kiemTraGT(nv),nv.getTuoi(),nv.getLuong()});
				   } 
		    }
		   
		}else if(o.equals(btnXoa)) {
			deleteRowSelected();
			
			
			
			
			
			
		}else if(o.equals(btnXoaTrang)) {
			txtMNV.setText("");
			txtHo.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
			txtLuong.setText("");
			txtMNV.requestFocus();
		}else if(o.equals(btnTim)) {
			searchMatchData();
		}else if(o.equals(btnLuu)) {
		       StoreData l = new StoreData();
		       try {
		    	   l.luuFile(listNV.getDsNV()); 	
		    	   JOptionPane.showMessageDialog(this, "Ban da luu thanh cong");
		       }catch(Exception ee) {
		    	   ee.printStackTrace();
		       }
		}
		
		
		
	}
	
	private void deleteRowSelected() {
		String listMNV="";
		String maNV="";
		
		if(table.getSelectedRowCount() == 0)
			JOptionPane.showMessageDialog(this, "Ban Hay chon dong can xoa");
		else {
			int[] listIndex= table.getSelectedRows();
			listMNV += table.getValueAt(listIndex[0], 0);
			
			for(int i=1 ; i< table.getSelectedRowCount();i++) {
				listMNV += ", " + table.getValueAt(listIndex[i], 0);
			}
			if(JOptionPane.showConfirmDialog(this,"Ban co chac chan muon xoa nhan vien "+listMNV +"?","Thong tin",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {
				try {
					for(int i=0 ; i<table.getSelectedRowCount();i++) {
						maNV = (String) table.getValueAt(listIndex[i], 0);
						if(listNV.xoaNhanVien(maNV)==false) {
							JOptionPane.showMessageDialog(this,"Xoa that bai. Da xay ra loi trong qua trinh hien thuc!");
							table.clearSelection();
						}
					}
					xoaHetDuLieuModel();
					docDuLieuTuListVaoModel();
				}catch(Exception e) {
					xoaHetDuLieuModel();
					docDuLieuTuListVaoModel();
					JOptionPane.showMessageDialog(this, "Xoa that bai. Da xay ra loi trong qua trinh hien thuc!");
					System.out.println(e);
				}
			}
			
			
		}
	}
	
	
	private void searchMatchData() {
		DSNhanVien nvList;
		this.flag =1;
		String x = txtTim.getText();
		xoaHetDuLieuModel();
		if(x.isEmpty() || x.trim() == "") {
			docDuLieuTuListVaoModel();
			return;
		}
		try {
			nvList = findNhanVien(x);
			if(nvList == null)
			   return;
			docDuLieuTuListVaoModel2(nvList); 
		}catch(Exception e){
			
		}
	}
	
	private void timTheoMaNV() {
		String str = txtTim.getText();
		if(str !=null && str.trim().length()>0) {
			try {
				NhanVien nv = listNV.timKiem(str);
				if(nv!=null) {
					xoaHetDuLieuModel();
					model.addRow(new Object[] {nv.getMaNV(),nv.getHoNV(),nv.getTenNV(),kiemTraGT(nv),nv.getTuoi(),nv.getLuong()});
				}else {
					JOptionPane.showMessageDialog(null, "Khong tim thay");
					return;
				}
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Du lieu khong hop le");
				txtTim.selectAll();
				txtTim.requestFocus();
			}
		}else {
			xoaHetDuLieuModel();
			docDuLieuTuListVaoModel();
			table.setModel(model);
		}
		
	}
	
	public void xoaHetDuLieuModel() {
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	public void docDuLieuTuListVaoModel() {
		for(int i=0; i< listNV.getSize();i++) {
			NhanVien nv= listNV.getElement(i);
			model.addRow(new Object[] {nv.getMaNV(),nv.getHoNV(),nv.getTenNV(),kiemTraGT(nv),nv.getTuoi(),nv.getLuong()});
			
		}
	}
	
	public void docDuLieuTuListVaoModel2(DSNhanVien x) {
		for(int i=0; i< x.getSize();i++) {
			NhanVien nv= x.getElement(i);
			model.addRow(new Object[] {nv.getMaNV(),nv.getHoNV(),nv.getTenNV(),kiemTraGT(nv),nv.getTuoi(),nv.getLuong()});
			
		}
	}
	
	public String kiemTraGT(NhanVien nv) {
		String phai;
		if(nv.isPhai()==true)
			return phai = "Nam";
		return phai = "Nu";
	}
	
	public DSNhanVien findNhanVien(String x) {
		DSNhanVien temp = new DSNhanVien();
		int endPos = x.length();
		for(int i=0; i< listNV.getSize();i++) {
			if(x.equals(listNV.getElement(i).getMaNV().substring(0, endPos))) {
				temp.themNhanVien(listNV.getElement(i));
			}
		}
		return temp;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row= table.getSelectedRow();
		if(row!= -1) {
		NhanVien nv = listNV.getElement(row);
		txtMNV.setText(nv.getMaNV());
		txtHo.setText(nv.getHoNV());
		txtTen.setText(nv.getTenNV());
		txtTuoi.setText(String.valueOf(nv.getTuoi()));
		txtLuong.setText(String.valueOf(nv.getLuong()));
	    if(nv.isPhai()== true)
	    	radNam.setSelected(true);
	    else
	    	radNu.setSelected(true);
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
