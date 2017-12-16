import {Developer} from "./developer";
import {Category} from "./category";

export class Game {
    gameName: string;
    releaseDate: string;
    description: string;
    platform: string;
    price: number;
    amount: number;
    rating: number;
    developer: Developer;
    developerId: number;
    categoryIds: number[];
    categories: Category[];
    picture: string;

    constructor() {}
}
