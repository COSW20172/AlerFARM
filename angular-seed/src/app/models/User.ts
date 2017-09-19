export class User {
    private username:string;
    private password:string;
    private name: string;
    private lastname: string;
    private image: string;

    constructor(username:string,password:string,name: string, lastname: string, image: string) {
        this.username=username;
        this.password=password;
        this.name = name;
        this.lastname = lastname;
        this.image = image;
    }
}