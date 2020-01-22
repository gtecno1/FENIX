/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RegAlimentos1.java
 *
 * Created on 06-ago-2016, 11:45:36
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author GERALDO J
 */
public class RegAlimentos extends javax.swing.JFrame {
DefaultTableModel model;
  conexionMySQL cc = new conexionMySQL();
  Connection cn = this.cc.Conectar();
  int Accion;
  String idIn;
  public static String fechaActual1()
  {
    Date fecha = new Date();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MMM/yyy");
    return formatoFecha.format(fecha);
  }
    /** Creates new form RegAlimentos1 */
    public RegAlimentos() {
        setUndecorated(true);
        initComponents();
       
        i();
    Inhabilitar();
    cargar("");
    Bloqueo();
    DesbP();
    this.TxtFec.setText(fechaActual1());
    setTitle("Inventario ");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(2);
    setLocationRelativeTo(null);
    setTitle("Registro de alimentos ");
    }
 void i()
  {
    Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/ful3.png"));
    
    setIconImage(icon);
    setVisible(true);
  }
  
 
  
  void Bloqueo()
  {
    this.BtnAgregar.setEnabled(false);
    this.btnEditar.setEnabled(false);
    this.btnEli.setEnabled(false);
  }
  
  void cargar(String valor)
  {
    try
    {
      String[] titulos = { "Id", "Producto", "Cantidad", "Medida", "Unidad", "Descripcion", "fecha ingre" };
      String[] registros = new String[7];
      this.model = new DefaultTableModel((Object[][])null, titulos);
      
      String cons = "select * from inventario where CONCAT (idinventario,'',producto) LIKE '%" + valor + "%'";
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(cons);
      while (rs.next())
      {
        registros[0] = rs.getString("idinventario");
        registros[1] = rs.getString("producto");
        registros[2] = rs.getString("cantidad");
        registros[3] = rs.getString("unidad_medida");
        registros[4] = rs.getString("etiqueta");
        registros[5] = rs.getString("descripcion");
        registros[6] = rs.getString("fecha_ingre");
       
        this.model.addRow(registros);
      }
      
      this.Tbl_Inventario.setModel(this.model);
      this.Tbl_Inventario.getColumnModel().getColumn(0).setPreferredWidth(50);
      this.Tbl_Inventario.getColumnModel().getColumn(1).setPreferredWidth(100);
      this.Tbl_Inventario.getColumnModel().getColumn(2).setPreferredWidth(100);
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
  }
  
  void limpiar()
  {
       
    this.jproducto.setSelectedItem("Seleccione");
    this.txtcantidad.setText("");
    this.txtunimed.setText("");
    this.txtdescripcion.setText("");
  }
  
  void Inhabilitar()
  {
      jPanel2.setVisible(false);
       jSpinner1.setEnabled(false);
    this.jproducto.setEnabled(false);
    this.txtcantidad.setEnabled(false);
    this.txtunimed.setEnabled(false);
    this.txtdescripcion.setEnabled(false);
  }
  
  void Habilitar()
          
  {
      jSpinner1.setEnabled(true);
       jPanel2.setVisible(true);
    this.jproducto.setEnabled(true);
    this.txtcantidad.setEnabled(true);
    this.txtunimed.setEnabled(true);
    this.txtdescripcion.setEnabled(true);
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
      
      String id = rs2.getString("idactide");
      if (id.equals("1")) {
        this.BtnAgregar.setEnabled(true);
      }
      if (id.equals("2")) {
        this.btnEditar.setEnabled(true);
      }
      if (id.equals("3")) {
        this.btnEli.setEnabled(true);
      }
      if (id.equals("4"))
      {
        this.BtnAgregar.setEnabled(true);
        this.btnEditar.setEnabled(true);
        this.btnEli.setEnabled(true);
      }
      if (id.equals("5"))
      {
        this.BtnAgregar.setEnabled(true);
        this.btnEditar.setEnabled(true);
      }
      if (id.equals("6"))
      {
        this.btnEditar.setEnabled(true);
        this.btnEli.setEnabled(true);
      }
      if (id.equals("7"))
      {
        this.BtnAgregar.setEnabled(true);
        
        this.btnEli.setEnabled(true);
      }
      if (id.equals("8"))
      {
        this.BtnAgregar.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEli.setEnabled(false);
      }
    }
    catch (SQLException ex)
    {
      ex.printStackTrace();
    }
  }
  
