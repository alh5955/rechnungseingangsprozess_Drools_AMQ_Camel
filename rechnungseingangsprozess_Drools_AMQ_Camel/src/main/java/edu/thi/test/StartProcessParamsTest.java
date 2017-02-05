package edu.thi.test;

import java.util.List;
import java.util.Map;

import edu.thi.iis.activemq.consumer.Variables;
//import java.util.Map;

/**
 * @author Alexander Hauke
 */

public class StartProcessParamsTest {

    private String message;

    //private Map<String, Object> mapVariables;

    private List<Variable> variables;

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //public Map<String, Object> getMapVariables() {
    //    return mapVariables;
    //}

    //public void setMapVariables(Map<String, Object> mapVariables) {
    //    this.mapVariables = mapVariables;
    //}

}