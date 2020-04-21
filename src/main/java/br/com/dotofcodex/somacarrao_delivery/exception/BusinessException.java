package br.com.dotofcodex.somacarrao_delivery.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 8771918821464634603L;

	private static final Logger logger = LoggerFactory.getLogger(BusinessException.class);

	public BusinessException() {
		super();
		logger.info("new BusinessException");
	}

	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		logger.info("new BusinessException");
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		logger.info("new BusinessException");
	}

	public BusinessException(String message) {
		super(message);
		logger.info("new BusinessException");
	}

	public BusinessException(Throwable cause) {
		super(cause);
		logger.info("new BusinessException");
	}

}
