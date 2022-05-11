# SampleCode_Tealeaf_HybridHtmlEmbeddedAuto
HybridHtmlEmbeddedAuto with Tealeaf sdk.

Built with Android Studio 4.0.0, Gradle version 6.1.1 
Support AndroidX, API level 16 to 30. Support Kotlin 1.3.72

# Notes
**DOM Diff** is now supported in **SaaS** only. This application has **DOM Diff** disabled. If you need to test for SaaS system. You will need to change from:

**diffEnabled: false,**

to 

**diffEnabled: true,**

## In the following files:

* defaultNativeDomCaptureConfiguration.js
* defaultNativeDomCaptureGesturesConfigurationHammer1.js
