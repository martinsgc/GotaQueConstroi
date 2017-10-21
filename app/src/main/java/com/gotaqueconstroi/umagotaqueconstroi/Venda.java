package com.gotaqueconstroi.umagotaqueconstroi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class Venda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venda);

        //Declarando as paradinhas
        ImageButton btnInformacaoVenda = (ImageButton) findViewById(R.id.btnInformacaoVenda);
        ImageButton btnNeutro = (ImageButton) findViewById(R.id.btnNeutro);
        ImageButton btnAromatizado = (ImageButton) findViewById(R.id.btnAromatizado);
        ImageButton btnCompra = (ImageButton) findViewById(R.id.btnCompra);
        final EditText txtQuantAromatizado = (EditText) findViewById(R.id.txtQuantAromatizado);
        final EditText txtQuantNeutro = (EditText) findViewById(R.id.txtQuantNeutro);
        final double valorPadrao = 8;

        //Botão Compra
        btnCompra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Declarando as paradinhas
                String quantAromatizadoDigitada;
                String quantNeutroDigitada;
                int quantAromatizado = 0;
                int quantNeutro = 0;
                double total;
                //Esqueminha para tratar valores
                Locale l = new Locale("pt", "BR");
                NumberFormat nf = NumberFormat.getCurrencyInstance(l);

                quantAromatizadoDigitada = txtQuantAromatizado.getText().toString();
                quantNeutroDigitada = txtQuantNeutro.getText().toString();
                //Tratamento de entrada
                if (quantAromatizadoDigitada.equals("")&& quantNeutroDigitada.equals("")){
                    Toast.makeText(Venda.this, "Digite uma quantidade válida ", Toast.LENGTH_SHORT).show();
                } else {
                    if (quantAromatizadoDigitada.equals("")){
                        quantAromatizado = 0;
                        quantNeutro = Integer.parseInt(txtQuantNeutro.getText().toString());
                    } else if (quantNeutroDigitada.equals("")){
                        quantAromatizado = Integer.parseInt(txtQuantAromatizado.getText().toString());
                        quantNeutro = 0;
                    } else {
                        quantAromatizado = Integer.parseInt(txtQuantAromatizado.getText().toString());
                        quantNeutro = Integer.parseInt(txtQuantNeutro.getText().toString());
                    }

                    if(quantAromatizado <= 0 && quantNeutro <= 0){
                        Toast.makeText(Venda.this, "Digite uma quantidade válida ", Toast.LENGTH_SHORT).show();
                        //Terminou o tratamento
                    } else {
                        //Calculo de Total
                        total = ((quantAromatizado * valorPadrao)+(quantNeutro * valorPadrao));
                        //Criar Alert Dialog
                        AlertDialog.Builder dialog;
                        dialog = new AlertDialog.Builder(Venda.this);
                        //Titulo do Dialog
                        dialog.setTitle("Confirmação");
                        //Mensagem da Dialog
                        dialog.setMessage("Confirma a compra de: \n \n "
                                + quantAromatizado + " unidades de sabão Aromatizado \n" +
                        + quantNeutro + " unidades de sabão Neutro \n \n " +
                        "No valor total de "+ (nf.format(total)) + " ?");
                        //Não deixar cancelar a Dialog
                        dialog.setCancelable(false);
                        //Definindo ícone
                        dialog.setIcon(android.R.drawable.ic_dialog_alert);
                        //Botao Negativo
                        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Venda.this, "Compra não realizada!", Toast.LENGTH_LONG).show();
                            }
                        });
                        //Botao positivo
                        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Venda.this, "Agradecemos a compra, em breve estaremos entregando!", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        });
                        //Criar a Dialog
                        dialog.create();
                        //Mostrar a Dialog
                        dialog.show();

                    }
                }


            }
        });

        //Botão do sabão Neutro
        btnNeutro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog;
                dialog = new AlertDialog.Builder(Venda.this);
                dialog.setTitle("Sabão Neutro");
                dialog.setMessage(" Melhor uso Sabão neutro");
                dialog.setCancelable(false);
                dialog.setIcon(android.R.drawable.ic_dialog_info);
                dialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.create();
                dialog.show();
            }
        });

        //Botão do sabão Aromatizado
        btnAromatizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog;
                dialog = new AlertDialog.Builder(Venda.this);
                dialog.setTitle("Sabão Aromatizado");
                dialog.setMessage(" Melhor uso Sabão aromatizado");
                dialog.setCancelable(false);
                dialog.setIcon(android.R.drawable.ic_dialog_info);
                dialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.create();
                dialog.show();
            }
        });


        //Botão de informações - O Azulzinho
         btnInformacaoVenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog;
                dialog = new AlertDialog.Builder(Venda.this);
                dialog.setTitle("Instruções");
                dialog.setMessage("1 - Digite a quantidade desejada de cada tipo. \n \n"  +
                        "2 - Caso queira apenas neutro não precisa preencher nada no campo quantidade do aromatizado. \n \n" +
                        "3 - Caso queira apenas aromatizado não precisa preencher nada no campo quantidade do neutro. \n \n" +
                        "4 - Após preencher todos os campos, basta clicar no botão rosa. \n \n" +
                        "5 - Confirme os dados na tela a seguir. \n \n" +
                        "6 - Pronto, em breve estaremos levando o sabão na sua casa. Muito Obrigado. ;) \n \n" +
                        "Facilite o troco!");
                dialog.setCancelable(false);
                dialog.setIcon(android.R.drawable.ic_dialog_info);
                dialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.create();
                dialog.show();

            }
        });

    }
}
