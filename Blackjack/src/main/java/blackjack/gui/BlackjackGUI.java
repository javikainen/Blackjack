package blackjack.gui;

import blackjack.logic.BlackjackLogic;
import blackjack.logic.Card;
import blackjack.logic.Hand;
import blackjack.logic.Player;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class creates the GUI and controls the flow of the program.
 *
 * @author Jari Avikainen
 */
public class BlackjackGUI extends javax.swing.JFrame {

    private final BlackjackLogic gameLogic;
    private int userBet;
    private Phase phase;
    private Player player;
    private Player humanPlayer;
    private CardMap cardImages;

    // Settings for the game
    private int numberOfAIPlayers = 2;
    private int startingMoney = 1000;
    private int numberOfDecks = 2;
    private String cardColor = "red";

    /**
     * Creates the GUI and creates and initialises new BlackjackLogic using
     * current settings.
     */
    public BlackjackGUI() {
        initComponents();
        cardImages = new CardMap();
        this.gameLogic = new BlackjackLogic(numberOfAIPlayers, numberOfDecks, startingMoney);
        this.userBet = 0;

        List<Player> players = gameLogic.getPlayers();

        switch (numberOfAIPlayers) {
            case 2:
                this.AIHandPanel2.setVisible(true);
                this.AIHandPanel1.setVisible(true);
                this.AIHandLabel2.setText(players.get(0).getName());
                this.AIHandLabel1.setText(players.get(2).getName());
                this.humanPlayer = players.get(1);
                break;
            case 1:
                this.AIHandPanel1.setVisible(true);
                this.AIHandLabel1.setText(players.get(1).getName());
            case 0:
                this.humanPlayer = players.get(0);
        }
        this.playerMoneylabel.setText("Player money: " + this.humanPlayer.getMoney());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        AIHandPanel1 = new javax.swing.JPanel();
        AIHandLabel1 = new javax.swing.JLabel();
        AIHandValue1 = new javax.swing.JLabel();
        AICardPanel1 = new javax.swing.JPanel();
        hitButton = new javax.swing.JButton();
        standButton = new javax.swing.JButton();
        AIHandPanel2 = new javax.swing.JPanel();
        AIHandLabel2 = new javax.swing.JLabel();
        AIHandValue2 = new javax.swing.JLabel();
        AICardPanel2 = new javax.swing.JPanel();
        playerHandPanel = new javax.swing.JPanel();
        playerHandLabel = new javax.swing.JLabel();
        playerHandValue = new javax.swing.JLabel();
        playerCardPanel = new javax.swing.JPanel();
        playerMoneylabel = new javax.swing.JLabel();
        betPanel = new javax.swing.JPanel();
        betLabel = new javax.swing.JLabel();
        betAdd10Button = new javax.swing.JButton();
        zeroBetButton = new javax.swing.JButton();
        betAdd5Button = new javax.swing.JButton();
        dealButton = new javax.swing.JButton();
        dealerHandPanel = new javax.swing.JPanel();
        dealerHandLabel = new javax.swing.JLabel();
        dealerHandValue = new javax.swing.JLabel();
        dealerCardPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel.setBackground(new java.awt.Color(20, 109, 48));
        jPanel.setFocusable(false);
        jPanel.setPreferredSize(new java.awt.Dimension(1024, 768));
        jPanel.setRequestFocusEnabled(false);
        jPanel.setVerifyInputWhenFocusTarget(false);

        AIHandPanel1.setFocusable(false);
        AIHandPanel1.setOpaque(false);
        AIHandPanel1.setLayout(new java.awt.BorderLayout(10, 5));

        AIHandLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        AIHandLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AIHandLabel1.setText("AI 2");
        AIHandLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        AIHandPanel1.add(AIHandLabel1, java.awt.BorderLayout.CENTER);

        AIHandValue1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        AIHandValue1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AIHandValue1.setMinimumSize(new java.awt.Dimension(38, 30));
        AIHandValue1.setPreferredSize(new java.awt.Dimension(38, 30));
        AIHandPanel1.add(AIHandValue1, java.awt.BorderLayout.SOUTH);

        AICardPanel1.setBackground(new java.awt.Color(20, 109, 48));
        AICardPanel1.setMinimumSize(new java.awt.Dimension(91, 126));
        AICardPanel1.setPreferredSize(new java.awt.Dimension(369, 126));
        AICardPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, -50, 0));
        AIHandPanel1.add(AICardPanel1, java.awt.BorderLayout.NORTH);

        hitButton.setText("Hit");
        hitButton.setEnabled(false);
        hitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitButtonActionPerformed(evt);
            }
        });

        standButton.setText("Stand");
        standButton.setEnabled(false);
        standButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standButtonActionPerformed(evt);
            }
        });

        AIHandPanel2.setFocusable(false);
        AIHandPanel2.setOpaque(false);
        AIHandPanel2.setLayout(new java.awt.BorderLayout(10, 5));

        AIHandLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        AIHandLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AIHandLabel2.setText("AI 1");
        AIHandLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        AIHandPanel2.add(AIHandLabel2, java.awt.BorderLayout.CENTER);

        AIHandValue2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        AIHandValue2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AIHandValue2.setPreferredSize(new java.awt.Dimension(38, 30));
        AIHandPanel2.add(AIHandValue2, java.awt.BorderLayout.SOUTH);

        AICardPanel2.setBackground(new java.awt.Color(20, 109, 48));
        AICardPanel2.setMinimumSize(new java.awt.Dimension(91, 126));
        AICardPanel2.setPreferredSize(new java.awt.Dimension(369, 126));
        AICardPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, -50, 0));
        AIHandPanel2.add(AICardPanel2, java.awt.BorderLayout.NORTH);

        playerHandPanel.setFocusable(false);
        playerHandPanel.setOpaque(false);
        playerHandPanel.setLayout(new java.awt.BorderLayout(10, 5));

        playerHandLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        playerHandLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerHandLabel.setText("Player");
        playerHandLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        playerHandPanel.add(playerHandLabel, java.awt.BorderLayout.CENTER);

        playerHandValue.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        playerHandValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerHandValue.setPreferredSize(new java.awt.Dimension(38, 30));
        playerHandPanel.add(playerHandValue, java.awt.BorderLayout.SOUTH);

        playerCardPanel.setBackground(new java.awt.Color(20, 109, 48));
        playerCardPanel.setMinimumSize(new java.awt.Dimension(91, 126));
        playerCardPanel.setPreferredSize(new java.awt.Dimension(369, 126));
        playerCardPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, -50, 0));
        playerHandPanel.add(playerCardPanel, java.awt.BorderLayout.NORTH);

        playerMoneylabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        playerMoneylabel.setText("Player Money: 0");

        betPanel.setOpaque(false);

        betLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        betLabel.setText("Bet: 0");

        betAdd10Button.setText("10");
        betAdd10Button.setEnabled(false);
        betAdd10Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betAdd10ButtonActionPerformed(evt);
            }
        });

        zeroBetButton.setText("0");
        zeroBetButton.setEnabled(false);
        zeroBetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroBetButtonActionPerformed(evt);
            }
        });

        betAdd5Button.setText("5");
        betAdd5Button.setEnabled(false);
        betAdd5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betAdd5ButtonActionPerformed(evt);
            }
        });

        dealButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dealButton.setText("Deal");
        dealButton.setEnabled(false);
        dealButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout betPanelLayout = new javax.swing.GroupLayout(betPanel);
        betPanel.setLayout(betPanelLayout);
        betPanelLayout.setHorizontalGroup(
            betPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(betPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(betPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(betPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(dealButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(betPanelLayout.createSequentialGroup()
                        .addComponent(zeroBetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(betPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(betLabel)
                            .addGroup(betPanelLayout.createSequentialGroup()
                                .addComponent(betAdd5Button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(betAdd10Button))))))
        );
        betPanelLayout.setVerticalGroup(
            betPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(betPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(betLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(betPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(betAdd10Button)
                    .addComponent(betAdd5Button)
                    .addComponent(zeroBetButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dealButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        dealerHandPanel.setFocusable(false);
        dealerHandPanel.setOpaque(false);
        dealerHandPanel.setLayout(new java.awt.BorderLayout(10, 5));

        dealerHandLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        dealerHandLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dealerHandLabel.setText("Dealer");
        dealerHandLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dealerHandPanel.add(dealerHandLabel, java.awt.BorderLayout.CENTER);

        dealerHandValue.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        dealerHandValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dealerHandValue.setPreferredSize(new java.awt.Dimension(38, 30));
        dealerHandPanel.add(dealerHandValue, java.awt.BorderLayout.SOUTH);

        dealerCardPanel.setBackground(new java.awt.Color(20, 109, 48));
        dealerCardPanel.setMinimumSize(new java.awt.Dimension(91, 126));
        dealerCardPanel.setPreferredSize(new java.awt.Dimension(369, 126));
        dealerCardPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, -50, 0));
        dealerHandPanel.add(dealerCardPanel, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(AIHandPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AIHandPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(playerMoneylabel)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(playerHandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(287, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hitButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(standButton)
                                .addGap(379, 379, 379))))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(betPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(806, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dealerHandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(338, 338, 338))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dealerHandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AIHandPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AIHandPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(playerHandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(standButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(playerMoneylabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(betPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitButtonActionPerformed
        gameLogic.dealCard(player);
        displayHand(getPlayArea(player), player.getHand());
        if (player.getHand().isBust()) {
            nextPhase(Phase.PLAY);
        }
    }//GEN-LAST:event_hitButtonActionPerformed

    private void standButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standButtonActionPerformed
        nextPhase(Phase.PLAY);
    }//GEN-LAST:event_standButtonActionPerformed

    private void dealButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealButtonActionPerformed
        gameLogic.adjustBets(this.userBet);
        nextPhase(Phase.DEAL);
    }//GEN-LAST:event_dealButtonActionPerformed

    private void betAdd5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betAdd5ButtonActionPerformed
        if (humanPlayer.getMoney() >= 5) {
            humanPlayer.setCurrentBet(humanPlayer.getCurrentBet() + 5);
            humanPlayer.takeMoney(5);
            this.userBet += 5;
            this.betLabel.setText("Bet: " + this.userBet);
            this.playerMoneylabel.setText("Player money: " + humanPlayer.getMoney());
        }
    }//GEN-LAST:event_betAdd5ButtonActionPerformed

    private void zeroBetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroBetButtonActionPerformed
        humanPlayer.setCurrentBet(0);
        humanPlayer.addMoney(this.userBet);
        this.userBet = 0;
        this.betLabel.setText("Bet: " + this.userBet);
        this.playerMoneylabel.setText("Player money: " + humanPlayer.getMoney());
    }//GEN-LAST:event_zeroBetButtonActionPerformed

    private void betAdd10ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betAdd10ButtonActionPerformed
        if (humanPlayer.getMoney() >= 10) {
            humanPlayer.setCurrentBet(humanPlayer.getCurrentBet() + 10);
            humanPlayer.takeMoney(10);
            this.userBet += 10;
            this.betLabel.setText("Bet: " + this.userBet);
            this.playerMoneylabel.setText("Player money: " + humanPlayer.getMoney());
        }
    }//GEN-LAST:event_betAdd10ButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AICardPanel1;
    private javax.swing.JPanel AICardPanel2;
    private javax.swing.JLabel AIHandLabel1;
    private javax.swing.JLabel AIHandLabel2;
    private javax.swing.JPanel AIHandPanel1;
    private javax.swing.JPanel AIHandPanel2;
    private javax.swing.JLabel AIHandValue1;
    private javax.swing.JLabel AIHandValue2;
    private javax.swing.JButton betAdd10Button;
    private javax.swing.JButton betAdd5Button;
    private javax.swing.JLabel betLabel;
    private javax.swing.JPanel betPanel;
    private javax.swing.JButton dealButton;
    private javax.swing.JPanel dealerCardPanel;
    private javax.swing.JLabel dealerHandLabel;
    private javax.swing.JPanel dealerHandPanel;
    private javax.swing.JLabel dealerHandValue;
    private javax.swing.JButton hitButton;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel playerCardPanel;
    private javax.swing.JLabel playerHandLabel;
    private javax.swing.JPanel playerHandPanel;
    private javax.swing.JLabel playerHandValue;
    private javax.swing.JLabel playerMoneylabel;
    private javax.swing.JButton standButton;
    private javax.swing.JButton zeroBetButton;
    // End of variables declaration//GEN-END:variables

    /**
     * Starts the game using the current game settings
     *
     */
    public void startGame() {
        nextPhase(Phase.BET);
    }

    private void nextPhase(Phase phase) {
        this.phase = phase;
        setButtons();
        switch (this.phase) {
            case BET:
                break;
            case DEAL:
                dealPhase();
                break;
            case PLAY:
                playPhase();
                break;
            case USER_TURN:
                break;
            case PAY:
                payPhase();
        }
    }

    private void setButtons() {
        betAdd5Button.setEnabled(false);
        betAdd10Button.setEnabled(false);
        dealButton.setEnabled(false);
        hitButton.setEnabled(false);
        standButton.setEnabled(false);
        zeroBetButton.setEnabled(false);
        switch (this.phase) {
            case BET:
                betAdd5Button.setEnabled(true);
                betAdd10Button.setEnabled(true);
                dealButton.setEnabled(true);
                zeroBetButton.setEnabled(true);
                break;
            case USER_TURN:
                hitButton.setEnabled(true);
                standButton.setEnabled(true);
            default:
        }
    }

    private void displayHand(JPanel area, Hand hand) {
        area.removeAll();
        if (area == dealerCardPanel && phase == Phase.DEAL) {
            area.add(new ImagePanel(cardImages.getCardBack(cardColor)));
            area.add(new ImagePanel(cardImages.getCardImage(hand.getContents().get(1))), 0);
        } else {
            for (Card card : hand.getContents()) {
                area.add(new ImagePanel(cardImages.getCardImage(card)), 0);
            }
        }
        area.validate();
    }

    private JPanel getPlayArea(Player player) {
        switch (player.getID()) {
            case 0:
                return AICardPanel2;
            case 1:
                return playerCardPanel;
            case 2:
                return AICardPanel1;
            case 3:
                return dealerCardPanel;
        }
        return null;
    }

    private JLabel getHandValueLabel(Player player) {
        switch (player.getID()) {
            case 0:
                return AIHandValue2;
            case 1:
                return playerHandValue;
            case 2:
                return AIHandValue1;
            case 3:
                return dealerHandValue;
        }
        return null;
    }

    private void dealPhase() {
        for (Player player : gameLogic.getPlayers()) {
            getHandValueLabel(player).setText("");
            JPanel area = getPlayArea(player);
            area.setEnabled(false);
        }
        gameLogic.deal();
        for (Player player : gameLogic.getPlayers()) {
            JPanel area = getPlayArea(player);
            area.setEnabled(true);
            displayHand(area, player.getHand());
        }
        nextPhase(Phase.PLAY);
    }

    private void playPhase() {
        while (true) {
            player = gameLogic.getNextPlayer();
            if (player == null) {
                nextPhase(Phase.PAY);
                break;
            } else if (player.isAI()) {
                gameLogic.playAIHand(player);
            } else {
                nextPhase(Phase.USER_TURN);
                break;
            }
            displayHand(getPlayArea(player), player.getHand());
        }
    }

    private void payPhase() {
        for (Player player : gameLogic.getPlayers()) {
            String result;
            if (player.getHand().isBlackJack()) {
                result = "Blackjack!";
            } else if (player.getHand().isBust()) {
                result = "Bust!";
            } else {
                result = Integer.toString(player.getHand().getValue());
            }
            getHandValueLabel(player).setText(result);
        }
        gameLogic.payWinnings();
        playerMoneylabel.setText("Player money: " + humanPlayer.getMoney());
        this.userBet = humanPlayer.getCurrentBet();
        this.betLabel.setText("Bet: " + this.userBet);
        nextPhase(Phase.BET);
    }

}
