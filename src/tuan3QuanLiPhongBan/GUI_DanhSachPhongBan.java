package tuan3QuanLiPhongBan;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class GUI_DanhSachPhongBan extends JFrame implements MouseListener {
	private JTree tree;
	private DefaultMutableTreeNode root;
	private dsPhongBan dsPB;
	public GUI_DanhSachPhongBan() {
		super("Danh sach phong ban");
		setResizable(true);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,500);
		setLocationRelativeTo(null);
		
		root = new DefaultMutableTreeNode("Danh sach phong ban");
		tree = new JTree(root);
		this.add(tree);
		
		khoiTaoDanhSach();
		
		for(PhongBan x: dsPB.getDSPB()) {
			root.add(new DefaultMutableTreeNode(x));
		}
		
		for(int i=0 ; i< root.getChildCount(); i++) {
			PhongBan temp = (PhongBan) ((DefaultMutableTreeNode)(root.getChildAt(i))).getUserObject();
		    dsNhanVien dsTemp = temp.getDsNV();
		    for(int j = 0; j < dsTemp.getSize(); j++) {
		        NhanVien x = dsTemp.getElementAt(j);
		        ((DefaultMutableTreeNode)(root.getChildAt(i))).add(new DefaultMutableTreeNode(x));   
		    }
		}
		
		for(int i=0; i<dsPB.getSize();i++) {
			TreeNode root = (TreeNode) tree.getModel().getRoot();
			TreeNode node = root.getChildAt(i);
			if (node != null) {
			    TreePath path = new TreePath(((DefaultTreeModel) tree.getModel()).getPathToRoot(node));
			    tree.expandPath(path);
			}
		}
		tree.addMouseListener(this);
		
		
		
	}
	
	
	
	public void khoiTaoDanhSach() {
		dsPB = new dsPhongBan();
		PhongBan pb1 = new PhongBan("001","Phong to chuc");
		PhongBan pb2 = new PhongBan("002","Phong ki thuat");
		dsPB.themPhongBan(pb1);
		dsPB.themPhongBan(pb2);
		
		try {
			NhanVien nv1 = new NhanVien("0001","001","Tran","Khanh",true,20,10000000);
			NhanVien nv2 = new NhanVien("0002","001","Pham","Van",false,20,11000000);
			NhanVien nv3 = new NhanVien("0003","001","Quoc","Anh",true,20,1300000);
			NhanVien nv4 = new NhanVien("0004","002","Thuy","Mai",false,20,10000000);
			NhanVien nv5 = new NhanVien("0005","002","Van","Anh",false,20,11000000);
			NhanVien nv6 = new NhanVien("0006","002","Vo","Vinh",true,20,12000000);
			
			pb1.getDsNV().themNhanVien(nv1);
			pb1.getDsNV().themNhanVien(nv2);
			pb1.getDsNV().themNhanVien(nv3);
			pb2.getDsNV().themNhanVien(nv4);
			pb2.getDsNV().themNhanVien(nv5);
			pb2.getDsNV().themNhanVien(nv6);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		new GUI_DanhSachPhongBan().setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = tree.getSelectionPath().getLastPathComponent();
		DefaultMutableTreeNode dmt = (DefaultMutableTreeNode) obj;
		if(e.getClickCount()==2) {
			if(dmt.getLevel()==1) {
				new GUI_DSNhanVien((PhongBan) ((DefaultMutableTreeNode)obj).getUserObject()).setVisible(true);
			}
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
