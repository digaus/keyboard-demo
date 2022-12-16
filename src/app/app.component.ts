import { Component, OnInit } from '@angular/core';
import { StatusBar } from '@capacitor/status-bar';
import { Platform } from '@ionic/angular';
import { SafeArea } from 'capacitor-plugin-safe-area';

@Component({
    selector: 'app-root',
    templateUrl: 'app.component.html',
    styleUrls: ['app.component.scss'],
})
export class AppComponent {
    constructor(
        private platform: Platform,
    ) {
        if (this.platform.is('android')) {
            StatusBar.setOverlaysWebView({ overlay: true });
            SafeArea.getSafeAreaInsets().then(({ insets }) => {
                console.log(insets);
                const style = document.documentElement.style;
                style.setProperty('--ion-safe-area-top', `${insets.top}px`);
                style.setProperty('--ion-safe-area-bottom', `${insets.bottom}px`);
            });
        }
    }

}