  public void Editar()
  {
    limpiar();
    Habilitar();
    
    this.Accion = 2;
    
    String cod = JOptionPane.showInputDialog("Introdusca Codigo ");
    try
    {
        Statement sv = this.cn.createStatement();
        ResultSet rd = sv.executeQuery("SELECT * FROM inventario WHERE idinventario ='" + cod + "'");
        rd.last();
        int encontrado = rd.getRow();
        if (encontrado == 1)
        {
      String SQL = " SELECT * FROM inventario WHERE idinventario = " + cod;
      
      Statement st = null;
      st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(SQL);
      rs.next();
       
      this.idIn = rs.getString("idinventario");
      this.jproducto.setSelectedItem(rs.getString("producto"));
      this.txtdescripcion.setText(rs.getString("descripcion"));
      this.txtunimed.setText(rs.getString("unidad_medida"));
       jSpinner1.setValue(rs.getString("etiqueta"));
      this.txtcantidad.setText(rs.getString("cantidad"));
        }else{
            JOptionPane.showMessageDialog(null, "No existe");
        }
        }
        
    catch (SQLException ex) {}
  }
  
  void Eliminar()
  {
    try
    {
      limpiar();
      String ci = JOptionPane.showInputDialog("Codigo");
      Statement sv = this.cn.createStatement();
        ResultSet rd = sv.executeQuery("SELECT * FROM inventario WHERE idinventario ='" + ci + "'");
        rd.last();
        int encontrado = rd.getRow();
        if (encontrado == 1)
        {
      String SQL = " SELECT * FROM inventario WHERE idinventario = '" + ci + "'";
      
      Statement st = null;
      st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(SQL);
      
      rs.next();
      
      this.idIn = rs.getString("idinventario");
      this.jproducto.setSelectedItem(rs.getString("producto"));
      this.txtdescripcion.setText(rs.getString("descripcion"));
      this.txtunimed.setText(rs.getString("unidad_medida"));
      jSpinner1.setValue(rs.getString("etiqueta"));
      this.txtcantidad.setText(rs.getString("cantidad"));
      Habilitar();
      int resp = JOptionPane.showConfirmDialog(this, "Deseas Eliminarlo", "Eliminar Dato", 0);
      if (resp == 0) {
        try
        {
          PreparedStatement psd = null;
          SQL = " DELETE FROM inventario WHERE idinventario ='" + ci + "'";
          psd = this.cn.prepareStatement(SQL);
          psd.execute();
          psd.close();
          Inhabilitar();
          limpiar();
          JOptionPane.showMessageDialog(this, "Registro Eliminado");
          cargar("");
        }
        
        catch (SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "Error SQL no se Eliminaron");
        }
      }
    }else{
     JOptionPane.showMessageDialog(null, "No existe");
}
    }
    catch (SQLException ex)
    {
      Logger.getLogger(Registro$estudiantil1.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel3 = new javax.swing.JPanel();
        BtnNuevo = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEli = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtunimed = new javax.swing.JTextField();
        lblProducto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jproducto = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tbl_Inventario = new javax.swing.JTable();
        Txtbuscar = new javax.swing.JTextField();
        lblProducto1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtFec = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setOpaque(false);

        BtnNuevo.setBackground(new java.awt.Color(0, 0, 0));
        BtnNuevo.setFont(new java.awt.Font("Tahoma", 1, 11));
        BtnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/Imagen3.png"))); // NOI18N
        BtnNuevo.setText("     NUEVO");
        BtnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        BtnAgregar.setBackground(new java.awt.Color(0, 0, 0));
        BtnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11));
        BtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/Imagen4.png"))); // NOI18N
        BtnAgregar.setText("GUARDAR");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(0, 0, 0));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/Imagen5.png"))); // NOI18N
        btnEditar.setText("   EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEli.setBackground(new java.awt.Color(0, 0, 0));
        btnEli.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnEli.setForeground(new java.awt.Color(255, 255, 255));
        btnEli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/Imagen6.png"))); // NOI18N
        btnEli.setText("ELIMINAR");
        btnEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(btnEli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEli, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 90, 160, 340);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 255)));
        jPanel2.setLayout(null);

        txtdescripcion.setColumns(20);
        txtdescripcion.setFont(new java.awt.Font("Arial", 1, 12));
        txtdescripcion.setRows(5);
        jScrollPane1.setViewportView(txtdescripcion);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 210, 260, 110);

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jLabel2.setText("CANTIDAD");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(100, 70, 70, 17);

        txtcantidad.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel2.add(txtcantidad);
        txtcantidad.setBounds(80, 90, 96, 29);

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jLabel3.setText("UNIDAD DE MEDIDA");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 130, 117, 17);

        txtunimed.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtunimed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtunimedActionPerformed(evt);
            }
        });
        jPanel2.add(txtunimed);
        txtunimed.setBounds(10, 150, 110, 29);

        lblProducto.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        lblProducto.setText("PRODUCTO");
        jPanel2.add(lblProducto);
        lblProducto.setBounds(100, 20, 65, 17);

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jLabel4.setText("DESCRIPCION");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(90, 190, 79, 17);

        jSpinner1.setFont(new java.awt.Font("Tahoma", 1, 10));
        jSpinner1.setModel(new javax.swing.SpinnerListModel(new String[] {"g(gramo)", "kg(Kilogramo)", "mg(Miligramo)", "gl(Galon)", "l(Litro)", "ml(Mililitro)"}));
        jSpinner1.setToolTipText("");
        jSpinner1.setOpaque(false);
        jPanel2.add(jSpinner1);
        jSpinner1.setBounds(130, 150, 120, 30);

        jproducto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jproducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Arroz", "Pasta", "Caraota", "Lentejas", "Arbejas", "Leche", "Azucar", "Mantequilla", "Azeite", "Carne", "Pollo", "--HORTALIZAS--", "Papa", "Cebolla", "Zanahoria", "Tomate", "Pimenton", "Aji", "Repollo", "Verengena", "Pepino", "Auyama", "Yuca", "Platano", "Ocumo", "Ñame", "Apio", "Remolacha", "--FRUTAS--", "Naranja", "Mandarina", "Piña", "Patilla", "Lechoza", "Melon", "Guayaba", " " }));
        jPanel2.add(jproducto);
        jproducto.setBounds(30, 40, 200, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/verdSDFSD.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel6);
        jLabel6.setBounds(0, 0, 260, 340);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(170, 100, 260, 340);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(51, 51, 51)));
        jPanel4.setLayout(null);

        Tbl_Inventario.setFont(new java.awt.Font("Tahoma", 1, 12));
        Tbl_Inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tbl_Inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_InventarioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tbl_Inventario);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(0, 50, 540, 279);

        Txtbuscar.setFont(new java.awt.Font("Tahoma", 1, 14));
        Txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtbuscarKeyReleased(evt);
            }
        });
        jPanel4.add(Txtbuscar);
        Txtbuscar.setBounds(12, 13, 179, 29);

        lblProducto1.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        lblProducto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/search.png"))); // NOI18N
        lblProducto1.setText("BUSQUEDA");
        jPanel4.add(lblProducto1);
        lblProducto1.setBounds(200, 10, 110, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/ffff.png"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel7);
        jLabel7.setBounds(0, 0, 540, 340);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(440, 100, 540, 340);

        TxtFec.setBackground(new java.awt.Color(51, 153, 0));
        TxtFec.setEditable(false);
        TxtFec.setFont(new java.awt.Font("Tahoma", 0, 18));
        TxtFec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtFec.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        TxtFec.setOpaque(false);
        jPanel1.add(TxtFec);
        TxtFec.setBounds(0, 450, 160, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11));
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
        jButton1.setBounds(860, 450, 110, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton2.setText("PRINCIPAL  #");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(750, 450, 110, 30);

        jLabel5.setBackground(new java.awt.Color(0, 204, 255));
        jLabel5.setFont(new java.awt.Font("Bodoni MT Black", 1, 24));
        jLabel5.setText("                   G  E  S  T  I  O  N   D E   D   E   P   O   S   I   T   O");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 40, 990, 40);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel13.setText("DATOS DEL PRODUCTO");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel13.setOpaque(true);
        jPanel1.add(jLabel13);
        jLabel13.setBounds(190, 80, 220, 20);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel10.setText("CONSULTA DE PRODUCTOS");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(590, 80, 250, 22);

        jLabel11.setBackground(new java.awt.Color(0, 204, 255));
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 102), new java.awt.Color(255, 102, 102)));
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(870, 450, 90, 30);

        jLabel12.setBackground(new java.awt.Color(0, 204, 255));
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel12.setOpaque(true);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(760, 450, 90, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/foto1.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 990, 490);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(240, 40, 360, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel14.setText("DATOS DEL PRODUCTO");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(220, 80, 180, 17);

        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(830, 440, 34, 14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
 
    Habilitar();
    this.Accion = 1;// TODO add your handling code here:
}//GEN-LAST:event_BtnNuevoActionPerformed

private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
String prod= String.valueOf(this.jproducto.getSelectedItem());
    String cant = this.txtcantidad.getText();
    String UMed = this.txtunimed.getText();
    String desc = this.txtdescripcion.getText();
    String Fech = this.TxtFec.getText();
    String u=String.valueOf(jSpinner1.getValue());
    
    String SQL;
    PreparedStatement psd;
    switch (this.Accion)
    {
    case 1: 
        if(prod.isEmpty() || cant.isEmpty() || UMed.isEmpty() ||desc.isEmpty() || Fech.isEmpty() || u.isEmpty())
       {
          new Thread(new vacio()).start();
       }
        else{
      SQL = "INSERT INTO inventario (producto,descripcion,unidad_medida,etiqueta,cantidad,fecha_ingre) VALUES (?,?,?,?,?,?)";
      try
      {
        psd = this.cn.prepareStatement(SQL);
        psd.setString(1, prod);
        psd.setString(2, desc);
        psd.setString(3, UMed);
        psd.setString(4, u);
        psd.setString(5, cant);
        psd.setString(6, Fech);
        
       
        
        int n = psd.executeUpdate();
        if (n > 0)
        {
          new Thread(new correcto1()).start();
          
          limpiar();
          Inhabilitar();
          this.BtnNuevo.setEnabled(true);
        }
      }
      catch (SQLException ex)
      {
        new Thread(new incorrecto()).start();
      }
      cargar("");
        }
      
      break;
    case 2: 
         if(prod.isEmpty() || cant.isEmpty() || UMed.isEmpty() ||desc.isEmpty() || Fech.isEmpty() || u.isEmpty())
       {
          new Thread(new vacio()).start();
       }
        else{
      SQL = "UPDATE inventario set idinventario=?, producto=?, descripcion=?,unidad_medida=?,etiqueta=?,cantidad=? WHERE idinventario=?";
      try
      {
        psd = this.cn.prepareStatement(SQL);
        psd.setString(1, this.idIn);
        psd.setString(2, prod);
        psd.setString(3, desc);
        psd.setString(4, UMed);
        psd.setString(5, u);
        
        psd.setString(6, cant);
        
        psd.setString(7, this.idIn);
        int n = psd.executeUpdate();
        if (n > 0)
        {
          limpiar();
          Inhabilitar();
          new Thread(new correcto1()).start();
        }
      }
      catch (SQLException ex)
      {
        new Thread(new incorrecto()).start();
      }
      cargar("");
         }
      
    }// TODO add your handling code here:
}//GEN-LAST:event_BtnAgregarActionPerformed

