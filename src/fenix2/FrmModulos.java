/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmModulos.java
 *
 * Created on 30-ene-2016, 9:58:42
 */
package fenix2;

import Conexion_Base_de_Datos.conexionMySQL;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Geraldo Andres
 */
public class FrmModulos extends javax.swing.JFrame {
     DefaultTableModel model;
      String co,no,ap,ro,rol1;
     int op;
    
 conexionMySQL cc = new conexionMySQL();
       Connection cn = cc.Conectar(); 
       String Car,Ac="1",id,id1;
       String Pro,A="0",C="0",D="0",T="0",COM="0",RE="0";
        String Act,Act2,Act3,G="0";
        String G1="0",E1="0",El1="0",To1="0";
         String G2="0",E2="0",El2="0",To2="0";
          String G3="0",E3="0",El3="0",To3="0";
           String G4="0",To4="0";
       int Accion;
       int ng,ng1,ng2;
    /** Creates new form FrmModulos */
    public FrmModulos() {
        setUndecorated(true);
        initComponents();
        i();
        nrol.setVisible(false);
       
         Bloquiar();
        bloqueo2();
         bloqueo1();
          bloqueoB();
        DesbP(); 
   
          bloqueo3();
           bloqueo4();
            bloqueo11();
        cargarusuarios();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
       
    
    }
    void nuevorol(){
    String roln = String.valueOf(this.nrol.getSelectedItem());
    if(roln.equals("Sub director")){
      Car="6";
        
    }
    if(roln.equals("Secretario(a)")){
      Car="7";
        
    }
    if(roln.equals("Cosinero")){
      Car="8";
        
    }
    if(roln.equals("Encargado")){
      Car="9";
        
    }
    if(roln.equals("Profesor")){
      Car="10";
        
    }
    if(roln.equals("Obrero")){
      Car="11";
        
    }
    if(roln.equals("Visitante")){
      Car="12";
        
    }
    rdior.setText(roln);
    nrol.setVisible(false);
}
    void i(){
    Image icon;
    icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/ful3.png"));
  
            
            
    setIconImage(icon);
    setVisible(true);
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
                  
          id=(rs2.getString("idactiro"));
          
         
            if(id.equals("1"))
                {
            BtnG.setEnabled(true);   
            }
          if(id.equals("2"))
                {
          btnEd.setEnabled(true);   
            }
           if(id.equals("3"))
                {
         btnElm.setEnabled(true);   
            }
            if(id.equals("4"))
                {
                 BtnG.setEnabled(true);
                  btnEd.setEnabled(true); 
                    btnElm.setEnabled(true);   
            }
          if(id.equals("5"))
                {
                    BtnG.setEnabled(true);
                  btnEd.setEnabled(true); 
                   
                    
            }
          if(id.equals("6"))
                {
                   
                  btnEd.setEnabled(true); 
                    btnElm.setEnabled(true);   
            }
          if(id.equals("7"))
                {
                    BtnG.setEnabled(true);
                 
                    btnElm.setEnabled(true);    
            }
          if(id.equals("8"))
                {
                    BtnG.setEnabled(false);
                  btnEd.setEnabled(false); 
                    btnElm.setEnabled(false);    
            }
          
          
          
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
  void  bloqueoB(){
         BtnG.setEnabled(false);
                  btnEd.setEnabled(false); 
                    btnElm.setEnabled(false);    
    }
    void selecP(){
          if(rre.isSelected()){
  RE="8";
  
    
}
          else{
              RE="0";
                bloqueo3();
              
          }
          if(rcom.isSelected()){
  COM="9";
  
    
}
          else{
              COM="0";
          }
       if(radioDe.isSelected()){
  D="2";
  
    
}
else{
    D="0";
} 
       if(radioCo.isSelected()){
  C="1";  
  
    
}
else{
    C="0";
}
       if(radioAd.isSelected()){
  A="3";  
   
}
else{
    A="0";
}
       if(radioTo20.isSelected()){
  T="4";  

}
       else{
        T="0";     
       }
      
    }
     void selec1A(){
      if(radioG.isSelected()){
          
  G="1";  
    
}
else{
    G="8";
}
     
    }
     void selec2A(){
      if(radioG1.isSelected()){
          
  G1="1";  
    
}
else{
    G1="0";
}
      if(radioE1.isSelected()){
          
  E1="2";  
    
}
else{
    E1="0";
}
   if(radioEl1.isSelected()){
 
       El1="3";  
    
}
else{
    El1="0";
}
   if(radioTo2.isSelected()){
  To1="4";  
 
   
}else{
       To1="0";
   }
    }
     void selec3A(){
      if(radioG2.isSelected()){
          
  G2="1";  
    
}
else{
    G2="0";
}
      if(radioE2.isSelected()){
          
  E2="2";  
    
}
else{
    E2="0";
}
   if(radioEl2.isSelected()){
 
       El2="3";  
    
}
else{
    El2="0";
}
   if(radioTo3.isSelected()){
  To3="4";  
 
   
}else{
       To3="0";
   }
    }
     void selec4A(){
      if(radioG3.isSelected()){
          
  G3="1";  
    
}
else{
    G3="0";
}
      if(radioE3.isSelected()){
          
  E3="2";  
    
}
else{
    E3="0";
}
   if(radioEl3.isSelected()){
 
       El3="3";  
    
}
else{
    El3="0";
}
   if(radioTo4.isSelected()){
  To4="4";  
 
   
}else{
       To4="0";
   }
    }
     void selec5A(){
      if(radioG4.isSelected()){
          
  G4="1";  
    
}
else{
    G4="8";
}

    }
    void suma(){
        Pro=A+C+D+T+RE+COM;
        if(Pro.equals("300000")){
            Pro="3";
        }
         if(Pro.equals("010000")){
            Pro="1";
        }
        if(Pro.equals("002000")){
            Pro="2";
        }
        if(Pro.equals("012000")){
            Pro="5";
        }
        if(Pro.equals("302000")){
            Pro="6";
        }
         if(Pro.equals("310000")){
            Pro="7";
        }
         if(Pro.equals("000400")){
            Pro="4";
        }
          if(Pro.equals("000080")){
            Pro="8";
        }
          if(Pro.equals("000009")){
            Pro="9";
        }
         if(Pro.equals("000089")){
            Pro="10";
        }
         if(Pro.equals("010009")){
            Pro="11";
        }
          if(Pro.equals("300009")){
            Pro="12";
        }
           if(Pro.equals("002009")){
            Pro="13";
        }
            if(Pro.equals("010080")){
            Pro="14";
        }
             if(Pro.equals("002080")){
            Pro="15";
        }
             if(Pro.equals("300080")){
            Pro="16";
        }
              if(Pro.equals("312000")){
            Pro="17";
        }
               if(Pro.equals("300089")){
            Pro="18";
        }
                  if(Pro.equals("010089")){
            Pro="19";
        }
                    if(Pro.equals("002089")){
            Pro="20";
        }
                      if(Pro.equals("302080")){
            Pro="21";
        }
                        if(Pro.equals("310080")){
            Pro="22";
        }
                         if(Pro.equals("302009")){
            Pro="23";
        }
                          if(Pro.equals("310009")){
            Pro="24";
        }
                  if(Pro.equals("312009")){
            Pro="25";
        }
                   if(Pro.equals("312080")){
            Pro="26";
        }
                    if(Pro.equals("012089")){
            Pro="27";
        }
                     if(Pro.equals("310089")){
            Pro="28";
        }
                      if(Pro.equals("302089")){
            Pro="29";
        }
                    if(Pro.equals("312089")){
            Pro="4";
        }
                    
           
    } 
    void suma2(){
        Act=El1+G1+E1+To1;
        if(Act.equals("3120")){
            Act="4";
        }
        if(Act.equals("3000")){
            Act="3";
        }
         if(Act.equals("0100")){
            Act="1";
        }
        if(Act.equals("0020")){
            Act="2";
        }
        if(Act.equals("0120")){
            Act="5";
        }
        if(Act.equals("3020")){
            Act="6";
        }
         if(Act.equals("3100")){
            Act="7";
        }
         if(Act.equals("0004")){
           Act="4";
        }
          if(Act.equals("0000")){
           Act="8";
        }   
        
    }
   
       void suma3(){
        Act2=El2+G2+E2+To3;
        if(Act2.equals("3120")){
            Act2="4";
        }
        if(Act2.equals("3000")){
            Act2="3";
        }
         if(Act2.equals("0100")){
            Act2="1";
        }
        if(Act2.equals("0020")){
            Act2="2";
        }
        if(Act2.equals("0120")){
            Act2="5";
        }
        if(Act2.equals("3020")){
            Act2="6";
        }
         if(Act2.equals("3100")){
            Act2="7";
        }
         if(Act2.equals("0004")){
           Act2="4";
        }
          if(Act2.equals("0000")){
           Act2="8";
        }   
        
    }
       void suma4(){
        Act3=El3+G3+E3+To4;
        if(Act3.equals("3120")){
            Act3="4";
        }
        if(Act3.equals("3000")){
            Act3="3";
        }
         if(Act3.equals("0100")){
            Act3="1";
        }
        if(Act3.equals("0020")){
            Act3="2";
        }
        if(Act3.equals("0120")){
            Act3="5";
        }
        if(Act3.equals("3020")){
            Act3="6";
        }
         if(Act3.equals("3100")){
            Act3="7";
        }
         if(Act3.equals("0004")){
           Act3="4";
        }
          if(Act3.equals("0000")){
           Act3="8";
        }   
        
    }
       void desbloqueo1(){
            radioG.setVisible(true);
               
            radioG.setEnabled(true);
               
       }
        void desbloqueo11(){
            radioG1.setVisible(true);
               radioE1.setVisible(true);
                radioEl1.setVisible(true);
                 radioTo2.setVisible(true);
            radioG1.setEnabled(true);
               radioE1.setEnabled(true);
                radioEl1.setEnabled(true);
                 radioTo2.setEnabled(true);
       }
         void desbloqueo2(){
            radioG2.setVisible(true);
               radioE2.setVisible(true);
                radioEl2.setVisible(true);
                 radioTo3.setVisible(true);
            radioG2.setEnabled(true);
               radioE2.setEnabled(true);
                radioEl2.setEnabled(true);
                 radioTo3.setEnabled(true);
       }
          void desbloqueo3(){
            radioG3.setVisible(true);
               radioE3.setVisible(true);
                radioEl3.setVisible(true);
                 radioTo4.setVisible(true);
            radioG3.setEnabled(true);
               radioE3.setEnabled(true);
                radioEl3.setEnabled(true);
                 radioTo4.setEnabled(true);
       }
           void desbloqueo4(){
            radioG4.setVisible(true);
               
            radioG4.setEnabled(true);
              
       }
       void bloqueo1(){
           radioG.setVisible(false);
              
          
       }
        void bloqueo11(){
           radioG1.setVisible(false);
               radioE1.setVisible(false);
                radioEl1.setVisible(false);
                 radioTo2.setVisible(false);
          
       }
        void bloqueo2(){
           radioG2.setVisible(false);
               radioE2.setVisible(false);
                radioEl2.setVisible(false);
                 radioTo3.setVisible(false);
        }
        void bloqueo3(){
           radioG3.setVisible(false);
               radioE3.setVisible(false);
                radioEl3.setVisible(false);
                 radioTo4.setVisible(false);
        }
         void bloqueo4(){
           radioG4.setVisible(false);
              
        }
    void Bloquiar(){
         jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        rdior.setEnabled(false);
        radioA.setEnabled(false);
         radioC.setEnabled(false);
          radioT.setEnabled(false);
           radioCo.setEnabled(false);
            radioDe.setEnabled(false);
             radioAd.setEnabled(false);
             rre.setEnabled(false);
               rcom.setEnabled(false);
                 radioTo20.setEnabled(false);
             tblusuarios.setEnabled(false);
             rN.setEnabled(false);
    }
     void Desbloquear(){
         jPanel2.setVisible(true);
         jPanel3.setVisible(true);
        jPanel4.setVisible(true);
         rdior.setEnabled(true);
        radioA.setEnabled(true);
         radioC.setEnabled(true);
          radioT.setEnabled(true);
           radioCo.setEnabled(true);
            radioDe.setEnabled(true);
             radioAd.setEnabled(true);
              radioTo20.setEnabled(true);
              rre.setEnabled(true);
               rcom.setEnabled(true);
                  tblusuarios.setEnabled(true);
                  rN.setEnabled(true);
    }
     void limpiar2(){
         radioG.setSelected(false);
               radioE1.setSelected(false);
                radioEl1.setSelected(false);
                 radioTo2.setSelected(false);
                 radioG1.setSelected(false);
               radioE2.setSelected(false);
                radioEl2.setSelected(false);
                 radioTo3.setSelected(false);
                 radioG2.setSelected(false);
                  radioG3.setSelected(false);
               radioE3.setSelected(false);
                radioEl3.setSelected(false);
                 radioTo4.setSelected(false);
                 radioG4.setSelected(false); 
     }
     void Limpiar(){
         rdior.setSelected(false);
         rN.setSelected(false);
        radioA.setSelected(false);
         radioC.setSelected(false);
          radioT.setSelected(false);
           radioCo.setSelected(false);
            radioDe.setSelected(false);
             radioAd.setSelected(false);
             rre.setSelected(false);
               rcom.setSelected(false);
                 radioTo20.setSelected(false);
                
            
    }
      void cargarusuarios() {
         String f,r;
        
      
        try{
            String [] titulos={"CODIGO","NOMBRE","APELLIDO","ROL"};
           
            String [] registros= new String[4];
            model=new DefaultTableModel(null,titulos);
            
            String cons="select * from usuario";
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while(rs.next()){
                registros[0]=rs.getString("id$usu");
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("apellido");
                             
                 registros[3]=rs.getString("rol");
               if( registros[3].equals("1")){
                  registros[3]="Director";  
               }
                 if( registros[3].equals("2")){
                  registros[3]="Coordinador";  
               }
               if( registros[3].equals("3")){
                  registros[3]="Trabajador";  
               }
                if( registros[3].equals("4")){
                  registros[3]="Desactivado";  
               }
                if( registros[3].equals("5")){
                  registros[3]="Ninguno";  
               }
                 if( registros[3].equals("6")){
                  registros[3]="Sub director";  
               }
                 if( registros[3].equals("7")){
                  registros[3]="Secretario(a)";  
               }
                 if( registros[3].equals("8")){
                  registros[3]="Cosinero";  
               }
                 if( registros[3].equals("9")){
                  registros[3]="Encargado";  
               }
                 if( registros[3].equals("10")){
                  registros[3]="Profesor";  
               }
                 if( registros[3].equals("11")){
                  registros[3]="Obrero";  
               }
                 if( registros[3].equals("12")){
                  registros[3]="Visitante";  
               }
                model.addRow(registros);      
                }
          tblusuarios.setModel(model);
           tblusuarios.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblusuarios.getColumnModel().getColumn(1).setPreferredWidth(100);
             tblusuarios.getColumnModel().getColumn(2).setPreferredWidth(100);
             tblusuarios.getColumnModel().getColumn(3).setPreferredWidth(100);
            }catch(Exception e){
                System.out.println(e.getMessage());
                 }
}
   void Gua(){
     suma();
      
       String SQL;
         PreparedStatement psd;
       switch(op){
            case 3:
                                try{
                                SQL= "UPDATE usuario set id$usu=?, nombre=?, apellido=?,rol=? WHERE id$usu=?";
                                  
                                 
                                  psd=cn.prepareStatement(SQL);
                                  psd.setString(1,co);
                              psd.setString(2,no);
                              psd.setString(3,ap);
                              psd.setString(4,Car);
                               psd.setString(5,co);
                                   
                                       ng= psd.executeUpdate();
                                      
                                      if (ng>0) {
                                           cargarusuarios();
                                         
                                   
                                      }
                   
        } catch (SQLException ex) {
        
        }
      break; 
           
       }
   } 
   void Guardar(){
      
       suma();
       selec1A();
       selec2A();
       selec3A();
        selec4A();
       
       suma2();
       suma3();
       suma4();
      selec5A();
            String SQL;
             
            
           PreparedStatement psd;
             
             switch(Accion){
                 
                  case 1:
               if(radioA.isSelected()|| radioC.isSelected()||radioT.isSelected()||rdior.isSelected()||rN.isSelected()) {
                   
                     
              if(Pro.equals("000000"))
              {
                   new Thread(new incorrecto7()).start();
              }
              else{
                      
                      SQL="INSERT INTO prorolact(id$rol,id$pro,idactiro,idactide,idactireg,idacticol,idacticon,Activo)VALUES (?,?,?,?,?,?,?,?)";
               try{
                      
                   psd = cn.prepareStatement(SQL);
                   psd.setString(1,Car);
                   psd.setString(2,Pro);
                   psd.setString(3,Act2);
                    psd.setString(4,Act);
                     psd.setString(5,Act3);
                       psd.setString(6,G);
                        psd.setString(7,G4);
                        
                   psd.setString(8,co);
                
                  
                   
                 ng1= psd.executeUpdate();
                   
                 if(ng1>0 && ng>0){
                     Limpiar();
                      limpiar2();
                             Bloquiar();
                              bloqueo1();
                          bloqueo11();
                           bloqueo2();
                            bloqueo3();
                             bloqueo4();
                    cargarusuarios();
                   new Thread(new correcto1()).start();
                   
               }
                
                   } 
               catch(SQLException ex)  { 
                  
                  new Thread(new incorrecto6()).start();
                 
               }  
                  
              }
               }else{
                 new Thread(new incorrecto8()).start();   
               }
            
                      break;
                       case 2: 
                            
                 if(radioA.isSelected()|| radioC.isSelected()||radioT.isSelected()||rdior.isSelected()||rN.isSelected()) {      
              if(Pro.equals("000000"))
              {
                   new Thread(new incorrecto7()).start();
              }
              else{
                      
                       SQL= "UPDATE prorolact set id$3=?, id$rol=?, id$pro=?,idactiro=?,idactide=?,idactireg=?,idacticol=?,idacticon=?, Activo=? WHERE id$3=?";
                       
                       try {
                       psd=cn.prepareStatement(SQL);
                         psd.setString(1,id);
                        psd.setString(2,Car);
                   psd.setString(3,Pro);
                   psd.setString(4,Act2);
                    psd.setString(5,Act);
                     psd.setString(6,Act3);
                       psd.setString(7,G);
                        psd.setString(8,G4);
                         psd.setString(9,co);
                         
                    psd.setString(10,id);
                           ng2= psd.executeUpdate();
                           if (ng2>0&& ng>0) {
                             Limpiar();
                              limpiar2();
                             Bloquiar();
                              bloqueo1();
                          bloqueo11();
                           bloqueo2();
                            bloqueo3();
                             bloqueo4();
                              cargarusuarios();
                              tblusuarios.setEnabled(true);
                           new Thread(new correcto1()).start();
         
                           }
                       }
                       catch(SQLException ex){
                     new Thread(new incorrecto6()).start();
                       }
              }
                 }else{
                   new Thread(new incorrecto8()).start();   
                 }
                       break;
                            
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
        BtnG = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        radioG = new javax.swing.JRadioButton();
        radioG1 = new javax.swing.JRadioButton();
        radioE1 = new javax.swing.JRadioButton();
        radioEl1 = new javax.swing.JRadioButton();
        radioTo2 = new javax.swing.JRadioButton();
        radioG2 = new javax.swing.JRadioButton();
        radioE2 = new javax.swing.JRadioButton();
        radioEl2 = new javax.swing.JRadioButton();
        radioTo3 = new javax.swing.JRadioButton();
        radioG3 = new javax.swing.JRadioButton();
        radioE3 = new javax.swing.JRadioButton();
        radioEl3 = new javax.swing.JRadioButton();
        radioTo4 = new javax.swing.JRadioButton();
        radioG4 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        btnEd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblusuarios = new javax.swing.JTable();
        btnElm = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        radioTo20 = new javax.swing.JRadioButton();
        radioAd = new javax.swing.JRadioButton();
        radioCo = new javax.swing.JRadioButton();
        radioDe = new javax.swing.JRadioButton();
        rre = new javax.swing.JRadioButton();
        rcom = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        radioA = new javax.swing.JRadioButton();
        radioC = new javax.swing.JRadioButton();
        radioT = new javax.swing.JRadioButton();
        rN = new javax.swing.JRadioButton();
        nrol = new javax.swing.JComboBox();
        rdior = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(null);

        BtnG.setBackground(new java.awt.Color(0, 0, 0));
        BtnG.setFont(new java.awt.Font("Tahoma", 1, 11));
        BtnG.setForeground(new java.awt.Color(255, 255, 255));
        BtnG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/Imagen4.png"))); // NOI18N
        BtnG.setText("GUARDAR");
        BtnG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGActionPerformed(evt);
            }
        });
        jPanel1.add(BtnG);
        BtnG.setBounds(230, 470, 138, 59);

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACTIVIDADES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        radioG.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioG.setText("Guardar");
        radioG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioGMouseClicked(evt);
            }
        });
        radioG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioGActionPerformed(evt);
            }
        });
        jPanel2.add(radioG);
        radioG.setBounds(0, 20, 90, 25);

        radioG1.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioG1.setText("Guardar");
        radioG1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioG1MouseClicked(evt);
            }
        });
        radioG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioG1ActionPerformed(evt);
            }
        });
        jPanel2.add(radioG1);
        radioG1.setBounds(0, 50, 90, 25);

        radioE1.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioE1.setText("Editar");
        radioE1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioE1MouseClicked(evt);
            }
        });
        jPanel2.add(radioE1);
        radioE1.setBounds(90, 50, 70, 25);

        radioEl1.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioEl1.setText("Eliminar");
        radioEl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioEl1MouseClicked(evt);
            }
        });
        jPanel2.add(radioEl1);
        radioEl1.setBounds(160, 50, 80, 25);

        radioTo2.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioTo2.setText("Todo");
        radioTo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioTo2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                radioTo2MousePressed(evt);
            }
        });
        radioTo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTo2ActionPerformed(evt);
            }
        });
        jPanel2.add(radioTo2);
        radioTo2.setBounds(240, 50, 70, 25);

        radioG2.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioG2.setText("Guardar");
        radioG2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioG2MouseClicked(evt);
            }
        });
        radioG2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioG2ActionPerformed(evt);
            }
        });
        jPanel2.add(radioG2);
        radioG2.setBounds(0, 80, 90, 25);

        radioE2.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioE2.setText("Editar");
        radioE2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioE2MouseClicked(evt);
            }
        });
        jPanel2.add(radioE2);
        radioE2.setBounds(90, 80, 70, 25);

        radioEl2.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioEl2.setText("Eliminar");
        radioEl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioEl2MouseClicked(evt);
            }
        });
        jPanel2.add(radioEl2);
        radioEl2.setBounds(160, 80, 80, 25);

        radioTo3.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioTo3.setText("Todo");
        radioTo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioTo3MouseClicked(evt);
            }
        });
        radioTo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTo3ActionPerformed(evt);
            }
        });
        jPanel2.add(radioTo3);
        radioTo3.setBounds(240, 80, 70, 25);

        radioG3.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioG3.setText("Guardar");
        radioG3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioG3MouseClicked(evt);
            }
        });
        radioG3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioG3ActionPerformed(evt);
            }
        });
        jPanel2.add(radioG3);
        radioG3.setBounds(0, 110, 90, 25);

        radioE3.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioE3.setText("Editar");
        radioE3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioE3MouseClicked(evt);
            }
        });
        jPanel2.add(radioE3);
        radioE3.setBounds(90, 110, 70, 25);

        radioEl3.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioEl3.setText("Eliminar");
        radioEl3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioEl3MouseClicked(evt);
            }
        });
        jPanel2.add(radioEl3);
        radioEl3.setBounds(160, 110, 80, 25);

        radioTo4.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioTo4.setText("Todo");
        radioTo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioTo4MouseClicked(evt);
            }
        });
        radioTo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTo4ActionPerformed(evt);
            }
        });
        jPanel2.add(radioTo4);
        radioTo4.setBounds(240, 110, 70, 25);

        radioG4.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioG4.setText("Guardar");
        radioG4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioG4MouseClicked(evt);
            }
        });
        radioG4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioG4ActionPerformed(evt);
            }
        });
        jPanel2.add(radioG4);
        radioG4.setBounds(0, 140, 90, 25);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/EWW.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 20, 310, 190);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(420, 230, 310, 210);

        btnEd.setBackground(new java.awt.Color(0, 0, 0));
        btnEd.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnEd.setForeground(new java.awt.Color(255, 255, 255));
        btnEd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/Imagen5.png"))); // NOI18N
        btnEd.setText("EDITAR");
        btnEd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdActionPerformed(evt);
            }
        });
        jPanel1.add(btnEd);
        btnEd.setBounds(390, 470, 131, 60);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/Imagen3.png"))); // NOI18N
        jButton1.setText("NUEVO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(70, 470, 140, 60);

        tblusuarios.setFont(new java.awt.Font("Tahoma", 1, 14));
        tblusuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblusuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblusuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblusuarios);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 128, 740, 90);

        btnElm.setBackground(new java.awt.Color(0, 0, 0));
        btnElm.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnElm.setForeground(new java.awt.Color(255, 255, 255));
        btnElm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/Imagen6.png"))); // NOI18N
        btnElm.setText("ELIMINAR");
        btnElm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElmActionPerformed(evt);
            }
        });
        jPanel1.add(btnElm);
        btnElm.setBounds(550, 470, 140, 60);

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROCESOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        radioTo20.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioTo20.setText("Todo");
        radioTo20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioTo20MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                radioTo20MousePressed(evt);
            }
        });
        radioTo20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTo20ActionPerformed(evt);
            }
        });
        jPanel3.add(radioTo20);
        radioTo20.setBounds(10, 170, 180, 18);

        radioAd.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioAd.setText("Gestiòn de rol");
        radioAd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioAdMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                radioAdMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                radioAdMouseReleased(evt);
            }
        });
        radioAd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAdActionPerformed(evt);
            }
        });
        jPanel3.add(radioAd);
        radioAd.setBounds(10, 80, 190, 25);

        radioCo.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioCo.setText("Control de Colaboracion");
        radioCo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioCoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                radioCoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                radioCoMouseReleased(evt);
            }
        });
        radioCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCoActionPerformed(evt);
            }
        });
        jPanel3.add(radioCo);
        radioCo.setBounds(10, 20, 200, 25);

        radioDe.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioDe.setText("Gestion de deposito");
        radioDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioDeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                radioDeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                radioDeMouseReleased(evt);
            }
        });
        jPanel3.add(radioDe);
        radioDe.setBounds(10, 50, 200, 25);

        rre.setFont(new java.awt.Font("Tahoma", 1, 14));
        rre.setText("Gestion de estudiante");
        rre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rreMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rreMouseReleased(evt);
            }
        });
        jPanel3.add(rre);
        rre.setBounds(10, 110, 190, 25);

        rcom.setFont(new java.awt.Font("Tahoma", 1, 14));
        rcom.setText("Control del Comedor");
        rcom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rcomMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rcomMouseReleased(evt);
            }
        });
        jPanel3.add(rcom);
        rcom.setBounds(10, 140, 190, 25);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/RDR2.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel3);
        jLabel3.setBounds(0, 20, 210, 190);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(190, 230, 210, 210);

        jPanel4.setBackground(new java.awt.Color(0, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ROLES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setLayout(null);

        radioA.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioA.setText("Director");
        radioA.setBorder(null);
        radioA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioAMouseClicked(evt);
            }
        });
        jPanel4.add(radioA);
        radioA.setBounds(10, 30, 130, 17);

        radioC.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioC.setText("Coordinador");
        radioC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioCMouseClicked(evt);
            }
        });
        jPanel4.add(radioC);
        radioC.setBounds(10, 60, 130, 25);

        radioT.setFont(new java.awt.Font("Tahoma", 1, 14));
        radioT.setText("Trabajador");
        radioT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioTMouseClicked(evt);
            }
        });
        radioT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTActionPerformed(evt);
            }
        });
        jPanel4.add(radioT);
        radioT.setBounds(10, 100, 130, 25);

        rN.setFont(new java.awt.Font("Tahoma", 1, 14));
        rN.setText("Desactivar");
        rN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rNMouseClicked(evt);
            }
        });
        rN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rNActionPerformed(evt);
            }
        });
        jPanel4.add(rN);
        rN.setBounds(10, 180, 132, 25);

        nrol.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nrol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "?", "Sub director", "Cosinero", "Encargado", "Profesor", "Obrero", "Visitante", "Secretario(a)" }));
        nrol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nrolActionPerformed(evt);
            }
        });
        jPanel4.add(nrol);
        nrol.setBounds(30, 140, 110, 30);

        rdior.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdior.setText("?");
        rdior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdiorMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rdiorMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rdiorMouseReleased(evt);
            }
        });
        jPanel4.add(rdior);
        rdior.setBounds(10, 140, 130, 25);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/EWW.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel2);
        jLabel2.setBounds(0, 20, 150, 190);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(20, 230, 150, 210);

        jLabel12.setBackground(new java.awt.Color(0, 204, 255));
        jLabel12.setFont(new java.awt.Font("Bodoni MT Black", 1, 24));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("GESTION DE ROLES");
        jLabel12.setOpaque(true);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(0, 40, 760, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton4.setText("SALIDA-->");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(630, 90, 100, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton3.setText("PRINCIPAL #");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(20, 90, 110, 30);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel14.setText("USUARIOS");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel14.setOpaque(true);
        jPanel1.add(jLabel14);
        jLabel14.setBounds(320, 90, 100, 20);

        jLabel5.setBackground(new java.awt.Color(0, 204, 255));
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 90, 90, 30);

        jLabel6.setBackground(new java.awt.Color(0, 204, 255));
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 102), new java.awt.Color(255, 102, 102)));
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(640, 90, 90, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconu/fondo4.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 760, 540);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(430, 80, 0, 0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void radioAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioAMouseClicked
if(radioA.isSelected()){
  Car="1";
  radioC.setSelected(false);
   radioT.setSelected(false);
  rN.setSelected(false); 
  rdior.setSelected(false);  
}
 
}//GEN-LAST:event_radioAMouseClicked

