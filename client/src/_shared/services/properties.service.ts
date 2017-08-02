import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Http} from '@angular/http';
import 'rxjs/add/operator/shareReplay';
@Injectable()
export class PropertiesService {

  categoriesObs: Observable<any[]>;
  statusObs: Observable<string[]>;

  constructor(private _http: Http) { }

  public getCategories(): Observable<any[]> {
    return this.categoriesObs = this.categoriesObs ||
      this._http.get(`http://localhost:8080/api/categories`).map(res => res.json()).shareReplay(1);
  }

  public getStatus(): Observable<string[]> {
    return this.statusObs = this.statusObs ||
      this._http.get(`http://localhost:8080/api/status`).map(res => res.json()).shareReplay(1);
  }

}
