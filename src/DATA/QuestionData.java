package DATA;

import Model.Question;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * this class represent the data of question
 * @author Yu Liu
 */
public class QuestionData {

    private static QuestionData questionData = null;
    private final Random random = new Random(new Date().getTime());
    private final List<Question> questions;

    
    public QuestionData() {
        this.questions = new ArrayList<>();
        try (Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("Files/question.txt"))) {
            while (scanner.hasNextLine()) {
                String subject = scanner.nextLine().trim();
                if (scanner.hasNextLine()) {
                    String correct = scanner.nextLine().trim();
                    Question question = new Question(subject, correct);
                    questions.add(question);
                }
            }
        }
    }

    /**
     * show the answer question
     * @return answer question
     */
    public static QuestionData getInstance() {
        if (questionData == null) {
            questionData = new QuestionData();
        }
        return questionData;
    }

    /**
     * get the next question
     * @return the question of next
     */
    public Question nextQuestion() {
        return questions.get(random.nextInt(questions.size()));
    }

}
