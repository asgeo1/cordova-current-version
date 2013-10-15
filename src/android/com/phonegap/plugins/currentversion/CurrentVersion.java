package com.phonegap.plugins.currentversion;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 * Returns the version number of the application
 */
public class CurrentVersion extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getVersion")) {
            Context context = this.cordova.getActivity().getApplicationContext();
            String versionName = null;

            try {
                versionName = "" + context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (NameNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if(versionName != null)
                callbackContext.success(versionName);
            else
                callbackContext.error("Could not retrieve version");

            return true;
        }

        return false;
    }
}