private void BtnGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGActionPerformed
selecP();
selec1A();
 try {
     if(Accion==2 && op==3){
         Gua();
       Guardar();
    cargarusuarios();     
     }
     else{
  Statement ss = (Statement) cn.createStatement();
ResultSet rd = ss.executeQuery("SELECT * FROM prorolact  WHERE Activo ='"+co+"' ");
         rd.last();

         int encontrado=rd.getRow();
         if(encontrado==1){
 JOptionPane.showMessageDialog(this,"No es posible");
 Limpiar();
  limpiar2();
 Bloquiar();
  bloqueo1();
                          bloqueo11();
                           bloqueo2();
                            bloqueo3();
                             bloqueo4();
         }
         else{
          Gua();
    Guardar();
    cargarusuarios();   
         }
           } 
 }catch (SQLException ex) {
          
         
}    

        
}//GEN-LAST:event_BtnGActionPerformed

private void radioCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioCMouseClicked
if(radioC.isSelected()){
  Car="2";  
   radioA.setSelected(false);
   radioT.setSelected(false); 
   rN.setSelected(false); 
   rdior.setSelected(false);  
}
}//GEN-LAST:event_radioCMouseClicked

private void radioTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioTMouseClicked
if(radioT.isSelected()){
  Car="3"; 
  radioC.setSelected(false);
   radioA.setSelected(false);
  rN.setSelected(false);  
 rdior.setSelected(false);  
}
}//GEN-LAST:event_radioTMouseClicked

