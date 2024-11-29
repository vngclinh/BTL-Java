package GUI;

import GUI.Controller.Login;
import java.text.ParseException;

public class Gui {
    private GUI.Admin.AdminFrame adminframe;
    private GUI.Login.Login loginframe;
    private GUI.SampleDatabase SampleData;

    public Gui() throws ParseException {
        this.adminframe = new GUI.Admin.AdminFrame();
        this.loginframe = new GUI.Login.Login();
        Login login = new GUI.Controller.Login(adminframe, loginframe);
    }
    public static void main(String[] args) throws ParseException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.err.println("Không thể thiết lập giao diện Nimbus");
        }
        Gui app = new Gui();
        java.awt.EventQueue.invokeLater(() -> {
            app.loginframe.setVisible(true);
        });
    }
    
}
