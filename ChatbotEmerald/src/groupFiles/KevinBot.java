package groupFiles;

public class KevinBot implements Chatbot{

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"hello"};
		
		for (int i = 0; i < triggers.length;)
		{
			if(EmeraldMain.findKeyword(userInput, triggers[i],0)>=0)
			{
				return true;
			}
				return false;
		}
		
		//duplicate for other trigger words
		if(EmeraldMain.findKeyword(userInput, "hello", 0)>=0)
		{
			return true;
		}
		
		return false;
	}

}
