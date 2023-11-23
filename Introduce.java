package chap01;

import javax.swing.*;

public class Introduce extends JFrame {
	private int introduceNum = 12;
	
	public Introduce() {
		// TODO Auto-generated constructor stub
		JLabel introduce = new JLabel();
		ImageIcon[] introduceIcon = new ImageIcon[13];
		
		String[] introduceIconString = new String[13];
		for(int i=0;i<=12;i++) {
			if(i<10) {
				introduceIconString[i] = ("img/introduce/introduce" + "0" + ".png");
				introduceIconString[i] = (new StringBuffer(introduceIconString[i]).insert(24, ("" + i))).toString();
			}else {
				introduceIconString[i] = ("img/introduce/introduce" + ((char)i) + ".png");
				introduceIconString[i] = (new StringBuffer(introduceIconString[i]).insert(23, ("" + i))).toString();
			}
		}
		
		for (int i = 0; i < introduceIconString.length; i++) {
			introduceIcon[i] = new ImageIcon(introduceIconString[i]);
		}
		introduce.setBounds(0, 0, 1440, 1080);
		introduce.setIcon(introduceIcon[12]);
		MainCode.mainPanel.add(introduce);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					if(MainCode.windowNum == 1 && MainCode.introduceShow == 1) {
						if(introduceNum>0) {
							introduceNum--;
							introduce.setIcon(introduceIcon[introduceNum]);
							if(introduceNum == 0) {
								MainCode.introduceShow = 2;
							}
						}
					}else if(MainCode.introduceShow == 0) {
						if(introduceNum<12) {
							introduceNum++;
							introduce.setIcon(introduceIcon[introduceNum]);
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
