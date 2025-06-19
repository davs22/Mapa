package Class;

import java.text.Normalizer;

public enum Capital {
    // 🔴 VERMELHO (Nordeste + DF)
    MACEIO("Maceió", "AL", 12, 123),
    SALVADOR("Salvador", "BA", 520, 500),
    FORTALEZA("Fortaleza", "CE", 520, 500),
    BRASILIA("Brasília", "DF", 520, 500),
    SAO_LUIS("São Luís", "MA"),
    JOAO_PESSOA("João Pessoa", "PB"),
    RECIFE("Recife", "PE"),
    TERESINA("Teresina", "PI"),
    NATAL("Natal", "RN"),
    ARACAJU("Aracaju", "SE"),

    // 🟢 VERDE (Norte)
    MANAUS("Manaus", "AM"),
    RIO_BRANCO("Rio Branco", "AC"),
    PORTO_VELHO("Porto Velho", "RO"),
    BOA_VISTA("Boa Vista", "RR"),
    BELEM("Belém", "PA"),
    MACAPA("Macapá", "AP"),
    PALMAS("Palmas", "TO"),

    // 🟤 MARROM (Centro-Oeste)
    CUIABA("Cuiabá", "MT"),
    GOIANIA("Goiânia", "GO"),
    CAMPO_GRANDE("Campo Grande", "MS"),

    // 🟡 AMARELO (Sudeste)
    SAO_PAULO("São Paulo", "SP"),
    BELO_HORIZONTE("Belo Horizonte", "MG"),
    VITORIA("Vitória", "ES"),
    RIO_DE_JANEIRO("Rio de Janeiro", "RJ"),

    // 🟣 ROXO (Sul)
    CURITIBA("Curitiba", "PR"),
    FLORIANOPOLIS("Florianópolis", "SC"),
    PORTO_ALEGRE("Porto Alegre", "RS");

    private final String nome;
    private final String sigla;
    private final int x;
    private final int y;

    // Construtor com coordenadas
    Capital(String nome, String sigla, int x, int y) {
        this.nome = nome;
        this.sigla = sigla;
        this.x = x;
        this.y = y;
    }

    // Construtor sem coordenadas
    Capital(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
        this.x = -1;
        this.y = -1;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
