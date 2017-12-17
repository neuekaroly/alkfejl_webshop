export class BasketItem {
    gameid: number;
    gamename: string;
    price: number;
    platform: string;
    quantity: number;

    constructor(gamename: string, price:number, platform: string, quantity: number, gameid: number){
        this.gamename = gamename;
        this.price = price;
        this.platform = platform;
        this.quantity = quantity;
        this.gameid = gameid;
    }
}
