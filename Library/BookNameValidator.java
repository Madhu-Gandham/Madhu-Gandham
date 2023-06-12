package com.infinite.Library;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("bookNameValidator")
public class BookNameValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String bookName = (String) value;

        // Validate book name: allow only alphabets and numbers
        if (!bookName.matches("[A-Za-z0-9]*")) {
            throw new ValidatorException(new FacesMessage("Book name can only contain alphabets and numbers."));
        }
    }
}
