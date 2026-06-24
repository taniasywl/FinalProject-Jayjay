package web.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.page.AboutUsPage;

public class AboutUsSteps {
    AboutUsPage aboutUsPage = new AboutUsPage(BaseTest.driver);

    @Given("the About Us popup is displayed")
    public void the_about_us_popup_is_displayed() {
        aboutUsPage.openAboutUs();
        aboutUsPage.verifyPopupDisplayed();
    }

    @Given("the video is playing")
    public void video_is_playing() {
        aboutUsPage.openAboutUs();
        aboutUsPage.clickPlay();
    }

    @Given("the user has closed the About Us popup")
    public void user_closed_popup() {
        aboutUsPage.openAboutUs();
        aboutUsPage.clickClose();
        aboutUsPage.verifyPopupClosed();
    }

    @When("the user clicks the About Us menu")
    public void the_user_clicks_the_about_us_menu() {
        aboutUsPage.openAboutUs();
    }

    @When("the user clicks About Us button {string}")
    public void the_user_clicks_about_us_button(String button) {
        switch (button.toLowerCase()) {
            case "play":
                aboutUsPage.clickPlay();
                break;
            case "pause":
                aboutUsPage.clickPause();
                break;
            case "close":
                aboutUsPage.clickClose();
                break;
            default:
                throw new IllegalArgumentException(
                        "Unsupported button: " + button
                );
        }
    }

    @When("the user clicks the About Us X icon")
    public void the_user_clicks_the_about_us_x_icon() {
        aboutUsPage.clickX();
    }

    @Then("the About Us popup should be displayed again")
    public void popup_should_be_displayed_again() {
        aboutUsPage.verifyPopupDisplayedAgain();
    }

    @Then("the About Us popup should be closed")
    public void popup_should_be_closed() {
        aboutUsPage.verifyPopupClosed();
    }

    @Then("the video should be displayed")
    public void video_should_be_displayed() {
        aboutUsPage.verifyVideoDisplayed();
    }

    @Then("the Play button should be displayed")
    public void play_button_should_be_displayed() {
        aboutUsPage.verifyPlayButtonDisplayed();
    }

    @Then("the video controls should be available")
    public void video_controls_should_be_available() {
        aboutUsPage.verifyControlsAvailable();
    }

    @Then("the video should start playing")
    public void video_should_start_playing() {
        aboutUsPage.verifyVideoPlaying();
    }

    @Then("the video should be paused")
    public void video_should_be_paused() {
        aboutUsPage.verifyVideoPaused();
    }

    @Then("the About Us Close button should be displayed")
    public void about_us_close_button_should_be_displayed() {
        aboutUsPage.verifyCloseButtonDisplayed();
    }
}


