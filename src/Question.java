import java.util.ArrayList;

class Question {
    private String questionText;
    private ArrayList<Integer> responses;
    private ArrayList<User> respondents;

    public Question(String questionText) {
        this.questionText = questionText;
        this.responses = new ArrayList<>();
        this.respondents = new ArrayList<>();
    }

    public String getQuestionText() {
        return questionText;
    }

    public void recordResponse(User user, int response) {
        if (!respondents.contains(user)) {
            responses.add(response);
            respondents.add(user);
        }
    }

    public ArrayList<Integer> getResponses() {
        return responses;
    }

    public ArrayList<User> getRespondents() {
        return respondents;
    }

    public int getTotalResponses() {
        return responses.size();
    }

    public int[] getResponseCounts() {
        int[] counts = new int[5];
        for (int response : responses) {
            counts[response]++;
        }
        return counts;
    }
}