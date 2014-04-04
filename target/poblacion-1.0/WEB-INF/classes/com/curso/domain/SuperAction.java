package com.curso.domain;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Results( { @Result(name = "json", type = "stream", params = { "contentType", "text/html", "inputName", "inputStream" }),
        @Result(name = "input", location = "error-async.jsp") })
public class SuperAction extends ActionSupport implements SessionAware, RequestAware, ServletResponseAware {

	Gson gson = new Gson();
    // TODO: Hacer que el error en el jsp, cuando no hay base de datos se quite
    // en la siguiente ejecucion exitosa

	public String JSON = "json";
	
    /**
	 * 
	 */
    private static final long serialVersionUID = 2416274655666702545L;

    private static final Logger log = Logger.getLogger(SuperAction.class);

    protected static SimpleDateFormat SDF_DDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");

    static {
        SDF_DDMMYYYY.setLenient(false);

    }
    
	protected Map request;
    
    protected HttpServletResponse response;

    protected Map<String, Object> session;

    protected InputStream inputStream;

    protected static final String JSON_SUCCESS = "success";
    protected static final String JSON_HASERRORS = "hasErrors";
    protected static final String JSON_ALERTS = "alerts";
    protected static final String JSON_DIVS = "divs";
    protected static final String JSON_VALUES = "values";
    protected static final String JSON_TABS = "tabs";
    protected static final String JSON_EXCEPTION = "exception";

    protected final String DIV = "div";
    protected final String NAME = "name";
    protected final String VALUE = "value";
    protected final String MSG = "msg";
    protected final String TAB = "tab";
    protected final String LEVEL = "lev";

    /**
     * Captura los parametros no necesarios de cada action, evitara validaciones del paramaters interceptor
     */
    private String ignorame[];

    public final String[] getIgnorame() {
        return ignorame;
    }

    public final void setIgnorame(String[] ignorame) {
        this.ignorame = ignorame;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public final InputStream getInputStream() {
        return inputStream;
    }

    public final void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    protected String emptyIfIsBlank(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        } else {
            return str.trim();
        }
    }

    protected String format_DMY_hhmm(Date date) {
        if (date == null) {
            return "";
        } else {

            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            fmt.setLenient(false);
            return fmt.format(date);
        }
    }

    protected String format_DMY(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            fmt.setLenient(false);
            return fmt.format(date);
        }
    }

    @SuppressWarnings("unchecked")
	public void setRequest(Map request) {
		this.request = request;
	}
	
	public void setServletResponse(javax.servlet.http.HttpServletResponse arg0) {
		response = arg0;
	}
	
	protected void streamIt(JsonObject messages) {
		try {
			inputStream = new ByteArrayInputStream(messages.toString()
					.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			log.error("streamIt", e);
			inputStream = new ByteArrayInputStream(messages.toString()
					.getBytes());
		}
	}
	
	 protected JsonObject getDivYMensaje(String div, String msg) {
	        Map<String, String> map = new HashMap<String, String>();
	        map.put(DIV, div);
	        map.put(MSG, msg);
	        return (JsonObject) gson.toJsonTree(map);
	    }
   
}
