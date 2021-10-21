import { Injectable } from '@angular/core';
import { TipoUsuario} from '../model.tipousuario';
import { UsuarioExternoModel} from '../model/UsuarioExternoModel';
import { UsuarioInternoModel } from '../model/UsuarioInternoModel';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private host ="http://localhost:9021";

  private urlUsuarioInterno ="/api/ms/users/tipo/v1/USUARIO_INTERNO";
  private urlUsuarioExterno="/api/ms/users/tipo/v1/USUARIO_EXTERNO";

  private tiposDeUsuario : TipoUsuario[] = [
    { tipo : 'USUARIO_INTERNO', descripcion : 'INTERNO'},
    { tipo : 'USUARIO_EXTERNO', descripcion : 'EXTERNO'}
  ]

  obtenerTipoUsuario(): TipoUsuario[]{
    return this.tiposDeUsuario;
  }


  obtenerListadoUsuariosExternos(){
   return this.http.get<UsuarioExternoModel[]>(this.host.concat(this.urlUsuarioExterno));
  } 
  
  obtenerListadoUsuariosInternos(){
    return this.http.get<UsuarioInternoModel[]>(this.host.concat(this.urlUsuarioInterno));
   } 
   


  constructor (private http:HttpClient){}

}
