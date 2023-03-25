package tuan3QuanLiPhongBan;

import java.util.ArrayList;

public class dsNhanVien {
	private ArrayList<NhanVien> dsNV;

	public dsNhanVien() {
		dsNV = new ArrayList<NhanVien>();
	}
	
	public boolean themNhanVien(NhanVien nv) {
		if(dsNV.contains(nv)) 
			return false;
		else {
			dsNV.add(nv);
			return true;
		}
	}
	
	public boolean xoaNhanVien(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(dsNV.contains(nv)) {
			dsNV.remove(nv);
			return true;
		}
		return false;
	}
	
	public NhanVien timKiem(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(dsNV.contains(nv)) {
			return dsNV.get(dsNV.indexOf(nv));
		}
		return null;
	}
	
	public ArrayList<NhanVien> getDSNV(){
		return dsNV;
	}
	
	
	public void setDSNV(ArrayList<NhanVien> ds) {
		this.dsNV = ds;
	}
	
	public NhanVien getElementAt(int index) {
		if(index<0 || index >= dsNV.size())
			return null;
		else
			return dsNV.get(index);
			
	}
	
	public int getSize() {
		return dsNV.size();
	}
	
	

}
