package groupFiles;

public class FultonSchool implements Chatbot {

	private boolean inSchoolLoop;
	private String schoolResponse;
	
	public void talk() {
		inSchoolLoop = true;
		while(inSchoolLoop){
			EmeraldMain.print("(Type 'quit' to go back.");
			//static call on promptInput method from FultonMain class
			schoolResponse = EmeraldMain.promptInput();
			if(schoolResponse.indexOf("quit") >= 0){
				inSchoolLoop = false;
				EmeraldMain.promptForever();
			} 
			EmeraldMain.print("That's my favorite part about school");
		}

	}

	public boolean isTriggered(String userInput) {
		String[] triggers = {"school","class","teacher"};
		//idea: create a for loop to iterate
		//through your array to triggers
		
		for(int i = 0; i < triggers.length; i++){
			if(EmeraldMain.findKeyword(userInput, triggers[i], 0) >= 0){
			return true;
			}
			return false;
		}
		

		if(EmeraldMain.findKeyword(userInput, "class", 0) >= 0){
			return true;
		}

		if(EmeraldMain.findKeyword(userInput, "school", 0) >= 0){
			return true;
		}
		return false;
	}

}
