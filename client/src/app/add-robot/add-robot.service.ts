import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class AddRobotService {

  constructor(private _http: Http) { }

  public addRobot(robot: any): Observable<any> {
    return this._http.post('http://localhost:8080/api/robot', robot).map(res => res.json());
  }

}
