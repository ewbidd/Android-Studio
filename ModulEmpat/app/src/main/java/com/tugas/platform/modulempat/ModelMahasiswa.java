package com.tugas.platform.modulempat;

public class ModelMahasiswa {
    private int mImg;
    private String nama, nim;

    public int getmImg() {
        return mImg;
    }

    public void setmImg(int mImg) {
        this.mImg = mImg;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public ModelMahasiswa(int img, String nama, String nim) {
        this.mImg = img;
        this.nama = nama;
        this.nim = nim;
    }
}
