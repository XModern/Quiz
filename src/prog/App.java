package prog;

import java.util.ArrayList;

public class App 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MainFrame mF= new MainFrame();
		ArrayList<Question> a= new ArrayList<Question>();
		for(int i=0;i<100;i++)
		{
			Question q= new Question();
			q.setQuestion(i+"?");
			a.add(q);
		}
		mF.QuestionPanelCreation(a);
	}

}
