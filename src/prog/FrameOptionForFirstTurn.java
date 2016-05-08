package prog;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameOptionForFirstTurn extends JFrame
{
	FrameOptionForFirstTurn(MainFrame MF)
	{
		this.setVisible(true);
		this.setSize(300, 100);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.getContentPane().setLayout(new GridBagLayout());
		
		GridBagConstraints layoutProperties= new GridBagConstraints();
		layoutProperties.fill= GridBagConstraints.CENTER;
		layoutProperties.gridx= 0;
		layoutProperties.gridy= 0;
		layoutProperties.insets= new Insets(10,1,1,1);
		
		JLabel question= new JLabel("Question");
		question.setText("Which team will be the first to answer?");		
		this.getContentPane().add(question, layoutProperties);
		
		
		JPanel buttonsPanel= new JPanel();
		
		buttonsPanel.setLayout(new FlowLayout(0,35,0));
		
		JButton firstTeam= new JButton(MF.getFirstTeamName());
		firstTeam.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event) 
				{
					MF.setTeamNumber(0);
					MF.setCounter(1);
					FrameOptionForFirstTurn.this.setVisible(false);
				}
			});
		buttonsPanel.add(firstTeam);
		
		JButton secoundTeam= new JButton(MF.getSecoundTeamName());
		secoundTeam.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event) 
				{
					MF.setTeamNumber(1);
					MF.setCounter(1);
					FrameOptionForFirstTurn.this.setVisible(false);
				}
			});
		buttonsPanel.add(secoundTeam);		
		
		
		layoutProperties.gridx= 0;
		layoutProperties.gridy= 1;
		layoutProperties.fill= GridBagConstraints.BOTH;
		this.getContentPane().add(buttonsPanel, layoutProperties);		
	}

}
