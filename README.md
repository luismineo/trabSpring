# Projeto SPRING MVC
API para gerenciamento de funcionários, estoque e ordens de serviço/venda

### Documentação dos endpoints:
[Postman](https://documenter.getpostman.com/view/27585864/2sA35JzfLL)

## Exemplos de conceitos orientação a objetos:
### Classe Concreta
![01-02-classeConcreta](https://github.com/luismineo/trabSpring/assets/69175314/a2da7ac6-114d-4901-a8d7-ea7481af577e) <br>
Classe concreta, neste caso, utilizada para definir a regra de negócios para o gerenciamento de vendedores

### Classe Abstrata
![01-abstractClass](https://github.com/luismineo/trabSpring/assets/69175314/04f75091-b8a1-4cf4-bc58-8f3679a0594b) <br>
Classe abstrata foi utilizada para definir a base para as classes de inventário e de funcionários

### Herança
![02-heritage](https://github.com/luismineo/trabSpring/assets/69175314/efd8aa02-e489-42e8-8af6-42565b6ea32c) <br>
Usada para criar classes que compartilham características entre si. Neste caso **produtos no inventário**, e **serviços prestados**.

### Acoplamento
![03-01-acoplamento](https://github.com/luismineo/trabSpring/assets/69175314/82dd5192-a215-4f62-b933-8b43f11e501e)
![03-02-acoplamento](https://github.com/luismineo/trabSpring/assets/69175314/78bad569-8760-4753-8aa3-83a2ed558f28) <br>
Usado para limitar o acesso aos parâmetros das classes

### Interfaces
![04-interface](https://github.com/luismineo/trabSpring/assets/69175314/4f9451d1-4fc7-42a0-be19-31306c005fc3) <br>
Usadas para agilizar o desenvolvimento, para classes que usam a mesma lógica para seus métodos

### Método concreto
![06-02-metodoConcreto](https://github.com/luismineo/trabSpring/assets/69175314/d6b6966d-bc2f-4728-936b-9d5be0430165) <br>
Neste caso, contém a lógica para criação de uma nova entrada no banco de dados, de uma ordem de venda

### Método abstrato 
![06-01-metodoAbstrato](https://github.com/luismineo/trabSpring/assets/69175314/9064167e-c979-4662-ae3b-c7586d038048) <br>
Métodos abstratos, são apenas assinaturas, que definem como um método poderá ser implementado

### Polimorfismo
![05-polimorfismo](https://github.com/luismineo/trabSpring/assets/69175314/8ed0c1aa-b12a-47ec-a7bc-26e6dc38a2ac) <br>
Neste caso, ao sobrescrevermos os métodos abstratos **(@Override)**, definidos na interface, estamos utilizando do polimorfismo

### Video apresentação do projeto:
[![thumb](https://github.com/luismineo/trabSpring/assets/69175314/4ebb70bb-6e5d-41a9-85a1-b293cb7d2f79)](https://www.youtube.com/watch?v=hF1t4E7wuLs)
