package com.example.myapplication;

public class ListNhac {
    private String ten;
    private String hinh;
    private String idvideo;


    public ListNhac(String ten, String hinh, String idvideo) {
        this.ten = ten;
        this.hinh = hinh;
        this.idvideo = idvideo;

    }


    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getIdvideo() {
        return idvideo;
    }

    public void setIdvideo(String idvideo) {
        this.idvideo = idvideo;
    }
}
