package bilgiler;

import java.util.Date;

public class ButunAracBilgileri {
    
    public String plaka;
    public int model;
    public String marka;
    public String tipi;
    public String vites;
    public int son_km;
    public String yakit_turu;
    public String sasi_no;
    public String motor_no;
    public String ruhsat_belge_no;
    Date muayene ;
    Date sigorta ;
    Date kasko ;
    Date filo_giris_tarihi ;
 
    
    public ButunAracBilgileri(String plaka,String marka,String tipi){
        
        this.plaka = plaka;
        
        this.marka = marka;
        this.tipi = tipi;
        
        
    } 
    
    public ButunAracBilgileri(String plaka,String marka,String tipi,int model,String vites,int son_km,
    String yakit_turu, String sasi_no, String motor_no,String ruhsat_belge_no,
    Date muayene,Date sigorta,
    Date kasko, Date filo_giris_tarihi){
        
        this.plaka = plaka;
        
        this.marka = marka;
        this.tipi = tipi;
        
        this.model = model;
        this.vites = vites;
        this.son_km = son_km;
        this.yakit_turu = yakit_turu;
        this.sasi_no = sasi_no;
        this.motor_no = motor_no;
        this.ruhsat_belge_no = ruhsat_belge_no;
        this.muayene = muayene;
        this.sigorta = sigorta;
        this.kasko = kasko;
        this.filo_giris_tarihi = filo_giris_tarihi;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
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

    public String getVites() {
        return vites;
    }

    public void setVites(String vites) {
        this.vites = vites;
    }

    public int getSon_km() {
        return son_km;
    }

    public void setSon_km(int son_km) {
        this.son_km = son_km;
    }

    public String getYakit_turu() {
        return yakit_turu;
    }

    public void setYakit_turu(String yakit_turu) {
        this.yakit_turu = yakit_turu;
    }

    public String getSasi_no() {
        return sasi_no;
    }

    public void setSasi_no(String sasi_no) {
        this.sasi_no = sasi_no;
    }

    public String getMotor_no() {
        return motor_no;
    }

    public void setMotor_no(String motor_no) {
        this.motor_no = motor_no;
    }

    public String getRuhsat_belge_no() {
        return ruhsat_belge_no;
    }

    public void setRuhsat_belge_no(String ruhsat_belge_no) {
        this.ruhsat_belge_no = ruhsat_belge_no;
    }

    public Date getMuayene() {
        return muayene;
    }

    public void setMuayene(Date muayene) {
        this.muayene = muayene;
    }

    public Date getSigorta() {
        return sigorta;
    }

    public void setSigorta(Date sigorta) {
        this.sigorta = sigorta;
    }

    public Date getKasko() {
        return kasko;
    }

    public void setKasko(Date kasko) {
        this.kasko = kasko;
    }

    public Date getFilo_giris_tarihi() {
        return filo_giris_tarihi;
    }

    public void setFilo_giris_tarihi(Date filo_giris_tarihi) {
        this.filo_giris_tarihi = filo_giris_tarihi;
    }

    
}
