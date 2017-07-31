package pl.asseco.workshop.calculationModule.Services;

import sun.net.www.content.text.Generic;

/**
 * Created by krzysztof.bogucki on 31 lip 2017.
 */
public class ErrorInfo {

    private String Message;
    private String StackTraces;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStackTraces() {
        return StackTraces;
    }

    public void setStackTraces(String stackTraces) {
        StackTraces = stackTraces;
    }



}
