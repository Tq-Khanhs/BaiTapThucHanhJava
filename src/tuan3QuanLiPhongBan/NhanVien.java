package tuan3QuanLiPhongBan;

import java.util.Objects;

public class NhanVien {
	private String maNV,hoNV,tenNV,maPB;
	private boolean phai;
	private int tuoi;
	private double luong;
	
	public NhanVien(String maNV,String maPB, String hoNV, String tenNV,  boolean phai, int tuoi, double luong) {
		super();
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.maPB = maPB;
		this.phai = phai;
		this.tuoi = tuoi;
		this.luong = luong;
	}

	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
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

	public String getMaPB() {
		return maPB;
	}

	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}

	public boolean isPhai() {
		return phai;
	}

	public void setPhai(boolean phai) {
		this.phai = phai;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}
	
	@Override
	public String toString() {
		String s = String.format("%s %s",hoNV,tenNV);
		return s;
	}
	
	
	
	

}
