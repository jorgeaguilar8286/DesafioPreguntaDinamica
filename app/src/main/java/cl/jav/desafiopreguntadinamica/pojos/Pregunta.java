package cl.jav.desafiopreguntadinamica.pojos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Pregunta {
    private String category;

    private String type;

    private String difficulty;

    private String question;

    @SerializedName("correct_answer")
    private String correctAnswer;

    @SerializedName("incorrect_answers")
    private ArrayList<String> incorrectAnswer;


    public Pregunta() {
    }

    public String getCategory() {

        return category;
    }

    public void setCategory(String category) {

        this.category = category;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getDifficulty() {

        return difficulty;
    }

    public void setDifficulty(String difficulty) {

        this.difficulty = difficulty;
    }

    public String getQuestion() {

        return question;
    }

    public void setQuestion(String question) {

        this.question = question;
    }

    public String getCorrectAnswer() {

        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {

        this.correctAnswer = correctAnswer;
    }

    public ArrayList<String> getIncorrectAnswer() {
        return incorrectAnswer;
    }

    public void setIncorrectAnswer(ArrayList<String> incorrectAnswer) {
        this.incorrectAnswer = incorrectAnswer;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", question='" + question + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", incorrectAnswer=" + incorrectAnswer +
                '}';
    }
}
