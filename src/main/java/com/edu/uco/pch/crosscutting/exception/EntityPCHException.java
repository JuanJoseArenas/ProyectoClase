package com.edu.uco.pch.crosscutting.exception;

import com.edu.uco.pch.crosscutting.Helper.ObjectHelper;
import com.edu.uco.pch.crosscutting.Helper.TextHelper;
import com.edu.uco.pch.crosscutting.exception.enums.Lugar;

public class EntityPCHException extends RuntimeException {

	private static final long serialVersionUID = 8718872093828946853L;

	protected String mensajeUsuario;
	protected Lugar lugar;

	public EntityPCHException(final String mensajeTecnico, final String mensajeUsuario, final Lugar lugar, final Throwable excepcionRaiz) {
		super(mensajeTecnico, excepcionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}
	
	public EntityPCHException(final String mensajeUsuario, final Lugar lugar) {
		super(mensajeUsuario, new Exception());
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}

	private final void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = TextHelper.applyTrim(mensajeUsuario);
	}

	private final void setLugar(final Lugar lugar) {
		this.lugar = ObjectHelper.getObjectHelper().getDefaultValue(lugar, Lugar.DEFAULT);

	}

	public final String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public final Lugar getLugar() {
		return lugar;
	}

}
