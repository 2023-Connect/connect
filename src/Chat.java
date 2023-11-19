import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

public class Chat extends JPanel{

    Config con = new Config();
    String title = con.getTitle();
    Color mainColor = con.getMainColor();
    JPanel mainPanel;
    JPanel myChatPanel, youChatPanel;
            JLabel myNameLabel;
                String myName="오수빈";
            JLabel myChat;
                String myChatst = "하이루";
           JLabel youNameLabel;
                String youName="오수빈";
           JLabel youChat;
                String youChatSt = "안녕~";

    //    font
    Font fontExtraBold = con.getFontExtraBold();
    Font fontMedium = con.getFontMedium();
    Font fontRegular = con.getFontRegular();
    Font fontBold = con.getFontRegular();
    public Chat () throws IOException, FontFormatException {

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

        setPreferredSize(new Dimension(360, 210));
        setBackground(Color.WHITE);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(360, 210));
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//            boardBulletinPanel.setBackground(Color.WHITE);
        mainPanel.setBackground(Color.WHITE);

        myChatPanel = new JPanel();
        myChatPanel.setPreferredSize(new Dimension(360, 100));
        myChatPanel.setLayout(new BoxLayout(myChatPanel, BoxLayout.Y_AXIS));
        myChatPanel.setBackground(Color.WHITE);

        myNameLabel = new JLabel(myName);
        myNameLabel.setFont(fontExtraBold);
        myNameLabel.setForeground(Color.BLACK);
        myNameLabel.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(10, 20, 10, 0),
                myNameLabel.getBorder()
        ));
        myChat = new JLabel(myChatst);
        myChat.setFont(fontRegular);
        myChat.setForeground(Color.BLACK);
        myChat.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(0, 20, 0, 0),
                myChat.getBorder()
        ));


        youChatPanel = new JPanel();
        youChatPanel.setPreferredSize(new Dimension(360, 100));
        youChatPanel.setLayout(new BoxLayout(youChatPanel, BoxLayout.Y_AXIS));
        youChatPanel.setBackground(mainColor);

        youNameLabel = new JLabel(youName);
        youNameLabel.setFont(fontExtraBold);
        youNameLabel.setForeground(Color.BLACK);
        youNameLabel.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(10, 20, 10, 0),
                youNameLabel.getBorder()
        ));
        youChat = new JLabel(youChatSt);
        youChat.setFont(fontRegular);
        youChat.setForeground(Color.BLACK);
        youChat.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(0, 20, 0, 0),
                youChat.getBorder()
        ));


        myChatPanel.add(myNameLabel);
        myChatPanel.add(myChat);
        youChatPanel.add(youNameLabel);
        youChatPanel.add(youChat);

        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(myChatPanel);
        mainPanel.add(youChatPanel);

        add(mainPanel);
        setVisible(true);
    }
}

