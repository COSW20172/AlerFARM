export class User {
    private email:string;
    private password:string;
    private name: string;
    private lastname: string;
    private image: string;

    constructor(email:string,password:string,name: string, lastname: string, image: string) {
        this.email=email;
        this.password=password;
        this.name = name;
        this.lastname = lastname;
        this.image = image;
    }
}