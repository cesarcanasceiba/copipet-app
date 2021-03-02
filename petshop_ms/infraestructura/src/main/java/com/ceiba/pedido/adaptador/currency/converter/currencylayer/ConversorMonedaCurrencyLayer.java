package com.ceiba.pedido.adaptador.currency.converter.currencylayer;

import com.ceiba.pedido.currency.converter.ConversorMonedaInterface;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ConversorMonedaCurrencyLayer implements ConversorMonedaInterface {

    @Override
    public Long fromUsDToCop(Long usD) {
        WebClient client = WebClient.builder().baseUrl(
                "http://api.currencylayer.com/live?access_key=24de132f44eb874e3b3afa59b9e02c54&format=1&source=USD&currencies=COP")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
        return client.get().retrieve().bodyToMono(CurrencyLayerConverterResponse.class).block().getQuotes()
                .get("USDCOP");
    }
}
