package br.com.dotofcodex.somacarrao_delivery.util;

import br.com.dotofcodex.somacarrao_delivery.exception.BusinessException;

public interface ValidObject<T> {

	public boolean exists(T object) throws BusinessException;

}
