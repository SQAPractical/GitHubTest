package study.qa.automation.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static study.qa.automation.utils.TestContext.executeJavascript;
import static study.qa.automation.utils.TestContext.getDriver;

public class def_3_13 {
    @When("^Navigate to login page$")
    public void navigateToLoginPage() {
//        getDriver().get("http://192.168.2.251");
        getDriver().get("http://local.school.portnov.com:4520/#/login");
    }

    @And("^Type email \"([^\"]*)\"$")
    public void typeEmail(String email) throws Throwable {
        Thread.sleep(2000);
//        String st = "Array.from(document.querySelectorAll('#mat-input-0'))[0].click()";
//        executeJavascript(st);
//        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys(email);
        Thread.sleep(1000);
    }

    @And("^Type Password \"([^\"]*)\"$")
    public void typePassword(String pass) throws Throwable {
        Thread.sleep(1000);
        String st = "Array.from(document.querySelectorAll('#mat-input-1'))[0].click()";
        executeJavascript(st);
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys(pass);
        Thread.sleep(1000);
    }

    @And("^Push Sign In button$")
    public void pushSignInButton() throws Throwable {
        Thread.sleep(1000);
        String st = "Array.from(document.querySelectorAll('.mat-button-wrapper'))[0].click()";
        executeJavascript(st);
        Thread.sleep(2000);
    }

    @And("^Error message displayed: \"([^\"]*)\"$")
    public void errorMessageDisplayed(String errorMessage) throws Throwable {
//        Thread.sleep(2000);
//        String st = getDriver().findElements(By.cssSelector(".cdk-overlay-pane > snack-bar-container > simple-snack-bar")).get(0).getText();
//        Assert.assertTrue(st.contains(errorMessage));
//        Thread.sleep(1000);

        Thread.sleep(1000);
        String message = getDriver().findElement(By.xpath("//simple-snack-bar[contains(text(),'Authentication failed')]")).getText();
        Assert.assertTrue(message.contains(errorMessage));
        Thread.sleep(1000);
    }




    @And("^Make sure user name is \"([^\"]*)\"$")
    public void elementIsPresent(String userName) throws Throwable {
        Thread.sleep(1000);
        String st = getDriver().findElements(By.cssSelector(("body > ac-root > mat-sidenav-container > mat-sidenav > ac-side-menu > mat-list > header > div > h3"))).get(0).getText();
        Assert.assertTrue(st.contains(userName));
    }

    @And("^Click on Quizzes on left navigational panel$")
    public void clickOnQuizzesOnLeftNavigationalPanel() throws Throwable {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
        Thread.sleep(2000);
    }

    @And("^Push Create new Quiz button$")
    public void pushCreateNewQuizButton() throws Throwable {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
        Thread.sleep(2000);
    }

    @And("^Type Title of the Quiz \"([^\"]*)\"$")
    public void typeTitleOfTheQuiz(String title) throws Throwable {
        getDriver().findElement(By.xpath("//*[@placeholder='Title Of The Quiz *']")).sendKeys(title);
        Thread.sleep(2000);
    }

    @And("^Click Add Question$")
    public void clickAddQuestion() throws Throwable {
        getDriver().findElement(By.xpath("//*[text()='add_circle']")).click();
        Thread.sleep(1000);
    }

    @And("^Select Single-Choice Type of question$")
    public void selectSingleChoiceTypeOfQuestion() {
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q1:')]/../../..//div[contains(text(), 'Single-Choice')]")).click();
    }

    @And("^Type text of Question \"([^\"]*)\"$")
    public void typeTextOfQuestion(String text) throws Throwable {
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q1:')]/../../..//*[@placeholder='Question *']")).sendKeys(text);
        Thread.sleep(2000);
    }

    @And("^Type text in Options \"([^\"]*)\" and \"([^\"]*)\"$")
    public void typeTextInOptionsAnd(String option1, String option2) throws Throwable {
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q1:')]/../../..//textarea[@placeholder='Option 1*']")).sendKeys(option1);
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q1:')]/../../..//textarea[@placeholder='Option 2*']")).sendKeys(option2);
        Thread.sleep(1000);
    }

    @And("^Select first option as correct answer$")
    public void selectFirstOptionAsCorrectAnswer() throws Throwable {
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q1:')]/../../..//*[@placeholder='Option 1*']/../../../../..//mat-radio-button")).click();
        Thread.sleep(1000);
    }

    @And("^Push Save button$")
    public void pushSaveButton() throws Throwable {
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//span[contains(text(), 'Save')]")).click();
        Thread.sleep(1000);
    }