private void radioCoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioCoMouseClicked

    radioTo20.setSelected(false);

}//GEN-LAST:event_radioCoMouseClicked

private void radioDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioDeMouseClicked
radioTo20.setSelected(false);

}//GEN-LAST:event_radioDeMouseClicked

private void radioAdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioAdMouseClicked
radioTo20.setSelected(false);

}//GEN-LAST:event_radioAdMouseClicked

private void btnEdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdActionPerformed
 String cod, SQL;
 
         this.op = 3;
        this.Accion = 2;
        
        cod = JOptionPane.showInputDialog("Introdusca Codigo e usuario ");

        try {
             Statement ss = (Statement) cn.createStatement();
ResultSet rd = ss.executeQuery("SELECT * FROM prorolact  WHERE Activo ='"+cod+"' ");
         rd.last();

         int encontrado=rd.getRow();
         if(encontrado==1){
             Limpiar();
              limpiar2();
              
 Desbloquear();
 tblusuarios.setEnabled(false);
          
            SQL = " SELECT * FROM prorolact WHERE Activo = " + cod;
Statement st = null;
           
            st = cn.createStatement();
            
            ResultSet rs = st.executeQuery(SQL);
           rs.next();
       String SQL3 = " SELECT * FROM usuario WHERE id$usu = " + cod;
Statement sk = null;
           
            sk = cn.createStatement();
            
            ResultSet rm = sk.executeQuery(SQL3);
           rm.next();
           co=rm.getString("id$usu");
            no=rm.getString("nombre");
          ap=rm.getString("apellido");
         
          
          
           id=rs.getString("id$3");
            id1=rs.getString("id$3");
          Car=rs.getString("id$rol");
         
            
           Pro=rs.getString("id$pro");
       Act3=rs.getString("idactide");
           Act=rs.getString("idactiro");
          Act2=rs.getString("idactireg");   
            G=rs.getString("idacticol"); 
            
             G4=rs.getString("idacticon");   
            
            
              if(Car.equals("1")){
              radioA.setSelected(true);
          }
           if(Car.equals("2")){
              radioC.setSelected(true);
          }
            if(Car.equals("3")){
              radioT.setSelected(true);
          }
             if(Pro.equals("4")){
              radioTo20.setSelected(true);
          }
             if(Car.equals("6")){
              rdior.setSelected(true);
              rdior.setText("Sub director");
          }
             if(Car.equals("7")){
              rdior.setSelected(true);
              rdior.setText("Secretario(a)");
          }
              if(Car.equals("8")){
              rdior.setSelected(true);
              rdior.setText("Cosinero");
          }
           if(Car.equals("9")){
              rdior.setSelected(true);
              rdior.setText("Encargado");
          }
           if(Car.equals("10")){
              rdior.setSelected(true);
              rdior.setText("Profesor");
          }
           if(Car.equals("11")){
              rdior.setSelected(true);
              rdior.setText("Obrero");
          }
           if(Car.equals("12")){
              rdior.setSelected(true);
              rdior.setText("Visitante");
          }
           
    
             if(Pro.equals("1")){
              radioCo.setSelected(true);
          }
           if(Pro.equals("2")){
              radioDe.setSelected(true);
          }
            if(Pro.equals("3")){
              radioAd.setSelected(true);
          }
            if(Pro.equals("5")){
              radioDe.setSelected(true);
              radioCo.setSelected(true);
          }
            if(Pro.equals("6")){
              radioDe.setSelected(true);
              radioAd.setSelected(true);
          }
             if(Pro.equals("7")){
              radioCo.setSelected(true);
              radioAd.setSelected(true);
          }
             if(Pro.equals("8")){
              rre.setSelected(true);
              
          }
              if(Pro.equals("9")){
             rcom.setSelected(true);
             
          }
               if(Pro.equals("10")){
              rre.setSelected(true);
               rcom.setSelected(true);
          }
               if(Pro.equals("11")){
              radioCo.setSelected(true);
               rcom.setSelected(true);
          }
               if(Pro.equals("12")){
              radioAd.setSelected(true);
               rcom.setSelected(true);
          }
               if(Pro.equals("13")){
              radioDe.setSelected(true);
               rcom.setSelected(true);
          }
               if(Pro.equals("14")){
              rre.setSelected(true);
              radioCo.setSelected(true);
          }
               if(Pro.equals("15")){
              rre.setSelected(true);
               radioDe.setSelected(true);
          }
               if(Pro.equals("16")){
              rre.setSelected(true);
               radioAd.setSelected(true);
          }
               if(Pro.equals("17")){
              rre.setSelected(true);
              radioAd.setSelected(true);
               radioDe.setSelected(true);
          }
                if(Pro.equals("18")){
              rre.setSelected(true);
              radioAd.setSelected(true);
               rcom.setSelected(true);
          }
                 if(Pro.equals("19")){
              rre.setSelected(true);
              rcom.setSelected(true);
               radioCo.setSelected(true);
          }
                  if(Pro.equals("20")){
              rre.setSelected(true);
              radioDe.setSelected(true);
               rcom.setSelected(true);
          }
                   if(Pro.equals("21")){
              rre.setSelected(true);
              radioAd.setSelected(true);
               radioDe.setSelected(true);
          }
                    if(Pro.equals("22")){
              rre.setSelected(true);
              radioAd.setSelected(true);
               radioCo.setSelected(true);
          }
                     if(Pro.equals("23")){
              radioDe.setSelected(true);
              radioAd.setSelected(true);
               rcom.setSelected(true);
          }
                      if(Pro.equals("24")){
              rcom.setSelected(true);
              radioAd.setSelected(true);
               radioCo.setSelected(true);
          }
                       if(Pro.equals("25")){
              rcom.setSelected(true);
              radioAd.setSelected(true);
              radioDe.setSelected(true);
               radioCo.setSelected(true);
          }
                        if(Pro.equals("26")){
              rre.setSelected(true);
              radioAd.setSelected(true);
              radioDe.setSelected(true);
               radioCo.setSelected(true);
          }
                          if(Pro.equals("27")){
            rre.setSelected(true);
              rcom.setSelected(true);
              radioDe.setSelected(true);
               radioCo.setSelected(true);
        }
                     if(Pro.equals("28")){
                         rre.setSelected(true);
              rcom.setSelected(true);
              radioAd.setSelected(true);
               radioCo.setSelected(true);
           
        }
                      if(Pro.equals("29")){
              rre.setSelected(true);
              rcom.setSelected(true);
              radioAd.setSelected(true);
               radioDe.setSelected(true);
        }
                      
             
              if(G.equals("1")){
              radioG.setSelected(true);
              desbloqueo1();
          }
              if(G4.equals("1")){
              radioG4.setSelected(true);
               desbloqueo4();
          }
              if(Act.equals("1")){
              radioG2.setSelected(true);
              desbloqueo2();
          }
           if(Act.equals("2")){
              radioE2.setSelected(true);
               desbloqueo2();
          }
            if(Act.equals("3")){
              radioEl2.setSelected(true);
               desbloqueo2();
          }
             if(Act.equals("4")){
              radioTo3.setSelected(true);
               desbloqueo2();
          }
            if(Act.equals("5")){
              radioG2.setSelected(true);
              radioE2.setSelected(true);
               desbloqueo2();
          } 
            if(Act.equals("6")){
              radioEl2.setSelected(true);
              radioE2.setSelected(true);
               desbloqueo2();
          } 
           if(Act.equals("7")){
              radioEl2.setSelected(true);
              radioG2.setSelected(true);
               desbloqueo2();
          } 
         
           
           
             if(Act3.equals("1")){
              radioG1.setSelected(true);
              desbloqueo11();
          }
           if(Act3.equals("2")){
              radioE1.setSelected(true);
              desbloqueo11();
          }
            if(Act3.equals("3")){
              radioEl1.setSelected(true);
              desbloqueo11();
          }
             if(Act3.equals("4")){
              radioTo2.setSelected(true);
              desbloqueo11();
          }
            if(Act3.equals("5")){
              radioG1.setSelected(true);
              radioE1.setSelected(true);
              desbloqueo11();
          } 
            if(Act3.equals("6")){
              radioEl1.setSelected(true);
              radioE1.setSelected(true);
              desbloqueo11();
          } 
           if(Act3.equals("7")){
              radioEl1.setSelected(true);
              radioG1.setSelected(true);
              desbloqueo11();
          } 
         
           
           
            if(Act2.equals("1")){
              radioG3.setSelected(true);
               desbloqueo3();
          }
           if(Act2.equals("2")){
              radioE3.setSelected(true);
               desbloqueo3();
          }
            if(Act2.equals("3")){
              radioEl3.setSelected(true);
               desbloqueo3();
          }
             if(Act2.equals("4")){
              radioTo4.setSelected(true);
               desbloqueo3();
          }
            if(Act2.equals("5")){
              radioG3.setSelected(true);
              radioE3.setSelected(true);
               desbloqueo3();
          } 
            if(Act2.equals("6")){
              radioEl3.setSelected(true);
              radioE3.setSelected(true);
               desbloqueo3();
          } 
           if(Act2.equals("7")){
              radioEl3.setSelected(true);
              radioG3.setSelected(true);
               desbloqueo3();
          } 
         }else{
              JOptionPane.showMessageDialog(null, "No posee rol");
         }

        } catch (SQLException ex) {
          
        }  
}//GEN-LAST:event_btnEdActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 op=3; 
    Accion=1;
 

