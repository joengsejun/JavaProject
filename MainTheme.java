package chap01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import javazoom.jl.player.MP3Player;

public class MainTheme extends JFrame{
	int nextPage = 0;
	public static boolean zPress = false;
	public MainTheme() {
		reset();
		JLabel start = new JLabel();
		JLabel introduce = new JLabel();
		JLabel theme = new JLabel();
		JLabel theme2 = new JLabel();
		JLabel blackBack1 = new JLabel();
		JLabel blackBack2 = new JLabel();
		JLabel gameTheme1 = new JLabel();
		JLabel gameTheme2 = new JLabel();
		JLabel textLabel = new JLabel();
		JLabel hpText = new JLabel();
		JLabel HP = new JLabel();
		JLabel bossHpText = new JLabel();
		JLabel bossHP = new JLabel();
		JLabel endText = new JLabel();
		JLabel END = new JLabel();
		
		ImageIcon startIcon = new ImageIcon("img/startButton.png");
		ImageIcon startIconHover = new ImageIcon("img/startButton_hover.png");
		ImageIcon howIcon = new ImageIcon("img/howButton.png");
		ImageIcon howIconHover = new ImageIcon("img/howButton_hover.png");
		ImageIcon themeIcon = new ImageIcon("img/mainTheme.gif");
		ImageIcon themeIcon2 = new ImageIcon("img/mainTheme2.png");
		ImageIcon black1 = new ImageIcon("img/blackBackground1.png");
		ImageIcon black2 = new ImageIcon("img/blackBackground2.png");
		ImageIcon endIcon = new ImageIcon("img/END.png");
		ImageIcon[] gameThemeIcon = new ImageIcon[41];
		
		String[] gameThemeIconString = new String[41];
		
		for (int i = 0; i < gameThemeIcon.length; i++) {
			if(i<10) {
				gameThemeIconString[i] = ("img/backGround/backGround" + "0" + ".png");
				gameThemeIconString[i] = (new StringBuffer(gameThemeIconString[i]).insert(26, ("" + i))).toString();
			}else {
				gameThemeIconString[i] = ("img/backGround/backGround" + ".png");
				gameThemeIconString[i] = (new StringBuffer(gameThemeIconString[i]).insert(25, ("" + i))).toString();
			}
		}
		
		for (int i = 0; i < gameThemeIcon.length; i++) {
			gameThemeIcon[i] = new ImageIcon(gameThemeIconString[i]);
		}

		theme.setBounds(0, 0, themeIcon.getIconWidth(), themeIcon.getIconHeight());
		theme.setIcon(themeIcon);
		theme2.setBounds(0, 0, themeIcon2.getIconWidth(), themeIcon2.getIconHeight());
		theme2.setIcon(themeIcon2);
		start.setBounds(1000, 800, startIcon.getIconWidth(), startIcon.getIconHeight());
		introduce.setBounds(1000, 600, howIcon.getIconWidth(), howIcon.getIconHeight());
		start.setIcon(startIcon);
		introduce.setIcon(howIcon);
		blackBack1.setBounds(0, 0, black1.getIconWidth(), black1.getIconHeight());
		blackBack2.setBounds(0, 0, black2.getIconWidth(), black2.getIconHeight());
		blackBack1.setIcon(black1);
		blackBack2.setIcon(black2);
		gameTheme1.setBounds(0, 0, gameThemeIcon[0].getIconWidth(), gameThemeIcon[0].getIconHeight());
		gameTheme2.setBounds(0, 0, gameThemeIcon[1].getIconWidth(), gameThemeIcon[1].getIconHeight());
		gameTheme1.setIcon(gameThemeIcon[0]);
		gameTheme2.setIcon(gameThemeIcon[1]);
		textLabel.setBounds(50, 900, 1000, 50);
		Font textFont = new Font("맑은 고딕", Font.BOLD, 40);
		textLabel.setFont(textFont);
		textLabel.setForeground(Color.WHITE);
		hpText.setBounds(40, 870, 300, 60);
		Font hpFont = new Font("HY견고딕", Font.BOLD, 30);
		hpText.setFont(hpFont);
		hpText.setForeground(Color.LIGHT_GRAY);
		hpText.setText("HP");
		HP.setOpaque(true);
		HP.setBounds(400, 880, 700, 40);
		HP.setBackground(Color.RED);
		Font endTextFont = new Font("맑은 고딕", Font.BOLD, 50);
		endText.setFont(endTextFont);
		endText.setBounds(300, 500, 1000, 300);
		endText.setForeground(Color.WHITE);
		END.setBounds(0, 0, endIcon.getIconWidth(), endIcon.getIconHeight());
		END.setIcon(endIcon);
		END.setVisible(false);
		
		endText.setVisible(false);
		
		hpText.setVisible(false);
		HP.setVisible(false);
		
		bossHpText.setBounds(40, 920, 300, 60);
		bossHpText.setFont(hpFont);
		bossHpText.setForeground(Color.LIGHT_GRAY);
		bossHpText.setText("BOSS_HP");
		bossHP.setOpaque(true);
		bossHP.setBounds(400, 930, 700, 40);
		bossHP.setBackground(Color.BLACK);
		
		bossHpText.setVisible(false);
		bossHP.setVisible(false);
		
		
		MouseListener ML1 = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				start.setIcon(startIcon);
				start.setBounds(start.getX(), start.getY()-10, startIcon.getIconWidth(), startIcon.getIconHeight());
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				start.setIcon(startIconHover);
				start.setBounds(start.getX(), start.getY()+10, startIconHover.getIconWidth(), startIconHover.getIconHeight());
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				MainCode.introduceShow = 0;
				MainCode.mainPanel.remove(start);
				MainCode.mainPanel.remove(introduce);
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						MainCode.windowNum = 0;
						MainCode.themeMp3.stop();
						
						new Player();

						new Boss();
						MainCode.mainPanel.add(hpText);
						MainCode.mainPanel.add(HP);
						MainCode.mainPanel.add(bossHpText);
						MainCode.mainPanel.add(bossHP);
						MainCode.mainPanel.add(gameTheme1);
						MainCode.mainPanel.add(gameTheme2);
						MP3Player a = new MP3Player();
						a.play("sound/전기문.mp3");
						while (theme.getLocation().x >= (0 - theme.getWidth()/2)) {
							theme.setLocation(theme.getLocation().x - 10, theme.getLocation().y);
							theme2.setLocation(theme2.getLocation().x + 10, theme2.getLocation().y);
							try {
								Thread.sleep(100);
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
						a.stop();
						theme.setVisible(false);
						theme2.setVisible(false);
						MainCode.windowNum = 2;
						while (blackBack1.getLocation().y >= 0-blackBack1.getHeight()) {
							blackBack1.setLocation(blackBack1.getLocation().x, blackBack1.getLocation().y-10);
							blackBack2.setLocation(blackBack2.getLocation().x, blackBack2.getLocation().y+10);
							try {
								Thread.sleep(10);
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
						textLabel.setText("Z를 눌러 상호작용");
						while(nextPage == 0) {
							if(Player.playerX > 500 && Player.playerX < 700) {
								textLabel.setVisible(true);
								if(zPress) {
									MainCode.windowNum = 0;
									MainCode.themeMp3.stop();
									
									gameTheme2.setIcon(gameThemeIcon[2]);
									while (textLabel.getLocation().y < 1200) {
										
										textLabel.setLocation(textLabel.getLocation().x,(textLabel.getLocation().y + 10));
										try {
											Thread.sleep(10);
										} catch (Exception e2) {
											// TODO: handle exception
										}
									}
									textLabel.setText("Test_01 : 동작 및 인지");
									while (textLabel.getLocation().y > 900) {
										textLabel.setLocation(textLabel.getLocation().x,(textLabel.getLocation().y - 10));
										try {
											Thread.sleep(10);
										} catch (Exception e2) {
											// TODO: handle exception
										}
									}
									try {
										Thread.sleep(3000);
									} catch (Exception e2) {
										// TODO: handle exception
									}
									while (textLabel.getLocation().y < 1200) {
										
										textLabel.setLocation(textLabel.getLocation().x,(textLabel.getLocation().y + 10));
										try {
											Thread.sleep(10);
										} catch (Exception e2) {
											// TODO: handle exception
										}
									}
									textLabel.setText("Test_02 : 내구성 및 전투, 제품검수와 폐기");
									while (textLabel.getLocation().y > 900) {
										textLabel.setLocation(textLabel.getLocation().x,(textLabel.getLocation().y - 10));
										try {
											Thread.sleep(10);
										} catch (Exception e2) {
											// TODO: handle exception
										}
									}
									try {
										Thread.sleep(3000);
									} catch (Exception e2) {
										// TODO: handle exception
									}
									while (textLabel.getLocation().y < 1200) {
										
										textLabel.setLocation(textLabel.getLocation().x,(textLabel.getLocation().y + 10));
										try {
											Thread.sleep(10);
										} catch (Exception e2) {
											// TODO: handle exception
										}
									}
									textLabel.setText("만약 이 글을 본것으로 확인될경우, 1차 테스트는 합격");
									while (textLabel.getLocation().y > 900) {
										textLabel.setLocation(textLabel.getLocation().x,(textLabel.getLocation().y - 10));
										try {
											Thread.sleep(10);
										} catch (Exception e2) {
											// TODO: handle exception
										}
									}
									try {
										Thread.sleep(3000);
									} catch (Exception e2) {
										// TODO: handle exception
									}
									while (textLabel.getLocation().y < 1200) {
										
										textLabel.setLocation(textLabel.getLocation().x,(textLabel.getLocation().y + 10));
										try {
											Thread.sleep(10);
										} catch (Exception e2) {
											// TODO: handle exception
										}
									}
									textLabel.setText("1차 테스트가 마무리 될 경우, 2차 테스트 시작");
									while (textLabel.getLocation().y > 900) {
										textLabel.setLocation(textLabel.getLocation().x,(textLabel.getLocation().y - 10));
										try {
											Thread.sleep(10);
										} catch (Exception e2) {
											// TODO: handle exception
										}
									}
									try {
										Thread.sleep(3000);
									} catch (Exception e2) {
										// TODO: handle exception
									}
									while (textLabel.getLocation().y < 1200) {
										
										textLabel.setLocation(textLabel.getLocation().x,(textLabel.getLocation().y + 10));
										try {
											Thread.sleep(10);
										} catch (Exception e2) {
											// TODO: handle exception
										}
									}
									try {
										Thread.sleep(2000);
									} catch (Exception e2) {
										// TODO: handle exception
									}
									MP3Player mnbvcxz = new MP3Player();
									mnbvcxz.play("sound/철문 3번.mp3");
									try {
										Thread.sleep(2000);
									} catch (Exception e2) {
										// TODO: handle exception
									}
									for (int i = 2; i < gameThemeIcon.length; i++) {
										gameTheme2.setIcon(gameThemeIcon[i]);
										try {
											Thread.sleep(200);
										} catch (Exception e2) {
											// TODO: handle exception
										}
									}
									mnbvcxz.stop();
									try {
										Thread.sleep(5000);
									} catch (Exception e2) {
										// TODO: handle exception
									}
									blackBack1.setLocation(0, 0);
									blackBack2.setLocation(0, 0);
									new MP3Player().play("sound/정전.mp3");
									try {
										Thread.sleep(4500);
									} catch (Exception e2) {
										// TODO: handle exception
									}
									new MP3Player().play("sound/기계작동.mp3");
									try {
										Thread.sleep(5000);
									} catch (Exception e2) {
										// TODO: handle exception
									}
									Boss.bossAction = 0;
									Boss.nextActionWait = 50;
									Boss.bossAppear = true;
									blackBack1.setVisible(false);
									blackBack2.setVisible(false);
									nextPage = 1;
									MainCode.windowNum = 3;
									Player.playerHP = 700;
									HP.setVisible(true);
									hpText.setVisible(true);
									bossHP.setVisible(true);
									bossHpText.setVisible(true);
									while(MainCode.windowNum == 3) {
										if(Player.playerHP <= 0) {
											MainCode.windowNum = 0;
										}
										HP.setBounds(HP.getLocation().x, HP.getLocation().y, Player.playerHP, HP.getHeight());
										bossHP.setBounds(bossHP.getLocation().x, bossHP.getLocation().y, (Boss.bossHp/10), bossHP.getHeight());
										if(Boss.bossHp <= 0) {
											MainCode.themeMp3.stop();
											blackBack1.setLocation(0, 0);
											blackBack2.setLocation(0, 0);
											blackBack1.setVisible(true);
											blackBack2.setVisible(true);
											new MP3Player().play("sound/정전.mp3");
											try {
												Thread.sleep(4500);
											} catch (Exception e2) {
												// TODO: handle exception
											}
											endText.setVisible(true);
											endText.setText("Test_02 : 내구성 및 전투, 제품검수와 폐기");
											try {
												Thread.sleep(5000);
											} catch (Exception e2) {
												// TODO: handle exception
											}
											for(int i=0;i<100;i++) {
												endText.setText("Test_03 : ??? ");
												try {
													Thread.sleep(10);
												} catch (Exception e2) {
													// TODO: handle exception
												}
											}
											endText.setVisible(false);
											END.setVisible(true);
											while (true) {

											}
										}
										try {
											Thread.sleep(70);
										} catch (Exception e2) {
											// TODO: handle exception
										}
									}
									MainCode.themeMp3.stop();
									blackBack1.setLocation(0, blackBack1.getHeight());
									blackBack2.setLocation(0, (0 - blackBack2.getHeight()));
									blackBack1.setVisible(true);
									blackBack2.setVisible(true);
									while(blackBack1.getLocation().y > 0) {
										blackBack1.setLocation(0, blackBack1.getLocation().y - 5);
										blackBack2.setLocation(0, blackBack2.getLocation().y + 5);
										try {
											Thread.sleep(10);
										} catch (Exception e2) {
											// TODO: handle exception
										}
									}
									endText.setVisible(true);
									endText.setText("GAME OVER");
//									theme.setVisible(true);
//									theme2.setVisible(true);
//									while(theme.getLocation().x < 0) {
//										theme.setLocation((theme.getLocation().x + 10), 0);
//										theme2.setLocation((theme2.getLocation().x - 10), 0);
//										try {
//											Thread.sleep(5);
//										} catch (Exception e2) {
//											// TODO: handle exception
//										}
//									}
								}
							}else {
								textLabel.setVisible(false);
							}
							try {
								Thread.sleep(100);
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
						
						textLabel.setVisible(false);
						
					}
				}).start();

			}
		};
		MouseListener ML2 = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				introduce.setIcon(howIcon);
				introduce.setBounds(introduce.getX(), introduce.getY()-10, howIcon.getIconWidth(), howIcon.getIconHeight());
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				introduce.setIcon(howIconHover);
				introduce.setBounds(introduce.getX(), introduce.getY()+10, howIconHover.getIconWidth(), howIconHover.getIconHeight());
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(MainCode.introduceShow  == 0) {
					introduce.setBounds(introduce.getX(), introduce.getY(), howIconHover.getIconWidth(), howIconHover.getIconHeight());
					MainCode.introduceShow = 1;
				}else if(MainCode.introduceShow == 2) {
					introduce.setBounds(introduce.getX(), introduce.getY(), howIconHover.getIconWidth(), howIconHover.getIconHeight());
					MainCode.introduceShow = 0;
				}
			}
		};
		start.addMouseListener(ML1);
		introduce.addMouseListener(ML2);
		MainCode.mainPanel.add(start);
		MainCode.mainPanel.add(introduce);
		MainCode.mainPanel.add(theme2);
		MainCode.mainPanel.add(theme);
		textLabel.setVisible(false);
		MainCode.mainPanel.add(END);
		MainCode.mainPanel.add(endText);
		MainCode.mainPanel.add(textLabel);

		MainCode.mainPanel.add(blackBack1);
		MainCode.mainPanel.add(blackBack2);
	}
	
	void reset() {
		zPress = false;
	}

	public static void main(String[] args) {
		
	}

}
