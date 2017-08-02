import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import { DragScrollModule } from 'angular2-drag-scroll';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MdAutocompleteModule,
  MdButtonModule,
  MdButtonToggleModule,
  MdCardModule,
  MdCheckboxModule,
  MdChipsModule,
  MdCoreModule,
  MdDatepickerModule,
  MdDialogModule,
  MdExpansionModule,
  MdGridListModule,
  MdIconModule,
  MdInputModule,
  MdListModule,
  MdMenuModule,
  MdPaginatorModule,
  MdProgressBarModule,
  MdProgressSpinnerModule,
  MdRadioModule,
  MdRippleModule,
  MdSelectModule,
  MdSidenavModule,
  MdSliderModule,
  MdSlideToggleModule,
  MdSnackBarModule,
  MdSortModule,
  MdTableModule,
  MdTabsModule,
  MdToolbarModule,
  MdTooltipModule
} from '@angular/material';


import {AppComponent} from './app.component';
import {SearchComponent} from './search/search.component';
import {FlexLayoutModule} from '@angular/flex-layout';
import {SearchService} from './search/search.service';
import { AddRobotComponent } from './add-robot/add-robot.component';
import { RobotComponent } from './robot/robot.component';
import {PropertiesService} from './_shared/services/properties.service';
import {AddRobotService} from "./add-robot/add-robot.service";
import { RobotDisplayComponent } from './robot-display/robot-display.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchComponent,
    AddRobotComponent,
    RobotComponent,
    RobotDisplayComponent
  ],
  imports: [
    MdAutocompleteModule,
    MdButtonModule,
    MdButtonToggleModule,
    MdCardModule,
    MdCheckboxModule,
    MdChipsModule,
    MdCoreModule,
    MdDatepickerModule,
    MdDialogModule,
    MdExpansionModule,
    MdGridListModule,
    MdIconModule,
    MdInputModule,
    MdListModule,
    MdMenuModule,
    MdPaginatorModule,
    MdProgressBarModule,
    MdProgressSpinnerModule,
    MdRadioModule,
    MdRippleModule,
    MdSelectModule,
    MdSidenavModule,
    MdSliderModule,
    MdSlideToggleModule,
    MdSnackBarModule,
    MdSortModule,
    MdTableModule,
    MdTabsModule,
    MdToolbarModule,
    MdTooltipModule,
    BrowserModule,
    FormsModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    DragScrollModule,
    HttpModule
  ],
  entryComponents: [AddRobotComponent, RobotComponent],
  providers: [
    SearchService,
    PropertiesService,
    AddRobotService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