Desbloquear();
Limpiar();
}//GEN-LAST:event_jButton1ActionPerformed

private void tblusuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblusuariosMouseClicked
 
    
    int i = tblusuarios.getSelectedRow();  
        co=(String) tblusuarios.getValueAt(i,0); 
       no=(String) tblusuarios.getValueAt(i,1);
        ap=(String) tblusuarios.getValueAt(i,2);
        
       ro=(String) tblusuarios.getValueAt(i,3);
          
           if( ro.equals("Director")){
                 ro="1";  
               }
                 if( ro.equals("Coordinador")){
                  ro="2";  
               }
               if( ro.equals("Trabajador")){
                  ro="Trabajador";  
               }
                if( ro.equals("Desactivar")){
                  ro="4";  
               }       
                if( ro.equals("Ninguno")){
                  ro="5";  
               }   
                 if( ro.equals("Sub director")){
                  ro="6";  
               }   
                 if( ro.equals("Secretario(a)")){
                  ro="7";  
               }  
                 if( ro.equals("Cosinero")){
                  ro="8";  
               }  
                 if( ro.equals("Encargado")){
                  ro="9";  
               }  
                 if( ro.equals("Profesor")){
                  ro="10";  
               }  
                 if( ro.equals("Obrero")){
                  ro="11";  
               }  
                 if( ro.equals("Visitante")){
                  ro="12";  
               }  
               
}//GEN-LAST:event_tblusuariosMouseClicked

