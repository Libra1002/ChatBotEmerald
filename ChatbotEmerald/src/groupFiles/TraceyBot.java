package groupFiles;

public class TraceyBot implements Chatbot{
	
	private boolean inSchoolLoop;
	private String schoolResponse;
	
	public void talk() {
		inSchoolLoop=true;
		while(inSchoolLoop){
			EmeraldMain.print("(Type quick to go back)");
			//static call on promptInput method from KongMain class
			schoolResponse = EmeraldMain.promptInput();
			if(schoolResponse.indexOf("quit")>=0){
				inSchoolLoop = false;
				EmeraldMain.promptForever();
			}
			EmeraldMain.print("That's my favorite part about school.");
		}
		
	}
	
	public boolean isTriggered(String userInput) {
		String[] trigger = {"school","class","teacher"};
		
		for(int i=0; i<trigger.length;i++){
			if(EmeraldMain.findKeyword(userInput, trigger[i], 0) >= 0){
			return true;
			}
		
		}
		return false;
	}
	
}
