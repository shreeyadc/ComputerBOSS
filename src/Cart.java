/* 
 * SPD Project (Computer BOSS Store)
 * 
 * This file will display the GUI of the cart by displaying all the items in the user's cart, their subtotal and total
 * 
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Cart extends JFrame implements ActionListener{
	
	//items in cart array
	public static ArrayList<Laptop> laptopsInCart = new ArrayList<Laptop>();

	//background image
	JLabel background = new JLabel(new ImageIcon("images/cartBackgroundLarge.png"));
	
	Icon logo = new ImageIcon("images/computerLogo.png");
	JButton computerLogo = new JButton(logo);	
	JButton shopBtn; //Inventory button
	JButton surveyBtn; //Survey button
	JButton education; //Education button
	
	Icon cart = new ImageIcon("images/cart.png");
	JButton cartBtn = new JButton(cart);
	JScrollPane scrollPane;
	JPanel panel = new JPanel();
	
	Icon checkout = new ImageIcon("images/checkoutButton.png");
	JButton checkoutBtn = new JButton(checkout);
	
	
	
	public Cart() {

		//setting the foundation of the window
		setSize(1400,800);
		setTitle("Cart");
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
			
		//background image
		background.setBounds(0,0,1400,3834);
		add(background);
		
		//**MENU BAR**

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
		shopBtn.setBounds(501,95,150,29);
		shopBtn.addActionListener(this);
		background.add(shopBtn);
		
		//survey button
		surveyBtn = new JButton("Survey");
		surveyBtn.setBounds(626,95,150,29);
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
		
		JLabel numItems = new JLabel(Integer.toString(laptopsInCart.size()));
		numItems.setBounds(0, 0, 10, 10);
		numItems.setFont(new Font("Helvetica Neue", Font.PLAIN,15));
		cartBtn.add(numItems);

		double subtotal = 0;
		double total = 0;
		double tax;
		double shipping = 10;
		
		int itemNumber = 0;
		int numOfItems = laptopsInCart.size();
		
		if (numOfItems != 0) {
			
			//cart title label
			JLabel cartTitle = new JLabel("Your Cart");
			cartTitle.setBounds(136, 225, 135, 36);
			cartTitle.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
			background.add(cartTitle);
			
			for (int i = 296; i < 1000000; i += 250) {
				
				//add background for each item in the cart to hold the information
				JLabel cartBackground = new JLabel(new ImageIcon("images/cartBackground.png"));
				cartBackground.setBounds(136, i, 710, 251);
				background.add(cartBackground);	
				
				JLabel compBackground = new JLabel(new ImageIcon("images/checkoutCompBackground.png"));
				compBackground .setBounds(0, 10, 234, 234);
				cartBackground.add(compBackground);	
				
				int laptopNum = getItemNumber(itemNumber)+1;
				JLabel computerImage = new JLabel(new ImageIcon("images/laptops/laptopSmall"+laptopNum+".png"));
				computerImage.setBounds(30, 30, 165, 165);
				compBackground.add(computerImage);
				
				JLabel name = new JLabel(getName(itemNumber));
				name.setBounds(260, 46, 276, 36);
				name.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
				cartBackground.add(name);
				
				JLabel price = new JLabel("$"+Double.toString(getPrice(itemNumber)));
				price.setBounds(260, 93, 130, 36);
				price.setFont(new Font("Helvetica Neue", Font.BOLD,20));
				cartBackground.add(price);
				
				subtotal += getPrice(itemNumber);

						
				itemNumber++;
		
					
				if (itemNumber >= numOfItems) {
					
					break;
				}
				else
					continue;
			}
		}
		else {
			JLabel cartTitle = new JLabel("Your Cart Is Empty :(");
			cartTitle.setBounds(136, 225, 500, 36);
			cartTitle.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
			background.add(cartTitle);
		}
		
		//CHECKOUT BOX
		JLabel checkoutBackground = new JLabel(new ImageIcon("images/checkoutBox.png"));
		checkoutBackground.setBounds(910, 296, 445, 558);
		background.add(checkoutBackground);
		
		JLabel summaryLabel = new JLabel("CHECKOUT SUMMARY");
		summaryLabel.setBounds(81, 77, 270, 24);
		summaryLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		checkoutBackground.add(summaryLabel);
		
		//subtotal cost
		JLabel subtotalLabel = new JLabel("Subtotal");
		subtotalLabel.setBounds(81, 138, 100, 24);
		subtotalLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		checkoutBackground.add(subtotalLabel);
		
		JLabel subtotalNum = new JLabel("$"+Double.toString(subtotal));
		subtotalNum.setBounds(260, 138, 150, 24);
		subtotalNum.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		checkoutBackground.add(subtotalNum);
		
		//shipping cost
		JLabel shippingLabel = new JLabel("Shipping");
		shippingLabel.setBounds(81, 194, 100, 24);
		shippingLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		checkoutBackground.add(shippingLabel);
		
		JLabel shippingNum = new JLabel("$10.00");
		shippingNum.setBounds(260, 194, 150, 24);
		shippingNum.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		checkoutBackground.add(shippingNum);
		
		//tax cost
		tax = subtotal * 0.13;
		String taxStr = String.format("%.2f", tax);
		
		JLabel taxLabel = new JLabel("GST/HST");
		taxLabel.setBounds(81, 253, 100, 24);
		taxLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		checkoutBackground.add(taxLabel);
		
		JLabel taxNum = new JLabel("$"+taxStr);
		taxNum.setBounds(260, 253, 150, 24);
		taxNum.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		checkoutBackground.add(taxNum);
		
		JLabel line = new JLabel("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		line.setBounds(81, 321, 300, 5);
		line.setForeground(new Color(217,217,217));
		line.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		checkoutBackground.add(line);
		
		//total cost
		total = subtotal + tax + shipping;
		String totalStr = String.format("%.2f", total);
		JLabel totalLabel = new JLabel("Total");
		totalLabel.setBounds(81, 370, 100, 24);
		totalLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		checkoutBackground.add(totalLabel);
		
		JLabel totalNum = new JLabel("$"+totalStr);
		totalNum.setBounds(220, 370, 300, 24);
		totalNum.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		checkoutBackground.add(totalNum);
		
		checkoutBtn.setBounds(15, 440, 400, 66);
		checkoutBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		checkoutBackground.add(checkoutBtn);

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
	
	public static int getItemNumber(int i) {
		return laptopsInCart.get(i).getLaptopNum();
	}
	public static String getName(int i) {
		
		return laptopsInCart.get(i).getModel();
	}
	public static double getPrice(int i) {
		
		return laptopsInCart.get(i).getPrice();
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
	}

}
