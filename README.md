# Sistema de Concessionária

Um sistema de gerenciamento de veículos para concessionária desenvolvido em Java com interface gráfica Swing.

## Funcionalidades

- Cadastro, edição e exclusão de carros e motos
- Interface gráfica com abas separadas para carros e motos
- Visualização em tabela dos veículos cadastrados
- Validação de dados de entrada

## Estrutura do Projeto

O projeto utiliza os seguintes conceitos de orientação a objetos:
- **Herança**: Classes Carro e Moto herdam da classe Veiculo
- **Polimorfismo**: Interface Dados implementada pelas classes de veículos
- **Encapsulamento**: Atributos privados com getters e setters

### Classes Principais

- `ConcessionariaGUI`: Interface gráfica principal
- `Veiculo`: Classe base para os veículos
- `Carro`: Classe específica para carros
- `Moto`: Classe específica para motos

## Como Usar

1. Execute a classe `ConcessionariaGUI`
2. Use as abas para alternar entre carros e motos
3. Preencha os campos necessários
4. Use os botões para:
   - Adicionar novo veículo
   - Editar veículo existente
   - Excluir veículo
   - Limpar campos

## Requisitos

- Java JDK 8 ou superior
- IDE Java (Eclipse, NetBeans, IntelliJ IDEA) 