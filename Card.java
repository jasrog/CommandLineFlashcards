import java.util.*;

public class Card {

    private int cardNumber;
    private String question;
    private String answer;


    public Card(){
        cardNumber = 0;
        question = "";
        answer = "";
    }

    public Card(String q, String ans, int cNum){
        question = q;
        answer = ans;
        cardNumber = cNum;
    }

    public void setCard(String q, String ans, int cNum){
        question = q;
        answer = ans;
        cardNumber = cNum;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }

    public String toString(){
        return "Question: " + question + "\n Answer: " + answer;
    }
}