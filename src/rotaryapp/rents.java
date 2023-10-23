
package rotaryapp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.String;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import javax.swing.table.TableModel;
import static mondrian.olap.fun.vba.Vba.string;




public class rents extends javax.swing.JPanel {

    
    public rents() {
        initComponents();
        tb_load();
        tb_rent_load();
        getcustomers();
        fill_date();
   
    }

    public void fill_date(){
    
        Date fecha = new Date();
        r_date.setDate(fecha);
        fecha_Act.setDate(fecha);
    
    }
    private void reset(){
        r_custom.setSelectedIndex(0);
        r_pay.setSelectedIndex(0);
        r_elements.setText("");
        r_code.setText("");
        r_status.setSelectedIndex(0);
        r_price.setText("");
        Date fecha = new Date();
        r_date.setDate(fecha);
        Date devolucion = new Date();
        return_date.setDate(devolucion);
        
        
      
        
    
    }
    public void tb_load(){
        
        try {
            String elementStatus = "Disponible";
            
            DefaultTableModel dt = (DefaultTableModel) elements_table.getModel();
            dt.setRowCount(0);
            
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM elementostbl WHERE element_status = '"+elementStatus+"'");
            
            while (rs.next()) {                
                Vector v = new Vector();
                
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                
                
                
                
                dt.addRow(v);
                
                
                
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    public void tb_rent_load(){
        
        try {
            String rentStatusOne = "Alquiler";
            String rentStatusTwo = "Préstamo";
            
            DefaultTableModel dt = (DefaultTableModel) rent_table.getModel();
            dt.setRowCount(0);
            
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM alquilerestbl WHERE rent_status = '"+rentStatusOne+"' OR rent_status = '"+rentStatusTwo+"'");
            
            while (rs.next()) {                
                Vector v = new Vector();
                
                
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));                
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                v.add(rs.getString(10));

                
                
                dt.addRow(v);
                
                
                
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }

    private void getcustomers(){
        
        try {
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM clientestbl");
            
            while (rs.next()) {   
                String customer = rs.getString("cliente_name");
                r_custom.addItem(customer);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
   /* public boolean IssueBook(){
        
        boolean isIssued = false;
        
        String id = r_id.getText();
        String name = r_custom.getSelectedItem().toString();
        String element = r_elements.getText();
        String code = r_code.getText();
        String status = r_status.getSelectedItem().toString();
        int price = Integer.parseInt(r_price.getText());
        Date uIssueDate = r_date.getDatoFecha();
        Long l1 = uIssueDate.getTime();
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        Date uDueDate = return_date.getDatoFecha();
        long l2 = uDueDate.getTime();
        java.sql.Date sDueDate = new java.sql.Date(l2);
        String payment = r_pay.getSelectedItem().toString();
        String account = r_account.getSelectedItem().toString();
        
        try {
            Connection con = db.mycon();
            String sql = "INSERT INTO alquilerestbl(rent_client, rent_element,rent_code, rent_status, rent_price, rent_date,return_date, rent_payment, rent_payStatus) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, id);
            pst.setString(2,name);
            pst.setString(3,element);
            pst.setString(4,code);
            pst.setString(5,status);
            pst.setInt(6,price);
            pst.setDate(7,sIssueDate);
            pst.setDate(8, sDueDate);
            pst.setString(9, payment);
            pst.setString(10,account);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0){
                isIssued=true;
                
            }else{
                    isIssued = false;
            }
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isIssued;
    }*/  

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        r_id = new javax.swing.JTextField();
        r_code = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        r_status = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        r_price = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        r_custom = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        r_pay = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        r_elements = new javax.swing.JTextField();
        updateBtn = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        r_account = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        r_date = new com.toedter.calendar.JDateChooser();
        return_date = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        updateBtn2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        e_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        rent_table = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        elements_table = new javax.swing.JTable();
        print_rentBtn = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        e_search2 = new javax.swing.JTextField();
        r_reset = new javax.swing.JButton();
        fecha_Act = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(0, 51, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 102)));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Forma de pago");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Cliente");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 102));
        jLabel4.setText("Alquiler N°");

        r_id.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        r_id.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        r_code.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        r_code.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        saveBtn.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(0, 51, 102));
        saveBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\tick si.png")); // NOI18N
        saveBtn.setText("Alquilar");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        r_status.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        r_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Disponible", "Alquiler", "Préstamo", "Fuera de servicio" }));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setText("Estado");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("Precio");

