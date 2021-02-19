/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.mauricio.retrofitclient.exeption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<?> handleBadRequestException(IllegalArgumentException ex) {

    return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(ex.getCause());
  }

  @ExceptionHandler(DataNotFoundException.class)
  public ResponseEntity<?> handleDataNotFoundException(DataNotFoundException ex) {

    return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(ex.getCause());
  }
}
