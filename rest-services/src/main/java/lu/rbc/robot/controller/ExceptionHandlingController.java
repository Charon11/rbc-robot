package lu.rbc.robot.controller;


import lombok.extern.log4j.Log4j;
import lu.rbc.robot.exception.NotSupportedStatusException;
import lu.rbc.robot.exception.NotSupportedCategoryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Created by renaudchardin on 31/07/2017.
 */
@Log4j
@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler({NotSupportedStatusException.class, NotSupportedCategoryException.class})
    public ResponseEntity NotSupportedExceptionHandler(Exception e) {
        log.error(e);
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity defaultHandler(Exception e){
        log.error(e);
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
