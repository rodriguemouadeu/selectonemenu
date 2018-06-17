package com.rodriguemouadeu.selectonemenu.entities;

import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public enum Status {
	
	SUBMITTED("selectonemenu.Status.Submitted"),
    REJECTED("selectonemenu.Status.Rejected"),
    APPROVED("selectonemenu.Status.Approved");

	private static final Logger LOG = Logger.getLogger(Status.class);
	
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n", Locale.getDefault());
	 
    private String i18nKey;

    private Status(String i18nKey) {
        this.i18nKey = i18nKey;
    }

    public String getI18nKey() {
        return i18nKey;
    }

	public static Status fromString(String value) {
		LOG.info("com.rodriguemouadeu.selectonemenu.entities.Status.fromString(String)" + ":" + value);
		
		if(Objects.requireNonNull(value) != null){
			for(Status item : values()){
				if(item.name().equals(value)){
					LOG.info("Hurray: Found Enum!");
					return item;
				}
			}
		}
		return null;
	}

	public static String fromName(Object value) {
		LOG.info("com.rodriguemouadeu.selectonemenu.entities.Status.fromName(Object)" + ":" + value);
		if(Objects.requireNonNull(value) != null){
			for(Status item : values()){
				if(item.name().equals(String.valueOf(value))){
					LOG.info(String.format("Hurray: Found Enum for '%s'!", value));
					String result = resourceBundle.getString(item.i18nKey);
					return result;
				}
			}
		}
		return null;
	}
}
