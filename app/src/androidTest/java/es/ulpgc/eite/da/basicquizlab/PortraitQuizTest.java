package es.ulpgc.eite.da.basicquizlab;


import android.content.Context;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@SuppressWarnings("ALL")
@LargeTest
@RunWith(AndroidJUnit4.class)
public class PortraitQuizTest {

  @Rule
  public ActivityTestRule<QuestionActivity> mActivityTestRule =
      new ActivityTestRule<>(QuestionActivity.class);

  @Test
  public void questionActivityTest() {

    Context appContext = 
        InstrumentationRegistry.getInstrumentation().getTargetContext();

    String[] questionArray = 
        appContext.getResources().getStringArray(R.array.question_array);
    
    String correctText = appContext.getString(R.string.correct_text);
    String incorrectText = appContext.getString(R.string.incorrect_text);
    String emptyText = appContext.getString(R.string.empty_text);
    
    
    // GIVEN

    ViewInteraction textView = onView(withId(R.id.questionText));
    textView.check(matches(withText(questionArray[0])));

    ViewInteraction textView2 = onView(withId(R.id.replyText));
    textView2.check(matches(withText(emptyText)));

    // WHEN

    ViewInteraction button = onView(withId(R.id.trueButton));
    button.perform(click());

    // THEN

    ViewInteraction textView3 = onView(withId(R.id.questionText));
    textView3.check(matches(withText(questionArray[0])));

    ViewInteraction textView4 = onView(withId(R.id.replyText));
    textView4.check(matches(withText(correctText)));

    // ------------------------


    // GIVEN

    ViewInteraction textView43 = onView(withId(R.id.questionText));
    textView43.check(matches(withText(questionArray[0])));

    ViewInteraction textView44 = onView(withId(R.id.replyText));
    textView44.check(matches(withText(correctText)));

    // WHEN

    ViewInteraction button2 = onView(withId(R.id.nextButton));
    button2.perform(click());

    // THEN & GIVEN

    ViewInteraction textView5 = onView(withId(R.id.questionText));
    textView5.check(matches(withText(questionArray[1])));

    ViewInteraction textView6 = onView(withId(R.id.replyText));
    textView6.check(matches(withText(emptyText)));

    // ------------------------

    // WHEN

    ViewInteraction button3 = onView(withId(R.id.nextButton));
    button3.perform(click());

    // THEN & GIVEN

    ViewInteraction textView7 = onView(withId(R.id.questionText));
    textView7.check(matches(withText(questionArray[1])));


    ViewInteraction textView8 = onView(withId(R.id.replyText));
    textView8.check(matches(withText(emptyText)));

    // ------------------------


    // WHEN

    ViewInteraction button4 = onView(withId(R.id.trueButton));
    button4.perform(click());

    // THEN & GIVEN

    ViewInteraction textView9 = onView(withId(R.id.questionText));
    textView9.check(matches(withText(questionArray[1])));


    ViewInteraction textView11 = onView(withId(R.id.replyText));
    textView11.check(matches(withText(incorrectText)));

    // ------------------------


    // WHEN

    ViewInteraction button5 = onView(withId(R.id.trueButton));
    button5.perform(click());

    // THEN & GIVEN

    ViewInteraction textView12 = onView(withId(R.id.questionText));
    textView12.check(matches(withText(questionArray[1])));

    ViewInteraction textView13 = onView(withId(R.id.replyText));
    textView13.check(matches(withText(incorrectText)));


    // ------------------------


    // WHEN

    ViewInteraction button6 = onView(withId(R.id.falseButton));
    button6.perform(click());

    // THEN & GIVEN

    ViewInteraction textView14 = onView(withId(R.id.questionText));
    textView14.check(matches(withText(questionArray[1])));

    ViewInteraction textView15 = onView(withId(R.id.replyText));
    textView15.check(matches(withText(incorrectText)));


    // ------------------------


    // WHEN

    ViewInteraction button7 = onView(withId(R.id.nextButton));
    button7.perform(click());

    // THEN & GIVEN

    ViewInteraction textView16 = onView(withId(R.id.questionText));
    textView16.check(matches(withText(questionArray[2])));

    ViewInteraction textView17 = onView(withId(R.id.replyText));
    textView17.check(matches(withText(emptyText)));


    // ------------------------


    // WHEN

    ViewInteraction button8 = onView(withId(R.id.falseButton));
    button8.perform(click());

    // THEN & GIVEN

    ViewInteraction textView18 = onView(withId(R.id.questionText));
    textView18.check(matches(withText(questionArray[2])));

    ViewInteraction textView19 = onView(withId(R.id.replyText));
    textView19.check(matches(withText(incorrectText)));


    // ------------------------


    // WHEN

    ViewInteraction button9 = onView(withId(R.id.nextButton));
    button9.perform(click());

    // THEN

    ViewInteraction textView20 = onView(withId(R.id.questionText));
    textView20.check(matches(withText(questionArray[0])));

    ViewInteraction textView21 = onView(withId(R.id.replyText));
    textView21.check(matches(withText(emptyText)));
  }




