import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class Notification {

	public static void main(String[] args) {

		String message1 = "You have a notification, Nirvik. Please be advised that you have ";
		String message2 = "days left for your GRE test. Scheduled on 29-07-2014.";
		String header = "GRE alert notification for Nirvik!!";
		final JFrame frame = new JFrame();
		frame.setSize(300, 125);
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 1.0f;
		constraints.weighty = 1.0f;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.fill = GridBagConstraints.BOTH;
		JLabel headingLabel = new JLabel(header);
		headingLabel.setIcon(null);
		headingLabel.setOpaque(false);
		frame.add(headingLabel, constraints);
		constraints.gridx++;
		constraints.weightx = 0f;
		constraints.weighty = 0f;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.NORTH;
		JButton closeButton = new JButton(new AbstractAction("X") {

			@Override
			public void actionPerformed(final ActionEvent e) {
				frame.dispose();
			}
		});
		closeButton.setMargin(new Insets(1, 4, 1, 4));
		closeButton.setFocusable(false);
		frame.add(closeButton, constraints);
		constraints.gridx = 0;
		constraints.gridy++;
		constraints.weightx = 1.0f;
		constraints.weighty = 1.0f;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.fill = GridBagConstraints.BOTH;

		long difference = 0;
		Date date = new Date();
		DateTime start = new DateTime(date);
		DateTime end = new DateTime(2014, 07, 29, 0, 0, 0);
		difference = Days.daysBetween(start, end).getDays();

		JLabel messageLabel = new JLabel("<Html>" + message1 + " " + difference
				+ " " + message2);
		frame.add(messageLabel, constraints);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(
				frame.getGraphicsConfiguration());
		frame.setLocation(scrSize.width - frame.getWidth(), scrSize.height
				- toolHeight.bottom - frame.getHeight());
		frame.setVisible(true);
		new Thread(){
		      @Override
		      public void run() {
		           try {
		                  Thread.sleep(500000); // time after which pop up will be disappeared.
		                  frame.dispose();
		           } catch (InterruptedException e) {
		                  e.printStackTrace();
		           }
		      };
		}.start();

	}
}
