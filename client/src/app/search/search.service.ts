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

  public searchByCategory(id) {
    const params = new URLSearchParams();
    params.set('categoryId', id);
    return this._http.get('http://localhost:8080/api/robot/findByCategory', {search: params}).map(res => res.json());
  }

  public placeOrder(id) {
    const params = new URLSearchParams();
    params.set('robotId', id);
    return this._http.post('http://localhost:8080/api/robot/order/place', {}, {search: params}).map(res => res.json());
  }

  public confirmOrder(id) {
    const params = new URLSearchParams();
    params.set('robotId', id);
    return this._http.post('http://localhost:8080/api/robot/order/confirm', {}, {search: params}).map(res => res.json());
  }

  public cancelOrder(id) {
    const params = new URLSearchParams();
    params.set('robotId', id);
    return this._http.post('http://localhost:8080/api/robot/order/cancel', {}, {search: params}).map(res => res.json());
  }

  public deleteRobot(robotId: string) {
    return this._http.delete(`http://localhost:8080/api/robot/${robotId}`);
  }

}
