package Controller;

import Model.Funcionario;

public class CadastroController {
    public static void cadastrar(String cpf, String nome, String telefone, String cargo, String email, String senha) throws Exception{
        for(Funcionario f : MainController.getFuncionarios()){
            if(f.getCpf().equals(cpf) || f.getEmail().equals(email))
                throw new Exception("Já existe um usuário com esse email e/ou CPF!");
        }
        Funcionario func = new Funcionario(cpf,nome,telefone,cargo,email,senha);
        MainController.addToArrayList(func);
    }
}
