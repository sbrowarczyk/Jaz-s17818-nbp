package pl.pjatk.jazs17818nbp.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.NotFound;

@RestControllerAdvice
public class NBPExceptionHandler {

  @ExceptionHandler(NotFound.class)
  public ResponseEntity<String> notFoundHandler(NotFound notFound) {
    String exceptionMessage =
        "Exception occurred on request. Exception message: " + notFound.getMessage();
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionMessage);

  }

  @ExceptionHandler(BadRequest.class)
  public ResponseEntity<String> badRequestHandler(
      BadRequest badRequest) {
    String exceptionMessage =
        "Exception occurred on request. Exception message: " + badRequest.getMessage();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionMessage);
  }

}
