package test;

import java.util.ArrayList;

import model.Question;
import model.QuestionBank;

public class QuestionText {

    public static void main(String[] args){

        ArrayList<Question> db = QuestionBank.database;
        Question q1 = db.get(0);
        assert q1.checkAnswer("Bill Gates") == false;
        assert q1.checkAnswer("James Gosling") == true;
        assert q1.checkAnswer("james gosling") == true;
    }
    
}
