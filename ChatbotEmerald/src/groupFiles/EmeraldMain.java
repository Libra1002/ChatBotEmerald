package groupFiles;

import java.util.Scanner;

public class EmeraldMain
{		
	static String response;
	static boolean inMainLoop;
	static Scanner input;
	static String user;
	//list all the chatbot available under this class
	//static Chatbot school;
	static Chatbot fulton;
	static Chatbot toby;
	static Chatbot tracey;
	static Chatbot kevin;
	static String[] characters={"Snowman", "Daniel", "Flirty","Joker"};
	
	
	public static void main(String[] args) {
		 //demostrateStringMethods();
		 createFields();
		 promptName();
	}	
	
	public static void promptName() {
		
		print("Enter your name");
		user = input.nextLine();
		String character = randomChar();
		print("Hey, "+user+". Let me introduce my friend, "+character);
		if(tracey.isTriggered(character)){
			tracey.talk();
		}else if(kevin.isTriggered(character)){
			kevin.talk();
		}else if(fulton.isTriggered(character)){
			fulton.talk();
		}else if(toby.isTriggered(character)){
			toby.talk();
		}
			
	}
	
	public static void promptFirstQ() {
		
			boolean notValid = true;
			
			while(notValid){
				String newChara = randomChar();
				if(fulton.isTriggered(newChara) && !fulton.beenVisited()){
					fulton.talk();
					notValid = false;
				}else if(kevin.isTriggered(newChara) && !kevin.beenVisited()){
					kevin.talk();
					notValid = false;
				}else if(tracey.isTriggered(newChara) && !tracey.beenVisited()){
					tracey.talk();
					notValid = false;
				}else if(!toby.beenVisited()){
					toby.talk();
					notValid = false;
				}else if(fulton.beenVisited() && kevin.beenVisited() && tracey.beenVisited() && toby.beenVisited()){
					promptBored();
					notValid = false;
					//we can make an array of random statements
				}
			}
						
	}
	
	public static String randomChar() {
		
		int intro = (int)(Math.random()*characters.length);
		return characters[intro];
	}
	
	public static void promptBored() {
		
		boolean boring = true;
		while (boring){
			print("I'm bored. (say quit if you want to restart.");
			response = promptInput();
			if(findKeyword(response, "quit", 0) >= 0){
				boring = false;
				promptName();
			}
		}
	}

		public static int findKeyword(String searchString, String keyword, int StartPsn) {
		searchString = searchString.trim();
		searchString = searchString.toLowerCase(); 
		keyword = keyword.toLowerCase();

		int psn = searchString.indexOf(keyword);
		
	
		while(psn >=0){
	
			String before = " ";
			String after = " ";

			if(psn >0){
				before = searchString.substring(psn-1, psn);
			}
	
			if(psn+ keyword.length() <searchString.length()){
				after = searchString.substring
						(psn + keyword.length(), psn + keyword.length()+1);
			}
			if(before.compareTo("a")< 0 && after.compareTo("a") <0 && noNegations(searchString,psn)){
				return psn;
			}else{
	
			psn = searchString.indexOf(keyword,psn+1);
				}
			}
			
			return -1;	
		}
		
		/**This is a helper method. A helper method is a method designed for "helping" a larger 
		 *method. Because of this, helper methods are generally private because they are only 
		 *used by only used by the methods they are helping. Also, when you do your project, I
		 *expect to see helper methods because they are also make code more READABLE
		 *@param searchString (always lowercase)
		 *@param psn
		 *@return "true" if there is no negation words in front of psn
		 */
		private static boolean noNegations(String searchString, int psn) {
			//check to see if the word "no" is in front of psn
			//check to see if there are 3 spaces in front
			//check to see if "no" is there
			if(psn -3 >=0 && searchString.substring(psn-3,psn).equals("no ")){
				return false;
			}
			//not
			if(psn -4 >=0 && searchString.substring(psn-4,psn).equals("not ")){
				return false;
				
			}
			//never
			if(psn -6 >=0 && searchString.substring(psn-6,psn).equals("never ")){
				return false;
			}	
			//n't
			if(psn -4 >=0 && searchString.substring(psn-4,psn).equals("n't ")){
				return false;
			}
				
			return true;
		}

		public static String promptInput() {
			String userInput = input.nextLine();
			return userInput;
		}
		
		private static void createFields() {
			input = new Scanner (System.in);
			fulton = new FultonBot();
			toby = new TobyBot();
			tracey = new TraceyBot();
			kevin = new KevinBot();
			user = "";
		}
		
		
		public static void print(String s) {
			String printString = "";
			int cutoff = 35;
			//check for words to add, IOW s has a length >0
			while(s.length() >0){
				String cut = "";
				String nextWord = "";
				//check to see if the next word will fit on line
				//there must still be words to add
				while(cut.length() +nextWord.length() <cutoff && s.length() >0){
					//add the next word to the line
					cut += nextWord;
					
					s = s.substring(nextWord.length());
					
					//identify the following word without the space
					int endOfWord = s.indexOf(" ");
					//if there are no more spaces, 
					//this is the last word so add the whole thing
					if(endOfWord == -1){
						endOfWord = s.length() -1;//-1 for index
					}
					
					nextWord = s.substring(0, endOfWord+1);
				}			
				
				printString += cut+"\n";
			}
			
			System.out.println(printString);
		}

	}