private void radioTo20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioTo20MouseClicked

 radioAd.setSelected(false);
 radioDe.setSelected(false);
 radioCo.setSelected(false);
 rre.setSelected(false);
 rcom.setSelected(false);
 
 
}//GEN-LAST:event_radioTo20MouseClicked

private void btnElmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElmActionPerformed
 String cod, SQL;
 Limpiar();
  limpiar2();
 
  String n;   
       
        
        cod = JOptionPane.showInputDialog("Introdusca Codigo a Eliminar ");
 n=cod;      
        try {

          
            SQL = " SELECT * FROM prorolact WHERE Activo = " + cod;

            Statement st = null;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            rs.next();
          int encontrado=rs.getRow();
         if(encontrado==1){
             Desbloquear();
           id=rs.getString("id$3");
            id1=rs.getString("id$3");
          Car=rs.getString("id$rol");
         
            
           Pro=rs.getString("id$pro");
      
           
       Act3=rs.getString("idactide");
           Act=rs.getString("idactiro");
          Act2=rs.getString("idactireg");   
            G=rs.getString("idacticol"); 
            
             G4=rs.getString("idacticon");   
            
              
            
              if(Car.equals("1")){
              radioA.setSelected(true);
          }
           if(Car.equals("2")){
              radioC.setSelected(true);
          }
            if(Car.equals("3")){
              radioT.setSelected(true);
          }
            if(Car.equals("4")){
              rN.setSelected(true);
              
          }
             if(Car.equals("6")){
              rdior.setSelected(true);
              rdior.setText("Sub director");
          }
             if(Car.equals("7")){
              rdior.setSelected(true);
              rdior.setText("Secretario(a)");
          }
              if(Car.equals("8")){
              rdior.setSelected(true);
              rdior.setText("Cosinero");
          }
           if(Car.equals("9")){
              rdior.setSelected(true);
              rdior.setText("Encargado");
          }
           if(Car.equals("10")){
              rdior.setSelected(true);
              rdior.setText("Profesor");
          }
           if(Car.equals("11")){
              rdior.setSelected(true);
              rdior.setText("Obrero");
          }
           if(Car.equals("12")){
              rdior.setSelected(true);
              rdior.setText("Visitante");
          }
           
             if(Pro.equals("4")){
              radioTo20.setSelected(true);
          }
             if(Pro.equals("1")){
              radioCo.setSelected(true);
          }
           if(Pro.equals("2")){
              radioDe.setSelected(true);
          }
            if(Pro.equals("3")){
              radioAd.setSelected(true);
          }
            if(Pro.equals("5")){
              radioDe.setSelected(true);
              radioCo.setSelected(true);
          }
            if(Pro.equals("6")){
              radioDe.setSelected(true);
              radioAd.setSelected(true);
          }
             if(Pro.equals("7")){
              radioCo.setSelected(true);
              radioAd.setSelected(true);
          }
             
            if(Pro.equals("8")){
              rre.setSelected(true);
              
          }
              if(Pro.equals("9")){
             rcom.setSelected(true);
             
          }
               if(Pro.equals("10")){
              rre.setSelected(true);
               rcom.setSelected(true);
          }
               if(Pro.equals("11")){
              radioCo.setSelected(true);
               rcom.setSelected(true);
          }
               if(Pro.equals("12")){
              radioAd.setSelected(true);
               rcom.setSelected(true);
          }
               if(Pro.equals("13")){
              radioDe.setSelected(true);
               rcom.setSelected(true);
          }
               if(Pro.equals("14")){
              rre.setSelected(true);
              radioCo.setSelected(true);
          }
               if(Pro.equals("15")){
              rre.setSelected(true);
               radioDe.setSelected(true);
          }
               if(Pro.equals("16")){
              rre.setSelected(true);
               radioAd.setSelected(true);
          }
               if(Pro.equals("17")){
              rre.setSelected(true);
              radioAd.setSelected(true);
               radioDe.setSelected(true);
          }
                if(Pro.equals("18")){
              rre.setSelected(true);
              radioAd.setSelected(true);
               rcom.setSelected(true);
          }
                 if(Pro.equals("19")){
              rre.setSelected(true);
              rcom.setSelected(true);
               radioCo.setSelected(true);
          }
                  if(Pro.equals("20")){
              rre.setSelected(true);
              radioDe.setSelected(true);
               rcom.setSelected(true);
          }
                   if(Pro.equals("21")){
              rre.setSelected(true);
              radioAd.setSelected(true);
               radioDe.setSelected(true);
          }
                    if(Pro.equals("22")){
              rre.setSelected(true);
              radioAd.setSelected(true);
               radioCo.setSelected(true);
          }
                     if(Pro.equals("23")){
              radioDe.setSelected(true);
              radioAd.setSelected(true);
               rcom.setSelected(true);
          }
                      if(Pro.equals("24")){
              rcom.setSelected(true);
              radioAd.setSelected(true);
               radioCo.setSelected(true);
          }
                       if(Pro.equals("25")){
              rcom.setSelected(true);
              radioAd.setSelected(true);
              radioDe.setSelected(true);
               radioCo.setSelected(true);
          }
                        if(Pro.equals("26")){
              rre.setSelected(true);
              radioAd.setSelected(true);
              radioDe.setSelected(true);
               radioCo.setSelected(true);
          }  
                         if(Pro.equals("27")){
            rre.setSelected(true);
              rcom.setSelected(true);
              radioDe.setSelected(true);
               radioCo.setSelected(true);
        }
                     if(Pro.equals("28")){
                         rre.setSelected(true);
              rcom.setSelected(true);
              radioAd.setSelected(true);
               radioCo.setSelected(true);
           
        }
                      if(Pro.equals("29")){
              rre.setSelected(true);
              rcom.setSelected(true);
              radioAd.setSelected(true);
               radioDe.setSelected(true);
        }
                      
            
                                 if(G.equals("1")){
              radioG.setSelected(true);
              desbloqueo1();
          }
              if(G4.equals("1")){
              radioG4.setSelected(true);
               desbloqueo4();
          }
              if(Act.equals("1")){
              radioG2.setSelected(true);
              desbloqueo2();
          }
           if(Act.equals("2")){
              radioE2.setSelected(true);
               desbloqueo2();
          }
            if(Act.equals("3")){
              radioEl2.setSelected(true);
               desbloqueo2();
          }
             if(Act.equals("4")){
              radioTo3.setSelected(true);
               desbloqueo2();
          }
            if(Act.equals("5")){
              radioG2.setSelected(true);
              radioE2.setSelected(true);
               desbloqueo2();
          } 
            if(Act.equals("6")){
              radioEl2.setSelected(true);
              radioE2.setSelected(true);
               desbloqueo2();
          } 
           if(Act.equals("7")){
              radioEl2.setSelected(true);
              radioG2.setSelected(true);
               desbloqueo2();
          } 
         
           
           
             if(Act3.equals("1")){
              radioG1.setSelected(true);
              desbloqueo11();
          }
           if(Act3.equals("2")){
              radioE1.setSelected(true);
              desbloqueo11();
          }
            if(Act3.equals("3")){
              radioEl1.setSelected(true);
              desbloqueo11();
          }
             if(Act3.equals("4")){
              radioTo2.setSelected(true);
              desbloqueo11();
          }
            if(Act3.equals("5")){
              radioG1.setSelected(true);
              radioE1.setSelected(true);
              desbloqueo11();
          } 
            if(Act3.equals("6")){
              radioEl1.setSelected(true);
              radioE1.setSelected(true);
              desbloqueo11();
          } 
           if(Act3.equals("7")){
              radioEl1.setSelected(true);
              radioG1.setSelected(true);
              desbloqueo11();
          } 
         
           
           
            if(Act2.equals("1")){
              radioG3.setSelected(true);
               desbloqueo3();
          }
           if(Act2.equals("2")){
              radioE3.setSelected(true);
               desbloqueo3();
          }
            if(Act2.equals("3")){
              radioEl3.setSelected(true);
               desbloqueo3();
          }
             if(Act2.equals("4")){
              radioTo4.setSelected(true);
               desbloqueo3();
          }
            if(Act2.equals("5")){
              radioG3.setSelected(true);
              radioE3.setSelected(true);
               desbloqueo3();
          } 
            if(Act2.equals("6")){
              radioEl3.setSelected(true);
              radioE3.setSelected(true);
               desbloqueo3();
          } 
           if(Act2.equals("7")){
              radioEl3.setSelected(true);
              radioG3.setSelected(true);
               desbloqueo3();
          } 
             
           
         
 int resp= JOptionPane.showConfirmDialog(this, "Deseas Eliminarlo","Eliminar Dato",JOptionPane.YES_NO_OPTION);
                      
                if(resp==JOptionPane.YES_NO_OPTION){
                    try{  
                        PreparedStatement psd=null; 
                        SQL =" DELETE FROM prorolact WHERE id$3 ='"+id+"'";
                        psd=cn.prepareStatement(SQL);
                        psd.execute();
                        psd.close();
                         Limpiar();
                         limpiar2();
                         Bloquiar();
                         bloqueo1();
                          bloqueo11();
                           bloqueo2();
                            bloqueo3();
                             bloqueo4();
                             
                        JOptionPane.showMessageDialog(this,"Registro Eliminado");
                         SQL= "UPDATE usuario set id$usu=?, rol=? WHERE id$usu=?";
                        
                         psd=cn.prepareStatement(SQL);
                                  psd.setString(1,n);
                              psd.setString(2,"5");
                             
                               psd.setString(3,n);
                                   
                                      psd.executeUpdate();
                                      
                         cargarusuarios();
                    }
                    
                       catch (SQLException ex) {
          
         
}    
                }  else{
                    Limpiar();
                    limpiar2();
                    Bloquiar();
                     bloqueo1();
                          bloqueo11();
                           bloqueo2();
                            bloqueo3();
                             bloqueo4();
                }}else{
            JOptionPane.showMessageDialog(null, "No posee rol"); 
         }       
        } catch (SQLException ex) {
          
         
}           
}//GEN-LAST:event_btnElmActionPerformed

