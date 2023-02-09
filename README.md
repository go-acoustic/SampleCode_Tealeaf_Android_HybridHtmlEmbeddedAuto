# SampleCode_Tealeaf_HybridHtmlEmbeddedAuto
HybridHtmlEmbeddedAuto with Tealeaf sdk.

Built with Android Studio Electric Eel, Gradle version 7.5.1
Support AndroidX, API level 21 to 33.

# Notes
**DOM Diff** is now supported in **SaaS** only. This application has **DOM Diff** disabled. If you need to test for SaaS system. You will need to change from:

**diffEnabled: false,**

to 

**diffEnabled: true,**

## In the following files:

* defaultNativeDomCaptureConfiguration.js
* defaultNativeDomCaptureGesturesConfigurationHammer1.js
