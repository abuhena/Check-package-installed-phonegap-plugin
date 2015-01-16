package com.anonnafrontend;

import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

public class CheckAppInstalledPlugin extends Plugin {
	
	public PluginResult execute(String action, JSONArray args, String callbackId) {
		try {
			PluginResult.Status status = PluginResult.Status.OK;
			Context currentCtx = cordova.getActivity();
			JSONObject result = new JSONObject();
			result.put("installed", appInstalledOrNot(args.getString(0), currentCtx));
			return new PluginResult(status, result.toString());
		} catch (Exception e) {
			
			return new PluginResult(PluginResult.Status.ERROR, "Failed to communicate");
			
		}
	}
	
	private boolean appInstalledOrNot(String uri, Context context) {
		Log.d("DEBUG Plugin", uri);
        PackageManager pm = context.getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }
        catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed ;
    }

}
