package com.example.customdialog;

import android.content.Context;

import androidx.test.core.app.ActivityScenario;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;


import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void customDialogTest() {
//        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.customdialog", appContext.getPackageName());

        // GIVEN
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
        String NAME = "Test message";

        // Execute and Verify
        onView(withId(R.id.btn)).perform(click());
        onView(withText("Rename Token")).check(matches(isDisplayed()));
        onView(withText("Enter a unique name for your token")).check(matches(isDisplayed()));
        onView(withText("Save")).perform(click());
        onView(withText("Cancel")).perform(click());

        // make sure dialog is still visible (can't click ok without entering a name)
        onView(withText("Test message")).check(matches(isDisplayed()));

        // enter a name
        onView(withId(R.id.nameEditText)).perform(typeText(NAME));
        onView(withText("Save")).perform(click());

        // make sure dialog is gone
        onView(withText("Rename Token")).check(doesNotExist());
        onView(withText("Enter a unique name for your token")).check(doesNotExist());
        onView(withId(R.id.txt)).check(matches(withText(NAME)));
    }

}