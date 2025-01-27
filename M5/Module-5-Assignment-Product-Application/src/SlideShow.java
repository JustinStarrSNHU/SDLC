import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.BLUE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	
	
	// Only the following two methods should be updated as we already have a working product, and the only changes the client has requested is that we shift our focus on wellness/detox destinations. 
	
	
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/TestImage1.jpg") + "'</body></html>"; // I am keeping the grand canyon because I don't think this destination needed to change in regards to having wellness/detox destinations
		} 
		
		// The following four images have been updated to reflect wellness/detox destinations.
		
		else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Starr-091223-1170-Roystonea_regia-habitat_view_Four_Seasons_Resort_from_Ohua_boat-Wailea-Maui_(24967016506).jpg") + "'</body></html>"; // Four Seasons Maui, Hawaii Photo authors: Forest & Kim Starr, CC BY 3.0 US <https://creativecommons.org/licenses/by/3.0/us/deed.en>, via Wikimedia Commons
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Sky_Lagoon_Exterior.jpg") + "'</body></html>"; // Sky Lagoon, Iceland - image author: Laurenmcl, CC BY-SA 4.0 <https://creativecommons.org/licenses/by-sa/4.0>, via Wikimedia Commons
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Couples_Retreat_Garden.jpg") + "'</body></html>"; // Ouyuan garden, Chine - image author: 钉钉, CC BY-SA 4.0 <https://creativecommons.org/licenses/by-sa/4.0>, via Wikimedia Commons
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Spirit_Vine_Ayahuasca_Retreat_Center_In_Brazil.jpg") + "'</body></html>"; // The Spirit Vine Ayahuasca Retreat Center in Brazil - Image author: Spirit Vine Retreats, CC BY-SA 4.0 <https://creativecommons.org/licenses/by-sa/4.0>, via Wikimedia Commons
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 The Grand Canyon.</font> <br>Spectacular canyon views and hiking.</body></html>"; // Again, I am keeping the description that was already written for the grand canyon, keeping in mind that we do not want to change code that works and is not affected by the clients new shift in focus. For me, I believe that this is still considered a wellness destination.
		} 
		
		// The following four descriptors have been updated to reflect the four locations that have been now included. I have also included image contributors to give image authors the appropriate acknowledgement.
		
		else if (i==2){
			text = "<html><body>#2 Four Seasons Resort - Maui, Hawaii - They now offer customizable experiences which are specific to each guest and is great for <br>travelers who are looking for an upgraded spa experience.<br> Image authors: Forest & Kim Starr, CC BY 3.0 US <https://creativecommons.org/licenses/by/3.0/us/deed.en>, via Wikimedia Commons </body></html>"; 
		} else if (i==3){
			text = "<html><body>#3 Sky Lagoon, Iceland - An incredible destination for relaxing and detox. Watch the beautiful Aurora Borealis also <br> known as the Northern Lights or partake in the icelandic bathing culture in their geothermal waters. <br> Image Author: Laurenmcl, CC BY-SA 4.0 <https://creativecommons.org/licenses/by-sa/4.0>, via Wikimedia Commons</body></html>"; 
		} else if (i==4){
			text = "<html><body>#4 Ouyuan Garden, China - An incredible botanical garden where couples can retreat for spiritual wellness.<br> Image author: 钉钉, CC BY-SA 4.0 <https://creativecommons.org/licenses/by-sa/4.0>, via Wikimedia Commons</body></html>";
		} else if (i==5){
			text = "<html><body>#5 The Spirit Vine Ayahuasca Retreat Center in Brazil - An incredible spiritual retreal. Attend spiritual workshops, yoga classes and more...<br>Image author: Spirit Vine Retreats, CC BY-SA 4.0 <https://creativecommons.org/licenses/by-sa/4.0>, via Wikimedia Commons</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}