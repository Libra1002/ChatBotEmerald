package groupFiles;

public class FultonBot implements Chatbot {
	
	public void talk() {
		
	}

	public boolean isTriggered(String userInput) {
		String[] triggers = {""};
		
		for(int i = 0; i < triggers.length; ){
			if(!(EmeraldMain.findKeyword(userInput, triggers[i], 0) >= 0)){
			i++;
			}
			return true;
		}
		return false;
	}

}
