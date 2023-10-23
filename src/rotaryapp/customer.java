
package rotaryapp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class customer extends javax.swing.JPanel {

    /**
     * Creates new form customer
     */
    public customer() {
        initComponents();
        tb_load();
    }
    
    
    //verificar cliente duplicado por dni
    public boolean checkDuplicate(){
        
        String dni = c_dni.getText();
        boolean isExist = false;
        
        try {
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT *FROM clientestbl WHERE cliente_dni = '"+dni+"'");
            if (rs.next()){
                isExist = true;
                
            }else{
                isExist =false;
            }
            
        } catch (Exception e) {
        }
        
        return isExist;
    
    
    }
    
    public void tb_load(){
        
        try {
            DefaultTableModel dt = (DefaultTableModel) customer_table.getModel();
            dt.setRowCount(0);
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM clientestbl");
            
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

    private void reset(){
        c_id.setText("");
        c_name.setText("");
        c_dni.setText("");
        c_tel.setText("");
        c_dom.setText("");
        c_loc.setText("");
        
    
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        c_id = new javax.swing.JTextField();
        c_name = new javax.swing.JTextField();
        c_tel = new javax.swing.JTextField();
        c_dni = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        c_dom = new javax.swing.JTextField();
        c_loc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        c_reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customer_table = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        search_table = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 51, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("DNI");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Cliente");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 102));
        jLabel4.setText("ID");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setText("Telefono");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("Domicilio");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 102));
        jLabel7.setText("Localidad");

        c_id.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        c_id.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        c_name.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        c_name.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        c_tel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        c_tel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        c_dni.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        c_dni.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        saveBtn.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(0, 51, 102));
        saveBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\tick si.png")); // NOI18N
        saveBtn.setText("Guardar");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(0, 51, 102));
        updateBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\update.png")); // NOI18N
        updateBtn.setText("Editar");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(0, 51, 102));
        deleteBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\delete.png")); // NOI18N
        deleteBtn.setText("Eliminar");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        searchBtn.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(0, 51, 102));
        searchBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\search.png")); // NOI18N
        searchBtn.setText("Buscar");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        c_dom.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        c_dom.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        c_loc.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        c_loc.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setText("CLIENTES");

        c_reset.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        c_reset.setForeground(new java.awt.Color(0, 51, 102));
        c_reset.setText("Reset");
        c_reset.setToolTipText("");
        c_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(c_id, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 74, Short.MAX_VALUE))
                            .addComponent(c_tel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(c_dom, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(c_loc, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(411, 411, 411)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c_reset)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(c_reset)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(c_id, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_dni)
                    .addComponent(c_tel)
                    .addComponent(c_dom)
                    .addComponent(c_loc))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        customer_table.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        customer_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "DNI", "Teléfono", "Domicilio", "Localidad"
            }
        ));
        customer_table.setSelectionBackground(new java.awt.Color(0, 51, 102));
        customer_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customer_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customer_table);

        jButton5.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 51, 102));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\print 25px.png")); // NOI18N
        jButton5.setText("Imprimir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Lista de clientes");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setText("Buscador:");

        search_table.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        search_table.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        search_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_tableKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(413, 413, 413))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(search_table, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(search_table, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // DELETE BUTTON
        
        String name = c_name.getText();
        
        if(name.isEmpty()){
            
            JOptionPane.showMessageDialog(this,"Seleccione cliente para eliminar.");
            
        }else{
            try {
                Statement s = db.mycon().createStatement();
                s.executeUpdate("DELETE FROM clientestbl WHERE cliente_name = '"+name+"'");
                JOptionPane.showMessageDialog(null,"Datos eliminados correctamente");
            } catch (SQLException e) {
                System.out.println(e);


            }
        }
        
        tb_load(); 
        reset();
        
        
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        //button search
        
        String name = c_name.getText();
        try {
            Statement s = db.mycon().createStatement();
        ResultSet rs = s.executeQuery("SELECT *FROM clientestbl WHERE cliente_name = '"+name+"'");
            
            if (rs.next()){
                c_id.setText(rs.getString("cid"));
                c_name.setText(rs.getString("cliente_name"));
                c_dni.setText(rs.getString("cliente_dni"));
                c_tel.setText(rs.getString("cliente_tel"));
                c_dom.setText(rs.getString("cliente_dom"));
                c_loc.setText(rs.getString("cliente_loc"));
                
            
            }
            
        } catch (SQLException e) {
            System.out.println(e);
            
            
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // UPDATE CUSTOMER BUTTON
        String name = c_name.getText();
        String dni = c_dni.getText();
        String telefono = c_tel.getText();
        String domicilio = c_dom.getText();
        String localidad = c_loc.getText();
        String id = c_id.getText();
        
        if(name.isEmpty() || dni.isEmpty() || telefono.isEmpty()||domicilio.isEmpty()||localidad.isEmpty()){
            
            JOptionPane.showMessageDialog(this,"No se puede actualizar datos, falta información. Todos los campos son obligatorios.");
        }else{
        
        try {
            Statement s = db.mycon().createStatement();
            s.executeUpdate("UPDATE clientestbl SET cliente_name ='"+name+"',cliente_dni ='"+dni+"',cliente_tel ='"+telefono+"',cliente_dom ='"+domicilio+"',cliente_loc ='"+localidad+"' WHERE cid='"+id+"' ");
            JOptionPane.showMessageDialog(null,"Datos actualizados correctamente");
        } catch (SQLException e) {
            System.out.println(e);
        }
        }
        
        tb_load();
        reset();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // button save
        
        String name = c_name.getText();
        String dni = c_dni.getText();
        String telefono = c_tel.getText();
        String domicilio = c_dom.getText();
        String localidad = c_loc.getText();
        
        if(name.isEmpty() || dni.isEmpty() || telefono.isEmpty()||domicilio.isEmpty()||localidad.isEmpty()){
            
            JOptionPane.showMessageDialog(this,"Falta información. Todos los campos son obligatorios");
        }else if(checkDuplicate()== true){
            JOptionPane.showMessageDialog(this, "Usuario ya registrado anteriormente. Utilizar el buscador");
        }else{
        
        try {
            Statement s = db.mycon().createStatement();
            s.executeUpdate("INSERT INTO clientestbl(cliente_name, cliente_dni, cliente_tel, cliente_dom, cliente_loc) VALUES ('"+name+"','"+dni+"','"+telefono+"','"+domicilio+"','"+localidad+"')");
            JOptionPane.showMessageDialog(null,"Datos guardados correctamente");
            
        } catch (Exception e) {
            System.out.println(e);
        }
        }
        tb_load();
        reset();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void c_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_resetActionPerformed
        // set reset all fields
        reset();
        
    }//GEN-LAST:event_c_resetActionPerformed

    private void customer_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer_tableMouseClicked
        // mouse click under table
        
        int r = customer_table.getSelectedRow();
        String id = customer_table.getValueAt(r,0).toString();
        String name = customer_table.getValueAt(r,1).toString();
        String dni = customer_table.getValueAt(r,2).toString();
        String telefono = customer_table.getValueAt(r,3).toString();
        String domicilio = customer_table.getValueAt(r,4).toString();
        String localidad = customer_table.getValueAt(r,5).toString();
        
        c_id.setText(id);
        c_name.setText(name);
        c_dni.setText(dni);
        c_tel.setText(telefono);
        c_dom.setText(domicilio);
        c_loc.setText(localidad);
        
        
        
        
        
    }//GEN-LAST:event_customer_tableMouseClicked

    private void search_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_tableKeyReleased
        // search by released key
        String name = search_table.getText();
        try {
            
            DefaultTableModel dt = (DefaultTableModel) customer_table.getModel();
            dt.setRowCount(0);
            Statement s = db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM clientestbl WHERE cliente_name LIKE '%"+name+"%'");
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
            
        } catch (Exception e) {
            tb_load();
        }
    }//GEN-LAST:event_search_tableKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField c_dni;
    private javax.swing.JTextField c_dom;
    private javax.swing.JTextField c_id;
    private javax.swing.JTextField c_loc;
    private javax.swing.JTextField c_name;
    private javax.swing.JButton c_reset;
    private javax.swing.JTextField c_tel;
    private javax.swing.JTable customer_table;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField search_table;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
