//Title: TitleFrame
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
//import the things needed
public class TitleFrame {
	public static void main(String[] args) {
	//Create the buttons
			JButton SurveyButton;
			JButton InventoryButton;
			JButton EducationButton;
			
			//Creating the frame
			JFrame frame = new JFrame();
			frame.setTitle("Laptop");//The little name is called Laptop
			frame.setVisible(true); //To make the frame visible
			frame.setSize(500,700);//The size of the frame
			frame.setResizable(false);//The use can't resize the frame
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//The program will exit when the user clicks close
			//Create label
			JLabel label = new JLabel();
			label.setText("Hello");//The text
			label.setForeground(new Color(0x000000));
			//The color of the word
			label.setBackground(new Color(0xffffff));
			label.setIconTextGap(8);//The pixel
			label.setFont(new Font("Arial", Font.BOLD, 40));
			//The type and the size of the word
			label.setBounds(150, 10, 190, 50);
			//The size of the label
			label.setHorizontalTextPosition(JLabel.RIGHT);
			label.setVerticalTextPosition(JLabel.CENTER);
			
			//Create SurveyButton
			SurveyButton = new JButton();
			SurveyButton.setText("Survey");
			//The word is Survey
			SurveyButton.setBounds(10, 80, 150, 100);
			//The place and the size that the word is
			SurveyButton.setFocusable(false);
			SurveyButton.setForeground(Color.black);
			//The word is black
			SurveyButton.setBackground(Color.red);
			//The background of the word is white
			SurveyButton.setBorder(BorderFactory.createEtchedBorder());
			//Something like a line on the out side of the box that hold the word
			SurveyButton.setIconTextGap(-3);
			SurveyButton.setFont(new Font("georgia", Font.BOLD, 30));
			//The type of the word and the size
			SurveyButton.setHorizontalTextPosition(JButton.CENTER);
			
			//Create InventoryButton
			InventoryButton = new JButton();
			InventoryButton.setText("Inventory");
			InventoryButton.setBounds(170, 80, 150, 100);
			//The place and the size that the word is
			InventoryButton.setFocusable(false);
			InventoryButton.setForeground(Color.blue);
			//The word is black
			InventoryButton.setBackground(Color.white);
			//The background of the word is white
			InventoryButton.setBorder(BorderFactory.createEtchedBorder());
			//Something like a line on the out side of the box that hold the word
			InventoryButton.setIconTextGap(-3);
			InventoryButton.setFont(new Font("georgia", Font.BOLD, 30));
			//The type of the word and the size
			InventoryButton.setHorizontalTextPosition(JButton.CENTER);
			
			//Create EducationButton
			EducationButton = new JButton();
			EducationButton.setText("Education");
			EducationButton.setBounds(330, 80, 150, 100);
			//The place and the size that the word is
			EducationButton.setFocusable(false);
			EducationButton.setForeground(Color.blue);
			//The word is black
			EducationButton.setBackground(Color.red);
			//The background of the word is white
			EducationButton.setBorder(BorderFactory.createEtchedBorder());
			//Something like a line on the out side of the box that hold the word
			EducationButton.setIconTextGap(-3);
			EducationButton.setFont(new Font("georgia", Font.BOLD, 30));
			//The type of the word and the size
			EducationButton.setHorizontalTextPosition(JButton.CENTER);
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0x8080ff));
			//The background color
			panel.setBounds(140,10, 60, 60);
			panel.setLayout(null);
			panel.add(SurveyButton);
			//add SurveyButton to panel
			panel.add(InventoryButton);
			//add InventoryButton to panel
			panel.add(EducationButton);
			//add EducationButton to panel
			
			frame.add(label);
			//add label to frame(kevin helped me)
			frame.add(panel);	
			//add panel to frame(kevin helped me)
			
					
		
}
	
}
