package hibernate.validator;

import hibernate.dto.SubjectDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SubjectValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return SubjectDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"subject","Enter a subject name");
        ValidationUtils.rejectIfEmpty(errors,"message","Enter a message");
        ValidationUtils.rejectIfEmpty(errors,"date","Enter a date");

    }
}
