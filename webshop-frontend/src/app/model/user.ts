enum Role {
  GUEST, USER, ADMIN
}

export class User {
    username: string;
    password: string;
    firstname: string;
    lastname: string;
    emailaddress: string;
    address: string;
    role: Role;

    constructor() {}
}
