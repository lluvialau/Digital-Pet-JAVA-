package Model;

/**
 * this class represent the question object
 * @author Yu Liu
 */
public class Question {
    private String subject;
    private String correct;

    /**
     *
     * @param subject
     * @param correct
     */
    public Question(String subject, String correct) {
        this.subject = subject;
        this.correct = correct;
    }
    
    /**
     * get the question subject
     * @return
     */
    public String getSubject() {
        return subject;
    }

    /**
     * set the good subject
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * the answer if correct
     * @return
     */
    public String getCorrect() {
        return correct;
    }

    /**
     * set the anwer if correct
     * @param correct
     */
    public void setCorrect(String correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "Question{" + "subject=" + subject + ", correct=" + correct + '}';
    }
    
}
