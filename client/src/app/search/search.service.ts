import {Injectable} from '@angular/core';
import {Http, URLSearchParams} from '@angular/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class SearchService {

  constructor(private _http: Http) {
  }

  public searchByStatus(status: string): Observable<any> {
    const params = new URLSearchParams();
    params.set('status', status);
    return this._http.get('http://localhost:8080/api/robot/findByStatus', {search: params}).map(res => res.json());
  }

  public searchByName(name: string): Observable<any> {
    const params = new URLSearchParams();
    params.set('name', name);
    return this._http.get('http://localhost:8080/api/robot/findByName', {search: params}).map(res => res.json());
  }

  public deleteRobot(robotId: string) {
    return this._http.delete(`http://localhost:8080/api/robot/${robotId}`);
  }

}
