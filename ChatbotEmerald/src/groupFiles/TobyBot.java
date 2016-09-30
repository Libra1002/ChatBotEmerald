package groupFiles;

public class TobyBot {
	private boolean inSchoolLoop;
	private String schoolResponse;
	
	public void talk() {
		inSchoolLoop = true;
		while(inSchoolLoop){
			EmeraldMain.print("(Type 'quit' to go back.)");
			//static call on promptInput method from TobyMain class
			schoolResponse = EmeraldMain.promptInput();
			if(schoolResponse.indexOf("quit") >=0){
				inSchoolLoop = false;
				EmeraldMain.promptForever();
			}
			EmeraldMain.print("That's my favorite part about school");
		}
	}

	public boolean isTriggered(String userInput) {
		String[] triggers = {"school"};
		
		if(EmeraldMain.findKeyword(userInput, "school", 0) >=0){
			return true;
		}
		
		return false;
	}	
}



