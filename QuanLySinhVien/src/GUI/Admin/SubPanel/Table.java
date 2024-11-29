package GUI.Admin.SubPanel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {

    public Table() {
        setShowHorizontalLines(true);
        setShowVerticalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                header.setHorizontalAlignment(JLabel.CENTER);
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                com.setBackground(Color.WHITE);
                setBorder(getBorder()); // Khôi phục viền mặc định
                //setBorder(noFocusBorder);
                if (selected) {
                    com.setForeground(new Color(15, 89, 140));
                } else {
                    com.setForeground(new Color(102, 102, 102));
                }
                return com;
            }
        });
        //cài đặt độ rộng cho cột
        SwingUtilities.invokeLater(() -> adjustColumnWidths());
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
    // Phương thức điều chỉnh độ rộng cột

    public void adjustColumnWidths() {
        int totalWidth = getWidth();
        if (getColumnModel().getColumnCount() > 0) {
            getColumnModel().getColumn(0).setPreferredWidth(30);  // ID
            getColumnModel().getColumn(1).setPreferredWidth(50); // Tên
            getColumnModel().getColumn(2).setPreferredWidth(50); // Ngày sinh
            getColumnModel().getColumn(3).setPreferredWidth(50); // SĐT
            getColumnModel().getColumn(4).setPreferredWidth(totalWidth - 180); // Lớp đang dạy (cột cuối)
        }
    }
}
