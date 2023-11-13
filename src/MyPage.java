import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyPage {

    Config con = new Config();
    String title = con.getTitle();
    Color mainColor = con.getMainColor();

    JPanel sidePanel;
    JPanel chatPanel;
    JPanel chatBtnPanel;
    JButton chatBtn;
    JPanel chatLabelPanel;
    JLabel chatLabel;
    String chat = "채팅";
    JPanel boardPanel;
    JPanel boardBtnPanel;
    JButton boardBtn;
    JPanel boardLabelPanel;
    JLabel boardLabel;
    String board = "게시판";
    JPanel searchPanel;
    JPanel searchBtnPanel;
    JButton searchBtn;
    JPanel searchLabelPanel;
    JLabel searchLabel;
    String search = "친구 찾기";
    JPanel myPagePanel;
    JPanel myPageBtnPanel;
    JButton myPageBtn;
    JPanel myPageLabelPanel;
    JLabel myPageLabel;
    String myPage = "마이페이지";
    JPanel myPageMainPanel;

    JPanel myPageMainTitlePanel;
    String myPageTitle = "마이페이지";
    JLabel myPageTitleLabel;

    JPanel myPageMainProfilePanel;
    JPanel myPageMainProfileTextPanel;
    String myPageName = "오수빈";
    JLabel myPageNameLabel;
    String myPageId = "oxnqlu";
    JLabel myPageIdLabel;
    String myPageSelfIntroduction = "쌍큼발랄고딩이";
    JLabel myPageSelfIntroductionLabel;

    JPanel myPageMainETCPanel;
    String nationality = "국적 : ";
    String myPageNationality = "대한민국";
    JLabel myPageNationalityLabel;
    String language = "언어 : ";
    String myPageLanguage = "한국어";
    JLabel myPageLanguageLabel;
    String birthday = "생년월일 : ";
    int birthdayYear = 2006;
    int birthdayMonth = 01;
    int birthdayDay = 16;
    JLabel myPageBirthdayLabel;
    String gender = "성별 : ";
    String myPageGender = "여";
    JLabel myPageGenderLabel;

    JButton myPageCorrectionButton;
    JPanel myPageMainButtonPanel;
    JButton profilePictureBtn;
    int buttonWidth = 500;
    int buttonHeight = 100;


    // font
    Font fontExtraBold = con.getFontExtraBold();
    Font fontMedium = con.getFontMedium();
    Font fontRegular = con.getFontRegular();
    Font fontBold = con.getFontRegular();

    // image
    ImageIcon chatImg = new ImageIcon("./Image/Button_Image/chat.png");
    ImageIcon boardImg = new ImageIcon("./Image/Button_Image/board.png");
    ImageIcon searchImg = new ImageIcon("./Image/Button_Image/search.png");
    ImageIcon myPageImg = new ImageIcon("./Image/Button_Image/myPage_here.png");

    ImageIcon profilePicture = new ImageIcon("./Image/profilePicture.jpg");
    Image originalImage, scaledImage;
    ImageIcon scaledIcon;

    JLabel profileLabel;


    public MyPage () throws IOException, FontFormatException {
        JFrame mainFrame = new JFrame(title);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(753,640);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setLayout(new BorderLayout());

        fontMedium = fontMedium.deriveFont(15f);
        GraphicsEnvironment ge1 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge1.registerFont(fontMedium);

        fontExtraBold = fontExtraBold.deriveFont(35f);
        GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge2.registerFont(fontExtraBold);

        fontRegular = fontRegular.deriveFont(18f);
        GraphicsEnvironment ge3 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge3.registerFont(fontRegular);

        fontBold = fontBold.deriveFont(14f);
        GraphicsEnvironment ge4 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge4.registerFont(fontBold);


        // sideBar
        sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(133, 640));
        sidePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        // chat
        chatPanel = new JPanel();
        chatPanel.setPreferredSize(new Dimension(130, 150));
        chatPanel.setLayout(new BorderLayout());

        chatBtnPanel = new JPanel();
        chatBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        chatBtnPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        chatBtn = new JButton(chatImg);
        chatBtn.setBorderPainted(false);
        chatBtn.setBackground(mainColor);
        chatBtn.setOpaque(true); // 투명하지 않게 설정하여 배경색이 보이도록 함
        chatBtn.setPreferredSize(new Dimension(90, 90)); // 버튼 크기 설정 (원형으로 보이게 하려면 너비와 높이가 동일해야 함)

        chatLabelPanel = new JPanel();
        chatLabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        chatLabel = new JLabel("<html><div style='margin-bottom: 10px;'>"+chat+"</div></html>");
        chatLabel.setFont(fontMedium);
        chatLabel.setForeground(Color.GRAY);

        //board
        boardPanel = new JPanel();
        boardPanel.setPreferredSize(new Dimension(130, 150));
        boardPanel.setLayout(new BorderLayout());

        boardBtnPanel = new JPanel();
        boardBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        boardBtnPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        boardBtn = new JButton(boardImg);
        boardBtn.setBorderPainted(false);
        boardBtn.setBackground(Color.WHITE);
        boardBtn.setOpaque(true); // 투명하지 않게 설정하여 배경색이 보이도록 함
        boardBtn.setPreferredSize(new Dimension(90, 90)); // 버튼 크기 설정 (원형으로 보이게 하려면 너비와 높이가 동일해야 함)

        boardLabelPanel = new JPanel();
        boardLabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        boardLabel = new JLabel("<html><div style='margin-bottom: 10px;'>"+board+"</div></html>");
        boardLabel.setFont(fontMedium);
        boardLabel.setForeground(Color.GRAY);

        // search
        searchPanel = new JPanel();
        searchPanel.setPreferredSize(new Dimension(130, 150));
        searchPanel.setLayout(new BorderLayout());

        searchBtnPanel = new JPanel();
        searchBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        searchBtnPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        searchBtn = new JButton(searchImg);
        searchBtn.setBorderPainted(false);
        searchBtn.setBackground(mainColor);
        searchBtn.setOpaque(true); // 투명하지 않게 설정하여 배경색이 보이도록 함
        searchBtn.setPreferredSize(new Dimension(90, 90)); // 버튼 크기 설정 (원형으로 보이게 하려면 너비와 높이가 동일해야 함)

        searchLabelPanel = new JPanel();
        searchLabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        searchLabel = new JLabel("<html><div style='margin-bottom: 10px;'>"+search+"</div></html>");
        searchLabel.setFont(fontMedium);
        searchLabel.setForeground(Color.GRAY);

        // myPage
        myPagePanel = new JPanel();
        myPagePanel.setPreferredSize(new Dimension(130, 150));
        myPagePanel.setLayout(new BorderLayout());

        myPageBtnPanel = new JPanel();
        myPageBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        myPageBtnPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        myPageBtn = new JButton(myPageImg);
        myPageBtn.setBorderPainted(false);
        myPageBtn.setBackground(Color.WHITE);
        myPageBtn.setOpaque(true); // 투명하지 않게 설정하여 배경색이 보이도록 함
        myPageBtn.setPreferredSize(new Dimension(90, 90)); // 버튼 크기 설정 (원형으로 보이게 하려면 너비와 높이가 동일해야 함)

        myPageLabelPanel = new JPanel();
        myPageLabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        myPageLabel = new JLabel("<html><div style='margin-bottom: 10px;'>"+myPage+"</div></html>");
        myPageLabel.setFont(fontMedium);
        myPageLabel.setForeground(Color.GRAY);

        // setBackground
        sidePanel.setBackground(Color.gray);
        chatBtnPanel.setBackground(mainColor);
        chatLabelPanel.setBackground(mainColor);
        boardBtnPanel.setBackground(Color.WHITE);
        boardLabelPanel.setBackground(Color.WHITE);
        searchBtnPanel.setBackground(mainColor);
        searchLabelPanel.setBackground(mainColor);
        myPageBtnPanel.setBackground(Color.WHITE);
        myPageLabelPanel.setBackground(Color.WHITE);

        // add
        chatBtnPanel.add(chatBtn);
        chatLabelPanel.add(chatLabel);
        chatPanel.add(chatBtnPanel, BorderLayout.CENTER);
        chatPanel.add(chatLabelPanel, BorderLayout.SOUTH);

        boardBtnPanel.add(boardBtn);
        boardLabelPanel.add(boardLabel);
        boardPanel.add(boardBtnPanel, BorderLayout.CENTER);
        boardPanel.add(boardLabelPanel, BorderLayout.SOUTH);

        searchBtnPanel.add(searchBtn);
        searchLabelPanel.add(searchLabel);
        searchPanel.add(searchBtnPanel, BorderLayout.CENTER);
        searchPanel.add(searchLabelPanel, BorderLayout.SOUTH);

        myPageBtnPanel.add(myPageBtn);
        myPageLabelPanel.add(myPageLabel);
        myPagePanel.add(myPageBtnPanel, BorderLayout.CENTER);
        myPagePanel.add(myPageLabelPanel, BorderLayout.SOUTH);

        sidePanel.add(chatPanel);
        sidePanel.add(boardPanel);
        sidePanel.add(searchPanel);
        sidePanel.add(myPagePanel);

        mainFrame.add(sidePanel, BorderLayout.WEST);
        mainFrame.setVisible(true);

        myPageMainPanel = new JPanel();
        myPageMainPanel.setPreferredSize(new Dimension(603, 640));
        myPageMainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        myPageMainPanel.setBackground(Color.WHITE);

        myPageMainTitlePanel = new JPanel();
        myPageMainTitlePanel.setPreferredSize(new Dimension(603, 70));
        myPageMainTitlePanel.setLayout(new BorderLayout());
        myPageTitleLabel = new JLabel("<html><div style='margin-left: 30px;'>" + myPageTitle + "</div></html>");
        myPageTitleLabel.setFont(fontExtraBold);
        myPageTitleLabel.setForeground(Color.BLACK);
        myPageMainTitlePanel.setBackground(Color.WHITE);



        myPageMainProfilePanel = new JPanel();
        myPageMainProfilePanel.setPreferredSize(new Dimension(550, 200));
        myPageMainProfilePanel.setLayout(new BorderLayout());
        myPageMainProfilePanel.setBackground(Color.WHITE);

        BufferedImage originalImage2 = null;
        try {
            originalImage2 = ImageIO.read(new File("./Image/profilePicture.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 이미지를 동그랗게 자르기
        int width1 = 180;
        int height1 = 180;
        BufferedImage circularImage1 = new BufferedImage(width1, height1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g11 = circularImage1.createGraphics();
        g11.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape circle1 = new Ellipse2D.Double(0, 0, width1, height1);
        g11.setClip(circle1);
        g11.drawImage(originalImage2.getScaledInstance(width1, height1, Image.SCALE_SMOOTH), 0, 0, null);
        g11.dispose();

        ImageIcon circularIcon1 = new ImageIcon(circularImage1);
        JLabel ImageLabel1 = new JLabel(circularIcon1);

        //myPageMainProfileTextPanel
        myPageMainProfileTextPanel = new JPanel();
        myPageMainProfileTextPanel.setPreferredSize(new Dimension(603, 150));
        myPageMainProfileTextPanel.setLayout(new BoxLayout(myPageMainProfileTextPanel, BoxLayout.Y_AXIS));
        myPageMainProfileTextPanel.setBackground(Color.WHITE);

        // myPageMainProfileTextPanel Text
        myPageNameLabel = new JLabel("<html><div style='margin-left: 30px; margin-top: 15px;'>" + myPageName + "</div></html>");
        myPageNameLabel.setFont(fontExtraBold);
        myPageNameLabel.setForeground(Color.BLACK);
        myPageIdLabel = new JLabel("<html><div style='margin-left: 30px;'>" + myPageId + "</div></html>");
        myPageIdLabel.setFont(fontRegular);
        myPageIdLabel.setForeground(Color.BLACK);
        myPageSelfIntroductionLabel = new JLabel("<html><div style='margin-left: 30px;'>" + myPageSelfIntroduction + "</div></html>");
        myPageSelfIntroductionLabel.setFont(fontRegular);
        myPageSelfIntroductionLabel.setForeground(Color.BLACK);

        // myPageMainETCPanel
        myPageMainETCPanel = new JPanel();
        myPageMainETCPanel.setPreferredSize(new Dimension(603, 120));
        myPageMainETCPanel.setLayout(new BoxLayout(myPageMainETCPanel, BoxLayout.Y_AXIS));
        myPageMainETCPanel.setBackground(Color.WHITE);

        // myPageMainETCPanel Text
        myPageNationalityLabel = new JLabel("<html><div style='margin-left: 30px;'>"
                + nationality + myPageNationality + "</div></html>");
        myPageNationalityLabel.setFont(fontRegular);
        myPageNationalityLabel.setForeground(Color.BLACK);
        myPageLanguageLabel = new JLabel("<html><div style='margin-left: 30px;'>"
                + language + myPageLanguage + "</div></html>");
        myPageLanguageLabel.setFont(fontRegular);
        myPageLanguageLabel.setForeground(Color.BLACK);
        myPageBirthdayLabel = new JLabel("<html><div style='margin-left: 30px;'>"
                + birthday + birthdayYear + "년 " + birthdayMonth + "월 " + birthdayDay + "일" + "</div></html>");
        myPageBirthdayLabel.setFont(fontRegular);
        myPageBirthdayLabel.setForeground(Color.BLACK);
        myPageGenderLabel = new JLabel("<html><div style='margin-left: 30px;'>"
                + gender + myPageGender + "</div></html>");
        myPageGenderLabel.setFont(fontRegular);
        myPageGenderLabel.setForeground(Color.BLACK);

        // myPageMainButtonPanel
        myPageMainButtonPanel = new JPanel();
        myPageMainButtonPanel.setPreferredSize(new Dimension(603, 100));
        myPageMainButtonPanel.setLayout(new BoxLayout(myPageMainButtonPanel, BoxLayout.Y_AXIS));
        myPageMainButtonPanel.setBackground(Color.WHITE);
        myPageCorrectionButton = new RoundedButton("수정");
        myPageCorrectionButton.setFont(fontBold);
        myPageCorrectionButton.setForeground(Color.GRAY);
        

        //add
        myPageMainTitlePanel.add(myPageTitleLabel);
        myPageMainProfilePanel.add(Box.createRigidArea(new Dimension(70, 0)));
        myPageMainProfilePanel.add(ImageLabel1, BorderLayout.WEST);
        myPageMainProfileTextPanel.add(myPageNameLabel);
        myPageMainProfileTextPanel.add(myPageIdLabel);
        myPageMainProfileTextPanel.add(myPageSelfIntroductionLabel);
        myPageMainETCPanel.add(myPageNationalityLabel);
        myPageMainETCPanel.add(myPageLanguageLabel);
        myPageMainETCPanel.add(myPageBirthdayLabel);
        myPageMainETCPanel.add(myPageGenderLabel);
        myPageMainButtonPanel.add(Box.createRigidArea(new Dimension(8, 0)));
        myPageMainButtonPanel.add(myPageCorrectionButton);
        myPageMainPanel.add(myPageMainTitlePanel);
        myPageMainPanel.add(myPageMainProfilePanel);
        myPageMainPanel.add(myPageMainProfileTextPanel);
        myPageMainPanel.add(myPageMainETCPanel);
        myPageMainPanel.add(myPageMainButtonPanel);
        mainFrame.add(myPageMainPanel, BorderLayout.CENTER);
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


    // main
    public static void main(String[] args) throws IOException, FontFormatException {
        new MyPage();
    }
}
