import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Sign_in extends Component {
    JFrame mainFrame;
    JPanel infoPanel;
        JLabel infoLabel;
        String login = "로그인";
        String signup = "회원가입";

    JPanel signInPanel;
        JPanel idPanel;
            JLabel idTitleLabel;
                String id = "아이디";
            JPanel idTAPanel;
                JTextField idTextArea;

        JPanel pwPanel;
            JLabel pwTitleLabel;
                String pw = "비밀번호";

            JPanel pwTAPanel;
                JTextField pwTextArea;

    JPanel bottomPanel;
        RoundedButton signInBtn;
        RoundedButton signUpBtn;


    Config con = new Config();
    String title = con.getTitle();
    Font fontBlack = con.getFontBlack();
    Font fontBold = con.getFontBold();
    Font fontMedium = con.getFontMedium();
    Font fontRegular = con.getFontRegular();

    Color mainColor = con.getMainColor();



    public Sign_in() throws IOException, FontFormatException {
        mainFrame = new JFrame(title);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(716,620);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setLayout(new BorderLayout());

        // font
        fontBlack = fontBlack.deriveFont(40f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fontBlack);

        fontBold = fontBold.deriveFont(20f);
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fontBold);

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
                new EmptyBorder(50,105,0,105),
                signInPanel.getBorder()
        ));
        signInPanel.setSize(500,300);

        // id
        idPanel = new JPanel();
        idPanel.setLayout(new BorderLayout());
        idPanel.setSize(83,55);
        idTitleLabel = new JLabel(id);
        idTitleLabel.setFont(fontMedium);

        idTAPanel = new JPanel();
        idTAPanel.setLayout(new BorderLayout());
        RoundedPanelBorder roundedPanelBorder = new RoundedPanelBorder(50,3);
        idTAPanel.setBorder(roundedPanelBorder);
        Border originalBorder = idTAPanel.getBorder();
        Border paddingBorder = new EmptyBorder(1, 15, 1, 15);
        idTAPanel.setBorder(BorderFactory.createCompoundBorder(originalBorder, paddingBorder));
        idTextArea = new JTextField(16);
        idTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        idTextArea.setFont(fontRegular);
        idTextArea.setOpaque(false);
        idTextArea.setBackground(new Color(0, 0, 0, 0));


        // pw
        pwPanel = new JPanel();
        pwPanel.setLayout(new BorderLayout());
        pwPanel.setSize(83,55);
        pwTitleLabel = new JLabel(pw);
        pwTitleLabel.setFont(fontMedium);

        pwTAPanel = new JPanel();
        pwTAPanel.setLayout(new BorderLayout());
        pwTAPanel.setBorder(roundedPanelBorder);
        Border original2Border = pwTAPanel.getBorder();
        pwTAPanel.setBorder(BorderFactory.createCompoundBorder(original2Border, paddingBorder));
        pwTextArea = new JTextField(16);
        pwTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        pwTextArea.setFont(fontRegular);
        pwTextArea.setOpaque(false);
        pwTextArea.setBackground(new Color(0, 0, 0, 0));



        // bottom
        bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(100,173,80,173),
                bottomPanel.getBorder()
        ));
        bottomPanel.setLayout(new BorderLayout());

        signInBtn = new RoundedButton(login);
        signInBtn.setPreferredSize(new Dimension(150, 65)); // 버튼의 크기를 지정합니다.
        signInBtn.setFont(fontBold);

        signInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });


        signUpBtn = new RoundedButton(signup);
        signUpBtn.setPreferredSize(new Dimension(150, 65));
        signUpBtn.setFont(fontBold);

        signUpBtn.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            try {
                new SignUp();
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            } catch (FontFormatException e1) {
                throw new RuntimeException(e1);
            }
            mainFrame.setVisible(false);
        }));


        // setBackground
        infoPanel.setBackground(Color.WHITE);
        idPanel.setBackground(Color.WHITE);
        idTAPanel.setBackground(Color.WHITE);
        pwPanel.setBackground(Color.WHITE);
        pwTAPanel.setBackground(Color.WHITE);
        signInPanel.setBackground(Color.WHITE);
        bottomPanel.setBackground(Color.WHITE);


        // add
        infoPanel.add(infoLabel);
        idTAPanel.add(idTextArea, BorderLayout.CENTER);
        idPanel.add(idTitleLabel, BorderLayout.WEST);
        idPanel.add(idTAPanel, BorderLayout.EAST);
        pwTAPanel.add(pwTextArea, BorderLayout.CENTER);
        pwPanel.add(pwTitleLabel, BorderLayout.WEST);
        pwPanel.add(pwTAPanel, BorderLayout.EAST);
        signInPanel.add(idPanel, BorderLayout.NORTH);
        signInPanel.add(pwPanel, BorderLayout.SOUTH);
        bottomPanel.add(signInBtn, BorderLayout.WEST);
        bottomPanel.add(signUpBtn, BorderLayout.EAST);
        mainFrame.add(infoPanel, BorderLayout.NORTH);
        mainFrame.add(signInPanel, BorderLayout.CENTER);
        mainFrame.add(bottomPanel, BorderLayout.SOUTH);

        idPanel.setPreferredSize(new Dimension(83, 43));
        idTAPanel.setPreferredSize(new Dimension(332, 55));

        mainFrame.setVisible(true);
    }
    private void performLogin() {
        String id = idTextArea.getText();
        String password = pwTextArea.getText();

        Map<String, String> users = FileManager.readUserIdPw();

        Map<String, String> userFile = FileManager.readUsersFromFile();

        if (users.get("id").equals(id) && users.get("password").equals(password)) {
            JOptionPane.showMessageDialog(mainFrame, "로그인 성공!");
            try {
                new MyPage(userFile);
                mainFrame.setVisible(false);
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            } catch (FontFormatException e1) {
                throw new RuntimeException(e1);
            }
        } else {
            JOptionPane.showMessageDialog(mainFrame, "로그인 실패. 올바른 아이디와 비밀번호를 입력하세요.");
        }

    }

    // 둥근 모서리
    public class RoundedPanelBorder implements Border {
        private final int arc;
        private final int thickness;

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
    public class RoundedButton extends JButton {
        public RoundedButton(String text) { super(text); decorate(); }
        protected void decorate() { setBorderPainted(false); setOpaque(false); }
        @Override
        protected void paintComponent(Graphics g) {
            Color c= mainColor; //배경색 결정
            Color o= Color.GRAY; //글자색 결정
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (getModel().isArmed()) { graphics.setColor(c.darker()); }
            else if (getModel().isRollover()) { graphics.setColor(c.brighter()); }
            else { graphics.setColor(c); }
            graphics.fillRoundRect(0, 0, width, height, 50, 50);
            FontMetrics fontMetrics = graphics.getFontMetrics();
            Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
            int textX = (width - stringBounds.width) / 2;
            int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
            graphics.setColor(o);
            graphics.setFont(getFont());
            graphics.drawString(getText(), textX, textY);
            graphics.dispose();
            super.paintComponent(g);
        }
    }

//    실행
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                new Sign_in();
            } catch (IOException | FontFormatException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
