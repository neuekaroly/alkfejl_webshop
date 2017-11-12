import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
 
import { Observable } from 'rxjs/Observable';

import { User } from '../model/user';

@Injectable()
export class BackendService {

    constructor(private http: Http) {}

    register(user: User): Observable<any> {
        console.log('Registering', user);
        return this.http.post('http://localhost:8080/users/register', user);
    }

}