import javax.swing.*;
import java.awt.*;

public class Sign_in {
    String title = "로그인";
    JPanel infoPanel;
        JLabel infoLabel;
        String login = "로그인";

    public Sign_in() {
        JFrame mainFrame = new JFrame(title);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1182,1024);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);

//        info
        infoPanel = new JPanel();
        infoLabel = new JLabel(login);

        infoPanel.add(infoLabel);

        mainFrame.setVisible(true);
    }

//    실행
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Sign_in();
            }
        });
    }
}
