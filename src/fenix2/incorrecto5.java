package fenix2;

import Conexion_Base_de_Datos.conexionMySQL;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class incorrecto5
  extends JFrame
  implements Runnable
{
  private int x = 0;
  int y = 92;
  int velocidad = 30;
  conexionMySQL cc = new conexionMySQL();
  Connection cn = this.cc.Conectar();
  Thread Hilo1;
  Thread Hilo2;
  private JButton jButton1;
  private JButton jButton2;
  private JLabel jLabel1;
  private JPanel jPanel1;
  
  public incorrecto5()
  {
    setUndecorated(true);
    initComponents();
    i();
    setSize(this.x, this.y);
    
    setLocationRelativeTo(null);
  }
  
  void i()
  {
    Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/ful3.png"));
    
    setIconImage(icon);
    setVisible(true);
  }
  
  private void initComponents()
  {
    this.jPanel1 = new JPanel();
    this.jLabel1 = new JLabel();
    this.jButton1 = new JButton();
    this.jButton2 = new JButton();
    
    setDefaultCloseOperation(3);
    
    this.jPanel1.setBackground(new Color(102, 204, 255));
    this.jPanel1.setBorder(BorderFactory.createEtchedBorder(new Color(0, 0, 0), new Color(0, 0, 0)));
    this.jPanel1.setLayout(null);
    
    this.jLabel1.setFont(new Font("Tahoma", 1, 18));
    this.jLabel1.setText("Deseas solicitar rol.?");
    this.jPanel1.add(this.jLabel1);
    this.jLabel1.setBounds(30, 20, 190, 22);
    
    this.jButton1.setBackground(new Color(0, 0, 0));
    this.jButton1.setForeground(new Color(255, 255, 255));
    this.jButton1.setText("Si");
    this.jButton1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        incorrecto5.this.jButton1ActionPerformed(evt);
      }
    });
    this.jPanel1.add(this.jButton1);
    this.jButton1.setBounds(30, 60, 70, 23);
    
    this.jButton2.setBackground(new Color(0, 0, 0));
    this.jButton2.setForeground(new Color(255, 255, 255));
    this.jButton2.setText("No");
    this.jButton2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        incorrecto5.this.jButton2ActionPerformed(evt);
      }
    });
    this.jPanel1.add(this.jButton2);
    this.jButton2.setBounds(150, 60, 70, 23);
    
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, 251, 32767));
    
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, 92, -2));
    
    pack();
  }
  
  private void jButton1ActionPerformed(ActionEvent evt)
  {
    try
    {
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM usuario  WHERE activo ='1' ");
      rs.last();
      
      int encontrado = rs.getRow();
      if (encontrado == 1)
      {
        String SQL = " SELECT * FROM usuario WHERE       activo ='1'";
        
        Statement sv = null;
        sv = this.cn.createStatement();
        ResultSet rv = sv.executeQuery(SQL);
        rv.next();
        
        String id = rv.getString("id$usu");
        String nob = rv.getString("nombre");
        String Ape = rv.getString("apellido");
        
        ResultSet rc = st.executeQuery("SELECT * FROM notificacion  WHERE rol ='1'      ");
        rc.last();
        
        int encontradoc = rc.getRow();
        if (encontradoc == 1)
        {
          String SQL0 = "UPDATE notificacion set rol=? WHERE rol=?";
          PreparedStatement psd0 = this.cn.prepareStatement(SQL0);
          psd0.setString(1, "0");
          psd0.setString(2, "1");
          psd0.executeUpdate();
        }
        String SQL1 = "INSERT INTO notificacion (nombre,apellido,rol) VALUES (?,?,?)";
        PreparedStatement psd1 = this.cn.prepareStatement(SQL1);
        psd1.setString(1, nob);
        psd1.setString(2, Ape);
        psd1.setString(3, "1");
        psd1.executeUpdate();
        
        String SQL0 = "UPDATE usuario set activo=? WHERE activo=?";
        PreparedStatement psd0 = this.cn.prepareStatement(SQL0);
        psd0.setString(1, "0");
        psd0.setString(2, "1");
        psd0.executeUpdate();
        
       
        
        cerrar();
      }
      else
      {
        JOptionPane.showMessageDialog(null, "0", "ERROR", 0);
      }
      rs.close();
      st.close();
    }
    catch (Exception e) {}
  }
  
  private void jButton2ActionPerformed(ActionEvent evt)
  {
    try
    {
      String SQL0 = "UPDATE usuario set activo=? WHERE activo=?";
      PreparedStatement psd0 = this.cn.prepareStatement(SQL0);
      psd0.setString(1, "0");
      psd0.setString(2, "1");
      psd0.executeUpdate();
    }
    catch (SQLException ex)
    {
      Logger.getLogger(incorrecto5.class.getName()).log(Level.SEVERE, null, ex);
    }
    cerrar();
  }
  
  public static void main(String[] args)
  {
   
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new Thread(new incorrecto5()).start();
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
        this.x -= 40;
        if (this.x == 100000) {
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
  
  public void run()
  {
    try
    {
      setVisible(true);
      for (int i = 0; i < 7; i++)
      {
        Thread.sleep(this.velocidad);
        setSize(this.x, this.y);
        setLocationRelativeTo(null);
        this.x += 40;
        if (this.x == 100000) {
          for (int j = 0; j < 6; j++)
          {
            Thread.sleep(this.velocidad);
            setSize(this.x, this.y);
            setLocationRelativeTo(null);
            this.y += 100;
          }
        }
      }
    }
    catch (InterruptedException e) {}
  }
}
