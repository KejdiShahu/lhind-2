import java.util.ArrayList;

class SurveyLogic {
    private ArrayList<Survey> surveys;

    public SurveyLogic() {
        this.surveys = new ArrayList<>();
    }

    public void addSurvey(Survey survey) {
        validateSurvey(survey);
        surveys.add(survey);
    }

    private void validateSurvey(Survey survey) {
        if (survey.getQuestions().size() < 10) {
            throw new IllegalArgumentException("Survey must have at least 10 questions");
        }
        if (survey.getQuestions().size() > 40) {
            throw new IllegalArgumentException("Survey cannot have more than 40 questions");
        }

        ArrayList<String> questions = new ArrayList<>();
        for (Question q : survey.getQuestions()) {
            if (questions.contains(q.getQuestionText())) {
                throw new IllegalArgumentException("All questions must be unique");
            }
            questions.add(q.getQuestionText());
        }
    }

    public int findMostGivenAnswer(Survey survey) {
        int[] totalCounts = new int[5];
        for (Question question : survey.getQuestions()) {
            int[] counts = question.getResponseCounts();
            for (int i = 0; i < counts.length; i++) {
                totalCounts[i] += counts[i];
            }
        }

        int mostCommonResponse = Response.NO_ANSWER;
        int maxCount = 0;
        for (int i = 0; i < totalCounts.length; i++) {
            if (totalCounts[i] > maxCount) {
                maxCount = totalCounts[i];
                mostCommonResponse = i;
            }
        }
        return mostCommonResponse;
    }

    public void printSurveyResults(Survey survey) {
        for (Question question : survey.getQuestions()) {
            System.out.println("\nQuestion: " + question.getQuestionText());
            int[] counts = question.getResponseCounts();
            System.out.println("Agree: " + counts[Response.AGREE]);
            System.out.println("Slightly Agree: " + counts[Response.SLIGHTLY_AGREE]);
            System.out.println("Slightly Disagree: " + counts[Response.SLIGHTLY_DISAGREE]);
            System.out.println("Disagree: " + counts[Response.DISAGREE]);
            System.out.println("No Answer: " + counts[Response.NO_ANSWER]);
        }
    }

    public ArrayList<Integer> findCandidateAnswers(Survey survey, User candidate) {
        ArrayList<Integer> answers = new ArrayList<>();
        for (Question question : survey.getQuestions()) {
            ArrayList<User> respondents = question.getRespondents();
            int index = respondents.indexOf(candidate);
            if (index != -1) {
                answers.add(question.getResponses().get(index));
            } else {
                answers.add(Response.NO_ANSWER);
            }
        }
        return answers;
    }

    public User findMostActiveCandidate() {
        User mostActive = null;
        int maxSurveys = 0;

        for (Survey survey : surveys) {
            for (User candidate : survey.getCandidates()) {
                int surveyCount = candidate.getTakenSurveys().size();
                if (surveyCount > maxSurveys) {
                    maxSurveys = surveyCount;
                    mostActive = candidate;
                }
            }
        }
        return mostActive;
    }

    public void removeUnderperformingQuestion(Survey survey) {
        int minimumResponses = survey.getCandidates().size() / 2;

        for (Question question : survey.getQuestions()) {
            if (question.getTotalResponses() < minimumResponses) {
                survey.removeQuestion(question);
                try {
                    validateSurvey(survey);
                } catch (IllegalArgumentException e) {
                    survey.addQuestion(question);
                    System.out.println("Cannot remove question as it would make survey invalid");
                }
                return;
            }
        }
        System.out.println("No underperforming questions found");
    }
}