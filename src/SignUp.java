import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SignUp extends JFrame {

    Font fontBlack = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Black.ttf"));
    Font fontBold = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Bold.ttf"));
    Font fontExtraBold = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-ExtraBold.ttf"));
    Font fontExtraLight = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-ExtraLight.ttf"));
    Font fontLight = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Light.ttf"));
    Font fontMedium = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Medium.ttf"));
    Font fontReqular = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Regular.ttf"));
    Font fontSemiBold = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-SemiBold.ttf"));
    Font fontThin = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Thin.ttf"));

    String[] national = {
            "국적을 선택해주세요.",
            "대만",
            "대한민국",
            "독일",
            "미국",
            "베트남",
            "우즈베키스탄",
            "인도네시아",
            "일본",
            "중국",
            "캐나다",
            "태국",
            "프랑스",
            "필리핀"
    };
    String[] national2 = {
            "다중국적자만 선택합니다",
            "대만",
            "대한민국",
            "독일",
            "미국",
            "베트남",
            "우즈베키스탄",
            "인도네시아",
            "일본",
            "중국",
            "캐나다",
            "태국",
            "프랑스",
            "필리핀"
    };
    String[] languageCombo = {
            "언어를 선택해주세요.",
            "한국어",
            "中國語",
            "Deutsch",
            "English",
            "Tiếng Việt",
            "o'zbek",
            "bahasa Indonesia",
            "日本語",
            "แบบไทย",
            "thaïlandais",
            "Filipino"
    };

    String[] genderCombo = {"여자", "남자","밝히고 싶지 않음"};
    ArrayList<Integer> year, month, day;


//    ArrayList<Integer> year, month, day;


    String titlename = "Connect";
    JLabel title = new JLabel("회원가입", JLabel.CENTER);
    JLabel id = new JLabel("아이디", JLabel.CENTER);
    JLabel name = new JLabel("닉네임", JLabel.CENTER);
    JLabel password = new JLabel("비밀번호", JLabel.CENTER);
    JLabel nationality1 = new JLabel("국적1", JLabel.CENTER);
    JLabel nationality2 = new JLabel("국적2", JLabel.CENTER);
    JLabel nationality3 = new JLabel("국적3", JLabel.CENTER);
    JLabel language = new JLabel("언어", JLabel.CENTER);
    JLabel birthday = new JLabel("생년월일", JLabel.CENTER);
    JLabel gender = new JLabel("성별", JLabel.CENTER);
    JButton signInButton;

    JPanel titlePanel, idPanel, namePanel, passwordPanel,
            nationalityPanel, languagePanel, birthdayPanel, genderPanel, signinButtonPanel;
    JPanel nationalityPanel1, nationalityPanel2, nationalityPanel3;


    JTextField idTextField, nameTextField, passwordTextField;
    JComboBox nationalityCombobox1, nationalityCombobox2, nationalityCombobox3;
    JComboBox languageCombobox, genderCombobox;
    JComboBox birthdayYearCombobox, birthdayMonthCombobox, birthdayDayCombobox;


    Color mainColor = Color.decode("#FFF17E");

    GridBagConstraints gbc = new GridBagConstraints();


    public SignUp() throws IOException, FontFormatException {
    }

    public void SignUp() {


        Dimension dim = new Dimension(400,400);
        JFrame mainFrame = new JFrame(titlename);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(716,650);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);

        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.WHITE);
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

        // font
        fontBlack = fontBlack.deriveFont(35f);
        GraphicsEnvironment ge1 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge1.registerFont(fontBlack);

        fontBold = fontBold.deriveFont(16f);
        GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge2.registerFont(fontBold);

        fontMedium = fontMedium.deriveFont(20f);
        GraphicsEnvironment ge3 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge3.registerFont(fontMedium);

        fontLight = fontLight.deriveFont(16f);
        GraphicsEnvironment ge4 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge4.registerFont(fontLight);

        RoundedPanelBorder roundedPanelBorder = new RoundedPanelBorder(30,2);

        year = new ArrayList<>();
        month = new ArrayList<>();
        day = new ArrayList<>();

        int j = 1900;
        for(int i = 0; i <= 123; i++){
            year.add(j++);
        }
        for(int i=0; i < 12; i++){
            month.add(i+1);
        }
        for(int i=0; i < 31; i++){
            day.add(i+1);
        }

        titlePanel = new JPanel();
        titlePanel.setBackground(Color.WHITE);
        title.setFont(fontBlack);
        titlePanel.setLayout(new BoxLayout(titlePanel,BoxLayout.X_AXIS));
        titlePanel.add(title);
        titlePanel.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(10,105,10,105),
                titlePanel.getBorder()
        ));

        idPanel = new JPanel();
        idPanel.setBackground(Color.WHITE);
        id.setFont(fontMedium);
        id.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(0,90,0,20),
                name.getBorder()
        ));
        idTextField = new JTextField(15);
        idTextField.setFont(fontLight);
        idTextField.setBorder(roundedPanelBorder);
        id.setAlignmentX(Component.RIGHT_ALIGNMENT);
        idPanel.add(id, BorderLayout.EAST);
        idPanel.add(idTextField, BorderLayout.EAST);
