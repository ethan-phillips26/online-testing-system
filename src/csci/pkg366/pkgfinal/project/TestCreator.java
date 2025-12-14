/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csci.pkg366.pkgfinal.project;
import java.util.Scanner;
import java.util.Collection;
import java.util.ArrayList;

/**
 *
 * @author cedar
 */
public class TestCreator {
    Scanner scan = new Scanner(System.in);
    public void AnswerBuilder(Questions q){
        String correct = "";
        Answers answer1 = new Answers();
        Answers answer2 = new Answers();
        Answers answer3 = new Answers();
        Answers answer4 = new Answers();
        int input;
        Collection<Answers> collection = new ArrayList<Answers>() {};
        System.out.print("How many options(1-4)?:");
        input = scan.nextInt();
        
        switch(input){
            case 1:
                System.out.println("Answer 1:");
                answer1.setAnswerText(scan.nextLine());
                System.out.println("Is it correct(Y/N)?:");
                correct = scan.nextLine();
                correct = correct.toUpperCase();
                switch(correct){
                    case("Y"):
                        answer1.setIsCorrect(Boolean.TRUE);
                    case("N"):
                        answer1.setIsCorrect(Boolean.FALSE);
                }
                collection.add(answer1);
                answer1.setQuestionId(q.getQuestionId());
            case 2:
                System.out.println("Answer 1:");
                answer1.setAnswerText(scan.nextLine());
                System.out.println("Is it correct(Y/N)?:");
                correct = scan.nextLine();
                correct = correct.toUpperCase();
                switch(correct){
                    case("Y"):
                        answer1.setIsCorrect(Boolean.TRUE);
                    case("N"):
                        answer1.setIsCorrect(Boolean.FALSE);
                }
                System.out.println("Answer 2:");
                answer2.setAnswerText(scan.nextLine());
                System.out.println("Is it correct(Y/N)?:");
                correct = scan.nextLine();
                correct = correct.toUpperCase();
                switch(correct){
                    case("Y"):
                        answer2.setIsCorrect(Boolean.TRUE);
                    case("N"):
                        answer2.setIsCorrect(Boolean.FALSE);
                }
                collection.add(answer1);
                collection.add(answer2);
                answer1.setQuestionId(q.getQuestionId());
                answer2.setQuestionId(q.getQuestionId());
            case 3:
                System.out.println("Answer 1:");
                answer1.setAnswerText(scan.nextLine());
                System.out.println("Is it correct(Y/N)?:");
                correct = scan.nextLine();
                correct = correct.toUpperCase();
                switch(correct){
                    case("Y"):
                        answer1.setIsCorrect(Boolean.TRUE);
                    case("N"):
                        answer1.setIsCorrect(Boolean.FALSE);
                }
                System.out.println("Answer 2:");
                answer2.setAnswerText(scan.nextLine());
                System.out.println("Is it correct(Y/N)?:");
                correct = scan.nextLine();
                correct = correct.toUpperCase();
                switch(correct){
                    case("Y"):
                        answer2.setIsCorrect(Boolean.TRUE);
                    case("N"):
                        answer2.setIsCorrect(Boolean.FALSE);
                }
                System.out.println("Answer 3:");
                answer3.setAnswerText(scan.nextLine());
                System.out.println("Is it correct(Y/N)?:");
                correct = scan.nextLine();
                correct = correct.toUpperCase();
                switch(correct){
                    case("Y"):
                        answer3.setIsCorrect(Boolean.TRUE);
                    case("N"):
                        answer3.setIsCorrect(Boolean.FALSE);
                }
                collection.add(answer1);
                collection.add(answer2);
                collection.add(answer3);
                answer1.setQuestionId(q.getQuestionId());
                answer2.setQuestionId(q.getQuestionId());
                answer3.setQuestionId(q.getQuestionId());
            case 4:
                System.out.println("Answer 1:");
                answer1.setAnswerText(scan.nextLine());
                System.out.println("Is it correct(Y/N)?:");
                correct = scan.nextLine();
                correct = correct.toUpperCase();
                switch(correct){
                    case("Y"):
                        answer1.setIsCorrect(Boolean.TRUE);
                    case("N"):
                        answer1.setIsCorrect(Boolean.FALSE);
                }
                System.out.println("Answer 2:");
                answer2.setAnswerText(scan.nextLine());
                System.out.println("Is it correct(Y/N)?:");
                correct = scan.nextLine();
                correct = correct.toUpperCase();
                switch(correct){
                    case("Y"):
                        answer2.setIsCorrect(Boolean.TRUE);
                    case("N"):
                        answer2.setIsCorrect(Boolean.FALSE);
                }
                System.out.println("Answer 3:");
                answer3.setAnswerText(scan.nextLine());
                System.out.println("Is it correct(Y/N)?:");
                correct = scan.nextLine();
                correct = correct.toUpperCase();
                switch(correct){
                    case("Y"):
                        answer3.setIsCorrect(Boolean.TRUE);
                    case("N"):
                        answer3.setIsCorrect(Boolean.FALSE);
                }
                System.out.println("Answer 4:");
                answer4.setAnswerText(scan.nextLine());
                System.out.println("Is it correct(Y/N)?:");
                correct = scan.nextLine();
                correct = correct.toUpperCase();
                switch(correct){
                    case("Y"):
                        answer4.setIsCorrect(Boolean.TRUE);
                    case("N"):
                        answer4.setIsCorrect(Boolean.FALSE);
                }
                collection.add(answer1);
                collection.add(answer2);
                collection.add(answer3);
                collection.add(answer4);
                answer1.setQuestionId(q.getQuestionId());
                answer2.setQuestionId(q.getQuestionId());
                answer3.setQuestionId(q.getQuestionId());
                answer4.setQuestionId(q.getQuestionId());
        }
        q.setAnswersCollection(collection);
    }
    
    public void QuestionBuilder(){
        Questions question = new Questions();
        String textInput = "";
        String enterAnsNow = "N";
        System.out.println("Enter the question:");
        textInput = scan.nextLine();
        question.setQuestionText(textInput);
        System.out.println("Set answers now(Y/N)?:");
        enterAnsNow = scan.nextLine();
        enterAnsNow = enterAnsNow.toUpperCase();
        if(enterAnsNow.equals("Y")){
            AnswerBuilder(question);
        }
    }
    
    public void TestBuilder(){
        
    }
    
    public String DisplayCreatedTests(){
        return "";
    }
}
