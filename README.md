PhoneGap Android installed package check plugin
=======================================

It's being easy to check an application installed on device by the associate package name
Just a line 

window.plugins.CheckAppInstalledPlugin.get(function(json){ //success callback }, function(json){ //error callback }, "package name");

# Example:

     window.plugins.CheckAppInstalledPlugin.get(function(data){
        var json_data = Ext.JSON.decode(data);
        if(json_data.installed)
        {
            if(latitude!==null&&longitude!==null)
            {
                window.location = 'geo:'+latitude+','+longitude;
            }else{
                alert('Warning', 'Your current location is unidentified');
            }
        }else{
            alert('Warning', 'Google Maps application has not installed');
        }
    },
    function(err){
        alert('Error', 'Error to open Google Maps');
    }, 'com.google.android.apps.maps');
    
    
Install this plugin:
     cordova plugin add https://github.com/abuhena/Check-package-installed-phonegap-plugin.git
     
