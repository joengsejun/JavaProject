package chap01;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Player extends JFrame {
	public static HitBoxCheck playerHitBox;
	public static int playerX = 20;
	public static int playerY = 570;
	public static int playerJump = 0;
	public static int playerAttack = 0;
	public static int playerIdle = 1;
	public static int playerHP;
	public static int playerMove = 0;
	public static boolean playerFlip = false;
	public Player() {
		reset();
		playerHitBox = new HitBoxCheck(20, 570, 200, 300);
		JLabel playerLabel = new JLabel();
		
		ImageIcon[] playerIcon = new ImageIcon[70];
		
		String[] playerIconString = new String[70];
		//0~7 = 공격;
		//8~47 = 걷기;
		//48~56 = idle(대기);
		//57~69 = 점프;
		for (int i = 0; i < playerIcon.length; i++) {
			if(i<10) {
				playerIconString[i] = ("img/player/player" + "0" + ".png");
				playerIconString[i] = (new StringBuffer(playerIconString[i]).insert(18, ("" + i))).toString();
			}else {
				playerIconString[i] = ("img/player/player" + ".png");
				playerIconString[i] = (new StringBuffer(playerIconString[i]).insert(17, ("" + i))).toString();
			}
		}
		for (int i = 0; i < playerIconString.length; i++) {
			playerIcon[i] = new ImageIcon(playerIconString[i]);
		}
		ImageIcon[] playerIconFlip = new ImageIcon[70];
		
		String[] playerIconFlipString = new String[70];
		//0~7 = 공격;
		//8~47 = 걷기;
		//48~56 = idle(대기);
		//57~69 = 점프;
		for (int i = 0; i < playerIconFlip.length; i++) {
			if(i<10) {
				playerIconFlipString[i] = ("img/playerFlip/player" + "0" + ".png");
				playerIconFlipString[i] = (new StringBuffer(playerIconFlipString[i]).insert(22, ("" + i))).toString();
			}else {
				playerIconFlipString[i] = ("img/playerFlip/player" + ".png");
				playerIconFlipString[i] = (new StringBuffer(playerIconFlipString[i]).insert(21, ("" + i))).toString();
			}
		}
		for (int i = 0; i < playerIconFlipString.length; i++) {
			playerIconFlip[i] = new ImageIcon(playerIconFlipString[i]);
		}

		playerLabel.setBounds(playerX, playerY, 200, 300);
		MainCode.mainPanel.add(playerLabel);
		// TODO Auto-generated constructor stub
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int sleepa;
				while (true) {
					sleepa = 100;
					if(MainCode.windowNum == 2 || MainCode.windowNum == 3) {
						if(playerIdle > 0) {
							playerIdle++;
							if(playerIdle>8) {
								playerIdle = 1;
							}
							if(playerFlip) {
								playerLabel.setIcon(playerIconFlip[(47+playerIdle)]);
							}else {
								playerLabel.setIcon(playerIcon[(47+playerIdle)]);
							}
						}else {
							if(playerMove > 0) {
								playerFlip = false;
								sleepa = 5;
								if(playerMove > 39) {
									playerMove = 1;
								}
								if(playerJump == 0 && playerAttack == 0) {
									playerLabel.setIcon(playerIcon[(7 + playerMove)]);
								}
								if(playerX < 1250) {
									playerX += 1;
								}
								playerLabel.setLocation(playerX, playerY);
							}else if(playerMove < 0) {
								playerFlip = true;
								sleepa = 5;
								if(playerMove < -39) {
									playerMove = -1;
								}
								if(playerJump == 0 && playerAttack == 0) {
									playerLabel.setIcon(playerIconFlip[(7 + (-1*playerMove))]);
								}
								if(playerX > 10) {
									playerX -= 1;
								}
								playerLabel.setLocation(playerX, playerY);
							}
						}
					}
					try {
						playerHitBox.HitBoxReset(playerX, playerY, 200, 300);
						Thread.sleep(sleepa);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				int sleep = 50;
				int jumpppp = 57;
				// TODO Auto-generated method stub
				while(true) {
					sleep = 50;
					if(MainCode.windowNum == 2 || MainCode.windowNum == 3) {
						if(playerJump > 0 && playerAttack == 0) {
							if(playerJump == 1) {
								if(playerFlip) {
									playerLabel.setIcon(playerIconFlip[jumpppp]);
								}else {
									playerLabel.setIcon(playerIcon[jumpppp]);
								}
								if(jumpppp < 59) {
									sleep = 20;
									jumpppp++;
								}else {
									sleep = 7;
								}
								playerY -= 2;
								if(playerY <= 470) {
									playerJump = 2;
								}
								playerLabel.setLocation(playerX, playerY);
							}else {
								sleep = 5;
								playerY += 2;
								if(playerY>=570) {
									playerJump = 0;
									playerMove = 0;
									playerIdle = 1;
									jumpppp = 57;
								}
								playerLabel.setLocation(playerX, playerY);
							}
						}
						if(playerAttack > 0 && playerJump == 0) {
							if(playerFlip) {
								playerLabel.setIcon(playerIconFlip[(playerAttack - 1)]);
							}else {
								playerLabel.setIcon(playerIcon[(playerAttack - 1)]);
							}
							sleep = 50;
							if(playerAttack >= 8) {
								if(playerMove == 0) {
									playerIdle++;
								}
								playerAttack = 0;
							}else {
								playerAttack++;
							}
						}
					}
					try {
						playerHitBox.HitBoxReset(playerX, playerY, 200, 300);
						Thread.sleep(sleep);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}).start();
	}
	void reset() {
		playerX = 20;
		playerY = 570;
		playerJump = 0;
		playerAttack = 0;
		playerIdle = 1;
		playerMove = 0;
		playerFlip = false;
	}
}
