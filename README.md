# projeto com implementação de DTO utilizando o ModelMapper para fazer o mapeamento e usando o banco MariaDb na porta 3310
Meu Site: 
https://ajeitandoseulado.com.brPara adionar o Hateos foi instalado a dependência no pow.xml

		<dependency>
			<groupId>org.springframework.hateoas</groupId>
			<artifactId>spring-hateoas</artifactId>
		</dependency>
    
   Em DTO foi alterado para
   
  public class BookDto extends RepresentationModel<BookDto> implements Serializable { 

  
  implementei o Hateos em service e colocaque os import manuais
  
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
  
  testando no potman acrescentei em header uma propriedade Accept e description application/json ou xml
  
  ![resposta em xml](https://user-images.githubusercontent.com/95228196/207428123-86d33a59-bf0a-4ba3-8b8e-4c1a9b919fa3.png)

  ![postman com resposta json](https://user-images.githubusercontent.com/95228196/207428086-3466725d-eae6-4397-884f-a8c18cb57045.png)
