
package rotaryapp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class elements extends javax.swing.JPanel {

    
    public elements() {
        initComponents();
        tb_load();
        getelements();
        tb_purchase();
    }
    
    public boolean checkDuplicate(){
        
        String code = e_code.getText();
        boolean isExist = false;
        
        try {
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT *FROM elementostbl WHERE element_code = '"+code+"'");
            if (rs.next()){
                isExist = true;
                
            }else{
                isExist =false;
            }
            
        } catch (Exception e) {
        }
        
        return isExist;
    
    
    }
    
    public void fill_date(){
    
        Date fecha = new Date();
        out_element.setDate(fecha);
    
    }
    
    Details jtRowData = new Details();
    
    public void loadItemfromDB(){
        
        String element = e_name.getSelectedItem().toString();
        
        try {
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM typesofelements WHERE name= '"+element+"'");
            
            while (rs.next()) {   
                String priceNE = rs.getString("price");
                e_price.setText(priceNE);
               
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
                
    
        
        
    }
    private void getelements(){
        
        try {
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM typesofelements");
            
            while (rs.next()) {   
                String element = rs.getString("name");
                e_name.addItem(element);
               
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
        
    
    
    public void tb_load(){
        
        try {
            DefaultTableModel dt = (DefaultTableModel) elements_table.getModel();
            dt.setRowCount(0);
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM elementostbl");
            
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
    
    public void tb_purchase(){
        
        try {
            DefaultTableModel dt = (DefaultTableModel) purchase_table.getModel();
            dt.setRowCount(0);
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM elements_moreinf");
            
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
        e_id.setText("");
        e_name.setSelectedIndex(0);
        e_code.setText("");
        e_status.setSelectedIndex(0);
        e_price.setText("");
        e_comment.setText("");
        e_code1.setText("");
        e_code2.setText("");
        Date fecha = new Date();
        enter_element.setDate(fecha);
        e_brand.setText("");
        purchase_price.setText("");
        
    
    }
    
    private void filter_elements(){
        String status = e_status1.getSelectedItem().toString();
        try {
            
            DefaultTableModel dt = (DefaultTableModel) elements_table.getModel();
            dt.setRowCount(0);
            Statement s = db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM elementostbl WHERE element_status = '"+status+"'");
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
            System.out.println(e);
            tb_load();
            
        }
    
        
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        e_reset = new javax.swing.JButton();
        e_status = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        enter_element = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        out_element = new com.toedter.calendar.JDateChooser();
        e_name = new javax.swing.JComboBox<>();
        e_id = new app.bolivia.swing.JCTextField();
        e_code = new app.bolivia.swing.JCTextField();
        e_price = new app.bolivia.swing.JCTextField();
        e_comment = new app.bolivia.swing.JCTextField();
        e_brand = new app.bolivia.swing.JCTextField();
        purchase_price = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        saveBtn1 = new javax.swing.JButton();
        e_code1 = new app.bolivia.swing.JCTextField();
        e_code2 = new app.bolivia.swing.JCTextField();
        searchBtn1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        saveBtn2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        new_element = new app.bolivia.swing.JCTextField();
        newE_price = new app.bolivia.swing.JCTextField();
        charge_newElement = new javax.swing.JButton();
        updateBtn1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        e_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        elements_table = new javax.swing.JTable();
        e_status1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        e_search1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        purchase_table = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 51, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));

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
        updateBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\editar 25px(1).png")); // NOI18N
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

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setText("ELEMENTOS ORTOPÉDICOS");

        e_reset.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        e_reset.setForeground(new java.awt.Color(0, 51, 102));
        e_reset.setText("Reset");
        e_reset.setToolTipText("");
        e_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_resetActionPerformed(evt);
            }
        });

        e_status.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        e_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado actual", "Disponible", "Alquiler", "Préstamo", "Fuera de servicio" }));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 102));
        jLabel7.setText("Fecha:");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 102));
        jLabel13.setText("F. Baja del elemento:");

        e_name.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        e_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre del elemento" }));
        e_name.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 102)));
        e_name.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                e_namePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        e_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_nameActionPerformed(evt);
            }
        });

        e_id.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 102)));
        e_id.setForeground(new java.awt.Color(0, 51, 102));
        e_id.setDisabledTextColor(new java.awt.Color(0, 51, 102));
        e_id.setFocusTraversalPolicyProvider(true);
        e_id.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        e_id.setPhColor(new java.awt.Color(0, 51, 102));
        e_id.setPlaceholder("ID");
        e_id.setSelectedTextColor(new java.awt.Color(0, 51, 102));
        e_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                e_idFocusLost(evt);
            }
        });
        e_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_idActionPerformed(evt);
            }
        });

        e_code.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 102)));
        e_code.setForeground(new java.awt.Color(0, 51, 102));
        e_code.setDisabledTextColor(new java.awt.Color(0, 51, 102));
        e_code.setFocusTraversalPolicyProvider(true);
        e_code.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        e_code.setPhColor(new java.awt.Color(0, 51, 102));
        e_code.setPlaceholder("Código");
        e_code.setPreferredSize(new java.awt.Dimension(188, 25));
        e_code.setSelectedTextColor(new java.awt.Color(0, 51, 102));
        e_code.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                e_codeFocusLost(evt);
            }
        });
        e_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_codeActionPerformed(evt);
            }
        });

        e_price.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 102)));
        e_price.setForeground(new java.awt.Color(0, 51, 102));
        e_price.setDisabledTextColor(new java.awt.Color(0, 51, 102));
        e_price.setFocusTraversalPolicyProvider(true);
        e_price.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        e_price.setPhColor(new java.awt.Color(0, 51, 102));
        e_price.setPlaceholder("Precio");
        e_price.setSelectedTextColor(new java.awt.Color(0, 51, 102));
        e_price.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                e_priceFocusLost(evt);
            }
        });
        e_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_priceActionPerformed(evt);
            }
        });

        e_comment.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 102)));
        e_comment.setForeground(new java.awt.Color(0, 51, 102));
        e_comment.setDisabledTextColor(new java.awt.Color(0, 51, 102));
        e_comment.setFocusTraversalPolicyProvider(true);
        e_comment.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        e_comment.setPhColor(new java.awt.Color(0, 51, 102));
        e_comment.setPlaceholder("Descripción del elemento");
        e_comment.setSelectedTextColor(new java.awt.Color(0, 51, 102));
        e_comment.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                e_commentFocusLost(evt);
            }
        });
        e_comment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_commentActionPerformed(evt);
            }
        });

        e_brand.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 102)));
        e_brand.setForeground(new java.awt.Color(0, 51, 102));
        e_brand.setDisabledTextColor(new java.awt.Color(0, 51, 102));
        e_brand.setFocusTraversalPolicyProvider(true);
        e_brand.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        e_brand.setPhColor(new java.awt.Color(0, 51, 102));
        e_brand.setPlaceholder("Marca");
        e_brand.setSelectedTextColor(new java.awt.Color(0, 51, 102));
        e_brand.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                e_brandFocusLost(evt);
            }
        });
        e_brand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_brandActionPerformed(evt);
            }
        });

        purchase_price.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 102)));
        purchase_price.setForeground(new java.awt.Color(0, 51, 102));
        purchase_price.setDisabledTextColor(new java.awt.Color(0, 51, 102));
        purchase_price.setFocusTraversalPolicyProvider(true);
        purchase_price.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        purchase_price.setPhColor(new java.awt.Color(0, 51, 102));
        purchase_price.setPlaceholder("Precio de compra");
        purchase_price.setSelectedTextColor(new java.awt.Color(0, 51, 102));
        purchase_price.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                purchase_priceFocusLost(evt);
            }
        });
        purchase_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_priceActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setText("-Datos de baja-");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 102));
        jLabel14.setText("DATOS OBLIGATORIOS");

        saveBtn1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        saveBtn1.setForeground(new java.awt.Color(0, 51, 102));
        saveBtn1.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\tick si.png")); // NOI18N
        saveBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtn1ActionPerformed(evt);
            }
        });

        e_code1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 102)));
        e_code1.setForeground(new java.awt.Color(0, 51, 102));
        e_code1.setDisabledTextColor(new java.awt.Color(0, 51, 102));
        e_code1.setFocusTraversalPolicyProvider(true);
        e_code1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        e_code1.setPhColor(new java.awt.Color(0, 51, 102));
        e_code1.setPlaceholder("Código");
        e_code1.setPreferredSize(new java.awt.Dimension(188, 25));
        e_code1.setSelectedTextColor(new java.awt.Color(0, 51, 102));
        e_code1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                e_code1FocusLost(evt);
            }
        });
        e_code1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_code1ActionPerformed(evt);
            }
        });

        e_code2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 102)));
        e_code2.setForeground(new java.awt.Color(0, 51, 102));
        e_code2.setDisabledTextColor(new java.awt.Color(0, 51, 102));
        e_code2.setFocusTraversalPolicyProvider(true);
        e_code2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        e_code2.setPhColor(new java.awt.Color(0, 51, 102));
        e_code2.setPlaceholder("Nombre del elemento");
        e_code2.setPreferredSize(new java.awt.Dimension(188, 25));
        e_code2.setSelectedTextColor(new java.awt.Color(0, 51, 102));
        e_code2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                e_code2FocusLost(evt);
            }
        });
        e_code2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_code2ActionPerformed(evt);
            }
        });

        searchBtn1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        searchBtn1.setForeground(new java.awt.Color(0, 51, 102));
        searchBtn1.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\search.png")); // NOI18N
        searchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 102));
        jLabel15.setText("-Datos de compra-");

        saveBtn2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        saveBtn2.setForeground(new java.awt.Color(0, 51, 102));
        saveBtn2.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\tick si.png")); // NOI18N
        saveBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtn2ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(153, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 102));
        jLabel16.setText("CARGAR NUEVO TIPO DE ELEMENTO");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 102));
        jLabel17.setText("(Solo si no se encuentra tipo en lista)");

        new_element.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 102)));
        new_element.setForeground(new java.awt.Color(0, 51, 102));
        new_element.setFocusTraversalPolicyProvider(true);
        new_element.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        new_element.setPlaceholder("Nombre del elemento");
        new_element.setSelectedTextColor(new java.awt.Color(0, 51, 102));
        new_element.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                new_elementFocusLost(evt);
            }
        });
        new_element.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_elementActionPerformed(evt);
            }
        });

        newE_price.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 102)));
        newE_price.setForeground(new java.awt.Color(0, 51, 102));
        newE_price.setFocusTraversalPolicyProvider(true);
        newE_price.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        newE_price.setPlaceholder("Precio de alquiler");
        newE_price.setSelectedTextColor(new java.awt.Color(0, 51, 102));
        newE_price.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                newE_priceFocusLost(evt);
            }
        });
        newE_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newE_priceActionPerformed(evt);
            }
        });

        charge_newElement.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        charge_newElement.setForeground(new java.awt.Color(0, 51, 102));
        charge_newElement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Library Management System icons/icons/ingresar.png"))); // NOI18N
        charge_newElement.setText("Cargar");
        charge_newElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                charge_newElementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(new_element, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(newE_price, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(charge_newElement)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(new_element, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newE_price, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(charge_newElement))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        updateBtn1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        updateBtn1.setForeground(new java.awt.Color(0, 51, 102));
        updateBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Library Management System icons/icons/archivo-factura-dolar.png"))); // NOI18N
        updateBtn1.setText("Actuallizar precio");
        updateBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enter_element, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(e_brand, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(purchase_price, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(out_element, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(e_code2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(e_code1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBtn1)))
                        .addGap(100, 100, 100)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(e_id, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(e_name, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(e_code, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(e_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(e_price, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(e_comment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel14)
                                .addGap(374, 374, 374)
                                .addComponent(e_reset))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(e_reset))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_status, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e_name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e_id, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e_code, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e_price, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e_comment, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(updateBtn)
                    .addComponent(deleteBtn)
                    .addComponent(searchBtn)
                    .addComponent(updateBtn1))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(e_code2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(e_code1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(e_brand, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(purchase_price, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enter_element, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(saveBtn1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(out_element, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13)))
                                    .addComponent(saveBtn2))
                                .addGap(27, 27, 27))
                            .addComponent(searchBtn1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 51, 102));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldan\\OneDrive\\Documentos\\NetBeansProjects\\Icons\\img\\print 25px.png")); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Lista de elementos");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setText("Buscador por  elemento:");

        e_search.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        e_search.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        e_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_searchActionPerformed(evt);
            }
        });
        e_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                e_searchKeyReleased(evt);
            }
        });

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
        elements_table.setSelectionBackground(new java.awt.Color(0, 102, 153));
        elements_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                elements_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(elements_table);
        if (elements_table.getColumnModel().getColumnCount() > 0) {
            elements_table.getColumnModel().getColumn(0).setResizable(false);
            elements_table.getColumnModel().getColumn(0).setPreferredWidth(1);
            elements_table.getColumnModel().getColumn(1).setResizable(false);
            elements_table.getColumnModel().getColumn(1).setPreferredWidth(10);
            elements_table.getColumnModel().getColumn(2).setResizable(false);
            elements_table.getColumnModel().getColumn(2).setPreferredWidth(3);
            elements_table.getColumnModel().getColumn(3).setResizable(false);
            elements_table.getColumnModel().getColumn(3).setPreferredWidth(3);
            elements_table.getColumnModel().getColumn(4).setResizable(false);
            elements_table.getColumnModel().getColumn(4).setPreferredWidth(5);
            elements_table.getColumnModel().getColumn(5).setResizable(false);
            elements_table.getColumnModel().getColumn(5).setPreferredWidth(3);
        }

        e_status1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        e_status1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Disponible", "Alquiler", "Préstamo", "Fuera de servicio" }));
        e_status1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_status1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 102));
        jLabel11.setText("Filtrar");

        e_search1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        e_search1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        e_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_search1ActionPerformed(evt);
            }
        });
        e_search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                e_search1KeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setText("Buscar por código");

        purchase_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Elemento", "Codigo", "F.compra", "Marca", "Precio compra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        purchase_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purchase_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(purchase_table);
        if (purchase_table.getColumnModel().getColumnCount() > 0) {
            purchase_table.getColumnModel().getColumn(0).setResizable(false);
            purchase_table.getColumnModel().getColumn(0).setPreferredWidth(1);
            purchase_table.getColumnModel().getColumn(1).setResizable(false);
            purchase_table.getColumnModel().getColumn(1).setPreferredWidth(10);
            purchase_table.getColumnModel().getColumn(2).setResizable(false);
            purchase_table.getColumnModel().getColumn(2).setPreferredWidth(3);
            purchase_table.getColumnModel().getColumn(3).setResizable(false);
            purchase_table.getColumnModel().getColumn(3).setPreferredWidth(3);
            purchase_table.getColumnModel().getColumn(4).setResizable(false);
            purchase_table.getColumnModel().getColumn(4).setPreferredWidth(5);
            purchase_table.getColumnModel().getColumn(5).setResizable(false);
            purchase_table.getColumnModel().getColumn(5).setPreferredWidth(3);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e_search, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(e_status1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 59, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(e_search, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(e_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(e_status1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void e_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e_searchKeyReleased
        // search by released key
        String name = e_search.getText();
       
        try {
            
            DefaultTableModel dt = (DefaultTableModel) elements_table.getModel();
            dt.setRowCount(0);
            Statement s = db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM elementostbl WHERE element_name LIKE '%"+name+"%'");
            
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
    }//GEN-LAST:event_e_searchKeyReleased

    private void elements_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_elements_tableMouseClicked
        // mouse click table
         int r = elements_table.getSelectedRow();
        String id = elements_table.getValueAt(r,0).toString();
        String name = elements_table.getValueAt(r,1).toString();
        String code = elements_table.getValueAt(r,2).toString();
        String status = elements_table.getValueAt(r,3).toString();
        String price = elements_table.getValueAt(r,4).toString();
        String comment = elements_table.getValueAt(r,5).toString();
        
        
        e_id.setText(id);
        e_name.setSelectedItem(name);
        e_code.setText(code);
        e_status.setSelectedItem(status);
        e_price.setText(price);
        e_comment.setText(comment);
        
        jtRowData.setVisible(true);
        jtRowData.pack();
        jtRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        jtRowData.e_id.setText(id);
        jtRowData.e_name.setText(name);
        jtRowData.e_code.setText(code);
        jtRowData.e_status.setText(status);
        jtRowData.e_price.setText(price);
        jtRowData.e_comment.setText(comment);
        
    }//GEN-LAST:event_elements_tableMouseClicked

    private void e_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_searchActionPerformed

    private void e_status1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_status1ActionPerformed
        // TODO add your handling code here:
        filter_elements();
    }//GEN-LAST:event_e_status1ActionPerformed

    private void e_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_search1ActionPerformed

    private void e_search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e_search1KeyReleased
        // search by code
         String code = e_search1.getText();
        try {
            
            DefaultTableModel dt = (DefaultTableModel) elements_table.getModel();
            dt.setRowCount(0);
            Statement s = db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM elementostbl WHERE element_code = '"+code+"' ");
            
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
    }//GEN-LAST:event_e_search1KeyReleased

    private void searchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn1ActionPerformed
        // TODO add your handling code here:
        String code = e_code1.getText();
        try {
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT *FROM elementostbl WHERE element_code = '"+code+"'");

            if (rs.next()){
                e_id.setText(rs.getString("eid"));
                e_name.setSelectedItem(rs.getString("element_name"));
                e_code.setText(rs.getString("element_code"));
                e_code2.setText(rs.getString("element_name"));
                e_status.setSelectedItem(rs.getString("element_status"));
                e_price.setText(rs.getString("element_price"));
                e_comment.setText(rs.getString("element_descript"));

            }

        } catch (SQLException e) {
            System.out.println(e);

        }
    }//GEN-LAST:event_searchBtn1ActionPerformed

    private void e_code2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_code2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_code2ActionPerformed

    private void e_code2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e_code2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_e_code2FocusLost

    private void e_code1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_code1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_code1ActionPerformed

    private void e_code1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e_code1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_e_code1FocusLost

    private void saveBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtn1ActionPerformed
        // TODO add your handling code here:

        Date uIssueDate = enter_element.getDate();
        Long l1 = uIssueDate.getTime();
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        
        String brand = e_brand.getText();
        String pPrice = purchase_price.getText();
        
        String name = e_code2.getText();
        String code = e_code1.getText();
       
            try {
                Statement s = db.mycon().createStatement();
                s.executeUpdate("INSERT INTO elements_moreinf(element_name, element_code, element_entry, element_brand, purchase_price) VALUES ('"+name+"','"+code+"','"+sIssueDate+"','"+brand+"','"+pPrice+"')");
                JOptionPane.showMessageDialog(null,"Información guardada");

            } catch (Exception e) {
                System.out.println(e);
            }
            tb_purchase();
        
    }//GEN-LAST:event_saveBtn1ActionPerformed

    private void purchase_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purchase_priceActionPerformed

    private void purchase_priceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_purchase_priceFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_purchase_priceFocusLost

    private void e_brandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_brandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_brandActionPerformed

    private void e_brandFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e_brandFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_e_brandFocusLost

    private void e_commentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_commentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_commentActionPerformed

    private void e_commentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e_commentFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_e_commentFocusLost

    private void e_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_priceActionPerformed

    private void e_priceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e_priceFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_e_priceFocusLost

    private void e_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_codeActionPerformed

    private void e_codeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e_codeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_e_codeFocusLost

    private void e_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_idActionPerformed

    private void e_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e_idFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_e_idFocusLost

    private void newE_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newE_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newE_priceActionPerformed

    private void newE_priceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newE_priceFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_newE_priceFocusLost

    private void new_elementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_elementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_new_elementActionPerformed

    private void new_elementFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_new_elementFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_new_elementFocusLost

    private void charge_newElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_charge_newElementActionPerformed
        // botton para cargar tipo de elemento nuevo y precio

        String newElement = new_element.getText();
        int newP = Integer.parseInt(newE_price.getText());

        try {
            Statement s = db.mycon().createStatement();
            s.executeUpdate("INSERT INTO typesofelements(name, price) VALUES ('"+newElement+"','"+newP+"')");
            JOptionPane.showMessageDialog(null,"Datos guardados correctamente");

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_charge_newElementActionPerformed

    private void e_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_nameActionPerformed

    private void e_namePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_e_namePopupMenuWillBecomeInvisible
        // TODO add your handling code here:

        loadItemfromDB();

    }//GEN-LAST:event_e_namePopupMenuWillBecomeInvisible

    private void e_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_resetActionPerformed
        // clear fields
        reset();
    }//GEN-LAST:event_e_resetActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        //button search

        String name = e_name.getSelectedItem().toString();
        try {
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT *FROM elementostbl WHERE element_name = '"+name+"'");

            if (rs.next()){
                e_id.setText(rs.getString("eid"));
                e_name.setSelectedItem(rs.getString("element_name"));
                e_code.setText(rs.getString("element_code"));
                e_status.setSelectedItem(rs.getString("element_status"));
                e_price.setText(rs.getString("element_price"));
                e_comment.setText(rs.getString("element_descript"));

            }

        } catch (SQLException e) {
            System.out.println(e);

        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // DELETE BUTTON

        String name = e_name.getSelectedItem().toString();

        if(name.isEmpty()){

            JOptionPane.showMessageDialog(this,"Seleccione elemento para eliminar.");

        }else{
            try {
                Statement s = db.mycon().createStatement();
                s.executeUpdate("DELETE FROM elementostbl WHERE element_name = '"+name+"'");
                JOptionPane.showMessageDialog(null,"Datos eliminados correctamente");
            } catch (SQLException e) {
                System.out.println(e);

            }
        }

        tb_load();
        reset();

    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // UPDATE CUSTOMER BUTTON
        String name = e_name.getSelectedItem().toString();
        String code = e_code.getText();
        String status = e_status.getSelectedItem().toString();
        int price = Integer.parseInt(e_price.getText());
        String comment = e_comment.getText();
        String id = e_id.getText();

        if(e_name.getSelectedIndex() == 0 || e_code.getText().isEmpty() || e_status.getSelectedIndex() == 0 || e_price.getText().isEmpty()){

            JOptionPane.showMessageDialog(this,"Falta información. Todos los campos son obligatorios");
        }else{

            try {
                Statement s = db.mycon().createStatement();
                s.executeUpdate("UPDATE elementostbl SET element_name ='"+name+"',element_code ='"+code+"',element_status ='"+status+"',element_price ='"+price+"',element_descript ='"+comment+"' WHERE eid='"+id+"' ");
                s.executeUpdate("UPDATE typesofelements SET price ='"+price+"' WHERE name = '"+name+"'");
                JOptionPane.showMessageDialog(null,"Datos actualizados correctamente");

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        tb_load();
        reset();

    }//GEN-LAST:event_updateBtnActionPerformed

    /**
     *
     */

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // button save

        String name = e_name.getSelectedItem().toString();
        String code = e_code.getText();
        String status = e_status.getSelectedItem().toString();
        int price = Integer.parseInt(e_price.getText());
        String comment = e_comment.getText();
        String id = e_id.getText();

        if(e_name.getSelectedIndex()== 0 || e_code.getText().isEmpty() || e_status.getSelectedIndex() == 0 || e_price.getText().isEmpty()){

            JOptionPane.showMessageDialog(this,"Falta información. Todos los campos son obligatorios");
        }else if(checkDuplicate()== true){
            JOptionPane.showMessageDialog(this, "Elemento cargado con anterioridad. Verificar utilizando el buscador");
        }else{

            try {
                Statement s = db.mycon().createStatement();
                s.executeUpdate("INSERT INTO elementostbl(element_name, element_code, element_status, element_price, element_descript) VALUES ('"+name+"','"+code+"','"+status+"','"+price+"','"+comment+"')");
                JOptionPane.showMessageDialog(null,"Datos guardados correctamente");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        tb_load();
        reset();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void saveBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtn2ActionPerformed

    private void updateBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtn1ActionPerformed
        // actualizar precio
        
        String name = e_name.getSelectedItem().toString();
        String price = e_price.getText();
        String status = e_status.getSelectedItem().toString();
        
         LocalDate fecha =LocalDate.now();
        
        
        
        try {
                Statement s = db.mycon().createStatement();
                s.executeUpdate("UPDATE elementostbl SET element_price ='"+price+"' WHERE element_name='"+name+"' ");
                s.executeUpdate("UPDATE typesofelements SET price ='"+price+"' WHERE name = '"+name+"'");
                s.executeUpdate("UPDATE alquilerestbl SET rent_price ='"+price+"' WHERE rent_element = '"+name+"'");
                JOptionPane.showMessageDialog(null,"Precios actualizados correctamente");

            } catch (Exception e) {
                System.out.println(e);
            }
    }//GEN-LAST:event_updateBtn1ActionPerformed

    private void purchase_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchase_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_purchase_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton charge_newElement;
    private javax.swing.JButton deleteBtn;
    private app.bolivia.swing.JCTextField e_brand;
    private app.bolivia.swing.JCTextField e_code;
    private app.bolivia.swing.JCTextField e_code1;
    private app.bolivia.swing.JCTextField e_code2;
    private app.bolivia.swing.JCTextField e_comment;
    private app.bolivia.swing.JCTextField e_id;
    private javax.swing.JComboBox<String> e_name;
    private app.bolivia.swing.JCTextField e_price;
    private javax.swing.JButton e_reset;
    private javax.swing.JTextField e_search;
    private javax.swing.JTextField e_search1;
    private javax.swing.JComboBox<String> e_status;
    private javax.swing.JComboBox<String> e_status1;
    private javax.swing.JTable elements_table;
    private com.toedter.calendar.JDateChooser enter_element;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private app.bolivia.swing.JCTextField newE_price;
    private app.bolivia.swing.JCTextField new_element;
    private com.toedter.calendar.JDateChooser out_element;
    private app.bolivia.swing.JCTextField purchase_price;
    private javax.swing.JTable purchase_table;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton saveBtn1;
    private javax.swing.JButton saveBtn2;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton searchBtn1;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton updateBtn1;
    // End of variables declaration//GEN-END:variables
}
