export class Humidity {
    private idParametro: Number;
    private valor: Number;
    private fecha: Number;
    private Clientes_idClientes: Number;

    constructor(idParametro: Number,Clientes_idClientes: Number,valor: Number, fecha: Number) {
        this.idParametro = idParametro;
        this.valor = valor;
        this.fecha = fecha;
        this.Clientes_idClientes=Clientes_idClientes;
    }
}
