import { Component } from '@angular/core';
import {MdDialog, MdDialogRef} from '@angular/material';
import {AddRobotComponent} from './add-robot/add-robot.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(public dialog: MdDialog){

  }

  openDialog() {
    const dialogRef = this.dialog.open(AddRobotComponent);
    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
    });
  }
}
