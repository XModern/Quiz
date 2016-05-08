package prog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuestionWindowPanel extends JFrame
{
	QuestionWindowPanel(Question question, MainFrame MF)
	{
		this.setVisible(true);
		this.setSize(500, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		
		JLabel questionText= new JLabel();		
		questionText.setText(question.getQuestion());
		questionText.setHorizontalAlignment(JLabel.CENTER);
		
		this.getContentPane().setLayout(new BorderLayout());
		
		this.getContentPane().add(questionText, BorderLayout.NORTH);
		
		JPanel buttonsPanel= new JPanel();
		
		JButton yesButton= new JButton("Yes");
		yesButton.setPreferredSize(new Dimension(100, 25));
		yesButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event) 
				{
					if(MF.getTeamNumber()==0)
					{
						if(question.checkAnswer(1)== true)
						{
							MF.setScore1(MF.getScore1()+1);
							MF.getLeftTeamScore().setText(MF.getScore1()+"");
						}
					}
					else if(MF.getTeamNumber()==1)
					{
						if(question.checkAnswer(1)==true)
						{
							MF.setScore2(MF.getScore2()+1);
							MF.getRightTeamScore().setText(MF.getScore2()+"");
						}
					}
					
					QuestionWindowPanel.this.setVisible(false);
				}			
			});
		
		JButton noButton= new JButton("No");
		noButton.setPreferredSize(new Dimension(100, 25));
		noButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event) 
				{
					if(MF.getTeamNumber()==0)
					{
						if(question.checkAnswer(0)== true)
						{
							MF.setScore1(MF.getScore1()+1);
							MF.getLeftTeamScore().setText(MF.getScore1()+"");
						}
					}
					else if(MF.getTeamNumber()==1)
					{
						if(question.checkAnswer(0)==true)
						{
							MF.setScore2(MF.getScore2()+1);
							MF.getRightTeamScore().setText(MF.getScore2()+"");
						}
					}
					QuestionWindowPanel.this.setVisible(false);
				}			
			});
		
		buttonsPanel.add(yesButton);
		buttonsPanel.add(noButton);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER,50,0));
		
		this.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
	}

}
