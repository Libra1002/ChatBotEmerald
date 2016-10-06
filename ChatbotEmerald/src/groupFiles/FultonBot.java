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
		while(inSongLoop){
			snowmanResponse = EmeraldMain.promptInput();
			for(int i = 0; i <= gameSong.length; i++){
				EmeraldMain.print("gameSong[i]");
			}
			if(snowmanResponse.indexOf("quit") >= 0){
				inSongLoop = false;
				EmeraldMain.promptFirstQ();
			} 
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