package tuan2ThongTinNhanVien;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Objects;

public class NhanVien{
	private static final long serialVersionUID =1L;
	private String maNV;
	private String hoNV;
	private String tenNV;
	private int tuoi;
	private boolean phai;
	private double luong;
	
	public NhanVien(String maNV) {
		this.maNV = maNV;
	}
	
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String maNV, String hoNV, String tenNV, boolean phai, int tuoi, double luong) {
		super();
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.tuoi = tuoi;
		this.phai = phai;
		this.luong = luong;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		if(maNV.equals("")||maNV==null)
		    new InputMismatchException("Khong duoc de ma trong");
		this.maNV = maNV;
		
	}

	public String getHoNV() {
		return hoNV;
	}

	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public boolean isPhai() {
		return phai;
	}

	public void setPhai(boolean phai) {
		this.phai = phai;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if(this == o  ) return true;
		if(o==null || getClass() != o.getClass()) return false;  
		NhanVien e = (NhanVien) o;
		return Objects.equals(maNV, e.maNV);	
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(maNV);
	}
	@Override
	public String toString() {
		String s = String.format("%s;%s;%s;%s;%d;%f", maNV,hoNV,tenNV,phai,tuoi,luong);
		return s;
	}

}
