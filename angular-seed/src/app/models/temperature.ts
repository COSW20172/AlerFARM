export class Temperature {
    private id: string;
    private valor: Number;
    private fecha: string;
    private description: string;

    constructor(id: string,valor: Number, fecha: string) {
        this.id = id;
        this.valor = valor;
        this.fecha = fecha;
        this.description="Temperature";
    }
}
