package fenix2;

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
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class incorrecto
  extends JFrame
  implements Runnable
{
  private JPanel jPanel1;
  private JLabel jLabel1;
  private JButton jButton1;
  Thread Hilo2;
  Thread Hilo1;
  int velocidad = 30;
  int y = 92;
  private int x = 0;
  
  public incorrecto()
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
    
    setDefaultCloseOperation(3);
    
    this.jPanel1.setBackground(new Color(102, 204, 255));
    this.jPanel1.setBorder(BorderFactory.createEtchedBorder(new Color(0, 0, 0), new Color(0, 0, 0)));
    this.jPanel1.setLayout(null);
    
    this.jLabel1.setFont(new Font("Tahoma", 1, 18));
    this.jLabel1.setText("Imposible x");
    this.jPanel1.add(this.jLabel1);
    this.jLabel1.setBounds(70, 20, 160, 22);
    
    this.jButton1.setBackground(new Color(0, 0, 0));
    this.jButton1.setForeground(new Color(255, 255, 255));
    this.jButton1.setText("Seguir");
    this.jButton1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        incorrecto.this.jButton1ActionPerformed(evt);
      }
    });
    this.jPanel1.add(this.jButton1);
    this.jButton1.setBounds(90, 60, 70, 23);
    
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, 251, 32767));
    
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, 92, -2));
    
    pack();
  }
  
  private void jButton1ActionPerformed(ActionEvent evt)
  {
    cerrar();
  }
  
  public static void main(String[] args)
  {
    
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new Thread(new incorrecto()).start();
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
