package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Menu extends javax.swing.JPanel {

    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu2.setOpaque(false);
        init();

    }

    private void init() {
        listMenu2.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu2.addItem(new Model_Menu("1_1", "Quản lý giáo viên", Model_Menu.MenuType.MENU));
        listMenu2.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        //listMenu1.addItem(new Model_Menu("2", "UI Elements", Model_Menu.MenuType.MENU));
        listMenu2.addItem(new Model_Menu("3", "Quản lý sinh viên", Model_Menu.MenuType.MENU));
        listMenu2.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu2.addItem(new Model_Menu("4", "Quản lý môn học", Model_Menu.MenuType.MENU));
        listMenu2.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu2.addItem(new Model_Menu("5", "Quản lý điểm", Model_Menu.MenuType.MENU));
        //listMenu2.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));

        //listMenu2.addItem(new Model_Menu("", "My Data", Model_Menu.MenuType.TITLE));
        //listMenu2.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        //listMenu1.addItem(new Model_Menu("6", "Icons", Model_Menu.MenuType.MENU));
        //listMenu1.addItem(new Model_Menu("7", "Sample Page", Model_Menu.MenuType.MENU));
        //listMenu1.addItem(new Model_Menu("8", "Extra", Model_Menu.MenuType.MENU));
        //listMenu1.addItem(new Model_Menu("9", "More", Model_Menu.MenuType.MENU));
        //listMenu1.addItem(new Model_Menu("10", "Logout", Model_Menu.MenuType.MENU));
        //listMenu2.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        listMenu2 = new GUI.ListMenu<>();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listMenu2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 73, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 74, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 190, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 189, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.decode("#08142c"));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintChildren(grphcs); 
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private GUI.ListMenu<String> listMenu2;
    // End of variables declaration//GEN-END:variables
}
