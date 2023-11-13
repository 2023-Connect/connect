import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class searchPanel extends JPanel {

    Config con = new Config();
    Font fontBold = con.getFontBold();
    Font fontMedium = con.getFontMedium();

    JLabel ImageLabel;
    JPanel contentPanel;
    JPanel userInfoPanel;
    JLabel nameLabel;
    String name = "황슬기";
    JPanel countryImagesPanel;
    JLabel chatContentLabel;
    String chatContent = "이곳은 자기소개란입니다";
    JPanel addPanel;
        JButton addBtn;
            ImageIcon plusImg = new ImageIcon("./Image/icon/plus.png");


    // image
    ImageIcon koreaImg = con.getKoreaImg();
    ImageIcon usaImg = con.getUsaImg();
    ImageIcon japanImg = con.getJapanImg();


    public searchPanel() throws IOException, FontFormatException {
        setPreferredSize(new Dimension(570, 120));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 35));

        // font
        fontBold = fontBold.deriveFont(28f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fontBold);

        // 이미지 파일 불러오기
        BufferedImage originalImage = null;
        try {
            originalImage = ImageIO.read(new File("./Image/profile_Image/profile.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 이미지를 동그랗게 자르기
        int width = 80;
        int height = 80;
        BufferedImage circularImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = circularImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape circle = new Ellipse2D.Double(0, 0, width, height);
        g2.setClip(circle);
        g2.drawImage(originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
        g2.dispose();

        ImageIcon circularIcon = new ImageIcon(circularImage);
        ImageLabel = new JLabel(circularIcon);

        // contentPanel
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 150));
        userInfoPanel = new JPanel(new BorderLayout());

        nameLabel = new JLabel(name);
        nameLabel.setFont(fontBold);

        countryImagesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel jLabel = new JLabel(koreaImg);
        countryImagesPanel.add(jLabel);
        jLabel = new JLabel(usaImg);
        countryImagesPanel.add(jLabel);
        jLabel = new JLabel(japanImg);
        countryImagesPanel.add(jLabel);


        chatContentLabel = new JLabel(chatContent);

        fontMedium = fontMedium.deriveFont(15f);
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fontMedium);

        int maxLength = 15; // 최대 길이

        String text = chatContentLabel.getText();
        if (text.length() > maxLength) {
            text = text.substring(0, maxLength) + "..."; // 일정 길이 이상이면 ...으로 축소
        }
        chatContentLabel.setText(text);
        chatContentLabel.setFont(fontMedium);

        countryImagesPanel.setBackground(Color.WHITE);
        userInfoPanel.setBackground(Color.WHITE);
        contentPanel.setBackground(Color.WHITE);

        userInfoPanel.add(nameLabel, BorderLayout.WEST);
        userInfoPanel.add(countryImagesPanel, BorderLayout.CENTER);
        contentPanel.add(userInfoPanel,BorderLayout.NORTH);
        contentPanel.add(chatContentLabel, BorderLayout.SOUTH);


        // timePanel
        addPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addBtn = new JButton(plusImg);
        addBtn.setPreferredSize(new Dimension(50,50));
        addBtn.setBackground(Color.WHITE);
        addBtn.setBorderPainted(false);

        addPanel.add(addBtn);
        addPanel.setBackground(Color.WHITE);


        add(ImageLabel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        add(addPanel, BorderLayout.EAST);
        setVisible(true);
    }
}