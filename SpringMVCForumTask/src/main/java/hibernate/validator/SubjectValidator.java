package hibernate.validator;

import hibernate.dto.SubjectDTO;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class SubjectValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return SubjectDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"subject","enter.subject");
        ValidationUtils.rejectIfEmpty(errors,"message","enter.message");
        ValidationUtils.rejectIfEmpty(errors,"date","enter.date");

        SubjectDTO subjectDTO = (SubjectDTO) o;
        Pattern pattern = Pattern.compile("[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])",
                Pattern.CASE_INSENSITIVE);
        if (!(pattern.matcher(subjectDTO.getDate()).matches())) {
            errors.rejectValue("date","enter.invalid.date");
        }
        if (!(StringUtils.capitalize(subjectDTO.getMessage()).equals(subjectDTO.getMessage()))) {
            errors.rejectValue("message", "enter.invalid.message");
        }
        if (!(WordUtils.capitalize(subjectDTO.getSubject()).equals(subjectDTO.getSubject()))) {
            errors.rejectValue("subject", "enter.invalid.subject");
        }
    }
}
