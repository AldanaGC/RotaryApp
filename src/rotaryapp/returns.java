
package rotaryapp;

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
import java.util.Date;
import java.lang.String;
import java.text.DateFormat;
import java.text.ParseException;
import javax.swing.table.TableModel;



public class returns extends javax.swing.JPanel {

    
    public returns() {
        initComponents();
        
        tb_rent_load();
        getcustomers();
       fill_date();
   
    }

    public void fill_date(){
    
        Date fecha = new Date();
        return_date.setDate(fecha);
    
    }
    private void reset(){
        r_custom.setSelectedIndex(0);
        r_pay.setSelectedIndex(0);
        r_elements.setText("");
        r_code.setText("");
        r_status.setSelectedIndex(0);
        r_price.setText("");
      
        
    
    }
    
    public void tb_rent_load(){
        
        try {
            String rentStatusOne = "Alquiler";
            String rentStatusTwo = "Préstamo";
            String rentStatusThree = "Devolución";
            
            DefaultTableModel dt = (DefaultTableModel) rent_table.getModel();
            dt.setRowCount(0);
            
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM alquilerestbl WHERE rent_status = '"+rentStatusOne+"' OR rent_status = '"+rentStatusTwo+"' OR rent_status = '"+rentStatusThree+"'");
            
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
        jLabel9 = new javax.swing.JLabel();
        r_status1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        r_date = new com.toedter.calendar.JDateChooser();
        return_date = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        e_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        rent_table = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        print_rentBtn = new javax.swing.JButton();
        r_reset = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 51, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Último mes pago");

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
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Library Management System icons/icons/ingresar.png"))); // NOI18N
        saveBtn.setText("Devolver");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        r_status.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        r_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Disponible", "Alquiler", "Préstamo", "Fuera de servicio" }));
        r_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_statusActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setText("Estado de elemento");

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
        r_pay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 102));
        jLabel11.setText("Fecha de devolución");

