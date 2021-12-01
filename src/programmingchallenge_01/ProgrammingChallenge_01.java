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

            switch(option){ //KEEP PLAYING -- MODS -- EXIT
                case 1:
                keepPlaying = true;
                break;

                case 2:
                System.out.println(ConsoleColors.YELLOW+"\nSelect your mod:"+ConsoleColors.RESET+"\n1. Modify a quizz\n2. Create a new quizz\n3. Back");
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
            if(mod == 1) { //MOD A CATEGORY
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

            } else if (mod == 2) { //NEW QUIZZ
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

            } else if (mod == 3) { //BACK TO OPTIONS
				openOptions();
			}
	}
	

	public static void modArray (String category [][]){
		System.out.println();

        System.out.println("Modifications: \n1. Add a question and / or an answer/s \n2. Modify a question and / or an answer/s \n3. Delate a question and / or an asnwer/s");
        int mod;
        boolean validMod = true;
        do {
            Scanner e = new Scanner(System.in);
            mod = e.nextInt();
            if ((mod <=3 && mod>=1)&& mod==6) {
                validMod = true;
            }
        } while (!validMod);
        
        if (mod == 1){ //ADD
            System.out.println("Work In PROGRESS!!! O.O");
        } else if (mod == 2){ //MODIFY 1.QUESTION 2.ANSWER

            System.out.println("\nWhat do you want to delate?\n1. Question/s\n2. Answer/s");
            int whatToModify; 
            do {
                Scanner d = new Scanner(System.in);
                whatToModify = d.nextInt();
            } while (whatToModify<1 || whatToModify>2);

            modify(whatToModify, category);
           
        
        } else if (mod == 3) { //DELATE 1.QUESTION 2.ANSWER
    
            System.out.println("\nWhat do you want to delate?\n1. Question/s\n2. Answer/s");
            int whatToDelate; 
            do {
                Scanner d = new Scanner(System.in);
                whatToDelate = d.nextInt();
            } while (whatToDelate<1 || whatToDelate>2);

        delate(whatToDelate, category); //1.QUESTIONS 2.ANSWERS
        } else if (mod == 6) { //EG
            System.out.println("\nYou found a esater egg 0.o!\n1. Questions\n2. Answers");
            int easterEgg; 
            do{
                Scanner t = new Scanner(System.in);
                easterEgg = t.nextInt();
            } while (easterEgg!=1&&easterEgg!=2);
            switch (easterEgg){
                case 1:
                System.out.println();
                logQuestions(category);
                break;
                case 2:
                logQuestions(category);
                break;
            }  
        }
		openOptions();
	}

    public static void modify (int whatToModify, String category [][]) {
        
        System.out.println("\nNumber of question to modify:");
        System.out.println();
        logQuestions(category);

        int modifyQuestion;
        do  {   
            Scanner w = new Scanner(System.in);
            modifyQuestion = w.nextInt()-1;
        } while (modifyQuestion < 1 || modifyQuestion > 10);
        
        if (whatToModify==1){ //MODIFY QUESTION
            System.out.println("\nNew question:\n");
            Scanner s = new Scanner(System.in);
            String newModQuestion = s.nextLine();
            category [0][modifyQuestion] = newModQuestion;
            System.out.println("Question "+modifyQuestion+" has been modified succesfully.\n1");

            System.out.println("\nDo you want to modify another question?\nY/N\n");
                Scanner d = new Scanner(System.in);
                String modifyAnotherQuestion = d.nextLine().toLowerCase();
                if (modifyAnotherQuestion.equals("y") || modifyAnotherQuestion.equals("yes")) {
                    modify(1,category);
                } else {
                    openOptions();
                }

        } else if (whatToModify==2){ //MODIFY ANSWER
            Boolean stopModifying = false;
            modifyAnswer(category, modifyQuestion);
            
            while (!stopModifying) {
                System.out.println("Do you want to modify another answer's question?\nY/N\n");
                Scanner s = new Scanner(System.in);
                String answerModifyQ = s.nextLine().toLowerCase();

                if (answerModifyQ.equals("y") || answerModifyQ.equals("yes")) {
                    System.out.println("Of the same question?\nY/N\n");
                    Scanner r = new Scanner(System.in);
                    String delateSameQuestion = r.nextLine().toLowerCase();

                    if (delateSameQuestion.equals("y") || delateSameQuestion.equals("yes")) {
                        modifyAnswer(category, modifyQuestion);
                    } else {
                        modify(2,category);
                    }
                } else {
                    stopModifying = true;
                }
            }
        }
        
    }

    public static void modifyAnswer (String category [][], int row) {

        System.out.println("\nAnswer to modify:\n");
        logAnswers(category, row);
        int modifyAnswer;
        do  {   
            Scanner s= new Scanner(System.in);
            modifyAnswer = s.nextInt();
        } while (modifyAnswer < 1 || modifyAnswer > 10);
        System.out.println("\nNew answer:\n");
        Scanner r = new Scanner(System.in);
        String newModAnswer = r.nextLine();
        category[modifyAnswer][row] = newModAnswer;
    }

    public static void delate (int whatToDelate, String category [][]){

        System.out.println("\nNumber of question to delate:");
        System.out.println();
        logQuestions(category);

        int delateQuestion;
        do  {   
            Scanner w = new Scanner(System.in);
            delateQuestion = w.nextInt();
        } while (delateQuestion < 1 || delateQuestion > 10);
        
        if (whatToDelate==1){ //DELATE QUESTION
            category [0][delateQuestion] = "";
            System.out.println("Question "+delateQuestion+" has been delated succesfully.\n1");
            System.out.println("\nDo you want to delate another question?\nY/N\n");
                Scanner d = new Scanner(System.in);
                String delateAnotherQuestion = d.nextLine().toLowerCase();
                if (delateAnotherQuestion.equals("y") || delateAnotherQuestion.equals("yes")) {
                    delate(1,category);
                } else {
                    openOptions();
                }

        } else if (whatToDelate==2){ //DELATE ANSWER
            Boolean stopDelate = false;
            delateAnswers(category, delateQuestion);
            
            while (!stopDelate) {
                System.out.println("Do you want to delate another answer?\nY/N\n");
                Scanner s = new Scanner(System.in);
                String answerDelateQ = s.nextLine().toLowerCase();

                if (answerDelateQ.equals("y") || answerDelateQ.equals("yes")) {
                    System.out.println("Of the same question?\nY/N\n");
                    Scanner r = new Scanner(System.in);
                    String delateSameQuestion = r.nextLine().toLowerCase();
                    if (delateSameQuestion.equals("y") || delateSameQuestion.equals("yes")) {
                        delateAnswers(category,delateQuestion);
                    } else {
                        delate(2, category);
                    }
                } else {
                    stopDelate = true;
                }
            }
        }
    }

    public static void delateAnswers (String category [][], int row){
       
        System.out.println("\nAnswer to delate:\n");
        logAnswers(category, row);
        int delateAnswers;
        do  {   
            Scanner s= new Scanner(System.in);
            delateAnswers = s.nextInt();
        } while (delateAnswers < 1 || delateAnswers > 10);
        category[delateAnswers][row] = "";
    }

    public static void logQuestions (String category [][]){

        for (int j= 0; j < category[0].length; j++){
            int k = j+1;
            System.out.println(k+". "+category[0][j]);
        }
    }

    public static void logAnswers (String category [][], int row){

        for (int h = 1; h < category.length; h++){
            System.out.println(h+". "+category[h][row]);
        }
    }

}