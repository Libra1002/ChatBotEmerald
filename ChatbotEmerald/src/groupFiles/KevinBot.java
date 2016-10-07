package groupFiles;

public class KevinBot implements Chatbot{

	private boolean visited;
	private boolean jokeLoop;
	private	String[] jokes = {"Why did the duck cross the road?"};
	private String[] answers = {"To prove he wasn't a chicken."};
	private String pun = "ba dum tss";
	private String jokeResponse;

	public KevinBot()
	{
		visited = false;
	}
	
	public void talk() {
		visited = true;
		jokeLoop = true;
		EmeraldMain.print("Well hello there.");
		while(jokeLoop)
		{
			jokeResponse = EmeraldMain.promptInput();
			EmeraldMain.print("Wanna hear a joke?");
			
			if(jokeResponse.indexOf("quit") >= 0)
			{
				EmeraldMain.print ("Aw you're no fun....");
				jokeLoop = false;
				EmeraldMain.promptFirstQ();
			} else
			  {
			  	int num = (int)(Math.random()*jokes.length);
				if(jokeResponse.indexOf("yes") >= 0)
				{
					EmeraldMain.print(jokes[num]);
					EmeraldMain.print(answers[num] + ", " + pun);
					EmeraldMain.print("Wanna hear another?");
				}
			  }
		}
	}

	public boolean isTriggered(String userInput) {
		String[] triggers = {"joke"};
		
		for (int i = 0; i < triggers.length;i++)
		{
			if(EmeraldMain.findKeyword(userInput, triggers[i],0)>=0)
			{
				return true;
			}
				return false;
		}
		
		//duplicate for other trigger words
		if(EmeraldMain.findKeyword(userInput, "joke", 0)>=0)
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean beenVisited() {
		
		return visited;
	}

}
