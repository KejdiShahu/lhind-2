import java.util.ArrayList;

class Survey {
    private String title;
    private String topic;
    private String description;
    private ArrayList<Question> questions;
    private ArrayList<User> candidates;

    public Survey(String title, String topic, String description) {
        this.title = title;
        this.topic = topic;
        this.description = description;
        this.questions = new ArrayList<>();
        this.candidates = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public ArrayList<User> getCandidates() {
        return candidates;
    }

    public void addCandidate(User user) {
        if (!candidates.contains(user)) {
            candidates.add(user);
            user.addSurvey(this);
        }
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public boolean removeQuestion(Question question) {
        return questions.remove(question);
    }
}