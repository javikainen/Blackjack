package blackjack.gui;

import blackjack.logic.BlackjackLogic;
import blackjack.logic.Card;
import blackjack.logic.Hand;
import blackjack.logic.Player;
import java.util.List;
import javax.swing.JLabel;

/**
 * This class creates the GUI and controls the flow of the program.
 *
 * @author Jari Avikainen
 */
public class BlackjackGUI extends javax.swing.JFrame {

    /**
     * Creates new form BlackjackGUI
     */
    private final BlackjackLogic gameLogic;

    private int userBet;
    private Phase phase;
    private Player player;
    private int numberOfAIPlayers = 2;
    private int startingMoney = 1000;
    private int numberOfDecks = 2;
    private Player humanPlayer;

    public BlackjackGUI() {
        initComponents();
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
        hitButton = new javax.swing.JButton();
        standButton = new javax.swing.JButton();
        playerHandPanel = new javax.swing.JPanel();
        playerHandLabel = new javax.swing.JLabel();
        playerHandValue = new javax.swing.JLabel();
        playerHandContents = new javax.swing.JLabel();
        playerMoneylabel = new javax.swing.JLabel();
        betPanel = new javax.swing.JPanel();
        betLabel = new javax.swing.JLabel();
        betAdd10Button = new javax.swing.JButton();
        zeroBetButton = new javax.swing.JButton();
        betAdd5Button = new javax.swing.JButton();
        dealButton = new javax.swing.JButton();
        AIHandPanel1 = new javax.swing.JPanel();
        AIHandLabel1 = new javax.swing.JLabel();
        AIHandValue1 = new javax.swing.JLabel();
        AIHandContents1 = new javax.swing.JLabel();
        AIHandPanel2 = new javax.swing.JPanel();
        AIHandLabel2 = new javax.swing.JLabel();
        AIHandValue2 = new javax.swing.JLabel();
        AIHandContents2 = new javax.swing.JLabel();
        dealerHandPanel = new javax.swing.JPanel();
        dealerHandLabel = new javax.swing.JLabel();
        dealerHandValue = new javax.swing.JLabel();
        dealerHandContents = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel.setBackground(new java.awt.Color(20, 109, 48));
        jPanel.setFocusable(false);
        jPanel.setPreferredSize(new java.awt.Dimension(1024, 768));
        jPanel.setRequestFocusEnabled(false);
        jPanel.setVerifyInputWhenFocusTarget(false);

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

        playerHandPanel.setFocusable(false);
        playerHandPanel.setOpaque(false);

        playerHandLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        playerHandLabel.setText("Player");

        playerHandValue.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N

        playerHandContents.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        playerHandContents.setFocusable(false);

        javax.swing.GroupLayout playerHandPanelLayout = new javax.swing.GroupLayout(playerHandPanel);
        playerHandPanel.setLayout(playerHandPanelLayout);
        playerHandPanelLayout.setHorizontalGroup(
            playerHandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerHandPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playerHandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerHandContents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(playerHandPanelLayout.createSequentialGroup()
                        .addComponent(playerHandLabel)
                        .addGap(18, 18, 18)
                        .addComponent(playerHandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 40, Short.MAX_VALUE)))
                .addContainerGap())
        );
        playerHandPanelLayout.setVerticalGroup(
            playerHandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerHandPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playerHandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerHandLabel)
                    .addComponent(playerHandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerHandContents, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
                .addContainerGap())
        );

        AIHandPanel1.setFocusable(false);
        AIHandPanel1.setOpaque(false);
        AIHandPanel1.setVisible(false);

        AIHandLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        AIHandLabel1.setText("AI 2");

        AIHandValue1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N

        AIHandContents1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        AIHandContents1.setFocusable(false);

        javax.swing.GroupLayout AIHandPanel1Layout = new javax.swing.GroupLayout(AIHandPanel1);
        AIHandPanel1.setLayout(AIHandPanel1Layout);
        AIHandPanel1Layout.setHorizontalGroup(
            AIHandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AIHandPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AIHandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AIHandContents1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(AIHandPanel1Layout.createSequentialGroup()
                        .addComponent(AIHandLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(AIHandValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AIHandPanel1Layout.setVerticalGroup(
            AIHandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AIHandPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AIHandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AIHandLabel1)
                    .addComponent(AIHandValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AIHandContents1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        AIHandPanel2.setFocusable(false);
        AIHandPanel2.setOpaque(false);
        AIHandPanel2.setVisible(false);

        AIHandLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        AIHandLabel2.setText("AI 1");

        AIHandValue2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N

        AIHandContents2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        AIHandContents2.setFocusable(false);

        javax.swing.GroupLayout AIHandPanel2Layout = new javax.swing.GroupLayout(AIHandPanel2);
        AIHandPanel2.setLayout(AIHandPanel2Layout);
        AIHandPanel2Layout.setHorizontalGroup(
            AIHandPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AIHandPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AIHandPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AIHandContents2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(AIHandPanel2Layout.createSequentialGroup()
                        .addComponent(AIHandLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(AIHandValue2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AIHandPanel2Layout.setVerticalGroup(
            AIHandPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AIHandPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AIHandPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AIHandLabel2)
                    .addComponent(AIHandValue2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AIHandContents2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dealerHandPanel.setFocusable(false);
        dealerHandPanel.setOpaque(false);

        dealerHandLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        dealerHandLabel.setText("Dealer");

        dealerHandValue.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N

        dealerHandContents.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        dealerHandContents.setFocusable(false);

        javax.swing.GroupLayout dealerHandPanelLayout = new javax.swing.GroupLayout(dealerHandPanel);
        dealerHandPanel.setLayout(dealerHandPanelLayout);
        dealerHandPanelLayout.setHorizontalGroup(
            dealerHandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dealerHandPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dealerHandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dealerHandContents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dealerHandPanelLayout.createSequentialGroup()
                        .addComponent(dealerHandLabel)
                        .addGap(18, 18, 18)
                        .addComponent(dealerHandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dealerHandPanelLayout.setVerticalGroup(
            dealerHandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dealerHandPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dealerHandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dealerHandLabel)
                    .addComponent(dealerHandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dealerHandContents, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerMoneylabel)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(betPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hitButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(standButton)
                                .addGap(160, 160, 160))))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(438, 438, 438)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dealerHandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerHandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(325, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(AIHandPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AIHandPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AIHandPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AIHandPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                        .addComponent(playerMoneylabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(betPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(dealerHandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playerHandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(standButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
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
        player.addCard(gameLogic.dealCard());
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
        this.playerMoneylabel.setText("Player money: " + humanPlayer.getMoney());
        nextPhase(Phase.DEAL);
    }//GEN-LAST:event_dealButtonActionPerformed

    private void betAdd5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betAdd5ButtonActionPerformed
        this.userBet += 5;
        this.betLabel.setText("Bet: " + this.userBet);
    }//GEN-LAST:event_betAdd5ButtonActionPerformed

    private void zeroBetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroBetButtonActionPerformed
        this.userBet = 0;
        this.betLabel.setText("Bet: " + this.userBet);
    }//GEN-LAST:event_zeroBetButtonActionPerformed

    private void betAdd10ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betAdd10ButtonActionPerformed
        this.userBet += 10;
        this.betLabel.setText("Bet: " + this.userBet);
    }//GEN-LAST:event_betAdd10ButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AIHandContents1;
    private javax.swing.JLabel AIHandContents2;
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
    private javax.swing.JLabel dealerHandContents;
    private javax.swing.JLabel dealerHandLabel;
    private javax.swing.JPanel dealerHandPanel;
    private javax.swing.JLabel dealerHandValue;
    private javax.swing.JButton hitButton;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel playerHandContents;
    private javax.swing.JLabel playerHandLabel;
    private javax.swing.JPanel playerHandPanel;
    private javax.swing.JLabel playerHandValue;
    private javax.swing.JLabel playerMoneylabel;
    private javax.swing.JButton standButton;
    private javax.swing.JButton zeroBetButton;
    // End of variables declaration//GEN-END:variables

    public void displayHand(JLabel area, Hand hand) {
        StringBuilder handBuilder = new StringBuilder();
        for (Card card : hand.getContents()) {
            handBuilder.append(card.getSuit()).append(card.getRank()).append(", ");
        }
        handBuilder.delete(handBuilder.length() - 2, handBuilder.length());
        if (area == dealerHandContents && phase == Phase.DEAL) {
            handBuilder.replace(0, 4, "    "); // Hide the "hole card"
        }
        area.setText(handBuilder.toString());
    }

    private JLabel getPlayArea(Player player) {
        switch (player.getID()) {
            case 0:
                return AIHandContents2;
            case 1:
                return playerHandContents;
            case 2:
                return AIHandContents1;
            case 3:
                return dealerHandContents;
        }
        return null;
    }
    
    private JLabel handValueLabel(Player player) {
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

    public void nextPhase(Phase phase) {
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

    private void dealPhase() {
        for (Player player : gameLogic.getPlayers()) {
            handValueLabel(player).setText("");
        }
        gameLogic.deal();
        for (Player player : gameLogic.getPlayers()) {
            displayHand(getPlayArea(player), player.getHand());
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
            handValueLabel(player).setText(result);
        }
        gameLogic.payWinnings();
        playerMoneylabel.setText("Player money: " + humanPlayer.getMoney());
        nextPhase(Phase.BET);
    }

    private void setButtons() {
        switch (this.phase) {
            case BET:
                betAdd5Button.setEnabled(true);
                betAdd10Button.setEnabled(true);
                dealButton.setEnabled(true);
                hitButton.setEnabled(false);
                standButton.setEnabled(false);
                zeroBetButton.setEnabled(true);
                break;
            case USER_TURN:
                betAdd5Button.setEnabled(false);
                betAdd10Button.setEnabled(false);
                dealButton.setEnabled(false);
                hitButton.setEnabled(true);
                standButton.setEnabled(true);
                zeroBetButton.setEnabled(false);
                break;
            case DEAL:
            case PAY:
            case PLAY:
                betAdd5Button.setEnabled(false);
                betAdd10Button.setEnabled(false);
                dealButton.setEnabled(false);
                hitButton.setEnabled(false);
                standButton.setEnabled(false);
                zeroBetButton.setEnabled(false);
                break;
        }
    }
}
