/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Registro$estudiantil1.java
 *
 * Created on 06-ago-2016, 12:36:35
 */
package fenix2;
import Conexion_Base_de_Datos.conexionMySQL;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author GERALDO J
 */
public class Registro$estudiantil1 extends javax.swing.JFrame {
int nAction;
  String cdu;
  conexionMySQL cc = new conexionMySQL();
  Connection cn = this.cc.Conectar();
  DefaultTableModel model;
    /** Creates new form Registro$estudiantil1 */
    public Registro$estudiantil1() {
         setUndecorated(true);
        initComponents();
         i();
    Bloquear();
    bloqueo();
    DesbP();
     LBF.setText(fechaActual());
    cargar("");
    contar();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(2);
    }
    public static String fechaActual(){

Date fecha= new Date();
SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MMM/yyy");
return formatoFecha.format(fecha);
} 
    void i()
  {
    Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/ful3.png"));
    
    setIconImage(icon);
    setVisible(true);
  }
  
  void DesbP()
  {
    try
    {
      String SQL = " SELECT * FROM usuario WHERE activo = 1";
      
      Statement st = null;
      st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(SQL);
      rs.next();
      
      String Cusu = rs.getString("id$usu");
      
      String SQL2 = " SELECT * FROM prorolact WHERE Activo = " + Cusu;
      Statement st2 = null;
      st2 = this.cn.createStatement();
      ResultSet rs2 = st2.executeQuery(SQL2);
      rs2.next();
      
      String id = rs2.getString("idactireg");
      if (id.equals("1")) {
        this.BtnGuar.setEnabled(true);
      }
      if (id.equals("2")) {
        this.Btnedit.setEnabled(true);
      }
      if (id.equals("3")) {
        this.BtnEli.setEnabled(true);
      }
      if (id.equals("4"))
      {
        this.BtnGuar.setEnabled(true);
        this.Btnedit.setEnabled(true);
        this.BtnEli.setEnabled(true);
      }
      if (id.equals("5"))
      {
        this.BtnGuar.setEnabled(true);
        this.Btnedit.setEnabled(true);
      }
      if (id.equals("6"))
      {
        this.Btnedit.setEnabled(true);
        this.BtnEli.setEnabled(true);
      }
      if (id.equals("7"))
      {
        this.BtnGuar.setEnabled(true);
        this.BtnEli.setEnabled(true);
      }
      if (id.equals("8"))
      {
        this.BtnGuar.setEnabled(false);
        this.BtnEli.setEnabled(false);
        this.Btnedit.setEnabled(false);
      }
    }
    catch (SQLException ex)
    {
      ex.printStackTrace();
    }
  }
  
  void bloqueo()
  {
    this.BtnGuar.setEnabled(false);
    this.BtnEli.setEnabled(false);
    this.Btnedit.setEnabled(false);
  }
  
  void Bloquear()
  {
    this.TxtCedu.setEnabled(false);
    this.Boxsecc.setEnabled(false);
    jPanel2.setVisible(false);
    this.Boxsex.setEnabled(false);
    this.TxtCedu.setEditable(false);
    this.TxtNom.setEnabled(false);
    this.TxtApe.setEnabled(false);
    this.Txtedad.setEnabled(false);
    this.boxa.setEnabled(false);
  }
  
  void desbloquear()
  {
       jPanel2.setVisible(true);
    this.TxtCedu.setEnabled(true);
    this.Boxsecc.setEnabled(true);
    this.boxa.setEnabled(true);
    this.Boxsex.setEnabled(true);
    this.TxtCedu.setEditable(true);
    this.TxtNom.setEnabled(true);
    this.TxtApe.setEnabled(true);
    this.Txtedad.setEnabled(true);
  }
  
  void Limpiar()
  {
    this.TxtCedu.setText("");
    this.Boxsecc.setSelectedItem("Seleccione");
    this.boxa.setSelectedItem("Seleccione");
    this.Boxsex.setSelectedItem("Seleccione");
    this.TxtCedu.setText("");
    this.TxtNom.setText("");
    this.TxtApe.setText("");
    this.Txtedad.setText("");
  }
  
