import {Component, OnInit} from '@angular/core';
import {SearchService} from './search.service';
import {PropertiesService} from '../../_shared/services/properties.service';

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

  }

  onCategoryChange(event) {
    console.log(event);
  }

  onStatusChange(event) {
    if (event.value)
      this.searchService.searchByStatus(event.value).subscribe(result => this.searchResults = result);
    else
      this.searchResults = [];
  }

  onSearchNameChange(event) {
    this.searchService.searchByName(event).subscribe(result => this.searchResults = result);
  }

  delete(robotId) {
    this.searchService.deleteRobot(robotId).subscribe(() =>
      this.searchResults.splice(this.searchResults.findIndex(r => r.id === robotId), 1));
  }

}
