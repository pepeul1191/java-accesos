## Boilerplate Spark-Velocity-Hibernate

Requisitos de software previamente instalado:

	+ Java 1.8
	+ Apache Maven
	+ NodeJS - NPM - Gulp

Instalación de dependencias:

	$  mvn eclipse:eclipse && mvn install && npm install && bower install 

### Generar 'dist'
	
	$ gulp layout && gulp app && gulp error-css
	
### Rutas

+ GET /estado_usuario/listar ->EstadoUsuarioHandler#listar
- GET /item/listar/menu ->Controller_Item#menu
- GET /item/listar_todos ->Controller_Item#listar_todos
+ GET /item/listar/@subtitulo_id ->Controller_Item#listar
- POST /item/guardar ->Controller_Item#guardar
+ GET /modulo/listar/@sistema_id ->Controller_Modulo#listar
- GET /modulo/listar_menu ->Controller_Modulo#listar_menu
- POST /modulo/guardar ->Controller_Modulo#guardar
+ GET /subtitulo/listar/@modulo_id ->Controller_Subtitulo#listar
- POST /subtitulo/guardar ->Controller_Subtitulo#guardar
- GET /permiso/listar/@sistema_id ->Controller_Permiso#listar
- GET /permiso/listar_asociados/@sistema_id/@rol_id ->Controller_Permiso#listar_asociados
- POST /permiso/guardar ->Controller_Permiso#guardar
- GET /rol/listar/@sistema_id ->Controller_Rol#listar
- POST /rol/guardar ->Controller_Rol#guardar
- POST /rol/ascociar_permisos ->Controller_Rol#ascociar_permisos
- GET /sistema/listar ->Controller_Sistema#listar
- POST /sistema/guardar ->Controller_Sistema#guardar
- GET /usuario/listar ->Controller_Usuario#listar
- GET /usuario/listar_accesos/@usuario_id ->Controller_Usuario#listar_accesos
- GET /usuario/listar_permisos/@usuario_id ->Controller_Usuario#listar_permisos
- GET /usuario/listar_roles/@usuario_id ->Controller_Usuario#listar_roles
- POST /usuario/asociar_permisos ->Controller_Usuario#asociar_permisos
- POST /usuario/asociar_roles ->Controller_Usuario#asociar_roles
- POST /usuario/validar ->Controller_Usuario#validar

### Fuentes externas:

+ persistence.xml MAKIGAS -> https://gist.github.com/danirod/7b23abcd5157bd47f422e2042f86e903
+ persistence.xml SQLITE -> https://gist.github.com/etissieres/5796622 

### TODO

+ En las peticiones REST a métodos que usan ORMLite, manejar que en caso del catch devuelva el mensaje.

---

 Thanks/Credits

    Pepe Valdivia: developer Software Web Perú [http://softweb.pe]