  void Guardar()
  {
    String ced = this.TxtCedu.getText();
    
    String sexo = String.valueOf(this.Boxsex.getSelectedItem());
    String seccion = String.valueOf(this.Boxsecc.getSelectedItem());
    String a = String.valueOf(this.boxa.getSelectedItem());
    String c=TxtCedu.getText(),no=TxtNom.getText(),ap=TxtApe.getText(),edad=Txtedad.getText();
    PreparedStatement psd;
    switch (this.nAction)
    {
    case 1: 
     
          if(c.isEmpty() || no.isEmpty() || ap.isEmpty() ||edad.isEmpty() || sexo.isEmpty() || a.isEmpty()|| seccion.isEmpty())
       {
        
       }
          else{
               try
          {
        Statement st = this.cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM persona WHERE idCedula ='" + ced + "'");
        rs.last();
        int encontrado = rs.getRow();
        if (encontrado == 1)
        {
          JOptionPane.showMessageDialog(null, "existe");
        }
        else
        {
          String SQL = "INSERT INTO persona(idCedula,nombre,apellido,sexo,edad,año,seccion)VALUES (?,?,?,?,?,?,?)";
         
            psd = this.cn.prepareStatement(SQL);
            psd.setString(1, this.TxtCedu.getText());
            psd.setString(2, this.TxtNom.getText());
            psd.setString(3, this.TxtApe.getText());
            psd.setString(5, this.Txtedad.getText());
            psd.setString(4, sexo);
            psd.setString(6, a);
            psd.setString(7, seccion);
            
            int m = psd.executeUpdate();
            if (m > 0)
            {
              Limpiar();
              Bloquear();
              contar();
              new Thread(new correcto1()).start();
            }
          }
          }
          catch (SQLException ex)
          {
            new Thread(new incorrecto()).start();
          }
          }
      
      
  
    case 2: 
        if(c.isEmpty() || no.isEmpty() || ap.isEmpty() ||edad.isEmpty() || sexo.isEmpty() || a.isEmpty()||seccion.isEmpty())
       {
          new Thread(new vacio()).start();
       }
        else{
      String SQL = "UPDATE persona set idCedula=?, nombre=?, apellido=?,sexo=?,edad=?,año=?,seccion=? WHERE idCedula=?";
      try
      {
        psd = this.cn.prepareStatement(SQL);
        psd.setString(1, this.TxtCedu.getText());
        psd.setString(2, this.TxtNom.getText());
        psd.setString(3, this.TxtApe.getText());
        psd.setString(5, this.Txtedad.getText());
        psd.setString(4, sexo);
        psd.setString(6, a);
        psd.setString(7, seccion);
        psd.setString(8, this.cdu);
        int n = psd.executeUpdate();
        if (n > 0)
        {
          Limpiar();
          Bloquear();
          contar();
          new Thread(new correcto1()).start();
        }
      
      }
        
      catch (SQLException ex)
      {
        new Thread(new incorrecto()).start();
      }
    }
        
  }
  }
  
  public void Editar()
  {
    desbloquear();
    Limpiar();
    
    this.nAction = 2;
    
    String cod = JOptionPane.showInputDialog("Introdusca cedula ");
    try
    {
         Statement sv = this.cn.createStatement();
        ResultSet rd = sv.executeQuery("SELECT * FROM persona WHERE idCedula ='" + cod + "'");
        rd.last();
        int encontrado = rd.getRow();
        if (encontrado == 1)
        {
         
        
      String SQL = " SELECT * FROM persona WHERE idCedula = " + cod;
      
      Statement st = null;
      st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(SQL);
      rs.next();
      this.cdu = rs.getString("idCedula");
      this.TxtCedu.setText(rs.getString("idCedula"));
      this.TxtNom.setText(rs.getString("nombre"));
      this.TxtApe.setText(rs.getString("apellido"));
      
      this.Boxsecc.setSelectedItem(rs.getString("seccion"));
      this.boxa.setSelectedItem(rs.getString("año"));
      this.Boxsex.setSelectedItem(rs.getString("sexo"));
      this.Txtedad.setText(rs.getString("edad"));
      
      this.BtnGuar.setEnabled(true);
    }
        else{
             JOptionPane.showMessageDialog(null, "No existe");
        }
    }
    catch (SQLException ex) {}
  
  }
  


