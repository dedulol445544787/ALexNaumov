package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulSubmitFormTest() {
        open("https://demoqa.com/");

        $(byText("Elements")).click();
        $(byText("Text Box")).click();

        $("[id='userName']").setValue("John");
        $("[id='userEmail']").setValue("johndoe@mail.com");
        $("[id='currentAddress']").setValue("123 Main St");
        $("[id='permanentAddress']").setValue("456 Second St");
        $("[id='submit']").click();

        $("[id='name']").shouldHave(text("Name:"), text("John"));
        $("[id='email']").shouldHave(text("Email:"), text("johndoe@mail.com"));
        $("[id='currentAddress']").shouldHave(
                text("Current Address :"), text("123 Main St"));
        $("[id='permanentAddress']").shouldHave(
                text("Permanent Address :"), text("456 Second St"));
    }
}