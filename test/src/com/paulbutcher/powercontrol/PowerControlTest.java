package com.paulbutcher.powercontrol;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.paulbutcher.powercontrol.PowerControlTest \
 * com.paulbutcher.powercontrol.tests/android.test.InstrumentationTestRunner
 */
public class PowerControlTest extends ActivityInstrumentationTestCase2<PowerControl> {

    public PowerControlTest() {
        super("com.paulbutcher.powercontrol", PowerControl.class);
    }

}
