package groupFiles;

public class FultonBot implements Chatbot {
	
	private boolean inLoop;
	private boolean inSongLoop;
	private boolean visited;
	private String snowmanResponse;
	private String[] gameSong = {"Do you wanna play a game?","Come on lets go and play",
			"For the first time in forever","Come out and play","It's like you've gone away...",
			"We used to be best buddies","And now we're not","I wish you would tell me why! "};
	public FultonBot(){
		visited = false;
	}
	
	public void talk() {
		inSongLoop = true;
		visited = true;
		EmeraldMain.print("What song is this a parody of?");
		EmeraldMain.print(gameSong[0]);
		songLoop();
		while(inSongLoop){
			snowmanResponse = EmeraldMain.promptInput();
			
			if(snowmanResponse.indexOf("build a snowman") >= 0){
				EmeraldMain.print("Enjoy the rest of the song ");
			}
			
			if(snowmanResponse.indexOf("quit") >= 0){
				inSongLoop = false;
				EmeraldMain.promptFirstQ();
			} 
		}
	}
	
	private void songLoop() {
		inLoop = true;
		int count = 0;
		while(inLoop){
			count++;
			
			if(count == gameSong.length-1){
				inLoop = false;
			}
			
			if(!((EmeraldMain.promptInput()).length() < 0)){
			EmeraldMain.print(gameSong[count]);
			}
		}
		EmeraldMain.print("Type 'quit' to visit someone else.");
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
