
package bilgiler;

import java.util.Date;


public class KiralananAracBilgileri  {
    
    public String plaka;
    public String marka;
    public String tipi;
    public String vites;
    public String musteri_tc;
    public String musteri_adi;
    public String musteri_soyadi;
    public String tel_no;
    
    
    
    
    
    Date baslangic_tarihi;
    Date bitis_tarihi;
    
    
    
    
    public int son_km;
    public int arac_fiyati;
    public String kur;
    
    
    String baslangic_saati;
    
    
    String bitis_saati ;
   
    
    public KiralananAracBilgileri(String plaka, String marka, String tipi,String vites,String musteri_tc,String musteri_adi,String musteri_soyadi,String tel_no,
        Date baslangic_tarihi,String baslangic_saati,
        Date bitis_tarihi,String bitis_saati,int son_km,int arac_fiyati,String kur){
        
        this.plaka = plaka;
        this.marka = marka;
        this.tipi = tipi;
        this.vites = vites;
        this.musteri_tc = musteri_tc;
        this.musteri_adi = musteri_adi;
        this.musteri_soyadi = musteri_soyadi;
        this.tel_no = tel_no;
        this.baslangic_tarihi = baslangic_tarihi;
        this.baslangic_saati = baslangic_saati;
        this.bitis_tarihi = bitis_tarihi;
        this.bitis_saati = bitis_saati;
        this.son_km = son_km;
        this.arac_fiyati=arac_fiyati;
        this.kur= kur;
        
    }

    public String getVites() {
        return vites;
    }

    public void setVites(String vites) {
        this.vites = vites;
    }

    public String getMusteri_tc() {
        return musteri_tc;
    }

    public void setMusteri_tc(String musteri_tc) {
        this.musteri_tc = musteri_tc;
    }

    public String getMusteri_adi() {
        return musteri_adi;
    }

    public void setMusteri_adi(String musteri_adi) {
        this.musteri_adi = musteri_adi;
    }

    public String getMusteri_soyadi() {
        return musteri_soyadi;
    }

    public void setMusteri_soyadi(String musteri_soyadi) {
        this.musteri_soyadi = musteri_soyadi;
    }

    public int getSon_km() {
        return son_km;
    }

    public void setSon_km(int son_km) {
        this.son_km = son_km;
    }

    public int getArac_fiyati() {
        return arac_fiyati;
    }

    public void setArac_fiyati(int arac_fiyati) {
        this.arac_fiyati = arac_fiyati;
    }

    public String getKur() {
        return kur;
    }

    public void setKur(String kur) {
        this.kur = kur;
    }


    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public  Date getBaslangic_tarihi() {
        return baslangic_tarihi;
    }

    public void setBaslangic_tarihi(Date baslangic_tarihi) {
        this.baslangic_tarihi = baslangic_tarihi;
    }

    public String getBaslangic_saati() {
        return baslangic_saati;
    }

    public void setBaslangic_saati(String baslangic_saati) {
        this.baslangic_saati = baslangic_saati;
    }

    public  Date getBitis_tarihi() {
        return bitis_tarihi;
    }

    public void setBitis_tarihi(Date bitis_tarihi) {
        this.bitis_tarihi = bitis_tarihi;
    }

    public String getBitis_saati() {
        return bitis_saati;
    }

    public void setBitis_saati(String bitis_saati) {
        this.bitis_saati = bitis_saati;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTipi() {
        return tipi;
    }

    public void setTipi(String tipi) {
        this.tipi = tipi;
    }
    
    
    
    
    
}
