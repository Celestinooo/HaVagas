package br.edu.ifsp.scl.pdm.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import br.edu.ifsp.scl.pdm.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

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
}