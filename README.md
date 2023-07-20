# Mashup de API: Descrição de carreira de artista usando Spotify e ChatGPT

## Introdução
O software desenvolvido é um mashup de API que utiliza duas fontes de informação para fornecer uma descrição da carreira de um artista musical. Para isso, a aplicação integra os serviços do Spotify e do ChatGPT.

## Funcionamento
O software foi desenvolvido em Java e utiliza o framework Spring para criar um servidor web que expõe três endpoints acessíveis via HTTP POST:

1. `/test/spotify`: Este endpoint recebe o nome de um artista como entrada e retorna a discografia do artista pesquisado no Spotify.

2. `/test/chatgpt`: Neste endpoint, o software recebe um álbum musical como entrada e retorna uma descrição da carreira do artista associada a esse álbum, usando o modelo de linguagem ChatGPT.

3. `/mashup`: O principal endpoint do software, onde é fornecido o nome de um artista como entrada. O software primeiro chama o serviço do Spotify para obter a discografia do artista. Em seguida, a discografia é enviada ao serviço ChatGPT para gerar uma descrição da carreira do artista com base na discografia. O resultado final é a descrição da carreira do artista retornada ao cliente.

## Dependências
O software faz uso de dois serviços principais:

1. SpotifyService: Essa classe é responsável por se comunicar com a API do Spotify para buscar a discografia do artista fornecido. Ela utiliza uma integração com a API do Spotify para realizar pesquisas e obter informações sobre os álbuns lançados pelo artista.

2. ChatGPTService: Esta classe é responsável por se comunicar com o serviço do ChatGPT, que é um modelo de linguagem treinado pela OpenAI. O serviço ChatGPT recebe a discografia do artista como entrada e gera uma descrição da carreira do artista com base nas informações dos álbuns.

## Fluxo de Execução
Ao acessar o endpoint `/mashup` com o nome de um artista, o software segue o seguinte fluxo:

1. O controller chama o método `getArtistDiscography` para obter a discografia do artista usando o serviço do Spotify.

2. Com a discografia em mãos, o controller chama o método `getChatGPTCarrerDescriptionByDiscography`, que envia a discografia para o serviço ChatGPT, que então retorna a descrição da carreira do artista.

3. Por fim, o resultado da descrição da carreira é retornado ao cliente como uma resposta HTTP.

## Uso
Para utilizar o software, os seguintes passos podem ser seguidos:

1. Certifique-se de ter todas as dependências corretamente configuradas, incluindo as chaves de API do Spotify e do ChatGPT, que são usadas para autenticar as requisições.

2. Inicie o servidor Spring.

3. Faça uma chamada HTTP POST para o endpoint `/mashup`, fornecendo o nome de um artista no corpo da requisição.

4. O servidor processará a requisição, chamará os serviços apropriados e retornará a descrição da carreira do artista como resposta.

## Conclusão
O software desenvolvido é um exemplo de mashup de API que integra os serviços do Spotify e do ChatGPT para fornecer uma descrição da carreira de um artista com base em sua discografia. Ele demonstra como diferentes serviços podem ser combinados para criar funcionalidades mais ricas e complexas em uma aplicação web. Além disso, ilustra o potencial de integração entre APIs para fornecer informações relevantes e valiosas aos usuários.
