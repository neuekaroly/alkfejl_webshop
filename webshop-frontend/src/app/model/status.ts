enum OrderStatus {
  DRAFT, COMPLETED, PROCESSING
}

enum ShippingStatus {
  NOTYETSHIPPED, SHIPPED, SHIPPINGNOTREQUIRED
}

export class Status {
  orderStatus: OrderStatus;
  shippingStatus: ShippingStatus;
  constructor() {}
}
