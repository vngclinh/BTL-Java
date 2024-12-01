package GUI.Admin.SubPanel;

import Model.Score;
import Model.Student;
import Model.Class;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class qldiem extends javax.swing.JPanel {

    public qldiem() {
        initComponents();
    }

    public void setData() {
        table.clearRows();
        for (Student x : Student.getAllStudents().values()) {
            if (!x.getClassAttended().isEmpty()) {
                for (Map.Entry<String, Score> entry : x.getClassAttended().entrySet()) {
                    String classID = entry.getKey();
                    Score y = entry.getValue();
                    if (!y.getResult().equals("Not Graded")) {
                        table.addRow(new Object[]{
                            x.getName(),
                            classID,
                            y.getAttendance(),
                            y.getHomework(),
                            y.getMidTerm(),
                            y.getEndTerm(),
                            y.calFinalScore(),
                            y.getResult()
                        });
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtClassID = new javax.swing.JTextField();
        txtHSid = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        panelBorder1 = new GUI.Admin.PanelBorder();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new GUI.Admin.SubPanel.Table();
        jLabel4 = new javax.swing.JLabel();
        txtCC = new javax.swing.JTextField();
        txtBTVN = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtGK = new javax.swing.JTextField();
        txtCK = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("   ID lớp học     :");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("   ID học viên   :");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("   Điểm chuyên cần   :");

        txtClassID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtClassID.setForeground(new java.awt.Color(51, 51, 51));
        txtClassID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClassIDActionPerformed(evt);
            }
        });

        txtHSid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtHSid.setForeground(new java.awt.Color(51, 51, 51));
        txtHSid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHSidActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(240, 204, 60));
        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Vào điểm");
        jButton2.setPreferredSize(new java.awt.Dimension(160, 28));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBorder(null);
        jScrollPane2.setOpaque(false);

        table.setForeground(new java.awt.Color(51, 51, 51));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên HV", "ID lớp", "CC", "BTVN", "GK", "CK", "ĐTB", "Kết quả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setColumnSelectionAllowed(true);
        table.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("   Điểm BTVN            :");
        jLabel4.setPreferredSize(new java.awt.Dimension(96, 28));

        txtCC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCC.setForeground(new java.awt.Color(51, 51, 51));
        txtCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCActionPerformed(evt);
            }
        });

        txtBTVN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBTVN.setForeground(new java.awt.Color(51, 51, 51));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("   Điểm giữa khóa     :");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("   Điểm cuối khóa     :");

        txtGK.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtGK.setForeground(new java.awt.Color(51, 51, 51));
        txtGK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGKActionPerformed(evt);
            }
        });

        txtCK.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCK.setForeground(new java.awt.Color(51, 51, 51));

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
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHSid, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(txtClassID))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBTVN, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(txtGK)
                            .addComponent(txtCK)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(39, 39, 39)
                        .addComponent(txtCC, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBTVN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClassID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHSid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (txtClassID.getText().equals("") || txtHSid.getText().equals("") || txtCC.getText().equals("") || txtBTVN.getText().equals("")
                || txtGK.getText().equals("") || txtCK.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ!");
        }
        String classID = txtClassID.getText().trim().toUpperCase();
        String hsID = txtHSid.getText().trim().toUpperCase();
        double CC = Double.parseDouble(txtCC.getText().trim());
        double BTVN = Double.parseDouble(txtBTVN.getText().trim());
        double GK = Double.parseDouble(txtGK.getText().trim());
        double CK = Double.parseDouble(txtCK.getText().trim());
        if (!Class.getAllClasses().containsKey(classID)) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID lớp học không tồn tại!");
            return;
        } else if (!Student.getAllStudents().containsKey(hsID)) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID học sinh không tồn tại!");
            return;
        } else {
            Class cls = Class.getAllClasses().get(classID);
            if (!cls.getStudentList().contains(Student.getAllStudents().get(hsID))) {
                javax.swing.JOptionPane.showMessageDialog(this, "Học viên " + hsID + " không trong lớp " + classID);
                return;
            }
        }
        Student x = Student.getAllStudents().get(hsID);
        x.setScore(classID, CC, BTVN, GK, CK);
        setData();
        txtClassID.setText("");
        txtHSid.setText("");
        txtCC.setText("");
        txtBTVN.setText("");
        txtGK.setText("");
        txtCK.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtClassIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClassIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClassIDActionPerformed

    private void txtHSidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHSidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHSidActionPerformed

    private void txtCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCActionPerformed

    private void txtGKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGKActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String filePath = "src/GUI/DataBase/ScoreInput.in";
        int ok = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String classID, hvID;
            double CC, BTVN, GK, CK;
            while ((classID = reader.readLine()) != null) {
                ok = 1;
                classID = classID.trim().toUpperCase();
                hvID = reader.readLine().trim().toUpperCase();
                String cc = reader.readLine().trim();
                String btvn = reader.readLine().trim();
                String gk = reader.readLine().trim();
                String ck = reader.readLine().trim();
                if (cc != null && gk != null && ck != null) {
                    CC = Double.parseDouble(cc);
                    BTVN = Double.parseDouble(btvn);
                    GK = Double.parseDouble(gk);
                    CK = Double.parseDouble(ck);
                    Score scr = new Score(CC, BTVN, GK, CK);
                    if (!Class.getAllClasses().containsKey(classID)) {
                        javax.swing.JOptionPane.showMessageDialog(this, "ID lớp học không tồn tại! " + classID);
                        return;
                    } else if (!Student.getAllStudents().containsKey(hvID)) {
                        javax.swing.JOptionPane.showMessageDialog(this, "ID học sinh không tồn tại! " + hvID);
                        return;
                    } else {
                        Class cls = Class.getAllClasses().get(classID);
                        if (!cls.getStudentList().contains(Student.getAllStudents().get(hvID))) {
                            javax.swing.JOptionPane.showMessageDialog(this, "Học viên " + hvID + " không trong lớp " + classID);
                            return;
                        }
                    }
                    Student x = Student.getAllStudents().get(hvID);
                    x.setScore(classID, CC, CK, BTVN, BTVN);
                    setData();
                }
            }
            if (ok == 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Chưa có dữ liệu!");
            }
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String filePath = "src/GUI/Database/ScoreOutput.in";

        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter(filePath))) {
            for (Student x : Student.getAllStudents().values()) {
                writer2.write(x.printStudentResult());
            }
            javax.swing.JOptionPane.showMessageDialog(this, "Ghi file thành công!");
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private GUI.Admin.PanelBorder panelBorder1;
    private GUI.Admin.SubPanel.Table table;
    private javax.swing.JTextField txtBTVN;
    private javax.swing.JTextField txtCC;
    private javax.swing.JTextField txtCK;
    private javax.swing.JTextField txtClassID;
    private javax.swing.JTextField txtGK;
    private javax.swing.JTextField txtHSid;
    // End of variables declaration//GEN-END:variables
}