private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
 Editar();// TODO add your handling code here:
}//GEN-LAST:event_btnEditarActionPerformed

private void btnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliActionPerformed
 Eliminar();// TODO add your handling code here:
}//GEN-LAST:event_btnEliActionPerformed

private void txtunimedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtunimedActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtunimedActionPerformed

private void Tbl_InventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_InventarioMouseClicked
 int i = this.Tbl_Inventario.getSelectedRow();
    String codigo = (String)this.Tbl_Inventario.getValueAt(i, 0);
    String prod = (String)this.Tbl_Inventario.getValueAt(i, 1);
    String disp = (String)this.Tbl_Inventario.getValueAt(i, 2);
    
    String desc = JOptionPane.showInputDialog("Cantidad a Egresar / Ingrasar:");
    int dispinible = Integer.parseInt(disp);
    int descuento = Integer.parseInt(desc);
  int total =dispinible +descuento;
  
    if (total < 0 )
    {
      JOptionPane.showMessageDialog(null, "No hay disponible la cantidad que se desea Egresar");
    }
    else
    {
      int dispfinal = dispinible + descuento;
      String modi = "UPDATE inventario SET cantidad='" + dispfinal + "' WHERE idinventario = '" + codigo + "'";
      try
      {
        PreparedStatement pst = this.cn.prepareStatement(modi);
        pst.executeUpdate();
        cargar("");
        new Thread(new correcto1()).start();
      }
      catch (Exception e)
      {
        new Thread(new incorrecto()).start();
      }
    }// TODO add your handling code here:
}//GEN-LAST:event_Tbl_InventarioMouseClicked

private void TxtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtbuscarKeyReleased
 cargar(this.Txtbuscar.getText());// TODO add your handling code here:
}//GEN-LAST:event_TxtbuscarKeyReleased

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
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
            java.util.logging.Logger.getLogger(RegAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RegAlimentos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JTable Tbl_Inventario;
    private javax.swing.JTextField TxtFec;
    private javax.swing.JTextField Txtbuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEli;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JComboBox jproducto;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblProducto1;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextArea txtdescripcion;
    private javax.swing.JTextField txtunimed;
    // End of variables declaration//GEN-END:variables
}
