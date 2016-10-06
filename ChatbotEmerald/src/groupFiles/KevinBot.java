package groupFiles;

public class KevinBot implements Chatbot{

	private boolean visited;
	public KevinBot()
	{
		visited = false;
	}
	
	@Override
	public void talk() {
		visited = true;
		String[] jokes = {"Why did the duck cross the road?"};
		String[] answers = {"To prove he wasn't a chicken."};
		String pun = "ba dum tss";
		// TODO Auto-generated method stub
		
	}

	@Override
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
