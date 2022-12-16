import { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  "appId": "io.ionic.starter",
  "appName": "Ionic Starter",
  "bundledWebRuntime": false,
  "webDir": "www",
  "plugins": {
    "SplashScreen": {
        "androidScaleType": "CENTER_CROP",
        "backgroundColor": "#00000000",
        "showSpinner": false,
        "launchAutoHide": false,
        "splashImmersive": true,
    },
    "Keyboard": {
        "resizeOnFullScreen": false,
    }
  },
  "cordova": {}
}
export default config;
