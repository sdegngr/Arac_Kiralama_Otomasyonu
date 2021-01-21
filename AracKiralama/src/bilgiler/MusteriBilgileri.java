package bilgiler;

public class MusteriBilgileri {
    
    public String tc;
    public String ad;
    public String soyad;
    public String tel_no;
    public String mail;
    public int bakiye;
    public String adres;
    public String sehir;
    
    
    public MusteriBilgileri(String tc,String ad,String soyad,String tel_no, String mail,int bakiye,String adres,String sehir){
    
        this.tc = tc;
        this.ad = ad;
        this.soyad = soyad;
        this.tel_no = tel_no;
        this.mail = mail;
        this.bakiye = bakiye; 
        this.adres = adres;
        this.sehir = sehir;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
    
    
    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
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

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getBakiye() {
        return bakiye;
    }

    public void setBakiye(int bakiye) {
        this.bakiye = bakiye;
    }
    
    
    
}
