import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SurveyLogic surveyLogic = new SurveyLogic();

        User user1 = new User("Alice", "Smith", "alice@example.com", "1234567890");
        User user2 = new User("Bob", "Jones", "bob@example.com", "0987654321");
        User user3 = new User("Charlie", "Brown", "charlie@example.com", "5555555555");

        Survey survey = new Survey("Customer Feedback", "Service Quality", "Evaluate our service");

        survey.addCandidate(user1);
        survey.addCandidate(user2);
        survey.addCandidate(user3);

        for (int i = 1; i <= 11; i++) {
            survey.addQuestion(new Question("Question " + i));
        }

        Question q1 = survey.getQuestions().get(0);
        q1.recordResponse(user1, Response.AGREE);
        q1.recordResponse(user3, Response.DISAGREE);

        Question q2 = survey.getQuestions().get(1);
        q2.recordResponse(user1, Response.DISAGREE);
        q2.recordResponse(user3, Response.NO_ANSWER);

        try {
            surveyLogic.addSurvey(survey);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("Most common response: " + surveyLogic.findMostGivenAnswer(survey));

        System.out.println("\nSurvey Results:");
        surveyLogic.printSurveyResults(survey);

        System.out.println("\nAlice's answers:");
        ArrayList<Integer> aliceAnswers = surveyLogic.findCandidateAnswers(survey, user1);
        for (int response : aliceAnswers) {
            switch (response) {
                case Response.AGREE:
                    System.out.println("Agree");
                    break;
                case Response.SLIGHTLY_AGREE:
                    System.out.println("Slightly Agree");
                    break;
                case Response.SLIGHTLY_DISAGREE:
                    System.out.println("Slightly Disagree");
                    break;
                case Response.DISAGREE:
                    System.out.println("Disagree");
                    break;
                default:
                    System.out.println("No Answer");
            }
        }

        User mostActive = surveyLogic.findMostActiveCandidate();
        if (mostActive != null) {
            System.out.println("\nMost active candidate: " + mostActive.getFirstName());
        }

        System.out.println("\nRemoving underperforming questions...");
        surveyLogic.removeUnderperformingQuestion(survey);
        System.out.println("Questions after removal:");
        for (Question q : survey.getQuestions()) {
            System.out.println(q.getQuestionText());
        }
    }
}