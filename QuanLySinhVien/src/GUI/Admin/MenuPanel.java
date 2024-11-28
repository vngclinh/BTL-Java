package GUI.Admin;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class MenuPanel extends javax.swing.JPanel {

    public MenuPanel() {
        initComponents();
        listMenu1.setOpaque(false);
        setOpaque(false);
        init();
    }

    private void init() {
        listMenu1.addItem(new Model_Menu("", "Tác vụ", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("teacher", "Quản lý giáo viên", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("student", "Quản lý học viên", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("course2", "Quản lý khóa học", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("class", "Quản lý lớp học", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("grade", "Quản lý điểm", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));

        listMenu1.addItem(new Model_Menu("", "Cài đặt", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("6 (1)", "Thay đổi mật khẩu", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listMenu1 = new GUI.Admin.ListMenu<>();

        setPreferredSize(new java.awt.Dimension(200, 500));
        setRequestFocusEnabled(false);

        listMenu1.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listMenu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(listMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.decode("#ffe996"));
//        GradientPaint g = new GradientPaint(0, 0, Color.decode("#acb6e5"), 0, getHeight(), Color.decode("#fdbb2d"));
//        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(20, getHeight() - 20, getWidth() - 20, 20); // Hình chữ nhật không bo góc bên trái
        g2.fillRect(0, 0, getWidth(), getHeight() - 20); // Phần còn lại của hình chữ nhật
        g2.fillArc(0, getHeight() - 40, 40, 40, 180, 90); // Bo góc dưới bên trái
        super.paintChildren(grphcs);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Admin.ListMenu<String> listMenu1;
    // End of variables declaration//GEN-END:variables
}
