// --------------------------------------------------------------------------
// Copyright © 2012 - 2013 Optymyze Pte. Ltd. All Rights Reserved.
// This program belongs to Optymyze Pte. Ltd. It is considered a TRADE SECRET
// and is not to be divulged or used by parties who have not received written
// authorization from Optymyze Pte. Ltd.
// --------------------------------------------------------------------------
package demo.bean;

/**
 * @author Bogdan Buzac
 */
public class ConverterBean {

    private String result;
    private String conversionSummary;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        double conversionFactor = 39.37;
        double metersToConvert = Double.parseDouble(result);
        double  inches = conversionFactor * metersToConvert;
        String inchesString = Double.toString(inches);

        this.result = result + " m = " + inchesString + " inches";
    }

    public void setConversionSummary(String conversionSummary) {
        this.conversionSummary = conversionSummary;
    }

    public String getConversionSummary() {
        return conversionSummary;
    }

}