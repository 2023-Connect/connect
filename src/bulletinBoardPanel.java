    import javax.imageio.ImageIO;
    import javax.swing.*;
    import javax.swing.border.Border;
    import java.awt.*;
    import java.awt.geom.Ellipse2D;
    import java.awt.geom.RoundRectangle2D;
    import java.awt.image.BufferedImage;
    import java.io.File;
    import java.io.IOException;

    public class bulletinBoardPanel extends JPanel{

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
        JPanel boardMainPanel;

        JPanel boardMainTitlePanel;
        String boardTitle = "게시판";
        JButton boardWritingButton;
        JLabel boardTitleLabel;


        JPanel boardMainChoosePanel;
        JButton boardTabButton, boardFollowButton;
        JScrollPane boardScrollPanel;
        JPanel boardBulletinPanel;
        JPanel boardBulletinUserPanel;
        JPanel boardBulletinNationalityPanel;
        JPanel boardBulletinTextPanel;
        JPanel boardBulletinCommentPanel;
        JPanel boardBulletinCommentsPanel;
        JPanel commentsNationalityPanel;
        JPanel contentPanel, userInfoPanel;
        JPanel boardGroupPanel;


        String boardName = "오수빈";
        JLabel boardNameLabel;
        String bulletinText =
                "<html>"+ "떡볶이조아" + "<br/>" + "아주그냥떡볶이가조아" + "<br/>" + "떡볶이가조아" + "</html>";
        JLabel bulletinTextLabel;
        String commentName = "황슬기";
        JLabel commentNameLabel;
        String commentText = "아주굿";
        JLabel commentTextLabel;

        int bulletinYear = 2023;
        int bulletinMonth = 8;
        int bulletinDay = 31;
        int bulletinHour = 9;
        int bulletinMinute = 8;
        String am = "am";
        String pm = "pm";

        JLabel bulletinTimeLabel;

        // font
        Font fontExtraBold = con.getFontExtraBold();
        Font fontMedium = con.getFontMedium();
        Font fontRegular = con.getFontRegular();
        Font fontRegular2 = con.getFontRegular();
        Font fontBold = con.getFontBold();
        Font fontBold2 = con.getFontBold();
        Font fontLight = con.getFontRegular();

        // image
        ImageIcon chatImg = new ImageIcon("./Image/Button_Image/chat.png");
        ImageIcon boardImg = new ImageIcon("./Image/Button_Image/board_here.png");
        ImageIcon searchImg = new ImageIcon("./Image/Button_Image/search.png");
        ImageIcon myPageImg = new ImageIcon("./Image/Button_Image/myPage.png");

        ImageIcon profilePicture = new ImageIcon("./Image/profilePicture.jpg");
        ImageIcon profilePicture2 = new ImageIcon("./Image/profilePicture2.jpg");
        ImageIcon plusImg = new ImageIcon("./Image/icon/plus.png");
        ImageIcon heartImg1 = new ImageIcon("./Image/icon/heart-1.png");
        ImageIcon heartImg2 = new ImageIcon("./Image/icon/heart-2.png");

        ImageIcon koreaImg = con.getKoreaImg();
        ImageIcon usaImg = con.getUsaImg();
        ImageIcon japanImg = con.getJapanImg();
        Image originalImage, scaledImage;
        ImageIcon scaledIcon;

        JButton profilePictureBtn,profilePictureBtn2;
        JButton plusButton;
        JButton heartButton1, heartButton2;
        JButton commentButton;

        JTextField commentTextField;

        JLabel profileLabel;


        public bulletinBoardPanel() throws IOException, FontFormatException {


            fontMedium = fontMedium.deriveFont(10f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fontMedium);

            fontExtraBold = fontExtraBold.deriveFont(24f);
            GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge2.registerFont(fontExtraBold);

            fontBold = fontBold.deriveFont(15f);
            GraphicsEnvironment ge3 = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge3.registerFont(fontBold);

            fontBold2 = fontBold.deriveFont(15f);
            GraphicsEnvironment ge4 = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge4.registerFont(fontBold2);

            fontRegular = fontRegular.deriveFont(18f);
            GraphicsEnvironment ge5 = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge5.registerFont(fontRegular);

            fontRegular2 = fontRegular.deriveFont(13f);
            GraphicsEnvironment ge6 = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge6.registerFont(fontRegular2);

            JFrame mainFrame = new JFrame(title);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(753,640);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setResizable(false);
            mainFrame.setLayout(new BorderLayout());

            // boardBulletinPanel
            // ( boardScrollPanel > boardBulletinPanel > boardBulletinUserPanel
            boardBulletinPanel = new JPanel();
            boardBulletinPanel.setPreferredSize(new Dimension(575, 360));
            boardBulletinPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//            boardBulletinPanel.setBackground(Color.WHITE);
            boardBulletinPanel.setBackground(Color.WHITE);


            // boardBulletinUserPanel
            boardBulletinUserPanel = new JPanel();
            boardBulletinUserPanel.setPreferredSize(new Dimension(570, 90));
            boardBulletinUserPanel.setLayout(new BoxLayout(boardBulletinUserPanel, BoxLayout.X_AXIS));
            boardBulletinUserPanel.setBackground(Color.WHITE);

//            boardNameLabel
            boardNameLabel = new JLabel(boardName);
            boardNameLabel.setFont(fontExtraBold);
            boardNameLabel.setForeground(Color.BLACK);

//            boardBulletinUserPanel
            BufferedImage originalImage2 = null;
            try {
                originalImage2 = ImageIO.read(new File("./Image/profilePicture.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 이미지를 동그랗게 자르기
            int width1 = 80;
            int height1 = 80;
            BufferedImage circularImage1 = new BufferedImage(width1, height1, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g11 = circularImage1.createGraphics();
            g11.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape circle1 = new Ellipse2D.Double(0, 0, width1, height1);
            g11.setClip(circle1);
            g11.drawImage(originalImage2.getScaledInstance(width1, height1, Image.SCALE_SMOOTH), 0, 0, null);
            g11.dispose();

            ImageIcon circularIcon1 = new ImageIcon(circularImage1);
            JLabel ImageLabel1 = new JLabel(circularIcon1);

            boardBulletinNationalityPanel = new JPanel();
            boardBulletinNationalityPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel jLabel = new JLabel(koreaImg);
            boardBulletinNationalityPanel.add(jLabel);
            jLabel = new JLabel(usaImg);
            boardBulletinNationalityPanel.add(jLabel);
            jLabel = new JLabel(japanImg);
            boardBulletinNationalityPanel.add(jLabel);
            boardBulletinNationalityPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
            boardBulletinNationalityPanel.setBackground(Color.WHITE);

//            plus 버튼
            originalImage = plusImg.getImage();
            scaledImage = originalImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(scaledImage);
            plusButton = new JButton(scaledIcon);
            plusButton.setContentAreaFilled(false);
            plusButton.setPreferredSize(new Dimension(30, 30));

            //게시글 내용
            boardBulletinTextPanel = new JPanel();
            boardBulletinTextPanel.setPreferredSize(new Dimension(570, 110));
            boardBulletinTextPanel.setLayout(new BoxLayout(boardBulletinTextPanel, BoxLayout.Y_AXIS));
            boardBulletinTextPanel.setBackground(Color.WHITE);
            bulletinTextLabel = new JLabel(bulletinText);
            bulletinTextLabel.setFont(fontRegular);
            bulletinTextLabel.setForeground(Color.BLACK);
            //게시글 날짜
            bulletinTimeLabel =
                    new JLabel(bulletinYear + "-" + bulletinMonth + "-" + bulletinDay +
                            " " + bulletinHour + ":" + bulletinMinute + " " + am);
            bulletinTimeLabel.setFont(fontMedium);
            bulletinTimeLabel.setForeground(Color.BLACK);

            // 댓글 달기
            boardBulletinCommentPanel = new JPanel();
            boardBulletinCommentPanel.setPreferredSize(new Dimension(560, 40));
            boardBulletinCommentPanel.setLayout(new BoxLayout(boardBulletinCommentPanel, BoxLayout.X_AXIS));
            boardBulletinCommentPanel.setBackground(Color.WHITE);
            //하트 아이콘
            originalImage = heartImg1.getImage();
            scaledImage = originalImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(scaledImage);
            heartButton1 = new JButton(scaledIcon);
            heartButton1.setContentAreaFilled(false);
            heartButton1.setPreferredSize(new Dimension(30, 30));
            // 댓글 다는 텍스트필드
            RoundedPanelBorder roundedPanelBorder = new RoundedPanelBorder(45,2);
            commentTextField = new JTextField(3);
            commentTextField.setBorder(roundedPanelBorder);
            commentTextField.setFont(fontRegular);
            int width = 300;
            int height = 40;
            commentTextField.setPreferredSize(new Dimension(width, height));
            // 댓글 다는 버튼
            commentButton = new RoundedButton2("달기");
            commentButton.setFont(fontBold2);
            commentButton.setForeground(Color.WHITE);
            Insets buttonMargin = commentButton.getMargin();
            buttonMargin.top = 10;
            buttonMargin.left = 20;
            commentButton.setMargin(buttonMargin);
            commentButton.setBorderPainted(false);

            //댓글들
            boardBulletinCommentsPanel = new JPanel();
            boardBulletinCommentsPanel.setPreferredSize(new Dimension(570, 100));
//            boardBulletinCommentsPanel.setLayout(new BoxLayout(boardBulletinCommentsPanel, BoxLayout.Y_AXIS));
            boardBulletinCommentsPanel.setBackground(Color.WHITE);

            BufferedImage originalImage = null;
            try {
                originalImage = ImageIO.read(new File("./Image/profilePicture2.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 이미지를 동그랗게 자르기
            int width2 = 60;
            int height2 = 60;
            BufferedImage circularImage = new BufferedImage(width2, height2, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = circularImage.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape circle = new Ellipse2D.Double(0, 0, width2, height2);
            g2.setClip(circle);
            g2.drawImage(originalImage.getScaledInstance(width2, height2, Image.SCALE_SMOOTH), 0, 0, null);
            g2.dispose();

            ImageIcon circularIcon = new ImageIcon(circularImage);
            JLabel ImageLabel = new JLabel(circularIcon);

            // contentPanel
            contentPanel = new JPanel(new BorderLayout());
            contentPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 100));
            userInfoPanel = new JPanel(new BorderLayout());

            commentNameLabel = new JLabel(commentName);
            commentNameLabel.setFont(fontBold);

            JPanel countryImagesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel jLabel2 = new JLabel(koreaImg);
            countryImagesPanel.add(jLabel2);
            jLabel2 = new JLabel(usaImg);
            countryImagesPanel.add(jLabel2);
            jLabel2 = new JLabel(japanImg);
            countryImagesPanel.add(jLabel2);


            commentTextLabel = new JLabel(commentText);
            commentTextLabel.setFont(fontRegular2);

            countryImagesPanel.setBackground(Color.WHITE);
            userInfoPanel.setBackground(Color.WHITE);
            contentPanel.setBackground(Color.WHITE);


            // 게시판
            boardBulletinUserPanel.setBackground(Color.WHITE);
            boardBulletinUserPanel.add(ImageLabel1, BorderLayout.WEST);
//            boardBulletinUserPanel.add(Box.createRigidArea(new Dimension(10, 0)));
            boardBulletinUserPanel.add(boardNameLabel);
            boardBulletinUserPanel.add(boardBulletinNationalityPanel);
//            boardBulletinUserPanel.add(Box.createRigidArea(new Dimension(30, 0))); // 오른쪽 여백 추가
            boardBulletinUserPanel.add(plusButton);

            //boardBulletinTextPanel
            boardBulletinTextPanel.setBackground(Color.WHITE);
            boardBulletinTextPanel.add(bulletinTextLabel);
            boardBulletinTextPanel.add(bulletinTimeLabel);

            //boardBulletinCommentPanel
            boardBulletinCommentPanel.setBackground(Color.WHITE);
            boardBulletinCommentPanel.add(heartButton1);
            boardBulletinCommentPanel.add(commentTextField);
            boardBulletinCommentPanel.add(commentButton);

            userInfoPanel.setBackground(Color.WHITE);
            contentPanel.setBackground(Color.WHITE);
            userInfoPanel.add(commentNameLabel, BorderLayout.WEST);
            userInfoPanel.add(countryImagesPanel, BorderLayout.CENTER);
            contentPanel.add(userInfoPanel,BorderLayout.NORTH);
            contentPanel.add(commentTextLabel, BorderLayout.SOUTH);

            boardBulletinCommentsPanel.setBackground(Color.WHITE);
            boardBulletinCommentsPanel.add(ImageLabel,BorderLayout.WEST);
            boardBulletinCommentsPanel.add(contentPanel, BorderLayout.CENTER);
            boardBulletinCommentsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            boardBulletinPanel.setBackground(Color.WHITE);
            boardBulletinPanel.setBackground(Color.WHITE);
            boardBulletinPanel.add(boardBulletinUserPanel);
            boardBulletinPanel.add(boardBulletinTextPanel);
            boardBulletinPanel.add(boardBulletinCommentPanel);
            boardBulletinPanel.add(boardBulletinCommentsPanel, BorderLayout.WEST);

            add(boardBulletinPanel);
            setVisible(true);
//            mainFrame.add(boardBulletinPanel);
//            mainFrame.setVisible(true);
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

        public class RoundedButton2 extends JButton {
            public RoundedButton2() { super(); decorate(); }
            public RoundedButton2(String text) { super(text); decorate(); }
            public RoundedButton2(Action action) { super(action); decorate(); }
            public RoundedButton2(Icon icon) { super(icon); decorate(); }
            public RoundedButton2(String text, Icon icon) { super(text, icon); decorate(); }
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
                graphics.fillRoundRect(0, 0, width, height, 40, 40);
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

        public class RoundedBorderButton extends JButton {

            public RoundedBorderButton(String text) { super(text); decorate();}

            protected void decorate() { setOpaque(false); }

            @Override
            protected void paintComponent(Graphics g) {
                Color c = Color.WHITE; // 배경색 결정
                Color o = Color.GRAY; // 글자색 결정
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (getModel().isArmed()) {
                    graphics.setColor(c.darker());
                } else if (getModel().isRollover()) {
                    graphics.setColor(c.brighter());
                } else {
                    graphics.setColor(c);
                }
                graphics.fillRoundRect(0, 0, width, height, 40, 40);

                // Add border here
                graphics.setColor(mainColor); // 테두리 색 설정
                graphics.setStroke(new BasicStroke(3)); // 테두리 두께 설정
                graphics.draw(new RoundRectangle2D.Double(1, 1, width - 2, height - 2, 40, 40));

                FontMetrics fontMetrics = graphics.getFontMetrics();
                Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
                int textX = (width - stringBounds.width) / 2;
                int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
                graphics.setColor(o);
                graphics.setFont(getFont());
                graphics.drawString(getText(), textX, textY);
            }
        }

//        public static void main(String[] args) throws IOException, FontFormatException {
//            new bulletinBoardPanel();
//        }
    }