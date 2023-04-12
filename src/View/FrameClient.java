package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class FrameClient extends JFrame {

	private PanelClient panelClient;

	public FrameClient() {
		this.setTitle("Client");
		this.setSize(new Dimension(400, 250));
		this.setLayout(new BorderLayout(5, 5));
		this.setLocationRelativeTo(null);

		this.panelClient = new PanelClient();

		this.add(this.panelClient);

		this.setVisible(true);
	}
}