//        idPanel.setBorder(BorderFactory.createCompoundBorder(
//                new EmptyBorder(0,0,-20,0),
//                id.getBorder()
//        ));
        idPanel.setVisible(true);

        namePanel = new JPanel();
        namePanel.setBackground(Color.WHITE);
        name.setFont(fontMedium);
        name.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(0,90,0,20),
                name.getBorder()
        ));
        nameTextField = new JTextField(15);
        nameTextField.setBorder(roundedPanelBorder);
        nameTextField.setFont(fontLight);
        name.setAlignmentX(Component.RIGHT_ALIGNMENT);
        namePanel.add(name, BorderLayout.EAST);
        namePanel.add(nameTextField, BorderLayout.EAST);
//        namePanel.setBorder(BorderFactory.createCompoundBorder(
//                new EmptyBorder(0,0,-20,0),
//                name.getBorder()
//        ));
        namePanel.setVisible(true);

        passwordPanel = new JPanel();
        passwordPanel.setBackground(Color.WHITE);
        password.setFont(fontMedium);
        password.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(0,100,0,10),
                password.getBorder()
        ));
        passwordTextField = new JTextField(15);
        passwordTextField.setFont(fontLight);
        passwordTextField.setBorder(roundedPanelBorder);
        password.setAlignmentX(Component.RIGHT_ALIGNMENT);
        passwordPanel.add(password, BorderLayout.EAST);
        passwordPanel.add(passwordTextField, BorderLayout.EAST);
