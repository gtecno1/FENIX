/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenix2;

import Conexion_Base_de_Datos.conexionMySQL;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CRIcto.pro
 */
public class Control$comenzales extends javax.swing.JFrame {
int Seleccion;
DefaultTableModel model;
    conexionMySQL cc=new conexionMySQL();
                Connection cn=cc.Conectar();
    /**
     * Creates new form Control$comenzales
     */
    public Control$comenzales() {
        setUndecorated(true);
        initComponents();
        i();
         cargar2("");
         contar("");
     bloqueo();
     DesbP();
     LBF.setText(fechaActual());
     this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
    }
    void i(){
    Image icon;
    icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/ful3.png"));
    
            
            
    setIconImage(icon);
    setVisible(true);
  }
 public static String fechaActual(){

Date fecha= new Date();
SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MMM/yyy");
return formatoFecha.format(fecha);
} 
void bloqueo(){
    jButton1.setEnabled(false);     
 }
   void DesbP(){
        try {
            String Cusu,id;
          String  SQL = " SELECT * FROM usuario WHERE activo = " + 1;

                    Statement st = null;
                    st = cn.createStatement();
                    ResultSet rs = st.executeQuery(SQL);
                    rs.next();
                 
                   Cusu=(rs.getString("id$usu"));
                   
         String SQL2 = " SELECT * FROM prorolact WHERE Activo = " +Cusu;
           Statement st2 = null;
                    st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(SQL2);
                    rs2.next();
                  
          id=(rs2.getString("idacticon"));
          
         
            if(id.equals("1"))
                {
           jButton1.setEnabled(true);   
            }
          if(id.equals("8"))
                {
         jButton1.setEnabled(false);   
            }
          
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
  void cargar(String valor){ 
   
    
     

   String sql="SELECT * FROM persona where  idCedula LIKE '%"+valor+"%'";
  

                
                try {
           Statement st = cn.createStatement();
               ResultSet rs=st.executeQuery(sql);
               
               while(rs.next()){

LBC.setText(rs.getString("idCedula"));
LBN.setText(rs.getString("nombre"));
LBA.setText(rs.getString("apellido"));

  

              

                
               }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
             
}
  void Guardar(){
          conexionMySQL cc = new conexionMySQL();
        Connection cn = cc.Conectar();

        String  Car,nombre,apelli,fecha,tr,cd,tm,fh,es;
        String SQL;

       
        nombre=LBN.getText();
        apelli=LBA.getText();
        Car=LBC.getText();
        fecha=LBF.getText();
        cd=LBC.getText();
    String cd2=TxtCedu.getText();
        PreparedStatement psd;

        
  switch(Seleccion){
      
       case 1:
       
           if(cd2.isEmpty() )
       {
          new Thread(new vacio()).start();
       }
        else{
               
           if(cd.equals(cd2)){
                
               
                    SQL="INSERT INTO comedor(Ced,nomb,Apelli,fecha)VALUES (?,?,?,?)";
                    try{

                        psd = cn.prepareStatement(SQL);

                        psd.setString(1,cd);
                       
                        psd.setString(2,nombre);
                        psd.setString(3,apelli);
                        psd.setString(4,fecha);
                        

                        int m= psd.executeUpdate();

                        if(m>0){
                           contar("");
                            new Thread(new correcto1()).start();
        
                        }}
                        catch(SQLException ex)  {

                            new Thread(new incorrecto()).start();

                        }
           }else{
                new Thread(new cedula()).start();
           }
           }
                  
                   break;    
                  
 }    }
    void cargar2(String valor){ 
   String [] titulos={"FECHA","CEDULA","NOMBRES","APELLIDOS"}; 
   String [] registros=new  String [4];
   String sql="SELECT *  FROM comedor where CONCAT (Ced) LIKE '%"+valor+"%'";
   
  
   model=new DefaultTableModel(null,titulos);
    conexionMySQL cc=new conexionMySQL();
       Connection cn=cc.Conectar();
                
                try {
             Statement st = cn.createStatement();
               ResultSet rs=st.executeQuery(sql);
               while(rs.next()){
                 
                   registros [0]=rs.getString("fecha");
                    registros [1]=rs.getString("Ced");
                   
                   registros [2]=rs.getString("nomb");
                   registros [3]=rs.getString("apelli");
                 
                 
                   
                   model.addRow(registros);
              Tablacon.setModel(model);
                  
           
          
                   
               }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
   }      
     void contar(String valor1){ 
   
   String sql="SELECT count(*)  FROM comedor where CONCAT (Ced) LIKE '%"+valor1+"%'";
   
  
 
    
                
                try {
             Statement st = cn.createStatement();
               ResultSet rs=st.executeQuery(sql);
               while(rs.next()){
                 
                  co.setText(rs.getString("count(*)"));
                    
                 
                   
                 
                  
           
          
                   
               }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
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
        TxtCedu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LBF = new javax.swing.JLabel();
        LBN = new javax.swing.JLabel();
        LBC = new javax.swing.JLabel();
        LBA = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablacon = new javax.swing.JTable();
        Txtbusque = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        co = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(null);

        TxtCedu.setFont(new java.awt.Font("Tahoma", 1, 14));
        TxtCedu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtCeduKeyReleased(evt);
            }
        });
        jPanel1.add(TxtCedu);
        TxtCedu.setBounds(30, 360, 180, 32);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/Imagen4.png"))); // NOI18N
        jButton1.setText("ACEPTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(50, 400, 140, 60);

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jLabel1.setText("FECHA:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 10, 50, 20);

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jLabel2.setText("CEDULA:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 60, 52, 17);

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jLabel3.setText("NOMBRE:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 110, 60, 17);

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jLabel4.setText("APELLIDO:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 160, 70, 17);

        LBF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LBF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(LBF);
        LBF.setBounds(60, 10, 120, 30);

        LBN.setFont(new java.awt.Font("Tahoma", 1, 18));
        LBN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(LBN);
        LBN.setBounds(70, 100, 120, 30);

        LBC.setFont(new java.awt.Font("Tahoma", 1, 18));
        LBC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(LBC);
        LBC.setBounds(70, 50, 120, 30);

        LBA.setFont(new java.awt.Font("Tahoma", 1, 18));
        LBA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(LBA);
        LBA.setBounds(70, 150, 120, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/RDR2.png"))); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 0, 200, 230);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 100, 200, 230);

        jPanel4.setBackground(new java.awt.Color(102, 204, 255));
        jPanel4.setLayout(null);

        Tablacon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tablacon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tablacon);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(0, 46, 550, 200);

        Txtbusque.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Txtbusque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtbusqueKeyReleased(evt);
            }
        });
        jPanel4.add(Txtbusque);
        Txtbusque.setBounds(10, 11, 164, 29);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/search.png"))); // NOI18N
        jLabel5.setText("BUSQUEDA");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(178, 12, 102, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("TOTAL:");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(380, 240, 60, 40);

        co.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(co);
        co.setBounds(440, 240, 110, 40);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/EWW.png"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel9);
        jLabel9.setBounds(0, 0, 550, 280);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(230, 100, 550, 280);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setText("CEDULA");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(90, 340, 70, 17);

        jLabel12.setBackground(new java.awt.Color(102, 204, 255));
        jLabel12.setFont(new java.awt.Font("Bodoni MT Black", 1, 24));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("C  O  N  T  R  O  L   D E L   C  O  M  E  D  O  R");
        jLabel12.setOpaque(true);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(0, 40, 800, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton2.setText("PRINCIPAL#");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(570, 410, 110, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("SALIDA-->");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(680, 410, 100, 40);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel13.setText("DATOS DEL ESTUDIANTE");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel13.setOpaque(true);
        jPanel1.add(jLabel13);
        jLabel13.setBounds(0, 80, 230, 20);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("CONSULTA DE COMENSALES");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel14.setOpaque(true);
        jPanel1.add(jLabel14);
        jLabel14.setBounds(370, 80, 260, 20);

        jLabel10.setBackground(new java.awt.Color(0, 204, 255));
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 102), new java.awt.Color(255, 102, 102)));
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(680, 410, 90, 40);

        jLabel11.setBackground(new java.awt.Color(0, 204, 255));
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(580, 410, 90, 40);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/WW.png"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, -10, 800, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtCeduKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCeduKeyReleased
   cargar(TxtCedu.getText());
    }//GEN-LAST:event_TxtCeduKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Seleccion=1;
        Guardar();
        cargar2("");
        
                LBC.setText("");
                LBN.setText("");
                        LBA.setText("");
                        TxtCedu.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TxtbusqueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtbusqueKeyReleased
cargar2(Txtbusque.getText());
contar(Txtbusque.getText());

    }//GEN-LAST:event_TxtbusqueKeyReleased

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 try
       {
            Statement st = (Statement) cn.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM usuario  WHERE activo ='"+1+"'  AND   activo <>'"+0+"'  " );
         rs.last();
          
            
        

         int encontrado=rs.getRow();
         
         if(encontrado==1)
             
         {  
             
             
         
          
           String SQL0= "UPDATE usuario set activo=? WHERE activo=?";
              PreparedStatement psd0 = cn.prepareStatement(SQL0);
            psd0.setString(1, "0");
             psd0.setString(2, "1");
            psd0.executeUpdate();
           
         
           
            
            this.dispose();
            
         }
         
         
         else
         {
            JOptionPane.showMessageDialog(null,"0","ERROR", JOptionPane.ERROR_MESSAGE);
      
         }

         rs.close();
         st.close();
       }
       catch (Exception e)
      {
      }
       
   
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 try
       {
            Statement st = (Statement) cn.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM usuario  WHERE activo ='"+1+"'  AND   activo <>'"+0+"'  " );
         rs.last();
          
            
        

         int encontrado=rs.getRow();
         
         if(encontrado==1)
             
         {  
             
           String   SQL = " SELECT * FROM usuario WHERE activo ='"+1+"' "; 
         
          Statement sv = null;
            sv = cn.createStatement();
            ResultSet rv = sv.executeQuery(SQL);
            rv.next(); 
           
         
        
          String id=(rv.getString("id$usu")); 
         
          
          String   SQL2 = " SELECT * FROM prorolact WHERE Activo ='"+id+"' "; 
         
          Statement sd = null;
            sd = cn.createStatement();
            ResultSet rc = sd.executeQuery(SQL2);
            rc.next(); 
         
             String id2=(rc.getString("id$3"));
             
            String SQL1= "UPDATE prorolact set Activo=? WHERE id$3=?";
              PreparedStatement psd = cn.prepareStatement(SQL1);
            psd.setString(1, "1");
             psd.setString(2, id2);
            psd.executeUpdate();
             this.dispose();
            new Thread(new Principal()).start();
      String SQL3= "UPDATE prorolact set Activo=? WHERE id$3=?";
              PreparedStatement psd2 = cn.prepareStatement(SQL3);
            psd2.setString(1, id);
             psd2.setString(2, id2);
            psd2.executeUpdate();      
         
          
          
            
           
            
         }
         
         
         else
         {
            JOptionPane.showMessageDialog(null,"0","ERROR", JOptionPane.ERROR_MESSAGE);
      
         }

         rs.close();
         st.close();
       }
       catch (Exception e)
      {
      }
       
   
  
      
       
}//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Control$comenzales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Control$comenzales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Control$comenzales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Control$comenzales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Control$comenzales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBA;
    private javax.swing.JLabel LBC;
    private javax.swing.JLabel LBF;
    private javax.swing.JLabel LBN;
    private javax.swing.JTable Tablacon;
    private javax.swing.JTextField TxtCedu;
    private javax.swing.JTextField Txtbusque;
    private javax.swing.JLabel co;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
