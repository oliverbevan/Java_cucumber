package hellocucumber;

        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;

        import java.util.Date;

        import static org.junit.Assert.*;

class IsItFriday {
    static String isItFriday(String today) {
        return "Nope";
    }
}

public class StepDefinitions {
    private String today;
    private String actualAnswer;

    @Given("today is Not Friday")
    public void today_is_Sunday() throws Exception {
        Date date = new Date();
        int day;
        day = date.getDay();

        switch (day) {
            case 0:
                today = "Sunday";
                System.out.println(today);
                break;
            case 1:
                today = "Monday";
                System.out.println(today);
                break;
            case 2:
                today = "Tuesday";
                System.out.println(today);
                break;
            case 3:
                today = "Wednesday";
                System.out.println(today);
                break;
            case 4:
                today = "Thursday";
                System.out.println(today);
                break;
            case 5:
                today = "Friday";
                throw new Exception("IT IS "+today+"!!!!!!!!!!!!!!!!!");
            case 6:
                today = "Saturday";
                System.out.println("Today it is "+today);
                break;
        }

        System.out.println(today);

    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {


        assertEquals(expectedAnswer, actualAnswer);
    }

}