  void Eliminar()
  {
    try
    {
      Limpiar();
      String ci = JOptionPane.showInputDialog("Cedula");
       Statement sv = this.cn.createStatement();
        ResultSet rd = sv.executeQuery("SELECT * FROM persona WHERE idCedula ='" + ci + "'");
        rd.last();
        int encontrado = rd.getRow();
        if (encontrado == 1)
        {
      
      String SQL = " SELECT * FROM persona WHERE idCedula = '" + ci + "'";
      
      Statement st = null;
      st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(SQL);
      
      rs.next();
      
      this.TxtCedu.setText(rs.getString("idCedula"));
      this.TxtNom.setText(rs.getString("nombre"));
      this.TxtApe.setText(rs.getString("apellido"));
      
      this.Boxsecc.setSelectedItem(rs.getString("seccion"));
      this.boxa.setSelectedItem(rs.getString("año"));
      this.Boxsex.setSelectedItem(rs.getString("sexo"));
      this.Txtedad.setText(rs.getString("edad"));
       desbloquear();
      int resp = JOptionPane.showConfirmDialog(this, "Deseas Eliminarlo", "Eliminar Dato", 0);
      if (resp == 0) {
        try
        {
          PreparedStatement psd = null;
          SQL = " DELETE FROM persona WHERE idCedula ='" + ci + "'";
          psd = this.cn.prepareStatement(SQL);
          psd.execute();
          psd.close();
         
          Limpiar();
          Bloquear();
          JOptionPane.showMessageDialog(this, "Registro Eliminado");
        }
      
        catch (SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "Error SQL no se Eliminaron");
        }
      }}else{
        JOptionPane.showMessageDialog(null, "No existe");    
        }
    }
    catch (SQLException ex)
    {
      Logger.getLogger(Registro$estudiantil1.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  void cargar(String valor)
  {
    String[] titulos = { "CEDULA", "NOMBRES", "APELLIDOS", "SEXO", "EDAD", "AÑO", "SECCION" };
    String[] registros = new String[7];
    String sql = "SELECT * FROM persona where CONCAT (idCedula) LIKE '%" + valor + "%'";
    
    this.model = new DefaultTableModel((Object[][])null, titulos);
    try
    {
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next())
      {
        registros[0] = rs.getString("idCedula");
        registros[1] = rs.getString("nombre");
        registros[2] = rs.getString("apellido");
        registros[3] = rs.getString("sexo");
        registros[4] = rs.getString("edad");
        registros[5] = rs.getString("año");
        registros[6] = rs.getString("seccion");
        
        this.model.addRow(registros);
        this.PersTabla.setModel(this.model);
      }
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null, ex);
    }
  }
  void contar(){ 
   
   String sql="SELECT count(*)  FROM persona ";
   try{
  
             Statement st = cn.createStatement();
               ResultSet rs=st.executeQuery(sql);
               while(rs.next()){
                 
                  est.setText(rs.getString("count(*)"));
                    
                 
                   
                 
                  
           
          
                   
               }
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
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
        jPanel2 = new javax.swing.JPanel();
        Txtedad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TxtCedu = new javax.swing.JTextField();
        TxtNom = new javax.swing.JTextField();
        TxtApe = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Boxsex = new javax.swing.JComboBox();
        Boxsecc = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        boxa = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PersTabla = new javax.swing.JTable();
        TxtCedC = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        est = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BtnNue = new javax.swing.JButton();
        BtnGuar = new javax.swing.JButton();
        Btnedit = new javax.swing.JButton();
        BtnEli = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        LBF = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(null);

        Txtedad.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel2.add(Txtedad);
        Txtedad.setBounds(78, 269, 58, 29);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jLabel1.setText("CEDULA");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(83, 13, 60, 17);

        TxtCedu.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel2.add(TxtCedu);
        TxtCedu.setBounds(12, 36, 196, 29);

        TxtNom.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel2.add(TxtNom);
        TxtNom.setBounds(12, 94, 196, 29);

        TxtApe.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel2.add(TxtApe);
        TxtApe.setBounds(12, 152, 196, 29);

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jLabel2.setText("NOMBRE");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(81, 71, 50, 17);

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jLabel3.setText("APELLIDO");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(82, 129, 70, 17);

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jLabel4.setText("SEXO");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(89, 192, 32, 17);

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jLabel5.setText("EDAD");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(90, 248, 32, 17);

        Boxsex.setFont(new java.awt.Font("Tahoma", 1, 11));
        Boxsex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "F", "M" }));
        jPanel2.add(Boxsex);
        Boxsex.setBounds(72, 214, 100, 28);

        Boxsecc.setFont(new java.awt.Font("Tahoma", 1, 11));
        Boxsecc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "A", "B", "C", "D", "E", "G", "F", "H", "I", "J", "K", "L", "M", "Ñ", "N", "R", "S", "T", "U", "Q", "W", "X", "Y", "Z" }));
        jPanel2.add(Boxsecc);
        Boxsecc.setBounds(120, 320, 100, 29);

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jLabel7.setText("SECCION");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(130, 304, 53, 17);

        boxa.setFont(new java.awt.Font("Tahoma", 1, 11));
        boxa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "PRIMERO", "SEGUNDO", "TERCERO", "CUARTO", "QUINTO", "SEXTO", "SEPTIMO" }));
        jPanel2.add(boxa);
        boxa.setBounds(10, 320, 100, 29);

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jLabel9.setText("AÑO");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(60, 304, 26, 17);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/rk.png"))); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 0, 220, 360);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(190, 100, 220, 360);

        jPanel5.setBackground(new java.awt.Color(102, 204, 255));
        jPanel5.setLayout(null);

        PersTabla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PersTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(PersTabla);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(0, 68, 550, 230);

        TxtCedC.setFont(new java.awt.Font("Tahoma", 1, 12));
        TxtCedC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCedCActionPerformed(evt);
            }
        });
        TxtCedC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtCedCKeyReleased(evt);
            }
        });
        jPanel5.add(TxtCedC);
        TxtCedC.setBounds(10, 34, 194, 28);

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/search.png"))); // NOI18N
        jLabel10.setText("BUSQUEDA");
        jPanel5.add(jLabel10);
        jLabel10.setBounds(210, 30, 110, 30);

        est.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel5.add(est);
        est.setBounds(440, 290, 110, 40);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("TOTAL:");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(380, 297, 60, 30);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/rk2.png"))); // NOI18N
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel11);
        jLabel11.setBounds(0, 0, 550, 330);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(420, 100, 550, 330);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setOpaque(false);

        BtnNue.setBackground(new java.awt.Color(0, 0, 0));
        BtnNue.setFont(new java.awt.Font("Tahoma", 1, 11));
        BtnNue.setForeground(new java.awt.Color(255, 255, 255));
        BtnNue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/Imagen3.png"))); // NOI18N
        BtnNue.setText("    NUEVO");
        BtnNue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNueActionPerformed(evt);
            }
        });

        BtnGuar.setBackground(new java.awt.Color(0, 0, 0));
        BtnGuar.setFont(new java.awt.Font("Tahoma", 1, 11));
        BtnGuar.setForeground(new java.awt.Color(255, 255, 255));
        BtnGuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/Imagen4.png"))); // NOI18N
        BtnGuar.setText("GUARDAR");
        BtnGuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuarActionPerformed(evt);
            }
        });

        Btnedit.setBackground(new java.awt.Color(0, 0, 0));
        Btnedit.setFont(new java.awt.Font("Tahoma", 1, 11));
        Btnedit.setForeground(new java.awt.Color(255, 255, 255));
        Btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/Imagen5.png"))); // NOI18N
        Btnedit.setText("   EDITAR");
        Btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtneditActionPerformed(evt);
            }
        });

        BtnEli.setBackground(new java.awt.Color(0, 0, 0));
        BtnEli.setFont(new java.awt.Font("Tahoma", 1, 11));
        BtnEli.setForeground(new java.awt.Color(255, 255, 255));
        BtnEli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/Imagen6.png"))); // NOI18N
        BtnEli.setText("ELIMINAR");
        BtnEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnEli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(Btnedit, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(BtnGuar, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(BtnNue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(BtnNue, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnGuar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEli, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 120, 178, 310);

        jLabel12.setBackground(new java.awt.Color(102, 204, 255));
        jLabel12.setFont(new java.awt.Font("Bodoni MT Black", 1, 24));
        jLabel12.setText("                           G E S T I O N  D E  E S T U D I A N T E S");
        jLabel12.setOpaque(true);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(0, 40, 1000, 40);

        LBF.setFont(new java.awt.Font("Tahoma", 1, 18));
        LBF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBF.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel1.add(LBF);
        LBF.setBounds(0, 440, 130, 30);

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
        jButton3.setBounds(860, 440, 100, 30);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton4.setText("PRINCIPAL  #");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(750, 440, 110, 30);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel13.setText("CONSULTA DE ESTUDIANTES");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel13.setOpaque(true);
        jPanel1.add(jLabel13);
        jLabel13.setBounds(560, 80, 270, 22);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel14.setText(" DATOS DEL ESTUDIANTE");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel14.setOpaque(true);
        jPanel1.add(jLabel14);
        jLabel14.setBounds(180, 80, 240, 22);

        jLabel15.setBackground(new java.awt.Color(0, 204, 255));
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel15.setOpaque(true);
        jPanel1.add(jLabel15);
        jLabel15.setBounds(760, 440, 100, 30);

        jLabel16.setBackground(new java.awt.Color(0, 204, 255));
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 102), new java.awt.Color(255, 102, 102)));
        jLabel16.setOpaque(true);
        jPanel1.add(jLabel16);
        jLabel16.setBounds(870, 440, 80, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/fondo.png"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 980, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void TxtCedCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCedCActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_TxtCedCActionPerformed

private void TxtCedCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCedCKeyReleased
cargar(this.TxtCedC.getText());// TODO add your handling code here:
}//GEN-LAST:event_TxtCedCKeyReleased

