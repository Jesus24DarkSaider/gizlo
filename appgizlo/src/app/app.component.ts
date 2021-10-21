import { Component, OnInit } from '@angular/core';
import { ITS_JUST_ANGULAR } from '@angular/core/src/r3_symbols';
import { TipoUsuario } from './model.tipousuario';
import { UsuarioExternoModel} from './model/UsuarioExternoModel';
import { UsuarioInternoModel } from './model/UsuarioInternoModel';
import { ModeloGenerico } from './model/ModeloGenerico';
import { UsuarioService } from './service/usuario.service';
import { ColumnaModel } from './model/ColumasModel';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[UsuarioService]
})
export class AppComponent implements OnInit { 
  title = 'appgizlo';
  public tiposUser: TipoUsuario[] = [];
  public valor:String = '';
  public userExter = "USUARIO_EXTERNO";
  public userInter ="USUARIO_INTERNO";
  public listadoUsuariosExternos: UsuarioExternoModel[] = [];
  public listadoUsuariosInternos: UsuarioInternoModel[] = [];
  public tipoUsuarioSeleccionado :TipoUsuario = {tipo:'',descripcion:''}
  
  // CAMPOS GENERICOS
  public nombreColumnas: ColumnaModel = {
    nombreColumnaUno: 'Nombre', nombreColumnaDos: 'Apellidos',
    nombreColumnaTres: 'Correo Personal', nombreColumnaCuatro: 'Ciudad',
    nombreColumnaCinco: 'Edad', nombreColumnaSeis: ''
  }



  public modeloGenerico: ModeloGenerico[] = [];
  public maping: ModeloGenerico = {
    atributoUno: '', atributoDos: '', atributoTres: ''
    , atributoCuatro: '', atributoCinco: '', atributoSeis: 0
  };

  constructor(private service: UsuarioService) {
    console.log(this.service.obtenerTipoUsuario());
    this.tiposUser = this.service.obtenerTipoUsuario();
  }

  ngOnInit(): void {
    this.tiposUser = this.service.obtenerTipoUsuario();

    this.service.obtenerListadoUsuariosExternos().subscribe(data => {
      this.listadoUsuariosExternos = data;
      // MAPEAMOS LOS DATOS QUE TRAE EL SERVICIO
      for (let index in this.listadoUsuariosExternos) {
        this.maping = {
          atributoUno: '', atributoDos: '', atributoTres: ''
          , atributoCuatro: '', atributoCinco: '', atributoSeis: 0
        };
        this.maping.atributoUno = this.listadoUsuariosExternos[index].nombre;
        this.maping.atributoDos = this.listadoUsuariosExternos[index].apellidos;
        this.maping.atributoTres = this.listadoUsuariosExternos[index].correoPersonal;
        this.maping.atributoCuatro = this.listadoUsuariosExternos[index].apellidos;
        this.maping.atributoSeis = this.listadoUsuariosExternos[index].edad;
        this.modeloGenerico.push(this.maping);
      }
    });

  }

  onSeleccionarCombo(event: any): void {

    this.modeloGenerico = []
    this.valor = JSON.stringify(event.target.value);
    console.log(JSON.stringify(event.target.value));

    //VALIDAMOS QUE SE SELECCIONE EL ITEM USUARIO EXTERNO
    if (this.valor == JSON.stringify(this.userExter)) {

      // HACEMOS EL CONSUMO DEL SERVICIO
      this.service.obtenerListadoUsuariosExternos().subscribe(data => {
        this.listadoUsuariosExternos = data;

        // SETEAMOS EL NOMBRE DE LAS COLUMNAS EN LA TABLA
        this.nombreColumnas.nombreColumnaUno = 'Nombre';
        this.nombreColumnas.nombreColumnaDos = 'Apellidos';
        this.nombreColumnas.nombreColumnaTres = 'Correo Personal';
        this.nombreColumnas.nombreColumnaCuatro = 'Ciudad';
        this.nombreColumnas.nombreColumnaCinco = 'Edad';

        // MAPEAMOS LOS DATOS QUE TRAE EL SERVICIO
        for (let index in this.listadoUsuariosExternos) {

          this.maping = {
            atributoUno: '', atributoDos: '', atributoTres: ''
            , atributoCuatro: '', atributoCinco: '', atributoSeis: 0
          };
          this.maping.atributoUno = this.listadoUsuariosExternos[index].nombre;
          this.maping.atributoDos = this.listadoUsuariosExternos[index].apellidos;
          this.maping.atributoTres = this.listadoUsuariosExternos[index].correoPersonal;
          this.maping.atributoCuatro = this.listadoUsuariosExternos[index].ciudad;
          this.maping.atributoSeis = this.listadoUsuariosExternos[index].edad;
          this.modeloGenerico.push(this.maping);
        }
        console.log(this.modeloGenerico);
      });


    }

    // VALIDAMOS QUE SE SELECCIONE EL ITEM USUARO INTERNO
    if (this.valor == JSON.stringify(this.userInter)) {
      // HACEMOS CONSUMO DEL SERVICIO
      this.service.obtenerListadoUsuariosInternos().subscribe(data => {
        this.listadoUsuariosInternos = data;

        for (let index in this.listadoUsuariosInternos) {
          this.maping = {
            atributoUno: '', atributoDos: '', atributoTres: ''
            , atributoCuatro: '', atributoCinco: '', atributoSeis: 0
          };
          this.maping.atributoUno = this.listadoUsuariosInternos[index].nombre;
          this.maping.atributoDos = this.listadoUsuariosInternos[index].apellidos;
          this.maping.atributoTres = this.listadoUsuariosInternos[index].correoCorporativo;
          this.maping.atributoCuatro = this.listadoUsuariosInternos[index].departamento;
          this.maping.atributoSeis = this.listadoUsuariosInternos[index].sueldo;
          this.modeloGenerico.push(this.maping);
        }
        // SETEAMOS EL NOMBRE DE LAS COLUMNAS A MOSTRAR EN LA TABLA
        this.nombreColumnas.nombreColumnaUno = 'Nombre';
        this.nombreColumnas.nombreColumnaDos = 'Apellidos';
        this.nombreColumnas.nombreColumnaTres = 'Correo Corporativo';
        this.nombreColumnas.nombreColumnaCuatro = 'Departamento';
        this.nombreColumnas.nombreColumnaCinco = 'Sueldo';
        console.log(this.modeloGenerico);
      });

         
     }
  }
}
