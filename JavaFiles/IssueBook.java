/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrame;

import java.sql.*;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author leahbarnes
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
    public void getBookDetails(){
        int bookID = Integer.parseInt(txt_bookID.getText());
        
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id=?");
            pst.setInt(1,bookID);
            ResultSet rs= pst.executeQuery();
           
           if(rs.next()){
               lbl_bookID.setText(rs.getString("book_id"));
               lbl_bookName.setText(rs.getString("book_name"));
               lbl_author.setText(rs.getString("author"));
               lbl_quantity.setText(rs.getString("quantity"));
          
           }
           else{
               lbl_bookError.setText("Invalid Book ID");
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getStudentDetails(){
        int studentID = Integer.parseInt(txt_studentID.getText());
        
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id=?");
            pst.setInt(1,studentID);
            ResultSet rs= pst.executeQuery();
           
           if(rs.next()){
               lbl_studentID.setText(rs.getString("student_id"));
               lbl_studentName.setText(rs.getString("name"));
               lbl_course.setText(rs.getString("course"));
               lbl_major.setText(rs.getString("major"));
          
           }
           else{
               lbl_studentError.setText("Invalid Student ID");
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public boolean issueBook(){
        boolean isIssued=false;
        int bookID=Integer.parseInt(txt_bookID.getText());
        int studentID=Integer.parseInt(txt_studentID.getText());
        String bookName=lbl_bookName.getText();
        String studentName=lbl_studentName.getText();
        java.util.Date issue_date=  date_IssueDate.getDatoFecha();
        java.util.Date due_date= date_DueDate.getDatoFecha();
        
        Long l1=issue_date.getTime();
        Long l2=due_date.getTime();
        
        issue_date = new java.sql.Date(l1);
        due_date = new java.sql.Date(l2);
        
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)");
            pst.setInt(1,bookID);
            pst.setString(2,bookName);
            pst.setInt(3,studentID);
            pst.setString(4,studentName);
            pst.setDate(5, (Date) issue_date);
            pst.setDate(6, (Date) due_date);
            pst.setString(7,"pending");
            
           int rowCount = pst.executeUpdate();
           if(rowCount >0){
               isIssued=true;
           }
           else{
               isIssued=false;
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isIssued;
    }
    
    public void updateBookCount(){
        int bookID=Integer.parseInt(txt_bookID.getText());
        try{
            Connection con = DBConnection.getConnection();
            String sql="update book_details set quantity = quantity-1 where book_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,bookID);
            
            int rowCount=pst.executeUpdate();
            if(rowCount >0){
               JOptionPane.showMessageDialog(this,"Book Count Updated!");
               int initialCount = Integer.parseInt(lbl_quantity.getText());
               lbl_quantity.setText(Integer.toString(initialCount-1));
           }
           else{
               JOptionPane.showMessageDialog(this,"Unable To Update Book Count!");
           }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    
    public boolean isAlreadyIssued(){
        boolean isAlreadyIssued=false;
        int bookID=Integer.parseInt(txt_bookID.getText());
        int studentID=Integer.parseInt(txt_studentID.getText());
        
        
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from issue_book_details where book_id =? and student_id=? and status=?");
            pst.setInt(1,bookID);
            pst.setInt(2,studentID);
            pst.setString(3,"pending");
            
           ResultSet rs = pst.executeQuery();
           if(rs.next()){
               isAlreadyIssued=true;
           }
           else{
               isAlreadyIssued=false;
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isAlreadyIssued;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_major = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_studentID = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lbl_studentError = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_bookID = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_studentID = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_bookID = new app.bolivia.swing.JCTextField();
        date_IssueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        date_DueDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 0, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Charter", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel2.setText("  Student Details");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Major: ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 120, 40));

        lbl_major.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        lbl_major.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_major, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 590, 200, 40));

        jLabel5.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student Name: ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 170, 40));

        jLabel6.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Course: ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 100, 40));

        jLabel7.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Student ID: ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 150, 40));

        lbl_studentID.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        lbl_studentID.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_studentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 200, 40));

        lbl_studentName.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 200, 40));

        lbl_course.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, 200, 40));

        jPanel8.setBackground(new java.awt.Color(255, 102, 0));
        jPanel8.setForeground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 450, 5));

        lbl_studentError.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 204, 51));
        jPanel3.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 780, 300, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 550, 1000));

        jPanel5.setBackground(new java.awt.Color(51, 0, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 102, 0));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Charter", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/art from web/backArrow.png"))); // NOI18N
        jLabel11.setText("Back");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 50));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 50));

        jLabel12.setFont(new java.awt.Font("Charter", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel12.setText("  Book Details");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 102, 0));
        jPanel7.setForeground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 450, 5));

        jLabel13.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Quantity: ");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 120, 40));

        lbl_bookError.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 204, 51));
        jPanel5.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 780, 330, 60));

        jLabel15.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Book Name: ");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 150, 40));

        jLabel16.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Author: ");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 100, 40));

        jLabel17.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Book ID: ");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 110, 40));

        lbl_bookID.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        lbl_bookID.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_bookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 200, 40));

        lbl_bookName.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 200, 40));

        lbl_author.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 200, 40));

        lbl_quantity.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 590, 200, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 1000));

        jLabel1.setFont(new java.awt.Font("Charter", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel1.setText(" Issue Book");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 110, 320, 110));

        jPanel4.setBackground(new java.awt.Color(255, 102, 0));
        jPanel4.setForeground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 250, -1, 5));

        jLabel4.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText("Issue Date: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 570, -1, -1));

        txt_studentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 0)));
        txt_studentID.setForeground(new java.awt.Color(51, 0, 102));
        txt_studentID.setFont(new java.awt.Font("Charter", 0, 17)); // NOI18N
        txt_studentID.setPhColor(new java.awt.Color(51, 0, 102));
        txt_studentID.setPlaceholder("Enter StudentID\n");
        txt_studentID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIDFocusLost(evt);
            }
        });
        jPanel1.add(txt_studentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 400, 310, 40));

        jLabel8.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 0));
        jLabel8.setText("Book ID:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 310, -1, -1));

        txt_bookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 0)));
        txt_bookID.setForeground(new java.awt.Color(51, 0, 102));
        txt_bookID.setFont(new java.awt.Font("Charter", 0, 17)); // NOI18N
        txt_bookID.setPhColor(new java.awt.Color(51, 0, 102));
        txt_bookID.setPlaceholder("Enter BookID ");
        txt_bookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIDFocusLost(evt);
            }
        });
        jPanel1.add(txt_bookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 300, 310, 40));

        date_IssueDate.setColorBackground(new java.awt.Color(102, 0, 153));
        date_IssueDate.setColorForeground(new java.awt.Color(255, 51, 0));
        date_IssueDate.setFont(new java.awt.Font("Charter", 0, 17)); // NOI18N
        date_IssueDate.setFuente(new java.awt.Font("Charter", 1, 15)); // NOI18N
        date_IssueDate.setPlaceholder("Select Issue Date");
        jPanel1.add(date_IssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 560, 280, -1));

        jLabel9.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 0));
        jLabel9.setText("Student ID:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 410, -1, -1));

        jLabel10.setFont(new java.awt.Font("Charter", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 0));
        jLabel10.setText("Due Date: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 660, -1, -1));

        date_DueDate.setColorBackground(new java.awt.Color(102, 0, 153));
        date_DueDate.setColorForeground(new java.awt.Color(255, 51, 0));
        date_DueDate.setFont(new java.awt.Font("Charter", 0, 17)); // NOI18N
        date_DueDate.setFuente(new java.awt.Font("Charter", 1, 15)); // NOI18N
        date_DueDate.setPlaceholder("Select Due Date");
        jPanel1.add(date_DueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 650, 280, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(51, 0, 102));
        rSMaterialButtonCircle2.setText("Issue Book ");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 780, 320, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1700, 1000));

        setSize(new java.awt.Dimension(1700, 1028));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void txt_studentIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIDFocusLost
        // TODO add your handling code here:
        if(!txt_studentID.getText().equals("")){
            getStudentDetails();
        }
    }//GEN-LAST:event_txt_studentIDFocusLost

    private void txt_bookIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIDFocusLost
        // TODO add your handling code here:
        if(!txt_bookID.getText().equals("")){
            getBookDetails();
        }
        
    }//GEN-LAST:event_txt_bookIDFocusLost

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
        if(lbl_quantity.getText().equals("0")){
            JOptionPane.showMessageDialog(this,"Book is not available.");
        }
        else{
            if(isAlreadyIssued() ==false){
            
            if(issueBook()==true){
            JOptionPane.showMessageDialog(this,"Book issue succesful!");
            updateBookCount();
            }
            else{
            JOptionPane.showMessageDialog(this,"Book issue NOT succesful!");
        }
        }
        else{
            JOptionPane.showMessageDialog(this,"Student already has book!");
        }
            
        }
    
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_DueDate;
    private rojeru_san.componentes.RSDateChooser date_IssueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookID;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_major;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentID;
    private javax.swing.JLabel lbl_studentName;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_bookID;
    private app.bolivia.swing.JCTextField txt_studentID;
    // End of variables declaration//GEN-END:variables
}
