package com.rodriguemouadeu.selectonemenu.converter;

import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import com.rodriguemouadeu.selectonemenu.entities.Status;

@FacesConverter("statusConverter")
public class StatusConverter implements Converter {

	private static Logger LOG =Logger.getLogger(StatusConverter.class);
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		LOG.info(StatusConverter.class.getName() + ":" + value);
		
		if(value != null && value.trim().length() > 0) {
            try {
                return Status.fromString(value);
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		LOG.info("com.rodriguemouadeu.selectonemenu.converter.StatusConverter.getAsString(FacesContext, UIComponent, Object): " + value);
		return value.toString();
//		if(Objects.requireNonNull(value) != null) {
//           String result = Status.fromName(value);
//			return result;
//        }
//        return null;
	}

}
