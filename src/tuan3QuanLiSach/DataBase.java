package tuan3QuanLiSach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DataBase {
	private static final String FILENAME = "data/sach.txt";
	public static void luuFile(ArrayList<Sach> dsSach) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(FILENAME));
			bw.write("MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN\n");
			for(Sach s: dsSach) {
				bw.write(s.toString()+"\n");
			}
			bw.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static ArrayList<Sach> docTuFile() {
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		BufferedReader br = null;
		try{
			if(new File(FILENAME).exists()){
				br  = new BufferedReader(new FileReader(FILENAME));
				br.readLine();
				while(br.ready()){
					String line = br.readLine();
					if(line != null && !line.trim().equals("")){
						String[] a = line.split(";");
						Sach s = new Sach(a[0], a[1], a[2],
								Integer.parseInt(a[3]), 
								a[4], Integer.parseInt(a[5]),
								Double.parseDouble(a[6]), a[7]);
						dsSach.add(s);
					}
				}
				br.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return dsSach;
	}
 
}
