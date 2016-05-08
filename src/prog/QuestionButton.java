package prog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class QuestionButton extends JButton
{
	private Question question= null;
	
	QuestionButton()
	{
		super();
		this.setVisible(true);
	}
	
	QuestionButton(Question outside_question, MainFrame MF)
	{
		this.question= outside_question;
		this.setText(this.getQuestion());
		this.setName(this.getQuestion());
		
		this.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{
				if(MF.getCounter()!= 0)
				{
					QuestionWindowPanel a= new QuestionWindowPanel(question, MF);	
				}
			}			
		});
	}
	
	public String getQuestion()
	{
		return question.getQuestion();		
	}
	
	public boolean checkAnswer(int answer)
	{
		return question.checkAnswer(answer);
	}	
}