private void rNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rNMouseClicked
if(rN.isSelected()){
  Car="4"; 
  radioC.setSelected(false);
   radioA.setSelected(false);
   radioT.setSelected(false);
   rdior.setSelected(false);  
    
}
}//GEN-LAST:event_rNMouseClicked

private void rNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rNActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_rNActionPerformed

private void radioAdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAdActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_radioAdActionPerformed

private void rreMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rreMouseReleased
radioTo20.setSelected(false);

   
}//GEN-LAST:event_rreMouseReleased

private void radioTo20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTo20ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_radioTo20ActionPerformed

private void rcomMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rcomMouseReleased
radioTo20.setSelected(false);
  
}//GEN-LAST:event_rcomMouseReleased

private void radioCoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioCoMouseReleased

}//GEN-LAST:event_radioCoMouseReleased

private void radioG4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioG4ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_radioG4ActionPerformed

private void radioG4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioG4MouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_radioG4MouseClicked

private void radioTo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTo4ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_radioTo4ActionPerformed

private void radioTo4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioTo4MouseClicked
radioG3.setSelected(false);
radioE3.setSelected(false);
 radioEl3.setSelected(false);   // TODO add your handling code here:
}//GEN-LAST:event_radioTo4MouseClicked

private void radioEl3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioEl3MouseClicked
radioTo4.setSelected(false);// TODO add your handling code here:
}//GEN-LAST:event_radioEl3MouseClicked

