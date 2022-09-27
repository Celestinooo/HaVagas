package br.edu.ifsp.scl.pdm.havagas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import br.edu.ifsp.scl.pdm.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String nomeCompletoKey = "NOME_COMPLETO_KEY";
    private static final String emailKey = "EMAIL_KEY";
    private static final String receberAtualizacoesKey = "RECEBER_ATUALIZACOES_KEY";
    private static final String tipoTelefoneComercialKey = "TIPO_TELEFONE_KEY";
    private static final String telefoneKey = "TELEFONE_KEY";
    private static final String adicionarCelularKey = "ADICIONAR_CELULAR_KEY";
    private static final String celularKey = "CELULAR_KEY";
    private static final String sexoFemininoKey = "SEXO_KEY";
    private static final String formacaoIndexKey = "FORMACAO_KEY";
    private static final String anoFormaturaKey = "ANO_FORMATURA_KEY";
    private static final String anoConclusaoKey = "ANO_CONCLUSAO_KEY";
    private static final String instituicaoKey = "INSTITUICAO_KEY";
    private static final String monografiaKey = "MONOGRAFIA_KEY";
    private static final String orientadorKey = "ORIENTADOR_KEY";
    private static final String vagasDeInteresseKey = "VAGAS_DE_INTERESSE_KEY";

    private ActivityMainBinding amb;
    private Formacao formacao = Formacao.ENSINO_FUNDAMENTAL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(amb.mainSv);
        amb.adicionarCelularCb.setOnCheckedChangeListener((compoundButton, checked) -> amb.celularEt.setVisibility(checked ? View.VISIBLE : View.GONE));
        amb.formacaoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0 || i == 1) {
                    mostrarCamposFundamentalEMedio();
                    formacao = i == 0 ? Formacao.ENSINO_FUNDAMENTAL : Formacao.ENSINO_MEDIO;
                }
                if (i == 2 || i == 3) {
                    mostrarCamposGraduacaoEEspecializacao();
                    formacao = i == 2 ? Formacao.GRADUACAO : Formacao.ESPECIALIZACAO;
                }
                if (i == 4 || i == 5) {
                    mostrarMestradoEDoutorado();
                    formacao = i == 4 ? Formacao.MESTRADO : Formacao.DOUTORADO;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        amb.limparBt.setOnClickListener(view -> limpar());

        amb.salvarBt.setOnClickListener(view -> salvar());
    }

    private void mostrarCamposFundamentalEMedio() {
        amb.formaturaEt.setVisibility(View.VISIBLE);
        amb.conclusaoInstituicaoLl.setVisibility(View.GONE);
        amb.monografiaOrientadorLl.setVisibility(View.GONE);
    }

    private void mostrarCamposGraduacaoEEspecializacao() {
        amb.formaturaEt.setVisibility(View.GONE);
        amb.conclusaoInstituicaoLl.setVisibility(View.VISIBLE);
        amb.monografiaOrientadorLl.setVisibility(View.GONE);
    }

    private void mostrarMestradoEDoutorado() {
        amb.formaturaEt.setVisibility(View.GONE);
        amb.conclusaoInstituicaoLl.setVisibility(View.VISIBLE);
        amb.monografiaOrientadorLl.setVisibility(View.VISIBLE);
    }


    private void limpar() {
        amb.nomeEt.getText().clear();
        amb.emailEt.getText().clear();
        amb.anoConclusaoEt.getText().clear();
        amb.celularEt.getText().clear();
        amb.formaturaEt.getText().clear();
        amb.instituicaoEt.getText().clear();
        amb.interesseEt.getText().clear();
        amb.monografiaEt.getText().clear();
        amb.orientadorEt.getText().clear();
        amb.telefoneEt.getText().clear();
        amb.receberAtualizacoesCb.setChecked(false);
        amb.comercialRb.setChecked(true);
        amb.residencialRb.setChecked(false);
        amb.adicionarCelularCb.setChecked(false);
        amb.femininoRb.setChecked(true);
        amb.masculinoRb.setChecked(false);
        amb.formacaoSpinner.setSelection(0);
    }

    private void salvar() {
        String nome = amb.nomeEt.getText().toString();
        String email = amb.emailEt.getText().toString();
        boolean receberAtualizacoes = amb.receberAtualizacoesCb.isChecked();
        TiposTelefone tipoTelefone = amb.comercialRb.isChecked() ? TiposTelefone.COMERCIAL : TiposTelefone.RESIDENCIAL;
        String telefone = amb.telefoneEt.getText().toString();
        boolean adicionarCelular = amb.adicionarCelularCb.isChecked();
        String celular = amb.celularEt.getText().toString();
        Sexo sexo = amb.femininoRb.isChecked() ? Sexo.FEMININO : Sexo.MASCULINO;
        String anoFormatura = amb.formaturaEt.getText().toString();
        String anoConclusao = amb.anoConclusaoEt.getText().toString();
        String instituicao = amb.instituicaoEt.getText().toString();
        String monografia = amb.monografiaEt.getText().toString();
        String orientador = amb.orientadorEt.getText().toString();
        String vagasDeInteresse = amb.interesseEt.getText().toString();

        Candidato candidato = new Candidato(nome, email, receberAtualizacoes, tipoTelefone, telefone, adicionarCelular, celular, sexo, formacao, anoFormatura, anoConclusao, instituicao, monografia, orientador, vagasDeInteresse);
        Toast.makeText(this, candidato.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        saveFormData(outState);
        // Para forçar que o formulário seja limpo e checar que os dados dispostos vêm do salvamento,
        // retire o comentário da linha abaixo
         limpar();
    }

    private void saveFormData(@NonNull Bundle bundle){
        String nome = amb.nomeEt.getText().toString();
        String email = amb.emailEt.getText().toString();
        boolean receberAtualizacoes = amb.receberAtualizacoesCb.isChecked();
        boolean isComercial = amb.comercialRb.isChecked();
        String telefone = amb.telefoneEt.getText().toString();
        boolean adicionarCelular = amb.adicionarCelularCb.isChecked();
        String celular = amb.celularEt.getText().toString();
        boolean isFeminino = amb.femininoRb.isChecked();
        String anoFormatura = amb.formaturaEt.getText().toString();
        String anoConclusao = amb.anoConclusaoEt.getText().toString();
        String instituicao = amb.instituicaoEt.getText().toString();
        String monografia = amb.monografiaEt.getText().toString();
        String orientador = amb.orientadorEt.getText().toString();
        String vagasDeInteresse = amb.interesseEt.getText().toString();

        bundle.putString(nomeCompletoKey,nome);
        bundle.putString(emailKey,email);
        bundle.putBoolean(receberAtualizacoesKey,receberAtualizacoes);

        bundle.putBoolean(tipoTelefoneComercialKey,isComercial);
        bundle.putString(telefoneKey,telefone);
        bundle.putBoolean(adicionarCelularKey,adicionarCelular);
        bundle.putString(celularKey,celular);

        bundle.putBoolean(sexoFemininoKey,isFeminino);

        bundle.putInt(formacaoIndexKey,amb.formacaoSpinner.getSelectedItemPosition());

        bundle.putString(anoFormaturaKey,anoFormatura);
        bundle.putString(anoConclusaoKey,anoConclusao);
        bundle.putString(instituicaoKey,instituicao);
        bundle.putString(monografiaKey,monografia);
        bundle.putString(orientadorKey,orientador);
        bundle.putString(vagasDeInteresseKey,vagasDeInteresse);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restoreFormData(savedInstanceState);
    }

    private void restoreFormData(@Nullable Bundle bundle){
        if(bundle == null) return;
        Log.e("Salvando","Restaurando valores");
        String nomeCompleto = bundle.getString(nomeCompletoKey);
        String email = bundle.getString(emailKey);
        boolean receberAtualizacoes = bundle.getBoolean(receberAtualizacoesKey);

        boolean isComercial = bundle.getBoolean(tipoTelefoneComercialKey);
        String telefone = bundle.getString(telefoneKey);
        boolean adicionarCelular = bundle.getBoolean(adicionarCelularKey);
        String celular = bundle.getString(celularKey);

        boolean isFeminino = bundle.getBoolean(sexoFemininoKey);

        int formacaoIndex = bundle.getInt(formacaoIndexKey);

        String anoFormatura = bundle.getString(anoFormaturaKey);
        String anoConclusao = bundle.getString(anoConclusaoKey);
        String instituicao = bundle.getString(instituicaoKey);
        String monografia = bundle.getString(monografiaKey);
        String orientador = bundle.getString(orientadorKey);
        String vagasDeInteresse = bundle.getString(vagasDeInteresseKey);

        amb.nomeEt.setText(nomeCompleto);
        amb.emailEt.setText(email);
        amb.receberAtualizacoesCb.setChecked(receberAtualizacoes);

        amb.comercialRb.setChecked(isComercial);
        amb.telefoneEt.setText(telefone);
        amb.adicionarCelularCb.setChecked(adicionarCelular);
        amb.celularEt.setText(celular);

        amb.femininoRb.setChecked(isFeminino);

        amb.formacaoSpinner.setSelection(formacaoIndex);
        amb.formaturaEt.setText(anoFormatura);
        amb.anoConclusaoEt.setText(anoConclusao);
        amb.instituicaoEt.setText(instituicao);
        amb.monografiaEt.setText(monografia);
        amb.orientadorEt.setText(orientador);
        amb.interesseEt.setText(vagasDeInteresse);
    }
}