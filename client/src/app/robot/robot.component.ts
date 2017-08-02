import {Component, Input, OnInit} from '@angular/core';
import {PropertiesService} from '../_shared/services/properties.service';

@Component({
  selector: 'app-robot',
  templateUrl: './robot.component.html',
  styleUrls: ['./robot.component.css']
})
export class RobotComponent implements OnInit {

  @Input() robot: any;
  categories: any[];
  statusList: string[];

  constructor(private propertiesService: PropertiesService) { }

  ngOnInit() {
    this.propertiesService.getCategories().subscribe(categories => this.categories = categories);
    this.propertiesService.getStatus().subscribe(status => this.statusList = status);

  }
}
