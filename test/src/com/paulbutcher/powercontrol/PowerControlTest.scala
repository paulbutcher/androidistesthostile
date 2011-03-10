package com.paulbutcher.powercontrol

import android.test.ActivityInstrumentationTestCase2

class PowerControlTest extends 
  ActivityInstrumentationTestCase2[PowerControl]("com.paulbutcher.powercontrol", classOf[PowerControl]) {
    
  def testStartImportant() {
      getActivity().startImportant(null)
  }
}
