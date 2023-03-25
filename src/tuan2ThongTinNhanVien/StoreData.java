package tuan2ThongTinNhanVien;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class StoreData {
//	public boolean luuFile(Object obj,String filePath) throws IOException,IOException{
//		ObjectOutputStream oos =null;
//		oos = new ObjectOutputStream(new FileOutputStream(filePath));
//		oos.writeObject(obj);
//		oos.flush();
//		oos.close();
//		return true;
//	}
//	
//	public Object docFile(String filePath) throws Exception{
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
//		Object o = ois.readObject();
//		ois.close();
//		return o;
//		
//	}
	public static final String fileName="data/NhanVien.txt";
	public static void luuFile(ArrayList<NhanVien> dsNV) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(fileName));
			bw.write("MaNV;Ho;Ten;Phai;Tuoi;TienLuong\n");
			for(NhanVien s: dsNV) {
				bw.write(s.toString()+"\n");
				bw.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public  static ArrayList<NhanVien> docFile() {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		BufferedReader br = null;
		try {
			if(new File(fileName).exists()) {
				br = new BufferedReader(new FileReader(fileName));
				br.readLine();
				while(br.ready()) {
					String line = br.readLine();
					if(line!=null && !line.trim().equals("")) {
						String[] a = line.split(";");
						NhanVien nv = new NhanVien(a[0],a[1],a[2],Boolean.parseBoolean(a[3]),Integer.parseInt(a[4]),Double.parseDouble(a[5]));
						ds.add(nv);
						
					}
					
				}
				br.close();
				}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		return ds;
	}

}