        r_price.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        r_price.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 102));
        jLabel7.setText("Elemento");

        r_custom.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        r_custom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        r_custom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_customActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setText("Código");

        r_pay.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        r_pay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Cobrador", "Sede", "Transferencia" }));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 102));
        jLabel11.setText("Fecha dev.");

        jButton5.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 51, 102));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\print 25px.png")); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        r_elements.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        r_elements.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        updateBtn.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(0, 51, 102));
        updateBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\editar 25px(1).png")); // NOI18N
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 102));
        jLabel14.setText("Último pago");

        r_account.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        r_account.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 102));
        jLabel15.setText("Fecha alquiler");

        r_date.setDateFormatString("yyyy-MM-dd");

        return_date.setDateFormatString("yyyy-MM-dd");

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 102)));

        updateBtn2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        updateBtn2.setForeground(new java.awt.Color(0, 51, 102));
        updateBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Library Management System icons/icons/archivo-factura-dolar.png"))); // NOI18N
        updateBtn2.setText("Actuallizar precios");
        updateBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(updateBtn2)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(updateBtn2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(r_date, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(return_date, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 14, Short.MAX_VALUE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(r_id, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(33, 33, 33)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(r_custom, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10)
                                                .addComponent(r_code, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(26, 26, 26)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(r_elements, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(r_pay, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(r_account, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(31, 31, 31)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(r_status, 0, 0, Short.MAX_VALUE)
                                .addGap(22, 22, 22))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(r_price, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(55, Short.MAX_VALUE))))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_custom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(r_pay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r_account, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(r_code, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r_elements, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r_price, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel15)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(r_date, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r_status, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(return_date, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(updateBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveBtn))))
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Alquileres - Préstamos");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setText("Buscador:");

        e_search.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        e_search.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        e_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                e_searchKeyReleased(evt);
            }
        });

        rent_table.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        rent_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N° alquiler", "Cliente", "Elemento", "Código", "Estado", "Precio", "Fecha alquiler", "Fecha devolución", "Forma de pago", "Ultimo pago"
            }
        ));
        rent_table.setAutoscrolls(false);
        rent_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rent_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rent_table);
        if (rent_table.getColumnModel().getColumnCount() > 0) {
            rent_table.getColumnModel().getColumn(0).setResizable(false);
            rent_table.getColumnModel().getColumn(0).setPreferredWidth(2);
            rent_table.getColumnModel().getColumn(1).setResizable(false);
            rent_table.getColumnModel().getColumn(1).setPreferredWidth(10);
            rent_table.getColumnModel().getColumn(2).setResizable(false);
            rent_table.getColumnModel().getColumn(2).setPreferredWidth(10);
            rent_table.getColumnModel().getColumn(3).setResizable(false);
            rent_table.getColumnModel().getColumn(3).setPreferredWidth(5);
            rent_table.getColumnModel().getColumn(4).setResizable(false);
            rent_table.getColumnModel().getColumn(4).setPreferredWidth(10);
            rent_table.getColumnModel().getColumn(5).setResizable(false);
            rent_table.getColumnModel().getColumn(5).setPreferredWidth(5);
            rent_table.getColumnModel().getColumn(6).setResizable(false);
            rent_table.getColumnModel().getColumn(6).setPreferredWidth(30);
            rent_table.getColumnModel().getColumn(7).setResizable(false);
            rent_table.getColumnModel().getColumn(7).setPreferredWidth(30);
            rent_table.getColumnModel().getColumn(8).setResizable(false);
            rent_table.getColumnModel().getColumn(8).setPreferredWidth(10);
            rent_table.getColumnModel().getColumn(9).setResizable(false);
            rent_table.getColumnModel().getColumn(9).setPreferredWidth(10);
        }

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setText("ALQUILER");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setText("Elementos disponibles");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 102));
        jLabel13.setText("Buscador:");

        elements_table.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        elements_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Elemento", "Codigo", "Estado", "Precio", "Comentario"
            }
        ));
        elements_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                elements_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(elements_table);

        print_rentBtn.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        print_rentBtn.setForeground(new java.awt.Color(0, 51, 102));
        print_rentBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\print 25px.png")); // NOI18N
        print_rentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_rentBtnActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 51, 102));
        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\print 25px.png")); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        e_search2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        e_search2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        e_search2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                e_search2KeyReleased(evt);
            }
        });

        r_reset.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        r_reset.setForeground(new java.awt.Color(0, 51, 102));
        r_reset.setText("Reset");
        r_reset.setToolTipText("");
        r_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_resetActionPerformed(evt);
            }
        });

        fecha_Act.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r_reset))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(171, 171, 171)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(e_search2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(print_rentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(e_search, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addContainerGap(12, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fecha_Act, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(34, 34, 34))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fecha_Act, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(e_search2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(print_rentBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(e_search, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(r_reset))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed
    
    private void updateElement(){
             
        String status = "Alquiler";
        String statusTwo="Préstamo";
        String code = r_code.getText();
        
        try {
            Statement s = db.mycon().createStatement();
            if(r_status.equals(status)){
            s.executeUpdate("UPDATE elementostbl SET element_status ='"+status+"' WHERE element_code='"+code+"' ");
            }else if (r_status.equals(statusTwo)){
                s.executeUpdate("UPDATE elementostbl SET element_status ='"+statusTwo+"'  WHERE element_code='"+code+"' ");
            }
            //JOptionPane.showMessageDialog(null,"Datos actualizados correctamente");
            tb_load();
            tb_rent_load();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
            // button save
            
   /* if (IssueBook() == true){
        JOptionPane.showMessageDialog(this,"Alquiler registrado con éxtio");
        
    }else{
    JOptionPane.showMessageDialog(this,"No es posible alquilar elemento");
    }*/
            
            
        String custom = r_custom.getSelectedItem().toString();
        String payment = r_pay.getSelectedItem().toString();
        String element = r_elements.getText();
        String code = r_code.getText();
        String status = r_status.getSelectedItem().toString();
        String statusTwo = r_status.getSelectedItem().toString();
        String price = r_price.getText();
        Date uIssueDate = r_date.getDate();
        Long l1 = uIssueDate.getTime();
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        Date uDueDate = return_date.getDate();
        long l2 = uDueDate.getTime();
        java.sql.Date sDueDate = new java.sql.Date(l2);
    
        String account = r_account.getSelectedItem().toString();
        
       
        if(r_custom.getSelectedIndex()== 0||r_pay.getSelectedIndex()== 0 ||r_elements.getText().isEmpty() || r_code.getText().isEmpty() || r_status.getSelectedIndex() == 1 || r_price.getText().isEmpty()|| r_date.getDate().toString().isEmpty()){
            
            JOptionPane.showMessageDialog(this,"Falta información. Todos los campos son obligatorios");
        }else{
            try {
                Statement s = db.mycon().createStatement();
                s.executeUpdate("INSERT INTO alquilerestbl(rent_client, rent_element,rent_code, rent_status, rent_price, rent_date,return_date, rent_payment, rent_payStatus) VALUES ('"+custom+"','"+element+"','"+code+"','"+status+"','"+price+"','"+sIssueDate+"','"+sDueDate+"','"+payment+"','"+account+"')");
                s.executeUpdate("UPDATE elementostbl SET element_status ='"+status+"' WHERE element_code='"+code+"' ");
                JOptionPane.showMessageDialog(null,"¡Elemento alquilado correctamente!");
                tb_rent_load();
                //updateElement();
                tb_load();
                reset();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        
      
        
        
   
    }//GEN-LAST:event_saveBtnActionPerformed

    private void e_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e_searchKeyReleased
        // search by released key
       
    }//GEN-LAST:event_e_searchKeyReleased

    private void rent_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rent_tableMouseClicked
        
        try {
            // mouse click table
            // DefaultTableModel dt = (DefaultTableModel) elements_table.getModel();
            //  dt.setRowCount(0);
            
            DefaultTableModel model = (DefaultTableModel)rent_table.getModel();
            
            int r = rent_table.getSelectedRow();
            
            
            String id = rent_table.getValueAt(r,0).toString();
            String name = rent_table.getValueAt(r,1).toString();
            String element = rent_table.getValueAt(r,2).toString();
            String code = rent_table.getValueAt(r, 3).toString();
            String status = rent_table.getValueAt(r,4).toString();
            String price = rent_table.getValueAt(r,5).toString();
            Date fechaalq = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(r,6));
            Date dateReturn = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(r,7));
            String pay = rent_table.getValueAt(r,8).toString();
            String account = rent_table.getValueAt(r, 9).toString();
            
            
            
            
            
            
            r_id.setText(id);
            r_custom.setSelectedItem(name);
            r_elements.setText(element);
            r_code.setText(code);
            r_status.setSelectedItem(status);
            r_price.setText(price);
            r_date.setDate(fechaalq);
            return_date.setDate(dateReturn);
            
            r_pay.setSelectedItem(pay);
            r_account.setSelectedItem(account);
        } catch (ParseException ex) {
            Logger.getLogger(rents.class.getName()).log(Level.SEVERE, null, ex);
        }
            
   
       
        
      
    }//GEN-LAST:event_rent_tableMouseClicked

    private void r_customActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_customActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_customActionPerformed

    private void elements_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_elements_tableMouseClicked
        // avaiable table mouse click
        int r = elements_table.getSelectedRow();
        //String id = elements_table.getValueAt(r,0).toString();
        String element = elements_table.getValueAt(r,1).toString();
        String code = elements_table.getValueAt(r,2).toString();
        String status = elements_table.getValueAt(r,3).toString();
        String price = elements_table.getValueAt(r,4).toString();
        String comment = elements_table.getValueAt(r,5).toString();
        
      //  r_id.setText(id);
        r_elements.setText(element);
        r_code.setText(code);
        r_status.setSelectedItem(status);
        r_price.setText(price);
        
       
    }//GEN-LAST:event_elements_tableMouseClicked

    private void print_rentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_rentBtnActionPerformed
        // print rent button
        try {
            rent_table.print();
            
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_print_rentBtnActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void e_search2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e_search2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_e_search2KeyReleased

    private void r_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_resetActionPerformed
        // clear fields
        reset();
    }//GEN-LAST:event_r_resetActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // UPDATE rent BUTTON
        String custom = r_custom.getSelectedItem().toString();
        String payment = r_pay.getSelectedItem().toString();
        String element = r_elements.getText();
        String code = r_code.getText();
        String status = r_status.getSelectedItem().toString();
        String price = r_price.getText();
        String fecha_alq = new SimpleDateFormat("yyyy/MM/dd").format(this.r_date.getDate());
        String fecha_dev = new SimpleDateFormat("yyyy/MM/dd").format(this.return_date.getDate());
        //String fecha_act = new SimpleDateFormat("yyyy/MM/dd").format(this.fecha_Act.getDate());
        /*Date uIssueDate = r_date.getDate();
        Long l1 = uIssueDate.getTime();
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        Date uDueDate = return_date.getDate();
        long l2 = uDueDate.getTime();
        java.sql.Date sDueDate = new java.sql.Date(l2);*/
        //SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy");
        //String d = format.format(fecha);
        String rid = r_id.getText();

        if(r_custom.getSelectedIndex()== 0||r_pay.getSelectedIndex()== 0 ||r_elements.getText().isEmpty() || r_code.getText().isEmpty() || r_status.getSelectedIndex() == 1 || r_price.getText().isEmpty()|| r_date.getDate().toString().isEmpty()){

            JOptionPane.showMessageDialog(this,"Falta información. Todos los campos son obligatorios");
        }else{

            try {
                Statement s = db.mycon().createStatement();
                s.executeUpdate("UPDATE alquilerestbl SET rent_client ='"+custom+"',rent_element ='"+element+"',rent_status ='"+status+"',rent_price ='"+price+"',rent_date ='"+fecha_alq+"',return_date ='"+fecha_dev+"',rent_payment ='"+payment+"',rent_code ='"+code+"' WHERE rent_id='"+rid+"' ");
                JOptionPane.showMessageDialog(null,"Datos de alquiler modificados");
                tb_rent_load();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        tb_load();
        reset();

    }//GEN-LAST:event_updateBtnActionPerformed

    private void updateBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtn2ActionPerformed
        // TODO add your handling code here:
         String name = r_elements.getText();
        String price = r_price.getText();
        String status = r_status.getSelectedItem().toString();
        
        String fecha_alq = new SimpleDateFormat("yyyy/MM/dd").format(this.r_date.getDate());
        String fecha_dev = new SimpleDateFormat("yyyy/MM/dd").format(this.return_date.getDate());
        String fecha_act = new SimpleDateFormat("yyyy/MM/dd").format(this.fecha_Act.getDate());
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        
        
        
       /* Date uIssueDate = r_date.getDate();
        Long l1 = uIssueDate.getTime();
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        
        Date uDueDate = return_date.getDate();
        long l2 = uDueDate.getTime();
        java.sql.Date sDueDate = new java.sql.Date(l2);
        
         Date fecha = new Date();*/
           try {
               
               Date fecha1 = formato.parse(fecha_alq);
               Date fecha2 = formato.parse(fecha_dev);
               Date fecha3= formato.parse(fecha_act);
               
               if (fecha1.before(fecha3)) {
                   try {
                       
                   
                Statement s = db.mycon().createStatement();
                s.executeUpdate("UPDATE elementostbl SET element_price ='"+price+"' WHERE element_name='"+name+"' ");
                s.executeUpdate("UPDATE typesofelements SET price ='"+price+"' WHERE name = '"+name+"'");
                   JOptionPane.showMessageDialog(null,"Precios actualizados correctamente");
                   
                   } catch (Exception e) {
                   }
                   
               }
               
               /* Statement s = db.mycon().createStatement();
                s.executeUpdate("UPDATE elementostbl SET element_price ='"+price+"' WHERE element_name='"+name+"' ");
                s.executeUpdate("UPDATE typesofelements SET price ='"+price+"' WHERE name = '"+name+"'");
                s.executeUpdate("UPDATE alquilerestbl SET rent_price ='"+price+"' WHERE rent_element = '"+name+"'");
                JOptionPane.showMessageDialog(null,"Precios actualizados correctamente");*/

            } catch (Exception e) {
                System.out.println(e);
            }
    }//GEN-LAST:event_updateBtn2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField e_search;
    private javax.swing.JTextField e_search2;
    private javax.swing.JTable elements_table;
    private com.toedter.calendar.JDateChooser fecha_Act;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton print_rentBtn;
    private javax.swing.JComboBox<String> r_account;
    private javax.swing.JTextField r_code;
    private javax.swing.JComboBox<String> r_custom;
    private com.toedter.calendar.JDateChooser r_date;
    private javax.swing.JTextField r_elements;
    private javax.swing.JTextField r_id;
    private javax.swing.JComboBox<String> r_pay;
    private javax.swing.JTextField r_price;
    private javax.swing.JButton r_reset;
    private javax.swing.JComboBox<String> r_status;
    private javax.swing.JTable rent_table;
    private com.toedter.calendar.JDateChooser return_date;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton updateBtn2;
    // End of variables declaration//GEN-END:variables
}
