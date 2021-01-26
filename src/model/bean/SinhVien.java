package model.bean;

public class SinhVien {
private int maSV;
private String hoTen;
private boolean gioiTinh;
private String Khoa;
public int getMaSV() {
	return maSV;
}
public void setMaSV(int maSV) {
	this.maSV = maSV;
}
public boolean isGioiTinh() {
	return gioiTinh;
}
public void setGioiTinhb(boolean gioiTinh) {
	this.gioiTinh = gioiTinh;
}
public String getHoTen() {
	return hoTen;
}
public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}
public String getKhoa() {
	return Khoa;
}
public void setKhoa(String khoa) {
	Khoa = khoa;
}
public String getGioiTinh(boolean gioiTinh)
{
	return gioiTinh?"Nam":"Nu";
}
public void setGioiTinhs(String gioiTinh) {
	this.gioiTinh = (gioiTinh.equalsIgnoreCase("Nam"))?true:false;
}
}
