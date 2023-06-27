package banco.main;

import java.util.ArrayList; 
import java.util.List;
import java.util.Scanner;

import banco.modelos.Gestor;
import banco.modelos.Cliente;
import banco.util.Utiles;
import banco.modelos.Mensaje;
import banco.modelos.Transferencia;

public class ConsolaBanco {

	private List<Gestor> gestores;
	private Integer siguienteIdGestor;
	private List<Cliente> clientes;
	private Integer siguienteidCliente;
	private List<Mensaje> mensajes;
	private Integer siguienteidMensaje;
	private Integer idOrigen;
	private List<Transferencia> transferencias;
	private Integer siguienteidTransferencia;
	private Scanner teclado;

	ConsolaBanco() {
		this.gestores = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.mensajes = new ArrayList<>();
		this.transferencias = new ArrayList<>();
		this.siguienteIdGestor = 1;
		this.siguienteidCliente = 1;
		this.siguienteidMensaje = 1;
		this.idOrigen = (int) (Math.random()*10);
		this.siguienteidTransferencia = 1;
		this.teclado = new Scanner(System.in);
	}

	private void mostrarMenu() {
		System.out.println("\n1. Insertar gestor");
		System.out.println("2. Insertar gestores de prueba");
		System.out.println("3. Consultar gestor");
		System.out.println("4. Ver todos los gestores");
		System.out.println("5. Actualizar gestor");
		System.out.println("6. Eliminar un gestor");
		System.out.println("7. Insertar cliente");
		System.out.println("8. Consultar cliente");
		System.out.println("9. Obtencion de todos los clientes");
		System.out.println("10. Actualizacion clientes");
		System.out.println("11. Eliminar un cliente");
		System.out.println("12. Obtencion de un mensaje");
		System.out.println("13. Obtencion de todos los mensajes");
		System.out.println("14. Envio de un mensaje");
		System.out.println("15. Obtencion de transferencia");
		System.out.println("16. Obtencion de todas las transferencias");
		System.out.println("17. Envio de transferencia");
		System.out.println("18. Login");
		System.out.println("0. Salir\n");
	}

	private void insertarGestor() {
		System.out.print("Nombre: ");
		String nombre = teclado.next();
		System.out.print("Email: ");
		String email = teclado.next();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		System.out.print("Oficina: ");
		String oficina = teclado.next();
		Gestor nuevoGestor = new Gestor(siguienteIdGestor, nombre, pass, email, oficina);
		gestores.add(nuevoGestor);
		siguienteIdGestor++;
		System.out.println("Gestor creado con éxito.");
	}

	private void insertarGestoresDePrueba() {
		System.out.print("Número de gestores: ");
		int numeroGestores = teclado.nextInt();
		for (int i = 0; i < numeroGestores; i++) {
			String usuario = Utiles.nombreAleatorio();
			String correo = Utiles.correoAleatorio();
			Gestor gestor = new Gestor(siguienteIdGestor, usuario, "", correo, "Valencia");
			gestores.add(gestor);
			siguienteIdGestor++;
		}
	}

