package genelectrovise.hypixel.skyblock.stockanalyser.display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class Window {

	private JFrame frame;
	private JButton btnNetwork = new JButton("Network");
	private JButton btnAdd = new JButton("Add");
	private JButton btnRequest = new JButton("Request");
	private JPanel panel = new JPanel();
	private JTextPane paneTracked = new JTextPane();
	private JTextPane paneInformation = new JTextPane();

	public static void main(String[] args) {
		new WindowManager().start();
	}

	/**
	 * Launch the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public void doWindow() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		createBasicComponents();
	}

	/**
	 * Creates the backing components for the GUI
	 */
	private void createBasicComponents() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1080, 840);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel.setBorder(new TitledBorder(null, "Hypixel Bazaar Stock Analyser - GenElectrovise", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 1054, 789);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		btnRequest.setBounds(955, 755, 89, 23);
		panel.add(btnRequest);

		btnAdd.setBounds(955, 721, 89, 23);
		panel.add(btnAdd);

		paneTracked.setBounds(10, 23, 225, 755);
		panel.add(paneTracked);

		paneInformation.setBounds(245, 23, 225, 755);
		panel.add(paneInformation);

		btnNetwork.setBounds(955, 687, 89, 23);
		panel.add(btnNetwork);
		frame.setResizable(false);
	}
}
