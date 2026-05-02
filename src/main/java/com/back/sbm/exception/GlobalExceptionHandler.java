package com.back.sbm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Manejador global de excepciones para la aplicación.
 * Centraliza el manejo de excepciones de todas las capas (controllers, services)
 * y devuelve respuestas HTTP estandarizadas con mensajes descriptivos.
 * 
 * Las excepciones se lanzan en services/controllers y se manejan aquí,
 * permitiendo que la lógica de presentación sea limpia y consistente.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja excepciones de validación de Bean Validation ("@Valid", "@NotNull", etc.).
     * 
     * @param ex La excepción de validación lanzada por Spring
     * @param request El objeto de la solicitud HTTP actual
     * @return ResponseEntity con lista detallada de errores de validación (400 Bad Request)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationExceptions(
            MethodArgumentNotValidException ex,
            WebRequest request) {

        List<ErrorResponseDTO.FieldError> fieldErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> ErrorResponseDTO.FieldError.builder()
                        .field(error.getField())
                        .message(error.getDefaultMessage())
                        .rejectedValue(error.getRejectedValue())
                        .build())
                .toList();

        ErrorResponseDTO response = ErrorResponseDTO.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Validation Failed")
                .message("La solicitud contiene errores de validación")
                .path(request.getDescription(false).replace("uri=", ""))
                .errors(fieldErrors)
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Maneja NoSuchElementException cuando un recurso no es encontrado.
     * Se lanza típicamente en servicios cuando findById().orElseThrow()
     * 
     * @param ex La excepción de elemento no encontrado
     * @param request El objeto de la solicitud HTTP actual
     * @return ResponseEntity con mensaje de error (404 Not Found)
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseDTO> handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {

        ErrorResponseDTO response = ErrorResponseDTO.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Not Found")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Maneja DataIntegrityViolationException cuando se viola una constraint de integridad.
     * Diferencia entre:
     * - Violación UNIQUE/CHECK → 400 Bad Request (error de validación)
     * - Violación FK → 409 Conflict (integridad referencial: registro con dependencias)
     *
     * @param ex La excepción de violación de integridad
     * @param request El objeto de la solicitud HTTP actual
     * @return ResponseEntity con mensaje y código HTTP apropiado
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handleDataIntegrityViolationException(
            DataIntegrityViolationException ex,
            WebRequest request) {

        String message = ex.getMessage();
        
        // Violación de UNIQUE o CHECK constraints
        if (message != null && (message.toLowerCase().contains("unique") || message.toLowerCase().contains("check"))) {
            ErrorResponseDTO response = ErrorResponseDTO.builder()
                    .timestamp(LocalDateTime.now())
                    .status(HttpStatus.BAD_REQUEST.value())
                    .error("Bad Request")
                    .message("Violación de restricción única: uno de los campos ya existe en la base de datos")
                    .path(request.getDescription(false).replace("uri=", ""))
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        
        // Violación de FK constraints (intento de borrar con dependencias)
        if (message != null && (message.toLowerCase().contains("foreign key") || message.toLowerCase().contains("fk"))) {
            ErrorResponseDTO response = ErrorResponseDTO.builder()
                    .timestamp(LocalDateTime.now())
                    .status(HttpStatus.CONFLICT.value())
                    .error("Conflict")
                    .message("No se puede eliminar el registro porque tiene datos asociados")
                    .path(request.getDescription(false).replace("uri=", ""))
                    .build();
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
        
        // Por defecto: devolver mensaje real de la base de datos para otros casos
        ErrorResponseDTO response = ErrorResponseDTO.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .error("Conflict")
                .message(message != null ? message : "Error de integridad de datos")
                .path(request.getDescription(false).replace("uri=", ""))
                .build();

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    /**
     * Maneja IllegalArgumentException para errores de validación de reglas de negocio.
     * Se lanza en servicios cuando se violan reglas (ej: cita duplicada, email único, etc.)
     * 
     * @param ex La excepción de argumento inválido
     * @param request El objeto de la solicitud HTTP actual
     * @return ResponseEntity con mensaje de error (400 Bad Request)
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDTO> handleIllegalArgumentException(
            IllegalArgumentException ex,
            WebRequest request) {

        ErrorResponseDTO response = ErrorResponseDTO.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Manejador genérico de excepciones no previstas.
     * Captura cualquier Exception que no sea manejada por handlers específicos.
     * 
     * @param ex La excepción genérica
     * @param request El objeto de la solicitud HTTP actual
     * @return ResponseEntity con mensaje de error (500 Internal Server Error)
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGlobalException(
            Exception ex,
            WebRequest request) {

        ErrorResponseDTO response = ErrorResponseDTO.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Internal Server Error")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