  @Test
  public void cheatActivityTest() {

    Context appContext =
        InstrumentationRegistry.getInstrumentation().getTargetContext();

    String[] questionArray =
        appContext.getResources().getStringArray(R.array.question_array);

    String correctText = appContext.getString(R.string.correct_text);
    String incorrectText = appContext.getString(R.string.incorrect_text);
    String emptyText = appContext.getString(R.string.empty_text);

    String trueText = appContext.getString(R.string.true_text);
    String falseText = appContext.getString(R.string.false_text);
    String warningText = appContext.getString(R.string.warning_text);

    // GIVEN

    ViewInteraction textView21 = onView(withId(R.id.questionText));
    textView21.check(matches(withText(questionArray[0])));

    ViewInteraction textView22 = onView(withId(R.id.replyText));
    textView22.check(matches(withText(emptyText)));


    // WHEN

    ViewInteraction button = onView(withId(R.id.cheatButton));
    button.perform(click());

    // THEN & GIVEN

    ViewInteraction textView = onView(withId(R.id.warningText));
    textView.check(matches(withText(warningText)));


    ViewInteraction textView2 = onView(withId(R.id.answerText));
    textView2.check(matches(withText(emptyText)));


    // ------------------------

    // WHEN

    pressBack();

    // THEN & GIVEN

    ViewInteraction textView3 = onView(withId(R.id.questionText));
    textView3.check(matches(withText(questionArray[0])));

    ViewInteraction textView4 = onView(withId(R.id.replyText));
    textView4.check(matches(withText(emptyText)));

    // ------------------------

    // WHEN

    ViewInteraction button2 = onView(withId(R.id.cheatButton));
    button2.perform(click());

    ViewInteraction button3 = onView(withId(R.id.noButton));
    button3.perform(click());


    // THEN & GIVEN

    ViewInteraction textView5 = onView(withId(R.id.questionText));
    textView5.check(matches(withText(questionArray[0])));

    ViewInteraction textView6 = onView(withId(R.id.replyText));
    textView6.check(matches(withText(emptyText)));

    // ------------------------

    // WHEN

    ViewInteraction button4 = onView(withId(R.id.cheatButton));
    button4.perform(click());

    ViewInteraction button5 = onView(withId(R.id.yesButton));
    button5.perform(click());


    // THEN & GIVEN

    ViewInteraction textView7 = onView(withId(R.id.warningText));
    textView7.check(matches(withText(warningText)));

    ViewInteraction textView8 = onView(withId(R.id.answerText));
    textView8.check(matches(withText(trueText)));

    // ------------------------

    // WHEN

    pressBack();

    // THEN & GIVEN

    ViewInteraction textView9 = onView(withId(R.id.questionText));
    textView9.check(matches(withText(questionArray[1])));

    ViewInteraction textView10 = onView(withId(R.id.replyText));
    textView10.check(matches(withText(emptyText)));


    // ------------------------

    // WHEN

    ViewInteraction button6 = onView(withId(R.id.falseButton));
    button6.perform(click());

    ViewInteraction textView11 = onView(withId(R.id.questionText));
    textView11.check(matches(withText(questionArray[1])));

    ViewInteraction textView13 = onView(withId(R.id.replyText));
    textView13.check(matches(withText(correctText)));


    ViewInteraction button7 = onView(withId(R.id.cheatButton));
    button7.perform(click());

    // THEN

    ViewInteraction textView14 = onView(withId(R.id.questionText));
    textView14.check(matches(withText(questionArray[1])));

    ViewInteraction textView15 = onView(withId(R.id.replyText));
    textView15.check(matches(withText(correctText)));
  }



  private void delayTest(long msecs) {

    try {
      Thread.sleep(msecs);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
