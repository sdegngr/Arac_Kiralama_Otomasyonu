/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;


import bilgiler.KontratBilgileri;
import db_islemler.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author sudeg
 */
public class AracKiralama extends javax.swing.JPanel {

    
    
    
    ButunDBIslemleri islemler = new ButunDBIslemleri();
    public KontratBilgileri kontrat ;
    String temp_plaka;
    String temp_musteriAd;
    String temp_musteriSoyad;
    String temp_musteriTC;
    String temp_marka ;
    String temp_tip ;
    int temp_son_km;
    String temp_vites;
    Date bas_tar; 
    String bas_sa;
    Date bit_tar;
    String bit_sa; 
    int fiyat;
    
    
    
    /**
     * Creates new form AracKiralama2
     */
    public AracKiralama(String temp_plaka,String temp_musteriAd,String temp_musteriSoyad,
    String temp_musteriTC,String temp_marka, String temp_tip, int temp_son_km, String temp_vites,Date bas_tar, 
    String bas_sa, Date bit_tar, String bit_sa, int fiyat) {
        
        initComponents();
        
        musteriad_text2.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
        musterisoyad_text2.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
        musteriTc_text.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
        plaka_text2.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
        tipi_text2.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
        marka_text2.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
        sonkm_text2.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
        vites_text2.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
        fiyat_text1.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
        top_fiyat_text.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
        kdv_bedeli_text.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
        kr_gun_say_text.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
        bit_sa_spinner1.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
        bas_sa_spinner1.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
        
        
        this.temp_plaka = temp_plaka;
        this.temp_musteriAd = temp_musteriAd;
        this.temp_musteriSoyad = temp_musteriSoyad;
        this.temp_musteriTC = temp_musteriTC;
        this.temp_marka = temp_marka;
        this.temp_tip = temp_tip;
        this.temp_son_km = temp_son_km;
        this.temp_vites = temp_vites;
        this.bas_tar = bas_tar; 
        this.bas_sa = bas_sa;
        this.bit_tar = bit_tar;
        this.bit_sa = bit_sa;
        this.fiyat = fiyat;
        
        postData2();
        
        if(fiyat_text1.getText() != null){   
            postData();
            
        }
        
        
    }
    
    
     public void bilgileriYazdir(){
        
        DecimalFormat formatter2 = new DecimalFormat("##.##");
            
            java.util.Date util_baslangic_tarihi = new java.util.Date(); 
            util_baslangic_tarihi = bas_tar1.getDate();
            
            java.util.Date util_bitis_tarihi = new java.util.Date();
            util_bitis_tarihi = bit_tar1.getDate();
            
            long fark = util_bitis_tarihi.getTime() - util_baslangic_tarihi.getTime();
            long deger = TimeUnit.DAYS.convert(fark, TimeUnit.MILLISECONDS);
            String str = Long.toString(deger);
            kr_gun_say_text.setText(str); //Gün farkını yazdırır.
            
            if(deger<0){
                JOptionPane.showMessageDialog(null, "Başlangıç ya da Bitiş tarihlerini tarihlerini yanlış girdiniz. Lütfen uygun bir tarih girin.");
                
            }
            
            else{
                int temp_fiyat = Integer.parseInt(fiyat_text1.getText()); //Girilen günlük fiyat bedelini çeker.
            
                long top_fiyat = temp_fiyat*deger;    //Gün farkı ile fiyatı çarpar ve toplam ödenecek parayı bulur.   
        
                String str2 = Long.toString(top_fiyat);
                top_fiyat_text.setText(str2);
            
            
                double kdv;
                kdv = top_fiyat;
                kdv = kdv * 0.18; //Toplam paranın KDV'sini hesaplar.
        
                kdv_bedeli_text.setText(formatter2.format(kdv));
            }
    }
    
    
     public void postData(){ 
        
        //Bos arac ve sonrasında müsteri listesinden bilgileri getirmek için
        
        
        
        plaka_text2.setText(temp_plaka);
        musteriad_text2.setText(temp_musteriAd); 
        musterisoyad_text2.setText(temp_musteriSoyad); 
        musteriTc_text.setText(String.valueOf( temp_musteriTC)); 
        marka_text2.setText(temp_marka); 
        vites_text2.setText(temp_vites); 
        tipi_text2.setText(temp_tip); 
        sonkm_text2.setText(String.valueOf(temp_son_km)); 
        
        top_fiyat_text.setEditable(false);
        kdv_bedeli_text.setEditable(false);
        kr_gun_say_text.setEditable(false);
        plaka_text2.setEditable(false);
        musteriad_text2.setEditable(false);
        musterisoyad_text2.setEditable(false);
        musteriTc_text.setEditable(false);
        marka_text2.setEditable(false);
        vites_text2.setEditable(false);
        tipi_text2.setEditable(false);
        sonkm_text2.setEditable(false);
        degistir_button.setEnabled(false);
        
    }
    
    
    public void postData2(){
        
        try {
            //Kiralık araç listesinden bilgileri getirmek için
            
            
            if(bit_tar == null){
                
                Date tarih = new Date();
                bas_tar1.setDate(tarih);
            }
            else{
                
            bas_tar1.setDate(bas_tar);
            bit_tar1.setDate(bit_tar);
            
            fiyat_text1.setText(String.valueOf(fiyat));
            
            DateFormat simpleDateFormat=new SimpleDateFormat("hh:mm:ss");
            Date bas_sa = (Date) simpleDateFormat.parse(this.bas_sa);
            bas_sa_spinner1.setValue(bas_sa);
            
            Date bit_sa = (Date) simpleDateFormat.parse(this.bit_sa);
            bit_sa_spinner1.setValue(bit_sa);
            
            bilgileriYazdir();
            
            
            top_fiyat_text.setEnabled(false);
            kdv_bedeli_text.setEnabled(false);
            kr_gun_say_text.setEnabled(false);
            plaka_text2.setEnabled(false);
            musteriad_text2.setEnabled(false);
            musterisoyad_text2.setEnabled(false);
            musteriTc_text.setEnabled(false);
            marka_text2.setEnabled(false);
            vites_text2.setEnabled(false);
            tipi_text2.setEnabled(false);
            sonkm_text2.setEnabled(false);
            kur_turu.setEnabled(false);
            fiyat_text1.setEnabled(false);
            bas_tar1.setEnabled(false);
            bas_sa_spinner1.setEnabled(false);
            bit_tar1.setEnabled(false);
            bit_sa_spinner1.setEnabled(false);
            degistir_button.setEnabled(true);
            
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(AracKiralama.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
     
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        vites_text2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sonkm_text2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        bas_tar1 = new org.jdesktop.swingx.JXDatePicker();
        marka_text2 = new javax.swing.JTextField();
        kaydet_button = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        plaka_text2 = new javax.swing.JTextField();
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        bas_sa_spinner1 = new javax.swing.JSpinner(sm);
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        Date date2 = new Date();
        SpinnerDateModel sm2 = new SpinnerDateModel(date2, null, null, Calendar.HOUR_OF_DAY);
        bit_sa_spinner1 = new javax.swing.JSpinner(sm2);
        kkapat_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        kiralanacak_gun_label = new javax.swing.JLabel();
        kur_turu = new javax.swing.JComboBox<>();
        kdv_label = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fiyat_text1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        bit_tar1 = new org.jdesktop.swingx.JXDatePicker();
        musteriad_text2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        top_fiyat_text = new javax.swing.JTextField();
        musterisoyad_text2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        musteriTc_text = new javax.swing.JTextField();
        kdv_bedeli_text = new javax.swing.JTextField();
        kr_gun_say_text = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        degistir_button = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tipi_text2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 153));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("BAŞ.TAR.");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("BAŞ.SA.");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("SON KM");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("BİTİŞ.TAR.");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("BİTİŞ.SA.");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("MARKA");

        kaydet_button.setBackground(new java.awt.Color(0, 0, 153));
        kaydet_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kaydet_button.setForeground(new java.awt.Color(255, 255, 255));
        kaydet_button.setText("KAYDET");
        kaydet_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaydet_buttonActionPerformed(evt);
            }
        });

        JSpinner.DateEditor de = new JSpinner.DateEditor(bas_sa_spinner1, "HH:mm:ss");
        bas_sa_spinner1.setEditor(de);

        JSpinner.DateEditor de2 = new JSpinner.DateEditor(bit_sa_spinner1, "HH:mm:ss");
        bit_sa_spinner1.setEditor(de2);

        kkapat_button.setBackground(new java.awt.Color(0, 0, 153));
        kkapat_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kkapat_button.setForeground(new java.awt.Color(255, 255, 255));
        kkapat_button.setText("KONTRAT KAPAT");
        kkapat_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kkapat_buttonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("FIYAT");

        kiralanacak_gun_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kiralanacak_gun_label.setForeground(new java.awt.Color(0, 0, 0));
        kiralanacak_gun_label.setText("KİRALANACAK GÜN SAYISI");

        kur_turu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TL", "EURO", "DOLAR" }));

        kdv_label.setBackground(new java.awt.Color(255, 255, 255));
        kdv_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kdv_label.setForeground(new java.awt.Color(0, 0, 0));
        kdv_label.setText("KDV BEDELİ");

        jLabel4.setBackground(new java.awt.Color(153, 153, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("MÜŞTERİ BİLGİLERİ");

        fiyat_text1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fiyat_text1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fiyat_text1KeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("TOPLAM FİYAT");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("MÜŞTERİ SOYADI");

        top_fiyat_text.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel17.setBackground(new java.awt.Color(153, 153, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("KDV DAHİL GÜNLÜK");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("MÜŞTERİ TC");

        jLabel11.setBackground(new java.awt.Color(153, 153, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("ARAÇ BİLGİLERİ");

        degistir_button.setBackground(new java.awt.Color(0, 0, 153));
        degistir_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        degistir_button.setForeground(new java.awt.Color(255, 255, 255));
        degistir_button.setText("DEĞİŞTİR");
        degistir_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degistir_buttonActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("TİPİ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("PLAKA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("MÜŞTERİ ADI");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("VİTES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
            .addComponent(jSeparator5)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(musteriad_text2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(73, 73, 73)
                        .addComponent(musterisoyad_text2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(musteriTc_text, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(46, 46, 46)
                                .addComponent(plaka_text2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tipi_text2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(88, 88, 88))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(marka_text2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sonkm_text2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91)
                        .addComponent(jLabel13)
                        .addGap(37, 37, 37)
                        .addComponent(vites_text2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(kaydet_button)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(fiyat_text1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(bit_sa_spinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addGap(68, 68, 68)
                                                    .addComponent(bas_tar1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(bas_sa_spinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bit_tar1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(kur_turu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(295, 295, 295)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel16)
                                                    .addComponent(kdv_label)
                                                    .addComponent(kiralanacak_gun_label))
                                                .addGap(45, 45, 45)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(kdv_bedeli_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(top_fiyat_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(kr_gun_say_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(124, 124, 124)
                                                .addComponent(kkapat_button)
                                                .addGap(116, 116, 116)
                                                .addComponent(degistir_button))))))
                            .addComponent(jLabel4)
                            .addComponent(jLabel11))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(musteriTc_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(musterisoyad_text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(musteriad_text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plaka_text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vites_text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(marka_text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sonkm_text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(tipi_text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(bas_tar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(bas_sa_spinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(bit_tar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(bit_sa_spinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(top_fiyat_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kdv_label)
                            .addComponent(kdv_bedeli_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kiralanacak_gun_label)
                            .addComponent(kr_gun_say_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38)
                .addComponent(jLabel17)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiyat_text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kur_turu, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kaydet_button)
                    .addComponent(kkapat_button)
                    .addComponent(degistir_button))
                .addGap(127, 127, 127))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void kaydet_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaydet_buttonActionPerformed
        // TODO add your handling code here:
        
        
            
            try{
                String plaka = plaka_text2.getText();
                String musteriAdi = musteriad_text2.getText();
                String musteriSoyad = musterisoyad_text2.getText();
                String tc = musteriTc_text.getText();
                String marka = marka_text2.getText();
                String vites = vites_text2.getText();
                String tip = tipi_text2.getText();
                int son_km = Integer.parseInt(sonkm_text2.getText());

                //kullanıcının girdireceği deperler
                String kur = kur_turu.getSelectedItem().toString();
                int fiyat = Integer.parseInt(fiyat_text1.getText());

                java.util.Date util_baslangic_tarihi = new java.util.Date();
                util_baslangic_tarihi = bas_tar1.getDate();
                java.sql.Date baslangic_tarihi = new java.sql.Date(util_baslangic_tarihi.getTime());

                Object bas_value = bas_sa_spinner1.getValue();
                Date baslangic_saati = (Date)bas_value;
                SimpleDateFormat bas_format = new SimpleDateFormat("HH:mm:ss");
                String bas_time = bas_format.format(baslangic_saati);

                java.util.Date util_bitis_tarihi = new java.util.Date();
                util_bitis_tarihi = bit_tar1.getDate();
                java.sql.Date bitis_tarihi = new java.sql.Date(util_bitis_tarihi.getTime());

                Object bit_value = bit_sa_spinner1.getValue();
                Date bitis_saati = (Date)bit_value;
                SimpleDateFormat bit_format = new SimpleDateFormat("HH:mm:ss");
                String bit_time = bit_format.format(bitis_saati);

                if(degistir_button.isEnabled()==false)
                islemler.aracKiralamaProcedure(plaka, marka, tip, son_km, vites, tc, kur, musteriAdi, musteriSoyad, baslangic_tarihi, bas_time, bitis_tarihi, bit_time,fiyat);

                else if(degistir_button.isEnabled()==true)
                islemler.kontrat_duzelt(plaka,kur,baslangic_tarihi,bas_time,bitis_tarihi,bit_time,fiyat);

                top_fiyat_text.setEnabled(false);
                kdv_bedeli_text.setEnabled(false);
                kr_gun_say_text.setEnabled(false);
                plaka_text2.setEnabled(false);
                musteriad_text2.setEnabled(false);
                musterisoyad_text2.setEnabled(false);
                musteriTc_text.setEnabled(false);
                marka_text2.setEnabled(false);
                vites_text2.setEnabled(false);
                tipi_text2.setEnabled(false);
                sonkm_text2.setEnabled(false);
                kur_turu.setEnabled(false);
                fiyat_text1.setEnabled(false);
                bas_tar1.setEnabled(false);
                bas_sa_spinner1.setEnabled(false);
                bit_tar1.setEnabled(false);
                bit_sa_spinner1.setEnabled(false);
                degistir_button.setEnabled(true);

            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "ERROR");

            }
          

    }//GEN-LAST:event_kaydet_buttonActionPerformed

    private void kkapat_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kkapat_buttonActionPerformed
        // *****************************TODO add your handling code here:

        String plaka = plaka_text2.getText();

        int odenen_toplam_miktar = (Integer.parseInt(top_fiyat_text.getText()));
        double kdv_bedeli = (Double.parseDouble(kdv_bedeli_text.getText()));
        int kiralanan_gun_sayisi = (Integer.parseInt(kr_gun_say_text.getText()));
        String musteri_tc = musteriTc_text.getText();

        new KontratKapatmaEkrani(plaka,musteri_tc,odenen_toplam_miktar,kdv_bedeli,kiralanan_gun_sayisi).setVisible(true);


    }//GEN-LAST:event_kkapat_buttonActionPerformed

    private void fiyat_text1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fiyat_text1KeyPressed
        // TODO add your handling code here:

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bilgileriYazdir();

        }
    }//GEN-LAST:event_fiyat_text1KeyPressed

    private void degistir_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degistir_buttonActionPerformed
        // TODO add your handling code here:
        top_fiyat_text.setEnabled(true);
        kdv_bedeli_text.setEnabled(true);
        kr_gun_say_text.setEnabled(true);
        plaka_text2.setEnabled(true);
        musteriad_text2.setEnabled(true);
        musterisoyad_text2.setEnabled(true);
        musteriTc_text.setEnabled(true);
        marka_text2.setEnabled(true);
        vites_text2.setEnabled(true);
        tipi_text2.setEnabled(true);
        sonkm_text2.setEnabled(true);
        kur_turu.setEnabled(true);
        fiyat_text1.setEnabled(true);
        bas_tar1.setEnabled(true);
        bas_sa_spinner1.setEnabled(true);
        bit_tar1.setEnabled(true);
        bit_sa_spinner1.setEnabled(true);
        
        
    }//GEN-LAST:event_degistir_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner bas_sa_spinner1;
    private org.jdesktop.swingx.JXDatePicker bas_tar1;
    private javax.swing.JSpinner bit_sa_spinner1;
    private org.jdesktop.swingx.JXDatePicker bit_tar1;
    private javax.swing.JButton degistir_button;
    private javax.swing.JTextField fiyat_text1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton kaydet_button;
    private javax.swing.JTextField kdv_bedeli_text;
    private javax.swing.JLabel kdv_label;
    private javax.swing.JLabel kiralanacak_gun_label;
    private javax.swing.JButton kkapat_button;
    private javax.swing.JTextField kr_gun_say_text;
    private javax.swing.JComboBox<String> kur_turu;
    private javax.swing.JTextField marka_text2;
    private javax.swing.JTextField musteriTc_text;
    private javax.swing.JTextField musteriad_text2;
    private javax.swing.JTextField musterisoyad_text2;
    public javax.swing.JTextField plaka_text2;
    private javax.swing.JTextField sonkm_text2;
    private javax.swing.JTextField tipi_text2;
    private javax.swing.JTextField top_fiyat_text;
    private javax.swing.JTextField vites_text2;
    // End of variables declaration//GEN-END:variables
}
