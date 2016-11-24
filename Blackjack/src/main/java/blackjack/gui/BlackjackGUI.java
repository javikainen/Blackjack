package blackjack.gui;

import blackjack.logic.BlackjackLogic;
import blackjack.logic.Card;
import blackjack.logic.Hand;
import blackjack.logic.Player;
import javax.swing.JTextField;

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
    private Phase state;
    private Player currentPlayer;

    public BlackjackGUI() {
        initComponents();
        this.gameLogic = new BlackjackLogic(0, 1, 1000);
        this.userBet = 0;
        this.playerMoneyPane.setText(Integer.toString(gameLogic.getPlayers().get(0).getMoney()));
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
        dealerHandLabel = new javax.swing.JLabel();
        dealerHandField = new javax.swing.JTextField();
        player1HandLabel = new javax.swing.JLabel();
        player1HandField = new javax.swing.JTextField();
        betLabel = new javax.swing.JLabel();
        currentBetField = new javax.swing.JTextField();
        zeroBetButton = new javax.swing.JButton();
        betAdd5Button = new javax.swing.JButton();
        betAdd10Button = new javax.swing.JButton();
        hitButton = new javax.swing.JButton();
        standButton = new javax.swing.JButton();
        dealButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerMoneyPane = new javax.swing.JTextPane();
        betLabel1 = new javax.swing.JLabel();
        player1HandLabel1 = new javax.swing.JLabel();
        playerHandValue = new javax.swing.JTextField();
        dealerHandValue = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel.setBackground(new java.awt.Color(20, 109, 48));
        jPanel.setPreferredSize(new java.awt.Dimension(1024, 768));

        dealerHandLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        dealerHandLabel.setText("Dealer Hand");

        dealerHandField.setEditable(false);
        dealerHandField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        player1HandLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        player1HandLabel.setText("Player Hand");

        player1HandField.setEditable(false);
        player1HandField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        betLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        betLabel.setLabelFor(currentBetField);
        betLabel.setText("Bet");

        currentBetField.setEditable(false);
        currentBetField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        currentBetField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        currentBetField.setText("0");

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

        betAdd10Button.setText("10");
        betAdd10Button.setEnabled(false);
        betAdd10Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betAdd10ButtonActionPerformed(evt);
            }
        });

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

        dealButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dealButton.setText("Deal");
        dealButton.setEnabled(false);
        dealButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(playerMoneyPane);

        betLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        betLabel1.setLabelFor(currentBetField);
        betLabel1.setText("Player Money");

        player1HandLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N

        playerHandValue.setEditable(false);
        playerHandValue.setBackground(new java.awt.Color(20, 109, 48));
        playerHandValue.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        playerHandValue.setBorder(null);
        playerHandValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerHandValueActionPerformed(evt);
            }
        });

        dealerHandValue.setEditable(false);
        dealerHandValue.setBackground(new java.awt.Color(20, 109, 48));
        dealerHandValue.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        dealerHandValue.setBorder(null);
        dealerHandValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealerHandValueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(betLabel)
                            .addComponent(currentBetField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(dealButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(zeroBetButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addComponent(betAdd5Button)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(betAdd10Button))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)))
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(player1HandLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(player1HandLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(playerHandValue))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(dealerHandLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dealerHandValue))
                    .addComponent(player1HandField, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addComponent(dealerHandField))
                .addGap(59, 59, 59)
                .addComponent(hitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(standButton)
                .addContainerGap(385, Short.MAX_VALUE))
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(betLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap(311, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dealerHandLabel)
                            .addComponent(dealerHandValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dealerHandField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(244, 244, 244)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(player1HandLabel)
                            .addComponent(player1HandLabel1)
                            .addComponent(playerHandValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(player1HandField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(standButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(betLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(betLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentBetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(betAdd10Button)
                            .addComponent(betAdd5Button)
                            .addComponent(zeroBetButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dealButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitButtonActionPerformed
        currentPlayer.addCard(gameLogic.dealCard());
        displayHand(getPlayArea(currentPlayer), currentPlayer.getHand());
        if (currentPlayer.getHand().isBust()) {
            nextPhase(Phase.PLAY);
        }
    }//GEN-LAST:event_hitButtonActionPerformed

    private void zeroBetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroBetButtonActionPerformed
        this.userBet = 0;
        this.currentBetField.setText(Integer.toString(this.userBet));
    }//GEN-LAST:event_zeroBetButtonActionPerformed

    private void betAdd5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betAdd5ButtonActionPerformed
        this.userBet += 5;
        this.currentBetField.setText(Integer.toString(this.userBet));
    }//GEN-LAST:event_betAdd5ButtonActionPerformed

    private void betAdd10ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betAdd10ButtonActionPerformed
        this.userBet += 10;
        this.currentBetField.setText(Integer.toString(this.userBet));
    }//GEN-LAST:event_betAdd10ButtonActionPerformed

    private void dealButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealButtonActionPerformed
        gameLogic.setBets(this.userBet);
        this.playerMoneyPane.setText(Integer.toString(gameLogic.getPlayers().get(0).getMoney()));
        nextPhase(Phase.DEAL);
    }//GEN-LAST:event_dealButtonActionPerformed

    private void standButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standButtonActionPerformed
        nextPhase(Phase.PLAY);
    }//GEN-LAST:event_standButtonActionPerformed

    private void playerHandValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerHandValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerHandValueActionPerformed

    private void dealerHandValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealerHandValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dealerHandValueActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton betAdd10Button;
    private javax.swing.JButton betAdd5Button;
    private javax.swing.JLabel betLabel;
    private javax.swing.JLabel betLabel1;
    private javax.swing.JTextField currentBetField;
    private javax.swing.JButton dealButton;
    private javax.swing.JTextField dealerHandField;
    private javax.swing.JLabel dealerHandLabel;
    private javax.swing.JTextField dealerHandValue;
    private javax.swing.JButton hitButton;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField player1HandField;
    private javax.swing.JLabel player1HandLabel;
    private javax.swing.JLabel player1HandLabel1;
    private javax.swing.JTextField playerHandValue;
    private javax.swing.JTextPane playerMoneyPane;
    private javax.swing.JButton standButton;
    private javax.swing.JButton zeroBetButton;
    // End of variables declaration//GEN-END:variables

    public void displayHand(JTextField area, Hand hand) {
        StringBuilder handBuilder = new StringBuilder();
        for (Card card : hand.getContents()) {
            handBuilder.append(card.getSuit()).append(card.getRank()).append(", ");
        }
        handBuilder.delete(handBuilder.length() - 2, handBuilder.length());
        if (area == dealerHandField && state == Phase.DEAL) {
            handBuilder.replace(0, 3, "??"); // Hide the "hole card"
        }
        area.setText(handBuilder.toString());
    }

    private JTextField getPlayArea(Player player) {
        switch (player.getID()) {
            case 0:
                return player1HandField;
        }
        return null;
    }

    public void nextPhase(Phase phase) {
        this.state = phase;
        setButtons();
        switch (this.state) {
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
            case DEALER_TURN:
                gameLogic.playDealerHand();
                displayHand(dealerHandField, gameLogic.getDealerHand());
                nextPhase(Phase.PAY);
                break;
            case PAY:
                payPhase();
        }
    }

    private void dealPhase() {
        playerHandValue.setText("");
        dealerHandValue.setText("");
        gameLogic.deal();
        for (Player player : gameLogic.getPlayers()) {
            displayHand(getPlayArea(player), player.getHand());
        }
        displayHand(dealerHandField, gameLogic.getDealerHand());
        nextPhase(Phase.PLAY);
    }

    private void playPhase() {
        while (true) {
            currentPlayer = gameLogic.getNextPlayer();
            if (currentPlayer == null) {
                nextPhase(Phase.DEALER_TURN);
                break;
            } else if (currentPlayer.isAI()) {
                gameLogic.playAIHand(currentPlayer);
            } else {
                nextPhase(Phase.USER_TURN);
                break;
            }
            displayHand(getPlayArea(currentPlayer), currentPlayer.getHand());
        }
    }

    private void payPhase() {
        playerHandValue.setText(Integer.toString(gameLogic.getPlayers().get(0).getHand().getValue()));
        dealerHandValue.setText(Integer.toString(gameLogic.getDealerHand().getValue()));
        gameLogic.payWinnings();
        playerMoneyPane.setText(Integer.toString(gameLogic.getPlayers().get(0).getMoney()));
        nextPhase(Phase.BET);
    }

    private void setButtons() {
        switch (this.state) {
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
            case DEALER_TURN:
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
