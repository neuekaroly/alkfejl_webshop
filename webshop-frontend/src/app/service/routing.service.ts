import { Injectable } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

export const LOGIN = '/login';
export const REGISTER = '/register';

export const MAIN = '';
export const SHOPPINGBASKET = MAIN + '/shoppingbasket';

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