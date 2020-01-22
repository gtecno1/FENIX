/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * principa.java
 *
 * Created on 05-ago-2016, 18:05:11
 */
package fenix2;
import Conexion_Base_de_Datos.conexionMySQL;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.PrintStream;
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
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author GERALDO J
 */
public class Principal extends javax.swing.JFrame implements Runnable {
private int x = 270;
  int y = 500;
  int velocidad = 30;
  int Accion = 1;
  int resp = 0;
  conexionMySQL cc = new conexionMySQL();
  Connection cn = this.cc.Conectar();
  Thread Hilo1;
  Thread Hilo2;
  String co;
  String no;
  String ap;
  String ids;
  String cod12;
  String codmensa;
  DefaultTableModel model;
  String cod;
  String z;
  String SQL;
  String SQL2;
  String Cusu;
  String id;
  String j;
  String cont;
    /** Creates new form principa */
    public Principal() {
        setUndecorated(true);
    
    initComponents();
    this.pans.setVisible(false);
    this.btv.setVisible(false);
    this.jButton4.setVisible(true);
    this.pn1.setVisible(false);
    this.btnen.setEnabled(false);
    this.repf.setVisible(false);
    this.txtz.setEnabled(false);
    
    v();
    i();
    solicitu();
    nombre();
    cargarusuarios();
    r();
    bloqueo();
    DesbP();
    this.pans.setOpaque(true);
   
    AWTUtilities.setWindowOpaque(this, false);
    setSize(this.x, this.y);
    setTitle("Pantalla principal  ");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(2);
       
    }
    void v()
  {
    try
    {
      String SQL1 = " SELECT * FROM prorolact WHERE   id$rol='1' AND Activo='1'";
      
      Statement sv = null;
      sv = this.cn.createStatement();
      ResultSet rv = sv.executeQuery(SQL1);
      rv.next();
      
      this.z = rv.getString("id$3");
    }
    catch (SQLException ex)
    {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
   void solicitu()
  {
    try
    {
      conexionMySQL mysql = new conexionMySQL();
      Connection cn1 = mysql.Conectar();
      Statement sf = cn1.createStatement();
      ResultSet rj = sf.executeQuery("SELECT * FROM prorolact  WHERE    id$3='" + this.z + "'  ");
      rj.last();
      
      int encontrado2 = rj.getRow();
      if (encontrado2 == 1)
      {
        Statement sp = cn1.createStatement();
        ResultSet rz = sp.executeQuery("SELECT * FROM notificacion  WHERE    rol='1'  ");
        rz.last();
        
        int encontrado5 = rz.getRow();
        if (encontrado5 == 1)
        {
          String SQL1 = " SELECT * FROM notificacion WHERE  rol ='1'";
          
          Statement sv = null;
          sv = this.cn.createStatement();
          ResultSet rv = sv.executeQuery(SQL1);
          rv.next();
          
          this.lbno.setText(rv.getString("nombre"));
          this.lbap.setText(rv.getString("apellido"));
          this.pn1.setVisible(true);
        }
        else
        {
          this.pn1.setVisible(false);
        }
      }
    }
    catch (SQLException ex)
    {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
   void i()
  {
    Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/ful3.png"));
    
    setIconImage(icon);
    setVisible(true);
  }
  
  void nombre()
  {
    try
    {
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM usuario  WHERE activo ='1'  AND   activo <>'0'  ");
      rs.last();
      
      int encontrado = rs.getRow();
      if (encontrado == 1)
      {
        String SQL = " SELECT * FROM usuario WHERE activo ='1' ";
        
        Statement sv = null;
        sv = this.cn.createStatement();
        ResultSet rv = sv.executeQuery(SQL);
        rv.next();
        
        this.ids = rv.getString("id$usu");
        this.lbn.setText(rv.getString("nombre"));
        this.lba.setText(rv.getString("apellido"));
        String rol = rv.getString("rol");
        if (rol.equals("1")) {
          rol = "Director:";
        }
        if (rol.equals("2")) {
          rol = "Coordinador:";
        }
        if (rol.equals("3")) {
          rol = "Trabajador:";
        }
        if (rol.equals("4")) {
          rol = "Desactivado:";
        }
        if (rol.equals("5")) {
          rol = "Ninguno:";
        }
        if (rol.equals("6")) {
          rol = "Sub director:";
        }
         if (rol.equals("7")) {
          rol = "Secretario(a):";
        }
          if (rol.equals("8")) {
          rol = "Cosinero:";
        }
           if (rol.equals("9")) {
          rol = "Encargado:";
        }
            if (rol.equals("10")) {
          rol = "Profesor:";
        }
             if (rol.equals("11")) {
          rol = "Obrero:";
        }
              if (rol.equals("12")) {
          rol = "Visitante:";
        }
        this.lbr.setText(rol);
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
  
  void e2()
  {
    String SQL = "INSERT INTO sms (codigo,nombre,apellido,contenido,mensajero) VALUES (?,?,?,?,?)";
    try
    {
      PreparedStatement psd = this.cn.prepareStatement(SQL);
      psd.setString(1, this.codmensa);
      psd.setString(2, this.lbn.getText());
      psd.setString(3, this.lba.getText());
      psd.setString(4, this.txtz.getText());
      psd.setString(5, this.ids);
      
      int n = psd.executeUpdate();
      if (n > 0) {
        new Thread(new enviado()).start();
      }
    }
    catch (SQLException ex)
    {
      new Thread(new incorrecto()).start();
    }
  }
  
  void carga()
  {
    try
    {
      this.SQL = (" SELECT * FROM sms WHERE codigo = '" + this.ids + "'   ");
      
      Statement sg = null;
      sg = this.cn.createStatement();
      ResultSet rg = sg.executeQuery(this.SQL);
      
      rg.next();
      
      this.cod12 = rg.getString("codigo");
      if (this.cod12.equals(this.ids)) {
        this.btv.setVisible(true);
      } else {
        this.jButton4.setVisible(true);
      }
      this.nob.setText(rg.getString("nombre"));
      this.ap2.setText(rg.getString("apellido"));
      this.re.setText(rg.getString("contenido"));
      this.cont = rg.getString("contenido");
      this.codmensa = rg.getString("mensajero");
    }
    catch (SQLException ex)
    {
      
    }
  }
  
  void r()
  {
    try
    {
      this.SQL = (" SELECT * FROM sms WHERE codigo = '" + this.ids + "'   ");
      
      Statement sg = null;
      sg = this.cn.createStatement();
      ResultSet rg = sg.executeQuery(this.SQL);
      
      rg.next();
      
      this.cod12 = rg.getString("codigo");
      if (this.cod12.equals(this.ids)) {
        this.btv.setVisible(true);
      }
      this.nob.setText(rg.getString("nombre"));
      this.ap2.setText(rg.getString("apellido"));
      this.re.setText(rg.getString("contenido"));
      this.cont = rg.getString("contenido");
      this.codmensa = rg.getString("mensajero");
    }
    catch (SQLException ex)
    {
     
    }
  }
  
  void bloqueo()
  {
      MnuRepMatricula.setEnabled(false);
      jMenuItem3.setEnabled(false);
   
      MnuIngreso.setEnabled(false);
      jMenuItem2.setEnabled(false);
       MnuMuestraInventario.setEnabled(false);
    this.btnC1.setEnabled(false);
    this.btnAs.setEnabled(false);
    this.btnDE.setEnabled(false);
     MnuRepInventario.setEnabled(false);
     MNuRepDocentes.setEnabled(false);
    this.btnCOM1.setEnabled(false);
    this.btnREG.setEnabled(false);
     jMenuco.setEnabled(false);
     MnuEgreso.setEnabled(false);
  }
  
  void DesbP()
  {
    try
    {
      this.SQL = " SELECT * FROM prorolact WHERE Activo = 1";
      
      Statement st = null;
      st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(this.SQL);
      rs.next();
      
      this.id = rs.getString("id$pro");
      if (this.id.equals("2")) {
        this.btnDE.setEnabled(true);
        MnuMuestraInventario.setEnabled(true);
        MnuRepMatricula.setEnabled(true);
      }
      if (this.id.equals("3")) {
           MnuEgreso.setEnabled(true);
        this.btnAs.setEnabled(true);
          MnuMuestraInventario.setEnabled(true);
      }
      if (this.id.equals("1")) {
          jMenuItem2.setEnabled(true);
        this.btnC1.setEnabled(true);
         jMenuco.setEnabled(true);
      }
      if (this.id.equals("4"))
      {
          jMenuItem2.setEnabled(true);
           
        this.btnC1.setEnabled(true);
         jMenuco.setEnabled(true);
         MnuEgreso.setEnabled(true);
        this.btnAs.setEnabled(true);
        this.btnDE.setEnabled(true);
         MnuMuestraInventario.setEnabled(true);
         MnuIngreso.setEnabled(true);
        this.btnCOM1.setEnabled(true);
         MNuRepDocentes.setEnabled(true);
        this.btnREG.setEnabled(true);
         MnuRepInventario.setEnabled(true);
        jMenuItem3.setEnabled(true);
        MnuRepMatricula.setEnabled(true);
      }
      if (this.id.equals("5"))
      {
          jMenuItem2.setEnabled(true);
        this.btnC1.setEnabled(true);
         jMenuco.setEnabled(true);
         MnuMuestraInventario.setEnabled(true);
        this.btnDE.setEnabled(true);
        MnuRepMatricula.setEnabled(true);
      }
      if (this.id.equals("6"))
      {
            MnuEgreso.setEnabled(true);
        this.btnAs.setEnabled(true);
        this.btnDE.setEnabled(true);
        MnuRepMatricula.setEnabled(true);
         MnuMuestraInventario.setEnabled(true);
      }
      if (this.id.equals("7"))
      {
          jMenuItem2.setEnabled(true);
            MnuMuestraInventario.setEnabled(true);
        this.btnC1.setEnabled(true);
         jMenuco.setEnabled(true);
        this.btnAs.setEnabled(true);
         MnuEgreso.setEnabled(true);
      }
      if (this.id.equals("8")) {
        this.btnREG.setEnabled(true);
         MnuRepInventario.setEnabled(true);
         MnuIngreso.setEnabled(true);
      }
      if (this.id.equals("9")) {
        this.btnCOM1.setEnabled(true);
         jMenuItem3.setEnabled(true);
          MNuRepDocentes.setEnabled(true);
      }
      if (this.id.equals("10"))
      {
           jMenuItem3.setEnabled(true);
        this.btnCOM1.setEnabled(true);
         MNuRepDocentes.setEnabled(true);
        this.btnREG.setEnabled(true);
         MnuRepInventario.setEnabled(true);
         MnuIngreso.setEnabled(true);
      }
      if (this.id.equals("11"))
      {
           jMenuItem3.setEnabled(true);
        this.btnC1.setEnabled(true);
         jMenuco.setEnabled(true);
        jMenuItem2.setEnabled(true);
        this.btnCOM1.setEnabled(true);
         MNuRepDocentes.setEnabled(true);
      }
      if (this.id.equals("12"))
      {
             MnuMuestraInventario.setEnabled(true);
              MnuEgreso.setEnabled(true);
        this.btnAs.setEnabled(true);
         jMenuItem3.setEnabled(true);
        this.btnCOM1.setEnabled(true);
         MNuRepDocentes.setEnabled(true);
      }
      if (this.id.equals("13"))
      {
           jMenuItem3.setEnabled(true);
        this.btnDE.setEnabled(true);
        this.btnCOM1.setEnabled(true);
         MNuRepDocentes.setEnabled(true);
        MnuRepMatricula.setEnabled(true);
      }
      if (this.id.equals("14"))
      {
          jMenuItem2.setEnabled(true);
        this.btnC1.setEnabled(true);
         jMenuco.setEnabled(true);
         MnuIngreso.setEnabled(true);
        this.btnREG.setEnabled(true);
         MnuRepInventario.setEnabled(true);
      }
      if (this.id.equals("15"))
      {
        this.btnDE.setEnabled(true);
        MnuRepMatricula.setEnabled(true);
         MnuMuestraInventario.setEnabled(true);
        
        this.btnREG.setEnabled(true);
      }
      if (this.id.equals("16"))
      {
          MnuMuestraInventario.setEnabled(true);
           MnuIngreso.setEnabled(true);
        this.btnREG.setEnabled(true);
         MnuRepInventario.setEnabled(true);
        this.btnAs.setEnabled(true);
         MnuEgreso.setEnabled(true);
      }
      if (this.id.equals("17"))
      {
          jMenuItem2.setEnabled(true);
          MnuMuestraInventario.setEnabled(true);
        this.btnC1.setEnabled(true);
         jMenuco.setEnabled(true);
        this.btnAs.setEnabled(true);
         MnuEgreso.setEnabled(true);
        this.btnDE.setEnabled(true);
        MnuRepMatricula.setEnabled(true);
         MnuMuestraInventario.setEnabled(true);
      }
      if (this.id.equals("18"))
      {
           jMenuItem3.setEnabled(true);
            MnuEgreso.setEnabled(true);
        this.btnAs.setEnabled(true);
        MnuMuestraInventario.setEnabled(true);
        this.btnCOM1.setEnabled(true);
         MNuRepDocentes.setEnabled(true);
        this.btnREG.setEnabled(true);
         MnuRepInventario.setEnabled(true);
         MnuIngreso.setEnabled(true);
      }
      if (this.id.equals("19"))
      {
           jMenuItem3.setEnabled(true);
          jMenuItem2.setEnabled(true);
        this.btnC1.setEnabled(true);
         jMenuco.setEnabled(true);
         MnuIngreso.setEnabled(true);
        this.btnCOM1.setEnabled(true);
         MNuRepDocentes.setEnabled(true);
        this.btnREG.setEnabled(true);
         MnuRepInventario.setEnabled(true);
      }
      if (this.id.equals("20"))
      {
           jMenuItem3.setEnabled(true);
        this.btnDE.setEnabled(true);
         MnuMuestraInventario.setEnabled(true);
         MnuIngreso.setEnabled(true);
        this.btnCOM1.setEnabled(true);
         MNuRepDocentes.setEnabled(true);
        this.btnREG.setEnabled(true);
         MnuRepInventario.setEnabled(true);
        MnuRepMatricula.setEnabled(true);
      }
      if (this.id.equals("21"))
      {
          MnuEgreso.setEnabled(true);
        this.btnAs.setEnabled(true);
        this.btnDE.setEnabled(true);
         MnuMuestraInventario.setEnabled(true);
         MnuIngreso.setEnabled(true);
        this.btnREG.setEnabled(true);
         MnuRepInventario.setEnabled(true);
        MnuRepMatricula.setEnabled(true);
      }
      if (this.id.equals("22"))
      {
          jMenuItem2.setEnabled(true);
          MnuMuestraInventario.setEnabled(true);
        this.btnC1.setEnabled(true);
         jMenuco.setEnabled(true);
        this.btnAs.setEnabled(true);
         MnuIngreso.setEnabled(true);
        this.btnREG.setEnabled(true);
         MnuRepInventario.setEnabled(true);
          MnuEgreso.setEnabled(true);
      }
      if (this.id.equals("23"))
      {
           MnuEgreso.setEnabled(true);
        this.btnAs.setEnabled(true);
        this.btnDE.setEnabled(true);
        MnuRepMatricula.setEnabled(true);
         MnuMuestraInventario.setEnabled(true);
         jMenuItem3.setEnabled(true);
        this.btnCOM1.setEnabled(true);
         MNuRepDocentes.setEnabled(true);
      }
      if (this.id.equals("24"))
      {
          jMenuItem2.setEnabled(true);
          MnuMuestraInventario.setEnabled(true);
        this.btnC1.setEnabled(true);
         jMenuco.setEnabled(true);
        this.btnAs.setEnabled(true);
         jMenuItem3.setEnabled(true);
        this.btnCOM1.setEnabled(true);
         MNuRepDocentes.setEnabled(true);
          MnuEgreso.setEnabled(true);
      }
      if (this.id.equals("25"))
      {
           jMenuItem3.setEnabled(true);
          jMenuItem2.setEnabled(true);
          
        this.btnC1.setEnabled(true);
         jMenuco.setEnabled(true);
          MnuEgreso.setEnabled(true);
        this.btnAs.setEnabled(true);
        this.btnDE.setEnabled(true);
        MnuRepMatricula.setEnabled(true);
         MnuMuestraInventario.setEnabled(true);
        this.btnCOM1.setEnabled(true);
         MNuRepDocentes.setEnabled(true);
      }
      if (this.id.equals("26"))
      {
          jMenuItem2.setEnabled(true);
          
        this.btnC1.setEnabled(true);
         jMenuco.setEnabled(true);
        this.btnAs.setEnabled(true);
         MnuEgreso.setEnabled(true);
        this.btnDE.setEnabled(true);
        MnuRepMatricula.setEnabled(true);
         MnuMuestraInventario.setEnabled(true);
        
        this.btnREG.setEnabled(true);
      }
       if(id.equals("27")){
            jMenuItem3.setEnabled(true);
            MnuIngreso.setEnabled(true);
            this.btnREG.setEnabled(true);
             MnuRepInventario.setEnabled(true);
              this.btnCOM1.setEnabled(true);
              this.btnDE.setEnabled(true);
              MnuRepMatricula.setEnabled(true);
               MnuMuestraInventario.setEnabled(true);
               this.btnC1.setEnabled(true);
               jMenuItem2.setEnabled(true);
                MNuRepDocentes.setEnabled(true);
                 jMenuco.setEnabled(true);
        }
                     if(id.equals("28")){
                          jMenuItem3.setEnabled(true);
                         MnuMuestraInventario.setEnabled(true);
                   MnuIngreso.setEnabled(true);     
               this.btnREG.setEnabled(true);
                MnuRepInventario.setEnabled(true);
               this.btnCOM1.setEnabled(true);
               this.btnAs.setEnabled(true);
                MnuEgreso.setEnabled(true);
              this.btnC1.setEnabled(true);
              jMenuItem2.setEnabled(true);
               MNuRepDocentes.setEnabled(true);
               jMenuco.setEnabled(true);
           
        }
                      if(id.equals("29")){
                           jMenuItem3.setEnabled(true);
                          
              MnuIngreso.setEnabled(true);
             this.btnREG.setEnabled(true);
             MnuRepInventario.setEnabled(true);
              this.btnCOM1.setEnabled(true);
              this.btnAs.setEnabled(true);
               MnuEgreso.setEnabled(true);
              MnuRepMatricula.setEnabled(true);
                this.btnDE.setEnabled(true);
                 MnuMuestraInventario.setEnabled(true);
                  MNuRepDocentes.setEnabled(true);
        }
                      
    }
    catch (SQLException ex)
    {
      ex.printStackTrace();
    }
  }
  
  void e()
  {
    String SQL = "INSERT INTO sms (codigo,nombre,apellido,contenido,mensajero) VALUES (?,?,?,?,?)";
    try
    {
      PreparedStatement psd = this.cn.prepareStatement(SQL);
      psd.setString(1, this.co);
      psd.setString(2, this.lbn.getText());
      psd.setString(3, this.lba.getText());
      psd.setString(4, this.txtz.getText());
      psd.setString(5, this.ids);
      
      int n = psd.executeUpdate();
      if (n > 0) {
        new Thread(new enviado()).start();
      }
    }
    catch (SQLException ex)
    {
      new Thread(new incorrecto()).start();
    }
  }
  
  void cargarusuarios()
  {
    try
    {
      String[] titulos = { "ID", "NOMBRE", "APELLIDO" };
      String[] registros = new String[4];
      this.model = new DefaultTableModel((Object[][])null, titulos);
      
      String cons = "select * from usuario";
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(cons);
      while (rs.next())
      {
        registros[0] = rs.getString("id$usu");
        registros[1] = rs.getString("nombre");
        registros[2] = rs.getString("apellido");
        
        this.model.addRow(registros);
      }
      this.tblecon.setModel(this.model);
      this.tblecon.getColumnModel().getColumn(0).setPreferredWidth(30);
      this.tblecon.getColumnModel().getColumn(1).setPreferredWidth(100);
      this.tblecon.getColumnModel().getColumn(2).setPreferredWidth(100);
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
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
        pans = new javax.swing.JPanel();
        btnen = new javax.swing.JButton();
        re = new javax.swing.JLabel();
        txtz = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblecon = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nob = new javax.swing.JLabel();
        ap2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btnREG = new javax.swing.JButton();
        btnCOM1 = new javax.swing.JButton();
        btnDE = new javax.swing.JButton();
        btnC1 = new javax.swing.JButton();
        btnAs = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbn = new javax.swing.JLabel();
        lba = new javax.swing.JLabel();
        lbr = new javax.swing.JLabel();
        pn1 = new javax.swing.JPanel();
        lbno = new javax.swing.JLabel();
        lbap = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btv = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        repf = new javax.swing.JPanel();
        btsi = new javax.swing.JButton();
        btno = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MnuInicio = new javax.swing.JMenu();
        GestionUsu = new javax.swing.JMenuItem();
        MnuInventario = new javax.swing.JMenu();
        MnuMuestraInventario = new javax.swing.JMenuItem();
        MnuIngreso = new javax.swing.JMenuItem();
        MnuEgreso = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        MnuReportes = new javax.swing.JMenu();
        MnuRepMatricula = new javax.swing.JMenuItem();
        MnuRepInventario = new javax.swing.JMenuItem();
        MNuRepDocentes = new javax.swing.JMenuItem();
        jMenuco = new javax.swing.JMenuItem();
        MnuAyuda = new javax.swing.JMenu();
        MnuManual = new javax.swing.JMenuItem();
        MnuAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        pans.setBackground(new java.awt.Color(255, 255, 255));
        pans.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 51, 51), new java.awt.Color(255, 51, 51)));

        btnen.setBackground(new java.awt.Color(0, 0, 0));
        btnen.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnen.setForeground(new java.awt.Color(255, 255, 255));
        btnen.setText("Enviar");
        btnen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenActionPerformed(evt);
            }
        });

        re.setFont(new java.awt.Font("Tahoma", 1, 11));
        re.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imag/dfs.png"))); // NOI18N
        re.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtz.setFont(new java.awt.Font("Tahoma", 1, 11));

        tblecon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblecon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbleconMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblecon);

        jPanel4.setBackground(new java.awt.Color(102, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel3.setText("De:");

        nob.setBackground(new java.awt.Color(0, 0, 0));
        nob.setFont(new java.awt.Font("Tahoma", 1, 14));

        ap2.setBackground(new java.awt.Color(0, 0, 0));
        ap2.setFont(new java.awt.Font("Tahoma", 1, 14));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nob, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ap2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nob, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                    .addComponent(ap2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText("USUARIOS");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton3.setForeground(new java.awt.Color(255, 102, 102));
        jButton3.setText("X");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 51, 51), new java.awt.Color(255, 51, 51)));
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pansLayout = new javax.swing.GroupLayout(pans);
        pans.setLayout(pansLayout);
        pansLayout.setHorizontalGroup(
            pansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pansLayout.createSequentialGroup()
                .addGroup(pansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pansLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel5))
                    .addGroup(pansLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(re, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(txtz, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pansLayout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(btnen)
                .addGap(39, 39, 39)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
            .addGroup(pansLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pansLayout.setVerticalGroup(
            pansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pansLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(re)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pans);
        pans.setBounds(340, 0, 250, 260);

        btnREG.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnREG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/5.png"))); // NOI18N
        btnREG.setText("GESTION DE ESTUDIANTES");
        btnREG.setBorderPainted(false);
        btnREG.setContentAreaFilled(false);
        btnREG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnREG.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnREG.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/x1.png"))); // NOI18N
        btnREG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREGActionPerformed(evt);
            }
        });
        jPanel1.add(btnREG);
        btnREG.setBounds(0, 90, 340, 120);

        btnCOM1.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnCOM1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/2.png"))); // NOI18N
        btnCOM1.setText("C. COMEDOR");
        btnCOM1.setBorderPainted(false);
        btnCOM1.setContentAreaFilled(false);
        btnCOM1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCOM1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnCOM1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/x3.png"))); // NOI18N
        btnCOM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCOM1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCOM1);
        btnCOM1.setBounds(120, 230, 250, 120);

        btnDE.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnDE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/3.png"))); // NOI18N
        btnDE.setText("GESTION DE DEPOSITO");
        btnDE.setBorderPainted(false);
        btnDE.setContentAreaFilled(false);
        btnDE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDE.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/x2.png"))); // NOI18N
        btnDE.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDEActionPerformed(evt);
            }
        });
        jPanel1.add(btnDE);
        btnDE.setBounds(380, 320, 180, 140);

        btnC1.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/1.png"))); // NOI18N
        btnC1.setText("C. COLABORACION");
        btnC1.setBorderPainted(false);
        btnC1.setContentAreaFilled(false);
        btnC1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnC1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/x5.png"))); // NOI18N
        btnC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnC1);
        btnC1.setBounds(570, 230, 270, 120);

        btnAs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/ao.png"))); // NOI18N
        btnAs.setText("GESTION DE ROLES");
        btnAs.setBorderPainted(false);
        btnAs.setContentAreaFilled(false);
        btnAs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAs.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/x.png"))); // NOI18N
        btnAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsActionPerformed(evt);
            }
        });
        jPanel1.add(btnAs);
        btnAs.setBounds(590, 90, 280, 120);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 204, 255), new java.awt.Color(0, 204, 255)));
        jPanel2.setLayout(null);

        lbn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbn.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbn);
        lbn.setBounds(110, 0, 90, 30);

        lba.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lba.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lba);
        lba.setBounds(200, 0, 92, 30);

        lbr.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbr.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbr);
        lbr.setBounds(10, 0, 100, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 20, 290, 30);

        pn1.setBackground(new java.awt.Color(255, 255, 255));
        pn1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 102), null));
        pn1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pn1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lbno.setFont(new java.awt.Font("Tahoma", 1, 12));

        lbap.setFont(new java.awt.Font("Tahoma", 1, 12));
        lbap.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lbapAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("A solicitado rol el usuario:");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton2.setForeground(new java.awt.Color(255, 102, 102));
        jButton2.setText("X");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn1Layout = new javax.swing.GroupLayout(pn1);
        pn1.setLayout(pn1Layout);
        pn1Layout.setHorizontalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pn1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbno, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbap, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        pn1Layout.setVerticalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn1Layout.createSequentialGroup()
                .addGroup(pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(pn1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbap, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jPanel1.add(pn1);
        pn1.setBounds(-10, 400, 220, 80);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton1.setText("SALIDA-->");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(680, 400, 180, 60);

        btv.setForeground(new java.awt.Color(255, 255, 255));
        btv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imag/ccc.png"))); // NOI18N
        btv.setText("sms");
        btv.setContentAreaFilled(false);
        btv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btv.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imag/v2.png"))); // NOI18N
        btv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btvActionPerformed(evt);
            }
        });
        jPanel1.add(btv);
        btv.setBounds(430, 30, 80, 50);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imag/dsa.png"))); // NOI18N
        jButton4.setText("sms");
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imag/v1.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(430, 30, 80, 50);

        repf.setBackground(new java.awt.Color(255, 255, 255));
        repf.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 0), new java.awt.Color(255, 0, 0)));
        repf.setLayout(null);

        btsi.setBackground(new java.awt.Color(0, 0, 0));
        btsi.setFont(new java.awt.Font("Tahoma", 1, 12));
        btsi.setForeground(new java.awt.Color(255, 255, 255));
        btsi.setText("si");
        btsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsiActionPerformed(evt);
            }
        });
        repf.add(btsi);
        btsi.setBounds(30, 20, 50, 20);

        btno.setBackground(new java.awt.Color(0, 0, 0));
        btno.setFont(new java.awt.Font("Tahoma", 1, 12));
        btno.setForeground(new java.awt.Color(255, 255, 255));
        btno.setText("no");
        btno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoActionPerformed(evt);
            }
        });
        repf.add(btno);
        btno.setBounds(110, 20, 50, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Deseas responder..?");
        repf.add(jLabel2);
        jLabel2.setBounds(40, 0, 130, 15);

        jPanel1.add(repf);
        repf.setBounds(370, 270, 190, 40);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 140, 180, 20);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(130, 280, 110, 20);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(390, 440, 160, 20);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(700, 280, 130, 20);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(710, 140, 150, 20);

        jLabel11.setBackground(new java.awt.Color(0, 204, 255));
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 0), new java.awt.Color(255, 51, 51)));
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(720, 410, 100, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/oficial.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 870, 480);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(null);

        MnuInicio.setText("INICIO");

        GestionUsu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        GestionUsu.setBackground(new java.awt.Color(255, 255, 255));
        GestionUsu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GestionUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/usuario2.png"))); // NOI18N
        GestionUsu.setText("GESTION DE CUENTAS");
        GestionUsu.setOpaque(true);
        GestionUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionUsuActionPerformed(evt);
            }
        });
        MnuInicio.add(GestionUsu);

        jMenuBar1.add(MnuInicio);

        MnuInventario.setText("ARCHIVO");
        MnuInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuInventarioActionPerformed(evt);
            }
        });

        MnuMuestraInventario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        MnuMuestraInventario.setBackground(new java.awt.Color(255, 255, 255));
        MnuMuestraInventario.setFont(new java.awt.Font("Segoe UI", 1, 14));
        MnuMuestraInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/5x.png"))); // NOI18N
        MnuMuestraInventario.setText("GESTION DE DEPOSITO");
        MnuMuestraInventario.setOpaque(true);
        MnuMuestraInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuMuestraInventarioActionPerformed(evt);
            }
        });
        MnuInventario.add(MnuMuestraInventario);

        MnuIngreso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        MnuIngreso.setBackground(new java.awt.Color(255, 255, 255));
        MnuIngreso.setFont(new java.awt.Font("Segoe UI", 1, 14));
        MnuIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/2x.png"))); // NOI18N
        MnuIngreso.setText("GESTION DE ESTUDIANTES");
        MnuIngreso.setOpaque(true);
        MnuIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuIngresoActionPerformed(evt);
            }
        });
        MnuInventario.add(MnuIngreso);

        MnuEgreso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        MnuEgreso.setBackground(new java.awt.Color(255, 255, 255));
        MnuEgreso.setFont(new java.awt.Font("Segoe UI", 1, 14));
        MnuEgreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/1x.png"))); // NOI18N
        MnuEgreso.setText("GESTION DE ROLES");
        MnuEgreso.setOpaque(true);
        MnuEgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuEgresoActionPerformed(evt);
            }
        });
        MnuInventario.add(MnuEgreso);

        jMenuBar1.add(MnuInventario);

        jMenu1.setText("CONTROL");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/3x.png"))); // NOI18N
        jMenuItem2.setText("C. COLABORACION");
        jMenuItem2.setOpaque(true);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/4x.png"))); // NOI18N
        jMenuItem3.setText("C.COMEDOR");
        jMenuItem3.setOpaque(true);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        MnuReportes.setText("REPORTES");

        MnuRepMatricula.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK));
        MnuRepMatricula.setBackground(new java.awt.Color(255, 255, 255));
        MnuRepMatricula.setFont(new java.awt.Font("Segoe UI", 1, 14));
        MnuRepMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/28.png"))); // NOI18N
        MnuRepMatricula.setText("R .DEPOSITO");
        MnuRepMatricula.setOpaque(true);
        MnuRepMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuRepMatriculaActionPerformed(evt);
            }
        });
        MnuReportes.add(MnuRepMatricula);

        MnuRepInventario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        MnuRepInventario.setBackground(new java.awt.Color(255, 255, 255));
        MnuRepInventario.setFont(new java.awt.Font("Segoe UI", 1, 14));
        MnuRepInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/27.png"))); // NOI18N
        MnuRepInventario.setText("R. ESTUDIANTES");
        MnuRepInventario.setOpaque(true);
        MnuRepInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuRepInventarioActionPerformed(evt);
            }
        });
        MnuReportes.add(MnuRepInventario);

        MNuRepDocentes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        MNuRepDocentes.setBackground(new java.awt.Color(255, 255, 255));
        MNuRepDocentes.setFont(new java.awt.Font("Segoe UI", 1, 14));
        MNuRepDocentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/25.png"))); // NOI18N
        MNuRepDocentes.setText("R. COMEDOR");
        MNuRepDocentes.setOpaque(true);
        MNuRepDocentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MNuRepDocentesActionPerformed(evt);
            }
        });
        MnuReportes.add(MNuRepDocentes);

        jMenuco.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuco.setBackground(new java.awt.Color(255, 255, 255));
        jMenuco.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jMenuco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/26.png"))); // NOI18N
        jMenuco.setText("R. COLABORACION");
        jMenuco.setOpaque(true);
        jMenuco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenucoActionPerformed(evt);
            }
        });
        MnuReportes.add(jMenuco);

        jMenuBar1.add(MnuReportes);

        MnuAyuda.setText("AYUDA");

        MnuManual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        MnuManual.setBackground(new java.awt.Color(255, 255, 255));
        MnuManual.setFont(new java.awt.Font("Segoe UI", 1, 14));
        MnuManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/manual2.png"))); // NOI18N
        MnuManual.setText("MANUAL DEL USUARIO");
        MnuManual.setOpaque(true);
        MnuManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuManualActionPerformed(evt);
            }
        });
        MnuAyuda.add(MnuManual);

        MnuAcerca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        MnuAcerca.setBackground(new java.awt.Color(255, 255, 255));
        MnuAcerca.setFont(new java.awt.Font("Segoe UI", 1, 14));
        MnuAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ayuda1.png"))); // NOI18N
        MnuAcerca.setText("ACERCA DE.");
        MnuAcerca.setOpaque(true);
        MnuAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuAcercaActionPerformed(evt);
            }
        });
        MnuAyuda.add(MnuAcerca);

        jMenuBar1.add(MnuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnREGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREGActionPerformed
 cerrar();
     Registro$estudiantil1 s = new Registro$estudiantil1();
    s.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_btnREGActionPerformed

private void btnCOM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCOM1ActionPerformed
 cerrar();
    Control$comenzales s = new Control$comenzales();
    s.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_btnCOM1ActionPerformed

private void btnDEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDEActionPerformed
cerrar();
     RegAlimentos s = new RegAlimentos();
    s.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_btnDEActionPerformed

private void btnC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC1ActionPerformed
cerrar();
    Colaboracion s = new Colaboracion();
    s.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_btnC1ActionPerformed

private void btnAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsActionPerformed
 cerrar();
     FrmModulos s = new FrmModulos();
    s.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_btnAsActionPerformed

private void GestionUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionUsuActionPerformed
 ConfiCuenta f = new ConfiCuenta();
    f.setVisible(true);
    try
    {
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM usuario  WHERE activo ='1'  AND   activo <>'0'  ");
      rs.last();
      
      int encontrado = rs.getRow();
      if (encontrado == 1)
      {
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
    catch (Exception e) {}// TODO add your handling code here:
}//GEN-LAST:event_GestionUsuActionPerformed

private void MnuMuestraInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuMuestraInventarioActionPerformed
cerrar();
     RegAlimentos s = new RegAlimentos();
    s.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_MnuMuestraInventarioActionPerformed

private void MnuIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuIngresoActionPerformed
 cerrar();
     Registro$estudiantil1 s = new Registro$estudiantil1();
    s.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_MnuIngresoActionPerformed

private void MnuEgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuEgresoActionPerformed
cerrar();
     FrmModulos s = new FrmModulos();
    s.setVisible(true);
}//GEN-LAST:event_MnuEgresoActionPerformed

private void MnuRepMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuRepMatriculaActionPerformed
 try {
             String fileJasper = "D:\\FENIX\\src\\Reportes\\deposito2.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(fileJasper);
            JasperPrint print= JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer.viewReport(print,false);
           
        } catch (JRException e) {
            System.out.printf(e.getMessage());
        }
      // TODO add your handling code here:
}//GEN-LAST:event_MnuRepMatriculaActionPerformed

