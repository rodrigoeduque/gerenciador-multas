package br.com.rodrigoeduque.gerenciadorMultas.exception;

import org.springframework.http.HttpStatusCode;

import java.util.List;

public class DefaultApiMessageError {

    private HttpStatusCode statusCode;
    private List<Object> error;

    public DefaultApiMessageError(HttpStatusCode statusCode, List<Object> error) {
        this.statusCode = statusCode;
        this.error = error;
    }

    public DefaultApiMessageError() {
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public List<Object> getError() {
        return error;
    }

    public void setError(List<Object> error) {
        this.error = error;
    }
}
