export class Temperature {
    private idParametro: Number;
    private Clientes_idClientes: Number;
    private valor: Number;
    private fecha: Number;
    private Arduino_idArduino: Number;

    constructor(idParametro:Number,Clientes_idClientes:Number,valor: Number, fecha: Number,Arduino_idArduino: Number) {
        this.idParametro = idParametro;
        this.Clientes_idClientes = Clientes_idClientes;
        this.valor = valor;
        this.fecha = fecha;
        this.Arduino_idArduino = 1;
    }
}
