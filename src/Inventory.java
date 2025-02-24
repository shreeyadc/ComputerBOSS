import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Inventory extends JFrame implements ActionListener{
	
	//background image
	JLabel background = new JLabel(new ImageIcon("images/inventoryBackground.png"));
	
	//scroll pane
	JScrollPane scrollPane;
	JPanel panel = new JPanel();
	
	//MENU BAR ITEMS
	Icon logo = new ImageIcon("images/computerLogo.png");
	JButton computerLogo = new JButton(logo);	
	JButton shopBtn; //Inventory button
	JButton surveyBtn; //Survey button
	JButton education; //Education button
	Icon cart = new ImageIcon("images/cart.png"); //image of the cart
	JButton cartBtn = new JButton(cart); //turn the image of the cart into a button
	
	Icon addToCartImage = new ImageIcon("images/addToCartSmall.png");
	
	JButton addToCart1;
	JButton addToCart2;
	JButton addToCart3;
	JButton addToCart4;
	JButton addToCart5;
	JButton addToCart6;
	JButton addToCart7;
	JButton addToCart8;
	JButton addToCart9;
	JButton addToCart10;
	JButton addToCart11;
	JButton addToCart12;
	
	public Inventory() {
		
		setSize(1400,800);
		setTitle("Welcome");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		//logo image/button
		background.add(computerLogo);
		computerLogo.setBounds(118,90,43,43);
		computerLogo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		computerLogo.addActionListener(this);
		
		//shop/inventory button
		shopBtn = new JButton("Shop");
		shopBtn.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		shopBtn.setOpaque(false);
		shopBtn.setContentAreaFilled(false);
		shopBtn.setBorderPainted(false);
		shopBtn.setBounds(460,95,150,29);
		shopBtn.addActionListener(this);
		background.add(shopBtn);
		
		//survey button
		surveyBtn = new JButton("Survey");
		surveyBtn.setBounds(620,95,150,29);
		surveyBtn.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		surveyBtn.setOpaque(false);
		surveyBtn.setContentAreaFilled(false);
		surveyBtn.setBorderPainted(false);
		surveyBtn.addActionListener(this);
		background.add(surveyBtn);
		
		//education button
		education = new JButton("Learn More");
		education.setBounds(771,95,200,29);
		education.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		education.setOpaque(false);
		education.setContentAreaFilled(false);
		education.setBorderPainted(false);
		education.addActionListener(this);
		background.add(education);
		
		//cart button
		background.add(cartBtn);
		cartBtn.setBounds(1280,90,37,39);
		cartBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		cartBtn.addActionListener(this);
		
		JLabel numItems = new JLabel(Integer.toString(Cart.laptopsInCart.size()));
		numItems.setBounds(5, 5, 10, 10);
		numItems.setFont(new Font("Helvetica Neue", Font.PLAIN,15));
		cartBtn.add(numItems);
		
		JLabel title = new JLabel("Step Up Your");
		title.setBounds(500, 200, 200, 100);
		title.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
		background.add(title);
		
		JLabel title2 = new JLabel("Computer Game.");
		title2.setBounds(700, 200, 800, 100);
		title2.setForeground(new Color(33,116,241));
		title2.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
		background.add(title2);
		
		JLabel subtitle = new JLabel("Shop top of the line exlusive computers, and become a computer boss.");
		subtitle.setBounds(400, 250, 800, 100);
		subtitle.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		background.add(subtitle);
		
		background.setBounds(0,0,1400,800);
		add(background);
		
		int index = -1;
		int count = 1;
		
		for (int r = 433; r <= 1665; r+= 424) {
			
			for (int i = 25; i <= 1036; i+= 315) {
				
				if (index == 11) {
					continue;
				}
				else {
					index++;
				}
				
				JLabel compBackground = new JLabel(new ImageIcon("images/inventoryCompBackground.png"));
				compBackground.setBounds(i, r, 390, 374);
				background.add(compBackground);
				
				JLabel compImage = new JLabel(new ImageIcon("images/laptops/laptopSmall"+count+".png"));
				compImage.setBounds(110, 39, 165, 200);
				compBackground.add(compImage);		
				
				JLabel compName = new JLabel(FileInput.getName(index));
				compName.setBounds(110, 286, 150, 30);
				compName.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
				compName.setForeground(new Color(115,115,115));
				compBackground.add(compName);
				
				JLabel price = new JLabel("$"+FileInput.getPrice(index));
				price.setBounds(110, 316, 150, 25);
				price.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
				compBackground.add(price);
				
				if (r == 433 && i == 25) {
					addToCart1 = new JButton(addToCartImage);
					addToCart1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
					addToCart1.setBounds(250, 286, 72, 72);
					addToCart1.addActionListener(this);
					compBackground.add(addToCart1);	
				}
				else if (r == 433 && i == 340) {
					addToCart2 = new JButton(addToCartImage);
					addToCart2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
					addToCart2.setBounds(250, 286, 72, 72);
					addToCart2.addActionListener(this);
					compBackground.add(addToCart2);	
				}
				else if (r == 433 && i == 655) {
					addToCart3 = new JButton(addToCartImage);
					addToCart3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
					addToCart3.setBounds(250, 286, 72, 72);
					addToCart3.addActionListener(this);
					compBackground.add(addToCart3);	
				}
				else if (r == 433 && i == 970) {
					addToCart4 = new JButton(addToCartImage);
					addToCart4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
					addToCart4.setBounds(250, 286, 72, 72);
					addToCart4.addActionListener(this);
					compBackground.add(addToCart4);	
				}
				//________________
				
				else if(r == 857 && i == 25) {
					addToCart5 = new JButton(addToCartImage);
					addToCart5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
					addToCart5.setBounds(250, 286, 72, 72);
					addToCart5.addActionListener(this);
					compBackground.add(addToCart5);	
				}
				else if (r == 857 && i == 340) {
					addToCart6 = new JButton(addToCartImage);
					addToCart6.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
					addToCart6.setBounds(250, 286, 72, 72);
					addToCart6.addActionListener(this);
					compBackground.add(addToCart6);	
				}
				else if (r == 857 && i == 655) {
					addToCart7 = new JButton(addToCartImage);
					addToCart7.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
					addToCart7.setBounds(250, 286, 72, 72);
					addToCart7.addActionListener(this);
					compBackground.add(addToCart7);	
				}
				else if (r == 857 && i == 970) {
					addToCart8 = new JButton(addToCartImage);
					addToCart8.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
					addToCart8.setBounds(250, 286, 72, 72);
					addToCart8.addActionListener(this);
					compBackground.add(addToCart8);	
				}
				//________________
				
				else if(r == 1281 && i == 25) {
					addToCart9 = new JButton(addToCartImage);
					addToCart9.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
					addToCart9.setBounds(250, 286, 72, 72);
					addToCart9.addActionListener(this);
					compBackground.add(addToCart9);	
				}
				else if (r == 1281 && i == 340) {
					addToCart10 = new JButton(addToCartImage);
					addToCart10.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
					addToCart10.setBounds(250, 286, 72, 72);
					addToCart10.addActionListener(this);
					compBackground.add(addToCart10);	
				}
				else if (r == 1281 && i == 655) {
					addToCart11 = new JButton(addToCartImage);
					addToCart11.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
					addToCart11.setBounds(250, 286, 72, 72);
					addToCart11.addActionListener(this);
					compBackground.add(addToCart11);	
				}
				else if (r == 1281 && i == 970) {
					addToCart12 = new JButton(addToCartImage);
					addToCart12.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
					addToCart12.setBounds(250, 286, 72, 72);
					addToCart12.addActionListener(this);
					compBackground.add(addToCart12);	
				}
				
				else {
					
				}
			
				count++;
				
				
			}
		}
		
		scrollPane = new JScrollPane(background);
		scrollPane.setBounds(0, 0, 1800, 790);
		
		//set the panel bounds and layout manager
		panel.setBounds(0, 0, 1800, 1000);
		panel.setLayout(null);
		
		//add the scroll pane to the panel
		//then add the panel to the frame
		panel.add(scrollPane);
		add(panel);
		
		
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == computerLogo) {
			setVisible(false);
			new Homepage();
		}
		if (e.getSource() == surveyBtn) {
			setVisible(false);
			new SurveyFrame();
		}
		if (e.getSource() == shopBtn) {
			setVisible(false);
			new Inventory();
		}
		if (e.getSource() == cartBtn) {
			setVisible(false);
			new Cart();
		}

		if (e.getSource() == addToCart1) {
			Cart.laptopsInCart.add(FileInput.laptopArray[0]);
		}
		if (e.getSource() == addToCart2) {
			Cart.laptopsInCart.add(FileInput.laptopArray[1]);
		}
		if (e.getSource() == addToCart3) {
			Cart.laptopsInCart.add(FileInput.laptopArray[2]);
		}
		if (e.getSource() == addToCart4) {
			Cart.laptopsInCart.add(FileInput.laptopArray[3]);
		}
		if (e.getSource() == addToCart5) {
			Cart.laptopsInCart.add(FileInput.laptopArray[4]);
		}
		if (e.getSource() == addToCart6) {
			Cart.laptopsInCart.add(FileInput.laptopArray[5]);
		}
		if (e.getSource() == addToCart7) {
			Cart.laptopsInCart.add(FileInput.laptopArray[6]);
		}
		if (e.getSource() == addToCart8) {
			Cart.laptopsInCart.add(FileInput.laptopArray[7]);
		}
		if (e.getSource() == addToCart9) {
			Cart.laptopsInCart.add(FileInput.laptopArray[8]);
		}
		if (e.getSource() == addToCart10) {
			Cart.laptopsInCart.add(FileInput.laptopArray[9]);
		}
		if (e.getSource() == addToCart11) {
			Cart.laptopsInCart.add(FileInput.laptopArray[10]);
		}
		if (e.getSource() == addToCart12) {
			Cart.laptopsInCart.add(FileInput.laptopArray[11]);
		}
		
	}
	
}
