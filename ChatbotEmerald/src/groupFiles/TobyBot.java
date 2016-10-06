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
			"Know what's on the menu?",
			"Do you have a Band-Aid?",
			"Can I follow you home?"};
	private String[] answers = {
			"the smile you gave me. Oh, also codes.",
			"Me-N-U (Me&You) and .",
			"because I just scraped my knee falling for you. Oh wait, I dont have knees.",
			"because my parents always told me to follow my dreams, even if they are programmed."};
	
	public void talk() {
		inFlirtLoop = true;
		visited = true;
		while(inFlirtLoop){
			botResponse();
			flirtResponse = EmeraldMain.promptInput();
			EmeraldMain.print("I have always wanted to tell you this. It's ");
				
			if(!isTriggered(flirtResponse)){
				inFlirtLoop = false;
				EmeraldMain.print("Uhhhh alright. Well it's ");
					
			}
		}	
	}
	
	public static void FlirtyBot() {

		inFlirtLoop = true;
		while(inFlirtyLoop){
			EmeraldMain.print("Hey there sexy! My name is...actually it's gonna be in your "
					+ "phone contacts very soon. Want to spare some time to chat with me?");  
			flirtResponse = EmeraldMain.promptInput();
			
			if(findKeyword(response, "sure","ok","yes","yeah","yea","yep","okay",0) >=0){
				EmeraldMain.print("I had a feeling that the bond between us was mutual.");
			}
			
			else{
				EmeraldMain.print("No worries. If you chat with me for a few minutes, "
						+ "soon you will be falling in love with me.");
			}
		}
	}


	private void botResponse() {
		int questionSelect = (int)(Math.random()*questions.length);
		EmeraldMain.print(questions[questionSelect]);
	}
	
	private void botSolution() {
	 .equals( .indexOf()));
	}

	public boolean isTriggered(String userInput) {
		String[] triggers = {"sure","ok","yes","yeah","yea","yep","okay"};
		
		for(int i = 0; i < triggers.length; i++){
			if(EmeraldMain.findKeyword(userInput, triggers[i], 0) >= 0)
			return true;
		}
		
		return false;	
	}
	
	public boolean beenVisited() {
		return visited;
	}
}





