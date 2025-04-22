package Class;

public enum Capital {
    VITORIA("Vitória"),
    RIO_BRANCO("Rio Branco"),
    SALVADOR("Salvador"),
    FORTALEZA("Fortaleza"),
    BRASILIA("Brasília"),
    MACEIO("Maceió"),
    MANAUS("Manaus"),
    BELO_HORIZONTE("Belo Horizonte"),
    RIO_DE_JANEIRO("Rio de Janeiro"),
    SAO_PAULO("São Paulo"),
    ARACAJU("Aracaju"),
    NATAL("Natal"),
    RECIFE("Recife"),
    GOIANIA("Goiânia"),
    BELEM("Belém");


    private final String nome;

    Capital(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static Capital fromNome(String nome) {
        for (Capital c : values()) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }
}
