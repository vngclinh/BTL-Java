package GUI.Admin;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class ListMenu<E> extends JList<E> {

    private final DefaultListModel<E> model;
    private int selectedIndex = -1;
    private int hoverIndex = -1;

    public ListMenu() {
        model = new DefaultListModel<>();
        setModel(model);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    if (index >= 0 && index < model.getSize()) {
                        Object o = model.getElementAt(index);
                        if (o instanceof Model_Menu && ((Model_Menu) o).getType() != Model_Menu.MenuType.EMPTY) {
                            selectedIndex = index;
                        }
                        repaint();
                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverIndex = -1;
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent me) {
                int index = locationToIndex(me.getPoint());
                if (index != hoverIndex && index >= 0 && index < model.getSize()) {
                    Object o = model.getElementAt(index);
                    if (o instanceof Model_Menu && ((Model_Menu) o).getType() != Model_Menu.MenuType.EMPTY) {
                        hoverIndex = index;
                        repaint();
                    }
                }
            }
        });
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Model_Menu data;
                if (value instanceof Model_Menu) {
                    data = (Model_Menu) value;
                } else {
                    data = new Model_Menu("", value + "", Model_Menu.MenuType.EMPTY);
                }
                MenuItem item = new MenuItem(data);
                item.setSelected(selectedIndex == index);
                item.setHover(hoverIndex == index);
                return item;
            }
        };
    }

    public void addItem(Model_Menu data) {
        model.addElement((E) data);
    }
}