package com.gotaqueconstroi.umagotaqueconstroi;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.text.Editable;
import android.text.TextWatcher;

public class Coleta extends AppCompatActivity {


    //MASK
    public static abstract class Mask {
        public static String unmask(String s) {
            return s.replaceAll("[.]", "").replaceAll("[-]", "")
                    .replaceAll("[/]", "").replaceAll("[(]", "")
                    .replaceAll("[)]", "").replaceAll("[:]", "");
        }

        public static TextWatcher insert(final String mask, final EditText ediTxt) {
            return new TextWatcher() {
                boolean isUpdating;
                String old = "";
                public void onTextChanged(CharSequence s, int start, int before,int count) {
                    String str = Mask.unmask(s.toString());
                    String mascara = "";
                    if (isUpdating) {
                        old = str;
                        isUpdating = false;
                        return;
                    }
                    int i = 0;
                    for (char m : mask.toCharArray()) {
                        if (m != '#' && str.length() > old.length()) {
                            mascara += m;
                            continue;
                        }
                        try {
                            mascara += str.charAt(i);
                        } catch (Exception e) {
                            break;
                        }
                        i++;
                    }
                    isUpdating = true;
                    ediTxt.setText(mascara);
                    ediTxt.setSelection(mascara.length());
                }
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
                public void afterTextChanged(Editable s) {}
            };
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coleta);
        ImageButton btnColeta = (ImageButton) findViewById(R.id.btnColeta);
        final EditText txtQuantidade = (EditText) findViewById(R.id.txtQuantidade);
        final EditText txtHorario = (EditText) findViewById(R.id.txtHorario);
        txtHorario.addTextChangedListener(Mask.insert("##:##", txtHorario));
        ImageButton btnInformacao = (ImageButton) findViewById(R.id.btnInformacao);

        

        btnColeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer quantidade;
                String horario;
                String quantidadeDigitada;
                horario = txtHorario.getText().toString();
                quantidadeDigitada = txtQuantidade.getText().toString();
                if(quantidadeDigitada.equals("")){
                    Toast.makeText(Coleta.this, "Digite uma quantidade válida ", Toast.LENGTH_SHORT).show();
                }else {
                    quantidade = Integer.parseInt(txtQuantidade.getText().toString());

                    if (quantidade <= 0) {
                        Toast.makeText(Coleta.this, "Digite uma quantidade válida ", Toast.LENGTH_SHORT).show();
                    } else {
                        //Criar Alert Dialog
                        AlertDialog.Builder dialog;
                        dialog = new AlertDialog.Builder(Coleta.this);
                        //Titulo do Dialog
                        dialog.setTitle("Confirmação");
                        //Mensagem da Dialog
                        dialog.setMessage("Confirma a doação de " + quantidade + " litros de óleo, " +
                        "com o melhor horário de coleta às " +horario +" horas?");
                        //Não deixar cancelar a Dialog
                        dialog.setCancelable(false);
                        //Definindo ícone
                        dialog.setIcon(android.R.drawable.ic_dialog_alert);
                        //Botao Negativo
                        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Coleta.this, "Doação não realizada !", Toast.LENGTH_LONG).show();
                            }
                        });
                        //Botao positivo
                        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Coleta.this, "Agradecemos a doação, em breve iremos recolher !", Toast.LENGTH_LONG).show();
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

        //Botão de informações - O Azulzinho
        btnInformacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog;
                dialog = new AlertDialog.Builder(Coleta.this);
                dialog.setTitle("Instruções");
                dialog.setMessage("1 - Coloque o óleo que será coletado dentro de garrafas pet. \n \n"  +
                        "2 - No campo quantidade, deverá ser informada a quantidade em litros \n \n" +
                "3 - No campo melhor horário, deverá ser informado o melhor horário para coleta no formato 24h. \n \n" +
                "4 - Após preencher todos os campos, basta clicar no botão verde. \n \n" +
                "5 - Confirme os dados na tela a seguir. \n \n" +
                "6 - Pronto, em poucos passos você ajudou o meio ambiente! Muito Obrigado. ;)");
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
