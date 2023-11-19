import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ChatRoomPage {


    Config con = new Config();
    String title = con.getTitle();
    Color mainColor = con.getMainColor();

    JPanel profilePanel;
            JLabel youNameLabel;
                String youName="오수빈";

            JPanel nationalityPanel;
            JButton exitButton;
    JScrollPane scrollPane;
                JPanel chatGroupPanel;

    JPanel inputPanel;
            JTextField chatTextField;
            JButton sendButton;



//  image
    ImageIcon koreaImg = con.getKoreaImg();
    ImageIcon usaImg = con.getUsaImg();
    ImageIcon japanImg = con.getJapanImg();

//    font
    Font fontExtraBold = con.getFontExtraBold();
    Font fontMedium = con.getFontMedium();
    Font fontRegular = con.getFontRegular();
    Font fontBold = con.getFontRegular();

    public ChatRoomPage(Map<String, String> userFile) throws IOException, FontFormatException {
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Set to DO_NOTHING_ON_CLOSE

        // Add a WindowListener to handle window closing event
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(mainFrame,
                        "정말 채팅창을 닫겠습니까?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    mainFrame.dispose(); // Dispose the frame only if the user chooses 'Yes'
                }
            }
        });
        mainFrame.setSize(400,700);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setLayout(new BorderLayout());

        fontMedium = fontMedium.deriveFont(15f);
        GraphicsEnvironment ge1 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge1.registerFont(fontMedium);

        fontExtraBold = fontExtraBold.deriveFont(20f);
        GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge2.registerFont(fontExtraBold);

        fontRegular = fontRegular.deriveFont(18f);
        GraphicsEnvironment ge3 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge3.registerFont(fontRegular);

        fontBold = fontBold.deriveFont(14f);
        GraphicsEnvironment ge4 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge4.registerFont(fontBold);

        profilePanel = new JPanel();
        profilePanel.setPreferredSize(new Dimension(400, 80));
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.X_AXIS));
        profilePanel.setBackground(Color.WHITE);


        //            boardNameLabel
        youNameLabel = new JLabel(youName);
        youNameLabel.setFont(fontExtraBold);
        youNameLabel.setForeground(Color.BLACK);

//            boardBulletinUserPanel
        BufferedImage originalImage2 = null;
        try {
            originalImage2 = ImageIO.read(new File("./Image/profilePicture.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 이미지를 동그랗게 자르기
        int width1 = 50;
        int height1 = 50;
        BufferedImage circularImage1 = new BufferedImage(width1, height1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g11 = circularImage1.createGraphics();
        g11.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape circle1 = new Ellipse2D.Double(0, 0, width1, height1);
        g11.setClip(circle1);
        g11.drawImage(originalImage2.getScaledInstance(width1, height1, Image.SCALE_SMOOTH), 0, 0, null);
        g11.dispose();

        ImageIcon circularIcon1 = new ImageIcon(circularImage1);
        JLabel ImageLabel1 = new JLabel(circularIcon1);

        nationalityPanel = new JPanel();
        nationalityPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel jLabel = new JLabel(koreaImg);
        nationalityPanel.add(jLabel);
        jLabel = new JLabel(usaImg);
        nationalityPanel.add(jLabel);
        jLabel = new JLabel(japanImg);
        nationalityPanel.add(jLabel);
        nationalityPanel.setBorder(BorderFactory.createEmptyBorder(22, 0, 0, 0));
        nationalityPanel.setBackground(Color.WHITE);

        exitButton = new RoundedButton("글쓰기");
        exitButton.setFont(fontBold);
        exitButton.setForeground(Color.GRAY);
        Insets exitButtonMargin = exitButton.getMargin();
        exitButtonMargin.left = 20; // 여백 값 조절 (원하는 값으로 변경)
        exitButtonMargin.top = 20;
        exitButton.setMargin(exitButtonMargin);




        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);

        chatGroupPanel = new JPanel();
        chatGroupPanel.setLayout(new BoxLayout(chatGroupPanel, BoxLayout.Y_AXIS)); // Use Y_AXIS for vertical layout
        chatGroupPanel.setBackground(Color.WHITE);

        for (int i = 0; i < 20; i++) {
            Chat chat = new Chat();
            chatGroupPanel.add(chat);
        }

        scrollPane = new JScrollPane(chatGroupPanel);
        scrollPane.setBackground(Color.WHITE);

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);

        inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(400, 45));
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.setBackground(Color.WHITE);

        RoundedPanelBorder roundedPanelBorder = new RoundedPanelBorder(45,2);
        chatTextField = new JTextField(15);
        chatTextField.setBorder(roundedPanelBorder);
        chatTextField.setFont(fontRegular);
        int width = 300;
        int height = 40;
        chatTextField.setPreferredSize(new Dimension(width, height));

        // 댓글 다는 버튼
        sendButton = new RoundedButton2("달기");
        sendButton.setFont(fontBold);
        sendButton.setForeground(Color.WHITE);
        Insets buttonMargin = sendButton.getMargin();
        buttonMargin.top = 10;
        buttonMargin.left = 20;
        sendButton.setMargin(buttonMargin);
        sendButton.setBorderPainted(false);


        profilePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        profilePanel.add(ImageLabel1, BorderLayout.WEST);
        profilePanel.add(youNameLabel);
        profilePanel.add(nationalityPanel);
        profilePanel.add(exitButton);
        profilePanel.add(Box.createRigidArea(new Dimension(10, 0)));

        inputPanel.add(chatTextField);
        inputPanel.add(sendButton);


        mainFrame.add(profilePanel, BorderLayout.NORTH);
        mainFrame.add(scrollPane, BorderLayout.CENTER);
        mainFrame.add(inputPanel, BorderLayout.SOUTH);



//        mainFrame.add(myPageMainPanel, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }

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
            graphics.fillRoundRect(0, 0, width, height, 30, 30);
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

}
