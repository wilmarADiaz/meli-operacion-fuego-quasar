# meli-operacion-fuego-quasar
Se abordó el problema en dos partes la primera se hace el cáculo de las posiciones y la
segunda se decifra el mensaje secreto.

Para el cálculo de la posición se usó el método matemético de trilateración, 
que deriva del cálculo de la triangulación matemática donde se toma la componente 'x' o 'y' 
como parte del triangulo rectangulo más la distancia (hipotenusa), aplicando luego 
la ecuación de pitágoras c²=a²+b² donde (x,y) es el punto a buscar (x1, y1) kenobi, 
(x2, y2) skywalker y (x3, y3) sato. 

![imagenTriangulacion](https://user-images.githubusercontent.com/79817894/164453597-4c99909a-6e6b-4f4d-8458-6d5a42822539.png)

<br>
Las ecuaciones quedarían de la siguiente manera:
<br>
d1²=(x-x1)²+(y-y1)²
<br>
d2²=(x-x2)²+(y-y2)²
<br>
d3²=(x-x3)²+(y-y3)²
<br>

y se lleva a un sistema de dos ecuaciones con dos incognitas (para mayor información sobre como llegar a ese sistema <a href="https://www.ijisme.org/wp-content/uploads/papers/v1i10/J04470911013.pdf">click aqui página 23</a>). Para dar solución ese tipo de ecuaciones se nos presenta:<br>
Ax + By = C <br>
Ex + Fy = G <br>
donde <br>
A= -2x1 + 2x2<br>
B= -2y1 + 2y2<br>
E= -2x2 + 2x3<br>
F= -2y2 + 2y3<br>
C= d1²-d2²-x1²+x2²-y1²+y2²<br>
G= d2²-d3²-x2²+x3²-y2²+y3²<br>

Para dar solución a este sistema de ecuaciones se usó Cramer donde se ecuentra los determinantes<br>
![ecuacion](https://user-images.githubusercontent.com/79817894/164460305-e30cb96b-a1bf-4ecc-b740-f1805987789f.png)
<br>
para hallar las coordenadas <br>
x = Dx/D  y = Dy/D    <br>

Luego de haber obtenido la posición lo siguiente es decifrar el mensaje secreto, para esto
se determina primero el mensaje (arreglo) que tenga menos posiciones como base, debido a que el desfase es a la izquierda se empieza a completar el mensaje de la ultima palabla hacia la primera posición.<br>

De esta manera se tiene la posición y el mensaje de la nave.


