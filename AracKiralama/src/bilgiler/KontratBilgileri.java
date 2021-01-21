/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilgiler;


/**
 *
 * @author sudeg
 */
public class KontratBilgileri extends KiralananAracBilgileri {
    
    int donus_km ;   //donusten sonraki son km
    String teslim_eden ;
    
    double kdv_bedeli;
    int odenen_toplam_miktar ;
    int kiralanan_gun_sayisi ;
    
    public KontratBilgileri(String plaka, String marka, String tipi,String vites,int donus_km,int son_km,int arac_fiyati,String kur,int odenen_toplam_miktar,
            double kdv_bedeli,
    int kiralanan_gun_sayisi,String musteri_tc,String musteri_adi,String musteri_soyadi,String teslim_eden,String tel_no,java.sql.Date baslangic_tarihi,String baslangic_saati,
    java.sql.Date bitis_tarihi,String bitis_saati){
        
        
        super(plaka,marka,tipi,vites,musteri_tc,musteri_adi,musteri_soyadi,tel_no,baslangic_tarihi,baslangic_saati,bitis_tarihi,bitis_saati,
                son_km,arac_fiyati,kur);
        
        this.donus_km=donus_km;
        this.teslim_eden = teslim_eden;
        this.kdv_bedeli=kdv_bedeli;
        this.odenen_toplam_miktar=odenen_toplam_miktar;
        this.kiralanan_gun_sayisi=kiralanan_gun_sayisi;
        
        
    }

    public int getDonus_km() {
        return donus_km;
    }

    public void setDonus_km(int donus_km) {
        this.donus_km = donus_km;
    }

    public String getTeslim_eden() {
        return teslim_eden;
    }

    public void setTeslim_eden(String teslim_eden) {
        this.teslim_eden = teslim_eden;
    }

    public double getKdv_bedeli() {
        return kdv_bedeli;
    }

    public void setKdv_bedeli(double kdv_bedeli) {
        this.kdv_bedeli = kdv_bedeli;
    }

    public int getOdenen_toplam_miktar() {
        return odenen_toplam_miktar;
    }

    public void setOdenen_toplam_miktar(int odenen_toplam_miktar) {
        this.odenen_toplam_miktar = odenen_toplam_miktar;
    }

    public int getKiralanan_gun_sayisi() {
        return kiralanan_gun_sayisi;
    }

    public void setKiralanan_gun_sayisi(int kiralanan_gun_sayisi) {
        this.kiralanan_gun_sayisi = kiralanan_gun_sayisi;
    }
    
    
}