    @And("^Click Assignments on left navigational panel$")
    public void clickAssignmentsOnLeftNavigationalPanel() throws Throwable {
        getDriver().findElement(By.xpath("//h5[text()='Assignments']")).click();
        Thread.sleep(5000);
    }

    @And("^Push Create new Assignment button$")
    public void pushCreateNewAssignmentButton() throws Throwable {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Create New Assignment')]")).click();
        Thread.sleep(5000);
    }

    @And("^Select Quiz \"([^\"]*)\"$")
    public void selectQuiz(String title) throws Throwable {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Select Quiz To Assign')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//div/..//*[contains (text(), \'" + title + "\')]")).click();
        Thread.sleep(1000);
    }

    @And("^Select Student \"([^\"]*)\"$")
    public void selectStudent(String nameStudent) throws Throwable {
        getDriver().findElement(By.xpath("//div[@class= 'mat-list-text'][contains(.,\'" + nameStudent + "\')]")).click();
        Thread.sleep(1000);

//        List<WebElement> names = getDriver().findElements(By.xpath("//div[@class= 'mat-list-text']"));
//        int count = names.size();
//        for (int i = 0; i < count; i++) {
//            String text = names.get(i).getText();
//            if (text.contains(nameStudent)) {
//                names.get(i).click();
//                Thread.sleep(1000);
//                break;
//            }
//        }
    }

    @And("^Push Give Assignment button$")
    public void pushGiveAssignmentButton() throws Throwable {
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]")).click();
        Thread.sleep(2000);
    }

    @And("^Click Logout on left navigational panel$")
    public void clickLogoutOnLeftNavigationalPanel() throws Throwable {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
        Thread.sleep(1000);
    }

    @And("^Click My Assignments on left navigational panel$")
    public void clickMyAssignmentsOnLeftNavigationalPanel() throws Throwable {
        getDriver().findElement(By.xpath("//h5[contains(text(),'My Assignments')]")).click();
        Thread.sleep(1000);
    }

    @Then("^Verify that quiz \"([^\"]*)\" was assign$")
    public void verifyThatQuizWasAssign(String myquiz) throws Throwable {
        WebElement quiz = getDriver().findElement(By.xpath("//h4[contains(text(), 'My Assignment')]/..//*[contains(text(), 'Assignment Sofia')]"));
        String textFromQuiz = quiz.getText();
        Assert.assertTrue(textFromQuiz.contains(myquiz));
        String name = getDriver().findElement(By.xpath("//div[@class='info']//h3")).getText();
        if (textFromQuiz.contains(myquiz)) {
            System.out.println(name + " get assignment. ");
        }
    }

    @And("^Delete quiz with name \"([^\"]*)\"$")
    public void deleteQuizWithName(String quiz) throws Throwable {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
        Thread.sleep(2000);

        int quizzes = getDriver().findElements(By.xpath("//*[contains(text(), 'Testing Assignment Sofia')]")).size();
        for (int i = 0; i < quizzes; i++) {
            getDriver().findElement(By.xpath("//*[contains(text(), 'Testing Assignment Sofia')]")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//*[contains(text(), 'Testing Assignment Sofia')]/../../..//*[contains(text(), 'Delete')]")).click();
            Thread.sleep(1000);

            getDriver().findElement(By.xpath("//*[contains(text(), 'Confirmation')]/../../..//*[contains(text(), 'Delete')]")).click();
            Thread.sleep(5000);

        }
    }

    @And("^Delete assignments with name \"([^\"]*)\"$")
    public void deleteAssignmentsWithName(String arg0) throws Throwable {
        getDriver().findElement(By.xpath("//h5[text()='Assignments']")).click();
        Thread.sleep(1000);

        int countAssignments = getDriver().findElements(By.xpath("//*[contains(text(),'Testing Assignment Sofia')]/..//*[contains(text(), 'more_vert')]")).size();
        Thread.sleep(1000);

        if (countAssignments != 0) {
            getDriver().findElement(By.xpath("//*[contains(text(),'Testing Assignment Sofia')]/..//*[contains(text(), 'more_vert')]")).click();
            Thread.sleep(1000);

            getDriver().findElement(By.xpath("//span[contains(text(),'Delete Assignment')]")).click();
            Thread.sleep(3000);
            getDriver().findElement(By.xpath("//*[contains(text(), 'Confirmation')]/../../..//*[contains(text(), 'Delete')]")).click();
            Thread.sleep(3000);
        }
    }
}
