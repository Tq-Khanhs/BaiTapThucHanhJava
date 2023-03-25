package tuan3QuanLiPhongBan;

import java.util.Objects;

public class PhongBan {
	private String tenPB, maPB;
	private dsNhanVien dsNV;
	
	public PhongBan(String maPB,String tenPB) {
		super();
		this.tenPB = tenPB;
		this.maPB = maPB;
		dsNV = new dsNhanVien();
	}

	public PhongBan() {
		super();
		// TODO Auto-generated constructor stub
		dsNV = new dsNhanVien();
	}

	public PhongBan(String maPB) {
		super();
		this.maPB = maPB;
		dsNV = new dsNhanVien();
	}

	public String getTenPB() {
		return tenPB;
	}

	public void setTenPB(String tenPB) {
		this.tenPB = tenPB;
	}

	public String getMaPB() {
		return maPB;
	}

	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}

	public dsNhanVien getDsNV() {
		return dsNV;
	}

	public void setDsNV(dsNhanVien dsNV) {
		this.dsNV = dsNV;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPB);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongBan other = (PhongBan) obj;
		if(maPB==null) {
			if(other.maPB!=null)
				return false;
		}else if(!maPB.equals(other.maPB))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return tenPB;
	}
	
	
	
	
	
	
	
	
	
	
	

}
