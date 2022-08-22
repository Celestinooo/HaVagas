package br.edu.ifsp.scl.pdm.havagas;

import androidx.annotation.NonNull;

public class Candidato {
    private final String nomeCompleto;
    private final String email;
    private final boolean receberAtualizacoesPorEmail;
    private final TiposTelefone tipoTelefone;
    private final String telefone;
    private final boolean adicionarMeuCelular;
    private final String celular;
    private final Sexo sexo;
    private final Formacao formacao;
    private final String anoDeFormatura;
    private final String anoDeConclusao;
    private final String instituicao;
    private final String tituloDeMonografia;
    private final String orientador;
    private final String vagasDeInteresse;

    public Candidato(String nomeCompleto, String email, boolean receberAtualizacoesPorEmail, TiposTelefone tipoTelefone, String telefone, boolean adicionarMeuCelular, String celular, Sexo sexo, Formacao formacao, String anoDeFormatura, String anoDeConclusao, String instituicao, String tituloDeMonografia, String orientador, String vagasDeInteresse) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.receberAtualizacoesPorEmail = receberAtualizacoesPorEmail;
        this.tipoTelefone = tipoTelefone;
        this.telefone = telefone;
        this.adicionarMeuCelular = adicionarMeuCelular;
        this.celular = celular;
        this.sexo = sexo;
        this.formacao = formacao;
        this.anoDeFormatura = anoDeFormatura;
        this.anoDeConclusao = anoDeConclusao;
        this.instituicao = instituicao;
        this.tituloDeMonografia = tituloDeMonografia;
        this.orientador = orientador;
        this.vagasDeInteresse = vagasDeInteresse;
    }

    @NonNull
    @Override
    public String toString() {
        if (formacao == Formacao.ENSINO_MEDIO || formacao == Formacao.ENSINO_FUNDAMENTAL) {
            if (adicionarMeuCelular) {
                return "Candidato{" +
                        "nomeCompleto='" + nomeCompleto + '\'' +
                        ", email='" + email + '\'' +
                        ", receberAtualizacoesPorEmail=" + receberAtualizacoesPorEmail +
                        ", tipoTelefone=" + tipoTelefone +
                        ", telefone='" + telefone + '\'' +
                        ", celular='" + celular + '\'' +
                        ", sexo=" + sexo +
                        ", formacao=" + formacao +
                        ", anoDeFormatura='" + anoDeFormatura + '\'' +
                        ", vagasDeInteresse='" + vagasDeInteresse + '\'' +
                        '}';
            } else {
                return "Candidato{" +
                        "nomeCompleto='" + nomeCompleto + '\'' +
                        ", email='" + email + '\'' +
                        ", receberAtualizacoesPorEmail=" + receberAtualizacoesPorEmail +
                        ", tipoTelefone=" + tipoTelefone +
                        ", telefone='" + telefone + '\'' +
                        ", sexo=" + sexo +
                        ", formacao=" + formacao +
                        ", anoDeFormatura='" + anoDeFormatura + '\'' +
                        ", vagasDeInteresse='" + vagasDeInteresse + '\'' +
                        '}';
            }
        } else if (formacao == Formacao.GRADUACAO || formacao == Formacao.ESPECIALIZACAO) {
            if (adicionarMeuCelular) {
                return "Candidato{" +
                        "nomeCompleto='" + nomeCompleto + '\'' +
                        ", email='" + email + '\'' +
                        ", receberAtualizacoesPorEmail=" + receberAtualizacoesPorEmail +
                        ", tipoTelefone=" + tipoTelefone +
                        ", telefone='" + telefone + '\'' +
                        ", celular='" + celular + '\'' +
                        ", sexo=" + sexo +
                        ", formacao=" + formacao +
                        ", anoDeConclusao='" + anoDeConclusao + '\'' +
                        ", instituicao='" + instituicao + '\'' +
                        ", vagasDeInteresse='" + vagasDeInteresse + '\'' +
                        '}';
            } else {
                return "Candidato{" +
                        "nomeCompleto='" + nomeCompleto + '\'' +
                        ", email='" + email + '\'' +
                        ", receberAtualizacoesPorEmail=" + receberAtualizacoesPorEmail +
                        ", tipoTelefone=" + tipoTelefone +
                        ", telefone='" + telefone + '\'' +
                        ", sexo=" + sexo +
                        ", formacao=" + formacao +
                        ", anoDeConclusao='" + anoDeConclusao + '\'' +
                        ", instituicao='" + instituicao + '\'' +
                        ", vagasDeInteresse='" + vagasDeInteresse + '\'' +
                        '}';
            }
        } else {
            if (adicionarMeuCelular) {

                return "Candidato{" +
                        "nomeCompleto='" + nomeCompleto + '\'' +
                        ", email='" + email + '\'' +
                        ", receberAtualizacoesPorEmail=" + receberAtualizacoesPorEmail +
                        ", tipoTelefone=" + tipoTelefone +
                        ", telefone='" + telefone + '\'' +
                        ", celular='" + celular + '\'' +
                        ", sexo=" + sexo +
                        ", formacao=" + formacao +
                        ", anoDeConclusao='" + anoDeConclusao + '\'' +
                        ", instituicao='" + instituicao + '\'' +
                        ", tituloDeMonografia='" + tituloDeMonografia + '\'' +
                        ", orientador='" + orientador + '\'' +
                        ", vagasDeInteresse='" + vagasDeInteresse + '\'' +
                        '}';
            } else {

                return "Candidato{" +
                        "nomeCompleto='" + nomeCompleto + '\'' +
                        ", email='" + email + '\'' +
                        ", receberAtualizacoesPorEmail=" + receberAtualizacoesPorEmail +
                        ", tipoTelefone=" + tipoTelefone +
                        ", telefone='" + telefone + '\'' +
                        ", sexo=" + sexo +
                        ", formacao=" + formacao +
                        ", anoDeConclusao='" + anoDeConclusao + '\'' +
                        ", instituicao='" + instituicao + '\'' +
                        ", tituloDeMonografia='" + tituloDeMonografia + '\'' +
                        ", orientador='" + orientador + '\'' +
                        ", vagasDeInteresse='" + vagasDeInteresse + '\'' +
                        '}';
            }
        }
    }
}
