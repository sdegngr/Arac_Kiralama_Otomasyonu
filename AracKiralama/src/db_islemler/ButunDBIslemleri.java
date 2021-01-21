
package db_islemler;
import bilgiler.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ButunDBIslemleri extends Db_Baglanti {
    Statement stmt = null;
    
    
    //Veritabanına yeni araç ekleme fonksiyonu
    public void arac_ekle(String plaka,int model,String marka,String tipi,String vites,int son_km,
    String yakit_turu, String sasi_no, String motor_no,String ruhsat_belge_no,
    java.sql.Date muayene_tarihi,java.sql.Date sigorta_tarihi,java.sql.Date kasko_tarihi,
    java.sql.Date filo_giris_tarihi){
        
        String query = "INSERT INTO BUTUN_ARAC_BILGILERI VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            preparedstatement = con.prepareStatement(query);
            
            preparedstatement.setString(1, plaka);
            preparedstatement.setString(2, marka);
            preparedstatement.setInt(3, model);
            preparedstatement.setString(4, vites);
            preparedstatement.setInt(5, son_km);
            preparedstatement.setString(6, tipi);
            preparedstatement.setString(7, yakit_turu);
            preparedstatement.setDate(8, muayene_tarihi);
            preparedstatement.setDate(9, sigorta_tarihi);
            preparedstatement.setDate(10, kasko_tarihi);
            preparedstatement.setString(11, sasi_no);
            preparedstatement.setString(12, motor_no);
            preparedstatement.setString(13, ruhsat_belge_no);            
            preparedstatement.setDate(14, filo_giris_tarihi);
            
            
            preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    //MUSTERİ EKLEME FONKSİYONU
    
    
    public void musteri_ekle(String tc,String ad,String soyad,String tel_no, String mail,int bakiye,String adres, String sehir){
        
        String query = "INSERT INTO MUSTERI_BILGILERI VALUES (?,?,?,?,?,?,?,?)";
        try {
            preparedstatement = con.prepareStatement(query);
            
            preparedstatement.setString(1, tc);
            preparedstatement.setString(2, ad);
            preparedstatement.setString(3, soyad);
            preparedstatement.setString(4, tel_no);
            preparedstatement.setString(5, mail);
            preparedstatement.setInt(6, bakiye);
            preparedstatement.setString(7, adres);
            preparedstatement.setString(8, sehir);
            
            
            preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    //Araç kiralama fonksiyonu
    
    public void aracKiralamaProcedure(String plaka, String marka, String tip, int son_km, String vites, String musteri_tc , String kur, String musteriAdi,String musteriSoyadi,
            java.sql.Date baslangic_tarihi, String baslangic_saati,java.sql.Date bitis_tarihi, String bitis_saati, int fiyat){
        try {
            CallableStatement cs;
            cs = con.prepareCall("{CALL ARACKIRALAMA(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, plaka );
            cs.setString(2, marka );
            cs.setString(3, tip );
            cs.setInt(4, son_km );
            cs.setString(5, vites );
            cs.setString(6, musteri_tc );
            cs.setString(7, musteriAdi );
            cs.setString(8, musteriSoyadi );
            cs.setDate(9, baslangic_tarihi );
            cs.setString(10, baslangic_saati );
            cs.setDate(11, bitis_tarihi );
            cs.setString(12, bitis_saati );
            cs.setInt(13, fiyat );
            cs.setString(14, kur );
           
            cs.executeQuery();

            
        } catch (SQLException ex) {
            Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("sıkıntı var");
        }
    }
    
    
    
    //KIRALIK ARAC LISTESI GOSTERME
    public ArrayList<KiralananAracBilgileri> kiradaki_arac_listesi(){
    
    ArrayList<KiralananAracBilgileri>  kiralik_arraylist= new ArrayList<KiralananAracBilgileri>();
    
    try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery("Select * From KIRALANAN_ARAC_BILGILERI");
            while (rs.next()){
                String plaka = rs.getString("PLAKA");
                
                
                String marka = rs.getString("MARKA");
                
                
                String tipi = rs.getString("TIP");
                
                String vites = rs.getString("VITES");
                
                int son_km = rs.getInt("SON_KM");
                
                int arac_fiyati = rs.getInt("ARAC_FIYATI");
                
                
                String kur = rs.getString("KUR");
                
                String musteri_tc = rs.getString("MUSTERI_TC");
                
                
                String musteri_adı = rs.getString("MUSTERI_ADI");
                
                String musteri_soyadı = rs.getString("MUSTERI_SOYADI");
                
                
                String tel_no = rs.getString("TEL_NO");
                
                
                Date baslangic_tarihi = rs.getDate("BAS_TARIHI");
                             
                String baslangic_saati = rs.getString("BAS_SAATI");
                
                Date bitis_tarihi =  rs.getDate("BITIS_TARIHI");
                                
                String bitis_saati = rs.getString("BITIS_SAATI");
                
                kiralik_arraylist.add( new KiralananAracBilgileri(plaka, marka, tipi,vites, musteri_tc,musteri_adı, musteri_soyadı,tel_no, 
                        baslangic_tarihi, baslangic_saati, bitis_tarihi, bitis_saati,son_km,arac_fiyati,kur));
    
            }
            
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return kiralik_arraylist;
    
    }
    
    //PLAKAYA GÖRE KIRALIK ARAC LISTESI GOSTERME
    public ArrayList<KiralananAracBilgileri> plakaya_gore_kiradaki_arac_listesi(){
    
    ArrayList<KiralananAracBilgileri>  kiralik_arraylist= new ArrayList<KiralananAracBilgileri>();
    
    try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery("Select * From KIRALANAN_ARAC_BILGILERI ORDER BY PLAKA");
            while (rs.next()){
                String plaka = rs.getString("PLAKA");
                
                
                String marka = rs.getString("MARKA");
                
                
                String tipi = rs.getString("TIP");
                
                String vites = rs.getString("VITES");
                
                int son_km = rs.getInt("SON_KM");
                
                int arac_fiyati = rs.getInt("ARAC_FIYATI");
                
                
                String kur = rs.getString("KUR");
                
                String musteri_tc = rs.getString("MUSTERI_TC");
                
                
                String musteri_adı = rs.getString("MUSTERI_ADI");
                
                String musteri_soyadı = rs.getString("MUSTERI_SOYADI");
                
                
                String tel_no = rs.getString("TEL_NO");
                
                
                Date baslangic_tarihi = rs.getDate("BAS_TARIHI");
                             
                String baslangic_saati = rs.getString("BAS_SAATI");
                
                Date bitis_tarihi =  rs.getDate("BITIS_TARIHI");
                                
                String bitis_saati = rs.getString("BITIS_SAATI");
                
                kiralik_arraylist.add( new KiralananAracBilgileri(plaka, marka, tipi,vites, musteri_tc,musteri_adı, musteri_soyadı,tel_no, 
                        baslangic_tarihi, baslangic_saati, bitis_tarihi, bitis_saati,son_km,arac_fiyati,kur));
    
            }
            
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return kiralik_arraylist;
    
    }
    
    //BUTUN ARAC LİSTELEME FONK.
    
    public ArrayList<ButunAracBilgileri> butunArac_listele(){
    
    ArrayList<ButunAracBilgileri>  butun_arraylist= new ArrayList<ButunAracBilgileri>();
    
    try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery("Select * From BUTUN_ARAC_BILGILERI");
            
            while (rs.next()){
                
                String plaka = rs.getString("PLAKA");
                
                String marka = rs.getString("MARKA");
                
                
                int modeli = rs.getInt("MODELI");
                
                
                String vites = rs.getString("VITES");
                
                
                int son_km = rs.getInt("SON_KM");
                
                
                String tip = rs.getString("TIP");
                
                String yakit_turu = rs.getString("YAKIT_TURU");
                
                Date muayene_tarihi = rs.getDate("MUAYENE_TARIHI");
                
                Date sigorta_tarihi = rs.getDate("SIGORTA_TARIHI");
                
                Date kasko_tarihi = rs.getDate("KASKO_TARIHI");
                
                String sasi_no = rs.getString("ŞASI_NO");
                
                String motor_no = rs.getString("MOTOR_NO");
                
                String ruhsat_no = rs.getString("RUHSAT_NO");
                
                Date f_giris = rs.getDate("FILO_GIRIS_TARIHI");
                
                             
               
                
                butun_arraylist.add( new ButunAracBilgileri(plaka,marka,tip,modeli,vites,son_km,yakit_turu,sasi_no,motor_no,ruhsat_no,muayene_tarihi,sigorta_tarihi,kasko_tarihi,f_giris));
    
            }
            
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return butun_arraylist;
    
    }
    
    //PLAKAYA GORE BUTUN ARAC LİSTELEME FONK.
    
    public ArrayList<ButunAracBilgileri> plaka_sirala_butunArac_listele(){
    
    ArrayList<ButunAracBilgileri>  butun_arraylist= new ArrayList<ButunAracBilgileri>();
    
    try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery("Select * From BUTUN_ARAC_BILGILERI ORDER BY PLAKA");
            
            while (rs.next()){
                
                String plaka = rs.getString("PLAKA");
                
                String marka = rs.getString("MARKA");
                
                
                int modeli = rs.getInt("MODELI");
                
                
                String vites = rs.getString("VITES");
                
                
                int son_km = rs.getInt("SON_KM");
                
                
                String tip = rs.getString("TIP");
                
                String yakit_turu = rs.getString("YAKIT_TURU");
                
                Date muayene_tarihi = rs.getDate("MUAYENE_TARIHI");
                
                Date sigorta_tarihi = rs.getDate("SIGORTA_TARIHI");
                
                Date kasko_tarihi = rs.getDate("KASKO_TARIHI");
                
                String sasi_no = rs.getString("ŞASI_NO");
                
                String motor_no = rs.getString("MOTOR_NO");
                
                String ruhsat_no = rs.getString("RUHSAT_NO");
                
                Date f_giris = rs.getDate("FILO_GIRIS_TARIHI");
                
                             
               
                
                butun_arraylist.add( new ButunAracBilgileri(plaka,marka,tip,modeli,vites,son_km,yakit_turu,sasi_no,motor_no,ruhsat_no,muayene_tarihi,sigorta_tarihi,kasko_tarihi,f_giris));
    
            }
            
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return butun_arraylist;
    
    }
    
    
    //MUSTERİ LİSTELEME FONK.
    
    public ArrayList<MusteriBilgileri> musteri_listesi(){
    
    ArrayList<MusteriBilgileri>  musteri_arraylist= new ArrayList<MusteriBilgileri>();
    
    try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery("Select * From MUSTERI_BILGILERI");
            
            while (rs.next()){
                
                String tc = rs.getString("MUSTERI_TC");
                
                String ad = rs.getString("AD");
                
                
                String soyad = rs.getString("SOYAD");
                
                
                String telno = rs.getString("TEL_NO");
                
                
                String mail = rs.getString("MAIL_ADD");
                
                
                int bakiye = rs.getInt("BAKIYE");
                
                String adres = rs.getString("ADRES");
                
                String sehir = rs.getString("SEHIR");
                             
               
                
                musteri_arraylist.add( new MusteriBilgileri(tc, ad, soyad, telno, mail, bakiye,adres,sehir));
    
            }
            
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return musteri_arraylist;
    
    }
    
    
    //ADA GORE SIRALI MUSTERİ LİSTELEME FONK.
    
    public ArrayList<MusteriBilgileri> ada_gore_sirali_musteri_listesi(){
    
    ArrayList<MusteriBilgileri>  musteri_arraylist= new ArrayList<MusteriBilgileri>();
    
    try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery("Select * From MUSTERI_BILGILERI ORDER BY AD");
            
            while (rs.next()){
                
                String tc = rs.getString("MUSTERI_TC");
                
                String ad = rs.getString("AD");
                
                
                String soyad = rs.getString("SOYAD");
                
                
                String telno = rs.getString("TEL_NO");
                
                
                String mail = rs.getString("MAIL_ADD");
                
                
                int bakiye = rs.getInt("BAKIYE");
                
                String adres = rs.getString("ADRES");
                
                String sehir = rs.getString("SEHIR");
                             
               
                
                musteri_arraylist.add( new MusteriBilgileri(tc, ad, soyad, telno, mail, bakiye,adres,sehir));
    
            }
            
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return musteri_arraylist;
    
    }
    
    //TCYE GORE SIRALI MUSTERİ LİSTELEME FONK.
    
    public ArrayList<MusteriBilgileri> tc_gore_sirali_musteri_listesi(){
    
    ArrayList<MusteriBilgileri>  musteri_arraylist= new ArrayList<MusteriBilgileri>();
    
    try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery("Select * From MUSTERI_BILGILERI ORDER BY MUSTERI_TC");
            
            while (rs.next()){
                
                String tc = rs.getString("MUSTERI_TC");
                
                String ad = rs.getString("AD");
                
                
                String soyad = rs.getString("SOYAD");
                
                
                String telno = rs.getString("TEL_NO");
                
                
                String mail = rs.getString("MAIL_ADD");
                
                
                int bakiye = rs.getInt("BAKIYE");
                
                String adres = rs.getString("ADRES");
                
                String sehir = rs.getString("SEHIR");
                             
               
                
                musteri_arraylist.add( new MusteriBilgileri(tc, ad, soyad, telno, mail, bakiye,adres,sehir));
    
            }
            
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return musteri_arraylist;
    
    }
    
    
    
    
    
    //BOS ARAC LİSTELEME
    public ArrayList<BosAracBilgileri> bosArac_listesi(){
    
    ArrayList<BosAracBilgileri>  bos_arac_arraylist= new ArrayList<BosAracBilgileri>();
    
    try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery("Select * From BOS_ARAC_BILGILERI");
            
            while (rs.next()){
                
                
                
                String plaka = rs.getString("PLAKA");
                
                
                String marka = rs.getString("MARKA");
                
                
                String tip = rs.getString("TIP");
                
                
                String vites = rs.getString("VITES");
                
                
                String yakit_turu = rs.getString("YAKIT_TURU");
                
                int son_km = rs.getInt("SON_KM");
                             
               
                bos_arac_arraylist.add( new BosAracBilgileri(plaka,marka,tip,vites,son_km,yakit_turu));
                
            }
            
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return bos_arac_arraylist;
    
    }
    
    //PLAKAYA GÖRE BOS ARAC LİSTELEME
    public ArrayList<BosAracBilgileri> plakaya_gore_bosArac_listesi(){
    
    ArrayList<BosAracBilgileri>  bos_arac_arraylist= new ArrayList<BosAracBilgileri>();
    
    try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery("Select * From BOS_ARAC_BILGILERI ORDER BY PLAKA");
            
            while (rs.next()){
                
                
                
                String plaka = rs.getString("PLAKA");
                
                
                String marka = rs.getString("MARKA");
                
                
                String tip = rs.getString("TIP");
                
                
                String vites = rs.getString("VITES");
                
                
                String yakit_turu = rs.getString("YAKIT_TURU");
                
                int son_km = rs.getInt("SON_KM");
                             
               
                bos_arac_arraylist.add( new BosAracBilgileri(plaka,marka,tip,vites,son_km,yakit_turu));
                
            }
            
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return bos_arac_arraylist;
    
    }
    
    
    //Kiralık Arac Güncelleme
    
    public void kontrat_duzelt(String plaka, String kur,java.sql.Date baslangic_tarihi, String baslangic_saati,
            java.sql.Date bitis_tarihi, String bitis_saati, int fiyat){
        
        
            String query = "UPDATE KIRALANAN_ARAC_BILGILERI SET ARAC_FIYATI = ?, KUR = ?, "
                    + "BAS_TARIHI = ?, BAS_SAATI = ?, BITIS_TARIHI = ?, BITIS_SAATI = ? "
                    + "WHERE PLAKA = ?";
        
        try {
            
            PreparedStatement stmt = con.prepareStatement(query);
            
            
            stmt.setInt(1, fiyat );
            stmt.setString(2, kur );
            stmt.setDate(3, baslangic_tarihi );
            stmt.setString(4, baslangic_saati );
            stmt.setDate(5, bitis_tarihi );
            stmt.setString(6, bitis_saati );
            stmt.setString(7, plaka );
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
    //ARAC SAYILARINI BULMA
    
    public String bos_arac_sayisi(){
        
        String query = "SELECT COUNT(*) FROM BOS_ARAC_BILGILERI";
        String count;
        try {
            
            preparedstatement = con.prepareStatement(query);
            ResultSet rs = preparedstatement.executeQuery();
            
            if(rs.next()){
                
                count = rs.getString("COUNT(*)");
                return count;
            }
            
            
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
           return null;
            
        }
        
        return null;
    }
    
    //KİRALIK ARAÇ SAYISI
    public String kiralik_arac_sayisi(){
        
        String query = "SELECT COUNT(*) FROM KIRALANAN_ARAC_BILGILERI";
        String count;
        try {
            
            preparedstatement = con.prepareStatement(query);
            ResultSet rs = preparedstatement.executeQuery();
            
            if(rs.next()){
                
                count = rs.getString("COUNT(*)");
                return count;
            }
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
           return null;
            
        }
        
        return null;
    }

 
    
    
    //KAPANAN_SOZLESMELER Tablosuna ekleme
    
    public void kontrat(String plaka,String musteri_tc,int donus_km, double kdv, String teslim_eden,java.sql.Date donus_tarihi,String kdon_time){
        
        
        try {
            CallableStatement cs;
            cs = con.prepareCall("{CALL KONTRAT_KALDIR(?,?,?,?,?,?,?)}");
            cs.setString(1, plaka );
            cs.setString(2, musteri_tc );
            cs.setInt(3, donus_km );
            cs.setDouble(4, kdv );
            cs.setString(5, teslim_eden );
            cs.setDate(6, donus_tarihi );
            cs.setString(7, kdon_time );
           
            cs.executeQuery();

            
        } catch (SQLException ex) {
            Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("sıkıntı var");
        }
    }
    
    //KAPANAN SOZLESMELER LİSTELEME
    public ArrayList<KontratBilgileri> kapanan_sozlesme_listesi(){
    
    ArrayList<KontratBilgileri>  kapanan_sozlesme_arraylist= new ArrayList<KontratBilgileri>();
    
    try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery("Select * From KAPANAN_SOZLESMELER");
            
            while (rs.next()){
                
                String plaka = rs.getString("PLAKA");
                String marka = rs.getString("MARKA");
                String tip = rs.getString("TIP");
                String vites = rs.getString("VITES");
                int bas_km = rs.getInt("BAS_KM");
                int son_km = rs.getInt("SON_KM");
                int fiyat = rs.getInt("ARAC_FIYATI");
                String kur = rs.getString("KUR");
                int top_para = rs.getInt("ODENEN_TOPLAM_MIKTAR");
                double kdv_bedeli = rs.getDouble("KDV_BEDELİ");
                int gun_say = rs.getInt("KIRALANAN_GUN_SAYISI");
                String tc = rs.getString("KUR");
                String musteri_ad = rs.getString("MUSTERI_ADI");
                String musteri_soyad = rs.getString("MUSTERI_SOYADI");
                String teslim_eden = rs.getString("TESLIM_EDEN");
                String tel_no = rs.getString("TEL_NO");
                Date baslangic_tarihi = rs.getDate("BAS_TARIHI");
                String baslangic_saati = rs.getString("BAS_SAATI");
                Date bitis_tarihi =  rs.getDate("BITIS_TARIHI");
                String bitis_saati = rs.getString("BITIS_SAATI");
                
                
               
                kapanan_sozlesme_arraylist.add( new KontratBilgileri(plaka,marka,tip,vites,son_km,bas_km,fiyat,kur,top_para,kdv_bedeli,gun_say,
                tc,musteri_ad,musteri_soyad,teslim_eden,tel_no,baslangic_tarihi,baslangic_saati,bitis_tarihi,bitis_saati));
                
            }
            
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return kapanan_sozlesme_arraylist;
    
    }
    
    
    //HESAP EKS LİSTELEME
    public ArrayList<HesapEks> hesap_eks_listele(String tc){
    
    ArrayList<HesapEks>  hesap_eks_arraylist= new ArrayList<HesapEks>();
    
    String query = "Select * From MUSTERI_HESAP_EKS WHERE MUSTERI_TC = '"+tc+"'";
    
    try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery(query);
            //preparedstatement.setString(1, tc); WHERE MUSTERI_TC = ?
            
            while (rs.next()){
                
                
                int alacak = rs.getInt("ALACAK");
                int borc = rs.getInt("BORC");
                int total = rs.getInt("TOTAL");
                String musteri_tc = rs.getString("MUSTERI_TC");
                String musteri_ad = rs.getString("MUSTERI_ADI");
                String musteri_soyad = rs.getString("MUSTERI_SOYADI");
                String aciklama = rs.getString("ACIKLAMA");
                Date baslangic_tarihi = rs.getDate("BAS_TARIHI");
                String tur = rs.getString("TUR");
                
                
                
                
               
                hesap_eks_arraylist.add(new HesapEks(musteri_tc,musteri_ad,musteri_soyad,tur,baslangic_tarihi,alacak,borc,total,aciklama));
                
            }
            
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return hesap_eks_arraylist;
    
    }
    
    
    //MÜŞTERİYE AİT KİRALIK ARAÇLARI BULMA
    public ArrayList<KiralananAracBilgileri> carinin_arac_listesi(String tc){
    
    ArrayList<KiralananAracBilgileri>  cari_kiralik_arraylist= new ArrayList<KiralananAracBilgileri>();
    
    try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery("Select * From KIRALANAN_ARAC_BILGILERI WHERE MUSTERI_TC = '"+tc+"'");
            while (rs.next()){
                String plaka = rs.getString("PLAKA");
                
                
                String marka = rs.getString("MARKA");
                
                
                int arac_fiyati = rs.getInt("ARAC_FIYATI");
                
                
                Date baslangic_tarihi = rs.getDate("BAS_TARIHI");
                             
               
                
                Date bitis_tarihi =  rs.getDate("BITIS_TARIHI");
                                
               
                
                cari_kiralik_arraylist.add( new KiralananAracBilgileri(plaka, marka, null,null, null,null, null,null, 
                        baslangic_tarihi, null, bitis_tarihi, null,0,arac_fiyati,null));
    
            }
            
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return cari_kiralik_arraylist;
    
    } 
    
    
    //BİR ARACIN BİLGİLERİNE ERİŞME
    
    public ArrayList<KiralananAracBilgileri> arac_bilgileri(String plaka){
    
    ArrayList<KiralananAracBilgileri>  bir_kiralik_arraylist= new ArrayList<KiralananAracBilgileri>();
    
    try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery("Select * From KIRALANAN_ARAC_BILGILERI WHERE PLAKA = '"+plaka+"'");
            while (rs.next()){
                
                
                int arac_fiyati = rs.getInt("ARAC_FIYATI");
                
                
                Date baslangic_tarihi = rs.getDate("BAS_TARIHI");
                             
               
                
                Date bitis_tarihi =  rs.getDate("BITIS_TARIHI");
                                
               
                
                bir_kiralik_arraylist.add( new KiralananAracBilgileri(plaka, null, null,null, null,null, null,null, 
                        baslangic_tarihi, null, bitis_tarihi, null,0,arac_fiyati,null));
    
            }
            
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return bir_kiralik_arraylist;
    
    } 
    
    //FATURA NO ÇAĞIRMA
    
    public int seq_fatura(){
        
        int fatura_no = 0;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select seq_fatura.nextval from dual");
            while (rs.next()){
                
                
                fatura_no = rs.getInt(1);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fatura_no;
        
    }
    
     //FATURA EKLE EKLEME FONKSİYONU
    
    
    public void fatura_ekle(String tc,String ad,String soyad,String tel_no, String adres, String sehir, String fatura_no, 
                            String gonderim_sekli, int genel_toplam, double kdv, String aciklama, String plaka, Date tarih){
        
        
        
        
        try {
            CallableStatement cs;
            cs = con.prepareCall("{CALL FATURA_PRO(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, plaka);
            cs.setString(2, tc);
            cs.setString(3, ad);
            cs.setString(4, soyad);
            cs.setString(5, tel_no);
            cs.setString(6, sehir);
            cs.setString(7, adres);
            cs.setString(8, fatura_no);
            cs.setString(9, gonderim_sekli);
            cs.setDouble(10, kdv);
            cs.setDouble(11, genel_toplam);
            cs.setString(12, aciklama); 
            cs.setDate(13, tarih);
            
           
            cs.executeQuery();

            
        } catch (SQLException ex) {
            Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("sıkıntı var");
        }
        
    }
    
    //TAHSİLAT NO ÇAĞIRMA
    
    public int seq_tahsilat(){
        
        int tahsilat_no = 0;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select seq_tahsilat.nextval from dual");
            while (rs.next()){
                
                
                tahsilat_no = rs.getInt(1);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tahsilat_no;
        
    }
    
    //TAHSİLAT EKLE EKLEME FONKSİYONU
   
    public void tahsilat_ekle(String tc,String ad,String soyad,String personel, String tahsilat_no, int kasa_tutarı, int cari_tutar, 
                              String aciklama, Date tarih){
        
        
        try {
            CallableStatement cs;
            cs = con.prepareCall("{CALL TAHSILAT_PRO(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, tc);
            cs.setString(2, ad);
            cs.setString(3, soyad);
            cs.setString(4, personel);
            cs.setString(5, tahsilat_no);
            cs.setInt(6, kasa_tutarı);
            cs.setInt(7, cari_tutar);
            cs.setString(8, aciklama);
            cs.setDate(9, tarih);
           
            cs.executeQuery();

            
        } catch (SQLException ex) {
            Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("sıkıntı var");
        }
        
    }
    
    
    
    
    //ODEME EKLE EKLEME FONKSİYONU
    
   
    public void odeme_ekle(String tc,String ad,String soyad,String personel, String makbuz_no, int kasa_tutarı, int cari_tutar, 
                              String aciklama, Date tarih){
        
        
        try {
            CallableStatement cs;
            cs = con.prepareCall("{CALL ODEME_PRO(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, tc);
            cs.setString(2, ad);
            cs.setString(3, soyad);
            cs.setString(4, personel);
            cs.setString(5, makbuz_no);
            cs.setInt(6, kasa_tutarı);
            cs.setInt(7, cari_tutar);
            cs.setString(8, aciklama);
            cs.setDate(9, tarih);
           
            cs.executeQuery();

            
        } catch (SQLException ex) {
            Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("sıkıntı var");
        }
        
    }
    
    
    //PERSONEL EKLE
    
    public void personel_ekle(String ad,String soyad,String kul_ad, String sifre,String yetki){
        
        String query = "INSERT INTO KULLANICI (ADI, SOYADI, NICK, SIFRE, YETKI) VALUES (?,?,?,?,?)";
        try {
            
            preparedstatement = con.prepareStatement(query);
            
            preparedstatement.setString(1, ad);
            preparedstatement.setString(2, soyad);
            preparedstatement.setString(3, kul_ad);
            preparedstatement.setString(4, sifre);
            preparedstatement.setString(5, yetki);
            
            
            preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    //BUTUN ARAC LİSTELEME FONK.
    
    public ArrayList<PersonelBilgileri> kul_listele(){
    
    ArrayList<PersonelBilgileri>  kul_arraylist= new ArrayList<PersonelBilgileri>();
    
    try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery("Select * From KULLANICI");
            
            while (rs.next()){
                
                int id = rs.getInt("ID");
                
                String ad = rs.getString("ADI");
                
                String soyad = rs.getString("SOYADI");
                                
                
                String nick = rs.getString("NICK");
                
                
                String sifre = rs.getString("SIFRE");
                
                String yetki = rs.getString("YETKI");
                
                
                kul_arraylist.add( new PersonelBilgileri(id, ad, soyad, nick, sifre, yetki));
    
            }
            
            
        } catch (SQLException ex) {
           Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return kul_arraylist;
    
    }
    
    
    
    public void perKayitGuncelle(int id,String ad, String soyad, String k_adi, String sifre, String yetki){
        
        
        
        String query = "UPDATE KULLANICI SET ADI = ? , SOYADI = ?, "
                       + "NICK = ? , SIFRE = ?, YETKI = ?  "
                       + "WHERE ID = ?";
        
        try {
            
            PreparedStatement stmt = con.prepareStatement(query);
            
            
            stmt.setString(1, ad );
            stmt.setString(2, soyad );
            stmt.setString(3, k_adi );
            stmt.setString(4, sifre );
            stmt.setString(5, yetki );
            stmt.setInt(6, id );
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    public void personel_sil (int id){
        String query = "DELETE FROM KULLANICI WHERE ID = ?";

        try (
                
            PreparedStatement stmt = con.prepareStatement(query)) {
      
            stmt.setInt(1, id);
            stmt.executeUpdate();
      
            
        } catch (SQLException ex) {
            Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    
    //GIRIS ISLEMI DOĞRULAMA
    
    public String[] giris_yap (String k_adi, String sifre){
        
        try {
            String[] out = new String[4];
            CallableStatement cs;
            cs = con.prepareCall("{CALL GIRIS_PROCEDURE(?,?,?,?,?,?)}");
            cs.setString(1, k_adi );
            cs.setString(2, sifre );
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.registerOutParameter(6, java.sql.Types.VARCHAR);
            cs.executeUpdate();
            String sonuc = cs.getString(3);
            String yetki = cs.getString(4);
            String ad = cs.getString(5);
            String soyad = cs.getString(6);
            
            out[0] = sonuc;
            out[1] = ad;
            out[2] = soyad;
            out[3] = yetki;
            
            return out;
        } catch (SQLException ex) {
            Logger.getLogger(ButunDBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    
    
    
}
