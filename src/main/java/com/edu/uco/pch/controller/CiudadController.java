package com.edu.uco.pch.controller;


import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uco.pch.business.facade.impl.ciudad.ConsultarCiudadesFacade;
import com.edu.uco.pch.business.facade.impl.ciudad.RegistrarCiudadFacade;
import com.edu.uco.pch.controller.response.CiudadResponse;
import com.edu.uco.pch.crosscutting.exception.PCHException;
import com.edu.uco.pch.dto.CiudadDTO;

@RestController
@RequestMapping("/api/v1/ciudades")
public final class CiudadController {

	@GetMapping("/dummy")
	public CiudadDTO dummy() {
		return CiudadDTO.build();
	}

	@GetMapping
	public ResponseEntity<CiudadResponse> consultar() {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();

		try {
			var ciudadDto = CiudadDTO.build();
			var facade = new ConsultarCiudadesFacade();
			
			ciudadResponse.setDatos(facade.execute(ciudadDto));
			ciudadResponse.getMensajes().add("Ciudades Consultadas Exitosamente");
			

		} catch (final PCHException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(excepcion.getMensajeUsuario());

			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "Se ha presentado un problema tratando de consultar la informacion de la ciudad";
			ciudadResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
		}

		return new ResponseEntity<CiudadResponse>(ciudadResponse, httpStatusCode);

	}
	
	@PostMapping
	public ResponseEntity<CiudadResponse> crear(@RequestBody CiudadDTO ciudad) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();

		try {
			var facade = new RegistrarCiudadFacade();
			
			facade.execute(ciudad);
			ciudadResponse.getMensajes().add("Ciudades creada Exitosamente");
			

		} catch (final PCHException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(excepcion.getMensajeUsuario());

			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "Se ha presentado un problema tratando de crear la nueva ciudad";
			ciudadResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
		}

		return new ResponseEntity<CiudadResponse>(ciudadResponse, httpStatusCode);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CiudadResponse> eliminar(@PathVariable UUID id ) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();

		try {
//			var facade = new EliminarCiudadFacade();
			
//			facade.execute(id);
			ciudadResponse.getMensajes().add("Ciudades eliminada Exitosamente");
			

		} catch (final PCHException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(excepcion.getMensajeUsuario());

			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la informacion de ciudad";
			ciudadResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
		}

		return new ResponseEntity<CiudadResponse>(ciudadResponse, httpStatusCode);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CiudadResponse> modificar(@PathVariable UUID id,
			@RequestBody CiudadDTO ciudadDto ) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();

		try {
			ciudadDto.setId(id);
//			var facade = new ModificarCiudadFacade();
			
//			facade.execute(id);
			ciudadResponse.getMensajes().add("Ciudades eliminada Exitosamente");
			

		} catch (final PCHException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(excepcion.getMensajeUsuario());

			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la informacion de ciudad";
			ciudadResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
		}

		return new ResponseEntity<CiudadResponse>(ciudadResponse, httpStatusCode);

	}

}