private void MnuRepInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuRepInventarioActionPerformed
 try {
             String fileJasper = "D:\\FENIX\\src\\Reportes\\estudiantes.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(fileJasper);
            JasperPrint print= JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer.viewReport(print,false);
           
        } catch (JRException e) {
            System.out.printf(e.getMessage());
        }
      
}//GEN-LAST:event_MnuRepInventarioActionPerformed

private void MNuRepDocentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MNuRepDocentesActionPerformed
 try {
             String fileJasper = "D:\\FENIX\\src\\Reportes\\comedor.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(fileJasper);
            JasperPrint print= JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer.viewReport(print,false);
           
        } catch (JRException e) {
            System.out.printf(e.getMessage());
        }
      
}//GEN-LAST:event_MNuRepDocentesActionPerformed

private void MnuManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuManualActionPerformed
try
    {
      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler D:\\Manual.pdf");
    }
    catch (IOException e)
    {
      JOptionPane.showMessageDialog(this.rootPane, "Error al Abrir el Archivo", "ERROR", 0);
    }// TODO add your handling code here:
}//GEN-LAST:event_MnuManualActionPerformed

private void MnuAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuAcercaActionPerformed
info d=new info();
d.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_MnuAcercaActionPerformed

private void lbapAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lbapAncestorAdded
// TODO add your handling code here:
}//GEN-LAST:event_lbapAncestorAdded

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
try
    {
      Statement st = this.cn.createStatement();
      ResultSet rj = st.executeQuery("SELECT * FROM notificacion  WHERE    rol='1'  ");
      rj.last();
      
      int encontrado2 = rj.getRow();
      if (encontrado2 == 1)
      {
        String SQL1 = " SELECT * FROM notificacion WHERE rol ='1' ";
        
        Statement sv = null;
        sv = this.cn.createStatement();
        ResultSet rv = sv.executeQuery(SQL1);
        rv.next();
        
        int id1 = rv.getInt("id_noti");
        int total = id1 - 1;
        PreparedStatement psd = null;
        this.SQL = " DELETE FROM notificacion WHERE rol ='1'";
        psd = this.cn.prepareStatement(this.SQL);
        psd.execute();
       
        
        String SQL0 = "UPDATE notificacion set rol=? WHERE id_noti=?";
        PreparedStatement psd0 = this.cn.prepareStatement(SQL0);
        psd0.setString(1, "1");
        psd0.setInt(2, total);
        psd0.executeUpdate();
      }
      this.pn1.setVisible(false);
      solicitu();
    }
    catch (SQLException ex)
    {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }// TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

