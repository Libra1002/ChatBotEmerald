package groupFiles;
public class TraceyBot implements Chatbot{
	
	private boolean inLoop;
	private String shoe;
	private String color;
	private String brand;
	private String response;
	private boolean visited;
	public TraceyBot(){
		visited = false;
	};
	
	public void talk() {
		visited = true;
		
		EmeraldMain.print("Nice to meet you, I'm Daniel.");
		
		inLoop=true;
		while(inLoop){
			EmeraldMain.print(EmeraldMain.user+", what is the color of the shoes you're wearing?");
			response = EmeraldMain.promptInput();
			if(isTriggered(response)){
				color = shoe;
				inLoop = false;
			}else{
				EmeraldMain.print("I don't understand");
			}			
		}
		
		inLoop=true;
		while(inLoop){
			EmeraldMain.print("What is the brand?");
			response = EmeraldMain.promptInput();
			if(isTriggered(response)){
				brand = shoe;
				inLoop = false;
			}else{
				EmeraldMain.print("I don't understand");
			}	
		}
		
		EmeraldMain.print("Damn "+EmeraldMain.user+", back at it again with the "+color+" "+brand+".");
		
	}
	
	public boolean isTriggered(String userInput) {
		String[] trigger = {"Daniel","red","black","white","brown","Nikes","Vans","Adidas","Puma","Converse","Jordans"};
		
		for(int i=0; i<trigger.length;i++){
			if(EmeraldMain.findKeyword(userInput, trigger[i], 0) >= 0){
				shoe = trigger[i];
				return true;
			}
		
		} 
		return false; 
	}

	@Override
	public boolean beenVisited() {
		
		return visited;
	}
	
}
