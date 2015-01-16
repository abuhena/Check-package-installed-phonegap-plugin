function CheckAppInstalledPlugin()
{
}
CheckAppInstalledPlugin.prototype.get = function(success, fail, package) {
	cordova.exec(success, fail, "CheckAppInstalledPlugin", "get", [package]);
};

cordova.addConstructor(function()  {
        if(!window.plugins) {
           window.plugins = {};
        }

   // shim to work in 1.5 and 1.6
   if (!window.Cordova) {
           window.Cordova = cordova;
   };

   window.plugins.CheckAppInstalledPlugin = new CheckAppInstalledPlugin();
});
