export class Humidity {
    private id: string;
    private valor: Number;
    private fecha: Number;
    private description: string;

    constructor(id:string,valor: Number, fecha: Number) {
        this.id = id;
        this.valor = valor;
        this.fecha = fecha;
        this.description="Humidity";
    }
}
