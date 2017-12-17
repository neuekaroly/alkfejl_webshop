import { Injectable } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

export const LOGIN = '/login';
export const REGISTER = '/register';
export const ADDGAME = '/addgame';
export const ADDCATEGORY = '/addcategory';
export const ADDDEVELOPER = '/adddeveloper';

export const MAIN = '';
export const SHOPPINGBASKET = MAIN + '/shoppingbasket';
export const STORE = MAIN + '/store';

@Injectable()
export class RoutingService {

    constructor(private router: Router, private route: ActivatedRoute) { }

    navigate(newRoute: string, data?: any) {

        if (data) {
            this.router.navigate([newRoute, data]);
        }
        else {
            this.router.navigate([newRoute]);
        }
    }

    getUrl(): string {
        return this.router.url;
    }

    getRouter(): Router {
        return this.router;
    }

    getRoute(): ActivatedRoute {
        return this.route;
    }

}
