/*
 * Copyright Integro Technologies Pte Ltd
 * $HeadURL: https://svn.integrosys.com/projects/ocbc_src/ECPS/OneECPS_KYC/src/java/com/integrosys/base/hs/techinfra/exception/BaseCheckedException.java $
 */
package com.project.demo.exception;

public class BaseCheckedException extends Exception{

	static final long serialVersionUID = 0L;
	private String errorCode;
	private Object params[];

	public BaseCheckedException()
	{
	}

	public BaseCheckedException(String debugMessage)
	{
		super(debugMessage);
	}

	public BaseCheckedException(Throwable t)
	{
		super(t);
	}

	public BaseCheckedException(String debugMessage, Throwable t)
	{
		super(debugMessage, t);
	}

	public BaseCheckedException(String errorCode, Object params[], String debugMessage)
	{
		super(debugMessage);
		this.errorCode = errorCode;
		this.params = params;
	}

	public BaseCheckedException(String errorCode, Object param, String debugMessage)
	{
		super(debugMessage);
		Object myParams[] = new Object[1];
		myParams[0] = param;
		this.errorCode = errorCode;
		params = myParams;
	}

	public BaseCheckedException(String errorCode, Object param1, Object param2, String debugMessage)
	{
		super(debugMessage);
		Object myParams[] = new Object[2];
		myParams[0] = param1;
		myParams[1] = param2;
		this.errorCode = errorCode;
		params = myParams;
	}

	public BaseCheckedException(String errorCode, Object param1, Object param2, Object param3, String debugMessage)
	{
		super(debugMessage);
		Object myParams[] = new Object[3];
		myParams[0] = param1;
		myParams[1] = param2;
		myParams[2] = param3;
		this.errorCode = errorCode;
		params = myParams;
	}

	public BaseCheckedException(String errorCode, Object params[], String debugMessage, Throwable t)
	{
		super(debugMessage, t);
		this.errorCode = errorCode;
		this.params = params;
	}

	public BaseCheckedException(String errorCode, Object param, String debugMessage, Throwable t)
	{
		super(debugMessage, t);
		Object myParams[] = new Object[1];
		myParams[0] = param;
		this.errorCode = errorCode;
		params = myParams;
	}

	public BaseCheckedException(String errorCode, Object param1, Object param2, String debugMessage, Throwable t)
	{
		super(debugMessage, t);
		Object myParams[] = new Object[2];
		myParams[0] = param1;
		myParams[1] = param2;
		this.errorCode = errorCode;
		params = myParams;
	}

	public BaseCheckedException(String errorCode, Object param1, Object param2, Object param3, String debugMessage, Throwable t)
	{
		super(debugMessage, t);
		Object myParams[] = new Object[3];
		myParams[0] = param1;
		myParams[1] = param2;
		myParams[2] = param3;
		this.errorCode = errorCode;
		params = myParams;
	}

	public String getErrorCode()
	{
		return errorCode;
	}

	public Object[] getParams()
	{
		return params;
	}
}
