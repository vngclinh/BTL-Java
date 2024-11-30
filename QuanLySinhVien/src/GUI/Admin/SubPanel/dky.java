package GUI.Admin.SubPanel;

import Model.Class;
import Model.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class dky extends javax.swing.JPanel {

    public dky() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHVid = new javax.swing.JTextField();
        txtClassID = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        panelBorder1 = new GUI.Admin.PanelBorder();
        lblMessage = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("   ID học viên    :");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("   ID lớp học      :");

        txtHVid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtHVid.setForeground(new java.awt.Color(51, 51, 51));
        txtHVid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHVidActionPerformed(evt);
            }
        });

        txtClassID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtClassID.setForeground(new java.awt.Color(51, 51, 51));

        jButton2.setBackground(new java.awt.Color(240, 204, 60));
        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Thêm vào lớp");
        jButton2.setPreferredSize(new java.awt.Dimension(160, 28));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        lblMessage.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jButton3.setBackground(new java.awt.Color(240, 204, 60));
        jButton3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Tải file lên");
        jButton3.setPreferredSize(new java.awt.Dimension(160, 28));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(240, 204, 60));
        jButton4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("Lưu vào file");
        jButton4.setPreferredSize(new java.awt.Dimension(160, 28));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClassID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHVid, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(116, 116, 116))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHVid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClassID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        lblMessage.setText("");
        if (txtHVid.getText().equals("") || txtClassID.getText().equals("")) {
            lblMessage.setText("Thông tin không hợp lệ!");
            return;
        }
        String hvID = txtHVid.getText().trim().toUpperCase();
        String classID = txtClassID.getText().trim().toUpperCase();
        if (!Student.getAllStudents().containsKey(hvID)) {
            lblMessage.setText("ID học viên " + hvID + " không tồn tại!");
            return;
        }
        if (!Class.getAllClasses().containsKey(classID)) {
            lblMessage.setText("ID lớp học " + classID + " không tồn tại!");
            return;
        }
        Class c = Class.getAllClasses().get(classID);
        Student s = Student.getAllStudents().get(hvID);
        if (s.getClassAttended().containsKey(classID)) {
            lblMessage.setText("Học viên " + hvID + " đã trong khóa học " + classID + " !");
            txtHVid.setText("");
            txtClassID.setText("");
            return;
        }
        c.addStudent(s);
        s.addAttendedClass(c);

        lblMessage.setText("Thêm học viên vào lớp thành công!");
        txtHVid.setText("");
        txtClassID.setText("");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtHVidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHVidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHVidActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        lblMessage.setText("");
        String filePath = "src/GUI/Database/Register.in";
        int ok=0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String hvID, classID;
            while ((hvID = reader.readLine()) != null) {
                ok=1;
                classID = reader.readLine();
                if (classID != null) {
                    hvID = hvID.toUpperCase();
                    classID = classID.toUpperCase();
                    if (!Student.getAllStudents().containsKey(hvID)) {
                        lblMessage.setText("ID học viên không tồn tại!");
                        return;
                    }
                    if (!Class.getAllClasses().containsKey(classID)) {
                        lblMessage.setText("ID lớp học không tồn tại!");
                        return;
                    }
                    Class c = Class.getAllClasses().get(classID);
                    Student s = Student.getAllStudents().get(hvID);
                    if (s.getClassAttended().containsKey(classID)) {
                        lblMessage.setText("Học viên đã trong khóa học!");
                        txtHVid.setText("");
                        txtClassID.setText("");
                        return;
                    }
                    c.addStudent(s);
                    s.addAttendedClass(c);

                    lblMessage.setText("Thêm học viên vào lớp thành công!");
                }
            }
            if(ok==0) lblMessage.setText("Chưa có dữ liệu!");
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        lblMessage.setText("");
        String filePath = "src/GUI/Database/Register.in";
        int ok=0;
        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter(filePath))) {
            for (Student x : Student.getAllStudents().values()) {
                if (!x.getClassAttended().isEmpty()) {
                    for (String classID : x.getClassAttended().keySet()) {
                        writer2.write(x.getId());
                        writer2.newLine();
                        writer2.write(classID);
                        writer2.newLine(); // Xuống dòng 
                        ok=1;
                    }
                }
            }
            if(ok==1) lblMessage.setText("Dữ liệu đã được ghi lại!");
            else lblMessage.setText("Chưa có dữ liệu!");
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Đã có lỗi xảy ra!");
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblMessage;
    private GUI.Admin.PanelBorder panelBorder1;
    private javax.swing.JTextField txtClassID;
    private javax.swing.JTextField txtHVid;
    // End of variables declaration//GEN-END:variables
}