private void BtnNueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNueActionPerformed
 desbloquear();
    Limpiar();
    this.nAction = 1;// TODO add your handling code here:
}//GEN-LAST:event_BtnNueActionPerformed

private void BtnGuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuarActionPerformed
Guardar();
    cargar("");// TODO add your handling code here:
}//GEN-LAST:event_BtnGuarActionPerformed

private void BtneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtneditActionPerformed
 Editar();// TODO add your handling code here:
}//GEN-LAST:event_BtneditActionPerformed

private void BtnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliActionPerformed
Eliminar();// TODO add your handling code here:
}//GEN-LAST:event_BtnEliActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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
        
        
        
        dispose();
      }
      else
      {
        JOptionPane.showMessageDialog(null, "0", "ERROR", 0);
      }
      rs.close();
      st.close();
    }
    catch (Exception e) {}// TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
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
        
        String id = rv.getString("id$usu");
        
        String SQL2 = " SELECT * FROM prorolact WHERE Activo ='" + id + "' ";
        
        Statement sd = null;
        sd = this.cn.createStatement();
        ResultSet rc = sd.executeQuery(SQL2);
        rc.next();
        
        String id2 = rc.getString("id$3");
        
        String SQL1 = "UPDATE prorolact set Activo=? WHERE id$3=?";
        PreparedStatement psd = this.cn.prepareStatement(SQL1);
        psd.setString(1, "1");
        psd.setString(2, id2);
        psd.executeUpdate();
         dispose();
        new Thread(new Principal()).start();
        String SQL3 = "UPDATE prorolact set Activo=? WHERE id$3=?";
        PreparedStatement psd2 = this.cn.prepareStatement(SQL3);
        psd2.setString(1, id);
        psd2.setString(2, id2);
        psd2.executeUpdate();
        
       
      }
      else
      {
        JOptionPane.showMessageDialog(null, "0", "ERROR", 0);
      }
      rs.close();
      st.close();
    }
    catch (Exception e) {}// TODO add your handling code here:
}//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Registro$estudiantil1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro$estudiantil1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro$estudiantil1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro$estudiantil1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Registro$estudiantil1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Boxsecc;
    private javax.swing.JComboBox Boxsex;
    private javax.swing.JButton BtnEli;
    private javax.swing.JButton BtnGuar;
    private javax.swing.JButton BtnNue;
    private javax.swing.JButton Btnedit;
    private javax.swing.JLabel LBF;
    private javax.swing.JTable PersTabla;
    private javax.swing.JTextField TxtApe;
    private javax.swing.JTextField TxtCedC;
    private javax.swing.JTextField TxtCedu;
    private javax.swing.JTextField TxtNom;
    private javax.swing.JTextField Txtedad;
    private javax.swing.JComboBox boxa;
    private javax.swing.JLabel est;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
