/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilgiler;

import java.util.Date;

/**
 *
 * @author sudeg
 */
public class HesapEks {
    
    public String musteri_tc;
    public String musteri_adi;
    public String musteri_soyadi;
    Date baslangic_tarihi;
    public int alacak;
    public int borc;
    public int total;
    public String tur;
    
    public String aciklama;
    
    
    
    public HesapEks(String musteri_tc,String musteri_adi,String musteri_soyadi,String tur, Date baslangic_tarihi, int alacak, int borc, int total,String aciklama){
        
        this.musteri_tc = musteri_tc;
        this.musteri_adi = musteri_adi;
        this.musteri_soyadi = musteri_soyadi;
        this.baslangic_tarihi = baslangic_tarihi;
        this.alacak = alacak;
        this.tur = tur;
        this.borc = borc;
        this.total = total;
        this.aciklama = aciklama;
        
    } 

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
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

    public Date getBaslangic_tarihi() {
        return baslangic_tarihi;
    }

    public void setBaslangic_tarihi(Date baslangic_tarihi) {
        this.baslangic_tarihi = baslangic_tarihi;
    }

    public int getAlacak() {
        return alacak;
    }

    public void setTop_arac_fiyati(int top_arac_fiyati) {
        this.alacak = top_arac_fiyati;
    }

    public int getBorc() {
        return borc;
    }

    public void setBorc(int borc) {
        this.borc = borc;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
    
    
    
    
    
    
    
}
