package Class;

import java.text.Normalizer;

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
        String nomeNormalizado = Normalizer.normalize(nome.trim().toLowerCase(), Normalizer.Form.NFD)
        .replaceAll("[^\\p{ASCII}]", "");
        for (Capital c : values()) {
            String capitalNormalizada = Normalizer.normalize(c.getNome().toLowerCase(), Normalizer.Form.NFD)
             .replaceAll("[^\\p{ASCII}]", "");
            if (capitalNormalizada.equals(nomeNormalizado)) {
                return c;
            }
        }
        return null;
    }
    
}
