import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


// import { AppComponent } from './app.component';
import {HelloComponent} from './app.component';

@NgModule({
  declarations: [
    // AppComponent
    HelloComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  // bootstrap: [AppComponent]
})
export class AppModule { }
