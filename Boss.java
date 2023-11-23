package chap01;

import java.awt.*;

import javax.swing.*;

public class Boss extends JFrame{
	public static boolean bossAppear = false;
	public static int bossAction = 0;
	public static int nextActionWait = 0;
	public static int bossHp;
	Boss(){
		reset();
		JLabel bossBody = new JLabel();
		JLabel bossHand1 = new JLabel();
		JLabel bossHand2 = new JLabel();
		JLabel bossHead = new JLabel();
		
		ImageIcon bossBodyIcon = new ImageIcon("img/bossBody.png");
		ImageIcon bossHand1Icon = new ImageIcon("img/bossHand1.png");
		ImageIcon bossHand2Icon = new ImageIcon("img/bossHand2.png");
		ImageIcon bossHeadIcon = new ImageIcon("img/bossHead.png");
		
		bossBody.setBounds(0, 0, bossBodyIcon.getIconWidth(), bossBodyIcon.getIconHeight());
		bossBody.setIcon(bossBodyIcon);
		bossHand1.setBounds(-200, -300, bossHand1Icon.getIconWidth(), bossHand1Icon.getIconHeight());
		bossHand1.setIcon(bossHand1Icon);
		bossHand2.setBounds(200, -300, bossHand2Icon.getIconWidth(), bossHand2Icon.getIconHeight());
		bossHand2.setIcon(bossHand2Icon);
		bossHead.setBounds(0, -25, bossHeadIcon.getIconWidth(), bossHeadIcon.getIconHeight());
		bossHead.setIcon(bossHeadIcon);
				
		MainCode.mainPanel.add(bossBody);
		MainCode.mainPanel.add(bossHead);
		MainCode.mainPanel.add(bossHand1);
		MainCode.mainPanel.add(bossHand2);
		bossHp = 5000;
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int bossidle = 1;
				int shotgun = 1;
				int hand = 0;
				int re1 = 0;
				int re2 = 0;
				while(true) {
					if(bossAction == 0) {
						if(bossidle == 1) {
							bossHand1.setLocation((bossHand1.getLocation().x + 1), (bossHand1.getLocation().y + 1));
							bossHand2.setLocation((bossHand2.getLocation().x - 1), (bossHand2.getLocation().y + 1));
							bossBody.setLocation(bossBody.getLocation().x, (bossBody.getLocation().y - 1));
							bossHead.setLocation(bossHead.getLocation().x, (bossHead.getLocation().y + 1));
							if(bossHand1.getLocation().y >= -275) {
								bossidle = 2;
							}
						}
						if(bossidle == 2) {
							bossHand1.setLocation((bossHand1.getLocation().x - 1), (bossHand1.getLocation().y - 1));
							bossHand2.setLocation((bossHand2.getLocation().x + 1), (bossHand2.getLocation().y - 1));
							bossBody.setLocation(bossBody.getLocation().x, (bossBody.getLocation().y + 1));
							bossHead.setLocation(bossHead.getLocation().x, (bossHead.getLocation().y - 1));
							if(bossHand1.getLocation().y <= -300) {
								bossidle = 1;
							}
						}
						nextActionWait--;
					}
					if(bossAction == 1) {
						if(hand == 1) {
							while(bossHand2.getLocation().y < 0) {
								while(bossHand2.getLocation().x > 0) {
									bossHand2.setLocation((bossHand2.getLocation().x - 3), bossHand2.getLocation().y);
									try {
										re1++;
										Thread.sleep(10);
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
								bossHand2.setLocation(bossHand2.getLocation().x, (bossHand2.getLocation().y + 15));
								try {
									re2++;
									Thread.sleep(1);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}								
							nextActionWait--;
							if(shotgun == 1) {
//								System.out.println("a");
//								System.out.println(Player.playerX);
								shotgun = 0;
								if(new HitBoxCheck(1060, 700, 200, 200).hit(Player.playerHitBox)) {
									Player.playerHP -= 200;
								}
							}else {
//								System.out.println(Player.playerHitBox.hit(new HitBoxCheck(1060, 650, 200, 200)));
								if(Player.playerAttack > 0 && Player.playerHitBox.hit(new HitBoxCheck(1060, 700, 200, 200))) {
									bossHp -= 30;
								}
							}
							if(nextActionWait == 0) {
								for(;re2>0;re2--) {
									bossHand2.setLocation(bossHand2.getLocation().x, (bossHand2.getLocation().y - 15));
									try {
										Thread.sleep(1);
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
								for(;re1>0;re1--) {
									bossHand2.setLocation((bossHand2.getLocation().x + 3), bossHand2.getLocation().y);
									try {
										Thread.sleep(10);
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
							}
						}else {
							while(bossHand1.getLocation().y < 0) {
								while(bossHand1.getLocation().x < 0) {
									bossHand1.setLocation((bossHand1.getLocation().x + 3), bossHand1.getLocation().y);
									try {
										re1++;
										Thread.sleep(10);
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
								bossHand1.setLocation(bossHand1.getLocation().x, (bossHand1.getLocation().y + 15));
								try {
									re2++;
									Thread.sleep(1);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							nextActionWait--;
							if(shotgun == 1) {
//								System.out.println("a");
								shotgun = 0;
								if(new HitBoxCheck(250, 700, 200, 200).hit(Player.playerHitBox)) {
									Player.playerHP -= 200;
//									System.out.println(Player.playerHP);
								}
							}else {
//								System.out.println(Player.playerHitBox.hit(new HitBoxCheck(300, 700, 200, 200)));
								if(Player.playerAttack > 0 && Player.playerHitBox.hit(new HitBoxCheck(250, 700, 200, 200))) {
									bossHp -= 30;
//									System.out.println(bossHp);
								}
							}
							if(nextActionWait == 0) {
								for(;re2>0;re2--) {
									bossHand1.setLocation(bossHand1.getLocation().x, (bossHand1.getLocation().y - 15));
									try {
										Thread.sleep(1);
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
								for(;re1>0;re1--) {
									bossHand1.setLocation((bossHand1.getLocation().x - 3), bossHand1.getLocation().y);
									try {
										Thread.sleep(10);
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
							}
						}
					}
					if(bossAction == 2) {
						if(hand == 1) {
							while(bossHand1.getLocation().y<0) {
								
								bossHand1.setLocation(bossHand1.getLocation().x, (bossHand1.getLocation().y + 1));
								try {
									re1++;
									Thread.sleep(5);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							while(bossHand1.getLocation().x<400) {
								bossHand1.setLocation((bossHand1.getLocation().x + 2), bossHand1.getLocation().y);
								if(new HitBoxCheck((250 + bossHand1.getLocation().x), 0, 300, 1000).hit(Player.playerHitBox)) {
									Player.playerHP -= 1;
								}
								try {
									re2++;
									Thread.sleep(5);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							while(re1>0) {
								re1--;
								bossHand1.setLocation(bossHand1.getLocation().x, (bossHand1.getLocation().y - 1));
								try {
									Thread.sleep(5);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							while(re2>0) {
								re2--;
								bossHand1.setLocation((bossHand1.getLocation().x - 2), bossHand1.getLocation().y);
								try {
									Thread.sleep(5);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							nextActionWait = 0;
						}else {
							while(bossHand2.getLocation().y<0) {
								
								bossHand2.setLocation(bossHand2.getLocation().x, (bossHand2.getLocation().y + 1));
								try {
									re1++;
									Thread.sleep(5);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							while(bossHand2.getLocation().x > -400) {
								bossHand2.setLocation((bossHand2.getLocation().x - 2), bossHand2.getLocation().y);
								if(new HitBoxCheck((1060 + bossHand2.getLocation().x), 0, 300, 1000).hit(Player.playerHitBox)) {
									Player.playerHP -= 1;
								}
								try {
									re2++;
									Thread.sleep(5);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							while(re1>0) {
								re1--;
								bossHand2.setLocation(bossHand2.getLocation().x, (bossHand2.getLocation().y - 1));
								try {
									Thread.sleep(5);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							while(re2>0) {
								re2--;
								bossHand2.setLocation((bossHand2.getLocation().x + 2), bossHand2.getLocation().y);
								try {
									Thread.sleep(5);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							nextActionWait = 0;
						}
					}
					if(bossAction == 3) {
						if(hand == 1) {
							while(shotgun != 0) {
								int x = ((int)(Math.random() * 1000));
								while(bossHand1.getLocation().x != x) {
									if(x<bossHand1.getLocation().x) {
										bossHand1.setLocation((bossHand1.getLocation().x - 1), bossHand1.getLocation().y);
										re2--;
									}else {
										bossHand1.setLocation((bossHand1.getLocation().x + 1), bossHand1.getLocation().y);
										re2++;
									}
									try {
										Thread.sleep(1);
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
								try {
									Thread.sleep(1500);
								} catch (Exception e) {
									// TODO: handle exception
								}
								while(bossHand1.getLocation().y < 0) {
									bossHand1.setLocation(bossHand1.getLocation().x, (bossHand1.getLocation().y + 15));
									try {
										re1++;
										Thread.sleep(1);
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
								if(new HitBoxCheck((bossHand1.getLocation().x + 250), 700, 200, 200).hit(Player.playerHitBox)) {
									Player.playerHP -= 200;
								}
								try {
									Thread.sleep(300);
								} catch (Exception e) {
									// TODO: handle exception
								}
								while(re1>0) {
									re1--;
									bossHand1.setLocation(bossHand1.getLocation().x, (bossHand1.getLocation().y - 15));
									try {
										Thread.sleep(1);
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
								try {
									Thread.sleep(300);
								} catch (Exception e) {
									// TODO: handle exception
								}
								shotgun--;
							}
							while(re2 > 0) {
								re2--;
								bossHand1.setLocation((bossHand1.getLocation().x - 1), bossHand1.getLocation().y);
								try {
									Thread.sleep(2);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							nextActionWait = 0;
							
						}else {
							while(shotgun != 0) {
								int x = ((int)(Math.random() * -1000));
								while(bossHand2.getLocation().x != x) {
									if(x<bossHand2.getLocation().x) {
										bossHand2.setLocation((bossHand2.getLocation().x - 1), bossHand2.getLocation().y);
										re2++;
									}else {
										bossHand2.setLocation((bossHand2.getLocation().x + 1), bossHand2.getLocation().y);
										re2--;
									}
									try {
										Thread.sleep(1);
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
								try {
									Thread.sleep(1500);
								} catch (Exception e) {
									// TODO: handle exception
								}
								while(bossHand2.getLocation().y < 0) {
									bossHand2.setLocation(bossHand2.getLocation().x, (bossHand2.getLocation().y + 15));
									try {
										re1++;
										Thread.sleep(1);
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
								if(new HitBoxCheck((1060 + bossHand2.getLocation().x), 700, 200, 200).hit(Player.playerHitBox)) {
									Player.playerHP -= 200;
								}
								try {
									Thread.sleep(300);
								} catch (Exception e) {
									// TODO: handle exception
								}
								while(re1>0) {
									re1--;
									bossHand2.setLocation(bossHand2.getLocation().x, (bossHand2.getLocation().y - 15));
									try {
										Thread.sleep(1);
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
								try {
									Thread.sleep(300);
								} catch (Exception e) {
									// TODO: handle exception
								}
								shotgun--;
							}
							while(re2 > 0) {
								re2--;
								bossHand2.setLocation((bossHand2.getLocation().x + 1), bossHand2.getLocation().y);
								try {
									Thread.sleep(2);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							nextActionWait = 0;
							
						}
					}
					bossBody.setVisible(bossAppear);
					bossHand1.setVisible(bossAppear);
					bossHand2.setVisible(bossAppear);
					bossHead.setVisible(bossAppear);
					if(nextActionWait == 0 && MainCode.windowNum == 3) {
						bossAction = ((int)(Math.random() * 5));
						nextActionWait = ((int)(Math.random() * 30) + 10);
						re1 = 0;
						re2 = 0;
						if(bossAction == 4) {
							bossAction = 1;
						}
						if(bossAction == 1) {
							hand = (((int)(Math.random() * 2))+1);
							shotgun = 1;
							nextActionWait += 20;
						}
						if(bossAction == 2) {
							hand = (((int)(Math.random() * 2))+1);
						}
						if(bossAction == 3) {
							hand = (((int)(Math.random() * 2))+1);
							shotgun = 3;
						}
					}
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}).start();
	}
	
	void reset() {
		bossAppear = false;
		bossAction = 0;
		nextActionWait = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
