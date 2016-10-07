package groupFiles;

public class FultonBot implements Chatbot {
	
	private boolean inSongLoop;
	private boolean visited;
	private String snowmanResponse;
	private String[] gameSong = {"Do you wanna play a game?","Come on lets go and play",
			"For the first time in forever","Come out and play","It's like you've gone away...",
			"We used to be best buddies","And now we're not","I wish you would tell me why!"};
	public FultonBot(){
		visited = false;
	}
	
	public void talk() {
		inSongLoop = true;
		visited = true;
		EmeraldMain.print(gameSong[0]);
		while(inSongLoop){
			snowmanResponse = EmeraldMain.promptInput();
			printResponse();
			
			if(snowmanResponse.indexOf("quit") >= 0){
				inSongLoop = false;
				EmeraldMain.promptFirstQ();
			} 
		}
		EmeraldMain.print("(Type 'quit' to go back.");
	}
	
	private void printResponse() {
		int count = 1;
		if(!((EmeraldMain.promptInput()).length() < 0)){
			EmeraldMain.print(gameSong[count]);
			
			while(count <= gameSong.length - 1)
			{
			count++;
			}
		}
	}

	public boolean isTriggered(String userInput) {
		String[] triggers = {"Yes","No","Snowman","Quit"};
		
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
