export class UsuarioInternoModel {
    constructor(
        public id: String,
        public nombre: String,
        public apellidos: String,
        public correoCorporativo: String,
        public departamento: String,
        public sueldo: Number,
    ){}
}