private void pn1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pn1AncestorAdded
// TODO add your handling code here:
}//GEN-LAST:event_pn1AncestorAdded

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 try
    {
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM usuario  WHERE activo ='1'  AND   activo <>'0'  ");
      rs.last();
      
      int encontrado = rs.getRow();
      if (encontrado == 1)
      {
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
    catch (Exception e) {}// TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

private void btvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btvActionPerformed
 this.pans.setVisible(true);
    this.repf.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_btvActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
this.pans.setVisible(true);
    this.btnen.setEnabled(true);
    this.tblecon.setVisible(true);
    this.txtz.setEnabled(true);// TODO add your handling code here:
}//GEN-LAST:event_jButton4ActionPerformed

private void btnenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenActionPerformed
 if (this.resp == 0)
    {
      e();
      this.re.setText("");
      this.nob.setText("");
      this.ap2.setText("");
      this.txtz.setText("");
      this.pans.setVisible(false);
      
      this.btnen.setEnabled(true);
    }
    else
    {
      e2();
      try
      {
        PreparedStatement psd = null;
        this.btnen.setEnabled(true);
        this.SQL = (" DELETE FROM sms WHERE codigo ='" + this.cod12 + "' AND contenido ='" + this.cont + "'");
        psd = this.cn.prepareStatement(this.SQL);
        psd.execute();
        psd.close();
        
       
      }
      catch (SQLException ex)
      {
        JOptionPane.showMessageDialog(null, "Error SQL no se Eliminaron");
      }
      this.re.setText("");
      this.nob.setText("");
      this.ap2.setText("");
      this.txtz.setText("");
      this.pans.setVisible(false);
      
      carga();
       btv.setVisible(false);
    }// TODO add your handling code here:
}//GEN-LAST:event_btnenActionPerformed

