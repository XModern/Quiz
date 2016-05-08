package prog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class MainFrame extends JFrame
{
	private final int lineSize= 5;	
	private final String firstTeamName= "Teachers";
	private final String secoundTeamName= "Students";
	private int score1= 0;
	private int score2= 0;
	
	private int teamNumber= 0;
	
	private QuestionsPanel mainPanel= new QuestionsPanel();
	
	private JLabel leftTeamName= new JLabel();
	private JLabel rightTeamName= new JLabel();
	private JLabel leftTeamScore= new JLabel();
	private JLabel rightTeamScore= new JLabel();
	private JLabel VS= new JLabel("VS");	
	
	private JPanel scorePanel= new JPanel();
	private JPanel questionPanel= new JPanel();
	
	private JScrollPane panelScroll= new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
													 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	private int counter= 0;
	
	MainFrame()
	{
		super();
		this.setVisible(true);
		this.setTitle("QuizProg");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
				
		this.add(mainPanel);

		mainPanel.setLayout(new BorderLayout());
		
	}
	
	public String getFirstTeamName()
	{
		return firstTeamName;
	}
	
	public String getSecoundTeamName()
	{
		return secoundTeamName;
	}
	
	public int getTeamNumber()
	{
		return teamNumber;
	}
	
	public void setTeamNumber(int number)
	{
		teamNumber= number;
	}
	
	public void setCounter(int counter)
	{
		this.counter= counter;
	}
	
	public void setScore1(int score)
	{
		score1= score;
	}
	
	public void setScore2(int score)
	{
		score2= score;
	}
	
	public int getScore1()
	{
		return score1;
	}
	
	public int getScore2()
	{
		return score2;
	}
	
	public JLabel getLeftTeamScore()
	{
		return leftTeamScore;
	}
	
	public JLabel getRightTeamScore()
	{
		return rightTeamScore;
	}
	
	public int getCounter()
	{
		return counter;
	}
	
	public void QuestionPanelCreation(ArrayList<Question> questions)
	{		
		scorePanel.setVisible(true);
		scorePanel.setLayout(new GridBagLayout());
		
		GridBagConstraints scorePanelProps= new GridBagConstraints();
		scorePanelProps.gridx= 0;
		scorePanelProps.gridy= 0;
		scorePanelProps.gridwidth= 1;
		scorePanelProps.gridheight= 2;
		scorePanelProps.weightx= 0.1;
		scorePanelProps.weighty= 0.1;
		scorePanelProps.anchor= GridBagConstraints.NORTH;
		scorePanelProps.fill= GridBagConstraints.CENTER;
		scorePanelProps.ipadx= 0;
		scorePanelProps.ipady= 0;		
		
		Font textFont= new Font("Arial",Font.BOLD, 16);

		leftTeamName.setText(firstTeamName);
		leftTeamName.setFont(textFont);		
		
		scorePanelProps.gridy= 0;
		scorePanel.add(leftTeamName, scorePanelProps);
		
		VS.setFont(textFont);
		
		scorePanelProps.gridx++;
		scorePanelProps.gridy= 0;
		scorePanel.add(VS, scorePanelProps);			
		
		rightTeamName.setText(secoundTeamName);
		rightTeamName.setFont(textFont);
		
		scorePanelProps.gridx++;
		scorePanelProps.gridy= 0;
		scorePanel.add(rightTeamName, scorePanelProps);
		
		leftTeamScore.setText(score1+"");
		leftTeamScore.setFont(textFont);
		
		scorePanelProps.insets= new Insets(20,0,1,1);
		scorePanelProps.gridx= 0;
		scorePanelProps.gridy= 1;
		scorePanel.add(leftTeamScore, scorePanelProps);
		
		scorePanelProps.insets= new Insets(20,0,1,1);
		scorePanelProps.gridx++;
		scorePanelProps.gridy= 1;
		scorePanel.add(new JLabel(), scorePanelProps);
		
		rightTeamScore.setText(score2+"");
		rightTeamScore.setFont(textFont);
		
		scorePanelProps.insets= new Insets(20,0,1,1);
		scorePanelProps.gridx++;
		scorePanelProps.gridy= 1;
		scorePanel.add(rightTeamScore, scorePanelProps);
		
		JButton changeTeamButton= new JButton("Change Team");
		changeTeamButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{
				if(counter!= 0)
				{
					if(teamNumber==0)
					{
						teamNumber= 1;
					}
					else if(teamNumber==1)
					{
						teamNumber= 0;
					}
				}
				else
				{		
					FrameOptionForFirstTurn FOFT= new FrameOptionForFirstTurn(MainFrame.this);
				}
			}			
		});
		
		scorePanelProps.fill= scorePanelProps.BOTH;
		scorePanelProps.gridx= 1;
		scorePanelProps.gridy= 2;
		scorePanel.add(changeTeamButton, scorePanelProps);
		
		mainPanel.add(scorePanel, BorderLayout.PAGE_START);
		
		questionPanel.setVisible(true);

		panelScroll.setViewportView(questionPanel);
		
		questionPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints layoutProperties= new GridBagConstraints();
		layoutProperties.gridx= 0;
		layoutProperties.gridy= 1;
		layoutProperties.gridwidth= 1;
		layoutProperties.gridheight= 1;
		layoutProperties.weightx= 0.1;
		layoutProperties.weighty= 0.1;
		layoutProperties.anchor= GridBagConstraints.NORTH;
		layoutProperties.fill= GridBagConstraints.BOTH;
		layoutProperties.ipadx= 0;
		layoutProperties.ipady= 100;
		
		layoutProperties.insets= new Insets(0/*Top*/, 
										   	10/*Left*/, 
											10/*Bottom*/, 
											10/*Right*/);
		
		for(int i=0;i<questions.size();i++)
		{
			
			if(layoutProperties.gridx>=lineSize)
			{
				layoutProperties.gridx=0;
				layoutProperties.gridy++;				
			}
			
			if((i<lineSize)&&(i+1>questions.size()-lineSize))
			{
				layoutProperties.insets= new Insets(25/*Top*/,
													10/*Left*/,
													100/*Bottom*/,
													10/*Right*/);
			}
			else if(i<lineSize)
			{
				layoutProperties.insets= new Insets(25/*Top*/, 
													10/*Left*/, 
													10/*Bottom*/, 
													10/*Right*/);
			}
			else if(i>=questions.size()-lineSize)
			{
				layoutProperties.insets= new Insets(10/*Top*/, 
													10/*Left*/, 
													25/*Bottom*/, 
													10/*Right*/);
			}
			else
			{
				layoutProperties.insets= new Insets(10/*Top*/, 
													10/*Left*/, 
													10/*Bottom*/, 
													10/*Right*/);
			}
			layoutProperties.gridx++;
			QuestionButton questionButton= new QuestionButton(questions.get(i), this);
			questionPanel.add(questionButton, layoutProperties);
		}
		
		mainPanel.add(panelScroll,BorderLayout.CENTER);
		
		mainPanel.validate();
		
		panelScroll.repaint();
		panelScroll.validate();
		panelScroll.setVisible(false);
		panelScroll.setVisible(true);
		
		questionPanel.repaint();
		questionPanel.validate();
		questionPanel.setVisible(false);
		questionPanel.setVisible(true);
	}

}