        jButton5.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 51, 102));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Library Management System icons/icons/imprimir.png"))); // NOI18N
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

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setText("Marcar devolución");

        r_status1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        r_status1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Devolución" }));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setText("Fecha de alquiler");

        r_date.setDateFormatString("dd-MM-yyyy");

        return_date.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r_id, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r_elements, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(r_code, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(172, 172, 172)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(r_pay, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(r_price, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(r_custom, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(r_status, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(r_status1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(r_date, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(return_date, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_elements, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_code, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(r_custom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r_pay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r_price, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(return_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(r_date, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_status, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_status1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Lista de alquileres y devoluciones");

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
                "N° alquiler", "Cliente", "Elemento", "Código", "Estado", "Precio", "Fecha alquiler", "Fecha devolucion", "Forma de pago", "Ultimo pago"
            }
        ));
        rent_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rent_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rent_table);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setText("DEVOLUCIONES");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 102));
        jLabel13.setText("Buscador:");

        print_rentBtn.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        print_rentBtn.setForeground(new java.awt.Color(0, 51, 102));
        print_rentBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\print 25px.png")); // NOI18N
        print_rentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_rentBtnActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e_search, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r_reset))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(print_rentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 234, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(print_rentBtn)))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(e_search, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
             
        String status = "Disponible";
      
        String code = r_code.getText();
        
        try {
            Statement s = db.mycon().createStatement();
            
            s.executeUpdate("UPDATE elementostbl SET element_status ='"+status+"' WHERE element_code='"+code+"' ");
           
            //JOptionPane.showMessageDialog(null,"Datos actualizados correctamente");
            //tb_load();
            tb_rent_load();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void updateRent(){
             
        String status = "Devolución";
        String statusTwo="Préstamo";
        String code = r_code.getText();
        
        try {
            Statement s = db.mycon().createStatement();
            if(r_status.equals(status)){
            s.executeUpdate("UPDATE alquilerestbl SET element_status ='"+status+"' WHERE element_code='"+code+"' ");
            }else{
                s.executeUpdate("UPDATE elementostbl SET element_status ='"+statusTwo+"'  WHERE element_code='"+code+"' ");
            }
            //JOptionPane.showMessageDialog(null,"Datos actualizados correctamente");
            
            tb_rent_load();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
            // button save
           
        String element = r_elements.getText(); 
        String code = r_code.getText();
        String custom = r_custom.getSelectedItem().toString();
        String payment = r_pay.getSelectedItem().toString();
        String status = r_status.getSelectedItem().toString();
        String statusTwo = r_status1.getSelectedItem().toString();
       // String price = r_price.getText();
        Date uIssueDate = r_date.getDate();
        Long l1 = uIssueDate.getTime();
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        Date uDueDate = return_date.getDate();
        long l2 = uDueDate.getTime();
        java.sql.Date sDueDate = new java.sql.Date(l2);
        
       
        if(r_custom.getSelectedIndex()== 0||r_pay.getSelectedIndex()== 0 ||r_elements.getText().isEmpty() || r_code.getText().isEmpty() || r_status.getSelectedIndex() == 2 || r_date.getDate().toString().isEmpty()){
            
            JOptionPane.showMessageDialog(this,"Falta información. Todos los campos son obligatorios");
        }else{
            try {
                Statement s = db.mycon().createStatement();
                s.executeUpdate("INSERT INTO devolucionestbl(ret_element, ret_code, ret_custom, ret_payStatus, ret_status,rent_date, ret_date) VALUES ('"+element+"','"+code+"','"+custom+"','"+payment+"','"+status+"','"+sIssueDate+"','"+sDueDate+"')");
                s.executeUpdate("UPDATE alquilerestbl SET rent_status ='"+statusTwo+"' WHERE rent_code='"+code+"' ");
                s.executeUpdate("UPDATE elementostbl SET element_status ='"+status+"' WHERE element_code='"+code+"' ");
                JOptionPane.showMessageDialog(null,"¡Elemento devuelto correctamente!");
                //updateElement();
                //updateRent();
                tb_rent_load();
                
                
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
            
            int r = rent_table.getSelectedRow();
            //String to =rent_table.getModel().getValueAt(r,0).toString();
            
            
            
            TableModel model = rent_table.getModel();
            
            String id = rent_table.getValueAt(r,0).toString();
            String name = rent_table.getValueAt(r,1).toString();
            String element = rent_table.getValueAt(r,2).toString();
            String code = rent_table.getValueAt(r, 3).toString();
            String status = rent_table.getValueAt(r,4).toString();
            String price = rent_table.getValueAt(r,5).toString();
            Date fechaalq = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(r,6));
            Date dateReturn = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(r,7));
            String pay = rent_table.getValueAt(r,7).toString();
           
            
            r_id.setText(id);
            r_custom.setSelectedItem(name);
            r_elements.setText(element);
            r_code.setText(code);
            r_status.setSelectedItem(status);
            r_price.setText(price);
            r_date.setDate(fechaalq);
            return_date.setDate(dateReturn);
            r_pay.setSelectedItem(pay);
          
        } catch (Exception e) {
           
        }
        
      
    }//GEN-LAST:event_rent_tableMouseClicked

    private void r_customActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_customActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_customActionPerformed

    private void print_rentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_rentBtnActionPerformed
        // print rent button
        try {
            rent_table.print();
            
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_print_rentBtnActionPerformed

    private void r_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_resetActionPerformed
        // clear fields
        reset();
    }//GEN-LAST:event_r_resetActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // UPDATE CUSTOMER BUTTON
        String custom = r_custom.getSelectedItem().toString();
        String payment = r_pay.getSelectedItem().toString();
        String element = r_elements.getText();
        String code = r_code.getText();
        String status = r_status.getSelectedItem().toString();
        String price = r_price.getText();
        Date fecha = r_date.getDate();
        SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy");
        String d = format.format(fecha);
        String rid = r_id.getText();

        if(r_custom.getSelectedIndex()== 0||r_pay.getSelectedIndex()== 0 ||r_elements.getText().isEmpty() || r_code.getText().isEmpty() || r_status.getSelectedIndex() == 1 || r_price.getText().isEmpty()|| r_date.getDate().toString().isEmpty()){

            JOptionPane.showMessageDialog(this,"Falta información. Todos los campos son obligatorios");
        }else{

            try {
                Statement s = db.mycon().createStatement();
                s.executeUpdate("UPDATE alquilerestbl SET rent_client ='"+custom+"',rent_element ='"+element+"',rent_status ='"+status+"',rent_price ='"+price+"',rent_date ='"+d+"',rent_payment ='"+payment+"',rent_code ='"+code+"' WHERE rent_id='"+rid+"' ");
                JOptionPane.showMessageDialog(null,"Datos de alquiler modificados");
                tb_rent_load();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        reset();

    }//GEN-LAST:event_updateBtnActionPerformed

    private void r_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_statusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField e_search;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton print_rentBtn;
    private javax.swing.JTextField r_code;
    private javax.swing.JComboBox<String> r_custom;
    private com.toedter.calendar.JDateChooser r_date;
    private javax.swing.JTextField r_elements;
    private javax.swing.JTextField r_id;
    private javax.swing.JComboBox<String> r_pay;
    private javax.swing.JTextField r_price;
    private javax.swing.JButton r_reset;
    private javax.swing.JComboBox<String> r_status;
    private javax.swing.JComboBox<String> r_status1;
    private javax.swing.JTable rent_table;
    private com.toedter.calendar.JDateChooser return_date;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
