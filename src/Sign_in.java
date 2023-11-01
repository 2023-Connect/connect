import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicTextAreaUI;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

public class Sign_in {
    String title = "Connect";
    JPanel infoPanel;
        JLabel infoLabel;
        String login = "로그인";

    JPanel signInPanel;
        JPanel idPanel;
            JLabel idTitlLabel;
                String id = "아이디";
            JPanel idTAPanel;
                JTextField idTextArea;

        JPanel pwPanel;
            JPanel pwTitlePanel;
                String pw = "비밀번호";

            JPanel pwTAPanel;
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

    // color
    Color mainColor = Color.decode("#FFF17E");

    public Sign_in() throws IOException, FontFormatException {
        JFrame mainFrame = new JFrame(title);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(716,620);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setLayout(new BorderLayout());

        // font
        fontBlack = fontBlack.deriveFont(40f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fontBlack);

        fontMedium = fontMedium.deriveFont(30f);
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fontMedium);

        fontRegular = fontRegular.deriveFont(20f);
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fontRegular);


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


        // signIn
        signInPanel = new JPanel();
        signInPanel.setLayout(new BorderLayout());
        signInPanel.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(50,105,58,105),
                signInPanel.getBorder()
        ));
        signInPanel.setSize(500,155);

        idPanel = new JPanel();
        idPanel.setLayout(new BorderLayout());
        idPanel.setSize(83,43);
        idTitlLabel = new JLabel(id);
        idTitlLabel.setFont(fontMedium);

        idTAPanel = new JPanel();
        idTAPanel.setLayout(new BorderLayout());
        RoundedPanelBorder roundedPanelBorder = new RoundedPanelBorder(50,5);
        idTAPanel.setBorder(roundedPanelBorder);
        idTextArea = new JTextField(1);
        idTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        idTextArea.setFont(fontRegular);
        idTextArea.setOpaque(false);
        idTextArea.setBackground(new Color(0, 0, 0, 0));

        // setBackground
        infoPanel.setBackground(Color.WHITE);
        idPanel.setBackground(Color.WHITE);
        idTAPanel.setBackground(Color.WHITE);
        signInPanel.setBackground(Color.WHITE);

        // add
        infoPanel.add(infoLabel);
        idTAPanel.add(idTextArea, BorderLayout.CENTER);
        idPanel.add(idTitlLabel, BorderLayout.WEST);
        idPanel.add(idTAPanel, BorderLayout.EAST);
        signInPanel.add(idPanel, BorderLayout.NORTH);
        mainFrame.add(infoPanel, BorderLayout.NORTH);
        mainFrame.add(signInPanel, BorderLayout.CENTER);

        idPanel.setPreferredSize(new Dimension(83, 43));
        idTAPanel.setPreferredSize(new Dimension(332, 55));

        mainFrame.setVisible(true);
    }


    // 둥근 모서리
    public class RoundedPanelBorder implements Border {
        private int arc;
        private int thickness;

        public RoundedPanelBorder(int arc, int thickness) {
            this.arc = arc;
            this.thickness = thickness;
        }
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(mainColor); // 테두리 색 설정
            g2d.setStroke(new BasicStroke(thickness));
            g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, arc, arc));
            g2d.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(thickness, thickness, thickness, thickness);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }
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
