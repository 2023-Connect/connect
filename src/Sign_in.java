import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Sign_in {
    String title = "Connect";
    JPanel infoPanel;
        JLabel infoLabel;
        String login = "로그인";

    JPanel signInPanel;
        JPanel idPanel;
            JPanel idTitlePanel;
                String id = "아이디";
            JTextArea idTextArea;

        JPanel pwPanel;
            JPanel pwTitlePanel;
                String pw = "비밀번호";
            JTextArea pwTextArea;

    // font
    Font fontBlack = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Black.ttf"));
    Font fontBold = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Bold.ttf"));
    Font fontExtraBold = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-ExtraBold.ttf"));
    Font fontExtraLight = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-ExtraLight.ttf"));
    Font fontLight = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Light.ttf"));
    Font fontMedium = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Medium.ttf"));
    Font fontRegular = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Regular.ttf"));
    Font fontSemiBold = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-SemiBold.ttf"));
    Font fontThin = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Thin.ttf"));

    public Sign_in() throws IOException, FontFormatException {
        JFrame mainFrame = new JFrame(title);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(716,620);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);

        // font
        fontBlack = fontBlack.deriveFont(40f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fontBlack);


        // info
        infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        infoPanel.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(70, 0, 0, 0),
                infoPanel.getBorder()
        ));


        infoLabel = new JLabel(login);
        infoLabel.setForeground(Color.BLACK);
        infoLabel.setFont(fontBlack);

        infoPanel.setBackground(Color.WHITE);

        infoPanel.add(infoLabel);
        mainFrame.add(infoPanel);

        mainFrame.setVisible(true);
    }

//    실행
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Sign_in();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (FontFormatException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
