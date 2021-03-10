package es.ulpgc.eite.da.basicquizlab.test;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.RemoteException;

import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;

import org.junit.Rule;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.ulpgc.eite.da.basicquizlab.QuestionActivity;
import es.ulpgc.eite.da.basicquizlab.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.Matchers.not;

@SuppressWarnings("ALL")
public class QuizSteps {

  private static final int DELAY_IN_SECS = 0 * 1000;

  @Rule
  public ActivityTestRule<QuestionActivity> testRule =
      new ActivityTestRule(QuestionActivity.class, true, false);

  private Activity activity;


  @Before("@quiz-feature")
  public void setUp() {
    testRule.launchActivity(new Intent());
    activity = testRule.getActivity();
  }

  @After("@quiz-feature")
  public void tearDown() {
    testRule.finishActivity();
  }


  @Given("^iniciar pantalla Question$")
  public void iniciarPantallaQuestion() {

    try {
      UiDevice device = UiDevice.getInstance(getInstrumentation());
      device.setOrientationNatural();
    } catch (RemoteException e) {
    }

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }

  }

  @And("^mostrar pregunta \"([^\"]*)\"$")
  public void mostrarPregunta(String q) {
    onView(withId(R.id.questionText)).check(matches(isDisplayed()));
    onView(withId(R.id.questionText)).check(matches(withText(q)));
  }

  @And("^ocultar resultado$")
  public void ocultarResultado() {
    //onView(withId(R.id.questionText)).check(matches(not(isDisplayed())));
    //onView(withId(R.id.replyText)).check(matches(isDisplayed()));
    //onView(withId(R.id.replyText)).check(matches(withText("???")));
    onView(withId(R.id.replyText))
        .check(matches(withText(activity.getString(R.string.empty_text))));
  }


  @And("^ocultar respuesta$")
  public void ocultarRespuesta() {
    //onView(withId(R.id.answerText)).check(matches(isDisplayed()));
    //onView(withId(R.id.answerText)).check(matches(withText("???")));
    onView(withId(R.id.answerText))
        .check(matches(withText(activity.getString(R.string.empty_text))));
  }

  @And("^mostrar botones True y False y Cheat activados$")
  public void mostrarBotonesTrueYFalseYCheatActivados() {
    onView(withId(R.id.trueButton)).check(matches(isEnabled()));
    onView(withId(R.id.falseButton)).check(matches(isEnabled()));
    onView(withId(R.id.cheatButton)).check(matches(isEnabled()));
  }

  @And("^mostrar boton Next desactivado$")
  public void mostrarBotonNextDesactivado() {
    onView(withId(R.id.nextButton)).check(matches(not(isEnabled())));
  }

  @When("^pulsar boton \"([^\"]*)\"$")
  public void pulsarBoton(String b) {

    String tb = activity.getString(R.string.true_button_text);
    //int button = (b.equals("True")) ? R.id.trueButton : R.id.falseButton;
    int button = (b.equals(tb)) ? R.id.trueButton : R.id.falseButton;
    onView(withId(button)).check(matches(isDisplayed()));
    onView(withId(button)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @Then("^mostrar resultado \"([^\"]*)\" a respuesta \"([^\"]*)\"$")
  public void mostrarResultadoARespuesta(String r, String a) {
    onView(withId(R.id.replyText)).check(matches(isDisplayed()));
    onView(withId(R.id.replyText)).check(matches(withText(r)));
  }

  @And("^mostrar botones True y False y Cheat desactivados$")
  public void mostrarBotonesTrueYFalseYCheatDesactivados() {
    onView(withId(R.id.trueButton)).check(matches(not(isEnabled())));
    onView(withId(R.id.falseButton)).check(matches(not(isEnabled())));
    onView(withId(R.id.cheatButton)).check(matches(not(isEnabled())));

  }

  @And("^mostrar boton Next activado$")
  public void mostrarBotonNextActivado() {
    onView(withId(R.id.nextButton)).check(matches(isEnabled()));
  }

  @When("^pulsar boton Cheat$")
  public void pulsarBotonCheat() {

    onView(withId(R.id.cheatButton)).check(matches(isDisplayed()));
    onView(withId(R.id.cheatButton)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @Then("^iniciar pantalla Cheat$")
  public void iniciarPantallaCheat() {
    //getInstrumentation().waitForIdleSync();

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @And("^mostrar mensaje Warning$")
  public void mostrarMensajeWarning() {
    onView(withId(R.id.warningText)).check(matches(isDisplayed()));
    //onView(withId(R.id.warningText))
    //    .check(matches(withText("Are you sure?")));
    onView(withId(R.id.warningText))
        .check(matches(withText(activity.getString(R.string.warning_text))));
  }

  @And("^mostrar botones Yes y No activados$")
  public void mostrarBotonesYesYNoActivados() {
    onView(withId(R.id.yesButton)).check(matches(isEnabled()));
    onView(withId(R.id.noButton)).check(matches(isEnabled()));
  }

  @When("^pulsar boton No$")
  public void pulsarBotonNo() {

    onView(withId(R.id.noButton)).check(matches(isDisplayed()));
    onView(withId(R.id.noButton)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @Then("^finalizar pantalla Cheat$")
  public void finalizarPantallaCheat() {
    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @And("^resumir pantalla Question$")
  public void resumirPantallaQuestion() {
    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @When("^pulsar boton Yes$")
  public void pulsarBotonYes() {

    onView(withId(R.id.yesButton)).check(matches(isDisplayed()));
    onView(withId(R.id.yesButton)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @Then("^mostrar respuesta \"([^\"]*)\" a pregunta \"([^\"]*)\"$")
  public void mostrarRespuestaAPregunta(String a, String q) {
    onView(withId(R.id.answerText)).check(matches(isDisplayed()));
    onView(withId(R.id.answerText)).check(matches(withText(a)));
  }

  @And("^mostrar botones Yes y No desactivados$")
  public void mostrarBotonesYesYNoDesactivados() {
    onView(withId(R.id.yesButton)).check(matches(not(isEnabled())));
    onView(withId(R.id.noButton)).check(matches(not(isEnabled())));

  }

  @When("^pulsar boton Back$")
  public void pulsarBotonBack() {
    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }

    //getInstrumentation().waitForIdleSync();
    pressBack();
  }

  @When("^pulsar boton Next$")
  public void pulsarBotonNext() {

    onView(withId(R.id.nextButton)).check(matches(isDisplayed()));
    onView(withId(R.id.nextButton)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @When("^girar pantalla$")
  public void girarPantalla() {

    int orientation = activity.getRequestedOrientation();

//    if(orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
//      orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
//
//    } else {
//      orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
//    }
//
//    activity.setRequestedOrientation(orientation);

    try {

      UiDevice device = UiDevice.getInstance(getInstrumentation());

      if(orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
        device.setOrientationNatural();

      } else {
        device.setOrientationLeft();
      }

    } catch (RemoteException e) {
    }

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }


  }
}
