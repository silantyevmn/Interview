package silantyevmn.ru.developerinterview;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import silantyevmn.ru.developerinterview.Lesson1.ConvertActivity;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static org.junit.Assert.assertEquals;

/**
 * Created by silan on 25.11.2018.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ConverterActivityTest {
    private String mStringToBetyped;

    @Rule
    public ActivityTestRule<ConvertActivity> mActivityRule = new ActivityTestRule<>(
            ConvertActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mStringToBetyped = "5";
    }

    @Test
    public void ConvertActivity_toFahrenheit_Test() {
        onView((withId(R.id.radio_convert_celsius_to_fahrenheit))).perform(click());
        // Type text and then press the button.
        onView(withId(R.id.inputValue))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.buttonToConvert)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.inputValue))
                .check(matches(withText(mStringToBetyped)));

        onView(withId(R.id.outputValue))
                .check(matches(withText("41,00"))); // формат вывода два знака после запятой

    }

    @Test
    public void ConvertActivity_toCelsius_Test() {
        onView((withId(R.id.radio_convert_fahrenheit_to_celsius))).perform(click());
        // Type text and then press the button.
        onView(withId(R.id.inputValue))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.buttonToConvert)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.inputValue))
                .check(matches(withText(mStringToBetyped)));

        onView(withId(R.id.outputValue))
                .check(matches(withText("-15,00"))); // формат вывода два знака после запятой

    }

    @Test
    public void ConvertActivity_toMile_Test() {
        onView((withId(R.id.radio_convert_kilometrs_to_mile))).perform(click());
        // Type text and then press the button.
        onView(withId(R.id.inputValue))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.buttonToConvert)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.inputValue))
                .check(matches(withText(mStringToBetyped)));

        onView(withId(R.id.outputValue))
                .check(matches(withText("3,11"))); // формат вывода два знака после запятой

    }

    @Test
    public void ConvertActivity_toKilometers_Test() {
        onView((withId(R.id.radio_convert_mile_to_kilomenrs))).perform(click());
        // Type text and then press the button.
        onView(withId(R.id.inputValue))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.buttonToConvert)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.inputValue))
                .check(matches(withText(mStringToBetyped)));

        onView(withId(R.id.outputValue))
                .check(matches(withText("8,00"))); // формат вывода два знака после запятой

    }

    @Test
    public void AppContext_Test() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("silantyevmn.ru.developerinterview", appContext.getPackageName());
    }
}
