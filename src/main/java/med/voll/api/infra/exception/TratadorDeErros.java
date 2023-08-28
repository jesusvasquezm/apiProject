package med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){ //Erro 404 NOT FOUND
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity tratarErro400(MethodArgumentNotValidException exception){ //Erro 400 BAD REQUEST
   var error = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(error.stream().map(DadoErroValidacao::new));
    }

    private record DadoErroValidacao(String field, String message){

        public DadoErroValidacao(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
