## Ideia
	-Criar um programa de estoque de produto para lojas. Utilizarei interface Grafica para conseguir criar full em java. Banco de dados será local também

### Ferramentas
	-JAVA
	-MySQL


#### Padrão do projeto
	-utilizando padrão mvc(model,view,controller).
###### MODEL - PRODUTO
	(
		ID_PRODUTO
		NOME_PRODUTO
		VALIDADE_PRODUTO
		TIPO_PRODUTO
		QUANTIDADE
		)
	Tive que adicionar uma interface chamada Comparator, para poder modificar o metodo Sort da biblioteca Collections, para poder organizar a forma que iria comparar e organizar os valores da lista para apresentar na tabela.
###### View - INTERFACE GRAFICA JAVA

		Utilizei a biblioteca java Swing para modelar a interface grafica. os metodos com nomes de componentes na classe GUI foram feitos, para conseguir fazer algo semelhante a criação de componente No React

###### Controller - 
	(CREATE PRODUTO
	READ PRODUTO(LISTAR POR NOME,TIPO,VALIDADE,QUANTIDADE)
	DELETE
	UPDATE
	)
	ConexaoDao(){
		classe feita para conseguir fazer a conexão com meu banco de dados local.
	CreateDao(){
		classe feita para criar valores dentro da tabela do meu banco de dados
	}
	DeleteDao(){
		Classe para deleterar valores da tablea
	Comparador(){
		Essa é a classe responsavel por modificar os metodos sort para poder ser responsivo a o tipo de organização que eu queria
	}
	ReadDao(){
		Classe para a listagem dos valores na tabela
	}
	UpdateDao(){
		Classe para a atualizar os valores da tabela
	}

# **TaskList**
- [x] COMEÇAR A DOCUMENTAÇÃO
- [x] INSTALAR O MYSQL
- [x] CRIAR A ENTIDADE
- [x] FAZER A PRIMEIRA INTERFACE(AONDE VAI FICAR AS OPÇÕES)
- [x] FAZER A CONEXÃO COM O BD
- [x] FAZER O CREATE
- [x] FAZER O PRIMEIRO READ
- [x] FAZER O DELETE
- [x] FAZER O UPDATE
- [x] IMPLEMENTAR OS READS MAIS IMPORTANTES
- [x] REORGANIZAR A INTERFACE
- [x] E APRIMORAR INTERFACE

[https://drive.google.com/drive/u/1/my-drive](https://drive.google.com/file/d/1TjANAb24CK7GeG9n8khx440j0TW24Plp/view?usp=sharing)

