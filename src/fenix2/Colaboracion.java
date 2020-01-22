/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Colaboracion.java
 *
 * Created on 20-feb-2016, 15:03:07
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Geraldo Andres
 */
public class Colaboracion extends javax.swing.JFrame {
    public static String fechaActual(){

Date fecha= new Date();
SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MMM/yyy");
return formatoFecha.format(fecha);
} 
int Seleccion=1;
DefaultTableModel model;
    conexionMySQL cc=new conexionMySQL();
                Connection cn=cc.Conectar();
   String SQL;             
    public Colaboracion() {
        setUndecorated(true);
        initComponents();
        i();
         Bloqueo();
         
        DesbP();
        cargar2("");
        contar();
        JBF.setText(fechaActual());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
    }
    void i(){
    Image icon;
    icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/ful3.png"));
   
            
            
    setIconImage(icon);
    setVisible(true);
  }
   void Bloqueo(){
    btnA.setEnabled(false);       
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
                  
          id=(rs2.getString("idacticol"));
          
         
            if(id.equals("1"))
                {
           btnA.setEnabled(true);   
            }
          if(id.equals("8"))
                {
         btnA.setEnabled(false);   
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

JBC.setText(rs.getString("idCedula"));
JBN.setText(rs.getString("nombre"));
JBA.setText(rs.getString("apellido"));
JBS.setText(rs.getString("sexo"));
JBSC.setText(rs.getString("seccion"));
   

              

                
               }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
             
}
  void Guardar(){
          
String co=JBC.getText();
String cd=txtbu.getText();
 String col= txtCola.getText();
      
        PreparedStatement psd;

        
  switch(Seleccion){
      
       case 1:
        if(cd.isEmpty() || col.isEmpty())
       {
          new Thread(new vacio()).start();
       }
        
        else{
          if(co.equals(cd)){
              
                
               
                    SQL="INSERT INTO colaboracion1 (cedula,cantida,fecha)VALUES (?,?,?)";
                    try{

                        psd = cn.prepareStatement(SQL);

                        psd.setString(1,JBC.getText());
                        psd.setString(2,txtCola.getText());
                        psd.setString(3,JBF.getText());
                        
                        

                        int m= psd.executeUpdate();

                        if(m>0){
                           cargar2("");
                           contar();
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
   String [] titulos={"CEDULA","DINERO","FECHA"}; 
   String [] registros=new  String [3];
   String sql="SELECT * FROM colaboracion1 where CONCAT (cedula) LIKE '%"+valor+"%'";
   
  
   model=new DefaultTableModel(null,titulos);
   
                
                try {
             Statement st = cn.createStatement();
               ResultSet rs=st.executeQuery(sql);
               while(rs.next()){
                  
                   registros [0]=rs.getString("cedula");
                    registros [1]=rs.getString("cantida");
                   registros [2]=rs.getString("fecha");
                   
                 
                  
                  
                   
                   model.addRow(registros);
              TbM.setModel(model);
                  
           
          
                   
               }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
   }   
    void contar(){ 
   
   String sql="SELECT count(*)  FROM colaboracion1 ";
   
  String sql2="select SUM(cantida) from colaboracion1";
 
    
                
                try {
                     Statement st1 = cn.createStatement();
               ResultSet rs1=st1.executeQuery(sql2);
               while(rs1.next()){
                   col.setText(rs1.getString("SUM(cantida)")); 
               }
             Statement st = cn.createStatement();
               ResultSet rs=st.executeQuery(sql);
               while(rs.next()){
                 
                  co.setText(rs.getString("count(*)"));
                    
                                  
               }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
   }     
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbM = new javax.swing.JTable();
        btnA = new javax.swing.JButton();
        txtCola = new javax.swing.JTextField();
        txtbu = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JBC = new javax.swing.JLabel();
        JBN = new javax.swing.JLabel();
        JBA = new javax.swing.JLabel();
        JBS = new javax.swing.JLabel();
        JBSC = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        JBF = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        co = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        col = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        FDF = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 51));

        jPanel1.setBackground(new java.awt.Color(204, 255, 102));
        jPanel1.setLayout(null);

        TbM.setFont(new java.awt.Font("Tahoma", 1, 14));
        TbM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TbM);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(340, 100, 320, 270);

        btnA.setBackground(new java.awt.Color(0, 0, 0));
        btnA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnA.setForeground(new java.awt.Color(255, 255, 255));
        btnA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/Imagen4.png"))); // NOI18N
        btnA.setText("ACEPTAR");
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });
        jPanel1.add(btnA);
        btnA.setBounds(260, 460, 150, 63);

        txtCola.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel1.add(txtCola);
        txtCola.setBounds(60, 420, 120, 28);

        txtbu.setFont(new java.awt.Font("Tahoma", 1, 14));
        txtbu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuKeyReleased(evt);
            }
        });
        jPanel1.add(txtbu);
        txtbu.setBounds(230, 420, 217, 28);

        jPanel2.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("SECCION:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 224, 60, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("APELLIDO:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 137, 70, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("SEXO:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 178, 40, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("CEDULA:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 49, 60, 15);

        JBC.setFont(new java.awt.Font("Tahoma", 1, 18));
        JBC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JBC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(JBC);
        JBC.setBounds(73, 49, 234, 28);

        JBN.setFont(new java.awt.Font("Tahoma", 1, 18));
        JBN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JBN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(JBN);
        JBN.setBounds(73, 95, 234, 24);

        JBA.setFont(new java.awt.Font("Tahoma", 1, 18));
        JBA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JBA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(JBA);
        JBA.setBounds(77, 137, 230, 28);

        JBS.setFont(new java.awt.Font("Tahoma", 1, 18));
        JBS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JBS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(JBS);
        JBS.setBounds(73, 178, 234, 28);

        JBSC.setFont(new java.awt.Font("Tahoma", 1, 18));
        JBSC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JBSC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(JBSC);
        JBSC.setBounds(77, 224, 230, 28);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("NOMBRE:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 95, 60, 15);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/RDR2.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 310, 270);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 100, 320, 270);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel7.setText("BUSCAR");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(310, 400, 70, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel8.setText("DINERO");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(90, 400, 70, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel9.setText("Bsf");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(190, 425, 20, 20);

        jLabel11.setBackground(new java.awt.Color(102, 204, 255));
        jLabel11.setFont(new java.awt.Font("Bodoni MT Black", 1, 24));
        jLabel11.setText("    C O N T R O L  DE  C O L A B O R A C I O N");
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(0, 40, 670, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton2.setText("PRINCIPAL #");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(450, 500, 110, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11));
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
        jButton3.setBounds(570, 500, 100, 40);

        JBF.setBackground(new java.awt.Color(102, 204, 255));
        JBF.setFont(new java.awt.Font("Tahoma", 1, 12));
        JBF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JBF.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        JBF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JBF.setOpaque(true);
        jPanel1.add(JBF);
        JBF.setBounds(0, 510, 140, 28);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel10.setText("CONSULTA DE COLABORADORES");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(350, 80, 298, 21);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel12.setText("DATOS DEL ESTUDIANTE");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel12.setOpaque(true);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(50, 80, 230, 20);

        jLabel13.setBackground(new java.awt.Color(0, 204, 255));
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 102), new java.awt.Color(255, 51, 51)));
        jLabel13.setOpaque(true);
        jPanel1.add(jLabel13);
        jLabel13.setBounds(570, 500, 90, 40);

        jLabel14.setBackground(new java.awt.Color(0, 204, 255));
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel14.setOpaque(true);
        jPanel1.add(jLabel14);
        jLabel14.setBounds(450, 500, 100, 40);

        co.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(co);
        co.setBounds(560, 370, 110, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Num de Colaboradores:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(390, 370, 170, 30);

        col.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(col);
        col.setBounds(560, 400, 110, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText(" Total de Bsf:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(460, 400, 100, 30);

        FDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/azul1.png"))); // NOI18N
        jPanel1.add(FDF);
        FDF.setBounds(0, -6, 670, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
Guardar();
JBC.setText("");
        JBN.setText("");
        JBA.setText("");
                JBS.setText("");
                JBSC.setText("");
                txtbu.setText("");
                txtCola.setText("");
}//GEN-LAST:event_btnAActionPerformed

private void txtbuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuKeyReleased
  cargar(txtbu.getText());
   cargar2(txtbu.getText());
}//GEN-LAST:event_txtbuKeyReleased

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
            java.util.logging.Logger.getLogger(Colaboracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Colaboracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Colaboracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Colaboracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Colaboracion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FDF;
    private javax.swing.JLabel JBA;
    private javax.swing.JLabel JBC;
    private javax.swing.JLabel JBF;
    private javax.swing.JLabel JBN;
    private javax.swing.JLabel JBS;
    private javax.swing.JLabel JBSC;
    private javax.swing.JTable TbM;
    private javax.swing.JButton btnA;
    private javax.swing.JLabel co;
    private javax.swing.JLabel col;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCola;
    private javax.swing.JTextField txtbu;
    // End of variables declaration//GEN-END:variables
}
