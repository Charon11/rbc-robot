import {Component, OnInit} from '@angular/core';
import {SearchService} from './search.service';
import {PropertiesService} from '../_shared/services/properties.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  categories: any[];
  statusList: string[];
  searchResults: any[] = [];

  constructor(private searchService: SearchService, private propertiesService: PropertiesService) {
  }

  ngOnInit() {
    this.propertiesService.getCategories().subscribe(categories => this.categories = categories);
    this.propertiesService.getStatus().subscribe(status => this.statusList = status);
    this.searchByStatus('available')
  }

  onCategoryChange(event) {
    if (event.value)
      this.searchByCategory(event.value.id);
    else
      this.searchResults = [];
  }

  searchByCategory(categoryId){
    this.searchService.searchByCategory(categoryId).subscribe(result => this.searchResults = this.matchCategories(result));
  }

  onStatusChange(event) {
    if (event.value)
      this.searchByStatus(event.value);
    else
      this.searchResults = [];
  }

  searchByStatus(status) {
    this.searchService.searchByStatus(status).subscribe(result => this.searchResults = this.matchCategories(result));
  }

  onSearchNameChange(event) {
    this.searchByName(event);
  }

  searchByName(name) {
    this.searchService.searchByName(name).subscribe(result => this.searchResults = this.matchCategories(result));
  }

  delete(robotId) {
    this.searchService.deleteRobot(robotId).subscribe(() =>
      this.searchResults.splice(this.searchResults.findIndex(r => r.id === robotId), 1));
  }

  placeOrder(robotId) {
    this.searchService.placeOrder(robotId).subscribe(res =>
      this.searchResults[this.searchResults.findIndex(r => r.id === robotId)] = this.matchCategory(res));
  }

  confirmOrder(robotId) {
    this.searchService.confirmOrder(robotId).subscribe(res =>
      this.searchResults[this.searchResults.findIndex(r => r.id === robotId)] = this.matchCategory(res));
  }

  cancelOrder(robotId) {
    this.searchService.cancelOrder(robotId).subscribe(res =>
      this.searchResults[this.searchResults.findIndex(r => r.id === robotId)] = this.matchCategory(res));
  }

  matchCategories(robots: any[]): any[] {
    return robots.map(robot => {
      return this.matchCategory(robot);
    });
  }

  matchCategory(robot: any): any {
    robot.category = this.categories[this.categories.findIndex(c => c.id === robot.category.id)];
    return robot;
  }
}
