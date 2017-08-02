import { Component, OnInit } from '@angular/core';
import {MdDialogRef} from '@angular/material';
import {AddRobotService} from "./add-robot.service";

@Component({
  selector: 'app-add-robot',
  templateUrl: './add-robot.component.html',
  styleUrls: ['./add-robot.component.css']
})
export class AddRobotComponent implements OnInit {

  robot: any = {};

  constructor(public dialogRef: MdDialogRef<AddRobotComponent>, private addRobotService: AddRobotService) { }

  ngOnInit() {
  }

  addRobot() {
    console.log(this.robot);
    this.addRobotService.addRobot(this.robot).subscribe(() => this.dialogRef.close());
  }

  close() {
    this.dialogRef.close()
  }

}
