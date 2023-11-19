import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.util.Map;

public class BulletinPage {

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

    JPanel mainPanel;
    JPanel chatTitlePanel;
    JLabel chatTitleLabel;
    JButton chatAddBtn;
    JScrollPane scrollPane;
    JPanel bulletinGroupPanel;
    JLabel ProfileImgLabel;

    JPanel boardMainChoosePanel;
    JButton boardWritingButton;
    JButton boardTabButton, boardFollowButton;



    // font
    Font fontBlack = con.getFontBlack();
    Font fontMedium = con.getFontMedium();

    // image
    ImageIcon chatImg = new ImageIcon("./Image/Button_Image/chat.png");
    ImageIcon boardImg = new ImageIcon("./Image/Button_Image/board_here.png");
    ImageIcon searchImg = new ImageIcon("./Image/Button_Image/search.png");
    ImageIcon myPageImg = new ImageIcon("./Image/Button_Image/myPage.png");

    Font fontExtraBold = con.getFontExtraBold();
    Font fontRegular = con.getFontRegular();
    Font fontRegular2 = con.getFontRegular();
    Font fontBold = con.getFontBold();
    Font fontBold2 = con.getFontBold();
    Font fontLight = con.getFontRegular();


    ImageIcon plusImg = new ImageIcon("./Image/icon/plus.png");

    public BulletinPage (Map<String, String> userFile) throws IOException, FontFormatException {
        JFrame mainFrame = new JFrame(title);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(753,640);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setLayout(new BorderLayout());


        // font
        fontBlack = fontBlack.deriveFont(40f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fontBlack);

        fontMedium = fontMedium.deriveFont(15f);
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fontMedium);

        fontExtraBold = fontExtraBold.deriveFont(15f);
        GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge2.registerFont(fontExtraBold);


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

        // addActionListener
        chatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            new ChatPage(userFile);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (FontFormatException e) {
                            throw new RuntimeException(e);
                        }
                        mainFrame.setVisible(false);
                    }
                });
            }
        });
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            new SearchPage(userFile);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (FontFormatException e) {
                            throw new RuntimeException(e);
                        }
                        mainFrame.setVisible(false);
                    }
                });
            }
        });
        myPageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            new MyPage(userFile);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (FontFormatException e) {
                            throw new RuntimeException(e);
                        }
                        mainFrame.setVisible(false);
                    }
                });
            }
        });

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


        // main
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(603, 640));
        mainPanel.setBackground(Color.WHITE);
        chatTitlePanel = new JPanel();
        chatTitlePanel.setLayout(new BorderLayout());
        chatTitlePanel.setBorder(BorderFactory.createEmptyBorder(40, 50, 30, 35));
        chatTitleLabel = new JLabel(board);
        chatTitleLabel.setFont(fontBlack);


        boardWritingButton = new RoundedButton("글쓰기");
        boardWritingButton.setFont(fontExtraBold);
        boardWritingButton.setForeground(Color.GRAY);
        Insets writingButtonMargin = boardWritingButton.getMargin();
        writingButtonMargin.left = 30; // 여백 값 조절 (원하는 값으로 변경)
        writingButtonMargin.top = 10;
        boardWritingButton.setMargin(writingButtonMargin);

        //boardMainChoosePanel
        boardMainChoosePanel = new JPanel(new FlowLayout());
        boardMainChoosePanel.setPreferredSize(new Dimension(603, 30));
        boardMainChoosePanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // FlowLayout로 변경 (왼쪽 정렬)
        boardMainChoosePanel.setBackground(Color.WHITE);


        // boardTabButton

        boardTabButton = new RoundedButton2("추천 탭");
        boardTabButton.setFont(fontExtraBold);
        boardTabButton.setForeground(Color.GRAY);
        Insets buttonMargin1 = boardTabButton.getMargin();
        buttonMargin1.left = 20;
        buttonMargin1.top = 10;
        boardTabButton.setMargin(buttonMargin1);
        boardTabButton.setBorderPainted(false);

        //boardFollowButton
        boardFollowButton = new RoundedBorderButton("팔로우");
        boardFollowButton.setFont(fontExtraBold);
        boardFollowButton.setForeground(Color.GRAY);
        Insets buttonMargin2 = boardFollowButton.getMargin();
        buttonMargin2.left = 20;
        buttonMargin2.top = 10;
        boardFollowButton.setMargin(buttonMargin2);
        boardFollowButton.setBorderPainted(false);

        bulletinGroupPanel = new JPanel();
        bulletinGroupPanel.setLayout(new BoxLayout(bulletinGroupPanel, BoxLayout.Y_AXIS));
        bulletinGroupPanel.setBackground(Color.WHITE);
        scrollPane = new JScrollPane(bulletinGroupPanel);
        scrollPane.setBackground(Color.WHITE);

        for (int i = 0; i < 10; i++ ) {
            bulletinBoardPanel bulletinBoardPanel = new bulletinBoardPanel();
            bulletinGroupPanel.add(bulletinBoardPanel);
//            JButton jButton = new JButton("어쩌고저ㅓㅉㄱㄱㄴ아럼ㄴㄹ");
//            bulletinGroupPanel.add(jButton);
        }

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);

        // setBackground
        chatTitlePanel.setBackground(Color.WHITE);
        mainPanel.setBackground(Color.WHITE);

        // add
        chatTitlePanel.add(chatTitleLabel, BorderLayout.WEST);
        chatTitlePanel.add(boardWritingButton, BorderLayout.EAST);

        boardMainChoosePanel.add(Box.createRigidArea(new Dimension(35, 0)));
        boardMainChoosePanel.add(boardTabButton);
        boardMainChoosePanel.add(boardFollowButton);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);

// boardMainChoosePanel과 scrollPane을 contentPanel에 추가
        contentPanel.add(boardMainChoosePanel);
        contentPanel.add(scrollPane);

// mainPanel에 contentPanel 추가
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.add(chatTitlePanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        mainFrame.add(sidePanel, BorderLayout.WEST);
        mainFrame.add(mainPanel, BorderLayout.EAST);
        mainFrame.setVisible(true);
    }

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

}
