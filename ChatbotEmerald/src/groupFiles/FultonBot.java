package groupFiles;

public class FultonBot implements Chatbot {
	
	private boolean inSongLoop;
	private boolean visited;
	public FultonBot(){
		visited = false;
	}
	
	public void talk() {
		inSongLoop = true;
		visited = true;
		while(inSongLoop){
			
			//static call on promptInput method from FultonMain class
			schoolResponse = EmeraldMain.promptInput();
			if(schoolResponse.indexOf("quit") >= 0){
				inSongLoop = false;
				EmeraldMain.promptFirstQ();
			} 
			EmeraldMain.print("That's my favorite part about school");
		}
		EmeraldMain.print("(Type 'quit' to go back.");
	}

	public boolean isTriggered(String userInput) {
		String[] triggers = {"Yes","No","Snowman"};
		
		for(int i = 0; i < triggers.length; ){
			if(!(EmeraldMain.findKeyword(userInput, triggers[i], 0) >= 0)){
			i++;
			}
			return true;
		}
		return false;
	}

	public boolean beenVisited() {
		return visited;
	}

}
