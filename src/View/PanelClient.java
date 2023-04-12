package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Client;

public class PanelClient extends JPanel implements ActionListener {

    private JTextField txtMessage;
	private Client client = new Client();

    public PanelClient() {
		client.start();

		this.setLayout(new BorderLayout());

        //Creation des composants
        this.txtMessage = new JTextField();
        this.txtMessage.setEditable(true);

        //Positionnement des composants

        this.add(this.txtMessage, BorderLayout.SOUTH);

        //activation des composants

        this.txtMessage.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == txtMessage) {
			client.setMessage(txtMessage.getText());
			txtMessage.setText(null);
		}
	}
}
