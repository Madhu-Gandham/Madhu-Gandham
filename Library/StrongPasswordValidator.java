package com.infinite.Library;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("strongPasswordValidator")
public class StrongPasswordValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String feedback = (String) component.getAttributes().get("feedback");
        if (!"strong".equals(feedback)) {
            throw new ValidatorException(new FacesMessage("Password must be strong."));
        }
    }
}
