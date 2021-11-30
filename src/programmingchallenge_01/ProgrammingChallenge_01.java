package programmingchallenge_01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProgrammingChallenge_01 {

    //CATEGORY 1
        final static String QANDA1 [][] = {{"What is the invention that made Piltover grow and more expandable?", 
                                     "From what city Ambessa Medarda comes to Piltover?",
                                     "Wha's the name of the drug used in Zaun to increse their strength?",
                                     "Who saved Jayce and her mother when he was a little boy?",
                                     "Wich character have a pocket watch?",
                                     "Witch Jinx's weapons use the gemstone to upgrade it's power?",
                                     "What adjustment engineer did Jayce and Viktor made to control the Hexcores?",
                                     "Question 8",
                                     "Question 9",
                                     "Question 10"},
	  /* quizz 1 correct answers */ {"(Portal)??", "Noxia", "Shimmer", "Ryze", "Ekko", "FishBones", "High frequency stabilization", "yes", "yes", "no"},
                                    {"(Hoverboards)??" , "Zaun", "3??", "Viktor", "Jayce", "Pow-pow" ,"Highest power supply ", "8", "9", "10"},
                                    {"()??", "Demacia", "c??", "Galio", "Heimerdinger", "Zaap", "The right reflective mirrors", "h", "i", "j"}};
        //CATEGORY 2
        final static String QANDA2 [][] = {{"Question 1.2", 
                                     "Question 2.2",
                                     "Question 3.2",
                                     "Question 4.2",
                                     "Question 5.2",
                                     "Question 6.2",
                                     "Question 7.2",
                                     "Question 8.2",
                                     "Question 9.2",
                                     "Question 10.2"},
                                    {"yes", "no", "no", "yes", "no", "yes", "no", "yes", "yes", "no"},
                                    {"1" , "2", "3", "4", "5", "6" ,"7", "8", "9", "10"},
                                    {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"}};
        //CATEGORY 3
        final static String QANDA3 [][] = {{"Question 1.3", 
                                     "Question 2.3",
                                     "Question 3.3",
                                     "Question 4.3",
                                     "Question 5.3",
                                     "Question 6.3",
                                     "Question 7.3",
                                     "Question 8.3",
                                     "Question 9.3",
                                     "Question 10.3"},
                                    {"yes", "no", "no", "yes", "no", "yes", "no", "yes", "yes", "no"},
                                    {"1" , "2", "3", "4", "5", "6" ,"7", "8", "9", "10"},
                                    {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"}};

		//PERCENTAGE 
        final static String LOWANS = "The user answered from  0% to 33% of the questions correctly.";
        final static String MEDLOWANS = "The user answered from  34% to 66% of the questions correctly.";
        final static String MEDHIGHANS = "The user answered from  67% to 99% of the questions correctly.";
        final static String HIGHANS = "The user answered 100% of the questions correctly.";

        //CAT NAME
        final static String CAT1 = "Arcane serie";
        final static String CAT2 = "CATEGORY 2";
        final static String CAT3 = "CATEGORY 3";
        //NEW USER ARRAY
        final static String userQANDA [][] = new String [4] [10];
		
		static boolean keepPlaying = true;

    public static void main(String[] args) {


        //NON-REPEATED RANDOM VALUES ARRAY
        ArrayList<Integer> randomGenerated = new ArrayList<Integer>();      
        ArrayList<Integer> randomAnswers = new ArrayList<Integer>();                

        String answer;
        String cat[][];
        String catName = "Not especified";
        
        final int VAL_POINTS = 10;
        final int VAL_EXTRAPOINTS = 20;

        int randomQ;
        int categroy=0; 

        int extraPoints = 0;

        int correctCount = 0;
        int incorrectCount = 0;
        int normalCorr = 0;

        int consecutiveErrors = 0;
        int consecutiveCorr = 0;

        while (keepPlaying) {

            System.out.println("\n------Select category------"+
                ConsoleColors.BLUE_BOLD_BRIGHT+"\n1."+CAT1+ConsoleColors.RESET+
                ConsoleColors.GREEN_BOLD_BRIGHT+"\n2."+CAT2+ConsoleColors.RESET+
                ConsoleColors.PURPLE_BOLD_BRIGHT+"\n2."+CAT3+ConsoleColors.RESET+
                "\n---------------------------");
            //VALID CAT INPUT
            boolean validCat = false;
            do {
                Scanner catIn = new Scanner(System.in);
                if (!catIn.hasNextInt()){
                    System.out.println("Input error.\nEnter a number to select the category:");
                }else {
                    categroy = catIn.nextInt();
                    if (categroy > 0 && categroy <=3){
                    validCat = true;
                    } else{
                    System.out.println("Error. You need to choose a category (1, 2 or 3)");
                    }
                }
            }while(!validCat);

            // CATEGORY SWITCH
            switch (categroy) {
                case 1:
                    cat = QANDA1;
                    catName = CAT1;
                    break;
                case 2:
                    cat = QANDA2;
                    catName =CAT2;
                    break;
                case 3:
                    cat = QANDA3;
                    catName = CAT3;
                    break;
                default:
                     cat = QANDA1;
            }
            boolean endGame = false;
            while (!endGame) {
                    // QUESTION RANDOMITZATION
                    do {
                        Random r = new Random();
                        randomQ=r.nextInt(cat[0].length);
                    } while (randomGenerated.contains(randomQ));

                randomGenerated.add(randomQ);
                //QUESTION PRINT
                System.out.println(ConsoleColors.CYAN_BOLD+"\n" + cat[0][randomQ]+ConsoleColors.RESET);
                System.out.println();
                // RANDOM DISPLAY TIPO TEST
                String testA="";
                String testB="";
                String testC="";

                while (cat == QANDA1 && randomAnswers.size()<= 2) { //add cat to display test abc.
                    Random r = new Random();
                    int randomA = r.nextInt(3)+1;//genera (0...n-1) +1
					
                    if (!randomAnswers.contains(randomA)){
                        switch(randomAnswers.size()){
                            case 0:
                            testA = cat[randomA][randomQ];
                            System.out.print("A) "+testA+"   ");
                            break;
                            case 1:
                            testB = cat[randomA][randomQ];
                            System.out.print("B) "+testB+"   ");
                            break;
                            case 2:
                            testC = cat[randomA][randomQ];
                            System.out.print("C) "+testC+"   ");
                            break;
                        }
                        randomAnswers.add(randomA);
                    }
                }
                randomAnswers.clear();

                System.out.println();
                Scanner answerIn = new Scanner(System.in);
                answer = answerIn.nextLine().toLowerCase();
                
                // ANSWER AUTOMOD
                //TIPO TEST
                switch(answer){
                    case "a":
                    answer = testA;
                    break;
                    case "b":
                    answer = testB;
                    break;
                    case "c":
                    answer = testC;
                }
                // Y/N ANSWERS
                if (answer.equals("y")) {
                    answer = "yes";
                } else if (answer.equals("n"))
                    answer = "no";

                int itsCorrect = 0; //1= correct 0 = incorrect
                String validAns;
                boolean correctAns = false;

                // ANS VALIDATION
                int j = 1;
                while (j < cat.length && !correctAns) {

                    if (cat == QANDA1){ //add cat to validate test abc first answers answers correct [1].
                        validAns = cat[1][randomQ];
                    }else{
                        validAns = cat[j][randomQ];
                    }
                    
                    if (validAns.equals(answer)){
                        itsCorrect = 1;
                        correctAns = true;
                    } else {
                        itsCorrect = 0;
                    }
                    j++;
                }
	
                // CORRECT
                if (itsCorrect == 1){ // a lot of var??
                    System.out.println("\nCorrect!");
                    correctCount++;
                    normalCorr++;
                    consecutiveCorr++;
                    consecutiveErrors = 0;
                // INCORRECT
                } else{
                    System.out.println("\nIncorrect!");
                    incorrectCount++;
                    consecutiveErrors++;
                }
                // CONSECUTIVE EXTRA POINTS
                if (consecutiveCorr>1 && itsCorrect == 0) {
                    extraPoints += VAL_EXTRAPOINTS*consecutiveCorr;
                    normalCorr -= consecutiveCorr;
                    consecutiveCorr = 0;
                }

                // GAME OVER CONDITION
                if (consecutiveErrors >= 3) {
                    endGame = true;
                    System.out.println(ConsoleColors.RED_BRIGHT+"\nYou failed 3 questions in a row..."+ConsoleColors.RESET);
                }
            }
            consecutiveErrors = 0;
            randomGenerated.clear();
            randomAnswers.clear();

            // CORRECT INCORRECT SCORE
            int score = extraPoints + normalCorr*VAL_POINTS;
            System.out.println();                  
            System.out.println(ConsoleColors.RED+"*==========================*\n           GAME OVER\n*==========================*"+ConsoleColors.RESET);
            System.out.println("\nCategory: "+ catName);
            System.out.println("\nCorrect answers: "+ConsoleColors.GREEN+correctCount+ConsoleColors.RESET+"\nIncorrect answers: "+ConsoleColors.RED+incorrectCount+ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN_BOLD+"\nScore: "+ score + " points"+ConsoleColors.RESET);

            // CORRECT PERCENTAGE
            Double correctPerc = (double)(correctCount*100)/QANDA1[0].length;

            System.out.println("\nPercentage: "+correctPerc+"%");
            
            if (correctPerc <= 33) {
                System.out.println(LOWANS);
            } else if (correctPerc >= 34 && correctPerc <= 66) {
                System.out.println(MEDLOWANS);
            } else if (correctPerc >= 67 && correctPerc <= 99) {
                System.out.println(MEDHIGHANS);
            } else if (correctPerc == 100) {
                System.out.println(HIGHANS);
            }
	// OPTIONS
            openOptions();
        }
    }
	
	public static void openOptions() {
		boolean validOption = true;
            int option;
            do {
                System.out.println(ConsoleColors.YELLOW+"\nOptions:"+ConsoleColors.RESET+"\n1. Play again.\n2. Questions mod / new quizz\n3. Exit game");
                Scanner optionsIScanner = new Scanner(System.in);
                    option = optionsIScanner.nextInt();
                if (option < 1 || option > 3 ){
                    validOption = false;
                } else{
                    System.out.println("Error. Invalid input.");
				}
				
            }while (!validOption);

            boolean modValidIn = true;
            int mod=0;

            switch(option){
                case 1:
                keepPlaying = true;
                break;

                case 2:
                System.out.println(ConsoleColors.YELLOW+"\n2. Select your mod:"+ConsoleColors.RESET+"\n1. Modify a quizz\n2. Create a new quizz\n3. Back");
                do {
                    Scanner modIn = new Scanner(System.in);
                    mod = modIn.nextInt();
                    if (mod>=1 ||mod<=3){ 
                    }else{
                        System.out.println("Error. Invalid input.");
                        modValidIn = false;
                    }
                } while (!modValidIn);
                break;

                case 3:
                keepPlaying = false;
                System.out.println("See you next time!");
                break;
            }
            if(mod == 1) {
                System.out.println("\nSelect the category you want to modify:"+ConsoleColors.BLUE_BOLD_BRIGHT+"\n1."+CAT1+ConsoleColors.RESET+
                ConsoleColors.GREEN_BOLD_BRIGHT+"\n2."+CAT2+ConsoleColors.RESET+
                ConsoleColors.PURPLE_BOLD_BRIGHT+"\n2."+CAT3+ConsoleColors.RESET);
                boolean validOptionCat = true;
                int catOption;
                do {
                    Scanner catOptionIn = new Scanner(System.in);
                    catOption = catOptionIn.nextInt();
                    if (catOption == 1){
                        modArray(QANDA1);
                    }else if (catOption == 2){
                        modArray(QANDA2);
                    }else if(catOption == 3){
                        modArray(QANDA3);
                    }else{
                        System.out.println("Error. Invalid input.");
                        validOption = false;
                    }
                } while (!validOptionCat); 

            } else if (mod == 2) {
                modNewQuizz();
            } else if (mod == 3) {
				openOptions();
			}
	}
	
    public static void logQuestions (String category [][]){
        for (int j= 0; j < category[0].length; j++){
            int k = j+1;
            System.out.println(k+". "+category[0][j]);
        }
    }

	public static void modArray (String category [][]){
		System.out.println();

        System.out.println("Modifications: \n1. Add a question and / or an answer/s \n2. Modify a question and / or an answer/s \n3. Delate a question and / or an asnwer/s");
        int mod;
        do {
            Scanner e = new Scanner(System.in);
            mod = e.nextInt();
        } while (mod<1 && mod>4);

		System.out.println("\nNumber of question to modify:");
		logQuestions(category);

		Scanner r = new Scanner(System.in);
		int questionNum = r.nextInt()-1;

		System.out.println("Type the new question:");
		Scanner s = new Scanner(System.in);
		String newQuestion = s.nextLine();
		category[0][questionNum] = newQuestion;

		System.out.println("Do you want to modify the answers?\nY/N");
		Scanner ansModIn = new Scanner(System.in);
		String answersMod = ansModIn.nextLine().toLowerCase();

		if (answersMod.equals("y")||answersMod.equals("yes")){
			for (int m = 1; m <= 3; m++){
				System.out.println("Type new answer:");
				Scanner t = new Scanner(System.in);
				String modAnswer = t.nextLine();
				userQANDA[m][questionNum] = modAnswer;
			}
			System.out.println("Your modifications has been done succesfuly.");
		}
		openOptions();
	}
	
	public static void modNewQuizz (){
        System.out.println("\nType of quizz: \n1. Test (a b c) \n2. Multiple answers correct");
        int typeNewQuizz;
        do {
            Scanner s = new Scanner(System.in);
            typeNewQuizz = s.nextInt();
        } while (typeNewQuizz<1 && typeNewQuizz>2);
       
            for (int q = 0; q < userQANDA[0].length; q++){
                int qn = q+1;
                System.out.println("\n\nQuestion nº "+qn+":");
                Scanner a = new Scanner(System.in);
                String newQuestionArray = a.nextLine();
                userQANDA[0][q] = newQuestionArray;
                
                for (int w = 1; w <= 3;w++){
                    if (typeNewQuizz==1){    
                        if(w==1){
                            System.out.println("\nType the correct answer:");
                        }else{
                            System.out.println("\nType a false answer:");
                        }
                    } else {
                        System.out.println("Type a possible asnwer:");
                    }

                    Scanner e = new Scanner(System.in);
                    String userNewArrayAnswer = e.nextLine();
                    userQANDA[w][q] = userNewArrayAnswer;
                }
            }
            System.out.println("Your new Quizz has been created succesfuly.");
            openOptions();
        }	
	}