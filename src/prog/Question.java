package prog;

public class Question 
{
	private String question= "";
	private int trueAnswer=0;
	private int userAnswer=0;
	
	public void setQuestion(String question)
	{
		this.question=question;
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public void setTrueAnswer(int answer)
	{
		trueAnswer= answer;
	}
	
	public void setUserAnswer(int answer)
	{
		userAnswer= answer;
	}
	
	public boolean checkUserAnswer()
	{
		return trueAnswer== userAnswer;
	}
	
	public boolean checkAnswer(int answer)
	{
		return trueAnswer== answer;
	}

}
