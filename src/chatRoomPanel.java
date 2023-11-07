import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class chatRoomPanel extends JPanel {

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
            String chatContent = "경로당홍삼캔디킹도둑엄준식밍청이메롱티비이지두댄스";
    JPanel timePanel;
        JLabel dayLabel;
            String day = "2023-11-7";
        JLabel timeLabel;
            String time = "14:00";
            String amPm;

    // image
    ImageIcon koreaImg = con.getKoreaImg();
    ImageIcon usaImg = con.getUsaImg();
    ImageIcon japanImg = con.getJapanImg();


    public chatRoomPanel() throws IOException, FontFormatException {
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
        contentPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 100));
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
        timePanel = new JPanel(new GridBagLayout());

        fontMedium = fontMedium.deriveFont(12f);
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fontMedium);

        dayLabel = new JLabel(day);
        dayLabel.setFont(fontMedium);

        // am pm 구하기
        String hourString = time.substring(0, 2);
        if (Integer.parseInt(hourString) > 12) {
            time = time.replace(time.substring(0, 2), Integer.toString(Integer.parseInt(hourString) - 12));
            amPm = "pm";
        } else {
            amPm = "am";
        }

        timeLabel = new JLabel(time + " " + amPm);
        timeLabel.setFont(fontMedium);

        // Create GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        timePanel.add(dayLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        timePanel.add(timeLabel, gbc);

        timePanel.setBackground(Color.WHITE);


        add(ImageLabel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        add(timePanel, BorderLayout.EAST);
        setVisible(true);
    }
}