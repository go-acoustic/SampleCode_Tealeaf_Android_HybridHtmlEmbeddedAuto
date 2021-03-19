/********************************************************************************************
* Copyright (C) 2016 Acoustic, L.P. All rights reserved.
*
* NOTICE: This file contains material that is confidential and proprietary to
* Acoustic, L.P. and/or other developers. No license is granted under any intellectual or
* industrial property rights of Acoustic, L.P. except as may be provided in an agreement with
* Acoustic, L.P. Any unauthorized copying or distribution of content from this file is
* prohibited.
********************************************************************************************/
package tl.hybridhtmlembeddedauto;

import android.app.Application;
import com.tl.uic.Tealeaf;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
      super.onCreate();
      Tealeaf.enable();
    }
    @Override
    public void onLowMemory() {

      super.onLowMemory();
    }
    @Override
    public void onTerminate() {
     
      super.onTerminate();
    }
}
