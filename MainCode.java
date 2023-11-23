package chap01;

import javax.swing.*;

import javazoom.jl.player.MP3Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MainCode extends JFrame {
	
	
	public static JPanel mainPanel = new JPanel();
	public static int windowNum;
	public static int introduceShow = 0;
	public static MP3Player themeMp3 = new MP3Player();
	public static int left = 0;
	public static int right = 0;
	MainCode(){
		setTitle("Unknowing alone person");
		setSize(1440, 1080);
		setLocationRelativeTo(null);
		mainPanel.setLayout(null);
		new Introduce();
		new MainTheme();
		windowNum = 1;
		add(mainPanel);
		KeyListener keyRight = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					right = 0;
					if(left == 0 && Player.playerJump == 0) {
						if(Player.playerY == 570) {
							Player.playerIdle++;
							Player.playerMove = 0;
						}
					}
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					right = 1;
					Player.playerIdle = 0;
					Player.playerMove++;
				}

			}
		};
		addKeyListener(keyRight);
		
		KeyListener keyLeft = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					left = 0;
					if(right == 0 && Player.playerJump == 0) {
						if(Player.playerY == 570) {
							Player.playerIdle++;
							Player.playerMove = 0;
						}
					}
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					left = 1;
					Player.playerIdle = 0;
					Player.playerMove--;
				}

			}
		};
		addKeyListener(keyLeft);
		KeyListener keyUp = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					Player.playerIdle = 0;
					if(Player.playerJump == 0 && Player.playerAttack == 0) {
						Player.playerJump = 1;
					}
				}

			}
		};
		addKeyListener(keyUp);
		
		KeyListener keySpace = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					Player.playerIdle = 0;
					if(Player.playerJump == 0 && Player.playerAttack == 0) {
						Player.playerAttack = 1;
					}
				}

			}
		};
		addKeyListener(keySpace);
		
		KeyListener keyZ = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_Z && windowNum == 2) {
					if(Player.playerX > 500 && Player.playerX < 700) {
						MainTheme.zPress = true;
					}
				}

			}
		};
		addKeyListener(keyZ);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					if(windowNum == 0) {
						themeMp3.stop();
					}
					if(windowNum == 1) {
						if(themeMp3.isPlaying()) {
							themeMp3.stop();
						}
						try {
							themeMp3.play("sound/보스전3.mp3");
							int a = 0;
							while(themeMp3.isPlaying() && a != 480) {
								a++;
								Thread.sleep(100);
							}
							themeMp3.stop();
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					if(windowNum == 2) {
						if(themeMp3.isPlaying()) {
							themeMp3.stop();
						}
						try {
							
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					if(windowNum == 3) {
						if(themeMp3.isPlaying()) {
							themeMp3.stop();
						}
						try {
							themeMp3.play("sound/보스전2.mp3");
							int b = 0;
							while(themeMp3.isPlaying() && b != 910) {
								b++;
								Thread.sleep(100);
							}
							themeMp3.stop();
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}

			}
		}).start();
	}
	
	public static void reset() {
		introduceShow = 0;
		left = 0;
		right = 0;
	}
	
	public static void main(String[] args) {
		new MainCode();

	}

}
