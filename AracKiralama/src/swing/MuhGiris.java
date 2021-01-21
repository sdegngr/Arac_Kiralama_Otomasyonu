/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;




/**
 *
 * @author sudeg
 */
public class MuhGiris extends javax.swing.JFrame{
    
    
    Object[] data = new Object[5];
    
    public String yetki;
    
    public boolean click;
    
    /**
     * Creates new form SVGiris
     */
    public MuhGiris(String yetki) {
        initComponents();
        this.yetki = yetki;
        yetki_txt.setText(yetki);
        yetki_txt.setBorder(null);
        yetki_txt.setEditable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        execute();
        
          
    }
    
    
    private void execute(){
        
        //buton.setEnabled(false);
        
             
        ImageIcon iconDriver = new ImageIcon(getClass().getResource("/icon/icons8_driving_30px_1.png"));
        ImageIcon iconFatura = new ImageIcon(getClass().getResource("/icon/icons8_invoice_30px.png"));
        ImageIcon iconOdeme = new ImageIcon(getClass().getResource("/icon/icons8_card_payment_30px.png"));
        ImageIcon iconCikis = new ImageIcon(getClass().getResource("/icon/icons8_shutdown_30px.png"));
        
        
        ImageIcon iconEkle = new ImageIcon(getClass().getResource("/icon/icons8_add_24px_1.png"));
        ImageIcon iconListele = new ImageIcon(getClass().getResource("/icon/icons8_list_24px_1.png")); 
        
        
        
        
        
        
        SVMenu kontrat_listele = new SVMenu(iconListele, "KAPANAN KOTRATLARI LİSTELE", new ActionListener() {
            
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                jLabel2.setText("Kapanan Kontratları Listeleme İşlemi");
                
                panel_sag1.removeAll();
                panel_sag1.add(new KapananSozlesmeler());
                        
                panel_sag1.repaint();
                panel_sag1.revalidate();
            }
        });
        
        
        
        
        SVMenu musteriListele = new SVMenu(iconListele, "MÜŞTERİ LİSTESİ", new ActionListener() {
            
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                jLabel2.setText("Müşteri Listeleme İşlemi");
                
                panel_sag1.removeAll();
                panel_sag1.add(new MusteriListeleme());
                        
                panel_sag1.repaint();
                panel_sag1.revalidate();
            }
        });
        
        SVMenu musteriEkle = new SVMenu(iconEkle, "MÜŞTERİ EKLE", new ActionListener() {
            
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                jLabel2.setText("Müşteri Ekleme İşlemi");
                
                panel_sag1.removeAll();
                panel_sag1.add(new Musteri_Ekle());
                        
                panel_sag1.repaint();
                panel_sag1.revalidate();
            }
        });
        
        SVMenu tumAracListeleme = new SVMenu(iconListele, "BÜTÜN ARAÇLARI LİSTELE", new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                jLabel2.setText("Bütün Araçları Listeleme İşlemi");
                
                panel_sag1.removeAll();
                panel_sag1.add(new ButunAracListeleme());   
                panel_sag1.repaint();
                panel_sag1.revalidate();
                
            }
        });
        
        
        SVMenu bosAracListeleme = new SVMenu(iconListele, "BOŞ ARAÇLARI LİSTELE", new ActionListener() {
            
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                jLabel2.setText("Boş Araçları Listeleme İşlemi");
                
                panel_sag1.removeAll();
                panel_sag1.add(new BosAracListeleme());
                        
                panel_sag1.repaint();
                panel_sag1.revalidate();
            }
        });
        
        SVMenu kiralikAracListeleme = new SVMenu(iconListele, "KİRALIK ARAÇLARI LİSTELE", new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                jLabel2.setText("Kiralık Araçları Listeleme İşlemi");
                
                panel_sag1.removeAll();
                panel_sag1.add(new KiralikAracListeleme());   
                panel_sag1.repaint();
                panel_sag1.revalidate();
                
            }
        });
        
        
        SVMenu hesap_eks = new SVMenu(iconListele, "MÜŞTERİ HESAP EKSTRESİ", new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                jLabel2.setText("Ekstre Görüntüleme İşlemi");
                
                
                JButton buton4=new JButton();  
                buton4.setBackground(new java.awt.Color(204, 204, 204));
                buton4.setPreferredSize(new java.awt.Dimension(50, 30));
                buton4.setText("SEÇ");
                
                MusteriListeleme musteri = new MusteriListeleme();
                
                panel_sag1.removeAll();
                panel_sag1.add(buton4, java.awt.BorderLayout.PAGE_END);
                panel_sag1.add(musteri);   
                panel_sag1.repaint();
                panel_sag1.revalidate();
                
                buton4.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent e){ 
                        
                        panel_sag1.removeAll();
                        panel_sag1.add(new MusHesapEks(musteri.temp_musteriTC)); 
                        panel_sag1.repaint();
                        panel_sag1.revalidate();
                        
                    }
                }); 
                
            }
        });
        
        
        
        SVMenu fatura = new SVMenu(iconFatura, "FATURA KES", new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                jLabel2.setText("Fatura Kesme İşlemi");
                
                JButton buton5=new JButton();  
                buton5.setBackground(new java.awt.Color(204, 204, 204));
                buton5.setPreferredSize(new java.awt.Dimension(50, 30));
                buton5.setText("SEÇ");
                
                MusteriListeleme musteri = new MusteriListeleme();
                
                panel_sag1.removeAll();
                panel_sag1.add(buton5, java.awt.BorderLayout.PAGE_END);
                panel_sag1.add(musteri);   
                panel_sag1.repaint();
                panel_sag1.revalidate();
                
                buton5.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent e){ 
                        
                        new Fatura(musteri.temp_musteriAd,musteri.temp_musteriSoyad,musteri.temp_musteriTC,musteri.temp_tel_no,musteri.temp_adres,musteri.temp_sehir).setVisible(true);
                        
                    }
                }); 
                
            }
        });
        
        
        
        
        SVMenu tahsilat_yap = new SVMenu(iconEkle, "TAHSİLAT YAP", new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                jLabel2.setText("Tahsilat Yapma İşlemi");
                
                
                JButton buton6=new JButton();  
                buton6.setBackground(new java.awt.Color(204, 204, 204));
                buton6.setPreferredSize(new java.awt.Dimension(50, 30));
                buton6.setLocation(1150, 700);
                buton6.setText("SEÇ");
                
                MusteriListeleme musteri = new MusteriListeleme();
                
                panel_sag1.removeAll();
                panel_sag1.add(buton6, java.awt.BorderLayout.PAGE_END);
                panel_sag1.add(musteri);   
                panel_sag1.repaint();
                panel_sag1.revalidate();
                
                buton6.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent e){ 
                        
                        new Tahsilat(musteri.temp_musteriAd,musteri.temp_musteriSoyad,musteri.temp_musteriTC,musteri.bakiye).setVisible(true);
                        
                    }
                }); 
                
            }
        });
        
        SVMenu odeme_yap = new SVMenu(iconEkle, "ODEME YAP", new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                jLabel2.setText("Ödeme Yapma İşlemi");
                 
                JButton buton6=new JButton();  
                buton6.setBackground(new java.awt.Color(204, 204, 204));
                buton6.setPreferredSize(new java.awt.Dimension(50, 30));
                buton6.setText("SEÇ");
                
                MusteriListeleme musteri = new MusteriListeleme();
                
                panel_sag1.removeAll();
                panel_sag1.add(buton6, java.awt.BorderLayout.PAGE_END);
                panel_sag1.add(musteri);   
                panel_sag1.repaint();
                panel_sag1.revalidate();
                
                buton6.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent e){ 
                        
                        new Odeme(musteri.temp_musteriAd,musteri.temp_musteriSoyad,musteri.temp_musteriTC,musteri.bakiye).setVisible(true);
                        
                    }
                }); 
                
            }
        });
        
        SVMenu cikis = new SVMenu(iconCikis, "ÇIKIŞ", new ActionListener() {
            
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                setVisible(false);
                new GirisEkranı().setVisible(true);
            }
        });
        
        
        
        SVMenu aracListeleme = new SVMenu(iconListele, "LİSTELEME İŞLEMLERİ", null, tumAracListeleme,bosAracListeleme, kiralikAracListeleme,kontrat_listele);
        
        SVMenu musteriİslemleri = new SVMenu(iconDriver, "MÜŞTERİ-FİRMA İŞLEMLERİ", null, musteriListele,musteriEkle,hesap_eks);
        
        SVMenu tahsilatİslemleri = new SVMenu(iconOdeme, "TAHSİLAT İŞLEMLERİ", null, tahsilat_yap);
        
        SVMenu odemeİslemleri = new SVMenu(iconOdeme, "ÖDEME İŞLEMLERİ", null, odeme_yap);
        
        
        
        addMenu(musteriİslemleri,aracListeleme,fatura,tahsilatİslemleri,odemeİslemleri,cikis);
        
    }
    
    
   
    
    private void addMenu(SVMenu... menu){
        
        for(int i=0; i<menu.length; i++){
            
            menu_1.add(menu[i]);
            
            ArrayList<SVMenu> subMenu = menu[i].getSubMenu();
            for (SVMenu m : subMenu) {
                addMenu(m);
            }
            
        }
        
        menu_1.revalidate();
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_ust1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        yetki_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        panel_sol1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        menu_1 = new javax.swing.JPanel();
        panel_sag1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_ust1.setBackground(new java.awt.Color(0, 0, 153));
        panel_ust1.setPreferredSize(new java.awt.Dimension(980, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_circled_menu_50px.png"))); // NOI18N

        yetki_txt.setEditable(false);
        yetki_txt.setBackground(new java.awt.Color(0, 0, 153));
        yetki_txt.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        yetki_txt.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_ust1Layout = new javax.swing.GroupLayout(panel_ust1);
        panel_ust1.setLayout(panel_ust1Layout);
        panel_ust1Layout.setHorizontalGroup(
            panel_ust1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ust1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(219, 219, 219)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 590, Short.MAX_VALUE)
                .addComponent(yetki_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_ust1Layout.setVerticalGroup(
            panel_ust1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ust1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel_ust1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(yetki_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ust1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panel_ust1, java.awt.BorderLayout.PAGE_START);

        panel_sol1.setBackground(new java.awt.Color(204, 204, 204));
        panel_sol1.setPreferredSize(new java.awt.Dimension(300, 645));

        jScrollPane2.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane2.setBorder(null);

        menu_1.setBackground(new java.awt.Color(204, 204, 204));
        menu_1.setLayout(new javax.swing.BoxLayout(menu_1, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(menu_1);

        javax.swing.GroupLayout panel_sol1Layout = new javax.swing.GroupLayout(panel_sol1);
        panel_sol1.setLayout(panel_sol1Layout);
        panel_sol1Layout.setHorizontalGroup(
            panel_sol1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        panel_sol1Layout.setVerticalGroup(
            panel_sol1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
        );

        getContentPane().add(panel_sol1, java.awt.BorderLayout.LINE_START);

        panel_sag1.setBackground(new java.awt.Color(255, 255, 255));
        panel_sag1.setPreferredSize(new java.awt.Dimension(1303, 864));
        panel_sag1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panel_sag1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1591, 1131));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SVGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SVGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SVGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SVGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SVGiris(null).setVisible(true);
            }
        });
    }

    
    class buttonListener implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            click = true;
        }
    }
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel menu_1;
    private javax.swing.JPanel panel_sag1;
    private javax.swing.JPanel panel_sol1;
    private javax.swing.JPanel panel_ust1;
    private javax.swing.JTextField yetki_txt;
    // End of variables declaration//GEN-END:variables
}


