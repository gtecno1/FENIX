/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * correcto.java
 *
 * Created on 25-jul-2016, 10:47:08
 */
package fenix2;

import Conexion_Base_de_Datos.conexionMySQL;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author GERALDO J
 */
public class enviado extends javax.swing.JFrame implements Runnable {
private int x=0; int y=92,velocidad=30;
    Thread Hilo1,Hilo2;
       
    /** Creates new form correcto */
    public enviado() {
        this.setUndecorated(true);
        initComponents();
        i();
      this.setSize(x,y);
         setLocationRelativeTo(null);
    }
    void i(){
    Image icon;
    icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/ful3.png"));
   
            
            
    setIconImage(icon);
    setVisible(true);
  }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SMS enviado");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 20, 120, 22);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(90, 60, 70, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
            
           
         cerrar();
            
         
          
            
           
            
    
    
       
   
  
      
}//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(enviado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(enviado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(enviado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(enviado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Thread(new enviado()).start();
            }
        });
    }
    void cerrar(){
        try{
       this.setVisible(true);
       for(int i=0;i<7;i++){
           Hilo1.sleep(velocidad);
           this.setSize(x,y);
           this.setLocationRelativeTo(null);
           x=x-40;
          if(x==100000){
           for(int j=0;j<6;j++){
           Hilo2.sleep(velocidad);
           this.setSize(x,y);
           this.setLocationRelativeTo(null);
           y=y-100;   
          } 
       }
       }
        }catch(InterruptedException e){
            
        } 
        this.dispose();
    }
    public void run(){
        try{
       this.setVisible(true);
       for(int i=0;i<7;i++){
           Hilo1.sleep(velocidad);
           this.setSize(x,y);
           this.setLocationRelativeTo(null);
           x=x+40;
          if(x==100000 ){
           for(int j=0;j<6;j++){
           Hilo2.sleep(velocidad);
           this.setSize(x,y);
           this.setLocationRelativeTo(null);
           y=y+100;   
          } 
       }
       }
        }catch(InterruptedException e){
            
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
