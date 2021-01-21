/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import bilgiler.BosAracBilgileri;
import db_islemler.ButunDBIslemleri;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author sudeg
 */
public class BosAracListeleme extends javax.swing.JPanel {

    ButunDBIslemleri islemler = new ButunDBIslemleri();
    DefaultTableModel modelim3 = new DefaultTableModel();
    String temp_plaka;
    String temp_marka;
    String temp_tip;
    String temp_vites;
    int temp_son_km;
    
    /**
     * Creates new form BosAracListeleme2
     */
    public BosAracListeleme() {
        initComponents();
        
        bosAracAramaYeri.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
        
        
        bos_arac_sayisi.setText("Bos Araçların Sayısı: "+islemler.bos_arac_sayisi());
        
        modelim3 = (DefaultTableModel) bosAracTablo.getModel();
        modelim3.setRowCount(0);
        ArrayList<BosAracBilgileri> bos_array = new ArrayList<BosAracBilgileri>();
        bos_array = islemler.bosArac_listesi();
        if (bos_array != null){
            
            for (BosAracBilgileri bos : bos_array){
                Object[] eklenenler = { bos.getPlaka(),bos.getMarka(),bos.getTipi(),bos.getVites(),
                    bos.getYakit_turu(),bos.getSon_km()};
                
                modelim3.addRow(eklenenler);
                
            }
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

        deneme = new javax.swing.JPanel();
        bosAracAramaYeri = new javax.swing.JTextField();
        bos_arac_sayisi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bosAracTablo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        deneme.setBackground(new java.awt.Color(255, 255, 255));
        deneme.setPreferredSize(new java.awt.Dimension(1282, 883));

        bosAracAramaYeri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bosAracAramaYeriKeyReleased(evt);
            }
        });

        bos_arac_sayisi.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bos_arac_sayisi.setForeground(new java.awt.Color(153, 153, 255));

        bosAracTablo.setBackground(new java.awt.Color(255, 255, 255));
        bosAracTablo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bosAracTablo.setForeground(new java.awt.Color(0, 0, 204));
        bosAracTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "PLAKA", "MARKA", "TİP", "VİTES", "YAKIT TÜRÜ", "SON KM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bosAracTablo.setGridColor(new java.awt.Color(0, 0, 0));
        bosAracTablo.setSelectionBackground(new java.awt.Color(153, 153, 255));
        bosAracTablo.setSelectionForeground(new java.awt.Color(255, 255, 255));
        bosAracTablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bosAracTabloMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(bosAracTablo);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_24px.png"))); // NOI18N
        jLabel1.setText("        ARA");

        jCheckBox1.setBackground(new java.awt.Color(0, 0, 0));
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox1.setText("Plakaya Göre Sırala");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout denemeLayout = new javax.swing.GroupLayout(deneme);
        deneme.setLayout(denemeLayout);
        denemeLayout.setHorizontalGroup(
            denemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(denemeLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(denemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(denemeLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bosAracAramaYeri, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(287, 287, 287))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1062, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(188, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, denemeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(denemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, denemeLayout.createSequentialGroup()
                        .addComponent(bos_arac_sayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, denemeLayout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(238, 238, 238))))
        );
        denemeLayout.setVerticalGroup(
            denemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(denemeLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(bos_arac_sayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(denemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bosAracAramaYeri, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(deneme, javax.swing.GroupLayout.PREFERRED_SIZE, 1432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deneme, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bosAracAramaYeriKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bosAracAramaYeriKeyReleased
        // TODO add your handling code here:

        String ara = bosAracAramaYeri.getText();
        dinamikAra(ara);

    }//GEN-LAST:event_bosAracAramaYeriKeyReleased

    private void bosAracTabloMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bosAracTabloMouseReleased
        // TODO add your handling code here:
        
        int row = bosAracTablo.getSelectedRow();
            if(row>=0){
                String temp_plaka2 = bosAracTablo.getValueAt(row, 0).toString();
                String temp_marka2 = bosAracTablo.getValueAt(row, 1).toString();
                String temp_tip2 = bosAracTablo.getValueAt(row, 2).toString();
                String temp_vites2 = bosAracTablo.getValueAt(row, 3).toString();
                int temp_son_km2 = (int)bosAracTablo.getValueAt(row, 5);
                
                
                
                this.temp_plaka = temp_plaka2;
                this.temp_marka = temp_marka2;
                this.temp_tip = temp_tip2;
                this.temp_vites = temp_vites2;
                this.temp_son_km = temp_son_km2;
                

            }
        
    }//GEN-LAST:event_bosAracTabloMouseReleased

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        
        modelim3.setRowCount(0);
        
        modelim3 = (DefaultTableModel) bosAracTablo.getModel();
        modelim3.setRowCount(0);
        ArrayList<BosAracBilgileri> bos_array = new ArrayList<BosAracBilgileri>();
        bos_array = islemler.plakaya_gore_bosArac_listesi();
        if (bos_array != null){
            
            for (BosAracBilgileri bos : bos_array){
                Object[] eklenenler = { bos.getPlaka(),bos.getMarka(),bos.getTipi(),bos.getVites(),
                    bos.getYakit_turu(),bos.getSon_km()};
                
                modelim3.addRow(eklenenler);
                
            }
        }
        
        
        if(!jCheckBox1.isSelected()){
            
            modelim3.setRowCount(0);
            
            bos_array = islemler.bosArac_listesi();
            if (bos_array != null){
            
                for (BosAracBilgileri bos : bos_array){
                    Object[] eklenenler = { bos.getPlaka(),bos.getMarka(),bos.getTipi(),bos.getVites(),
                        bos.getYakit_turu(),bos.getSon_km()};
                
                    modelim3.addRow(eklenenler);
                
                }
            }
            
        }
        
        
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    
    public void dinamikAra(String ara){
        
        TableRowSorter<DefaultTableModel> temp2 = new TableRowSorter<DefaultTableModel>(modelim3);
        
        bosAracTablo.setRowSorter(temp2);
        temp2.setRowFilter(RowFilter.regexFilter(ara));
        
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bosAracAramaYeri;
    private javax.swing.JTable bosAracTablo;
    private javax.swing.JLabel bos_arac_sayisi;
    private javax.swing.JPanel deneme;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}