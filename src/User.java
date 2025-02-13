import java.util.ArrayList;

class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private ArrayList<Survey> takenSurveys;

    public User(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.takenSurveys = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Survey> getTakenSurveys() {
        return takenSurveys;
    }

    public void addSurvey(Survey survey) {
        takenSurveys.add(survey);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}