private void radioE3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioE3MouseClicked
radioTo4.setSelected(false);// TODO add your handling code here:
}//GEN-LAST:event_radioE3MouseClicked

private void radioG3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioG3ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_radioG3ActionPerformed

private void radioG3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioG3MouseClicked
radioTo4.setSelected(false);// TODO add your handling code here:
}//GEN-LAST:event_radioG3MouseClicked

private void radioTo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTo3ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_radioTo3ActionPerformed

private void radioTo3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioTo3MouseClicked
radioG2.setSelected(false);
radioE2.setSelected(false);
 radioEl2.setSelected(false);   // TODO add your handling code here:
}//GEN-LAST:event_radioTo3MouseClicked

private void radioEl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioEl2MouseClicked
radioTo3.setSelected(false);// TODO add your handling code here:
}//GEN-LAST:event_radioEl2MouseClicked

private void radioE2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioE2MouseClicked
radioTo3.setSelected(false);// TODO add your handling code here:
}//GEN-LAST:event_radioE2MouseClicked

private void radioG2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioG2ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_radioG2ActionPerformed

private void radioG2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioG2MouseClicked
radioTo3.setSelected(false);
// TODO add your handling code here:
}//GEN-LAST:event_radioG2MouseClicked

private void radioTo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTo2ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_radioTo2ActionPerformed

