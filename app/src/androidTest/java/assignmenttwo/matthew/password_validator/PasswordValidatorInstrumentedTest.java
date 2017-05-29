package assignmenttwo.matthew.password_validator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class PasswordValidatorInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("assignmenttwo.matthew.password_validator", appContext.getPackageName());
    }

    @Test
    public void testValidateWithoutChangingInput() throws Exception {

        onView(withId(R.id.inputText))
                .check(matches(withText("")));
        onView(withId(R.id.validateButton))
                .perform(click());
        onView(withId(R.id.outputText))
                .check(matches(withText("Password is NOT strong enough!")));

    }

    @Test
    public void testValidateWithPuttingInvalidPass() throws Exception {

        onView(withId(R.id.inputText))
                .perform(typeText("invalid password"));
        onView(withId(R.id.validateButton))
                .perform(click());
        onView(withId(R.id.outputText))
                .check(matches(withText("Password is NOT strong enough!")));

    }

    @Test
    public void testValidateWithPuttingNoPass() throws Exception {

        onView(withId(R.id.inputText))
                .perform(typeText(""));
        onView(withId(R.id.validateButton))
                .perform(click());
        onView(withId(R.id.outputText))
                .check(matches(withText("Password is NOT strong enough!")));

    }

    @Test
    public void testValidateWithPuttingValidPass() throws Exception {

        onView(withId(R.id.inputText))
                .perform(typeText("ThisIsValid123!@#"));
        onView(withId(R.id.validateButton))
                .perform(click());
        onView(withId(R.id.outputText))
                .check(matches(withText("Password is strong enough!")));

    }
}
