export class User {
    private email:string;
    private password:string;
    private name: string;
    private idUser: Number;
    private celular: string;

    constructor(email:string,password:string,name: string, idUser: Number, celular: string) {
        this.email=email;
        this.password=password;
        this.name = name;
        this.idUser = idUser;
        this.celular = celular;
    }
}