private void radioTo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioTo2MouseClicked
radioG1.setSelected(false);
radioE1.setSelected(false);
 radioEl1.setSelected(false);   // TODO add your handling code here:
}//GEN-LAST:event_radioTo2MouseClicked

private void radioEl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioEl1MouseClicked
radioTo2.setSelected(false);// TODO add your handling code here:
}//GEN-LAST:event_radioEl1MouseClicked

private void radioE1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioE1MouseClicked
radioTo2.setSelected(false);// TODO add your handling code here:
}//GEN-LAST:event_radioE1MouseClicked

private void radioG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioG1ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_radioG1ActionPerformed

private void radioG1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioG1MouseClicked
radioTo2.setSelected(false);
  // TODO add your handling code here:
}//GEN-LAST:event_radioG1MouseClicked

private void radioGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioGActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_radioGActionPerformed

private void radioGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioGMouseClicked

}//GEN-LAST:event_radioGMouseClicked

private void rreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rreMousePressed
 if(rre.isSelected()){

    bloqueo3();
     radioG3.setSelected(false);  
      radioE3.setSelected(false);  
     radioEl3.setSelected(false);
      radioTo4.setSelected(false);  
}
          else{
             desbloqueo3();
               
              
          }// TODO add your handling code here:
}//GEN-LAST:event_rreMousePressed

private void rcomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rcomMousePressed
 if(rcom.isSelected()){

    bloqueo4();
     radioG4.setSelected(false);  
    
}
          else{
             desbloqueo4();
            
              
          }// TODO add your handling code here:
}//GEN-LAST:event_rcomMousePressed

private void radioAdMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioAdMouseReleased
// TODO add your handling code here:
}//GEN-LAST:event_radioAdMouseReleased

private void radioAdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioAdMousePressed
if(radioAd.isSelected()){

    bloqueo2();
    radioG2.setSelected(false);  
      radioE2.setSelected(false);  
     radioEl2.setSelected(false);
      radioTo3.setSelected(false);
}
          else{
             desbloqueo2();
               
              
          }// TODO add your handling code here:
}//GEN-LAST:event_radioAdMousePressed

private void radioDeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioDeMousePressed
if(radioDe.isSelected()){

    bloqueo11();
    radioG1.setSelected(false);  
      radioE1.setSelected(false);  
     radioEl1.setSelected(false);
      radioTo2.setSelected(false);
    
}
          else{
             desbloqueo11();
               
              
          }// TODO add your handling code here:
// TODO add your handling code here:
}//GEN-LAST:event_radioDeMousePressed

private void radioCoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioCoMousePressed
if(radioCo.isSelected()){

    bloqueo1();
    radioG.setSelected(false);  
     
}
          else{
             desbloqueo1();
               
              
          }// TODO add your handling code here:
}//GEN-LAST:event_radioCoMousePressed

private void radioTo20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioTo20MousePressed
if(radioTo20.isSelected()){

    bloqueo1();
    bloqueo11();
    bloqueo2();
    bloqueo3();
    bloqueo4();
    limpiar2();
}
          else{
    radioG3.setSelected(false);  
      radioE3.setSelected(false);  
     radioEl3.setSelected(false);
      radioTo4.setSelected(false);  
             desbloqueo1();
              desbloqueo11();
               desbloqueo2();
                desbloqueo3();
                
                 desbloqueo4();
               
              
          }
}//GEN-LAST:event_radioTo20MousePressed

private void radioTo2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioTo2MousePressed
// TODO add your handling code here:
}//GEN-LAST:event_radioTo2MousePressed

private void radioTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_radioTActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
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
       
   
}//GEN-LAST:event_jButton4ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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
       
   
  
      
       
}//GEN-LAST:event_jButton3ActionPerformed

private void radioCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_radioCoActionPerformed

private void radioDeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioDeMouseReleased
// TODO add your handling code here:
}//GEN-LAST:event_radioDeMouseReleased

private void rdiorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdiorMouseClicked
 
 radioC.setSelected(false);
   radioA.setSelected(false);
  rN.setSelected(false);  
   
  radioT.setSelected(false);
}//GEN-LAST:event_rdiorMouseClicked

private void rdiorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdiorMouseReleased

}//GEN-LAST:event_rdiorMouseReleased

private void rdiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdiorMousePressed
if(rdior.isSelected()){
 
  nrol.setVisible(false);
  
  rN.setSelected(false);  
}
else{
    nrol.setVisible(true);
    
}
}//GEN-LAST:event_rdiorMousePressed

private void nrolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nrolActionPerformed
nuevorol();// TODO add your handling code here:
}//GEN-LAST:event_nrolActionPerformed

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
            java.util.logging.Logger.getLogger(FrmModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmModulos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnG;
    private javax.swing.JButton btnEd;
    private javax.swing.JButton btnElm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox nrol;
    private javax.swing.JRadioButton rN;
    private javax.swing.JRadioButton radioA;
    private javax.swing.JRadioButton radioAd;
    private javax.swing.JRadioButton radioC;
    private javax.swing.JRadioButton radioCo;
    private javax.swing.JRadioButton radioDe;
    private javax.swing.JRadioButton radioE1;
    private javax.swing.JRadioButton radioE2;
    private javax.swing.JRadioButton radioE3;
    private javax.swing.JRadioButton radioEl1;
    private javax.swing.JRadioButton radioEl2;
    private javax.swing.JRadioButton radioEl3;
    private javax.swing.JRadioButton radioG;
    private javax.swing.JRadioButton radioG1;
    private javax.swing.JRadioButton radioG2;
    private javax.swing.JRadioButton radioG3;
    private javax.swing.JRadioButton radioG4;
    private javax.swing.JRadioButton radioT;
    private javax.swing.JRadioButton radioTo2;
    private javax.swing.JRadioButton radioTo20;
    private javax.swing.JRadioButton radioTo3;
    private javax.swing.JRadioButton radioTo4;
    private javax.swing.JRadioButton rcom;
    private javax.swing.JRadioButton rdior;
    private javax.swing.JRadioButton rre;
    private javax.swing.JTable tblusuarios;
    // End of variables declaration//GEN-END:variables
}
