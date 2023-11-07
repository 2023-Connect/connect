import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;

public class Board {

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
    String boardTitle = "게시판";
    JButton writing;
    JLabel boardTitleLabel;





    // font
    Font fontExtraBold = con.getFontExtraBold();
    Font fontMedium = con.getFontMedium();
    Font fontRegular = con.getFontRegular();
    Font fontBold = con.getFontRegular();

    // image
    ImageIcon chatImg = new ImageIcon("./Image/Button_Image/chat.png");
    ImageIcon boardImg = new ImageIcon("./Image/Button_Image/board_here.png");
    ImageIcon searchImg = new ImageIcon("./Image/Button_Image/search.png");
    ImageIcon myPageImg = new ImageIcon("./Image/Button_Image/myPage.png");

    ImageIcon profilePicture = new ImageIcon("./Image/profilePicture.jpg");
    Image originalImage, scaledImage;
    ImageIcon scaledIcon;

    JLabel profileLabel;


    public Board () throws IOException, FontFormatException {
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
        new Board();
    }
}
