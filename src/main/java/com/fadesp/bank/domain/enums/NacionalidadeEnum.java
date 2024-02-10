package com.fadesp.bank.domain.enums;

public enum NacionalidadeEnum {
    BRASILEIRO("Brasileiro(a)"),
    ESTRANGEIRO("Estrangeiro(a)");

    private final String descricao;

    NacionalidadeEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NacionalidadeEnum fromDescricao(String descricao) {
        for (NacionalidadeEnum nacionalidadeEnum : NacionalidadeEnum.values()) {
            if (nacionalidadeEnum.descricao.equalsIgnoreCase(descricao)) {
                return nacionalidadeEnum;
            }
        }
        throw new IllegalArgumentException("Descrição de nacionalidade inválida: " + descricao);
    }
}
