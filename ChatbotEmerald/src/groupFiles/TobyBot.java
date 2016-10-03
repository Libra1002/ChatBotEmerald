package groupFiles;

public class TobyBot implements Chatbot {
	private String jokeResponse;
	private boolean inJokeLoop;
	
	private int jokeCount;
	
	public TobyBot(){
		jokeCount = 0;
	}
	
	public void talk() {
		inJokeLoop = true;
		while(inJokeLoop){
			EmeraldMain.print("(Type 'quit' to go back.)");
			jokeResponse = EmeraldMain.promptInput();
			if(jokeResponse.indexOf("quit") >=0){
				inJokeLoop = false;
				EmeraldMain.promptForever();
			}
			EmeraldMain.print("That's my favorite part about ");
		}
	}

	public boolean isTriggered(String userInput) {
		String[] triggers = {"school"};
		
		for(int i = 0; i < triggers.length; ){
			if(!(EmeraldMain.findKeyword(userInput, triggers[i], 0) >= 0)){
			i++;
			}
			return true;
		}
		
		if(EmeraldMain.findKeyword(userInput, "school", 0) >=0){
			return true;
		}
		
		return false;
	}	
}



