public class Vendedor extends Funcionarios {

    private EquipeVenda equipe;
    public double Salario(){
        return 2000.00;
    };

    public EquipeVenda getEquipe() {
        return equipe;
    }

    public void setEquipe(EquipeVenda equipe) {
        this.equipe = equipe;
    }
}
