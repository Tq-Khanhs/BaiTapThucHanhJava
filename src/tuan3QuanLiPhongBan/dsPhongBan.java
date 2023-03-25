package tuan3QuanLiPhongBan;

import java.util.ArrayList;

public class dsPhongBan {
	private ArrayList<PhongBan> dsPB;

	public dsPhongBan() {
		super();
		dsPB = new ArrayList<PhongBan>();
	}
	
	public boolean themPhongBan(PhongBan pb) {
		if(dsPB.contains(pb))
			return false;
		dsPB.add(pb);
		return true;
	}
	
	public boolean xoaPhongBan(String maPB) {
		PhongBan pb = new PhongBan(maPB);
		if(dsPB.contains(pb)) {
			dsPB.remove(pb);
			return true;
		}
		return false;
	}
	
	public PhongBan timKiemPB(String maPB) {
		PhongBan pb = new PhongBan(maPB);
		if(dsPB.contains(pb)) {
			return dsPB.get(dsPB.indexOf(pb));
		}
		return null;
	}
	
	
	public PhongBan getPBAt(int index) {
		if(index <0 || index >= dsPB.size())
			return null;
		return dsPB.get(index);
	}
	
	public ArrayList<PhongBan> getDSPB(){
		return dsPB;
	}
	
	public  int getSize() {
		return dsPB.size();
	}
	
	

}
