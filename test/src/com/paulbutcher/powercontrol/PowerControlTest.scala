package com.paulbutcher.powercontrol

import android.content.{Context, ContextWrapper, Intent}
import android.os.PowerManager
import android.test.ActivityUnitTestCase
import android.test.mock.MockContext
import android.util.Log

import com.borachio.junit3.MockFactory

class PowerControlTest
  extends ActivityUnitTestCase[PowerControl](classOf[PowerControl]) 
  with MockFactory {
    
  val startIntent = new Intent(Intent.ACTION_MAIN)
    
  override def setUp() {
    super.setUp
    resetExpectations
  }
  
  override def tearDown() {
    verifyExpectations
    super.tearDown
  }
  
  def testAttempt1 {
    val mockContext = new MockContext;
    setActivityContext(mockContext)
    startActivity(startIntent, null, null)
  }
    
  def testAttempt2 {
    val testContext = new ContextWrapper(getInstrumentation.getTargetContext);
    setActivityContext(testContext)
    startActivity(startIntent, null, null)
  }
  
  def testAttempt3 {
    val mockPowerManager = mock[PowerManager]
    val testContext = new ContextWrapper(getInstrumentation.getTargetContext) {
      override def getSystemService(name: String) = name match {
        case "power" => mockPowerManager
        case _ => super.getSystemService(name)
      }
    }
    setActivityContext(testContext)
    startActivity(startIntent, null, null)
  }
  
  // def testAttempt4 {
  //   val mockNewWakeLock = mockFunction[Int, String, PowerManager#WakeLock]
  //   val mockPowerManager = new PowerManager {
  //     override def newWakeLock(flags: Int, tag: String) = mockNewWakeLock(flags, tag)
  //   }
  //   val testContext = new ContextWrapper(getInstrumentation.getTargetContext) {
  //     override def getSystemService(name: String) = name match {
  //       case "power" => mockPowerManager
  //       case _ => super.getSystemService(name)
  //     }
  //   }
  //   setActivityContext(testContext)
  //   startActivity(startIntent, null, null)
  // }
}
