package GUI.Admin.SubPanel;

import Model.Teacher;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class qlgv extends javax.swing.JPanel {

    public qlgv() {
        initComponents();
        setData();
    }

    public void setData() {
        table.clearRows();
        for (Teacher tcr : Teacher.getAllTeachers().values()) {
            String classIds = tcr.getTeachingCourses().isEmpty() ? "Hien khong co lop"
                    : tcr.getTeachingCourses().toString().replaceAll("[\\[\\]]", "");
            table.addRow(new Object[]{
                tcr.getId(),
                tcr.getName(),
                tcr.getDob(),
                tcr.getPhoneNum(),
                classIds
            });

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtDob = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        panelBorder1 = new GUI.Admin.PanelBorder();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new GUI.Admin.SubPanel.Table();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("   Tên giáo viên    :");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("   Ngày sinh         :");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("   Số điện thoại    :");

        txtName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(51, 51, 51));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtDob.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDob.setForeground(new java.awt.Color(51, 51, 51));

        txtSdt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSdt.setForeground(new java.awt.Color(51, 51, 51));

        jButton2.setBackground(new java.awt.Color(240, 204, 60));
        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Thêm giáo viên");
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
                "ID", "Họ và tên", "Ngày sinh", "Số điện thoại", "Các lớp đang dạy"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setColumnSelectionAllowed(true);
        table.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(175, 175, 175)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtDob)
                    .addComponent(txtSdt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (txtName.getText().equals("") || txtDob.getText().equals("") || txtSdt.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ!");
            return;
        }
        String tcrName = txtName.getText().trim().toUpperCase();
        String tcrDob = txtDob.getText().trim();
        String tcrSdt = txtSdt.getText().trim();
        for (Teacher x : Teacher.getAllTeachers().values()) {
            if (x.getPhoneNum().equals(tcrSdt)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Giáo viên đã có trong hệ thống!");
                return;
            }
        }
        Teacher tcr = new Teacher(tcrName, tcrDob, tcrSdt);
        setData();
        txtName.setText("");
        txtDob.setText("");
        txtSdt.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String filePath = "src/GUI/Database/TeacherInput.in";
        int ok = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String name, birthDate, phoneNumber;
            while ((name = reader.readLine()) != null) {
                ok = 1;
                name = name.trim();
                birthDate = reader.readLine().trim();
                phoneNumber = reader.readLine().trim();

                if (birthDate != null && phoneNumber != null) {
                    for (Teacher x : Teacher.getAllTeachers().values()) {
                        if (x.getPhoneNum().equals(phoneNumber)) {
                            javax.swing.JOptionPane.showMessageDialog(this, "Giáo viên đã có trong hệ thống!");
                            return;
                        }
                    }
                    Teacher x = new Teacher(name, birthDate, phoneNumber);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ!");
                    break;
                }
            }
            if (ok == 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Chưa có dữ liệu!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        setData();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String filePath1 = "src/GUI/Database/TeacherInput.in";
        String filePath2 = "src/GUI/Database/TeacherOutput.in";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath1))) {
            for (Teacher teacher : Teacher.getAllTeachers().values()) {
                writer.write(teacher.save());
                writer.newLine(); // Xuống dòng sau mỗi giáo viên
            }
        } catch (IOException e) {
        }

        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter(filePath2))) {
            for (Teacher teacher : Teacher.getAllTeachers().values()) {
                writer2.write(teacher.toString());
                writer2.newLine(); // Xuống dòng sau mỗi giáo viên
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
    private javax.swing.JScrollPane jScrollPane2;
    private GUI.Admin.PanelBorder panelBorder1;
    private GUI.Admin.SubPanel.Table table;
    private javax.swing.JTextField txtDob;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSdt;
    // End of variables declaration//GEN-END:variables
}
