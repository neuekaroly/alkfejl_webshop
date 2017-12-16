import {isNegativeNumberLiteral} from "tslint";

export class Filter {
  searchTag: string;
  priceTag: number;
  categories: Array<number>;
  platforms: Array<number>;

  constructor() {
    this.searchTag = '';
    this.priceTag = -1;
    this.categories = new Array<number>();
    this.platforms = new Array<number>();
  }
}
