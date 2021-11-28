package programmingchallenge_01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProgrammingChallenge_01 {

    public static void main(String[] args) {

        //CATEGORY 1
        final String QANDA1 [][] = {{"What is the invention that made Piltover grow and more expandable?", 
                                     "From what city Ambessa Medarda comes to Piltover?",
                                     "Wha's the name of the drug used in Zaun to increse their strength?",
                                     "Who saved Jayce and her mother when he was a little boy?",
                                     "Wich character have a pocket watch?",
                                     "Witch Jinx's weapons use the gemstone to upgrade it's power?",
                                     "What adjustment engineer did Jayce and Viktor made to control the Hexcores? ",
                                     "Question 8",
                                     "Question 9",
                                     "Question 10"},
                                    {"(Portal)??", "Noxia", "Shimmer", "Ryze", "Ekko", "FishBones", "High frequency stabilization", "yes", "yes", "no"},
                                    {"(Hoverboards)??" , "Zaun", "3??", "Viktor", "Jayce", "Pow-pow" ,"Highest power supply ", "8", "9", "10"},
                                    {"()??", "Demacia", "c??", "Galio", "Heimerdinger", "Zaap", "The right reflective mirrors", "h", "i", "j"}};
        //CATEGORY 2
        final String QANDA2 [][] = {{"Question 1.2", 
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
        final String QANDA3 [][] = {{"Question 1.3", 
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

        //NON-REPEATED RANDOM VALUES ARRAY
        ArrayList<Integer> randomGenerated = new ArrayList<Integer>();      
        ArrayList<Integer> randomAnswers = new ArrayList<Integer>();                

        //PERCENTAGE 
        final String LOWANS = "The user answered from  0% to 33% of the questions correctly.";
        final String MEDLOWANS = "The user answered from  34% to 66% of the questions correctly.";
        final String MEDHIGHANS = "The user answered from  67% to 99% of the questions correctly.";
        final String HIGHANS = "The user answered 100% of the questions correctly.";

        //CAT NAME
        final String CAT1 = "Arcane serie";
        final String CAT2 = "CATEGORY 2";
        final String CAT3 = "CATEGORY 3";

        
        String answer;
        String cat[][];
        String catName = "Not especified";
        
        final int VAL_POINTS = 10;
        final int VAL_EXTRAPOINTS = 20;

        int randomQ;
        int categroy; 

        int extraPoints = 0;

        int correctCount = 0;
        int incorrectCount = 0;
        int normalCorr = 0;

        int consecutiveErrors = 0;
        int consecutiveCorr = 0;

        int gameCounter = 0;

        boolean keepPlaying = true;
        boolean validCat = false;

         
        
        while (keepPlaying) {

            System.out.println("\n------Select category------"+
                ConsoleColors.BLUE_BOLD_BRIGHT+"\n1."+CAT1+ConsoleColors.RESET+
                ConsoleColors.GREEN_BOLD_BRIGHT+"\n2."+CAT2+ConsoleColors.RESET+
                ConsoleColors.PURPLE_BOLD_BRIGHT+"\n2."+CAT3+ConsoleColors.RESET+
                "\n---------------------------");
            //VALID CAT INPUT
            do {
                Scanner catIn = new Scanner(System.in);
                categroy = catIn.nextInt();
                if (categroy > 0 && categroy <=3){
                    validCat = true;
                } else {
                    System.out.println("Error. You need to choose a category (1, 2 or 3)");
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
                System.out.println("\n" + cat[0][randomQ]);
                System.out.println();
                // RANDOM DISPLAY TIPO TEST
                String testA="";
                String testB="";
                String testC="";

                while (cat == QANDA1 && randomAnswers.size()<= 2) { //add cat to display test abc.
                    Random r = new Random();
                    int randomA = r.nextInt(1,4);

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
                if (answer.equals("yes")) {
                    answer = "y";
                } else if (answer.equals("no"))
                    answer = "n";

                
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
                };
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
                gameCounter++;

                // GAME OVER CONDITIONS
                if (gameCounter >= cat[0].length) {
                    endGame = true;
                } else if (consecutiveErrors >= 3) {
                    endGame = true;
                    System.out.println("\nYou failed 3 questions in a row...\nGood luck next time!");
                }
            }
            randomGenerated.clear();
            randomAnswers.clear();

            // CORRECT INCORRECT SCORE
            int score = extraPoints + normalCorr*VAL_POINTS;
            System.out.println();
            System.out.println(ConsoleColors.RED+"*--------------------------*\n           GAME OVER\n*--------------------------*"+ConsoleColors.RESET);
            System.out.println("*Category: "+ catName);
            System.out.println("\nCorrect answers: "+ConsoleColors.GREEN+correctCount+ConsoleColors.RESET+"\nIncorrect answers: "+ConsoleColors.RED+incorrectCount+ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN_BOLD+"\nScore: "+ score + " points"+ConsoleColors.RESET);

            // PERCENTAGE
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

            // PLAY AGAIN
            System.out.println("\nDo you want to play again?\nY/N");
            Scanner againIn = new Scanner(System.in);
            String playAgain = againIn.nextLine().toLowerCase();

            if (playAgain.equals("n") || playAgain.equals("no")){
                keepPlaying = false;
                System.out.println("See you next time!");
            }
        }
    }
}