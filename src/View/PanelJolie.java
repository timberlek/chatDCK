package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelJolie extends JPanel
{
    private JPanel pnlJolie;
    private JLabel lblImage;

    public PanelJolie()
    {
        this.setBackground(new Color(21, 31, 40));

        /*Creation des composants */
        
        this.pnlJolie = new JPanel();
        Icon logo = new ImageIcon(getClass().getResource("./images/logo.png"));  
        this.lblImage = new JLabel(logo);

        

        

        /*positionnement des composants */

        this.add(this.lblImage);
        this.add(this.pnlJolie);
        

    }
}
