package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Client;

public class PanelClient extends JPanel implements ActionListener {

    private JTextField txtMessage;
    private JTextArea txtAChat;
	private Client client = new Client(this);

    public PanelClient() {
		this.client.start();
		this.setLayout(new BorderLayout());

        //Creation des composants
        this.txtMessage = new JTextField();
        this.txtMessage.setEditable(true);

        this.txtAChat = new JTextArea();
        this.txtAChat.setEditable(false);
        this.txtAChat.setText("");

        //Positionnement des composants

        this.add(this.txtAChat,   BorderLayout.CENTER);
        this.add(this.txtMessage, BorderLayout.SOUTH);

        //activation des composants

        
        this.txtMessage.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == txtMessage) {
            String message = this.txtMessage.getText();
            this.client.setMessage(message);
			this.txtMessage.setText(null);
		}
	}

    public void appendTxt(String msg) { this.txtAChat.append(msg + "\n");}

    public String getPseudo(){return this.client.getPseudo();}
    public String getTxt(){return this.txtMessage.getText();}
}
