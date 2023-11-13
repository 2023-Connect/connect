import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChatPage {

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
            JPanel chatGroupPanel;






    // font
    Font fontBlack = con.getFontBlack();
    Font fontMedium = con.getFontMedium();

    // image
    ImageIcon chatImg = new ImageIcon("./Image/Button_Image/chat_here.png");
    ImageIcon boardImg = new ImageIcon("./Image/Button_Image/board.png");
    ImageIcon searchImg = new ImageIcon("./Image/Button_Image/search.png");
    ImageIcon myPageImg = new ImageIcon("./Image/Button_Image/myPage.png");


    ImageIcon plusImg = new ImageIcon("./Image/icon/plus.png");

    public ChatPage () throws IOException, FontFormatException {
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
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            new SearchPage();
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
        boardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            new BulletinPage();
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
                            new MyPage();
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
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(603, 640));
        chatTitlePanel = new JPanel();
        chatTitlePanel.setLayout(new BorderLayout());
        chatTitlePanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 35));
        chatTitleLabel = new JLabel(chat);
        chatTitleLabel.setFont(fontBlack);


        chatAddBtn = new JButton(plusImg);
        chatAddBtn.setBackground(Color.WHITE);
        chatAddBtn.setBorderPainted(false);

        chatGroupPanel = new JPanel();
        chatGroupPanel.setLayout(new BoxLayout(chatGroupPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < 10; i++ ) {
            chatRoomPanel chatRoomPanel = new chatRoomPanel();
            chatGroupPanel.add(chatRoomPanel);
        }


        scrollPane = new JScrollPane(chatGroupPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);

        // setBackground
        chatTitlePanel.setBackground(Color.WHITE);
        mainPanel.setBackground(Color.WHITE);



        // add
        chatTitlePanel.add(chatTitleLabel, BorderLayout.WEST);
        chatTitlePanel.add(chatAddBtn, BorderLayout.EAST);

        mainPanel.add(chatTitlePanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        mainFrame.add(sidePanel, BorderLayout.WEST);
        mainFrame.add(mainPanel, BorderLayout.EAST);
        mainFrame.setVisible(true);
    }


    // main
    public static void main(String[] args) throws IOException, FontFormatException {
        new ChatPage();
    }
}
