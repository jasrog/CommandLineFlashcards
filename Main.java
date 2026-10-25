import java.util.*;
import java.lang.*;

public class Main{

    public static void main ( String args[] ){
        
        String create = "CREATE";
        String review = "REVIEW";
        String all = "ALL";
        String quit = "QUIT";
        String quiz = "QUIZ";
        int cNum = -1;
        boolean QUIT = false;
        ArrayList<Card> cardData = new ArrayList<Card>();

        Scanner input = new Scanner(System.in);

        while(QUIT == false){

        System.out.println(" \n Welcome to the flashcard creation software. \n To create a new card,type 'create'. \n To review cards, type 'review'.  \n To see every card type 'all' \n To quit, type 'quit' " + "\n");

        String command = input.next();
        Card reviewCard;

        if (command.toUpperCase().equals(create)){

            cNum += 1;

            Scanner inputtwo = new Scanner(System.in);
            System.out.println("Enter the question for the card please :: ");
            String q = inputtwo.nextLine();

            System.out.println("Now enter the answer to your question please :: ");
            Scanner inputthree = new Scanner(System.in);
            String ans = inputthree.nextLine();

            reviewCard = new Card(q, ans, cNum);
            cardData.add(cNum, reviewCard);
        }

        if (command.toUpperCase().equals(review)){

            int randomCard = (int)(Math.random() * cardData.size());

            System.out.println(functions.reviewCheck(cardData));

            functions.randomCardGenerator(randomCard, cardData);
            if(functions.answerCheck(randomCard, cardData) == true){
              System.out.println("Good Job! Your answer was correct!" + "\n" + "\n");
            }
            else {
              System.out.println("That's not quite right, the correct answer is " + cardData.get(randomCard).getAnswer() + "\n" + "\n");
            }
        }

        if (command.toUpperCase().equals(all)){
            
            for(int i = 0; i < cardData.size(); i++){
                System.out.println("Question: " + cardData.get(i).getQuestion());
                System.out.println("Answer: " + cardData.get(i).getAnswer());
            }
        }

        if (command.toUpperCase().equals(quiz)){

            System.out.println("You got a " + functions.quizScoreCalculator(cardData) + "%");
            System.out.println("Good Job!");
        }

        if(command.toUpperCase().equals(quit)){
            QUIT = true;
        }

        }
    }
}

class functions{

    public static boolean answerCheck (int randomCard, ArrayList<Card> cardData){

        Scanner inputAns = new Scanner(System.in);

        System.out.println(cardData.get(randomCard).getQuestion());

        String quizAns = inputAns.nextLine();

        if(quizAns.equalsIgnoreCase(cardData.get(randomCard).getAnswer())) {
          return true;
        }
        else {
            return false;
        }
    }

    public static String randomCardGenerator (int randomCard, ArrayList<Card> cardData){
        return cardData.get(randomCard).getQuestion();
    }

    public static double quizScoreCalculator(ArrayList<Card> cardData){
      
      double total = 0.0;
      double correct = 0.0;

      for(int i = 0; i < cardData.size(); i++){

        if(functions.answerCheck(i, cardData) == true){
          correct++;
        }
        total++;
      }

      double score = (correct/total) * 100;

      return score;

    }

    public static String reviewCheck(ArrayList<Card> cardData){
      if(cardData.size() == 0){
        return "Sorry, you need to create a card first.";
      }
      return "";
    }
}