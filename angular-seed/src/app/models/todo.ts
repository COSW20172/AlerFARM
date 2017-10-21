export class Todo {
    private clientes_idClientes: string;
    private priority: Number;
    private completed: boolean;

    constructor(clientes_idClientes: string, priority: Number = 1, completed: boolean = false) {
        this.clientes_idClientes = clientes_idClientes;
        this.completed = completed;
        this.priority = priority;
    }
}