private void tbleconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbleconMouseClicked
 int i = this.tblecon.getSelectedRow();
    this.co = ((String)this.tblecon.getValueAt(i, 0));
    this.no = ((String)this.tblecon.getValueAt(i, 1));
    this.ap = ((String)this.tblecon.getValueAt(i, 2));// TODO add your handling code here:
}//GEN-LAST:event_tbleconMouseClicked

private void btsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsiActionPerformed
this.resp = 1;
 btv.setVisible(false);
    this.repf.setVisible(false);
    this.txtz.setEnabled(true);
    this.btnen.setEnabled(true);
    this.tblecon.setVisible(false);
   
}//GEN-LAST:event_btsiActionPerformed

private void btnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoActionPerformed
this.repf.setVisible(false);
    this.btnen.setEnabled(true);
    try
    {
      PreparedStatement psd = null;
      this.btnen.setEnabled(true);
      this.SQL = (" DELETE FROM sms WHERE codigo ='" + this.cod12 + "' AND contenido ='" + this.cont + "'");
      psd = this.cn.prepareStatement(this.SQL);
      psd.execute();
      psd.close();
      
      
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null, "Error SQL no se Eliminaron");
    }
    this.re.setText("");
    this.nob.setText("");
    this.ap2.setText("");
    this.txtz.setText("");
     btv.setVisible(false);
    this.pans.setVisible(false);
    
    carga();// TODO add your handling code here:
}//GEN-LAST:event_btnoActionPerformed

