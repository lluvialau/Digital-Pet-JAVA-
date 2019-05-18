
package GUI;

import DATA.UserData;
import Model.Boss;
import Model.Pet;
import Model.User;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * user interface form for VS platform
 * 
 * @author Yu Liu
 */
public class FightDialog extends javax.swing.JDialog {

    private UserData userData;

    /**
     * Creates a GUI for VS platform
     * @param parent 
     * @param modal
     * @param i  
     */
    public FightDialog(java.awt.Frame parent, boolean modal, int i) {

        super(parent, modal);
        userData = UserData.getInstance();
        initComponents();
        userDao = UserData.getInstance();
        userDao.getLoginUser().setStatus("fight");
        loadBossImage("Files/easy_boss.jpg");
        ImageIcon imageIcon;
        System.out.println("" + i);
        showPicture();
        WindowUtil.center(this);
    }

    /**
     * the method to show picture of VS
     */
    public void showPicture() {
        String kind = userData.getLoginUser().getKind();
        String fileName = "/Files/" +"s"+ kind + ".gif";
        loadPetImage(fileName);
    }

    /**
     * the method to load pet picture
     * 
     * @param fileName the game object to reprent name of pet
     */
    private void loadPetImage(String fileName) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(fileName));
        labelPet.setIcon(imageIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupFight = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        labelPet = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelBoss = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaMessage = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        radioButtonEasy = new javax.swing.JRadioButton();
        radioButtonNormal = new javax.swing.JRadioButton();
        radioButtonDifficult = new javax.swing.JRadioButton();
        buttonFight = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fight");
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel2.setToolTipText("");
        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        labelPet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(labelPet);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VS");
        jPanel2.add(jLabel1);

        labelBoss.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBoss.setPreferredSize(new java.awt.Dimension(0, 250));
        jPanel2.add(labelBoss);

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        textAreaMessage.setColumns(20);
        textAreaMessage.setRows(5);
        jScrollPane2.setViewportView(textAreaMessage);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        buttonGroupFight.add(radioButtonEasy);
        radioButtonEasy.setSelected(true);
        radioButtonEasy.setText("easy");
        radioButtonEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonEasyActionPerformed(evt);
            }
        });
        jPanel1.add(radioButtonEasy);

        buttonGroupFight.add(radioButtonNormal);
        radioButtonNormal.setText("normal");
        radioButtonNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonNormalActionPerformed(evt);
            }
        });
        jPanel1.add(radioButtonNormal);

        buttonGroupFight.add(radioButtonDifficult);
        radioButtonDifficult.setText("difficult");
        radioButtonDifficult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonDifficultActionPerformed(evt);
            }
        });
        jPanel1.add(radioButtonDifficult);

        buttonFight.setText("Fight");
        buttonFight.setPreferredSize(new java.awt.Dimension(80, 25));
        buttonFight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFightActionPerformed(evt);
            }
        });
        jPanel1.add(buttonFight);

        jButton1.setText("Exit");
        jButton1.setPreferredSize(new java.awt.Dimension(80, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);
        jPanel1.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonFightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFightActionPerformed
        User user = userDao.getLoginUser();
        Pet pet = user.getPet();
        if (pet.getHappiness() < 50) {
            JOptionPane.showMessageDialog(this, "happiness is not enough!");
            return;
        }
        buttonFight.setEnabled(false);
        new FightThread().start();
    }//GEN-LAST:event_buttonFightActionPerformed

    private void loadBossImage(String fileName) {
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource(fileName));
        labelBoss.setIcon(imageIcon);
    }

    private void radioButtonEasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonEasyActionPerformed
        loadBossImage("Files/easy_boss.jpg");
    }//GEN-LAST:event_radioButtonEasyActionPerformed

    private void radioButtonNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonNormalActionPerformed
        loadBossImage("Files/normal_boss.jpg");
    }//GEN-LAST:event_radioButtonNormalActionPerformed

    private void radioButtonDifficultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonDifficultActionPerformed
        loadBossImage("Files/difficult_boss.jpg");
    }//GEN-LAST:event_radioButtonDifficultActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFight;
    private javax.swing.ButtonGroup buttonGroupFight;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelBoss;
    private javax.swing.JLabel labelPet;
    private javax.swing.JRadioButton radioButtonDifficult;
    private javax.swing.JRadioButton radioButtonEasy;
    private javax.swing.JRadioButton radioButtonNormal;
    private javax.swing.JTextArea textAreaMessage;
    // End of variables declaration//GEN-END:variables
    private UserData userDao;

    private class FightThread extends Thread {

        // the method to show the message of game
        private void showMessage(String message) {
            textAreaMessage.append(message + "\n");
            textAreaMessage.setCaretPosition(textAreaMessage.getText().length());
        }

        @Override
        public void run() {
            User user = userDao.getLoginUser();
            Pet pet = user.getPet();
            userDao.setHappiness(user, pet.getHappiness() - 50);
            int level;
            // select level of game
            if (radioButtonEasy.isSelected()) {
                level = 1;
            } else if (radioButtonNormal.isSelected()) {
                level = 2;
            } else {
                level = 3;
            }
            Boss boss = new Boss(level);
            textAreaMessage.setText("");
            while (true) {
                pet.setStamina(pet.getStamina() - boss.getStrength());
                // bad dog win, pet failed
                if (pet.getStamina() <= 0) {
                    JOptionPane.showMessageDialog(FightDialog.this, "You failed!");
                    pet.setHappiness(0);
                    pet.setStamina(0);
                    break;
                }
                showMessage("Bad dog hit the pet casuse " + boss.getStrength() + " damage, The pet left " + pet.getStamina() + " health");
                boolean over = false;
                for (int i = 0; i < pet.getAgility() / 10; i++) {
                    boss.setStamina(boss.getStamina() - pet.getStrength());
                    // bad dog failed, pet win.
                    if (boss.getStamina() <= 0) {
                        showMessage("Bad dog Died. ");
                        showMessage("Pet won!");
                        userDao.addMoney(user, boss.getMoney());
                        over = true;
                        break;
                    }
                    showMessage("pet hit the baddog, casue " + pet.getStrength() + " damage, the bad dog left " + boss.getStamina() + " health");
                    UserData.playAudio();
                }
                if (over) {
                    break;
                }
            }
            buttonFight.setEnabled(true);
        }
    }

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //     System.out.println(""+gf.i);
    }
}