	private void consultarGestor() {
		System.out.print("Id del gestor a consultar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = buscarGestorPorId(idGestor);
		// si se ha encontrado
		if (gestorResultado != null) {
			System.out.println(gestorResultado);
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
		}
	}

	private Gestor buscarGestorPorId(int id) {
		Gestor gestorResultado = null;
		for (int i = 0; i < gestores.size(); i++) {
			Gestor gestor = gestores.get(i);
			if (gestor.getId() == id) {
				gestorResultado = gestor;
	
				// como ya lo hemos encontrado, rompemos el bucle
				return gestorResultado;
			}
		}
		return null;
	}
	
	private Cliente buscarClientePorId(int id) {
		Cliente clienteResultado = null;
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getId() == id) {
				clienteResultado = cliente;
				// como ya lo hemos encontrado, rompemos el bucle
				return clienteResultado;
			}
		}
		return null;
	}
	private Mensaje buscarMensajePorId(int id) {
		Mensaje mensajeResultado = null;
		for (int i = 0; i < mensajes.size(); i++) {
			Mensaje mensaje = mensajes.get(i);
			if (mensaje.getId() == id) {
				mensajeResultado = mensaje;
				// como ya lo hemos encontrado, rompemos el bucle
				return mensajeResultado;
			}
		}
		return null;
	}
	private Transferencia buscarTransferenciaPorId(int id) {
		Transferencia transferenciaResultado = null;
		for (int i = 0; i < transferencias.size(); i++) {
			Transferencia transferencia = transferencias.get(i);
			if (transferencia.getId() == id) {
				transferenciaResultado = transferencia;
				// como ya lo hemos encontrado, rompemos el bucle
				return transferenciaResultado;
			}
		}
		return null;
	}
	private void verTodosGestores() {
		if (gestores.isEmpty()) {
			System.out.println("Todavía no hay gestores.");
		}
		gestores.forEach(gestor -> {
			System.out.println(gestor);
		});
	}

	private void actualizarGestor() {
		System.out.print("Id del gestor a actualizar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = buscarGestorPorId(idGestor);
		// si se ha encontrado
		if (gestorResultado != null) {
			System.out.println(gestorResultado);
			System.out.println("[n] Nombre");
			System.out.println("[e] Email");
			System.out.println("[c] Contraseña");
			System.out.println("[o] Oficina");
			System.out.println("[x] Cancelar");
			System.out.print("Campo a actualizar: ");
			char opcionActualizar = teclado.next().charAt(0);
			switch (opcionActualizar) {
			case 'n':
				System.out.print("Nombre: ");
				String nombre = teclado.next();
				gestorResultado.setUsuario(nombre);
				break;
			case 'e':
				System.out.print("Email: ");
				String email = teclado.next();
				gestorResultado.setCorreo(email);
				break;
			case 'c':
				System.out.print("Contraseña: ");
				String pass = teclado.next();
				gestorResultado.setPassword(pass);
				break;
			case 'o':
				System.out.print("Oficina: ");
				String oficina = teclado.next();
				gestorResultado.setOficina(oficina);
				break;
			case 'x':
				System.out.print("Cancelando actualización...");
				break;
			default:
				System.out.println("Opción no válida.");
			}
			if (opcionActualizar != 'x') {
				System.out.println("Se actualizó el gestor con el id " + idGestor);
			}
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
		}
	}

	private void eliminarGestor() {
		System.out.print("Id del gestor a eliminar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = buscarGestorPorId(idGestor);
		int posicionGestor = -1;
		// si se ha encontrado
		if (gestorResultado != null) {
			gestores.remove(posicionGestor);
			System.out.println("Se eliminó el gestor con el id " + idGestor);
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
		}
	}
	private void insertarCliente() {
		System.out.print("Nombre: ");
		String nombre = teclado.next();
		System.out.print("Email: ");
		String email = teclado.next();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		double saldo = 0.00;
		Integer gestorPredeterminado = 1;
		Cliente nuevoCliente = new Cliente(siguienteidCliente, nombre, pass, email, saldo, gestorPredeterminado);
		clientes.add(nuevoCliente);
		siguienteidCliente++;
		System.out.println("Cliente creado con éxito.");
	}
	
	private void consultarCliente() {
		System.out.print("Id del cliente a consultar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = buscarClientePorId(idCliente);
		// si se ha encontrado
		if (clienteResultado != null) {
			System.out.println(clienteResultado);
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idCliente);
		}
	}
	private void obtenerTodosClientes() {
		if (clientes.isEmpty()) {
			System.out.println("Todavía no hay clientes.");
		}
		clientes.forEach(cliente -> {
			System.out.println(cliente);
		});
	}
	
	private void actualizarClientes() {
		System.out.print("Id del cliente a actualizar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = buscarClientePorId(idCliente);
		// si se ha encontrado
		if (clienteResultado != null) {
			System.out.println(clienteResultado);
			System.out.println("[n] Nombre");
			System.out.println("[e] Email");
			System.out.println("[c] Contraseña");
			System.out.println("[o] Gestor");
			System.out.println("[x] Cancelar");
			System.out.print("Campo a actualizar: ");
			char opcionActualizar = teclado.next().charAt(0);
			switch (opcionActualizar) {
			case 'n':
				System.out.print("Nombre: ");
				String nombre = teclado.next();
				clienteResultado.setUsuario(nombre);
				break;
			case 'e':
				System.out.print("Email: ");
				String email = teclado.next();
				clienteResultado.setCorreo(email);
				break;
			case 'c':
				System.out.print("Contraseña: ");
				String pass = teclado.next();
				clienteResultado.setPassword(pass);
				break;
			case 'o':
				System.out.print("Gestor: ");
				Integer idGestor = teclado.nextInt();
				clienteResultado.setIdGestor(idGestor);
				break;
			case 'x':
				System.out.print("Cancelando actualización...");
				break;
			default:
				System.out.println("Opción no válida.");
			}
			if (opcionActualizar != 'x') {
				System.out.println("Se actualizó el cliente con el id " + idCliente);
			}
		} else {
			System.out.println("No se pudo encontrar un cliente con el id " + idCliente);
		}
	}
	private void eliminarCliente() {
		System.out.print("Id del cliente a eliminar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = buscarClientePorId(idCliente);
		int posicionCliente = -1;
		// si se ha encontrado
		if (clienteResultado != null) {
			gestores.remove(posicionCliente);
			System.out.println("Se eliminó el gestor con el id " + idCliente);
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idCliente);
		}
	}
	private void envioMensaje() {
		System.out.print("ID Destinatario: ");
		Integer idDestino = teclado.nextInt();
		teclado.nextLine();
		System.out.print("Texto: ");
		String texto = teclado.nextLine();
		Mensaje nuevoMensaje = new Mensaje(siguienteidMensaje, idOrigen, idDestino, texto);
		mensajes.add(nuevoMensaje);
		siguienteidMensaje++;
		System.out.println("Mensaje enviado con exito.");
	}
	private void obtenerMensaje() {
		System.out.print("Id del mensaje a consultar: ");
		int idMensaje = teclado.nextInt();
		Mensaje mensajeResultado = buscarMensajePorId(idMensaje);
		// si se ha encontrado
		if (mensajeResultado != null) {
			System.out.println(mensajeResultado);
		} else {
			System.out.println("No se pudo encontrar un mensaje con el id " + idMensaje);
		}
	}
	
	private void obtenerTodosMensajes() {
		if (mensajes.isEmpty()) {
			System.out.println("Todavía no hay mensajes.");
		}
		mensajes.forEach(mensaje -> {
			System.out.println(mensaje);
		});
	}
	private void envioTransferencia() {
		System.out.print("ID Destinatario: ");
		Integer idDestino = teclado.nextInt();
		System.out.print("Importe: ");
		double importe = teclado.nextDouble();
		teclado.nextLine();
		System.out.print("Concepto: ");
		String concepto = teclado.nextLine();
		Transferencia nuevaTransferencia = new Transferencia(siguienteidTransferencia, idOrigen, idDestino, importe ,concepto );
		transferencias.add(nuevaTransferencia);
		siguienteidTransferencia++;
		System.out.println("Transferenca enviada con exito.");
	}
	private void obtenerTransferencia() {
		System.out.print("Id de la transferencia a consultar: ");
		int idTransferencia = teclado.nextInt();
		Transferencia transferenciaResultado = buscarTransferenciaPorId(idTransferencia);
		// si se ha encontrado
		if (transferenciaResultado != null) {
			System.out.println(transferenciaResultado);
		} else {
			System.out.println("No se pudo encontrar una transferencia con el id " + idTransferencia);
		}
	}
	private void obtenerTodasTransferencias() {
		if (transferencias.isEmpty()) {
			System.out.println("Todavía no hay transferencias.");
		}
		transferencias.forEach(transferencia -> {
			System.out.println(transferencia);
		});
	}
	private void login() {
			System.out.print("Id gestor: ");
			int idGestor = teclado.nextInt();
			System.out.print("Contraseña: ");
			String pass = teclado.next();
			Gestor gestor = buscarGestorPorId(idGestor);
			// si el gestor existe
			if (gestor != null) {
				// si la contraseña coincide
				if (gestor.getPassword().equals(pass)) {
					System.out.println("Login correcto!");
				} else {
					System.out.println("Login incorrecto!");
				}
			} else {
				System.out.println("El usuario no existe...");
			}
	}
	private void iniciarConsola() {

		int opcion = -1;

		do {

			mostrarMenu();

			System.out.print("Selecciona una opción: ");
			opcion = teclado.nextInt();
			switch (opcion) {
			case 1:
				insertarGestor();
				break;
			case 2:
				insertarGestoresDePrueba();
				break;
			case 3:
				consultarGestor();
				break;
			case 4:
				verTodosGestores();
				break;
			case 5:
				actualizarGestor();
				break;
			case 6:
				eliminarGestor();
				break;
			case 7:
				insertarCliente();
				break;
			case 8:
				consultarCliente();
				break;
			case 9:
				obtenerTodosClientes();
				break;
			case 10:
				actualizarClientes();
				break;
			case 11:
				eliminarCliente();
				break;
			case 12:
				obtenerMensaje();
				break;
			case 13:
				obtenerTodosMensajes();
				break;
			case 14:
				envioMensaje();
				break;
			case 15:
				obtenerTransferencia();
				break;
			case 16:
				obtenerTodasTransferencias();
				break;
			case 17:
				envioTransferencia();
				break;
			case 18:
				login();
				break;
			case 0:
				teclado.close();
				System.out.println("¡Hasta pronto!");
				break;
			default:
				System.out.println("Opción desconocida...");
			}

		} while (opcion != 0);
	}

	public static void main(String[] args) {

		ConsolaBanco consola = new ConsolaBanco();

		consola.iniciarConsola();

	}

}