//        passwordPanel.setBorder(BorderFactory.createCompoundBorder(
//                new EmptyBorder(0,0,-20,0),
//                password.getBorder()
//        ));
        passwordPanel.setVisible(true);

        nationalityPanel1 = new JPanel();
        nationalityPanel1.setBackground(Color.WHITE);
        nationality1.setFont(fontMedium);
        nationality1.setAlignmentX(Component.RIGHT_ALIGNMENT);
        nationality1.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(0,-25,0,20),
                name.getBorder()
        ));
        nationalityCombobox1 = new JComboBox(national);
        nationalityCombobox1.setFont(fontLight);

        nationalityPanel1.add(nationality1, BorderLayout.EAST);
        nationalityPanel1.add(nationalityCombobox1, BorderLayout.EAST);

        nationalityPanel2 = new JPanel();
        nationalityPanel2.setBackground(Color.WHITE);
        nationality2.setFont(fontMedium);
        nationalityCombobox2 = new JComboBox(national2);
        nationalityCombobox2.setFont(fontLight);
        nationality2.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(0,0,0,20),
                name.getBorder()
        ));
        nationalityPanel2.add(nationality2, BorderLayout.EAST);
        nationalityPanel2.add(nationalityCombobox2, BorderLayout.EAST);

        nationalityPanel3 = new JPanel();
        nationalityPanel3.setBackground(Color.WHITE);
        nationality3.setFont(fontMedium);
        nationalityCombobox3 = new JComboBox(national2);
        nationalityCombobox3.setFont(fontLight);
        nationality3.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(0,0,0,20),
                name.getBorder()
        ));
        nationalityPanel3.add(nationality3, BorderLayout.EAST);
        nationalityPanel3.add(nationalityCombobox3, BorderLayout.EAST);

        languagePanel = new JPanel();
        languagePanel.setBackground(Color.WHITE);
        language.setFont(fontMedium);
        languageCombobox = new JComboBox(languageCombo);
        languageCombobox.setFont(fontLight);
        language.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(0,-20,0,30),
                name.getBorder()
        ));
        languagePanel.add(language, BorderLayout.EAST);
        languagePanel.add(languageCombobox, BorderLayout.EAST);


        birthdayPanel = new JPanel();
        birthdayPanel.setBackground(Color.WHITE);
        birthday.setFont(fontMedium);
        birthdayYearCombobox = new JComboBox<Integer>(year.toArray(new Integer[year.size()]));
        birthdayYearCombobox.setFont(fontLight);
        birthdayMonthCombobox = new JComboBox<Integer>(month.toArray(new Integer[month.size()]));
        birthdayMonthCombobox.setFont(fontLight);
        birthdayDayCombobox = new JComboBox<Integer>(day.toArray(new Integer[day.size()]));
        birthdayDayCombobox.setFont(fontLight);
        birthday.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(0,-25,0,0),
                name.getBorder()
        ));
        birthdayPanel.add(birthday, BorderLayout.EAST);
        birthdayPanel.add(birthdayYearCombobox, BorderLayout.EAST);
        birthdayPanel.add(birthdayMonthCombobox);
        birthdayPanel.add(birthdayDayCombobox);

        genderPanel = new JPanel();
        genderPanel.setBackground(Color.WHITE);
        gender.setFont(fontMedium);
        gender.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(0,40,0,50),
                gender.getBorder()
        ));
        genderCombobox = new JComboBox(genderCombo);
        genderCombobox.setFont(fontLight);
        genderPanel.add(gender, BorderLayout.EAST);
        genderPanel.add(genderCombobox, BorderLayout.EAST);

        signinButtonPanel = new JPanel();
        signinButtonPanel.setBackground(Color.WHITE);
        signInButton = new RoundedButton("회원가입");
        signInButton.setFont(fontBold);
        signinButtonPanel.add(signInButton, BorderLayout.EAST);


//        nationalityPanel.add(nationalityPanel1);
//        nationalityPanel.add(nationalityPanel2);
//        nationalityPanel.add(nationalityPanel3);


        jPanel.add(titlePanel);
        jPanel.add(idPanel);
        jPanel.add(namePanel);
        jPanel.add(passwordPanel);
        jPanel.add(nationalityPanel1);
        jPanel.add(nationalityPanel2);
        jPanel.add(nationalityPanel3);
        jPanel.add(languagePanel);
        jPanel.add(birthdayPanel);
        jPanel.add(genderPanel);
        jPanel.add(signinButtonPanel);

        mainFrame.add(jPanel);

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
            g2d.draw(new RoundRectangle2D.Double(x-1, y, width - 1, height - 1, arc, arc));
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

    // 버튼
    public class RoundedButton extends JButton {
        public RoundedButton() { super(); decorate(); }
        public RoundedButton(String text) { super(text); decorate(); }
        public RoundedButton(Action action) { super(action); decorate(); }
        public RoundedButton(Icon icon) { super(icon); decorate(); }
        public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); }
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
            graphics.fillRoundRect(0, 0, width, height, 20, 20);
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

    public static void main(String[] args) throws IOException, FontFormatException {
        SignUp signup = new SignUp();
        signup.SignUp();
    }

}
