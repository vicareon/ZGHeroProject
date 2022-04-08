package acelerazg

class Main {
    static void main(String[] args){
        Database.conectar()
        Database.listarTodasEmpresas()
        Database.listarTodosCandidatos()
        Database.listarTodasVagas()
    }
}