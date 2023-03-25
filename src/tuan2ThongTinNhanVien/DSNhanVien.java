package tuan2ThongTinNhanVien;

import java.io.Serializable;
import java.util.ArrayList;

public class DSNhanVien{
	private ArrayList<NhanVien> dsNV;

	public DSNhanVien() {
		dsNV = new ArrayList<NhanVien>(10);
	}
	
	public void napDuLieuTuFile() {
		this.dsNV = StoreData.docFile();	
	}
	
	public DSNhanVien(ArrayList<NhanVien> dsNV) {
		this.dsNV = dsNV;
		
	}
	
	public boolean themNhanVien(NhanVien nv)
	{
		if(dsNV.contains(nv))
			return false;
		dsNV.add(nv);
		return true;
	}
	
	public boolean xoaNhanVien(String maNV)
	{
		NhanVien nv= new NhanVien(maNV);
		if(dsNV.contains(nv)) {
			dsNV.remove(nv);
			return true;
		}
	    return false;
	    
	}
	
	public NhanVien timKiem(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(dsNV.contains(nv))
			return dsNV.get(dsNV.indexOf(nv));
		return null;
	}
	
	public ArrayList<NhanVien> getDsNV(){
		return dsNV;
	}
	
	public void setDsNV(ArrayList<NhanVien> dsNV) {
		this.dsNV = dsNV;
	}
	
	public NhanVien getElement(int index) {
		if(index <0 || index >= dsNV.size())
			return null;
		else 
			return dsNV.get(index);
		
	}
	
	public int getSize() {
		return dsNV.size();
	}

}
