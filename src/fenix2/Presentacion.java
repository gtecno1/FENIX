/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Presentacion2.java
 *
 * Created on 04-ago-2016, 19:57:41
 */
package fenix2;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author GERALDO J
 */
public class Presentacion extends javax.swing.JFrame  {
Timer contador;
  int a;
  Thread Hilo2;
  Thread Hilo1;
  int velocidad = 60;
  int y = 280;
  private int x = 420;
    /** Creates new form Presentacion2 */
    public Presentacion() {
       setUndecorated(true);
        initComponents();
        
         
    setOpacity(0.9F);
    AWTUtilities.setWindowOpaque(this, false);
   
    b();
    i();
    
    setSize(this.x, this.y);
    
    setTitle("Bienvenido al sistema  ");
    setLocationRelativeTo(null);
    this.contador = new Timer(50, new claseTimer());
    this.contador.start();
    }
public void i()
  {
    Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/ful3.png"));
    
    setIconImage(icon);
    setVisible(true);
  }
     
      void b()
  {
    this.jL1.setVisible(false);
    this.jbl2.setVisible(false);
    this.jbl3.setVisible(false);
    this.jbl4.setVisible(false);
    this.jbl5.setVisible(false);
  }
  
  public class claseTimer
    implements ActionListener
  {
    public claseTimer() {}
    
    public void actionPerformed(ActionEvent e)
    {
      Presentacion.this.a = Presentacion.this.ProgressBar.getValue();
      Presentacion.this.ProgressBar.setForeground(Color.red);
      if (Presentacion.this.a < 100)
      {
        Presentacion.this.a += 1;
        if (Presentacion.this.a <= 10)
        {
          Presentacion.this.txt.setText("verificando.");
          Presentacion.this.jL1.setVisible(true);
        }
        if ((Presentacion.this.a > 10) && (Presentacion.this.a <= 20))
        {
          Presentacion.this.txt.setText("verificando..");
          Presentacion.this.jbl2.setVisible(true);
        }
        if ((Presentacion.this.a > 20) && (Presentacion.this.a <= 30))
        {
          Presentacion.this.txt.setText("verificando...");
          Presentacion.this.jbl3.setVisible(true);
        }
        if ((Presentacion.this.a > 30) && (Presentacion.this.a <= 40))
        {
          Presentacion.this.txt.setText("ajustando.");
          Presentacion.this.jbl4.setVisible(true);
        }
        if ((Presentacion.this.a > 40) && (Presentacion.this.a <= 50)) {
          Presentacion.this.txt.setText("ajustando..");
        }
        if ((Presentacion.this.a > 50) && (Presentacion.this.a <= 60))
        {
          Presentacion.this.txt.setText("datos.");
          Presentacion.this.jbl6.setVisible(false);
          Presentacion.this.jbl5.setVisible(true);
        }
        if ((Presentacion.this.a > 60) && (Presentacion.this.a <= 70)) {
          Presentacion.this.txt.setText("datos..");
        }
        if ((Presentacion.this.a > 70) && (Presentacion.this.a <= 80)) {
          Presentacion.this.txt.setText("datos...");
        }
        if ((Presentacion.this.a > 80) && (Presentacion.this.a <= 90)) {
          Presentacion.this.txt.setText("datos.");
        }
        if ((Presentacion.this.a > 90) && (Presentacion.this.a <= 100)) {
          Presentacion.this.txt.setText("listo");
        }
        Presentacion.this.ProgressBar.setValue(Presentacion.this.a);
      }
      else
      {
        Presentacion.this.contador.stop();
        Presentacion.this.cerrar();
        
        Acceso1 f = new Acceso1();
        f.setVisible(true);
      }
    }
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
        ProgressBar = new javax.swing.JProgressBar();
        txt = new javax.swing.JLabel();
        jL1 = new javax.swing.JLabel();
        jbl3 = new javax.swing.JLabel();
        jbl2 = new javax.swing.JLabel();
        jbl4 = new javax.swing.JLabel();
        jbl5 = new javax.swing.JLabel();
        jbl6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setLayout(null);
        jPanel1.add(ProgressBar);
        ProgressBar.setBounds(50, 230, 330, 10);

        txt.setFont(new java.awt.Font("Tahoma", 1, 11));
        txt.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt);
        txt.setBounds(50, 200, 100, 16);

        jL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/HHL.png"))); // NOI18N
        jPanel1.add(jL1);
        jL1.setBounds(-10, -10, 110, 100);

        jbl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/HH6.png"))); // NOI18N
        jPanel1.add(jbl3);
        jbl3.setBounds(60, 10, 140, 100);

        jbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/DD.png"))); // NOI18N
        jPanel1.add(jbl2);
        jbl2.setBounds(20, 0, 120, 100);

        jbl4.setIcon(new javax.swing.ImageIcon("D:\\G2.png")); // NOI18N
        jPanel1.add(jbl4);
        jbl4.setBounds(100, 40, 170, 100);

        jbl5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/GG.png"))); // NOI18N
        jPanel1.add(jbl5);
        jbl5.setBounds(180, 120, 86, 70);

        jbl6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/GG2.png"))); // NOI18N
        jPanel1.add(jbl6);
        jbl6.setBounds(190, 120, 74, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\ff.png")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(280, 30, 150, 170);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setText("C N A E");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(200, 190, 60, 17);

        jLabel3.setText("2015-2016");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(200, 250, 60, 14);

        jLabel4.setText("version 2.0 ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 250, 70, 14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
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
            java.util.logging.Logger.getLogger(Presentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Presentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Presentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Presentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
             new Presentacion().setVisible(true);
            }
        });
        
    }
     void cerrar()
  {
    try
    {
      setVisible(true);
      for (int i = 0; i < 7; i++)
      {
        Thread.sleep(this.velocidad);
        setSize(this.x, this.y);
        setLocationRelativeTo(null);
        this.x -= 100;
        if (this.x == 900) {
          for (int j = 0; j < 6; j++)
          {
            Thread.sleep(this.velocidad);
            setSize(this.x, this.y);
            setLocationRelativeTo(null);
            this.y -= 100;
          }
        }
      }
    }
    catch (InterruptedException e) {}
    dispose();
  
  
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JLabel jL1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jbl2;
    private javax.swing.JLabel jbl3;
    private javax.swing.JLabel jbl4;
    private javax.swing.JLabel jbl5;
    private javax.swing.JLabel jbl6;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
}