private void jMenucoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenucoActionPerformed
try {
             String fileJasper = "D:\\FENIX\\src\\Reportes\\colaboracion.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(fileJasper);
            JasperPrint print= JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer.viewReport(print,false);
           
        } catch (JRException e) {
            System.out.printf(e.getMessage());
        }
}//GEN-LAST:event_jMenucoActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
repf.setVisible(false); 
    this.pans.setVisible(false); 
    
}//GEN-LAST:event_jButton3ActionPerformed

private void MnuInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuInventarioActionPerformed
 cerrar();
     FrmModulos s = new FrmModulos();
    s.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_MnuInventarioActionPerformed

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
cerrar();
    Colaboracion s = new Colaboracion();
    s.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_jMenuItem2ActionPerformed

private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
 cerrar();
    Control$comenzales s = new Control$comenzales();
    s.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_jMenu1ActionPerformed

private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
cerrar();
    Control$comenzales s = new Control$comenzales();
    s.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
              new Thread(new Principal()).start();
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
        this.x += 100;
        if (this.x == 900) {
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem GestionUsu;
    private javax.swing.JMenuItem MNuRepDocentes;
    private javax.swing.JMenuItem MnuAcerca;
    private javax.swing.JMenu MnuAyuda;
    private javax.swing.JMenuItem MnuEgreso;
    private javax.swing.JMenuItem MnuIngreso;
    private javax.swing.JMenu MnuInicio;
    private javax.swing.JMenu MnuInventario;
    private javax.swing.JMenuItem MnuManual;
    private javax.swing.JMenuItem MnuMuestraInventario;
    private javax.swing.JMenuItem MnuRepInventario;
    private javax.swing.JMenuItem MnuRepMatricula;
    private javax.swing.JMenu MnuReportes;
    private javax.swing.JLabel ap2;
    private javax.swing.JButton btnAs;
    private javax.swing.JButton btnC1;
    private javax.swing.JButton btnCOM1;
    private javax.swing.JButton btnDE;
    private javax.swing.JButton btnREG;
    private javax.swing.JButton btnen;
    private javax.swing.JButton btno;
    private javax.swing.JButton btsi;
    private javax.swing.JButton btv;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuco;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lba;
    private javax.swing.JLabel lbap;
    private javax.swing.JLabel lbn;
    private javax.swing.JLabel lbno;
    private javax.swing.JLabel lbr;
    private javax.swing.JLabel nob;
    private javax.swing.JPanel pans;
    private javax.swing.JPanel pn1;
    private javax.swing.JLabel re;
    private javax.swing.JPanel repf;
    private javax.swing.JTable tblecon;
    private javax.swing.JTextField txtz;
    // End of variables declaration//GEN-END:variables
}
