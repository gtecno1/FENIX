/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenix2;

import Conexion_Base_de_Datos.conexionMySQL;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Acceso1 extends javax.swing.JFrame {
 /**
     * Creates new form Usuario
     */
    public Acceso1() {
       
        this.setUndecorated(true);
        initComponents();
       i();
        setTitle("Ingresar  ");
        setLocationRelativeTo(null);
        recusuario();  
        
    }
    
     private static final char[] CONSTS_HEX = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f' }; 
     public static String encriptaEnMD5(String stringAEncriptar)  
     {        
         try        {     
             MessageDigest msgd = MessageDigest.getInstance("MD5");      
             byte[] bytes = msgd.digest(stringAEncriptar.getBytes());     
             StringBuilder strbCadenaMD5 = new StringBuilder(2 * bytes.length); 
             for (int i = 0; i < bytes.length; i++)    
             {            
                 int bajo = (int)(bytes[i] & 0x0f);  
             int alto = (int)((bytes[i] & 0xf0) >> 4);    
             strbCadenaMD5.append(CONSTS_HEX[alto]);      
             strbCadenaMD5.append(CONSTS_HEX[bajo]);           }  
             return strbCadenaMD5.toString();      
         } catch (NoSuchAlgorithmException e) {         
             return null;        }  
     } 
     void i(){
    Image icon;
    icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconu/ful4.png"));
   
            
            
    setIconImage(icon);
    setVisible(true);
  }
    void entrar() throws SQLException{
    
     String usuario=txtusuario.getText();
     String password=txtpass.getText();
    
       if((usuario.isEmpty())||(password.isEmpty()))
       {
         JOptionPane.showMessageDialog(null, "Ingrese su nombre de usuario y contraseña");
       }
       else
       {  conexionMySQL mysql = new conexionMySQL();
          Connection cn = (Connection) mysql.Conectar();
         Statement st = (Statement) cn.createStatement();
 
       
       try
       {
           ResultSet rd = st.executeQuery("SELECT * FROM usuario  WHERE usuario ='"+encriptaEnMD5(usuario)+"' AND  contraseña='"+encriptaEnMD5(password)+"' AND   rol='"+4+"'  " );
         rd.last();
          
            
        

         int encontrado1=rd.getRow();
         
         if(encontrado1==1)
             
         {  
           new Thread(new incorrecto4()).start();  
         }
         ResultSet rj = st.executeQuery("SELECT * FROM usuario  WHERE usuario ='"+encriptaEnMD5(usuario)+"' AND  contraseña='"+encriptaEnMD5(password)+"' AND   rol='"+5+"'  " );
         rj.last();
          
            
        

         int encontrado2=rj.getRow();
         
         if(encontrado2==1)
             
         {  
           new Thread(new incorrecto5()).start();  
             String   SQL = " SELECT * FROM usuario WHERE usuario ='"+encriptaEnMD5(usuario)+"' AND  contraseña='"+encriptaEnMD5(password)+"'  AND   activo ='"+0+"'"; 
         
          Statement sv = null;
            sv = cn.createStatement();
            ResultSet rv = sv.executeQuery(SQL);
            rv.next(); 
           
         
       
          String id=(rv.getString("id$usu"));
           String SQL0= "UPDATE usuario set activo=? WHERE id$usu=?";
              PreparedStatement psd0 = cn.prepareStatement(SQL0);
            psd0.setString(1, "1");
             psd0.setString(2, id);
            psd0.executeUpdate();
           
           
         }
         ResultSet rs = st.executeQuery("SELECT * FROM usuario  WHERE usuario ='"+encriptaEnMD5(usuario)+"' AND  contraseña='"+encriptaEnMD5(password)+"'     " );
         rs.last();
          
            
        

         int encontrado=rs.getRow();
         
         if(encontrado==1)
             
         {  
             
             
         
            String   SQL = " SELECT * FROM usuario WHERE usuario ='"+encriptaEnMD5(usuario)+"' AND  contraseña='"+encriptaEnMD5(password)+"'  AND   rol <>'"+5+"'"; 
         
          Statement sv = null;
            sv = cn.createStatement();
            ResultSet rv = sv.executeQuery(SQL);
            rv.next(); 
           
         
         rs.next();
          String id=(rv.getString("id$usu"));
           String SQL0= "UPDATE usuario set activo=? WHERE id$usu=?";
              PreparedStatement psd0 = cn.prepareStatement(SQL0);
            psd0.setString(1, "1");
             psd0.setString(2, id);
            psd0.executeUpdate();
           
         
             
            
            this.dispose();
           new Thread(new correcto()).start();
          
           
           
            
         }
         
         
         else
         {
            JOptionPane.showMessageDialog(null,"nombre de usuario o contraseña incorrecta","ERROR", JOptionPane.ERROR_MESSAGE);
        txtusuario.setText("");
        txtpass.setText("");
         }

         rs.close();
         st.close();
       }
       catch (Exception e)
      {
      }
       } 
   
      
      
       } 
     
    void recusuario(){
    conexionMySQL cc = new conexionMySQL();
    Connection cn = cc.Conectar();
    String SQL="Select * from rec_usuario";
    try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next())
            {
                txtusuario.setText(rs.getString("rusuario"));
            }
            } catch (Exception ex) {
            
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        BtnSalir = new javax.swing.JButton();
        BtnEntrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INICIO DE CUENTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Usuarios.png"))); // NOI18N
        jLabel1.setText("Usuario");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(110, 20, 130, 50);

        txtusuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txtusuario);
        txtusuario.setBounds(80, 70, 200, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/lock.png"))); // NOI18N
        jLabel2.setText("Contraseña");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel2);
        jLabel2.setBounds(130, 100, 120, 32);

        txtpass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txtpass);
        txtpass.setBounds(80, 140, 200, 30);

        BtnSalir.setFont(new java.awt.Font("Tahoma", 1, 10));
        BtnSalir.setText("SALIR-->");
        BtnSalir.setContentAreaFilled(false);
        BtnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(BtnSalir);
        BtnSalir.setBounds(250, 210, 89, 20);

        BtnEntrar.setBackground(new java.awt.Color(0, 0, 0));
        BtnEntrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        BtnEntrar.setText("ENTRAR");
        BtnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnEntrarMouseClicked(evt);
            }
        });
        BtnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEntrarActionPerformed(evt);
            }
        });
        BtnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnEntrarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BtnEntrarKeyReleased(evt);
            }
        });
        jPanel2.add(BtnEntrar);
        BtnEntrar.setBounds(140, 180, 83, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 10));
        jButton1.setText(" CUENTA #");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(20, 210, 90, 20);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEntrarActionPerformed
     
        try {
            entrar();
        } catch (SQLException ex) {
            Logger.getLogger(Acceso1.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }//GEN-LAST:event_BtnEntrarActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
       dispose();
      
    }//GEN-LAST:event_BtnSalirActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.dispose();
    ConfiCuenta s=new ConfiCuenta();
s.setVisible(true);

}//GEN-LAST:event_jButton1ActionPerformed

private void BtnEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnEntrarKeyPressed

 
}//GEN-LAST:event_BtnEntrarKeyPressed

private void BtnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEntrarMouseClicked
 // TODO add your handling code here:
}//GEN-LAST:event_BtnEntrarMouseClicked

private void BtnEntrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnEntrarKeyReleased
// TODO add your handling code here:
}//GEN-LAST:event_BtnEntrarKeyReleased

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
            java.util.logging.Logger.getLogger(Acceso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acceso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acceso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acceso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Acceso1().setVisible(true);
                
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEntrar;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
