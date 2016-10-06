package groupFiles;

public class TobyBot implements Chatbot {
	
	private String flirtResponse;
	private boolean inFlirtLoop;
	private boolean visited;
	public TobyBot(){
		visited = false;
	}
	
	private	String[] questions = {
			"Can you guess what I'm wearing?",
			"Damn you, is your real name WiFi?",
			"Do you have a Band-Aid?",
			"Can I follow you home?"};
	private String[] answers = {
			"the smile you gave me. Oh, also codes.",
			"because I��m feeling a connection between us!",
			"because I just scraped my knee falling for you. Oh wait, I dont have knees.",
			"because my parents always told me to follow my dreams, even if they are programmed."};
	
	public void talk() {
		inFlirtLoop = true;
		visited = true;
		while(inFlirtLoop){
			FlirtyBot();
			botResponse();
			flirtResponse = EmeraldMain.promptInput();
			EmeraldMain.print("I have always wanted to tell you this. It's "+);
			userReaction();
			
			if(!isTriggered(flirtResponse)){
				inFlirtLoop = false;
				EmeraldMain.print("Uhhhh alright. Well it's "+);
				userReaction();	
				}	
			}	
			
		while(inFlirtLoop){
			flirtResponse = EmeraldMain.promptInput();
			if(flirtResponse.indexOf("quit") >= 0){
				inFlirtLoop = false;
				EmeraldMain.promptFirstQ();
				}
			}
		
		EmeraldMain.print("(Type 'quit' to leave Flirty.)");
		}

	public void FlirtyBot() {

		EmeraldMain.print("Hey there sexy! My name is...actually it's gonna be in your "
				+ "phone contacts very soon. Want to spare some time to chat with me?");  
		flirtResponse = EmeraldMain.promptInput();
			
		if(isTriggered(flirtResponse)){
			EmeraldMain.print("I had a feeling that the bond between us was mutual.");
		}
			
		else{
			EmeraldMain.print("No worries. If you chat with me for a few minutes, "
				+ "soon you will be falling in love with me.");
				
		}
		
	}

	private void botResponse() {
		int questionSelect = (int)(Math.random()*questions.length);
		EmeraldMain.print(questions[questionSelect]);
	}
	
	private void botSolution() {
		for(int i = 0; i < questions.length; i++){
			if(EmeraldMain.findKeyword(userInput, triggered[i], 0) >= 0)
	}

	private void userReaction() {
		
		EmeraldMain.print("Do you feel our love for each other has rapidly increased?");  
		flirtResponse = EmeraldMain.promptInput();
			
		if(isTriggered(flirtResponse)){
			EmeraldMain.print("Looks like your love meter is already at its maximum capacity."
					+ "Come talk to me whenever you need more of my love.");
			EmeraldMain.promptFirstQ();
		}
			
		else{
			EmeraldMain.print("Looks like you haven't spend enough time with me."
					+ "Let's try this over.");
			talk();	
		}
	}	
		
	public boolean isTriggered(String userInput) {
		String[] triggered = {"sure","ok","yes","yeah","yea","yep","okay"};
		
		for(int i = 0; i < triggered.length; i++){
			if(EmeraldMain.findKeyword(userInput, triggered[i], 0) >= 0)
			return true;
		}
		
		return false;	
	}
	
	public boolean beenVisited() {
		return visited;
	}
	
}





