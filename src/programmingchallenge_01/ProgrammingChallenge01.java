package programmingchallenge_01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProgrammingChallenge01 {

    //CATEGORY 1
        final static String QANDA1 [][] = {{"What is the invention that made Piltover grow and more expandable?", 
                                            "From what city Ambessa Medarda comes to Piltover?",
                                            "Wha's the name of the drug used in Zaun to increse their strength?",
                                            "Who saved Jayce and her mother when he was a little boy?",
                                            "Wich character have a pocket watch?",
                                            "Witch Jinx's weapons use the gemstone to upgrade it's power?",
                                            "What engineer adjustment  did Jayce and Viktor made to control the Hexcores?",
                                            "What was Jinx's name when she was little?",
                                            "Who is the surfer who appears in the dock?",
                                            "Who is the singer of the closing song of Arcane Series?",
                                            "",
                                            "",
                                            "",
                                            ""},
              /* quizz 1 correct answers */ {"The portal", "Noxia", "Shimmer", "Ryze", "Ekko", "FishBones", "High frequency stabilization", "Powder", "Ekko", "Sting", "", "", "", ""},
                                            {"Hoverboards" , "Zaun", "Powder", "Viktor", "Jayce", "Pow-pow" ,"Highest power supply ", "Little Jinx", "Heimerdinger", "Dan Reynolds", "", "", "", ""},
                                            {"Blitzcrank", "Demacia", "Zhun", "Galio", "Heimerdinger", "Zaap", "The right reflective mirrors", "Anne", "Talyia", "Dua Lipa", "", "", "", ""}};
    //CATEGORY 2
        final static String QANDA2 [][] = {{"What is actually electricity?", 
                                            "Which did Viking people use as money?",
                                            "What was the first country to use tanks in combat during World War I?",
                                            "What is the main component of the sun?",
                                            "Which two months are named after Emperors of the Roman Empire?",
                                            "Which of the following animals can run the fastest?",
                                            "In which country is Transylvania?",
                                            "Which company is known for publishing the Mario video game?",
                                            "Which was the first film by Disney to be produced in colour?",
                                            "How many time zones are there in total in the world?",
                                            "",
                                            "",
                                            "",
                                            ""},
                /*correct */                {"A flow of electrons", "Jewellery", "Britain", "Gas", "July and August", "Cheetah", "Romania", "Nintendo", "Snow White and the Seven Dwarfs", "24", "", "", "", ""},
                                            {"A flow of atoms" , "Rune stones", "Germany", "Molten iron", "January and February", "Leopard" ,"Bulgaria", "Electronic Arts", "Cinderella", "32", "", "", "", ""},
                                            {"A flow of water", "Seal skins", "Japan", "Liquid lava", "May and June", "Tiger", "Croatia", "SEGA", "Sleeping Beauty", "8", "", "", "", ""}};
    //CATEGORY 3
        final static String QANDA3 [][] = {{"What is the name of SpaceX rocket engine?", 
                                            "What's the name of one of Elon Musk's companys?",
                                            "Can you name an actor or actress who played in Matrix?",
                                            "Can you name one of the Lockheed Martin combat jets?",
                                            "What's the name of a famous Catalan dish ",
                                            "Wich SpaceX starship prototype did fly?",
                                            "Name an actor who played in a Tarantino movie who won an Oscar",
                                            "Name one of Picasso paintings",
                                            "Wich are the besat IDE for Java?",
                                            "Wich singer has colab with Arianna Grande?",
                                            "",
                                            "",
                                            "",
                                            ""},
                                            {"raptor", "tesla", "keanu reeves", "f 16", "crema catalana", "sn15", "lionardo di caprio", "guernica", "netbeans", "the weekend", "", "", "", ""},
                                            {"merlin" , "boring company", "laurence fishburne", "f 22", "pa amb tomaquet", "sn16" ,"christoph waltz", "the old guitarist", "visual studio code", "mac miller", "", "", "", ""},
                                            {"kestrel", "spacex", "carrie anne moss", "blackbird", "paella", "sn8", "uma thurman", "the weeping woman", "intelj", "nicki minaj", "", "", "", ""},
                                            {"", "", "", "", "", "", "", "", "", "", "", "", "", ""}};

	//PERCENTAGE 
        final static String LOWANS = "The user answered from  0% to 33% of the questions correctly.";
        final static String MEDLOWANS = "The user answered from  34% to 66% of the questions correctly.";
        final static String MEDHIGHANS = "The user answered from  67% to 99% of the questions correctly.";
        final static String HIGHANS = "The user answered 100% of the questions correctly.";

    //CAT NAME
        final static String CAT1 = "Arcane serie";
        final static String CAT2 = "CATEGORY 2";
        final static String CAT3 = "CATEGORY 3";
              static String CAT4 = "User Quizz";

    //NEW USER ARRAY
        static String userQANDA [][] = null;
        
		
		static boolean keepPlaying = true;

    public static void main(String[] args) {

        //NON-REPEATED RANDOM VALUES ARRAY
        ArrayList<Integer> randomGenerated = new ArrayList<>(); //used question's index of static arrays      
        ArrayList<Integer> randomAnswers = new ArrayList<>(); //used answers displayed in the test (type of quizz[abc])          

        String answer; //user answer input

        //Holders
        String cat[][]; //holder to display questions/answers and answers validation
        String catName = "Not especified"; //holder of category name (CAT1/CAT2/CAT3/CAT4)
        
        //Points
        final int VAL_POINTS = 10; //value of a correct answer
        final int VAL_EXTRAPOINTS = 20; //value of more than 1 correctly question answered consecutively

        int extraPoints = 0;//calculated points after consecutive answers

        //Selectors
        int randomQ; //random number to pick a question from the arrays
        int category=0; //number to select category. value used in the category switch

        //Counters
        int correctCount = 0;
        int incorrectCount = 0;
        int normalCorr = 0;//no consecutive correct answers

        int consecutiveErrors = 0; 
        int consecutiveCorr = 0;

        int validLength=0;

    //QUIZZ GAME
        while (keepPlaying) { // keep playing till 3. Exit game in menu
        
            System.out.println("\n------Select category------"+ 
                ConsoleColors.BLUE_BOLD_BRIGHT+"\n1."+CAT1+ConsoleColors.RESET+
                ConsoleColors.GREEN_BOLD_BRIGHT+"\n2."+CAT2+ConsoleColors.RESET+
                ConsoleColors.PURPLE_BOLD_BRIGHT+"\n3."+CAT3+ConsoleColors.RESET+
                ConsoleColors.WHITE_BOLD_BRIGHT+"\n4. "+CAT4+ConsoleColors.RESET+
                               "\n---------------------------");

        //VALID CATEGORY NUMBER INPUT
            boolean validCat = false;
            do {
                Scanner catIn = new Scanner(System.in);
                if (!catIn.hasNextInt()){
                    System.out.println("Input error.\nEnter a number to select the category:");
                }else {
                    category = catIn.nextInt();
                    if (category > 0 && category <=4){
                        if (category == 4 && userQANDA == null){
                            System.out.println("This Quizz is not avaliable now.\nChoose one of the three first categories.");
                        }else{
                            validCat = true;
                        }
                    } else{
                    System.out.println(" Choose a number of one of the categories:");
                    }
                }
            }while(!validCat);

        // CATEGORY SWITCH
            switch (category) {
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
                case 4:
                    cat = userQANDA;
                    catName = CAT4;
                    break;
                default:
                     cat = QANDA1;
            }
            boolean endGame = false;

        //Length with no empty spaces
            for (int i = 0; i < cat[0].length; i++) {
                if (!cat[0][i].equals("")){
                    validLength++;
                }
            }

            while (!endGame) { // keep playing till 3 consecutive errors

            // QUESTION RANDOMITZATION
                do {
                    Random r = new Random();
                    randomQ=r.nextInt(validLength);
                } while (randomGenerated.contains(randomQ));

                randomGenerated.add(randomQ); //add index of question to ArrayList

            //QUESTION PRINT
                System.out.println(ConsoleColors.CYAN_BOLD+"\n" + cat[0][randomQ]+ConsoleColors.RESET);
                System.out.println();

            // RANDOM DISPLAY TIPO TEST [abc]
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

            //ANSWER SCANNER
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

                boolean itsCorrect = false;
                String validAns=""; // holder of correct answers

                // ANS VALIDATION
                int j = 1;
                while (j < cat.length && !itsCorrect) {
                    if (!cat[j][randomQ].equals("")) {
                        if (cat == QANDA1){ //add cat to validate test abc first answers it's the correct one [1].
                            validAns = cat[1][randomQ];
                        }else {
                            validAns = cat[j][randomQ];
                        }
                        
                        if (validAns.equals(answer)){
                            itsCorrect = true;
                        } else {
                            itsCorrect = false;
                        }
                    } else {
                        itsCorrect = false;
                    }
                    j++;
                }
	
            // CORRECT
                if (itsCorrect){ 
                    System.out.println("\nCorrect!");
                    correctCount++;
                    normalCorr++;//all corrects ++ normalCorr
                    consecutiveCorr++;
                    consecutiveErrors = 0;
            // INCORRECT
                } else{
                    System.out.println("\nIncorrect!");
                    incorrectCount++;
                    consecutiveErrors++;
                }    
            // CONSECUTIVE EXTRA POINTS
                if (consecutiveCorr>1 && itsCorrect) {
                    extraPoints += VAL_EXTRAPOINTS*consecutiveCorr;// extra points calc
                    normalCorr -= consecutiveCorr; //we keep the correct answers that aren't consecutive
                    consecutiveCorr = 0;
                }

            // 3 CONSECUTIVE ERRORS GAME OVER CONDITION
                if (consecutiveErrors >= 3) {
                    endGame = true;
                    clear();
                    System.out.println(ConsoleColors.RED_BRIGHT+"\nYou failed 3 questions in a row..."+ConsoleColors.RESET);
                } else if (randomGenerated.size()==validLength) {
                    endGame = true;
                }
            }
            consecutiveErrors = 0;
            randomGenerated.clear();
            randomAnswers.clear();

        // CORRECT INCORRECT SCORE
            int score = extraPoints + normalCorr*VAL_POINTS; // already calc extraPoints + no consecutive correct ansewers * normal points
            System.out.println();                  
            System.out.println(ConsoleColors.RED+"*==========================*\n           GAME OVER\n*==========================*"+ConsoleColors.RESET);
            System.out.println("\nCategory: "+ catName);
            System.out.println("\nCorrect answers: "+ConsoleColors.GREEN+correctCount+ConsoleColors.RESET+"\nIncorrect answers: "+ConsoleColors.RED+incorrectCount+ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN_BOLD+"\nScore: "+ score + " points"+ConsoleColors.RESET);

        // CORRECT PERCENTAGE
            Double correctPerc = (double)(correctCount*100)/validLength;
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
            openOptions();
        }
    }

//OPTIONS MENUS
    //PRINCIPAL (PLAY AGAIN / MOD / EXIT GAME)
        public static void openOptions() {

                boolean validOption = true;
                int option;
                do {
                    System.out.println(ConsoleColors.YELLOW+"\nOptions:"+ConsoleColors.RESET+"\n1. Play again.\n2. Questions mod / new quizz\n3. Exit game");
                    Scanner optionsIScanner = new Scanner(System.in);
                        option = optionsIScanner.nextInt();
                    if (option <0 || option >4){
                        validOption = false;
                    } else{
                        System.out.println("Error. Invalid input.");
                    }		
                }while (!validOption);

                switch(option){ //KEEP PLAYING -- MODS -- EXIT
                    case 1:
                    keepPlaying = true;
                    clear();
                    break;

                    case 2:
                    clear();
                    modSelection();
                    break;

                    case 3:
                    keepPlaying = false;
                    clear();
                    System.out.println("See you next time!");
                    break;
                }		
            }
   
    //MOD SELECTION (1.MODIFY / 2.NEW QUIZZ)
        public static void modSelection () {
            boolean modValidIn = true;
            int mod=0;

            System.out.println(ConsoleColors.YELLOW+"\nSelect your mod:"+ConsoleColors.RESET+
                            "\n1. Modify a quizz"
                            + "\n2. Create a new quizz"
                            + "\n3. Back");
                    do {
                        Scanner modIn = new Scanner(System.in);
                        mod = modIn.nextInt();
                        if (mod>=1 ||mod<=3){ 
                        }else{
                            System.out.println("Error. Invalid input.");
                            modValidIn = false;
                        }
                    } while (!modValidIn);

                switch (mod) {
                    case 1:
                        //MOD A QUIZZ
                        System.out.println("\nSelect the category you want to modify:"+ConsoleColors.BLUE_BOLD_BRIGHT+"\n1."+CAT1+ConsoleColors.RESET+
                                ConsoleColors.GREEN_BOLD_BRIGHT+"\n2."+CAT2+ConsoleColors.RESET+
                                ConsoleColors.PURPLE_BOLD_BRIGHT+"\n3."+CAT3+ConsoleColors.RESET+
                                ConsoleColors.WHITE_BOLD_BRIGHT+"\n4. "+CAT4+ConsoleColors.RESET);
                        boolean validOptionCat = true;
                        int catOption;
                        do {
                            Scanner catOptionIn = new Scanner(System.in);
                            catOption = catOptionIn.nextInt();
                            if (catOption == 1){
                                clear();
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+CAT1+ConsoleColors.RESET);
                                modifications(QANDA1);
                            }else if (catOption == 2){
                                clear();
                                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+CAT2+ConsoleColors.RESET);
                                modifications(QANDA2);
                            }else if(catOption == 3){
                                clear();
                                System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT+CAT3+ConsoleColors.RESET);
                                modifications(QANDA3);
                            }else{
                                System.out.println("Error. Invalid input.");
                                validOptionCat = false;
                            }
                        } while (!validOptionCat);
                        break;
                    case 2:
                        //NEW QUIZZ
                        clear();newQuizz();
                        break;
                    case 3:
                        //BACK TO OPTIONS
                        clear();openOptions();
                        break;
                    default:
                        break;
                }
        }
    
    //1. MODIFY (ADD / CHANGE / DELATE)
        public static void modifications (String category [][]){
            System.out.println();

            System.out.println(ConsoleColors.YELLOW+"Modifications:"+ConsoleColors.RESET+"\n1. Add a question and / or an answer/s\n2. Change a question and / or an answer/s\n3. Delate a question and / or an asnwer/s\n4. Back");
            int mod;
            boolean validMod = true;
            do {
                Scanner e = new Scanner(System.in);
                mod = e.nextInt();
                if ((mod <=3 && mod>=1)&& mod==6) {
                    validMod = true;
                }
            } while (!validMod);
            
                switch (mod) {
                    case 1:
                        //ADD
                        modAdd(category);
                        break;
                    case 2:
                        //CHANGE 1.QUESTION 2.ANSWER
                        modChange(category);
                        break;
                    case 3:
                        //DELATE 1.QUESTION 2.ANSWER
                        modDelate(category); 
                        break;
                    case 4:
                        clear();
                        modSelection();
                        break;
                    case 6:
                        //EG
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
                    clear();
        }
    
    //1.1 ADD (QUESTION / ANSWERS)
        public static void modAdd (String category[][]) {
                System.out.println("\nWhat do you want to add?\n1. Question/s\n2. Answer/s\n3. Back");
                int whatToModify;
                do {
                    Scanner d = new Scanner(System.in);
                    whatToModify = d.nextInt();
                } while (whatToModify<1 || whatToModify>3);

                switch (whatToModify) {
                    case 1:
                    boolean thereIsEmptyQ = false;
                    boolean noMoreQ = false;
                    int j = 0;
                    while (!noMoreQ && j < category[0].length ){
                        if (category[0][j].equals("")) {
                            thereIsEmptyQ = true;
                            System.out.println("T\nType your new question:");
                            Scanner w = new Scanner(System.in);
                            String addQuestion = w.nextLine();
                            category[0][j] = addQuestion;
                            System.out.println("\nDo you want to add an answer to this question?\nY/N\n");
                            Scanner f = new Scanner(System.in);
                            String addAnswer = f.nextLine().toLowerCase();
                
                            System.out.println("\nDo you want to add another question?\nY/N\n");
                            Scanner d = new Scanner(System.in);
                            String modifyAnotherQuestion = d.nextLine().toLowerCase();
                                if (modifyAnotherQuestion.equals("n") || modifyAnotherQuestion.equals("no")) {
                                    noMoreQ = true;
                                }
                        }
                        j++;
                    }
                    if (thereIsEmptyQ){
                        System.out.println("Your new question has been added succesfully.\n");
                    }else{
                        System.out.println("Full questions. Delate some to add new ones.");
                    }
                    openOptions();
                    break;

                    case 2:
                        System.out.println("\nSelect the question wich you'll add a new answer:");
                        System.out.println();
                        logQuestions(category);
                        int questionAddAnswer;
                        boolean thereIsEmptyA = false;
                        do  {   
                            Scanner w = new Scanner(System.in);
                            questionAddAnswer = w.nextInt()-1;
                        } while (questionAddAnswer < 1 || questionAddAnswer > category[0].length);

                        for (int k = 1; k < 4; k++) {
                            if (category[k][questionAddAnswer].equals("")) {
                                thereIsEmptyA = true;
                                System.out.println("\nType your new answer:");
                                Scanner w = new Scanner(System.in);
                                String addAnswer = w.nextLine();
                                category[0][k] = addAnswer;
                            }   
                        }
                        if (thereIsEmptyA){
                            System.out.println("Your new answer has been added succesfully.\n");
                            
                        }else {
                            System.out.println("Full answers. Delate some to add new ones.");
                        }
                        openOptions();
                    break;

                    case 3:
                    modifications(category);
                    break;
                }
                
        }
    
    //1.2 CHANGE [QUESTION / ANSWER]
        public static void modChange (String category [][]) {
        
            System.out.println("\nWhat do you want to change?\n1. Question/s\n2. Answer/s\n3. Back");
            int whatToModify = 3;
            int questionToModify=0;
            do {
                Scanner d = new Scanner(System.in);
                whatToModify = d.nextInt();
            } while (whatToModify<1 || whatToModify>3);

            if (whatToModify==1||whatToModify==2){
                System.out.println("\nNumber of question to modify:");
                System.out.println();
                logQuestions(category);

                
                do  {   
                    Scanner w = new Scanner(System.in);
                    questionToModify = w.nextInt()-1;
                } while (questionToModify <= 0 || questionToModify > category[0].length);
            }
        
            switch (whatToModify) { 
            //CHANGE QUESTION
                case 1:
                System.out.println("\nNew question:\n");
                Scanner s = new Scanner(System.in);
                String changedQuestion = s.nextLine();
                category [0][questionToModify] = changedQuestion;
                System.out.println("Question "+questionToModify+" has been modified succesfully.\n");

                System.out.println("\nDo you want to modify another question?\nY/N\n");
                    Scanner d = new Scanner(System.in);
                    String modifyAnotherQuestion = d.nextLine().toLowerCase();
                    
                    if (modifyAnotherQuestion.equals("y") || modifyAnotherQuestion.equals("yes")) {
                        modChange(category);
                    } else {
                        clear();
                        openOptions();
                    }
                break;
            //CHANGE ANSWER    
                case 2:
                Boolean stopModifying = false;
                clear();
                modifyAnswer(category, questionToModify, 1);
                //MORE 
                while (!stopModifying) {
                    System.out.println("Do you want to change another answer's question?\nY/N\n");
                    Scanner g = new Scanner(System.in);
                    String answerModifyQ = g.nextLine().toLowerCase();

                    if (answerModifyQ.equals("y") || answerModifyQ.equals("yes")) {
                        System.out.println("Of the same question?\nY/N\n");
                        Scanner r = new Scanner(System.in);
                        String delateSameQuestion = r.nextLine().toLowerCase();

                        if (delateSameQuestion.equals("y") || delateSameQuestion.equals("yes")) {
                            clear();
                            modifyAnswer(category, questionToModify, 1);
                        } else {
                            clear();
                            modChange(category);
                        }
                    } else {
                        stopModifying = true;
                    }
                }
                break;
                case 3:
                modifications(category);
                break;
                }
            
        }
  
    //1.3 DELATE [QUESTION/ANSWER] mod 2
        public static void modDelate (String category [][]){

            System.out.println("\nWhat do you want to delate?\n1. Question/s\n2. Answer/s\n3. Back");
            int whatToDelate=3;
            int questionToModify=0;
            do {
                Scanner d = new Scanner(System.in);
                whatToDelate = d.nextInt();
            } while (whatToDelate<1 || whatToDelate>3);
            if ( whatToDelate==1 || whatToDelate==2){
                System.out.println("\nNumber of question to delate:");
                System.out.println();
                logQuestions(category);

                
                do  {   
                    Scanner w = new Scanner(System.in);
                    questionToModify = w.nextInt()-1;
                } while (questionToModify <= 0 || questionToModify > category[0].length);
            }
            switch (whatToDelate) { //DELATE QUESTION
                case 1:
                category [0][questionToModify] = "";
                //String qHolder;
                for (int j = 0; j < category[0].length-1; j++) {
                    //qHolder =  category[0][j];
                    if (category[0][j].equals("") && !category[0][j+1].equals("")) {
                        category[0][j] = category[0][j+1];
                        category[0][j+1] = "";
                    }
                }
                System.out.println("Question "+questionToModify+" has been delated succesfully.\n");
                System.out.println("\nDo you want to delate another question?\nY/N\n");
                    Scanner d = new Scanner(System.in);
                    String delateAnotherQuestion = d.nextLine().toLowerCase();
                    if (delateAnotherQuestion.equals("y") || delateAnotherQuestion.equals("yes")) {
                        modDelate(category);
                    } else {
                        openOptions();
                    }
                break;

                case 2://DELATE ANSWER
                Boolean stopDelate = false;
                modifyAnswer(category, questionToModify, 2);
                //MORE
                while (!stopDelate) {
                    System.out.println("Do you want to delate another answer?\nY/N\n");
                    Scanner s = new Scanner(System.in);
                    String answerDelateQ = s.nextLine().toLowerCase();

                    if (answerDelateQ.equals("y") || answerDelateQ.equals("yes")) {
                        System.out.println("Of the same question?\nY/N\n");
                        Scanner r = new Scanner(System.in);
                        String delateSameQuestion = r.nextLine().toLowerCase();
                        if (delateSameQuestion.equals("y") || delateSameQuestion.equals("yes")) {
                            clear();
                            modifyAnswer(category, questionToModify, 2);
                        } else {
                            clear();
                            modDelate(category);
                        }
                    } else {
                        stopDelate = true;
                    }
                }
                break;
                case 3:
                modifications(category);
                break;
            }
        }
  
    // 1.2.1 / 1.3.1 MODIFY ANSWER
        public static void modifyAnswer(String category [][], int row, int modType) {
            String toDo = "modify";
            switch (modType){
                case 1: toDo = "change";
                break;
                case 2: toDo = "delate";
                break;
                case 3: toDo = "add";
                break;
            }
            System.out.println("\nAnswer to "+toDo+":");
            logAnswers(category, row);
            int modifyAnswer;
            do  {   
                Scanner s= new Scanner(System.in);
                modifyAnswer = s.nextInt();
            } while (modifyAnswer < 1 || modifyAnswer > 10);

            switch (modType){
                case 1: //CHANGE
                    System.out.println("\nNew answer:\n");
                    Scanner r = new Scanner(System.in);
                    String newModAnswer = r.nextLine();
                    category[modifyAnswer][row] = newModAnswer;
                break;
                case 2: //DELATE
                    category[modifyAnswer][row] = "";
                break;
                case 3:
                    System.out.println("\nAdd answer:\n");
                    Scanner g = new Scanner(System.in);
                    String addAnswer = g.nextLine();
                    category[modifyAnswer][row] = addAnswer;
                break;

            }
        }    

    //2. NEW QUIZZ (TEST / MULTIPLE A) 
        public static void newQuizz () {
            userQANDA = new String [4] [10];
            System.out.println(ConsoleColors.YELLOW+"\nType of quizz:"+ConsoleColors.RESET+
                            "\n1. Test (a b c) " // typeNewQuizz == 1
                            + "\n2. Multiple answers correc" // typeNewQuizz == 2
                            + "t\n3. Back");
            int typeNewQuizz;
            do {
                Scanner s = new Scanner(System.in);
                typeNewQuizz = s.nextInt();
            } while (typeNewQuizz<1 && typeNewQuizz>3);
            
            if (typeNewQuizz==1 || typeNewQuizz==2){
                for (int q = 0; q < userQANDA[0].length; q++){
                    int questionNumber = q+1;
                    System.out.println("\n\nQuestion nº "+questionNumber+":");
                    Scanner a = new Scanner(System.in);
                    String newQuestionArray = a.nextLine();
                    
                    userQANDA[0][q] = newQuestionArray;
                
                    for (int w = 1; w <= 3;w++){
                        if (typeNewQuizz==1){    //test abc
                            if(w==1){
                                System.out.println("\nType the correct answer:");
                            }else{
                                System.out.println("\nType a false answer:");
                            }
                        } else { //3 possible answers
                            System.out.println("Type a possible asnwer:");
                        }

                        Scanner e = new Scanner(System.in);
                        String userNewArrayAnswer = e.nextLine();
                        userQANDA[w][q] = userNewArrayAnswer;
                    }
                }
                System.out.println("\nType a new name for your Quizz:\n");
                Scanner e = new Scanner(System.in);
                String newQuizzName = e.nextLine();
                CAT4 = newQuizzName;

                System.out.println("Your new Quizz has been created succesfuly.\n\nPress Enter to continue.");
                Scanner enter = new Scanner(System.in);
                clear();
                openOptions();
            } else if (typeNewQuizz == 3) {
                clear();
                modSelection();
                
            }
    }

//eg log
    public static void logQuestions (String category [][]){
        for (int j= 0; j < category[0].length; j++){
            int k = j+1;
            if (!category[0][j].equals("")){
                System.out.println(k+". "+category[0][j]);
            }
        }
    }

    public static void logAnswers (String category [][], int row){

        for (int h = 1; h < category.length; h++){
            System.out.println(h+". "+category[h][row]);
        }
    }

//clear terminal
    public static void clear () {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}