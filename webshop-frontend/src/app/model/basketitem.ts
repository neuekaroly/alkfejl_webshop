export class BasketItem {
    gamename: string;
    price: number;
    platform: string;
    quantity: number;

    constructor(gamename: string, price:number, platform: string, quantity: number){
        this.gamename = gamename;
        this.price = price;
        this.platform = platform;
        this.quantity = quantity;
    }
}
