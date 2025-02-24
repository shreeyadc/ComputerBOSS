import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//SurveyResults class that will create the window for the results
public class ResultsPage extends JFrame implements ActionListener{

	public static int numItems;
	//background image
	JLabel background = new JLabel(new ImageIcon("images/backgroundWhite.png"));
	
	//MENU BAR ITEMS
	Icon logo = new ImageIcon("images/computerLogo.png");
	JButton computerLogo = new JButton(logo);	
	JButton shopBtn; //Inventory button
	JButton surveyBtn; //Survey button
	JButton education; //Education button
	Icon cart = new ImageIcon("images/cart.png"); //image of the cart
	JButton cartBtn = new JButton(cart); //turn the image of the cart into a button

	//Create panels for scrolling
	JScrollPane scrollPane;
	JPanel panel = new JPanel(); 
	
	//Other buttons
	JButton viewItem;
	JButton addToCart;
	JButton addSecondary1;
	JButton addSecondary2;
		
	//constructor method
	public ResultsPage() {
		
		//setting the foundation of the window
		setSize(1400,800);
		setTitle("Your Results");
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
			
		//background image
		background.setBounds(0,0,1400,1754);
		add(background);
		
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
		
		JLabel numItems = new JLabel(updateCart());
		numItems.setBounds(10, 0, 10, 10);
		numItems.setFont(new Font("Helvetica Neue", Font.PLAIN,15));
		cartBtn.add(numItems);
		
		//Title
		JLabel labelTitle = new JLabel("Discover The Computer Made For You.");
		labelTitle.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
		labelTitle.setBounds(434, 200, 900, 100);
		background.add(labelTitle);
		
		JLabel subHeader = new JLabel("Our state of the art system has curated a match that will suit you and your lifestyle.");
		subHeader.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		subHeader.setBounds(340, 250, 900, 100);
		background.add(subHeader);

		//TOP PICK
		//background image for laptop
		JLabel square = new JLabel(new ImageIcon("images/laptopBackground.png"));
		square.setBounds(75, 430, 490, 521);
		background.add(square);
		
		
		
		//Computer image
		//turn the index of the top computer plus one into a string to upload corresponding image
		String topLaptopIndex = Integer.toString(SurveyResult.getTopIndex(0)+1);
		JLabel computerImage = new JLabel(new ImageIcon("images/laptops/laptop"+topLaptopIndex+".png"));
		computerImage.setBounds(60, 83, 354, 354);
		square.add(computerImage);
		
		//get the model name
		JLabel name = new JLabel(SurveyResult.getName(0));
		name.setBounds(625, 440, 457, 61);
		name.setFont(new Font("Helvetica Neue", Font.BOLD, 50));
		background.add(name);
		
		//add the price of the computer to the screen
		JLabel price = new JLabel("$"+SurveyResult.getPrice(0));
		price.setBounds(1090, 440, 230, 61);
		price.setFont(new Font("Helvetica Neue", Font.PLAIN, 50));
		background.add(price);
		
		//Stars rating
		JLabel stars = new JLabel(new ImageIcon("images/stars.png"));
		stars.setBounds(625, 510, 165, 32);
		background.add(stars);
		
		//Description of the computer
		JTextArea textArea = new JTextArea(SurveyResult.getInfo(0));
		textArea.setBounds(625, 580, 700, 250);
		textArea.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		background.add(textArea);
		
		//Add cart button
		Icon add = new ImageIcon("images/addToCart.png");
		addToCart = new JButton(add);
		addToCart.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		addToCart.addActionListener(this);
		addToCart.setBounds(625, 830, 257, 87);
		background.add(addToCart);
		
		//Add view product page button
		Icon view = new ImageIcon("images/view.png");
		viewItem = new JButton(view);
		viewItem.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		viewItem.setBounds(890, 830, 259, 89);
		viewItem.addActionListener(this);
		background.add(viewItem);
				
		//favourite button (non-functional)
		JLabel fav = new JLabel(new ImageIcon("images/fav.png"));
		fav.setBounds(1165, 830, 83, 83);
		background.add(fav);
		
		//add background for the secondary options
		JLabel blueBox = new JLabel(new ImageIcon("images/blueBackground.png"));
		blueBox.setBounds(0, 1035, 1400, 719);
		background.add(blueBox);
		
		//Title
		JLabel label2 = new JLabel("Not what you’re looking for? Check out similar products");
		label2.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
		label2.setForeground(Color.white);
		label2.setBounds(146, 135, 900, 36);
		blueBox.add(label2);
		
		
		//SECONDARY OPTIONS
		int count = 1; //a counter that will keep track of which computer to display
		//for loop that starts at the x value of where the boxes should lay and increments to match the next box
		for (int i = 146; i <= 722; i += 576) {
		

			//Add background for secondary laptops
			JLabel whiteBox = new JLabel(new ImageIcon("images/whiteBox.png"));
			whiteBox.setBounds(i, 232, 565, 393);
			blueBox.add(whiteBox);
	
			//Computer image for secondary laptops
			JLabel placeholder2 = new JLabel(new ImageIcon("images/laptops/laptopSmall"+(SurveyResult.getTopIndex(count)+1)+".png"));
			placeholder2.setBounds(74, 64, 165, 174);
			whiteBox.add(placeholder2);	
			
			//Add the name/model of the secondary laptops
			JLabel name2 = new JLabel(SurveyResult.getName(count));
			name2.setBounds(280, 100, 220, 61);
			name2.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
			whiteBox.add(name2);
			
			//Add the price of the secondary laptops
			JLabel price2 = new JLabel("$"+SurveyResult.getPrice(count));
			price2.setBounds(280, 140, 192, 61);
			price2.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
			whiteBox.add(price2);
			
			Icon viewFull = new ImageIcon("images/viewFull.png");
			JButton viewFullInfo = new JButton(viewFull);
			viewFullInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			viewFullInfo.setBounds(37, 272, 388, 87);
			whiteBox.add(viewFullInfo);
			
			Icon addItem = new ImageIcon("images/add.png");
			
			if (i == 146) {
				addSecondary1 = new JButton(addItem);
				addSecondary1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				addSecondary1.setBounds(437, 272, 91, 91);
				whiteBox.add(addSecondary1);
				addSecondary1.addActionListener(this);
			}
			else {
				addSecondary2 = new JButton(addItem);
				addSecondary2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				addSecondary2.setBounds(437, 272, 91, 91);
				whiteBox.add(addSecondary2);
				addSecondary2.addActionListener(this);
			}
			
			count++;
		}
		
		
		
		scrollPane = new JScrollPane(background);
		scrollPane.setBounds(0, 0, 1800, 790);
		
		//set the panel bounds and layout manager
		panel.setBounds(0, 0, 1800, 1754);
		panel.setLayout(null);
		
		//add the scroll pane to the panel
		//then add the panel to the frame
		panel.add(scrollPane);
		add(panel);
		
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {


	}
	public static String updateCart() {
		numItems = Cart.laptopsInCart.size();
		return Integer.toString(numItems);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == viewItem) {
			try {
				Desktop.getDesktop().browse(new URL(SurveyResult.getLink(0)).toURI());
			}
			catch (Exception e1)
			{}
		}
		if (e.getSource() == addToCart) {
			updateCart();
			Cart.laptopsInCart.add(SurveyResult.topThreeLaptops[0]);
		}
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

		if (e.getSource() == addSecondary1) {
			updateCart();
			Cart.laptopsInCart.add(SurveyResult.topThreeLaptops[1]);
		}
		if (e.getSource() == addSecondary2) {
			updateCart();
			Cart.laptopsInCart.add(SurveyResult.topThreeLaptops[2]);
		}
		
	}
}
