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
public class PersonelBilgileri {
    
    int id;
    String ad;
    String soyad;
    String nick;
    String sifre;
    String yetki;
    
    public PersonelBilgileri(int id, String ad,String soyad,String nick,String sifre,String yetki){
        
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.nick = nick ;
        this.sifre = sifre;
        this.yetki = yetki;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getYetki() {
        return yetki;
    }

    public void setYetki(String yetki) {
        this.yetki = yetki;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
    
    
}
