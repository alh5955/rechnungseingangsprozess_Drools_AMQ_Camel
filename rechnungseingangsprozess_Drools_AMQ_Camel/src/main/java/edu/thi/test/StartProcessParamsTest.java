package edu.thi.test;

import java.util.List;
import java.util.Map;
//import java.util.Map;

/**
 * @author Alexander Hauke
 */

public class StartProcessParamsTest {

    private String message;

    private Map<String, Object> mapVariables;

    private List<VariablesTest> variables;

    public List<VariablesTest> getVariables() {
        return variables;
    }

    public void setVariables(List<VariablesTest> variables) {
        this.variables = variables;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getMapVariables() {
        return mapVariables;
    }

    public void setMapVariables(Map<String, Object> mapVariables) {
        this.mapVariables = mapVariables;
    }

}