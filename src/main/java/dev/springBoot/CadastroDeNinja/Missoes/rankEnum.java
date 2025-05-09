package dev.springBoot.CadastroDeNinja.Missoes;

public enum rankEnum {

    D("estudante da academia"),
    C("genin"),
    B("chunin"),
    A("Anbu"),
    S("jouninEspecial"),
    SS("kage");

    String Nivel;

    rankEnum(String nivel) {
        Nivel = nivel;
    }
}
