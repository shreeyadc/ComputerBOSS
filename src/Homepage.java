
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

public class Homepage extends JFrame implements ActionListener{
	
	JLabel background = new JLabel(new ImageIcon("images/backgroundSmallWhite.png"));
	
	Icon logo = new ImageIcon("images/computerLogo.png");
	JButton computerLogo = new JButton(logo);	
	JButton shopBtn; //Inventory button
	JButton surveyBtn; //Survey button
	JButton educationBtn; //educationBtn button
	Icon cart = new ImageIcon("images/cart.png");
	JButton cartBtn = new JButton(cart);

	
	Icon computer = new ImageIcon("images/computerImage.png");
	JButton computerImage = new JButton(computer);
	
	Icon startButton = new ImageIcon("images/getStarted.png");
	JButton getStarted = new JButton(startButton);
	
	public Homepage() {
		
		setSize(1400,800);
		setTitle("Welcome");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		background.setBounds(0,0,1400,800);
		
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
		
		//educationBtn button
		educationBtn = new JButton("Learn More");
		educationBtn.setBounds(771,95,200,29);
		educationBtn.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		educationBtn.setOpaque(false);
		educationBtn.setContentAreaFilled(false);
		educationBtn.setBorderPainted(false);
		educationBtn.addActionListener(this);
		background.add(educationBtn);

		//cart button
		background.add(cartBtn);
		cartBtn.setBounds(1280,90,37,39);
		cartBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		cartBtn.addActionListener(this);

		JLabel numItems = new JLabel(Integer.toString(Cart.laptopsInCart.size()));
		numItems.setBounds(20, 20, 5, 20);
		numItems.setFont(new Font("Helvetica Neue", Font.PLAIN,15));
		cartBtn.add(numItems);
		
		JLabel title1 = new JLabel("Welcome To");
		title1.setBounds(123,250,470,146);
		title1.setFont(new Font("Helvetica Neue", Font.PLAIN, 60));
		background.add(title1);
		
		JLabel title2 = new JLabel("Computer BOSS");
		title2.setBounds(123,330,470,146);
		title2.setForeground(new Color(33,116,241));
		title2.setFont(new Font("Helvetica Neue", Font.BOLD, 60));
		background.add(title2);
		
		background.add(computerImage);
		computerImage.setBounds(900,200,646,400);
		computerImage.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		background.add(getStarted);
		getStarted.setBounds(123,500,374,58);
		getStarted.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		add(background);
		setVisible(true);
			
		
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
		if (e.getSource() == getStarted) {
			setVisible(false);
			new SurveyFrame();
		}
	}
}
