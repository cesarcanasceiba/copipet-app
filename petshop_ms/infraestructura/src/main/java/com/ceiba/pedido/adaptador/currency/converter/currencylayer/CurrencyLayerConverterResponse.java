package com.ceiba.pedido.adaptador.currency.converter.currencylayer;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyLayerConverterResponse {
    private boolean success;
    private Map<String, Long> quotes;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, Long> getQuotes() {
        return quotes;
    }

    public void setQuotes(Map<String, Long> quotes) {
        this.quotes = quotes;
    }
}
