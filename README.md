# Image-Processing

•	Negativo Digital

O filtro negativo converte uma imagem no seu complemento. Cada pixel da imagem é transformado no valor que falta para que o mesmo tenha valor máximo. 
A função recebe como entrada uma lista de parâmetros, mas só irá ler o primeiro argumento que deve ser o endereço da imagem a ser convertida. Uma nova imagem será armazenada no disco com a identificação "negative" e o nome desse arquivo é retornado pela função.

•	Gaussiano

O filtro Gaussiano é um filtro passa-baixas. Ele é utilizado para suavizar a imagem, sendo útil para remover ruído aleatório. Como efeito colateral, ele provoca suavização das bordas causando um efeito de imagem borrada que aumenta, conforme se aumenta o tamanho da máscara de convolução. 
A função recebe dois argumentos, sendo o primeiro o nome da imagem a ser processada e o segundo indicando qual das 8 máscaras Gaussianas deverá ser utilizada. Uma nova imagem será armazenada no disco com a identificação "gauss" e o nome desse arquivo é retornado pela função.

•	Máscara Genérica

O filtro de máscara genérica pode realizar qualquer filtro convolucional. Ele recebe uma lista de argumentos, sendo que o 1º argumento indica o nome da imagem a ser processada, o 2º e o 3º argumentos indicam a altura e o comprimento da máscara a ser aplicada, o 4º argumento indica o tipo de máscara passada (lowpass, highpass, etc.), e os argumentos restantes são os valores para cada posição da máscara.

•	Equalização de Histograma

A equalização de histograma é utilizada para estender o contraste da imagem. Basicamente ela redistribui as intensidades da imagem fazendo com que ocupem o espectro de intensidades de maneira mais uniforme.
A função recebe um único argumento que indica o nome da imagem a ser processada. Uma nova imagem será armazenada no disco com a identificação "histogramEq" e o nome desse arquivo é retornado pela função.

•	Laplaciano

O filtro Laplaciano é um filtro passa-altas. Ele é utilizado para evidenciar as componentes de alta frequência da imagem (bordas). Como efeito colateral, ele também realça ruídos existentes na imagem.
A função recebe um único argumento que indica o nome da imagem a ser processada. Uma nova imagem será armazenada no disco com a identificação "laplace" e o nome desse arquivo é retornado pela função.

•	Logarítmico

O filtro logarítmico reduz o contraste da imagem em áreas de alta intensidade e aumenta o contraste em áreas de baixa intensidade. 
A função recebe 2 argumentos, sendo o primeiro argumento o nome da imagem a ser processada e o segundo argumento uma constante C utilizada no cálculo. Uma nova imagem será armazenada no disco com a identificação "logarithmic" e o nome desse arquivo é retornado pela função.

•	Máximo

O filtro de máxima realça regiões claras da imagem. Ele aumenta o tamanho de objetos mais claros que o fundo e diminui o tamanho de objetos mais escuros que o fundo em que estão inseridos.
A função recebe um único argumento que indica o nome da imagem a ser processada. Uma nova imagem será armazenada no disco com a identificação "max" e o nome desse arquivo é retornado pela função.

•	Mínimo

O filtro de mínima realça regiões escuras da imagem. Ele aumenta o tamanho de objetos mais escuros que o fundo e diminui o tamanho de objetos mais claros que o fundo em que estão inseridos.
A função recebe um único argumento que indica o nome da imagem a ser processada. Uma nova imagem será armazenada no disco com a identificação "min" e o nome desse arquivo é retornado pela função.

•	Mediana

O filtro de mediana é um filtro passa-baixas não linear utilizado para remoção de ruídos impulsivos (sal e pimenta) da imagem. Ele não lida tão bem com o ruído aleatório, porém não gera o efeito colateral de perdas visíveis de bordas.
A função recebe um único argumento que indica o nome da imagem a ser processada. Uma nova imagem será armazenada no disco com a identificação "median" e o nome desse arquivo é retornado pela função.


•	Potência

O filtro de potência trabalha manipulando o contraste da imagem. Através da constante gama pode realizar transformações que realçam altas ou baixas intensidades de maneiras diferentes.
A função recebe 3 argumentos, sendo o primeiro argumento o nome da imagem a ser processada, o segundo argumento uma constante C, e o terceiro argumento outra constante (gama). Uma nova imagem será armazenada no disco com a identificação "potency" e o nome desse arquivo é retornado pela função.  

•	Limiarização Global Simples

A Limiarização Global Simples torna a imagem binária escolhendo automaticamente um limiar que irá dividir os pixels em dois grupos. Inicialmente o limiar é a intensidade média da imagem, então o limiar vai sendo modificado até que a mudança nos grupos com a troca do limiar seja insignificante.
A função recebe um único argumento que indica o nome da imagem a ser processada. Uma nova imagem será armazenada no disco com a identificação "limiarização_global" e o nome desse arquivo é retornado pela função.

•	Subtração

Este filtro recebe duas imagens como parâmetro e gera uma terceira imagem com os valores, pixel a pixel, equivalentes a imagem1 - imagem2. Esta terceira imagem é armazenada e a função retorna o nome do arquivo.

•	Soma

Este filtro recebe duas imagens como parâmetro e gera uma terceira imagem com os valores, pixel a pixel, equivalentes a imagem1 + imagem2. Esta terceira imagem é armazenada e a função retorna o nome do arquivo.

•	Limiarização

Limiariza a imagem dividindo seus pixels em dois grupos. O critério para escolha do grupo é o Limiar que é recebido como parâmetro pela função. A imagem binária é armazenada e seu nome é retornado pela função.
