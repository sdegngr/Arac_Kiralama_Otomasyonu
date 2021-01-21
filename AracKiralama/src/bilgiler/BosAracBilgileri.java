
package bilgiler;

/**
 *
 * @author sudeg
 */
public class BosAracBilgileri {
    
    public String plaka;
    public String marka;
    public String tip;
    public String vites;
    public String yakit_turu;
    public int son_km;
    
    
    
    public BosAracBilgileri(String plaka,String marka,String tip,String vites,int son_km,
                            String yakit_turu){
        
        this.plaka = plaka;
        this.marka = marka;
        this.tip = tip;
        this.vites = vites;
        this.yakit_turu = yakit_turu;
        this.son_km = son_km;
        
        
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
        return tip;
    }

    public void setTipi(String tipi) {
        this.tip = tipi;
    }

    public String getVites() {
        return vites;
    }

    public void setVites(String vites) {
        this.vites = vites;
    }

    public String getYakit_turu() {
        return yakit_turu;
    }

    public void setYakit_turu(String yakit_turu) {
        this.yakit_turu = yakit_turu;
    }

    public int getSon_km() {
        return son_km;
    }

    public void setSon_km(int son_km) {
        this.son_km = son_km;
    }
    
    
    
    
    
}
