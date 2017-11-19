import { Category } from '../model/category';

export class Game {
    gameName: string;
    releaseDate: string;
    descriptipn: string;
    platform: string;
    price: number;
    amount: number;
    rating: number;
    developer: string;
    categories: Category[];
}