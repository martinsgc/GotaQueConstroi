package com.gotaqueconstroi.umagotaqueconstroi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Sobre extends AppCompatActivity {

    WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        mWebView = (WebView) findViewById(R.id.webview);

        String text = "<html><body>"
                + "<p align=\"justify\">"
                + " &emsp; Uma gota que constrói surgiu através da necessidade de se pensar um projeto que " +
                "possibilitasse gerar renda, mas que fosse além de uma ideia financeira, mas que " +
                "sensibilizasse a população a necessidade de cuidarmos do nosso meio ambiente. <br>" +
                " &emsp; Por esse e tantos outros motivos que o projeto uma gota que constrói foi pensado " +
                "com intuito de promover uma sensibilização e capacitação de uma determinada " +
                "comunidade como instituições filantrópicas (APAE), associações de bairros ou até " +
                "mesmo os programas geridos pelas políticas publicas (CAPS E ABRIGO). Com intuito de" +
                " transformar um pouco dessa realidade e o numero de pessoas desempregadas. <br>" +
                "  &emsp; Sendo através da reutilização do óleo de cozinha transformando em sabão. <br>" +
                " &emsp; Sabão que poderá ser vendido para obtenção de renda familiar, para desenvolvimento" +
                " de projetos sociais dentro das APAES e do abrigo, como até mesmo nos investimentos" +
                " em materiais para a realização das oficinas já existentes nos caps. <br>" +
                " &emsp; Tendo como ferramenta de execução o APP: Gota que possibilita acompanhar e " +
                "gerenciar as doações, a coleta do material, as vendas e o histórico de prevenção ambiental."
                + "</p> "
                + "</body></html>";

        mWebView.loadData(text, "text/html", "utf-8");
    }
}
