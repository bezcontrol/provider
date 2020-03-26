package ua.kh.baklanov.web.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class ValidateAnyTariffFields {

    private static List<String>errors=new ArrayList<>();

    private ValidateAnyTariffFields(){}

    public static String isNameValid(String name){
        String errorMessage="Name is not valid!";
        if (Objects.isNull(name)) {
           return errorMessage;
        }
        return null;
    }

    public static String isPriceValid(String price){
        String errorMessage="Price is not valid";
        if (Objects.isNull(price)) {
            return errorMessage;
        }
        try {
            int intPrice = Integer.parseInt(price);
            if(intPrice<0){
                return errorMessage;
            }
        } catch (NumberFormatException e){
            return errorMessage;
        }
        return null;
    }

    public static String isDurationValid(String duration){
        String errorMessage="Duration is not valid";
        if (Objects.isNull(duration)) {
            return errorMessage;
        }
        try {
            int intDuration = Integer.parseInt(duration);
            if(intDuration<0){
                return errorMessage;
            }
        } catch (NumberFormatException e){
            return errorMessage;
        }
        return null;
    }

    public static List<String> isGeneralFieldsValid(String name, String price, String duration){
        if(Objects.nonNull(isNameValid(name))){
            errors.add(isNameValid(name));
        }
        if(Objects.nonNull(isPriceValid(price))){
            errors.add(isPriceValid(price));
        }
        if(Objects.nonNull(isDurationValid(duration))){
            errors.add(isDurationValid(duration));
        }
        List<String> errorResults=new ArrayList<>(errors);
        errors.clear();
        return errorResults;
    }

    public static String isServiceValid(String serviceId) {
        String errorMessage="Service is not valid";
        if ("".equals(serviceId)) {
            return errorMessage;
        }
        try {
            int intService = Integer.parseInt(serviceId);
            if(intService<0){
                return errorMessage;
            }
        } catch (NumberFormatException e){
            return errorMessage;
        }
        return null;
    }
}
